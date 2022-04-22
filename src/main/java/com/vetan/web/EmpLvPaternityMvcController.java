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
import com.vetan.model.EmpLvPaternityEntity;
import com.vetan.service.EmpLvPaternityService;

@Controller
@RequestMapping("/emplvpaternity")
public class EmpLvPaternityMvcController 
{
	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	EmpLvPaternityService service;

	@RequestMapping
	public String getAllEmpLvPaternitys(Model model) 
	{
		List<EmpLvPaternityEntity> list = service.getAllEmpLvPaternitys();

		model.addAttribute("emplvpaternitys", list);
		model.addAttribute("editEmpLvPaternity", new EmpLvPaternityEntity());
		return "emplvpaternity-list";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmpLvPaternityById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			EmpLvPaternityEntity entity = service.getEmpLvPaternityById(id.get());
			model.addAttribute("emplvpaternity", entity);
		} else {
			model.addAttribute("emplvpaternity", new EmpLvPaternityEntity());
		}
		return "add-edit-emplvpaternity";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteEmpLvPaternityById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteEmpLvPaternityById(id);
		return "redirect:/emplvpaternity";
	}

	@RequestMapping(path = "/createEmpLvPaternity", method = RequestMethod.POST)
	public String createOrUpdateEmpLvPaternity(EmpLvPaternityEntity emplvpaternity) 
	{
		service.createOrUpdateEmpLvPaternity(emplvpaternity);
		return "redirect:/emplvpaternity";
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
		return "redirect:/emplvpaternity";
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
		return "redirect:/emplvpaternity";
	}
}
