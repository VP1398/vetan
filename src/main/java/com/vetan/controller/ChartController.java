package com.vetan.controller;

import com.vetan.data.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/chart")
public class ChartController {
	@RequestMapping(method = RequestMethod.GET)
	public String chart(ModelMap model) {
		return "chart";
	}

	@RequestMapping(value = "/getScaleamt", method = RequestMethod.POST)
	public @ResponseBody
    List<Component> getScaleamt() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Component> componentList = new ArrayList<Component>();

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			Connection dbConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/payroll_schema", "vetan", "vetan123");

			// retrieve necessary records from database
			Statement getFromDb = dbConnection.createStatement();
			ResultSet components = getFromDb
					.executeQuery("select componentname,  componentvalue from chartcat");

			// populate an ArrayList with the retrieved data
			while (components.next()) {
				componentList.add(new Component(components.getString("componentname"),
						components.getString("componentvalue")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return componentList;
	}
}
