package com.vetan.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.vetan.data.EmpDetails;
import com.vetan.data.Vetan;
import com.vetan.repository.FileDBRepository;

@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

   
  public Vetan store(MultipartFile file, EmpDetails empDetails) throws IOException {
	  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    Vetan fileDB = new Vetan(fileName, file.getContentType(), file.getBytes(),empDetails.getExpense(),empDetails.getVendor(),empDetails.getInv_no(),empDetails.getInv_date(),empDetails.getInv_amt(),empDetails.getEnt_amt(),empDetails.getClaimed_amt(),empDetails.getRemarks());

	    return fileDBRepository.save(fileDB);
		
	}

  public Vetan getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<Vetan> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }


}
