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
import com.vetan.data.Employee;

@Controller
@RequestMapping("/grid")
public class GridController {

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

		return "grid";
	}

	@RequestMapping(value = "/vetanpie",method = RequestMethod.GET)
	public String getVetanpie(ModelMap model) {


		return "grid/vetanpie";
	}

	@RequestMapping(value = "/grid10",method = RequestMethod.GET)
	public String grid10(ModelMap model) {


		return "grid/grid10";
	}
	@RequestMapping(value = "/grid11",method = RequestMethod.GET)
	public String grid11(ModelMap model) {


		return "grid/grid11";
	}
	@RequestMapping(value = "/gridar",method = RequestMethod.GET)
	public String gridar(ModelMap model) {


		return "grid/gridar";
	}
	@RequestMapping(value = "/gridvar",method = RequestMethod.GET)
	public String gridvar(ModelMap model) {


		return "grid/gridvar";
	}
	
	 @RequestMapping(value = "/row",method = RequestMethod.GET)
	    public String row(ModelMap model){
	        return "grid/row";
	    }
	    
	@RequestMapping(value = "/gridemp",method = RequestMethod.GET)
	public String gridemp(ModelMap model) {


		return "grid/gridemp";
	}
	
	@RequestMapping(value = "/gridmy10",method = RequestMethod.GET)
	public String gridmy10(ModelMap model) {


		return "grid/gridmy10";
	}
	
	@RequestMapping(value = "/gridpayslip",method = RequestMethod.GET)
	public String gridpayslip(ModelMap model) {


		return "grid/gridpayslip";
	}

	@RequestMapping(value = "/gridmyarr",method = RequestMethod.GET)
	public String gridmyarr(ModelMap model) {


		return "grid/gridmyarr";
	}
	@RequestMapping(value = "/gridmyvar",method = RequestMethod.GET)
	public String gridmyvar(ModelMap model) {


		return "grid/gridmyvar";
	}

	@RequestMapping(value = "/gridvp",method = RequestMethod.GET)
	public String gridvp(ModelMap model) {


		return "grid/gridvp";
	}
	
	@RequestMapping(value = "/statutory",method = RequestMethod.GET)
	public String statutory(ModelMap model) {


		return "grid/statutory";
	}
	


	
	@RequestMapping(value = "/getEmployees11", method = RequestMethod.POST)
	public @ResponseBody
    List<Employee> getEmployees11() throws ClassNotFoundException {
		List<Employee> employeeList = new ArrayList<Employee>();
     //  System.out.println("get employee ");
		try {

			String tableName="salary11";
			employeeList =getTableInformation(tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}
	private List<Employee> getTableInformation(String tableName) throws ClassNotFoundException, SQLException {
		
		
		List<Employee> employtList = new ArrayList<Employee>();
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection dbConnection = DriverManager.getConnection(driverUrl, userName,password);
		System.out.println("connection dbConnection");
		Statement getFromDb = dbConnection.createStatement();
		ResultSet employees = getFromDb
				.executeQuery("SELECT id, ec,    ename,    cat,    role,    dob,    doj,    dop,    paexp,    loc,    dept,    bcode,    gen,    account_no,    pan,    aadhaar,    email,    mobile,    manager,    ph_conv,    sub_all,    age,    texp,    pexp,    City_type,    BPay,    DA,    House_Cl_All,    Spl_All,    PF,    VPF,    hac,    hra,    pqp,    holiday_working,    deputa_all,    sd_all,    transfer,    transport,    shifting_all,    off_pay,    lunch_1,    lunch_2,    road_trvl_all,    mid_aca_trsfr_all,    award_grad_ss,    fa_lop,      c_tr,    med_aid,    health_checkup,    merit_award,    briefcase,    np_all,    edu_exp,    pli,    c_fee,    s_ss,    s_fee,    s_hon,    d_hon,    mba_hon,    hon_uy_s,    hon_uy_n,    hon_uy_i,    pt,    it,    qtrs,    lic,    lic_js,    society,    h_sch,    hl,    hli,    hl2,    hli2,    payroll,    gl,    pfl,    fest_adv,    wl4,    wl2,    comp_l,    misc_l,    u_sub,    assoc_sub,    lwf,    fl,    sec_l,    cons_l,    mcdrf,    levy,    o_ded,    nps,    sl,    trust_l,    trust_int,    esi_ee,    esi_er,    l_ins,    add_cash_all,    add_f_all,    add_upcntry_all,    bosh_all,    can_all,    cycle_all,    hardship_all,    home_travel,    lumsum_all,    lumsum_all_pilot,    spl_area_all,        upcntry_all,    veh_maint,    wash_all,    fpp,    cca_metro,    conveyance,    paradip_port_all,    proj_area_all,    travel_halting_all,    total_payable,    total_deduct,    net_pay FROM salary11;");
		while (employees.next()) {
			employtList.add(new Employee(
			      					
					 employees.getString("id"), 
					 employees.getString("ec"), 
					   employees.getString("ename"), 
					   employees.getString("cat"), 
					   employees.getString("role"), 
					   employees.getString("dob"), 
					   employees.getString("doj"), 
					   employees.getString("dop"), 
					   employees.getString("paexp"), 
					   employees.getString("loc"), 
					   employees.getString("dept"), 
					   employees.getString("bcode"), 
					   employees.getString("gen"), 
					   employees.getString("account_no"), 
					   employees.getString("pan"), 
					   employees.getString("aadhaar"), 
					   employees.getString("email"), 
					   employees.getString("mobile"), 
					   employees.getString("manager"), 
					   employees.getString("ph_conv"), 
					   employees.getString("sub_all"), 
					   employees.getString("age"), 
					   employees.getString("texp"), 
					   employees.getString("pexp"), 
					   employees.getString("city_type"), 
					   employees.getString("bpay"), 
					   employees.getString("da"), 
					   employees.getString("house_cl_all"), 
					   employees.getString("spl_all"), 
					   employees.getString("pf"), 
					   employees.getString("vpf"), 
					   employees.getString("hac"), 
					   employees.getString("hra"), 
					   employees.getString("pqp"), 
					   employees.getString("holiday_working"), 
					   employees.getString("deputa_all"), 
					   employees.getString("sd_all"), 
					   employees.getString("transfer"), 
					   employees.getString("transport"), 
					   employees.getString("shifting_all"), 
					   employees.getString("off_pay"), 
					   employees.getString("lunch_1"), 
					   employees.getString("lunch_2"), 
					   employees.getString("road_trvl_all"), 
					   employees.getString("mid_aca_trsfr_all"), 
					   employees.getString("award_grad_ss"), 
					   employees.getString("fa_lop"), 
					   employees.getString("c_tr"), 
					   employees.getString("med_aid"), 
					   employees.getString("health_checkup"), 
					   employees.getString("merit_award"), 
					   employees.getString("briefcase"), 
					   employees.getString("np_all"), 
					   employees.getString("edu_exp"), 
					   employees.getString("pli"), 
					   employees.getString("c_fee"), 
					   employees.getString("s_ss"), 
					   employees.getString("s_fee"), 
					   employees.getString("s_hon"), 
					   employees.getString("d_hon"), 
					   employees.getString("mba_hon"), 
					   employees.getString("hon_uy_s"), 
					   employees.getString("hon_uy_n"), 
					   employees.getString("hon_uy_i"), 
					   employees.getString("pt"), 
					   employees.getString("it"), 
					   employees.getString("qtrs"), 
					   employees.getString("lic"), 
					   employees.getString("lic_js"), 
					   employees.getString("society"), 
					   employees.getString("h_sch"), 
					   employees.getString("hl"), 
					   employees.getString("hli"), 
					   employees.getString("hl2"), 
					   employees.getString("hli2"), 
					   employees.getString("payroll"), 
					   employees.getString("gl"), 
					   employees.getString("pfl"), 
					   employees.getString("fest_adv"), 
					   employees.getString("wl4"), 
					   employees.getString("wl2"), 
					   employees.getString("comp_l"), 
					   employees.getString("misc_l"), 
					   employees.getString("u_sub"), 
					   employees.getString("assoc_sub"), 
					   employees.getString("lwf"), 
					   employees.getString("fl"), 
					   employees.getString("sec_l"), 
					   employees.getString("cons_l"), 
					   employees.getString("mcdrf"), 
					   employees.getString("levy"), 
					   employees.getString("o_ded"), 
					   employees.getString("nps"), 
					   employees.getString("sl"), 
					   employees.getString("trust_l"), 
					   employees.getString("trust_int"), 
					   employees.getString("esi_ee"), 
					   employees.getString("esi_er"), 
					   employees.getString("l_ins"), 
					   employees.getString("add_cash_all"), 
					   employees.getString("add_f_all"), 
					   employees.getString("add_upcntry_all"), 
					   employees.getString("bosh_all"), 
					   employees.getString("can_all"), 
					   employees.getString("cycle_all"), 
					   employees.getString("hardship_all"), 
					   employees.getString("home_travel"), 
					   employees.getString("lumsum_all"), 
					   employees.getString("lumsum_all_pilot"), 
					   employees.getString("spl_area_all"), 
					  
					   employees.getString("upcntry_all"), 
					   employees.getString("veh_maint"), 
					   employees.getString("wash_all"), 
					   employees.getString("fpp"), 
					   employees.getString("cca_metro"), 
					   employees.getString("conveyance"), 
					   employees.getString("paradip_port_all"), 
					   employees.getString("proj_area_all"), 
					   employees.getString("travel_halting_all"), 
					   employees.getString("total_payable"), 
					   employees.getString("total_deduct"), 
					   employees.getString("net_pay")
		                    ));
		}
		
		return employtList;
	}
	@RequestMapping(value = "/getEmployees10", method = RequestMethod.POST)
	public @ResponseBody
    List<Employee> getEmployees10() throws ClassNotFoundException {
		List<Employee> employeeList = new ArrayList<Employee>();

		try {
		
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(
					driverUrl, userName, password);


			Statement getFromDb = dbConnection.createStatement();
			ResultSet employees = getFromDb
					.executeQuery("SELECT id, ec,    ename,    cat,    role,    dob,    doj,    dop,    paexp,    loc,    dept,    bcode,    gen,    account_no,    pan,    aadhaar,    email,    mobile,    manager,    ph_conv,    sub_all,    age,    texp,    pexp,    City_type,    BPay,    DA,    House_Cl_All,    Spl_All,    PF,    VPF,    hac,    hra,    pqp,    holiday_working,    deputa_all,    sd_all,    transfer,    transport,    shifting_all,    off_pay,    lunch_1,    lunch_2,    road_trvl_all,    mid_aca_trsfr_all,    award_grad_ss,    fa_lop,     c_tr,    med_aid,    health_checkup,    merit_award,    briefcase,    np_all,    edu_exp,    pli,    c_fee,    s_ss,    s_fee,    s_hon,    d_hon,    mba_hon,    hon_uy_s,    hon_uy_n,    hon_uy_i,    pt,    it,    qtrs,    lic,    lic_js,    society,    h_sch,    hl,    hli,    hl2,    hli2,    payroll,    gl,    pfl,    fest_adv,    wl4,    wl2,    comp_l,    misc_l,    u_sub,    assoc_sub,    lwf,    fl,    sec_l,    cons_l,    mcdrf,    levy,    o_ded,    nps,    sl,    trust_l,    trust_int,    esi_ee,    esi_er,    l_ins,    add_cash_all,    add_f_all,    add_upcntry_all,    bosh_all,    can_all,    cycle_all,    hardship_all,    home_travel,    lumsum_all,    lumsum_all_pilot,    spl_area_all,        upcntry_all,    veh_maint,    wash_all,    fpp,    cca_metro,    conveyance,    paradip_port_all,    proj_area_all,    travel_halting_all,    total_payable,    total_deduct,    net_pay FROM salary10;");

			while (employees.next()) {
				employeeList.add(new Employee(
						 employees.getString("id"), 
						 employees.getString("ec"), 
						   employees.getString("ename"), 
						   employees.getString("cat"), 
						   employees.getString("role"), 
						   employees.getString("dob"), 
						   employees.getString("doj"), 
						   employees.getString("dop"), 
						   employees.getString("paexp"), 
						   employees.getString("loc"), 
						   employees.getString("dept"), 
						   employees.getString("bcode"), 
						   employees.getString("gen"), 
						   employees.getString("account_no"), 
						   employees.getString("pan"), 
						   employees.getString("aadhaar"), 
						   employees.getString("email"), 
						   employees.getString("mobile"), 
						   employees.getString("manager"), 
						   employees.getString("ph_conv"), 
						   employees.getString("sub_all"), 
						   employees.getString("age"), 
						   employees.getString("texp"), 
						   employees.getString("pexp"), 
						   employees.getString("city_type"), 
						   employees.getString("bpay"), 
						   employees.getString("da"), 
						   employees.getString("house_cl_all"), 
						   employees.getString("spl_all"), 
						   employees.getString("pf"), 
						   employees.getString("vpf"), 
						   employees.getString("hac"), 
						   employees.getString("hra"), 
						   employees.getString("pqp"), 
						   employees.getString("holiday_working"), 
						   employees.getString("deputa_all"), 
						   employees.getString("sd_all"), 
						   employees.getString("transfer"), 
						   employees.getString("transport"), 
						   employees.getString("shifting_all"), 
						   employees.getString("off_pay"), 
						   employees.getString("lunch_1"), 
						   employees.getString("lunch_2"), 
						   employees.getString("road_trvl_all"), 
						   employees.getString("mid_aca_trsfr_all"), 
						   employees.getString("award_grad_ss"), 
						   employees.getString("fa_lop"), 
						  
						   employees.getString("c_tr"), 
						   employees.getString("med_aid"), 
						   employees.getString("health_checkup"), 
						   employees.getString("merit_award"), 
						   employees.getString("briefcase"), 
						   employees.getString("np_all"), 
						   employees.getString("edu_exp"), 
						   employees.getString("pli"), 
						   employees.getString("c_fee"), 
						   employees.getString("s_ss"), 
						   employees.getString("s_fee"), 
						   employees.getString("s_hon"), 
						   employees.getString("d_hon"), 
						   employees.getString("mba_hon"), 
						   employees.getString("hon_uy_s"), 
						   employees.getString("hon_uy_n"), 
						   employees.getString("hon_uy_i"), 
						   employees.getString("pt"), 
						   employees.getString("it"), 
						   employees.getString("qtrs"), 
						   employees.getString("lic"), 
						   employees.getString("lic_js"), 
						   employees.getString("society"), 
						   employees.getString("h_sch"), 
						   employees.getString("hl"), 
						   employees.getString("hli"), 
						   employees.getString("hl2"), 
						   employees.getString("hli2"), 
						   employees.getString("payroll"), 
						   employees.getString("gl"), 
						   employees.getString("pfl"), 
						   employees.getString("fest_adv"), 
						   employees.getString("wl4"), 
						   employees.getString("wl2"), 
						   employees.getString("comp_l"), 
						   employees.getString("misc_l"), 
						   employees.getString("u_sub"), 
						   employees.getString("assoc_sub"), 
						   employees.getString("lwf"), 
						   employees.getString("fl"), 
						   employees.getString("sec_l"), 
						   employees.getString("cons_l"), 
						   employees.getString("mcdrf"), 
						   employees.getString("levy"), 
						   employees.getString("o_ded"), 
						   employees.getString("nps"), 
						   employees.getString("sl"), 
						   employees.getString("trust_l"), 
						   employees.getString("trust_int"), 
						   employees.getString("esi_ee"), 
						   employees.getString("esi_er"), 
						   employees.getString("l_ins"), 
						   employees.getString("add_cash_all"), 
						   employees.getString("add_f_all"), 
						   employees.getString("add_upcntry_all"), 
						   employees.getString("bosh_all"), 
						   employees.getString("can_all"), 
						   employees.getString("cycle_all"), 
						   employees.getString("hardship_all"), 
						   employees.getString("home_travel"), 
						   employees.getString("lumsum_all"), 
						   employees.getString("lumsum_all_pilot"), 
						   employees.getString("spl_area_all"), 
						   employees.getString("upcntry_all"), 
						   employees.getString("veh_maint"), 
						   employees.getString("wash_all"), 
						   employees.getString("fpp"), 
						   employees.getString("cca_metro"), 
						   employees.getString("conveyance"), 
						   employees.getString("paradip_port_all"), 
						   employees.getString("proj_area_all"), 
						   employees.getString("travel_halting_all"), 
						   employees.getString("total_payable"), 
						   employees.getString("total_deduct"), 
						   employees.getString("net_pay")
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employeeList;
	}
	@RequestMapping(value = "/getEmpsal", method = RequestMethod.POST)
	public @ResponseBody
    List<Employee> getEmpsal() throws ClassNotFoundException {
		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(
					driverUrl, userName, password);


			Statement getFromDb = dbConnection.createStatement();
			ResultSet employees = getFromDb
					.executeQuery("SELECT id, ec,    ename,    cat,    role,   DATE_FORMAT(dob, '%d/%m/%Y') AS dob, DATE_FORMAT(doj, '%d/%m/%Y') AS doj   ,  DATE_FORMAT(dop, '%d/%m/%Y') AS dop  ,   paexp,    loc,    dept,    bcode,    gen,    account_no,    pan,    aadhaar,    email,    mobile,    manager,    ph_conv,    sub_all,    age,    texp,    pexp,    City_type,    BPay,    DA,    House_Cl_All,    Spl_All,    PF,    VPF,    hac,    hra,    pqp,    holiday_working,    deputa_all,    sd_all,    transfer,    transport,    shifting_all,    off_pay,    lunch_1,    lunch_2,    road_trvl_all,    mid_aca_trsfr_all,    award_grad_ss,    fa_lop,     c_tr,    med_aid,    health_checkup,    merit_award,    briefcase,    np_all,    edu_exp,    pli,    c_fee,    s_ss,    s_fee,    s_hon,    d_hon,    mba_hon,    hon_uy_s,    hon_uy_n,    hon_uy_i,    pt,    it,    qtrs,    lic,    lic_js,    society,    h_sch,    hl,    hli,    hl2,    hli2,    payroll,    gl,    pfl,    fest_adv,    wl4,    wl2,    comp_l,    misc_l,    u_sub,    assoc_sub,    lwf,    fl,    sec_l,    cons_l,    mcdrf,    levy,    o_ded,    nps,    sl,    trust_l,    trust_int,    esi_ee,    esi_er,    l_ins,    add_cash_all,    add_f_all,    add_upcntry_all,    bosh_all,    can_all,    cycle_all,    hardship_all,    home_travel,    lumsum_all,    lumsum_all_pilot,    spl_area_all,       upcntry_all,    veh_maint,    wash_all,    fpp,    cca_metro,    conveyance,    paradip_port_all,    proj_area_all,    travel_halting_all,    total_payable,    total_deduct,    net_pay FROM empsal;");

			while (employees.next()) {
				employeeList.add(new Employee(
						 employees.getString("id"), 		
						 employees.getString("ec"), 
						   employees.getString("ename"), 
						   employees.getString("cat"), 
						   employees.getString("role"), 
						   employees.getString("dob"), 
						   employees.getString("doj"), 
						   employees.getString("dop"), 
						   employees.getString("paexp"), 
						   employees.getString("loc"), 
						   employees.getString("dept"), 
						   employees.getString("bcode"), 
						   employees.getString("gen"), 
						   employees.getString("account_no"), 
						   employees.getString("pan"), 
						   employees.getString("aadhaar"), 
						   employees.getString("email"), 
						   employees.getString("mobile"), 
						   employees.getString("manager"), 
						   employees.getString("ph_conv"), 
						   employees.getString("sub_all"), 
						   employees.getString("age"), 
						   employees.getString("texp"), 
						   employees.getString("pexp"), 
						   employees.getString("city_type"), 
						   employees.getString("bpay"), 
						   employees.getString("da"), 
						   employees.getString("house_cl_all"), 
						   employees.getString("spl_all"), 
						   employees.getString("pf"), 
						   employees.getString("vpf"), 
						   employees.getString("hac"), 
						   employees.getString("hra"), 
						   employees.getString("pqp"), 
						   employees.getString("holiday_working"), 
						   employees.getString("deputa_all"), 
						   employees.getString("sd_all"), 
						   employees.getString("transfer"), 
						   employees.getString("transport"), 
						   employees.getString("shifting_all"), 
						   employees.getString("off_pay"), 
						   employees.getString("lunch_1"), 
						   employees.getString("lunch_2"), 
						   employees.getString("road_trvl_all"), 
						   employees.getString("mid_aca_trsfr_all"), 
						   employees.getString("award_grad_ss"), 
						   employees.getString("fa_lop"), 
						 
						   employees.getString("c_tr"), 
						   employees.getString("med_aid"), 
						   employees.getString("health_checkup"), 
						   employees.getString("merit_award"), 
						   employees.getString("briefcase"), 
						   employees.getString("np_all"), 
						   employees.getString("edu_exp"), 
						   employees.getString("pli"), 
						   employees.getString("c_fee"), 
						   employees.getString("s_ss"), 
						   employees.getString("s_fee"), 
						   employees.getString("s_hon"), 
						   employees.getString("d_hon"), 
						   employees.getString("mba_hon"), 
						   employees.getString("hon_uy_s"), 
						   employees.getString("hon_uy_n"), 
						   employees.getString("hon_uy_i"), 
						   employees.getString("pt"), 
						   employees.getString("it"), 
						   employees.getString("qtrs"), 
						   employees.getString("lic"), 
						   employees.getString("lic_js"), 
						   employees.getString("society"), 
						   employees.getString("h_sch"), 
						   employees.getString("hl"), 
						   employees.getString("hli"), 
						   employees.getString("hl2"), 
						   employees.getString("hli2"), 
						   employees.getString("payroll"), 
						   employees.getString("gl"), 
						   employees.getString("pfl"), 
						   employees.getString("fest_adv"), 
						   employees.getString("wl4"), 
						   employees.getString("wl2"), 
						   employees.getString("comp_l"), 
						   employees.getString("misc_l"), 
						   employees.getString("u_sub"), 
						   employees.getString("assoc_sub"), 
						   employees.getString("lwf"), 
						   employees.getString("fl"), 
						   employees.getString("sec_l"), 
						   employees.getString("cons_l"), 
						   employees.getString("mcdrf"), 
						   employees.getString("levy"), 
						   employees.getString("o_ded"), 
						   employees.getString("nps"), 
						   employees.getString("sl"), 
						   employees.getString("trust_l"), 
						   employees.getString("trust_int"), 
						   employees.getString("esi_ee"), 
						   employees.getString("esi_er"), 
						   employees.getString("l_ins"), 
						   employees.getString("add_cash_all"), 
						   employees.getString("add_f_all"), 
						   employees.getString("add_upcntry_all"), 
						   employees.getString("bosh_all"), 
						   employees.getString("can_all"), 
						   employees.getString("cycle_all"), 
						   employees.getString("hardship_all"), 
						   employees.getString("home_travel"), 
						   employees.getString("lumsum_all"), 
						   employees.getString("lumsum_all_pilot"), 
						   employees.getString("spl_area_all"), 

						   employees.getString("upcntry_all"), 
						   employees.getString("veh_maint"), 
						   employees.getString("wash_all"), 
						   employees.getString("fpp"), 
						   employees.getString("cca_metro"), 
						   employees.getString("conveyance"), 
						   employees.getString("paradip_port_all"), 
						   employees.getString("proj_area_all"), 
						   employees.getString("travel_halting_all"), 
						   employees.getString("total_payable"), 
						   employees.getString("total_deduct"), 
						   employees.getString("net_pay")
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return employeeList;
	}
	@RequestMapping(value = "/getEmparr", method = RequestMethod.POST)
	public @ResponseBody
    List<Employee> getEmparr() throws ClassNotFoundException {
		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(
					driverUrl, userName, password);
			Statement getFromDb = dbConnection.createStatement();
			ResultSet employees = getFromDb
					.executeQuery("SELECT  id,   ec,  ename,    cat,    role,   dob,    doj,     dop,    paexp,    loc,    dept,    bcode,    gen,    account_no,    pan,    aadhaar,    email,    mobile,    manager,    ph_conv,    sub_all,    age,    texp,    pexp,    City_type,    BPay,    DA,    House_Cl_All,    Spl_All,    PF,    VPF,    hac,    hra,    pqp,    holiday_working,    deputa_all,    sd_all,    transfer,    transport,    shifting_all,    off_pay,    lunch_1,    lunch_2,    road_trvl_all,    mid_aca_trsfr_all,    award_grad_ss,    fa_lop,     c_tr,    med_aid,    health_checkup,    merit_award,    briefcase,    np_all,    edu_exp,    pli,    c_fee,    s_ss,    s_fee,    s_hon,    d_hon,    mba_hon,    hon_uy_s,    hon_uy_n,    hon_uy_i,    pt,    it,    qtrs,    lic,    lic_js,    society,    h_sch,    hl,    hli,    hl2,    hli2,    payroll,    gl,    pfl,    fest_adv,    wl4,    wl2,    comp_l,    misc_l,    u_sub,    assoc_sub,    lwf,    fl,    sec_l,    cons_l,    mcdrf,    levy,    o_ded,    nps,    sl,    trust_l,    trust_int,    esi_ee,    esi_er,    l_ins,    add_cash_all,    add_f_all,    add_upcntry_all,    bosh_all,    can_all,    cycle_all,    hardship_all,    home_travel,    lumsum_all,    lumsum_all_pilot,    spl_area_all,       upcntry_all,    veh_maint,    wash_all,    fpp,    cca_metro,    conveyance,    paradip_port_all,    proj_area_all,    travel_halting_all,    total_payable,    total_deduct,    net_pay FROM arrear_view;");

			while (employees.next()) {
				employeeList.add(new Employee(
						 employees.getString("id"), 
						 employees.getString("ec"), 
						   employees.getString("ename"), 
						   employees.getString("cat"), 
						   employees.getString("role"), 
						   employees.getString("dob"), 
						   employees.getString("doj"), 
						   employees.getString("dop"), 
						   employees.getString("paexp"), 
						   employees.getString("loc"), 
						   employees.getString("dept"), 
						   employees.getString("bcode"), 
						   employees.getString("gen"), 
						   employees.getString("account_no"), 
						   employees.getString("pan"), 
						   employees.getString("aadhaar"), 
						   employees.getString("email"), 
						   employees.getString("mobile"), 
						   employees.getString("manager"), 
						   employees.getString("ph_conv"), 
						   employees.getString("sub_all"), 
						   employees.getString("age"), 
						   employees.getString("texp"), 
						   employees.getString("pexp"), 
						   employees.getString("city_type"), 
						   employees.getString("bpay"), 
						   employees.getString("da"), 
						   employees.getString("house_cl_all"), 
						   employees.getString("spl_all"), 
						   employees.getString("pf"), 
						   employees.getString("vpf"), 
						   employees.getString("hac"), 
						   employees.getString("hra"), 
						   employees.getString("pqp"), 
						   employees.getString("holiday_working"), 
						   employees.getString("deputa_all"), 
						   employees.getString("sd_all"), 
						   employees.getString("transfer"), 
						   employees.getString("transport"), 
						   employees.getString("shifting_all"), 
						   employees.getString("off_pay"), 
						   employees.getString("lunch_1"), 
						   employees.getString("lunch_2"), 
						   employees.getString("road_trvl_all"), 
						   employees.getString("mid_aca_trsfr_all"), 
						   employees.getString("award_grad_ss"), 
						   employees.getString("fa_lop"), 
						 
						   employees.getString("c_tr"), 
						   employees.getString("med_aid"), 
						   employees.getString("health_checkup"), 
						   employees.getString("merit_award"), 
						   employees.getString("briefcase"), 
						   employees.getString("np_all"), 
						   employees.getString("edu_exp"), 
						   employees.getString("pli"), 
						   employees.getString("c_fee"), 
						   employees.getString("s_ss"), 
						   employees.getString("s_fee"), 
						   employees.getString("s_hon"), 
						   employees.getString("d_hon"), 
						   employees.getString("mba_hon"), 
						   employees.getString("hon_uy_s"), 
						   employees.getString("hon_uy_n"), 
						   employees.getString("hon_uy_i"), 
						   employees.getString("pt"), 
						   employees.getString("it"), 
						   employees.getString("qtrs"), 
						   employees.getString("lic"), 
						   employees.getString("lic_js"), 
						   employees.getString("society"), 
						   employees.getString("h_sch"), 
						   employees.getString("hl"), 
						   employees.getString("hli"), 
						   employees.getString("hl2"), 
						   employees.getString("hli2"), 
						   employees.getString("payroll"), 
						   employees.getString("gl"), 
						   employees.getString("pfl"), 
						   employees.getString("fest_adv"), 
						   employees.getString("wl4"), 
						   employees.getString("wl2"), 
						   employees.getString("comp_l"), 
						   employees.getString("misc_l"), 
						   employees.getString("u_sub"), 
						   employees.getString("assoc_sub"), 
						   employees.getString("lwf"), 
						   employees.getString("fl"), 
						   employees.getString("sec_l"), 
						   employees.getString("cons_l"), 
						   employees.getString("mcdrf"), 
						   employees.getString("levy"), 
						   employees.getString("o_ded"), 
						   employees.getString("nps"), 
						   employees.getString("sl"), 
						   employees.getString("trust_l"), 
						   employees.getString("trust_int"), 
						   employees.getString("esi_ee"), 
						   employees.getString("esi_er"), 
						   employees.getString("l_ins"), 
						   employees.getString("add_cash_all"), 
						   employees.getString("add_f_all"), 
						   employees.getString("add_upcntry_all"), 
						   employees.getString("bosh_all"), 
						   employees.getString("can_all"), 
						   employees.getString("cycle_all"), 
						   employees.getString("hardship_all"), 
						   employees.getString("home_travel"), 
						   employees.getString("lumsum_all"), 
						   employees.getString("lumsum_all_pilot"), 
						   employees.getString("spl_area_all"), 

						   employees.getString("upcntry_all"), 
						   employees.getString("veh_maint"), 
						   employees.getString("wash_all"), 
						   employees.getString("fpp"), 
						   employees.getString("cca_metro"), 
						   employees.getString("conveyance"), 
						   employees.getString("paradip_port_all"), 
						   employees.getString("proj_area_all"), 
						   employees.getString("travel_halting_all"), 
						   employees.getString("total_payable"), 
						   employees.getString("total_deduct"), 
						   employees.getString("net_pay")
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}
	@RequestMapping(value = "/getEmpvar", method = RequestMethod.POST)
	public @ResponseBody
    List<Employee> getEmpvar() throws ClassNotFoundException {
		List<Employee> employeeList = new ArrayList<Employee>();

		try {

			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(
					driverUrl, userName, password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet employees = getFromDb
					.executeQuery("SELECT id,  ec,    ename,    cat,    role,   dob,    doj,     dop,    paexp,    loc,    dept,    bcode,    gen,    account_no,    pan,    aadhaar,    email,    mobile,    manager,    ph_conv,    sub_all,    age,    texp,    pexp,    City_type,    BPay,    DA,    House_Cl_All,    Spl_All,    PF,    VPF,    hac,    hra,    pqp,    holiday_working,    deputa_all,    sd_all,    transfer,    transport,    shifting_all,    off_pay,    lunch_1,    lunch_2,    road_trvl_all,    mid_aca_trsfr_all,    award_grad_ss,    fa_lop,     c_tr,    med_aid,    health_checkup,    merit_award,    briefcase,    np_all,    edu_exp,    pli,    c_fee,    s_ss,    s_fee,    s_hon,    d_hon,    mba_hon,    hon_uy_s,    hon_uy_n,    hon_uy_i,    pt,    it,    qtrs,    lic,    lic_js,    society,    h_sch,    hl,    hli,    hl2,    hli2,    payroll,    gl,    pfl,    fest_adv,    wl4,    wl2,    comp_l,    misc_l,    u_sub,    assoc_sub,    lwf,    fl,    sec_l,    cons_l,    mcdrf,    levy,    o_ded,    nps,    sl,    trust_l,    trust_int,    esi_ee,    esi_er,    l_ins,    add_cash_all,    add_f_all,    add_upcntry_all,    bosh_all,    can_all,    cycle_all,    hardship_all,    home_travel,    lumsum_all,    lumsum_all_pilot,    spl_area_all,       upcntry_all,    veh_maint,    wash_all,    fpp,    cca_metro,    conveyance,    paradip_port_all,    proj_area_all,    travel_halting_all,    total_payable,    total_deduct,    net_pay FROM variance_view;");

			while (employees.next()) {
				employeeList.add(new Employee(
						 employees.getString("id"), 
						 employees.getString("ec"), 
						   employees.getString("ename"), 
						   employees.getString("cat"), 
						   employees.getString("role"), 
						   employees.getString("dob"), 
						   employees.getString("doj"), 
						   employees.getString("dop"), 
						   employees.getString("paexp"), 
						   employees.getString("loc"), 
						   employees.getString("dept"), 
						   employees.getString("bcode"), 
						   employees.getString("gen"), 
						   employees.getString("account_no"), 
						   employees.getString("pan"), 
						   employees.getString("aadhaar"), 
						   employees.getString("email"), 
						   employees.getString("mobile"), 
						   employees.getString("manager"), 
						   employees.getString("ph_conv"), 
						   employees.getString("sub_all"), 
						   employees.getString("age"), 
						   employees.getString("texp"), 
						   employees.getString("pexp"), 
						   employees.getString("city_type"), 
						   employees.getString("bpay"), 
						   employees.getString("da"), 
						   employees.getString("house_cl_all"), 
						   employees.getString("spl_all"), 
						   employees.getString("pf"), 
						   employees.getString("vpf"), 
						   employees.getString("hac"), 
						   employees.getString("hra"), 
						   employees.getString("pqp"), 
						   employees.getString("holiday_working"), 
						   employees.getString("deputa_all"), 
						   employees.getString("sd_all"), 
						   employees.getString("transfer"), 
						   employees.getString("transport"), 
						   employees.getString("shifting_all"), 
						   employees.getString("off_pay"), 
						   employees.getString("lunch_1"), 
						   employees.getString("lunch_2"), 
						   employees.getString("road_trvl_all"), 
						   employees.getString("mid_aca_trsfr_all"), 
						   employees.getString("award_grad_ss"), 
						   employees.getString("fa_lop"), 
						 
						   employees.getString("c_tr"), 
						   employees.getString("med_aid"), 
						   employees.getString("health_checkup"), 
						   employees.getString("merit_award"), 
						   employees.getString("briefcase"), 
						   employees.getString("np_all"), 
						   employees.getString("edu_exp"), 
						   employees.getString("pli"), 
						   employees.getString("c_fee"), 
						   employees.getString("s_ss"), 
						   employees.getString("s_fee"), 
						   employees.getString("s_hon"), 
						   employees.getString("d_hon"), 
						   employees.getString("mba_hon"), 
						   employees.getString("hon_uy_s"), 
						   employees.getString("hon_uy_n"), 
						   employees.getString("hon_uy_i"), 
						   employees.getString("pt"), 
						   employees.getString("it"), 
						   employees.getString("qtrs"), 
						   employees.getString("lic"), 
						   employees.getString("lic_js"), 
						   employees.getString("society"), 
						   employees.getString("h_sch"), 
						   employees.getString("hl"), 
						   employees.getString("hli"), 
						   employees.getString("hl2"), 
						   employees.getString("hli2"), 
						   employees.getString("payroll"), 
						   employees.getString("gl"), 
						   employees.getString("pfl"), 
						   employees.getString("fest_adv"), 
						   employees.getString("wl4"), 
						   employees.getString("wl2"), 
						   employees.getString("comp_l"), 
						   employees.getString("misc_l"), 
						   employees.getString("u_sub"), 
						   employees.getString("assoc_sub"), 
						   employees.getString("lwf"), 
						   employees.getString("fl"), 
						   employees.getString("sec_l"), 
						   employees.getString("cons_l"), 
						   employees.getString("mcdrf"), 
						   employees.getString("levy"), 
						   employees.getString("o_ded"), 
						   employees.getString("nps"), 
						   employees.getString("sl"), 
						   employees.getString("trust_l"), 
						   employees.getString("trust_int"), 
						   employees.getString("esi_ee"), 
						   employees.getString("esi_er"), 
						   employees.getString("l_ins"), 
						   employees.getString("add_cash_all"), 
						   employees.getString("add_f_all"), 
						   employees.getString("add_upcntry_all"), 
						   employees.getString("bosh_all"), 
						   employees.getString("can_all"), 
						   employees.getString("cycle_all"), 
						   employees.getString("hardship_all"), 
						   employees.getString("home_travel"), 
						   employees.getString("lumsum_all"), 
						   employees.getString("lumsum_all_pilot"), 
						   employees.getString("spl_area_all"), 

						   employees.getString("upcntry_all"), 
						   employees.getString("veh_maint"), 
						   employees.getString("wash_all"), 
						   employees.getString("fpp"), 
						   employees.getString("cca_metro"), 
						   employees.getString("conveyance"), 
						   employees.getString("paradip_port_all"), 
						   employees.getString("proj_area_all"), 
						   employees.getString("travel_halting_all"), 
						   employees.getString("total_payable"), 
						   employees.getString("total_deduct"), 
						   employees.getString("net_pay")
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return employeeList;
	}
	@RequestMapping(value = "/getMyarr", method = RequestMethod.POST)
	public @ResponseBody
    List<Employee> getMyarr() throws ClassNotFoundException {
		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(driverUrl, userName, password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet employees = getFromDb
					.executeQuery("SELECT id, ec,    ename,    cat,    role,   dob,    doj,     dop,    paexp,    loc,    dept,    bcode,    gen,    account_no,    pan,    aadhaar,    email,    mobile,    manager,    ph_conv,    sub_all,    age,    texp,    pexp,    City_type,    BPay,    DA,    House_Cl_All,    Spl_All,    PF,    VPF,    hac,    hra,    pqp,    holiday_working,    deputa_all,    sd_all,    transfer,    transport,    shifting_all,    off_pay,    lunch_1,    lunch_2,    road_trvl_all,    mid_aca_trsfr_all,    award_grad_ss,    fa_lop,     c_tr,    med_aid,    health_checkup,    merit_award,    briefcase,    np_all,    edu_exp,    pli,    c_fee,    s_ss,    s_fee,    s_hon,    d_hon,    mba_hon,    hon_uy_s,    hon_uy_n,    hon_uy_i,    pt,    it,    qtrs,    lic,    lic_js,    society,    h_sch,    hl,    hli,    hl2,    hli2,    payroll,    gl,    pfl,    fest_adv,    wl4,    wl2,    comp_l,    misc_l,    u_sub,    assoc_sub,    lwf,    fl,    sec_l,    cons_l,    mcdrf,    levy,    o_ded,    nps,    sl,    trust_l,    trust_int,    esi_ee,    esi_er,    l_ins,    add_cash_all,    add_f_all,    add_upcntry_all,    bosh_all,    can_all,    cycle_all,    hardship_all,    home_travel,    lumsum_all,    lumsum_all_pilot,    spl_area_all,       upcntry_all,    veh_maint,    wash_all,    fpp,    cca_metro,    conveyance,    paradip_port_all,    proj_area_all,    travel_halting_all,    total_payable,    total_deduct,    net_pay FROM arrear_view where ec=1000138;");

			while (employees.next()) {
				employeeList.add(new Employee(
						 employees.getString("id"), 
						 employees.getString("ec"), 
						   employees.getString("ename"), 
						   employees.getString("cat"), 
						   employees.getString("role"), 
						   employees.getString("dob"), 
						   employees.getString("doj"), 
						   employees.getString("dop"), 
						   employees.getString("paexp"), 
						   employees.getString("loc"), 
						   employees.getString("dept"), 
						   employees.getString("bcode"), 
						   employees.getString("gen"), 
						   employees.getString("account_no"), 
						   employees.getString("pan"), 
						   employees.getString("aadhaar"), 
						   employees.getString("email"), 
						   employees.getString("mobile"), 
						   employees.getString("manager"), 
						   employees.getString("ph_conv"), 
						   employees.getString("sub_all"), 
						   employees.getString("age"), 
						   employees.getString("texp"), 
						   employees.getString("pexp"), 
						   employees.getString("city_type"), 
						   employees.getString("bpay"), 
						   employees.getString("da"), 
						   employees.getString("house_cl_all"), 
						   employees.getString("spl_all"), 
						   employees.getString("pf"), 
						   employees.getString("vpf"), 
						   employees.getString("hac"), 
						   employees.getString("hra"), 
						   employees.getString("pqp"), 
						   employees.getString("holiday_working"), 
						   employees.getString("deputa_all"), 
						   employees.getString("sd_all"), 
						   employees.getString("transfer"), 
						   employees.getString("transport"), 
						   employees.getString("shifting_all"), 
						   employees.getString("off_pay"), 
						   employees.getString("lunch_1"), 
						   employees.getString("lunch_2"), 
						   employees.getString("road_trvl_all"), 
						   employees.getString("mid_aca_trsfr_all"), 
						   employees.getString("award_grad_ss"), 
						   employees.getString("fa_lop"), 
						 
						   employees.getString("c_tr"), 
						   employees.getString("med_aid"), 
						   employees.getString("health_checkup"), 
						   employees.getString("merit_award"), 
						   employees.getString("briefcase"), 
						   employees.getString("np_all"), 
						   employees.getString("edu_exp"), 
						   employees.getString("pli"), 
						   employees.getString("c_fee"), 
						   employees.getString("s_ss"), 
						   employees.getString("s_fee"), 
						   employees.getString("s_hon"), 
						   employees.getString("d_hon"), 
						   employees.getString("mba_hon"), 
						   employees.getString("hon_uy_s"), 
						   employees.getString("hon_uy_n"), 
						   employees.getString("hon_uy_i"), 
						   employees.getString("pt"), 
						   employees.getString("it"), 
						   employees.getString("qtrs"), 
						   employees.getString("lic"), 
						   employees.getString("lic_js"), 
						   employees.getString("society"), 
						   employees.getString("h_sch"), 
						   employees.getString("hl"), 
						   employees.getString("hli"), 
						   employees.getString("hl2"), 
						   employees.getString("hli2"), 
						   employees.getString("payroll"), 
						   employees.getString("gl"), 
						   employees.getString("pfl"), 
						   employees.getString("fest_adv"), 
						   employees.getString("wl4"), 
						   employees.getString("wl2"), 
						   employees.getString("comp_l"), 
						   employees.getString("misc_l"), 
						   employees.getString("u_sub"), 
						   employees.getString("assoc_sub"), 
						   employees.getString("lwf"), 
						   employees.getString("fl"), 
						   employees.getString("sec_l"), 
						   employees.getString("cons_l"), 
						   employees.getString("mcdrf"), 
						   employees.getString("levy"), 
						   employees.getString("o_ded"), 
						   employees.getString("nps"), 
						   employees.getString("sl"), 
						   employees.getString("trust_l"), 
						   employees.getString("trust_int"), 
						   employees.getString("esi_ee"), 
						   employees.getString("esi_er"), 
						   employees.getString("l_ins"), 
						   employees.getString("add_cash_all"), 
						   employees.getString("add_f_all"), 
						   employees.getString("add_upcntry_all"), 
						   employees.getString("bosh_all"), 
						   employees.getString("can_all"), 
						   employees.getString("cycle_all"), 
						   employees.getString("hardship_all"), 
						   employees.getString("home_travel"), 
						   employees.getString("lumsum_all"), 
						   employees.getString("lumsum_all_pilot"), 
						   employees.getString("spl_area_all"), 

						   employees.getString("upcntry_all"), 
						   employees.getString("veh_maint"), 
						   employees.getString("wash_all"), 
						   employees.getString("fpp"), 
						   employees.getString("cca_metro"), 
						   employees.getString("conveyance"), 
						   employees.getString("paradip_port_all"), 
						   employees.getString("proj_area_all"), 
						   employees.getString("travel_halting_all"), 
						   employees.getString("total_payable"), 
						   employees.getString("total_deduct"), 
						   employees.getString("net_pay")
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return employeeList;
	}
	@RequestMapping(value = "/getMyvar", method = RequestMethod.POST)
	public @ResponseBody
    List<Employee> getMyvar() throws ClassNotFoundException {
		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(
					driverUrl, userName, password);

			Statement getFromDb = dbConnection.createStatement();
			ResultSet employees = getFromDb
					.executeQuery("SELECT id, ec,    ename,    cat,    role,   dob,    doj,     dop,    paexp,    loc,    dept,    bcode,    gen,    account_no,    pan,    aadhaar,    email,    mobile,    manager,    ph_conv,    sub_all,    age,    texp,    pexp,    City_type,    BPay,    DA,    House_Cl_All,    Spl_All,    PF,    VPF,    hac,    hra,    pqp,    holiday_working,    deputa_all,    sd_all,    transfer,    transport,    shifting_all,    off_pay,    lunch_1,    lunch_2,    road_trvl_all,    mid_aca_trsfr_all,    award_grad_ss,    fa_lop,     c_tr,    med_aid,    health_checkup,    merit_award,    briefcase,    np_all,    edu_exp,    pli,    c_fee,    s_ss,    s_fee,    s_hon,    d_hon,    mba_hon,    hon_uy_s,    hon_uy_n,    hon_uy_i,    pt,    it,    qtrs,    lic,    lic_js,    society,    h_sch,    hl,    hli,    hl2,    hli2,    payroll,    gl,    pfl,    fest_adv,    wl4,    wl2,    comp_l,    misc_l,    u_sub,    assoc_sub,    lwf,    fl,    sec_l,    cons_l,    mcdrf,    levy,    o_ded,    nps,    sl,    trust_l,    trust_int,    esi_ee,    esi_er,    l_ins,    add_cash_all,    add_f_all,    add_upcntry_all,    bosh_all,    can_all,    cycle_all,    hardship_all,    home_travel,    lumsum_all,    lumsum_all_pilot,    spl_area_all,       upcntry_all,    veh_maint,    wash_all,    fpp,    cca_metro,    conveyance,    paradip_port_all,    proj_area_all,    travel_halting_all,    total_payable,    total_deduct,    net_pay FROM variance_view where ec = 1000138;");

			while (employees.next()) {
				employeeList.add(new Employee(
						 employees.getString("id"), 				
						 employees.getString("ec"), 
						   employees.getString("ename"), 
						   employees.getString("cat"), 
						   employees.getString("role"), 
						   employees.getString("dob"), 
						   employees.getString("doj"), 
						   employees.getString("dop"), 
						   employees.getString("paexp"), 
						   employees.getString("loc"), 
						   employees.getString("dept"), 
						   employees.getString("bcode"), 
						   employees.getString("gen"), 
						   employees.getString("account_no"), 
						   employees.getString("pan"), 
						   employees.getString("aadhaar"), 
						   employees.getString("email"), 
						   employees.getString("mobile"), 
						   employees.getString("manager"), 
						   employees.getString("ph_conv"), 
						   employees.getString("sub_all"), 
						   employees.getString("age"), 
						   employees.getString("texp"), 
						   employees.getString("pexp"), 
						   employees.getString("city_type"), 
						   employees.getString("bpay"), 
						   employees.getString("da"), 
						   employees.getString("house_cl_all"), 
						   employees.getString("spl_all"), 
						   employees.getString("pf"), 
						   employees.getString("vpf"), 
						   employees.getString("hac"), 
						   employees.getString("hra"), 
						   employees.getString("pqp"), 
						   employees.getString("holiday_working"), 
						   employees.getString("deputa_all"), 
						   employees.getString("sd_all"), 
						   employees.getString("transfer"), 
						   employees.getString("transport"), 
						   employees.getString("shifting_all"), 
						   employees.getString("off_pay"), 
						   employees.getString("lunch_1"), 
						   employees.getString("lunch_2"), 
						   employees.getString("road_trvl_all"), 
						   employees.getString("mid_aca_trsfr_all"), 
						   employees.getString("award_grad_ss"), 
						   employees.getString("fa_lop"), 
						 
						   employees.getString("c_tr"), 
						   employees.getString("med_aid"), 
						   employees.getString("health_checkup"), 
						   employees.getString("merit_award"), 
						   employees.getString("briefcase"), 
						   employees.getString("np_all"), 
						   employees.getString("edu_exp"), 
						   employees.getString("pli"), 
						   employees.getString("c_fee"), 
						   employees.getString("s_ss"), 
						   employees.getString("s_fee"), 
						   employees.getString("s_hon"), 
						   employees.getString("d_hon"), 
						   employees.getString("mba_hon"), 
						   employees.getString("hon_uy_s"), 
						   employees.getString("hon_uy_n"), 
						   employees.getString("hon_uy_i"), 
						   employees.getString("pt"), 
						   employees.getString("it"), 
						   employees.getString("qtrs"), 
						   employees.getString("lic"), 
						   employees.getString("lic_js"), 
						   employees.getString("society"), 
						   employees.getString("h_sch"), 
						   employees.getString("hl"), 
						   employees.getString("hli"), 
						   employees.getString("hl2"), 
						   employees.getString("hli2"), 
						   employees.getString("payroll"), 
						   employees.getString("gl"), 
						   employees.getString("pfl"), 
						   employees.getString("fest_adv"), 
						   employees.getString("wl4"), 
						   employees.getString("wl2"), 
						   employees.getString("comp_l"), 
						   employees.getString("misc_l"), 
						   employees.getString("u_sub"), 
						   employees.getString("assoc_sub"), 
						   employees.getString("lwf"), 
						   employees.getString("fl"), 
						   employees.getString("sec_l"), 
						   employees.getString("cons_l"), 
						   employees.getString("mcdrf"), 
						   employees.getString("levy"), 
						   employees.getString("o_ded"), 
						   employees.getString("nps"), 
						   employees.getString("sl"), 
						   employees.getString("trust_l"), 
						   employees.getString("trust_int"), 
						   employees.getString("esi_ee"), 
						   employees.getString("esi_er"), 
						   employees.getString("l_ins"), 
						   employees.getString("add_cash_all"), 
						   employees.getString("add_f_all"), 
						   employees.getString("add_upcntry_all"), 
						   employees.getString("bosh_all"), 
						   employees.getString("can_all"), 
						   employees.getString("cycle_all"), 
						   employees.getString("hardship_all"), 
						   employees.getString("home_travel"), 
						   employees.getString("lumsum_all"), 
						   employees.getString("lumsum_all_pilot"), 
						   employees.getString("spl_area_all"), 

						   employees.getString("upcntry_all"), 
						   employees.getString("veh_maint"), 
						   employees.getString("wash_all"), 
						   employees.getString("fpp"), 
						   employees.getString("cca_metro"), 
						   employees.getString("conveyance"), 
						   employees.getString("paradip_port_all"), 
						   employees.getString("proj_area_all"), 
						   employees.getString("travel_halting_all"), 
						   employees.getString("total_payable"), 
						   employees.getString("total_deduct"), 
						   employees.getString("net_pay")
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}
	@RequestMapping(value = "/getMy10", method = RequestMethod.POST)
	public @ResponseBody
    List<Employee> getMy10() throws ClassNotFoundException {
		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection dbConnection = DriverManager.getConnection(
					driverUrl, userName, password);
			Statement getFromDb = dbConnection.createStatement();
			ResultSet employees = getFromDb
					.executeQuery("SELECT id, ec,    ename,    cat,    role,    dob,    doj,    dop,    paexp,    loc,    dept,    bcode,    gen,    account_no,    pan,    aadhaar,    email,    mobile,    manager,    ph_conv,    sub_all,    age,    texp,    pexp,    City_type,    BPay,    DA,    House_Cl_All,    Spl_All,    PF,    VPF,    hac,    hra,    pqp,    holiday_working,    deputa_all,    sd_all,    transfer,    transport,    shifting_all,    off_pay,    lunch_1,    lunch_2,    road_trvl_all,    mid_aca_trsfr_all,    award_grad_ss,    fa_lop,     c_tr,    med_aid,    health_checkup,    merit_award,    briefcase,    np_all,    edu_exp,    pli,    c_fee,    s_ss,    s_fee,    s_hon,    d_hon,    mba_hon,    hon_uy_s,    hon_uy_n,    hon_uy_i,    pt,    it,    qtrs,    lic,    lic_js,    society,    h_sch,    hl,    hli,    hl2,    hli2,    payroll,    gl,    pfl,    fest_adv,    wl4,    wl2,    comp_l,    misc_l,    u_sub,    assoc_sub,    lwf,    fl,    sec_l,    cons_l,    mcdrf,    levy,    o_ded,    nps,    sl,    trust_l,    trust_int,    esi_ee,    esi_er,    l_ins,    add_cash_all,    add_f_all,    add_upcntry_all,    bosh_all,    can_all,    cycle_all,    hardship_all,    home_travel,    lumsum_all,    lumsum_all_pilot,    spl_area_all,        upcntry_all,    veh_maint,    wash_all,    fpp,    cca_metro,    conveyance,    paradip_port_all,    proj_area_all,    travel_halting_all,    total_payable,    total_deduct,    net_pay FROM salary10 where ec = 1000138;");
			while (employees.next()) {
				employeeList.add(new Employee(
						 employees.getString("id"), 
						 employees.getString("ec"), 
						   employees.getString("ename"), 
						   employees.getString("cat"), 
						   employees.getString("role"), 
						   employees.getString("dob"), 
						   employees.getString("doj"), 
						   employees.getString("dop"), 
						   employees.getString("paexp"), 
						   employees.getString("loc"), 
						   employees.getString("dept"), 
						   employees.getString("bcode"), 
						   employees.getString("gen"), 
						   employees.getString("account_no"), 
						   employees.getString("pan"), 
						   employees.getString("aadhaar"), 
						   employees.getString("email"), 
						   employees.getString("mobile"), 
						   employees.getString("manager"), 
						   employees.getString("ph_conv"), 
						   employees.getString("sub_all"), 
						   employees.getString("age"), 
						   employees.getString("texp"), 
						   employees.getString("pexp"), 
						   employees.getString("city_type"), 
						   employees.getString("bpay"), 
						   employees.getString("da"), 
						   employees.getString("house_cl_all"), 
						   employees.getString("spl_all"), 
						   employees.getString("pf"), 
						   employees.getString("vpf"), 
						   employees.getString("hac"), 
						   employees.getString("hra"), 
						   employees.getString("pqp"), 
						   employees.getString("holiday_working"), 
						   employees.getString("deputa_all"), 
						   employees.getString("sd_all"), 
						   employees.getString("transfer"), 
						   employees.getString("transport"), 
						   employees.getString("shifting_all"), 
						   employees.getString("off_pay"), 
						   employees.getString("lunch_1"), 
						   employees.getString("lunch_2"), 
						   employees.getString("road_trvl_all"), 
						   employees.getString("mid_aca_trsfr_all"), 
						   employees.getString("award_grad_ss"), 
						   employees.getString("fa_lop"), 
						  
						   employees.getString("c_tr"), 
						   employees.getString("med_aid"), 
						   employees.getString("health_checkup"), 
						   employees.getString("merit_award"), 
						   employees.getString("briefcase"), 
						   employees.getString("np_all"), 
						   employees.getString("edu_exp"), 
						   employees.getString("pli"), 
						   employees.getString("c_fee"), 
						   employees.getString("s_ss"), 
						   employees.getString("s_fee"), 
						   employees.getString("s_hon"), 
						   employees.getString("d_hon"), 
						   employees.getString("mba_hon"), 
						   employees.getString("hon_uy_s"), 
						   employees.getString("hon_uy_n"), 
						   employees.getString("hon_uy_i"), 
						   employees.getString("pt"), 
						   employees.getString("it"), 
						   employees.getString("qtrs"), 
						   employees.getString("lic"), 
						   employees.getString("lic_js"), 
						   employees.getString("society"), 
						   employees.getString("h_sch"), 
						   employees.getString("hl"), 
						   employees.getString("hli"), 
						   employees.getString("hl2"), 
						   employees.getString("hli2"), 
						   employees.getString("payroll"), 
						   employees.getString("gl"), 
						   employees.getString("pfl"), 
						   employees.getString("fest_adv"), 
						   employees.getString("wl4"), 
						   employees.getString("wl2"), 
						   employees.getString("comp_l"), 
						   employees.getString("misc_l"), 
						   employees.getString("u_sub"), 
						   employees.getString("assoc_sub"), 
						   employees.getString("lwf"), 
						   employees.getString("fl"), 
						   employees.getString("sec_l"), 
						   employees.getString("cons_l"), 
						   employees.getString("mcdrf"), 
						   employees.getString("levy"), 
						   employees.getString("o_ded"), 
						   employees.getString("nps"), 
						   employees.getString("sl"), 
						   employees.getString("trust_l"), 
						   employees.getString("trust_int"), 
						   employees.getString("esi_ee"), 
						   employees.getString("esi_er"), 
						   employees.getString("l_ins"), 
						   employees.getString("add_cash_all"), 
						   employees.getString("add_f_all"), 
						   employees.getString("add_upcntry_all"), 
						   employees.getString("bosh_all"), 
						   employees.getString("can_all"), 
						   employees.getString("cycle_all"), 
						   employees.getString("hardship_all"), 
						   employees.getString("home_travel"), 
						   employees.getString("lumsum_all"), 
						   employees.getString("lumsum_all_pilot"), 
						   employees.getString("spl_area_all"), 
						   employees.getString("upcntry_all"), 
						   employees.getString("veh_maint"), 
						   employees.getString("wash_all"), 
						   employees.getString("fpp"), 
						   employees.getString("cca_metro"), 
						   employees.getString("conveyance"), 
						   employees.getString("paradip_port_all"), 
						   employees.getString("proj_area_all"), 
						   employees.getString("travel_halting_all"), 
						   employees.getString("total_payable"), 
						   employees.getString("total_deduct"), 
						   employees.getString("net_pay")
                                ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return employeeList;
	}

@RequestMapping(value = "/getPayslip", method = RequestMethod.POST)
public @ResponseBody
List<Employee> getMy11() throws ClassNotFoundException {
	List<Employee> employeeList = new ArrayList<Employee>();

	try {
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection dbConnection = DriverManager.getConnection(
				driverUrl, userName, password);
		Statement getFromDb = dbConnection.createStatement();
		ResultSet employees = getFromDb
				.executeQuery("SELECT id, ec,    ename,    cat,    role,    dob,    doj,    dop,    paexp,    loc,    dept,    bcode,    gen,    account_no,    pan,    aadhaar,    email,    mobile,    manager,    ph_conv,    sub_all,    age,    texp,    pexp,    City_type,    BPay,    DA,    House_Cl_All,    Spl_All,    PF,    VPF,    hac,    hra,    pqp,    holiday_working,    deputa_all,    sd_all,    transfer,    transport,    shifting_all,    off_pay,    lunch_1,    lunch_2,    road_trvl_all,    mid_aca_trsfr_all,    award_grad_ss,    fa_lop,     c_tr,    med_aid,    health_checkup,    merit_award,    briefcase,    np_all,    edu_exp,    pli,    c_fee,    s_ss,    s_fee,    s_hon,    d_hon,    mba_hon,    hon_uy_s,    hon_uy_n,    hon_uy_i,    pt,    it,    qtrs,    lic,    lic_js,    society,    h_sch,    hl,    hli,    hl2,    hli2,    payroll,    gl,    pfl,    fest_adv,    wl4,    wl2,    comp_l,    misc_l,    u_sub,    assoc_sub,    lwf,    fl,    sec_l,    cons_l,    mcdrf,    levy,    o_ded,    nps,    sl,    trust_l,    trust_int,    esi_ee,    esi_er,    l_ins,    add_cash_all,    add_f_all,    add_upcntry_all,    bosh_all,    can_all,    cycle_all,    hardship_all,    home_travel,    lumsum_all,    lumsum_all_pilot,    spl_area_all,        upcntry_all,    veh_maint,    wash_all,    fpp,    cca_metro,    conveyance,    paradip_port_all,    proj_area_all,    travel_halting_all,    total_payable,    total_deduct,    net_pay FROM salary11 where ec = 1000138;");
		while (employees.next()) {
			employeeList.add(new Employee(
					 employees.getString("id"), 
					 employees.getString("ec"), 
					   employees.getString("ename"), 
					   employees.getString("cat"), 
					   employees.getString("role"), 
					   employees.getString("dob"), 
					   employees.getString("doj"), 
					   employees.getString("dop"), 
					   employees.getString("paexp"), 
					   employees.getString("loc"), 
					   employees.getString("dept"), 
					   employees.getString("bcode"), 
					   employees.getString("gen"), 
					   employees.getString("account_no"), 
					   employees.getString("pan"), 
					   employees.getString("aadhaar"), 
					   employees.getString("email"), 
					   employees.getString("mobile"), 
					   employees.getString("manager"), 
					   employees.getString("ph_conv"), 
					   employees.getString("sub_all"), 
					   employees.getString("age"), 
					   employees.getString("texp"), 
					   employees.getString("pexp"), 
					   employees.getString("city_type"), 
					   employees.getString("bpay"), 
					   employees.getString("da"), 
					   employees.getString("house_cl_all"), 
					   employees.getString("spl_all"), 
					   employees.getString("pf"), 
					   employees.getString("vpf"), 
					   employees.getString("hac"), 
					   employees.getString("hra"), 
					   employees.getString("pqp"), 
					   employees.getString("holiday_working"), 
					   employees.getString("deputa_all"), 
					   employees.getString("sd_all"), 
					   employees.getString("transfer"), 
					   employees.getString("transport"), 
					   employees.getString("shifting_all"), 
					   employees.getString("off_pay"), 
					   employees.getString("lunch_1"), 
					   employees.getString("lunch_2"), 
					   employees.getString("road_trvl_all"), 
					   employees.getString("mid_aca_trsfr_all"), 
					   employees.getString("award_grad_ss"), 
					   employees.getString("fa_lop"), 
					  
					   employees.getString("c_tr"), 
					   employees.getString("med_aid"), 
					   employees.getString("health_checkup"), 
					   employees.getString("merit_award"), 
					   employees.getString("briefcase"), 
					   employees.getString("np_all"), 
					   employees.getString("edu_exp"), 
					   employees.getString("pli"), 
					   employees.getString("c_fee"), 
					   employees.getString("s_ss"), 
					   employees.getString("s_fee"), 
					   employees.getString("s_hon"), 
					   employees.getString("d_hon"), 
					   employees.getString("mba_hon"), 
					   employees.getString("hon_uy_s"), 
					   employees.getString("hon_uy_n"), 
					   employees.getString("hon_uy_i"), 
					   employees.getString("pt"), 
					   employees.getString("it"), 
					   employees.getString("qtrs"), 
					   employees.getString("lic"), 
					   employees.getString("lic_js"), 
					   employees.getString("society"), 
					   employees.getString("h_sch"), 
					   employees.getString("hl"), 
					   employees.getString("hli"), 
					   employees.getString("hl2"), 
					   employees.getString("hli2"), 
					   employees.getString("payroll"), 
					   employees.getString("gl"), 
					   employees.getString("pfl"), 
					   employees.getString("fest_adv"), 
					   employees.getString("wl4"), 
					   employees.getString("wl2"), 
					   employees.getString("comp_l"), 
					   employees.getString("misc_l"), 
					   employees.getString("u_sub"), 
					   employees.getString("assoc_sub"), 
					   employees.getString("lwf"), 
					   employees.getString("fl"), 
					   employees.getString("sec_l"), 
					   employees.getString("cons_l"), 
					   employees.getString("mcdrf"), 
					   employees.getString("levy"), 
					   employees.getString("o_ded"), 
					   employees.getString("nps"), 
					   employees.getString("sl"), 
					   employees.getString("trust_l"), 
					   employees.getString("trust_int"), 
					   employees.getString("esi_ee"), 
					   employees.getString("esi_er"), 
					   employees.getString("l_ins"), 
					   employees.getString("add_cash_all"), 
					   employees.getString("add_f_all"), 
					   employees.getString("add_upcntry_all"), 
					   employees.getString("bosh_all"), 
					   employees.getString("can_all"), 
					   employees.getString("cycle_all"), 
					   employees.getString("hardship_all"), 
					   employees.getString("home_travel"), 
					   employees.getString("lumsum_all"), 
					   employees.getString("lumsum_all_pilot"), 
					   employees.getString("spl_area_all"), 
					   employees.getString("upcntry_all"), 
					   employees.getString("veh_maint"), 
					   employees.getString("wash_all"), 
					   employees.getString("fpp"), 
					   employees.getString("cca_metro"), 
					   employees.getString("conveyance"), 
					   employees.getString("paradip_port_all"), 
					   employees.getString("proj_area_all"), 
					   employees.getString("travel_halting_all"), 
					   employees.getString("total_payable"), 
					   employees.getString("total_deduct"), 
					   employees.getString("net_pay")
                            ));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return employeeList;
}
}
