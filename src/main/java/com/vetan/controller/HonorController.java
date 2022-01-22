package com.vetan.controller;


import com.vetan.data.Honor;

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
@RequestMapping("/honor")
public class HonorController {


		@Value("${spring.datasource.driver-class-name}")
		private String driverClassName;

		@Value("${spring.datasource.url}")
		private String driverUrl;

		@Value("${spring.datasource.username}")
		private String userName;

		@Value("${spring.datasource.password}")
		private String password;

		@RequestMapping(value = "/",method = RequestMethod.GET)
	public String honor(ModelMap model) {
		return "honor";
	}
		
		@RequestMapping(value = "/gridhonor",method = RequestMethod.GET)
		public String gridhonor(ModelMap model) {


			return "grid/gridhonor";
		}

		@RequestMapping(value = "/gridmanager",method = RequestMethod.GET)
		public String gridmanager(ModelMap model) {


			return "grid/gridmanager";
		}

	@RequestMapping(value = "/getHonor", method = RequestMethod.POST)
	public @ResponseBody
    List<Honor> getReim() throws ClassNotFoundException {
		List<Honor> honorList = new ArrayList<Honor>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName, password);
			// System.out.println("get employee " + honorList );
			Statement getFromDb = dbConnection.createStatement();
			ResultSet emphonor = getFromDb
					.executeQuery("SELECT scholar, child, relation, year, school, application, pass_year, grade, s_amount, remarks FROM honor;");

			while (emphonor.next()) {
			  	honorList.add(new Honor(
			  			emphonor.getString("scholar"),
			  			emphonor.getString("child"),
			  		    emphonor.getString("relation"),
			  		    emphonor.getString("year"),
			  			emphonor.getString("school"),
			  			emphonor.getString("application"),
			  			emphonor.getString("pass_year"),
			  			emphonor.getString("grade"),
			  			emphonor.getString("s_amount"),
			  			emphonor.getString("remarks")
		
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// System.out.println("get employee " + honorList );
		return honorList;
	}
	
}
