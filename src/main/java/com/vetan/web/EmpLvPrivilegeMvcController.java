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
import com.vetan.model.EmpLvPrivilegeEntity;
import com.vetan.service.EmpLvPrivilegeService;

@Controller
@RequestMapping("/emplvprivilege")
public class EmpLvPrivilegeMvcController 
{
	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	EmpLvPrivilegeService service;

	@RequestMapping
	public String getAllEmpLvPrivileges(Model model) 
	{
		List<EmpLvPrivilegeEntity> list = service.getAllEmpLvPrivileges();

		model.addAttribute("emplvprivileges", list);
		model.addAttribute("editEmpLvPrivilege", new EmpLvPrivilegeEntity());
		return "emplvprivilege-list";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmpLvPrivilegeById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			EmpLvPrivilegeEntity entity = service.getEmpLvPrivilegeById(id.get());
			model.addAttribute("emplvprivilege", entity);
		} else {
			model.addAttribute("emplvprivilege", new EmpLvPrivilegeEntity());
		}
		return "add-edit-emplvprivilege";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteEmpLvPrivilegeById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteEmpLvPrivilegeById(id);
		return "redirect:/emplvprivilege";
	}

	@RequestMapping(path = "/createEmpLvPrivilege", method = RequestMethod.POST)
	public String createOrUpdateEmpLvPrivilege(EmpLvPrivilegeEntity emplvprivilege) 
	{
		service.createOrUpdateEmpLvPrivilege(emplvprivilege);
		return "redirect:/emplvprivilege";
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
		return "redirect:/emplvprivilege";
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
		return "redirect:/emplvprivilege";
	}
}
