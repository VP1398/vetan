package com.vetan.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vetan.exception.RecordNotFoundException;
import com.vetan.model.EmpLvTransferEntity;
import com.vetan.service.EmpLvTransferService;

@Controller
@RequestMapping("/emplvtransfer")
public class EmpLvTransferMvcController 
{
	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	EmpLvTransferService service;

	@RequestMapping
	public String getAllEmpLvTransfers(Model model) 
	{
		List<EmpLvTransferEntity> list = service.getAllEmpLvTransfers();

		model.addAttribute("emplvtransfers", list);
		model.addAttribute("editEmpLvTransfer", new EmpLvTransferEntity());
		return "emplvtransfer-list";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmpLvTransferById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			EmpLvTransferEntity entity = service.getEmpLvTransferById(id.get());
			model.addAttribute("emplvtransfer", entity);
		} else {
			model.addAttribute("emplvtransfer", new EmpLvTransferEntity());
		}
		return "add-edit-emplvtransfer";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteEmpLvTransferById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteEmpLvTransferById(id);
		return "redirect:/emplvtransfer";
	}

	@RequestMapping(path = "/createEmpLvTransfer", method = RequestMethod.POST)
	public String createOrUpdateEmpLvTransfer(EmpLvTransferEntity emplvtransfer) 
	{
		service.createOrUpdateEmpLvTransfer(emplvtransfer);
		return "redirect:/emplvtransfer";
	}

	@RequestMapping(path = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("pictureFile") MultipartFile file, @RequestParam("id") String id)
	{
		try {
			if(!file.isEmpty()){
				byte[] bytes = file.getBytes();
				String filename = file.getOriginalFilename();
				File newFile = new File(targetPath+"/WEB-INF/classes/static/images/");
				if (!newFile.exists()) {
					newFile.mkdirs();
				}
				BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(targetPath+"/WEB-INF/classes/static/images/" + id + "_" + filename)));
				stream.write(bytes);
				System.out.println("File saved successfully.");
				stream.flush();
				stream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/emplvtransfer";
	}

	@RequestMapping(path = "/deleteFile", method = RequestMethod.POST)
	public String deleteFile(@RequestParam("filename") String filename)
	{
		try {
			File file = new File(targetPath+"/WEB-INF/classes/static/images/" + filename);
			if (file.delete()) {
				System.out.println("File deleted successfully.");
			}else {
				System.out.println("Failed to delete the file.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/emplvtransfer";
	}
}
