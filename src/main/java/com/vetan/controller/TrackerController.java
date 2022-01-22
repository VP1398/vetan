package com.vetan.controller;


import com.vetan.data.Tracker;

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
@RequestMapping("/tracker")
public class TrackerController {
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String tracker(ModelMap model) {
		return "tracker";
	}
	@RequestMapping(value = "/gridtracker",method = RequestMethod.GET)
	public String gridtracker(ModelMap model) {


		return "grid/gridtracker";
	}

	@RequestMapping(value = "/getTracker", method = RequestMethod.POST)
	public @ResponseBody
    List<Tracker> getReim() throws ClassNotFoundException {
		List<Tracker> trackerList = new ArrayList<Tracker>();
		try {
		
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet emptracker = getFromDb
					.executeQuery("SELECT id, claimdate,  claimid,  description,    status, amount, payment FROM tracker;");

			while (emptracker.next()) {
			  	trackerList.add(new Tracker(
			  			emptracker.getString("id"),
			  			emptracker.getString("claimdate"),
			  			emptracker.getString("claimid"),
			  		    emptracker.getString("description"),
			  		    emptracker.getString("status"),
			  			emptracker.getString("payment"),
			  			emptracker.getString("amount")
			  	
		
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// System.out.println("get employee " + trackerList );
		return trackerList;
	}
	
}
