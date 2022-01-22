package com.vetan.controller;


import com.vetan.data.RemLoan;

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
@RequestMapping("/remloan")
public class RemLoanController {
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String remloan(ModelMap model) {
		return "remloan";
	}
	@RequestMapping(value = "/gridremloan",method = RequestMethod.GET)
	public String gridremloan(ModelMap model) {


		return "grid/gridremloan";
	}

	@RequestMapping(value = "/getRemLoan", method = RequestMethod.POST)
	public @ResponseBody
    List<RemLoan> getReim() throws ClassNotFoundException {
		List<RemLoan> remloanList = new ArrayList<RemLoan>();
		try {

			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);
			Statement getFromDb = dbConnection.createStatement();
			ResultSet empremloan = getFromDb
					.executeQuery("SELECT loan,  prod_name,  prod_type,  vendor,  inv_no,  inv_date,  est_val,  tot_est,  ent_amt,  req_amt,  remarks FROM loan;");

			while (empremloan.next()) {
			  	remloanList.add(new RemLoan(
			  			empremloan.getString("loan"),
			  			empremloan.getString("prod_name"),
			  		    empremloan.getString("prod_type"),
			  		    empremloan.getString("vendor"),
			  			empremloan.getString("inv_no"),
			  			empremloan.getString("inv_date"),
			  			empremloan.getString("est_val"),
			  			empremloan.getString("tot_est"),
			  			empremloan.getString("ent_amt"),
			  			empremloan.getString("req_amt"),
			  			empremloan.getString("remarks")
		
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return remloanList;
	}
	
}
