package com.vetan.controller;

import com.vetan.data.Empgratuity;

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
@RequestMapping("/grat")
public class GratController {
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String grat(ModelMap model) {
		return "grat";
	}
	@RequestMapping(value = "/gridempgrat",method = RequestMethod.GET)
	public String gridempgrat(ModelMap model) {


		return "grid/gridempgrat";
	}
	
	@RequestMapping(value = "/gridgrat",method = RequestMethod.GET)
	public String gridgrat(ModelMap model) {


		return "grid/gridgrat";
	}

	@RequestMapping(value = "/getGratuity", method = RequestMethod.POST)
	public @ResponseBody
    List<Empgratuity> getGratuity() throws ClassNotFoundException {
		List<Empgratuity> empgratList = new ArrayList<Empgratuity>();
       // System.out.println("get employee ");
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);
			Statement getFromDb = dbConnection.createStatement();
			ResultSet empgratuities = getFromDb
					.executeQuery("select   id, ec,  ename,  cat,  role,  area,  bcode,  bpay,  da,  fpp, pqp, spl_all,  grat_type, grat_amt FROM grattot_view  ;");
			
			while (empgratuities.next()) {
			  	empgratList.add(new Empgratuity(
			  			
						  empgratuities.getString("id"),
						   empgratuities.getString("ec"),
						   empgratuities.getString("ename"),
						   empgratuities.getString("cat"),
						   empgratuities.getString("role"),
						   empgratuities.getString("area"),
						   empgratuities.getString("bcode"),
						   empgratuities.getString("bpay"),
						   empgratuities.getString("da"),
						   empgratuities.getString("fpp"),
						   empgratuities.getString("pqp"),
						   empgratuities.getString("spl_all"),
						   empgratuities.getString("grat_type"),
						   empgratuities.getString("grat_amt")

                                ));
			}
			System.out.println("size is " + empgratList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empgratList;
	}
	@RequestMapping(value = "/getempGratuity", method = RequestMethod.POST)
	public @ResponseBody
    List<Empgratuity> getempGratuity() throws ClassNotFoundException {
		List<Empgratuity> empgratList = new ArrayList<Empgratuity>();
		try {
	
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);
					
  			Statement getFromDb = dbConnection.createStatement();
			ResultSet empgratuities = getFromDb
					.executeQuery("select  id, ec,  ename,  cat,  role,  area,  bcode,  bpay,  da,  fpp, pqp, spl_all,  grat_type, grat_amt FROM grattot_view where ec=1000138 ;");
			
			while (empgratuities.next()) {
			  	empgratList.add(new Empgratuity(
			  			
						  empgratuities.getString("id"),
						   empgratuities.getString("ec"),
						   empgratuities.getString("ename"),
						   empgratuities.getString("cat"),
						   empgratuities.getString("role"),
						   empgratuities.getString("area"),
						   empgratuities.getString("bcode"),
						   empgratuities.getString("bpay"),
						   empgratuities.getString("da"),
						   empgratuities.getString("fpp"),
						   empgratuities.getString("pqp"),
						   empgratuities.getString("spl_all"),
						   empgratuities.getString("grat_type"),
						   empgratuities.getString("grat_amt")

                                ));
			}
			System.out.println("size is " + empgratList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empgratList;
	}
	
}
