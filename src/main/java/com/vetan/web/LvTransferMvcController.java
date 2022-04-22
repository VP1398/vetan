package com.vetan.web;

import com.vetan.exception.RecordNotFoundException;
import com.vetan.model.LvTransferEntity;
import com.vetan.service.LvTransferService;

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
@RequestMapping("/lvtransfer")
public class LvTransferMvcController
{
	@Value("${spring.project.directory}")
	private String targetPath;

	@Autowired
	LvTransferService service;

	/**
	 * This method is used to fetch all lvtransfer entries from the database and
	 * set the values into the model attribute which will be used by html template to populate data.
	 * @param model This attribute is used to set values which will be used in the html template to populate data
	 * @return String This returns the name of the html page to be displayed.
	 */
	@RequestMapping
	public String getAllLvTransfers(Model model)
	{
		List<LvTransferEntity> list = service.getAllLvTransfers();

		model.addAttribute("lvtransfers", list);
		model.addAttribute("editLvTransfer", new LvTransferEntity());
		return "lvtransfer-list";
	}

	/**
	 * This method is used to delete lvtransfer entry from the database by its id.
	 * @param model This attribute is used to set values which will be used in the html template to populate data.
	 * @param id This is the lvtransfer id which is the primary key
	 * @return String This returns the name of the html page it has to be redirected.
	 */
	@RequestMapping(path = "/delete/{id}")
	public String deleteLvTransferById(Model model, @PathVariable("id") Long id)
							throws RecordNotFoundException 
	{
		service.deleteLvTransferById(id);
		return "redirect:/lvtransfer";
	}

	/**
	 * This method is used to update all the columns of the lvtransfer entry in the database.
	 * Gets gets called when data is edited and submitted from the cardview.
	 * @param lvtransfer This is the lvtransfer entity with all its value pre-populated.
	 * @return String This returns the name of the html page it has to be redirected.
	 */
	@RequestMapping(path = "/createLvTransfer", method = RequestMethod.POST)
	public String createOrUpdateLvTransfer(LvTransferEntity lvtransfer)
	{
		service.createOrUpdateLvTransfer(lvtransfer);
		return "redirect:/lvtransfer";
	}

	/**
	 * This method is used to upload attachment from card view.
	 * @param file This attribute is the file which is uploaded
	 * @param id This is the employee id which is the primary key
	 * @return String This returns the name of the html page it has to be redirected.
	 */
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
		return "redirect:/lvtransfer";
	}

	/**
	 * This method is used to delete the uploaded attachment from the server and from the database as well.
	 * @param filename This attribute is the name of file which needs to be deleted
	 * @return String This returns the name of the html page it has to be redirected.
	 */
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
		return "redirect:/lvtransfer";
	}
}
