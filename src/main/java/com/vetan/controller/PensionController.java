package com.vetan.controller;



import com.vetan.data.Emppension;

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
@RequestMapping("/pension")
public class PensionController {
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String pensiond(ModelMap model) {
		return "pension";
	}
	@RequestMapping(value = "/gridpen",method = RequestMethod.GET)
	public String gridpen(ModelMap model) {


		return "grid/gridpen";
	}

	@RequestMapping(value = "/getPension", method = RequestMethod.POST)
	public @ResponseBody
    List<Emppension> getPension() throws ClassNotFoundException {
		List<Emppension> emppensionList = new ArrayList<Emppension>();
		try {

			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);


			Statement getFromDb = dbConnection.createStatement();
			ResultSet emppensions = getFromDb
					.executeQuery("	SELECT ec,ename,gen,designation,cat,comm_add,dob,doj,dop,retire_date,age,texp,pexp,bpay,spl_all,retire_class,bcode,mobile,email,pan,aadhaar,bcode_credit,app_date,qualify_yrs,qualify_yrs_add,qualify_yrs_tot,l_s_month,pension_type,pension_rate,bps_settle,commutation,med_exam_reqd,commutation_frac,dom_checkup,commutation_dt,fpp,pqp,Off_pay,total_pay FROM totalpension_view;");

			while (emppensions.next()) {
			  	emppensionList.add(new Emppension(
						
						   emppensions.getString("ec"),
						   emppensions.getString("ename"),
						   emppensions.getString("gen"),
						   emppensions.getString("designation"),
						   emppensions.getString("cat"),
						   emppensions.getString("comm_add"),
						   emppensions.getString("dob"),
						   emppensions.getString("doj"),
						   emppensions.getString("dop"),
						   emppensions.getString("retire_date"),
						   emppensions.getString("age"),
						   emppensions.getString("texp"),
						   emppensions.getString("pexp"),
						   emppensions.getString("bpay"),
						   emppensions.getString("spl_all"),
						   emppensions.getString("retire_class"),
						   emppensions.getString("bcode"),
						   emppensions.getString("mobile"),
						   emppensions.getString("email"),
						   emppensions.getString("pan"),
						   emppensions.getString("aadhaar"),
						   emppensions.getString("bcode_credit"),
						   emppensions.getString("app_date"),
						   emppensions.getString("qualify_yrs"),
						   emppensions.getString("qualify_yrs_add"),
						   emppensions.getString("qualify_yrs_tot"),
						   emppensions.getString("l_s_month"),
						   emppensions.getString("pension_type"),
						   emppensions.getString("pension_rate"),
						   emppensions.getString("bps_settle"),
						   emppensions.getString("commutation"),
						   emppensions.getString("med_exam_reqd"),
						   emppensions.getString("commutation_frac"),
						   emppensions.getString("dom_checkup"),
						   emppensions.getString("commutation_dt"),
						   emppensions.getString("fpp"),
						   emppensions.getString("pqp"),
						   emppensions.getString("off_pay"),
						   emppensions.getString("total_pay")
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emppensionList;
	}
	
}
