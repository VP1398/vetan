package com.vetan.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.springframework.beans.factory.annotation.Value;


@RestController   
@RequestMapping("/Employee")
public class InsertController {
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@Autowired
	private Environment environment;

	@RequestMapping(path = "/Insert", method = RequestMethod.POST) // parameters will be field names
	
	public String Insert(@RequestParam String idemp, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String hire_date, @RequestParam String email, @RequestParam String salary, @RequestParam String jobid, @RequestParam String managerid) throws IOException {
     String myURL = environment.getProperty("JSON.URL");

			try {
			  	System.out.println("in try block");
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn = DriverManager.getConnection(driverUrl, userName,password);
				 // create a sql date object so we can use it in our INSERT statement
			      Calendar calendar = Calendar.getInstance();
			      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

			      // the mysql insert statement
   String query = "insert into empprofile(idemp, firstname, lastname, hire_date, email, salary, jobid, managerid)"
			        + "values (?, ?, ?, ?, ?, ?, ?, ?)";
			  	System.out.println("after query string");

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString (1, "10");
			      preparedStmt.setString (2, "Barney");
			      preparedStmt.setString (3, "Rubble");
			      preparedStmt.setDate   (4, startDate);
			      preparedStmt.setString (5, "abc@gmail.com");
			      preparedStmt.setInt    (6, 5000);
			      preparedStmt.setInt    (7, 02);
			      preparedStmt.setInt    (8, 20);

			      // execute the preparedstatement
			      preparedStmt.execute();
				  	System.out.println("after preparedStmt");

			      conn.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("Got an exception!");
			      System.err.println(e.getMessage());
			    }


		
		return "ok";

	}
	@RequestMapping(path = "/Update ", method = RequestMethod.POST) // parameters will be field names
	
	public String Update(@RequestParam String idemp, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String hire_date, @RequestParam String email, @RequestParam String salary, @RequestParam String jobid, @RequestParam String managerid) throws IOException {
     String myURL = environment.getProperty("JSON.URL");

			try {
			  	System.out.println("in try block");
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn = DriverManager.getConnection(driverUrl, userName,password);
				 // create a sql date object so we can use it in our INSERT statement
			      Calendar calendar = Calendar.getInstance();
			      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

			      // the mysql insert statement
   String query = "update empprofile set email = ? where idemp = ?";
   //create the java mysql update preparedstatement
  
   System.out.println("after query string");

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString (1, "barney@gmail.com");
			      preparedStmt.setString (2, "10");

			      // execute the preparedstatement
			      preparedStmt.executeUpdate();
				  	System.out.println("after preparedStmt");

			      conn.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("Got an exception!");
			      System.err.println(e.getMessage());
			    }


		
		return "ok";

	}


}