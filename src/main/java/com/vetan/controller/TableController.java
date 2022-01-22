package com.vetan.controller;

import com.vetan.data.Other;

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
@RequestMapping("/table")
public class TableController {
	

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String table(ModelMap model) {
		return "table";
	}

	@RequestMapping(value = "/gridesi",method = RequestMethod.GET)
	public String gridemp(ModelMap model) {


		return "grid/gridesi";
	}
	
	@RequestMapping(value = "/gridhome",method = RequestMethod.GET)
	public String gridhome(ModelMap model) {


		return "grid/gridhome";
	}
	@RequestMapping(value = "/gridlic",method = RequestMethod.GET)
	public String gridlic(ModelMap model) {


		return "grid/gridlic";
	}
	@RequestMapping(value = "/gridlwf",method = RequestMethod.GET)
	public String gridlwf(ModelMap model) {


		return "grid/gridlwf";
	}
	@RequestMapping(value = "/gridsoc",method = RequestMethod.GET)
	public String gridsoc(ModelMap model) {


		return "grid/gridsoc";
	}
	@RequestMapping(value = "/gridunion",method = RequestMethod.GET)
	public String gridunion(ModelMap model) {


		return "grid/gridunion";
	}
	@RequestMapping(value = "/getHome", method = RequestMethod.POST)
	public @ResponseBody
    List<Other> getHome() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Other> otherList = new ArrayList<Other>();

		try {
		
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);
			// retrieve necessary records from database
			Statement getFromDb = dbConnection.createStatement();
			ResultSet tables = getFromDb
					.executeQuery("select id, ec, ename,   area, bcode,type1,type2,type3,type4,type5, total from home_view;");

			

			// populate an ArrayList with the retrieved data
			while (tables.next()) {
				otherList.add(new Other(
				      					
						tables.getString("id"),
						tables.getString("ec"), 
				                        tables.getString("ename"), 
				                         tables.getString("area"), 
				                         tables.getString("bcode"), 
				                        tables.getString("type1"), 
				                        tables.getString("type2"),
				                        tables.getString("type3"), 
				                        tables.getString("type4"),
				                        tables.getString("type5"), 
				                        tables.getString("total")
		
	                            ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return otherList;
	}
	@RequestMapping(value = "/getLic", method = RequestMethod.POST)
	public @ResponseBody
    List<Other> getLic() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Other> otherList = new ArrayList<Other>();

		try {
	
			Class.forName("com.mysql.jdbc.Driver"); 
					Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet tables = getFromDb
					.executeQuery("select id, ec, ename,   area, bcode,lic as type1,lic_js type2,0 as type3, 0 as type4,0  as type5, total from lic_view;");

			

			while (tables.next()) {
				otherList.add(new Other(
						tables.getString("id"),
										tables.getString("ec"), 
				                        tables.getString("ename"), 
				                         tables.getString("area"), 
				                         tables.getString("bcode"), 
				                        tables.getString("type1"), 
				                        tables.getString("type2"),
				                        tables.getString("type3"), 
				                        tables.getString("type4"),
				                        tables.getString("type5"), 
				                        tables.getString("total")
		
	                            ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return otherList;
	}
	@RequestMapping(value = "/getSoc", method = RequestMethod.POST)
	public @ResponseBody
    List<Other> getSoc() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Other> otherList = new ArrayList<Other>();

		try {
		
			Class.forName("com.mysql.jdbc.Driver"); 
					Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet tables = getFromDb
					.executeQuery("select id, ec, ename,   area, bcode,society as type1,off_pay type2,0 as type3, 0 as type4,0  as type5, total from society_view;");

			

			while (tables.next()) {
				otherList.add(new Other(
						tables.getString("id"),
										tables.getString("ec"), 
				                        tables.getString("ename"), 
				                         tables.getString("area"), 
				                         tables.getString("bcode"), 
				                        tables.getString("type1"), 
				                        tables.getString("type2"),
				                        tables.getString("type3"), 
				                        tables.getString("type4"),
				                        tables.getString("type5"), 
				                        tables.getString("total")
		
	                            ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return otherList;
	}
	@RequestMapping(value = "/getUnion", method = RequestMethod.POST)
	public @ResponseBody
    List<Other> getUnion() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Other> otherList = new ArrayList<Other>();

		try {
		
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet tables = getFromDb
					.executeQuery("select id, ec, ename,   area, bcode,assoc_sub as type1,u_sub type2,0 as type3, 0 as type4,0  as type5, total from union_view;");

			

			while (tables.next()) {
				otherList.add(new Other(
						tables.getString("id"),
										tables.getString("ec"), 
				                        tables.getString("ename"), 
				                         tables.getString("area"), 
				                         tables.getString("bcode"), 
				                        tables.getString("type1"), 
				                        tables.getString("type2"),
				                        tables.getString("type3"), 
				                        tables.getString("type4"),
				                        tables.getString("type5"), 
				                        tables.getString("total")
		
	                            ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return otherList;
	}
	@RequestMapping(value = "/getEsi", method = RequestMethod.POST)
	public @ResponseBody
    List<Other> getEsi() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Other> otherList = new ArrayList<Other>();

		try {

			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet tables = getFromDb
					.executeQuery("select id, ec, ename,   area, bcode,esi_ee as type1,esi_er type2,0 as type3, 0 as type4,0  as type5, total from esi_view;");

			

			while (tables.next()) {
				otherList.add(new Other(
						tables.getString("id"),
										tables.getString("ec"), 
				                        tables.getString("ename"), 
				                         tables.getString("area"), 
				                         tables.getString("bcode"), 
				                        tables.getString("type1"), 
				                        tables.getString("type2"),
				                        tables.getString("type3"), 
				                        tables.getString("type4"),
				                        tables.getString("type5"), 
				                        tables.getString("total")
		
	                            ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return otherList;
	}
	@RequestMapping(value = "/getLwf", method = RequestMethod.POST)
	public @ResponseBody
    List<Other> getLwf() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		List<Other> otherList = new ArrayList<Other>();

		try {
	
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet tables = getFromDb
					.executeQuery("select id, ec, ename,   area, bcode,esi_ee as type1,esi_er type2,0 as type3, 0 as type4,0  as type5, total from lwf_view;");

			

			while (tables.next()) {
				otherList.add(new Other(
						tables.getString("id"),
										tables.getString("ec"), 
				                        tables.getString("ename"), 
				                         tables.getString("area"), 
				                         tables.getString("bcode"), 
				                        tables.getString("type1"), 
				                        tables.getString("type2"),
				                        tables.getString("type3"), 
				                        tables.getString("type4"),
				                        tables.getString("type5"), 
				                        tables.getString("total")
		
	                            ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return otherList;
	}
}