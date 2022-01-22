package com.vetan.controller;


import com.vetan.data.Reimburse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/screen")
public class ScreenController {
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String screen(ModelMap model) {
		return "screen";
	}
	@RequestMapping(value = "/gridreimburse",method = RequestMethod.GET)
	public String gridreimburse(ModelMap model) {


		return "grid/gridreimburse";
	}
	
	@RequestMapping(value = "/cardreimburse",method = RequestMethod.GET)
	public String cardreimburse(ModelMap model) {


		return "grid/cardreimburse";
	}
	
	@RequestMapping(value = "/gridscholar",method = RequestMethod.GET)
	public String gridscholar(ModelMap model) {


		return "grid/gridscholar";
	}

		
	
	@RequestMapping(value = "/getReimburse", method = RequestMethod.POST)
	public @ResponseBody
    List<Reimburse> getReim() throws ClassNotFoundException {
		List<Reimburse> empscreenList = new ArrayList<Reimburse>();
		try {
	
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);


			Statement getFromDb = dbConnection.createStatement();
			ResultSet emprem = getFromDb
					.executeQuery("SELECT expense, vendor, inv_no, DATE_FORMAT(inv_date, \"%d/%m/%Y\")  as inv_date,  inv_amt, ent_amt, claimed_amt, remarks FROM reimbursement; ");

			while (emprem.next()) {
			  	empscreenList.add(new Reimburse(
			  			emprem.getString("expense"),
			  			emprem.getString("vendor"),
			  			
			  		    emprem.getString("inv_no"),
			  		    emprem.getString("inv_date"),
			  			emprem.getString("inv_amt"),
			  			emprem.getString("ent_amt"),
			  			emprem.getString("claimed_amt"),

			  			emprem.getString("remarks")
		
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empscreenList;
	}
	
}
