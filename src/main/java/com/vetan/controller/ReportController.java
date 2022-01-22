	package com.vetan.controller;

    import com.vetan.data.Loan;

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
    @RequestMapping("/report")
    public class ReportController {
    	

    	@Value("${spring.datasource.driver-class-name}")
    	private String driverClassName;

    	@Value("${spring.datasource.url}")
    	private String driverUrl;

    	@Value("${spring.datasource.username}")
    	private String userName;

    	@Value("${spring.datasource.password}")
    	private String password;

    	@RequestMapping(value = "/",method = RequestMethod.GET)
        public String report(ModelMap model) {
            return "report";
        }

    	@RequestMapping(value = "/gridgeneral",method = RequestMethod.GET)
    	public String gridgeneral(ModelMap model) {


    		return "grid/gridgeneral";
    	}
    	
    	@RequestMapping(value = "/gridhra",method = RequestMethod.GET)
    	public String gridhra(ModelMap model) {


    		return "grid/gridhra";
    	}
    	
    	@RequestMapping(value = "/gridit",method = RequestMethod.GET)
    	public String gridit(ModelMap model) {


    		return "grid/gridit";
    	}
    	
    	@RequestMapping(value = "/gridmcdrf",method = RequestMethod.GET)
    	public String gridmcdrf(ModelMap model) {


    		return "grid/gridmcdrf";
    	}
    	
    	@RequestMapping(value = "/gridmyit",method = RequestMethod.GET)
    	public String gridmyit(ModelMap model) {


    		return "grid/gridmyit";
    	}
    	
    	@RequestMapping(value = "/gridnps",method = RequestMethod.GET)
    	public String gridnps(ModelMap model) {

    		

    		return "grid/gridnps";
    	}
    	
    	@RequestMapping(value = "/gridpt",method = RequestMethod.GET)
    	public String gridpt(ModelMap model) {


    		return "grid/gridpt";
    	}
    	
    	@RequestMapping(value = "/gridvec",method = RequestMethod.GET)
    	public String gridvec(ModelMap model) {


    		return "grid/gridvec";
    	}
    	
    	
    	
    	
        @RequestMapping(value = "/getVec", method = RequestMethod.POST)
        public @ResponseBody
        List<Loan> getVec() throws ClassNotFoundException {
            List<Loan> reportList = new ArrayList<Loan>();


            try {
            
                Class.forName("com.mysql.jdbc.Driver");
        		Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

                Statement getFromDb = dbConnection.createStatement();
                ResultSet reports = getFromDb
                        .executeQuery("select id, ec,ename,area,bcode,loan_type,loan_amt from vec_view;");

                while (reports.next()) {
                    reportList.add(new Loan(
                    		reports.getString("id"),
                                            reports.getString("ec"),
                                            reports.getString("ename"),
                                               reports.getString("area"),
                                             reports.getString("bcode"),
                                            reports.getString("loan_type"),
                                            reports.getString("loan_amt")

                                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
         //    System.out.println("get employee " + reportList );
            return reportList;
        }
        @RequestMapping(value = "/getGeneral", method = RequestMethod.POST)
        public @ResponseBody
        List<Loan> getGeleral() throws ClassNotFoundException {
            List<Loan> reportList = new ArrayList<Loan>();


            try {
                 Class.forName("com.mysql.jdbc.Driver");
        		Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

                Statement getFromDb = dbConnection.createStatement();
                ResultSet reports = getFromDb
                        .executeQuery("select id, ec, ename,   area, bcode, loan_type, loan_amt from general_view;");

                while (reports.next()) {
                    reportList.add(new Loan(
                    		reports.getString("id"),
                                            reports.getString("ec"),
                                            reports.getString("ename"),
                                               reports.getString("area"),
                                             reports.getString("bcode"),
                                            reports.getString("loan_type"),
                                            reports.getString("loan_amt")

                                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
           //  System.out.println("get employee " + reportList );
            return reportList;
        }
        @RequestMapping(value = "/getMcdrf", method = RequestMethod.POST)
        public @ResponseBody
        List<Loan> getMcdrf() throws ClassNotFoundException {
            List<Loan> reportList = new ArrayList<Loan>();


            try {
           
                Class.forName("com.mysql.jdbc.Driver");
        		Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

                Statement getFromDb = dbConnection.createStatement();
                ResultSet reports = getFromDb
                        .executeQuery("select id, ec, ename,   area, bcode, loan_type, loan_amt from mcdrf_view;");

                while (reports.next()) {
                    reportList.add(new Loan(
                    		reports.getString("id"),
                                            reports.getString("ec"),
                                            reports.getString("ename"),
                                               reports.getString("area"),
                                             reports.getString("bcode"),
                                            reports.getString("loan_type"),
                                            reports.getString("loan_amt")

                                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
         //    System.out.println("get employee " + reportList );
            return reportList;
        }
        @RequestMapping(value = "/getNps", method = RequestMethod.POST)
        public @ResponseBody
        List<Loan> getNps() throws ClassNotFoundException {
            List<Loan> reportList = new ArrayList<Loan>();


            try {
    
                Class.forName("com.mysql.jdbc.Driver");
        		Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

                Statement getFromDb = dbConnection.createStatement();
                ResultSet reports = getFromDb
                        .executeQuery("select id, ec, ename,   area, bcode, loan_type, loan_amt from nps_view;");

                while (reports.next()) {
                    reportList.add(new Loan(
                    		reports.getString("id"),
                                            reports.getString("ec"),
                                            reports.getString("ename"),
                                               reports.getString("area"),
                                             reports.getString("bcode"),
                                            reports.getString("loan_type"),
                                            reports.getString("loan_amt")

                                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
         //    System.out.println("get employee " + reportList );
            return reportList;
        }
        @RequestMapping(value = "/getHra", method = RequestMethod.POST)
        public @ResponseBody
        List<Loan> getHra() throws ClassNotFoundException {
            List<Loan> reportList = new ArrayList<Loan>();


            try {
       
                Class.forName("com.mysql.jdbc.Driver");
        		Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

                Statement getFromDb = dbConnection.createStatement();
                ResultSet reports = getFromDb
                        .executeQuery("select id, ec, ename,   area, bcode, loan_type, loan_amt from hra_view;");

                while (reports.next()) {
                    reportList.add(new Loan(
                    		reports.getString("id"),
                                            reports.getString("ec"),
                                            reports.getString("ename"),
                                               reports.getString("area"),
                                             reports.getString("bcode"),
                                            reports.getString("loan_type"),
                                            reports.getString("loan_amt")

                                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
           //  System.out.println("get employee " + reportList );
            return reportList;
        }
        @RequestMapping(value = "/getLwf", method = RequestMethod.POST)
        public @ResponseBody
        List<Loan> getLwf() throws ClassNotFoundException {
            List<Loan> reportList = new ArrayList<Loan>();


            try {
        
                Class.forName("com.mysql.jdbc.Driver");
        		Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

                Statement getFromDb = dbConnection.createStatement();
                ResultSet reports = getFromDb
                        .executeQuery("select id,  ec, ename,   area, bcode, loan_type, loan_amt from lwf_view;");

                while (reports.next()) {
                    reportList.add(new Loan(
                    		     reports.getString("id"),
                                            reports.getString("ec"),
                                            reports.getString("ename"),
                                               reports.getString("area"),
                                             reports.getString("bcode"),
                                            reports.getString("loan_type"),
                                            reports.getString("loan_amt")

                                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
         //    System.out.println("get employee " + reportList );
            return reportList;
        }
        @RequestMapping(value = "/getPt", method = RequestMethod.POST)
        public @ResponseBody
        List<Loan> getPt() throws ClassNotFoundException {
            List<Loan> reportList = new ArrayList<Loan>();


            try {

                Class.forName("com.mysql.jdbc.Driver");
        		Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

                Statement getFromDb = dbConnection.createStatement();
                ResultSet reports = getFromDb
                        .executeQuery("select id, ec, ename,   area, bcode, loan_type, loan_amt from pt_view;");

                while (reports.next()) {
                    reportList.add(new Loan(
                    					    reports.getString("id"),
                                            reports.getString("ec"),
                                            reports.getString("ename"),
                                            reports.getString("area"),
                                            reports.getString("bcode"),
                                            reports.getString("loan_type"),
                                            reports.getString("loan_amt")

                                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
          //   System.out.println("get employee " + reportList );
            return reportList;
        }
        @RequestMapping(value = "/getIt", method = RequestMethod.POST)
        public @ResponseBody
        List<Loan> getIt() throws ClassNotFoundException {
            List<Loan> reportList = new ArrayList<Loan>();


            try {
      
                Class.forName("com.mysql.jdbc.Driver");
        		Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

                Statement getFromDb = dbConnection.createStatement();
                ResultSet reports = getFromDb
                        .executeQuery("select id, ec, ename,   area, bcode, round(loan_type) as loan_type, loan_amt from it_view;");

                while (reports.next()) {
                    reportList.add(new Loan(
                    		 				reports.getString("id"),
                                            reports.getString("ec"),
                                            reports.getString("ename"),
                                              reports.getString("area"),
                                             reports.getString("bcode"),
                                            reports.getString("loan_type"),
                                            reports.getString("loan_amt")

                                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        //     System.out.println("get employee " + reportList );
            return reportList;
        }
        @RequestMapping(value = "/getMyit", method = RequestMethod.POST)
        public @ResponseBody
        List<Loan> getMyit() throws ClassNotFoundException {
            List<Loan> reportList = new ArrayList<Loan>();


            try {
  
                Class.forName("com.mysql.jdbc.Driver");
        		Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);

                Statement getFromDb = dbConnection.createStatement();
                ResultSet reports = getFromDb
                        .executeQuery("select id, ec, ename,   area, bcode, round(loan_type) as loan_type, loan_amt from it_view where ec =1000138;");

                while (reports.next()) {
                    reportList.add(new Loan(
                    		reports.getString("id"),
                                            reports.getString("ec"),
                                            reports.getString("ename"),
                                               reports.getString("area"),
                                             reports.getString("bcode"),
                                            reports.getString("loan_type"),
                                            reports.getString("loan_amt")

                                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
         //    System.out.println("get employee " + reportList );
            return reportList;
        }
    }
