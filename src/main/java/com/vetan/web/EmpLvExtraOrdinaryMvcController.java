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
import com.vetan.model.EmpLvExtraOrdinaryEntity;
import com.vetan.service.EmpLvExtraOrdinaryService;

@Controller
@RequestMapping("/emplvextraordinary")
public class EmpLvExtraOrdinaryMvcController 
{
	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	EmpLvExtraOrdinaryService service;

	@RequestMapping
	public String getAllEmpLvExtraOrdinarys(Model model) 
	{
		List<EmpLvExtraOrdinaryEntity> list = service.getAllEmpLvExtraOrdinarys();

		model.addAttribute("emplvextraordinarys", list);
		model.addAttribute("editEmpLvExtraOrdinary", new EmpLvExtraOrdinaryEntity());
		return "emplvextraordinary-list";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmpLvExtraOrdinaryById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			EmpLvExtraOrdinaryEntity entity = service.getEmpLvExtraOrdinaryById(id.get());
			model.addAttribute("emplvextraordinary", entity);
		} else {
			model.addAttribute("emplvextraordinary", new EmpLvExtraOrdinaryEntity());
		}
		return "add-edit-emplvextraordinary";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteEmpLvExtraOrdinaryById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteEmpLvExtraOrdinaryById(id);
		return "redirect:/emplvextraordinary";
	}

	@RequestMapping(path = "/createEmpLvExtraOrdinary", method = RequestMethod.POST)
	public String createOrUpdateEmpLvExtraOrdinary(EmpLvExtraOrdinaryEntity emplvextraordinary) 
	{
		service.createOrUpdateEmpLvExtraOrdinary(emplvextraordinary);
		return "redirect:/emplvextraordinary";
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
		return "redirect:/emplvextraordinary";
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
		return "redirect:/emplvextraordinary";
	}
}
