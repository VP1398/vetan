package com.vetan.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetan.message.ResponseFile;
import com.vetan.data.EmpDetails;
import com.vetan.data.Vetan;
import com.vetan.service.FileStorageService;

@Controller
@CrossOrigin("http://localhost:8080")
public class FileController {

  @Autowired
  private FileStorageService storageService;
  
  //private static final String EXTERNAL_FILE_PATH = "E:\\springboot\\vetan\\src\\main\\resources\\static\\images\\";
  
  private static final String EXTERNAL_FILE_PATH = "../../../static/uimages/";

 
  
  @PostMapping("/uploadVetan")
  public ResponseEntity<Vetan> uploadData(@RequestParam("file") MultipartFile file, @RequestPart("emp") String empDetails) {
    String message = "";
    EmpDetails edetails = new EmpDetails();
    Vetan vetan = null;
    try {
    	ObjectMapper obj = new ObjectMapper();
    	edetails=obj.readValue(empDetails, EmpDetails.class);
    	vetan = storageService.store(file,edetails);

    	message = "Uploaded the file successfully: " + file.getOriginalFilename();
    	return ResponseEntity.status(HttpStatus.OK).body(vetan);
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(vetan);
    }
  }

  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId())
          .toUriString();

      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length,          
          dbFile.getExpense(),
          dbFile.getVendor(),
          dbFile.getInv_amt(),
          dbFile.getInv_no(),
          dbFile.getInv_date(),
          dbFile.getEnt_amt(),
          dbFile.getClaimed_amt(),
          dbFile.getRemarks(),
          dbFile.getId(),
          dbFile.getData());
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<Vetan> getFile(@PathVariable String id) throws IOException {
    Vetan fileDB = storageService.getFile(id);
   
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB);
  }
  
 

  @GetMapping("/download/{id}")
	public ResponseEntity<String> download(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String id) throws IOException {

	    Vetan fileDB = storageService.getFile(id);
	    try {
	    	 String path = new File("../../../static/uimages/")
                     .getAbsolutePath();
	    	 System.out.println("path :::::: "+path);
	    	 
	    	FileOutputStream fos = new FileOutputStream(path+"/"+fileDB.getId());
	    	fos.write(fileDB.getData());
	    	return ResponseEntity.status(HttpStatus.OK).body("Downloaded file in "+path +fileDB.getId());
	    }catch(Exception e) {
	    	e.printStackTrace(System.out);
	    	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("File not downloaded");
	    }
   
	}
	
}
