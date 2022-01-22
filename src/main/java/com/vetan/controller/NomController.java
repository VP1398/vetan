package com.vetan.controller;


import com.vetan.dao.NominationDAO;
import com.vetan.data.Nominee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping("/nominee")
public class NomController {

	@Autowired
	NominationDAO nominationDAO;
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String nominee(ModelMap model) {
		return "nominee";
	}
	
	@RequestMapping(value = "/gridngpa",method = RequestMethod.GET)
	public String gridngpa(ModelMap model) {


		return "grid/gridngpa";
	}

	@RequestMapping(value = "/gridngrat",method = RequestMethod.GET)
	public String gridngrat(ModelMap model) {


		return "grid/gridngrat";
	}

	@RequestMapping(value = "/gridnpf",method = RequestMethod.GET)
	public String gridnpf(ModelMap model) {


		return "grid/gridnpf";
	}



	@RequestMapping(value = "/getPFNominee", method = RequestMethod.POST)
	public @ResponseBody
    List<Nominee> getPFNominee() throws ClassNotFoundException {
		List<Nominee> nomineeList = new ArrayList<Nominee>();
		List<Nominee> nomineesList = null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet empnominee = getFromDb
			.executeQuery("SELECT type, ec, name, aadhaar, DATE_FORMAT(dob, \"%d/%m/%Y\") as dob, gender, relation, address, proportion FROM nomination where type ='PF',where ec=1000138 ");


			nomineesList = nominationDAO.findByType("PF");



		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// System.out.println("get Nominee " + nomineesList );
		return nomineesList;
	}

	@RequestMapping(value = "/getGPANominee", method = RequestMethod.POST)
	public @ResponseBody
    List<Nominee> getGPANominee() throws ClassNotFoundException {
		List<Nominee> nomineeList = new ArrayList<Nominee>();
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);


			Statement getFromDb = dbConnection.createStatement();
			ResultSet empnominee = getFromDb
					.executeQuery("SELECT type, ec, name, aadhaar, DATE_FORMAT(dob, \"%d/%m/%Y\") as dob, gender, relation, address, proportion FROM nomination where type ='GPA';");

			while (empnominee.next()) {
			  	nomineeList.add(new Nominee(
	                    empnominee.getString("name"),
			  			empnominee.getString("aadhaar"),
			  		    empnominee.getString("dob"),
			  			empnominee.getString("gender"),
			  			empnominee.getString("relation"),
			  			empnominee.getString("address"),

			  			empnominee.getString("proportion")
		
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// System.out.println("get Nominee " + nomineeList );
		return nomineeList;
	}
	@RequestMapping(value = "/getGratNominee", method = RequestMethod.POST)
	public @ResponseBody
    List<Nominee> getGratNominee() throws ClassNotFoundException {
		List<Nominee> nomineeList = new ArrayList<Nominee>();
		try {
		
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet empnominee = getFromDb
					.executeQuery("SELECT type, ec, name, aadhaar, DATE_FORMAT(dob, \"%d/%m/%Y\") as dob, gender, relation, address, proportion FROM nomination where type ='Gratuity';");

			while (empnominee.next()) {
			  	nomineeList.add(new Nominee(
	                    empnominee.getString("name"),
			  			empnominee.getString("aadhaar"),
			  		    empnominee.getString("dob"),
			  			empnominee.getString("gender"),
			  			empnominee.getString("relation"),
			  			empnominee.getString("address"),

			  			empnominee.getString("proportion")
		
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// System.out.println("get Nominee " + nomineeList );
		return nomineeList;
	}
	
}
