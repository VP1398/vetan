package com.vetan.controller;


import com.vetan.data.Fee;

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
@RequestMapping("/fee")
public class FeeController {
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping(value = "/",method = RequestMethod.GET)

	public String fee(ModelMap model) {
		return "fee";
	}
	@RequestMapping(value = "/gridfee",method = RequestMethod.GET)
	public String gridfee(ModelMap model) {


		return "grid/gridfee";
	}

	@RequestMapping(value = "/getFee", method = RequestMethod.POST)
	public @ResponseBody
    List<Fee> getReim() throws ClassNotFoundException {
		List<Fee> feeList = new ArrayList<Fee>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName, password);
			Statement getFromDb = dbConnection.createStatement();
			ResultSet empfee = getFromDb
					.executeQuery("SELECT ed_fee,  child,  relation,  academic,  school,  class1,  expense,  amount,  remarks FROM school;");
			while (empfee.next()) {
			  	feeList.add(new Fee(
			  			empfee.getString("ed_fee"),
			  			empfee.getString("child"),
			  		    empfee.getString("relation"),
			  		    empfee.getString("academic"),
			  			empfee.getString("school"),
			  			empfee.getString("class1"),
			  			empfee.getString("expense"),
			  			empfee.getString("amount"),
			  			empfee.getString("remarks")
		
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		 //System.out.println("get employee " + feeList );
		return feeList;
	}
	
}
