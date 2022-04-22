package com.vetan.service;

import com.vetan.exception.RecordNotFoundException;
import com.vetan.model.MyImage;
import com.vetan.model.RemLConEntity;
import com.vetan.repository.RemLConRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemLConService {

	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	RemLConRepository repository;

	/**
	 * This method is used to fetch all the remlcon entries from the database.
	 * @return List<RemLConEntity> This returns the list of remlcon entities fetched from the database.
	 */
	public List<RemLConEntity> getAllRemLCons()
	{
		List<RemLConEntity> result = (List<RemLConEntity>) repository.findAll();
		
		if(result.size() > 0) {

			for (RemLConEntity entity:
				 result) {
				retriveAttachmentsAndStore(entity.getAttach());
			}
			return result;
		} else {
			return new ArrayList<RemLConEntity>();
		}
	}

	/**
	 * This method is used to get a single remlcon entry from the database based on its id.
	 * @param id This attribute is the id of the remlcon entry.
	 * @return RemLConEntity This returns the RemLConEntity object for the requested remlcon id.
	 */
	public RemLConEntity getRemLConById(Long id) throws RecordNotFoundException
	{
		Optional<RemLConEntity> remlcon = repository.findById(id);
		
		if(remlcon.isPresent()) {
			return remlcon.get();
		} else {
			throw new RecordNotFoundException("No remlcon record exist for given id");
		}
	}

	/**
	 * This method is used to update all the columns of the RemLCon entry in the database.
	 * @param entity This attribute is the RemLConEntity object with pre-populated data for all columns.
	 * @return String This returns updated RemLConEntity object.
	 */
	public RemLConEntity createOrUpdateRemLCon(RemLConEntity entity)
	{
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			
			return entity;
		} 
		else 
		{
			Optional<RemLConEntity> employee = repository.findById(entity.getId());
			
			if(employee.isPresent()) 
			{
				RemLConEntity newEntity = employee.get();
				newEntity.setLocalConveyance(entity.getLocalConveyance());
				newEntity.setPurpose(entity.getPurpose());
				newEntity.setDate(entity.getDate());
				newEntity.setStartTime(entity.getStartTime());
				newEntity.setEndTime(entity.getEndTime());
				newEntity.setFrom(entity.getFrom());
				newEntity.setDestination(entity.getDestination());
				newEntity.setVehicleType(entity.getVehicleType());
				newEntity.setTransportMode(entity.getTransportMode());
				newEntity.setKmsNo(entity.getKmsNo());
				newEntity.setRate(entity.getRate());
				newEntity.setAmount(entity.getAmount());
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
	 * @return byte[] This returns the byte array of all the attachments for a particular remlcon entity.
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
	 * This method is used to delete the remlcon entry from the database by its id.
	 * @param id This attribute is the id of the remlcon entry to be deleted.
	 * @return void
	 */
	public void deleteRemLConById(Long id) throws RecordNotFoundException
	{
		Optional<RemLConEntity> employee = repository.findById(id);
		
		if(employee.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No remlcon record exist for given id");
		}
	} 
}