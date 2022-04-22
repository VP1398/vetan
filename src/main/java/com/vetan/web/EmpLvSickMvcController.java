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
import com.vetan.model.EmpLvSickEntity;
import com.vetan.service.EmpLvSickService;

@Controller
@RequestMapping("/emplvsick")
public class EmpLvSickMvcController 
{
	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	EmpLvSickService service;

	@RequestMapping
	public String getAllEmpLvSicks(Model model) 
	{
		List<EmpLvSickEntity> list = service.getAllEmpLvSicks();

		model.addAttribute("emplvsicks", list);
		model.addAttribute("editEmpLvSick", new EmpLvSickEntity());
		return "emplvsick-list";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmpLvSickById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			EmpLvSickEntity entity = service.getEmpLvSickById(id.get());
			model.addAttribute("emplvsick", entity);
		} else {
			model.addAttribute("emplvsick", new EmpLvSickEntity());
		}
		return "add-edit-emplvsick";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteEmpLvSickById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteEmpLvSickById(id);
		return "redirect:/emplvsick";
	}

	@RequestMapping(path = "/createEmpLvSick", method = RequestMethod.POST)
	public String createOrUpdateEmpLvSick(EmpLvSickEntity emplvsick) 
	{
		service.createOrUpdateEmpLvSick(emplvsick);
		return "redirect:/emplvsick";
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
		return "redirect:/emplvsick";
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
		return "redirect:/emplvsick";
	}
}
