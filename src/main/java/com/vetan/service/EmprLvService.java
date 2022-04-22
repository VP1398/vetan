package com.vetan.service;

import com.vetan.exception.RecordNotFoundException;
import com.vetan.model.EmprLvEntity;
import com.vetan.model.MyImage;
import com.vetan.repository.EmprLvRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmprLvService {

	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	EmprLvRepository repository;

	/**
	 * This method is used to fetch all the emprlv entries from the database.
	 * @return List<EmprLvEntity> This returns the list of emprlv entities fetched from the database.
	 */
	public List<EmprLvEntity> getAllEmprLvs()
	{
		List<EmprLvEntity> result = (List<EmprLvEntity>) repository.findAll();
		
		if(result.size() > 0) {

			for (EmprLvEntity entity:
				 result) {
				retriveAttachmentsAndStore(entity.getAttach());
			}
			return result;
		} else {
			return new ArrayList<EmprLvEntity>();
		}
	}

	/**
	 * This method is used to get a single emprlv entry from the database based on its id.
	 * @param id This attribute is the id of the emprlv entry.
	 * @return EmprLvEntity This returns the EmprLvEntity object for the requested emprlv id.
	 */
	public EmprLvEntity getEmprLvById(Long id) throws RecordNotFoundException
	{
		Optional<EmprLvEntity> emprlv = repository.findById(id);
		
		if(emprlv.isPresent()) {
			return emprlv.get();
		} else {
			throw new RecordNotFoundException("No emprlv record exist for given id");
		}
	}

	/**
	 * This method is used to update all the columns of the EmprLv entry in the database.
	 * @param entity This attribute is the EmprLvEntity object with pre-populated data for all columns.
	 * @return String This returns updated EmprLvEntity object.
	 */
	public EmprLvEntity createOrUpdateEmprLv(EmprLvEntity entity)
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<EmprLvEntity> employee = repository.findById(entity.getId());
			
			if(employee.isPresent()) 
			{
				EmprLvEntity newEntity = employee.get();
				newEntity.setEcode(entity.getEcode());
				newEntity.setEname(entity.getEname());
				newEntity.setCategory(entity.getCategory());
				newEntity.setRole(entity.getRole());
				newEntity.setDateOfJoining(entity.getDateOfJoining());
				newEntity.setAge(entity.getAge());
				newEntity.setLocation(entity.getLocation());
				newEntity.setDepartment(entity.getDepartment());
				newEntity.setBcode(entity.getBcode());
				newEntity.setGender(entity.getGender());
				newEntity.setManager(entity.getManager());
				newEntity.setCityType(entity.getCityType());
				newEntity.setLeaveType(entity.getLeaveType());
				newEntity.setStartDate(entity.getStartDate());
				newEntity.setEndDate(entity.getEndDate());
				newEntity.setDays(entity.getDays());
				newEntity.setNoOfDays(entity.getNoOfDays());
				newEntity.setStatus(entity.getStatus());
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
	 * @return byte[] This returns the byte array of all the attachments for a particular emprlv entity.
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
	 * This method is used to delete the emprlv entry from the database by its id.
	 * @param id This attribute is the id of the emprlv entry to be deleted.
	 * @return void
	 */
	public void deleteEmprLvById(Long id) throws RecordNotFoundException
	{
		Optional<EmprLvEntity> employee = repository.findById(id);
		
		if(employee.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No emprlv record exist for given id");
		}
	} 
}