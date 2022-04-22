package com.vetan.web;

import com.vetan.exception.RecordNotFoundException;
import com.vetan.model.EmpLvCasualEntity;
import com.vetan.service.EmpLvCasualService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/emplvcasual")
public class EmpLvCasualMvcController 
{
	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	EmpLvCasualService service;

	@RequestMapping
	public String getAllEmpLvCasuals(Model model) 
	{
		List<EmpLvCasualEntity> list = service.getAllEmpLvCasuals();

		model.addAttribute("emplvcasuals", list);
		model.addAttribute("editEmpLvCasual", new EmpLvCasualEntity());
		return "emplvcasual-list";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteEmpLvCasualById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteEmpLvCasualById(id);
		return "redirect:/emplvcasual";
	}

	@RequestMapping(path = "/createEmpLvCasual", method = RequestMethod.POST)
	public String createOrUpdateEmpLvCasual(EmpLvCasualEntity emplvcasual) 
	{
		service.createOrUpdateEmpLvCasual(emplvcasual);
		return "redirect:/emplvcasual";
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
		return "redirect:/emplvcasual";
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
		return "redirect:/emplvcasual";
	}
}
