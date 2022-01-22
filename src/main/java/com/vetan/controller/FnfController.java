package com.vetan.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// Spring Framework

import com.vetan.data.Fnf;

@Controller
@RequestMapping("/fnf")
public class FnfController {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String driverUrl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String grid(ModelMap model) {

		return "fnf";
	}

	@RequestMapping(value = "/gridfnf",method = RequestMethod.GET)
	public String gridfnf(ModelMap model) {


		return "grid/gridfnf";
	}
	
	@RequestMapping(value = "/getFnf", method = RequestMethod.POST)
	public @ResponseBody
    List<Fnf> getFnf() throws ClassNotFoundException {
		List<Fnf> fnfList = new ArrayList<Fnf>();
       // System.out.println("get Fnf ");
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(
					driverUrl, userName, password);
	
			Statement getFromDb = dbConnection.createStatement();
			ResultSet fnfs = getFromDb
					.executeQuery("SELECT ec,  ename,  cat,  role,  dob,  doj,  dop,  paexp,  age,  texp,  pexp,  city_type,  loc,  dept,  bcode,  gen,  account_no,  pan,  aadhaar,  email,  mobile,  manager,  dor,  lwd,  np_shortfall,  leave_bal,  np_waiver,  payable_days,  pf,  vpf,  pt,  it,  qtrs,  lic,  lic_js,  society,  h_sch,  hl,  hli,  hl2,  hli2,  payroll,  gl,  pfl,  fest_adv,  wl4,  wl2,  comp_l,  misc_l,  u_sub,  assoc_sub,  lwf,  fl,  sec_l,  cons_l,  mcdrf,  levy,  o_ded,  nps,  sl,  trust_l,  trust_int,  esi_ee,  esi_er,  l_ins,  total_payable,  total_deduct,  net_pay FROM fnf;");
			while (fnfs.next()) {
				fnfList.add(new Fnf(
				      					
					     fnfs.getString("ec"), 
					      fnfs.getString("ename"), 
					      fnfs.getString("cat"), 
					      fnfs.getString("role"), 
					      fnfs.getString("dob"), 
					      fnfs.getString("doj"), 
					      fnfs.getString("dop"), 
					      fnfs.getString("paexp"), 
					      fnfs.getString("age"), 
					      fnfs.getString("texp"), 
					      fnfs.getString("pexp"), 
					      fnfs.getString("city_type"), 
					      fnfs.getString("loc"), 
					      fnfs.getString("dept"), 
					      fnfs.getString("bcode"), 
					      fnfs.getString("gen"), 
					      fnfs.getString("account_no"), 
					      fnfs.getString("pan"), 
					      fnfs.getString("aadhaar"), 
					      fnfs.getString("email"), 
					      fnfs.getString("mobile"), 
					      fnfs.getString("manager"), 
					      fnfs.getString("dor"), 
					      fnfs.getString("lwd"), 
					      fnfs.getString("np_shortfall"), 
					      fnfs.getString("leave_bal"), 
					      fnfs.getString("np_waiver"), 
					      fnfs.getString("payable_days"), 
					      fnfs.getString("pf"), 
					      fnfs.getString("vpf"), 
					      fnfs.getString("pt"), 
					      fnfs.getString("it"), 
					      fnfs.getString("qtrs"), 
					      fnfs.getString("lic"), 
					      fnfs.getString("lic_js"), 
					      fnfs.getString("society"), 
					      fnfs.getString("h_sch"), 
					      fnfs.getString("hl"), 
					      fnfs.getString("hli"), 
					      fnfs.getString("hl2"), 
					      fnfs.getString("hli2"), 
					      fnfs.getString("payroll"), 
					      fnfs.getString("gl"), 
					      fnfs.getString("pfl"), 
					      fnfs.getString("fest_adv"), 
					      fnfs.getString("wl4"), 
					      fnfs.getString("wl2"), 
					      fnfs.getString("comp_l"), 
					      fnfs.getString("misc_l"), 
					      fnfs.getString("u_sub"), 
					      fnfs.getString("assoc_sub"), 
					      fnfs.getString("lwf"), 
					      fnfs.getString("fl"), 
					      fnfs.getString("sec_l"), 
					      fnfs.getString("cons_l"), 
					      fnfs.getString("mcdrf"), 
					      fnfs.getString("levy"), 
					      fnfs.getString("o_ded"), 
					      fnfs.getString("nps"), 
					      fnfs.getString("sl"), 
					      fnfs.getString("trust_l"), 
					      fnfs.getString("trust_int"), 
					      fnfs.getString("esi_ee"), 
					      fnfs.getString("esi_er"), 
					      fnfs.getString("l_ins"), 
					      fnfs.getString("total_payable"), 
					      fnfs.getString("total_deduct"), 
					      fnfs.getString("net_pay")

                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fnfList;
	}
	
}
