package com.vetan.controller;

import com.vetan.data.Emppf;

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
@RequestMapping("/fund")
public class FundController {
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String fund(ModelMap model) {
		return "fund";
	}
	@RequestMapping(value = "/gridpf",method = RequestMethod.GET)
	public String gridpf(ModelMap model) {


		return "grid/gridpf";
	}

	@RequestMapping(value = "/getFund", method = RequestMethod.POST)
	public @ResponseBody
    List<Emppf> getFund() throws ClassNotFoundException {
		List<Emppf> empfundList = new ArrayList<Emppf>();
       // System.out.println("get employee ");
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);
			Statement getFromDb = dbConnection.createStatement();
			ResultSet emppfs = getFromDb
					.executeQuery("SELECT id, ec, ename, bcode, area, bpay, da, bpay_tot, pf, epf, epsf, vpf, pfl, total FROM pf_view;");
			while (emppfs.next()) {
			  	empfundList.add(new Emppf(

						  
			  			emppfs.getString("id"),

			  			emppfs.getString("ec"),
						   emppfs.getString("ename"),
						   emppfs.getString("bcode"),
						   emppfs.getString("area"),
						   emppfs.getString("bpay"),
						   emppfs.getString("da"),
						   emppfs.getString("bpay_tot"),
						   emppfs.getString("pf"),
						   emppfs.getString("epf"),
						   emppfs.getString("epsf"),
						   emppfs.getString("vpf"),
						   emppfs.getString("pfl"),
						   emppfs.getString("total")
		
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empfundList;
	}
	
}
