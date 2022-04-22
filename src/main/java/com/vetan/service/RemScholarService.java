package com.vetan.service;

import com.vetan.exception.RecordNotFoundException;
import com.vetan.model.MyImage;
import com.vetan.model.RemScholarEntity;
import com.vetan.repository.RemScholarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemScholarService {

	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	RemScholarRepository repository;

	/**
	 * This method is used to fetch all the remscholar entries from the database.
	 * @return List<RemScholarEntity> This returns the list of remscholar entities fetched from the database.
	 */
	public List<RemScholarEntity> getAllRemScholars()
	{
		List<RemScholarEntity> result = (List<RemScholarEntity>) repository.findAll();
		
		if(result.size() > 0) {

			for (RemScholarEntity entity:
				 result) {
				retriveAttachmentsAndStore(entity.getAttach());
			}
			return result;
		} else {
			return new ArrayList<RemScholarEntity>();
		}
	}

	/**
	 * This method is used to get a single remscholar entry from the database based on its id.
	 * @param id This attribute is the id of the remscholar entry.
	 * @return RemScholarEntity This returns the RemScholarEntity object for the requested remscholar id.
	 */
	public RemScholarEntity getRemScholarById(Long id) throws RecordNotFoundException
	{
		Optional<RemScholarEntity> remscholar = repository.findById(id);
		
		if(remscholar.isPresent()) {
			return remscholar.get();
		} else {
			throw new RecordNotFoundException("No remscholar record exist for given id");
		}
	}

	/**
	 * This method is used to update all the columns of the RemScholar entry in the database.
	 * @param entity This attribute is the RemScholarEntity object with pre-populated data for all columns.
	 * @return String This returns updated RemScholarEntity object.
	 */
	public RemScholarEntity createOrUpdateRemScholar(RemScholarEntity entity)
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<RemScholarEntity> employee = repository.findById(entity.getId());
			
			if(employee.isPresent()) 
			{
				RemScholarEntity newEntity = employee.get();
				newEntity.setScholarshipType(entity.getScholarshipType());
				newEntity.setChildName(entity.getChildName());
				newEntity.setRelationship(entity.getRelationship());
				newEntity.setFinancialYear(entity.getFinancialYear());
				newEntity.setCollegeName(entity.getCollegeName());
				newEntity.setApplicationType(entity.getApplicationType());
				newEntity.setPassingYear(entity.getPassingYear());
				newEntity.setPercentage(entity.getPercentage());
				newEntity.setScholarshipAmount(entity.getScholarshipAmount());
				newEntity.setRemarks(entity.getRemarks());
				newEntity.setAttachments(entity.getAttachments());
				newEntity.setAttach(retriveAttachmentsAsBytes(entity.getAttachments()));

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				
				return entity;
			}
		}
	}

	/**
	 * This method is used to retrive all the attachments from the database and store it as files in the local server.
	 * @param bytes This attribute is the byte array of attachments retrieved from the database.
	 * @return void
	 */
	public void retriveAttachmentsAndStore(byte[] bytes){
		try{
			if(bytes != null){
				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				ObjectInputStream in = new ObjectInputStream(bais);
				ArrayList<MyImage> attachments = (ArrayList<MyImage>) in.readObject();
				if(attachments != null){
					for(MyImage obj : attachments){
						byte[] arr = obj.getImageAsBytes();
						String name = obj.getImageName();
						File file = new File(targetPath+"/WEB-INF/classes/static/images/");
						if (!file.exists()) {
							file.mkdirs();
						}
						BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(targetPath+"/WEB-INF/classes/static/images/"+name)));
						stream.write(arr);
						stream.flush();
						stream.close();
					}
				}
				in.close();
				bais.close();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to create byte array from the uploaded file which can be stored in the database.
	 * @param filenames This attribute is the names of files which will be byte converted.
	 * @return byte[] This returns the byte array of all the attachments for a particular remscholar entity.
	 */
	public byte[] retriveAttachmentsAsBytes(String filenames){
		ArrayList<MyImage> attachments = new ArrayList<MyImage>();
		try{
			if(filenames != null){
				String[] names = filenames.split("\\|");
				for (String name : names)
				{
					if(name.trim().length() > 0){
						File file = new File(targetPath+"/WEB-INF/classes/static/images/"+name);
						byte[] arr = Files.readAllBytes(file.toPath());
						attachments.add(new MyImage(name, arr));
					}
				}
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(baos);
				out.writeObject(attachments);
				byte[] bytes = baos.toByteArray();
				out.flush();
				baos.close();
				return bytes;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method is used to delete the remscholar entry from the database by its id.
	 * @param id This attribute is the id of the remscholar entry to be deleted.
	 * @return void
	 */
	public void deleteRemScholarById(Long id) throws RecordNotFoundException
	{
		Optional<RemScholarEntity> employee = repository.findById(id);
		
		if(employee.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No remscholar record exist for given id");
		}
	} 
}