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
import com.vetan.model.EmpLvMiscarriageEntity;
import com.vetan.service.EmpLvMiscarriageService;

@Controller
@RequestMapping("/emplvmiscarriage")
public class EmpLvMiscarriageMvcController 
{
	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	EmpLvMiscarriageService service;

	@RequestMapping
	public String getAllEmpLvMiscarriages(Model model) 
	{
		List<EmpLvMiscarriageEntity> list = service.getAllEmpLvMiscarriages();

		model.addAttribute("emplvmiscarriages", list);
		model.addAttribute("editEmpLvMiscarriage", new EmpLvMiscarriageEntity());
		return "emplvmiscarriage-list";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmpLvMiscarriageById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			EmpLvMiscarriageEntity entity = service.getEmpLvMiscarriageById(id.get());
			model.addAttribute("emplvmiscarriage", entity);
		} else {
			model.addAttribute("emplvmiscarriage", new EmpLvMiscarriageEntity());
		}
		return "add-edit-emplvmiscarriage";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteEmpLvMiscarriageById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteEmpLvMiscarriageById(id);
		return "redirect:/emplvmiscarriage";
	}

	@RequestMapping(path = "/createEmpLvMiscarriage", method = RequestMethod.POST)
	public String createOrUpdateEmpLvMiscarriage(EmpLvMiscarriageEntity emplvmiscarriage) 
	{
		service.createOrUpdateEmpLvMiscarriage(emplvmiscarriage);
		return "redirect:/emplvmiscarriage";
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
		return "redirect:/emplvmiscarriage";
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
		return "redirect:/emplvmiscarriage";
	}
}
