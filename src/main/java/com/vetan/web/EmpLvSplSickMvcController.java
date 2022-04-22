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
import com.vetan.model.EmpLvSplSickEntity;
import com.vetan.service.EmpLvSplSickService;

@Controller
@RequestMapping("/emplvsplsick")
public class EmpLvSplSickMvcController 
{
	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	EmpLvSplSickService service;

	@RequestMapping
	public String getAllEmpLvSplSicks(Model model) 
	{
		List<EmpLvSplSickEntity> list = service.getAllEmpLvSplSicks();

		model.addAttribute("emplvsplsicks", list);
		model.addAttribute("editEmpLvSplSick", new EmpLvSplSickEntity());
		return "emplvsplsick-list";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmpLvSplSickById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			EmpLvSplSickEntity entity = service.getEmpLvSplSickById(id.get());
			model.addAttribute("emplvsplsick", entity);
		} else {
			model.addAttribute("emplvsplsick", new EmpLvSplSickEntity());
		}
		return "add-edit-emplvsplsick";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteEmpLvSplSickById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteEmpLvSplSickById(id);
		return "redirect:/emplvsplsick";
	}

	@RequestMapping(path = "/createEmpLvSplSick", method = RequestMethod.POST)
	public String createOrUpdateEmpLvSplSick(EmpLvSplSickEntity emplvsplsick) 
	{
		service.createOrUpdateEmpLvSplSick(emplvsplsick);
		return "redirect:/emplvsplsick";
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
		return "redirect:/emplvsplsick";
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
		return "redirect:/emplvsplsick";
	}
}
