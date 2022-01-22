<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />
    
    <title>Vetan</title>
    <link rel="stylesheet" href="../jqwidgets/styles/jqx.base.css" type="text/css" />
    <link rel="stylesheet" href="../jqwidgets/styles/jqx.arctic.css" type="text/css" />

	<script type="text/javascript" src="../scripts/jquery-1.12.4.min.js"></script>
         <%@include file="externalJsImports.jsp"%>
        
        
        <script type="text/javascript" src="../jqwidgets/jqxgrid.filter.js"></script>
        <script type="text/javascript" src="../jqwidgets/jqxgrid.grouping.js"></script>
        <script type="text/javascript" src="../jqwidgets/jqxgrid.columnsreorder.js"></script>
 		<script type="text/javascript" src="../jqwidgets/jqxgrid.aggregates.js"></script>
 		
      <script type="text/javascript">
     $(document).ready(function() {
            var source = {
                datatype: 'json',
                datafields: [

                    {name: 'ec', type: 'string'},
                        {name: 'ename', type: 'string'},
                        {name: 'cat', type: 'string'},
                        {name: 'role', type: 'string'},
                        {name: 'dob', type: 'string'},
                        {name: 'doj', type: 'string'},
                        {name: 'dop', type: 'string'},
                        {name: 'paexp', type: 'number'},
                        {name: 'loc', type: 'string'},
                        {name: 'dept', type: 'string'},
                        {name: 'bcode', type: 'string'},
                        {name: 'gen', type: 'string'},
                        {name: 'account_no', type: 'number'},
                        {name: 'pan', type: 'string'},
                        {name: 'aadhaar', type: 'string'},
                        {name: 'email', type: 'string'},
                        {name: 'mobile', type: 'number'},
                        {name: 'manager', type: 'string'},
                        //{name: 'ph_conv', type: 'number'},
                        {name: 'sub_all', type: 'number'},
                        {name: 'age', type: 'number'},
                        {name: 'texp', type: 'number'},
                        {name: 'pexp', type: 'number'},
                        {name: 'city_type', type: 'number'},
                        {name: 'bpay', type: 'number'},
                        {name: 'da', type: 'number'},
                      //{name: 'house_cl_all', type: 'number'},
                        {name: 'spl_all', type: 'number'},
                        {name: 'pf', type: 'number'},
                        {name: 'vpf', type: 'number'},
                        {name: 'hac', type: 'number'},
                        {name: 'hra', type: 'number'},
                        {name: 'pqp', type: 'number'},
                      //{name: 'holiday_working', type: 'number'},
                        {name: 'deputa_all', type: 'number'},
                        {name: 'sd_all', type: 'number'},
                        {name: 'transfer', type: 'number'},
                        {name: 'transport', type: 'number'},
                        {name: 'shifting_all', type: 'number'},
                        {name: 'off_pay', type: 'number'},
                      //{name: 'lunch_1', type: 'number'},
                      //{name: 'lunch_2', type: 'number'},
                        {name: 'road_trvl_all', type: 'number'},
                        {name: 'mid_aca_trsfr_all', type: 'number'},
                      //{name: 'award_grad_ss', type: 'number'},
                      //{name: 'fa_lop', type: 'number'},
                      
                        {name: 'c_tr', type: 'number'},
                        {name: 'med_aid', type: 'number'},
                        {name: 'health_checkup', type: 'number'},
                      //{name: 'merit_award', type: 'number'},
                        {name: 'briefcase', type: 'number'},
                        {name: 'np_all', type: 'number'},
                      //{name: 'edu_exp', type: 'number'},
                        {name: 'pli', type: 'number'},
                      //{name: 'c_fee', type: 'number'},
                        {name: 's_ss', type: 'number'},
                      //{name: 's_fee', type: 'number'},
                      //{name: 's_hon', type: 'number'},
                      //{name: 'd_hon', type: 'number'},
                      //{name: 'mba_hon', type: 'number'},
                      //{name: 'hon_uy_s', type: 'number'},
                      //{name: 'hon_uy_n', type: 'number'},
                      //{name: 'hon_uy_i', type: 'number'},
                        {name: 'pt', type: 'number'},
                        {name: 'it', type: 'number'},
                        {name: 'qtrs', type: 'number'},
                        {name: 'lic', type: 'number'},
                        {name: 'lic_js', type: 'number'},
                        {name: 'society', type: 'number'},
                        {name: 'h_sch', type: 'number'},
                        {name: 'hl', type: 'number'},
                        {name: 'hli', type: 'number'},
                        {name: 'hl2', type: 'number'},
                        {name: 'hli2', type: 'number'},
                        {name: 'payroll', type: 'number'},
                        {name: 'gl', type: 'number'},
                        {name: 'pfl', type: 'number'},
                        {name: 'fest_adv', type: 'number'},
                        {name: 'wl4', type: 'number'},
                        {name: 'wl2', type: 'number'},
                        {name: 'comp_l', type: 'number'},
                        {name: 'misc_l', type: 'number'},
                        {name: 'u_sub', type: 'number'},
                        {name: 'assoc_sub', type: 'number'},
                        {name: 'lwf', type: 'number'},
                        {name: 'fl', type: 'number'},
                        {name: 'sec_l', type: 'number'},
                        {name: 'cons_l', type: 'number'},
                        {name: 'mcdrf', type: 'number'},
                        {name: 'levy', type: 'number'},
                        {name: 'o_ded', type: 'number'},
                        {name: 'nps', type: 'number'},
                        {name: 'sl', type: 'number'},
                        {name: 'trust_l', type: 'number'},
                        {name: 'trust_int', type: 'number'},
                        {name: 'esi_ee', type: 'number'},
                        {name: 'esi_er', type: 'number'},
                        {name: 'l_ins', type: 'number'},
                      //{name: 'add_cash_all', type: 'number'},
                      //{name: 'add_f_all', type: 'number'},
                      //{name: 'add_upcntry_all', type: 'number'},
                      //{name: 'bosh_all', type: 'number'},
                      //{name: 'can_all', type: 'number'},
                        {name: 'cycle_all', type: 'number'},
                      //{name: 'hardship_all', type: 'number'},
                      //{name: 'home_travel', type: 'number'},
                      //{name: 'lumsum_all', type: 'number'},
                      //{name: 'lumsum_all_pilot', type: 'number'},
                        {name: 'spl_area_all', type: 'number'},
                     
                      //{name: 'upcntry_all', type: 'number'},
                     //{name: 'veh_maint', type: 'number'},
                        {name: 'wash_all', type: 'number'},
                        {name: 'fpp', type: 'number'},
                        {name: 'cca_metro', type: 'number'},
                        {name: 'conveyance', type: 'number'},
                      //{name: 'paradip_port_all', type: 'number'},
                        {name: 'proj_area_all', type: 'number'},
                        {name: 'travel_halting_all', type: 'number'},
                        {name: 'total_payable', type: 'number'},
                        {name: 'total_deduct', type: 'number'},
                        {name: 'net_pay', type: 'number'}

                   ],
                    id: 'id',
                    url: '${pageContext.request.contextPath}/grid/getMyarr',
                    type: 'POST',
                    async: true
                };
                var initrowdetails = function (index, parentElement, gridElement, datarecord) {
                    var tabsdiv  = null;
                    var information = null;
                    var notes = null;
                    var custom = null;
                    var frad= null;
                    var ded= null;
                    var pay= null;
                    var sal= null;
                    var inc= null;
                    tabsdiv  = $($(parentElement).children()[0]);

                if (tabsdiv  != null) {

                    information = tabsdiv .find('.information');
                    notes = tabsdiv .find('.notes');
                    custom = tabsdiv .find('.custom');
                    frad= tabsdiv .find('.frad');        
                    pay  = tabsdiv.find('.pay');
                    ded= tabsdiv .find('.ded');    
                    sal= tabsdiv .find('.sal');   
                    inc= tabsdiv .find('.inc'); 
                    // title.text(datarecord.CustomerName);
                    if (custom && custom.length > 0) {
                        // custom[0].innerHTML = "<div style='margin: 5px;'>" + datarecord.CustomerName + "</div>";
                        tabsdiv.css('margin-top', '20px');
                    }
                    var container = $('<div style="margin: 5px;"></div>')
                    container.appendTo($(information));    
                    var leftcolumn = $('<div style="float: left; width: 50%;"></div>');
                    var rightcolumn = $('<div style="float: left; width: 50%;"></div>');
                    container.append(leftcolumn);
                    
                    container.append(rightcolumn);
                    

                    var aadhaar = "<div style='margin: 10px;'><b>Aadhaar:</b> " + datarecord.aadhaar + "</div>";
                    
                    var age = "<div style='margin: 10px;'><b>Age:</b> " + datarecord.age + "</div>";
                    var account_no = "<div style='margin: 10px;'><b>Area:</b>" + datarecord.account_no + "</div>";
                    var city_type = "<div style='margin: 10px;'><b>City Type:</b> " + datarecord.city_type + "</div>";

                    var dob = "<div style='margin: 10px;'><b>Birth Date:</b> " + datarecord.dob + "</div>";
                    var doj = "<div style='margin: 10px;'><b>Joining Date:</b> " + datarecord.doj + "</div>";
     
                    $(leftcolumn).append(aadhaar);
                    $(leftcolumn).append(age);
                 
                    $(leftcolumn).append(city_type);
                    $(leftcolumn).append(dob);
                    $(leftcolumn).append(doj);


       
                    var dop = "<div style='margin: 10px;'><b>Promotion Date:</b> " + datarecord.dop + "</div>";

                    var email = "<div style='margin: 10px;'><b>Email Id:</b> " + datarecord.email + "</div>";
                    var pan = "<div style='margin: 10px;'><b>PAN:</b> " + datarecord.pan + "</div>";

                    var paexp = "<div style='margin: 10px;'><b>Past Exp:</b> " + datarecord.paexp + "</div>";
                    var texp = "<div style='margin: 10px;'><b> Present Exp:</b> " + datarecord.texp + "</div>";
                    var pexp = "<div style='margin: 10px;'><b> Promotion Exp:</b> " + datarecord.pexp + "</div>";
                     $(rightcolumn).append(dop);

                    $(rightcolumn).append(email);
                    $(rightcolumn).append(pan);
                    $(rightcolumn).append(paexp);
                    $(rightcolumn).append(texp);
                    $(rightcolumn).append(pexp);
                
                
                // Fixed Component 1 start
                    var container1 = $('<div style="margin: 5px;"></div>')
                    container1.appendTo($(notes));    
                    var leftcolumn1 = $('<div style="float: left; width: 25%;"></div>');
                    var Middlecolumn1 = $('<div style="float: left; width: 25%;"></div>');
                    var centercolumn1 = $('<div style="float: left; width: 25%;"></div>');
                    var rightcolumn1 = $('<div style="float: left; width: 25%;"></div>');
                    container1.append(leftcolumn1);
                    container1.append(Middlecolumn1);
                    container1.append(centercolumn1);
                    container1.append(rightcolumn1);
                   // var add_cash_all = "<div style='margin: 10px;'><b>Add Cash Allow: 0</b> </div>";
                   // var add_f_all = "<div style='margin: 10px;'><b>Add Fixed Allow:</b> " + datarecord.add_f_all + "</div>";
                   // var bosh_all = "<div style='margin: 10px;'><b>BOSH All:</b> " + datarecord.bosh_all + "</div>";
                   // var can_all = "<div style='margin: 10px;'><b>Canteen All:</b>" + datarecord.can_all + "</div>";
                    var cca_metro = "<div style='margin: 10px;'><b>CCA Metro:</b>" + datarecord.cca_metro + "</div>";
                    var conveyance = "<div style='margin: 10px;'><b>Conveyance:</b> " + datarecord.conveyance + "</div>";
                    var cycle_all = "<div style='margin: 10px;'><b>Cycle:</b> " + datarecord.lwf + "</div>";
                    var da = "<div style='margin: 10px;'><b>DA:</b>" + datarecord.da + "</div>";

            
                  //  $(leftcolumn1).append(add_cash_all);
                   // $(leftcolumn1).append(add_f_all);
                  //  $(leftcolumn1).append(bosh_all);
                  //  $(leftcolumn1).append(can_all);
                    $(leftcolumn1).append(cca_metro);
                    $(leftcolumn1).append(conveyance);
                    $(leftcolumn1).append(cycle_all);
                    $(leftcolumn1).append(da);


     
                   // var edu_exp = "<div style='margin: 10px;'><b>Edu. Exp.:</b> " + datarecord.edu_exp + "</div>";
                    var fpp = "<div style='margin: 10px;'><b>FPP:</b> " + datarecord.fpp + "</div>";
                    var hra = "<div style='margin: 10px;'><b>HRA:</b> " + datarecord.hra + "</div>";
                    var np_all = "<div style='margin: 10px;'><b>Newspaper All:</b>" + datarecord.np_all + "</div>";
                    var off_pay = "<div style='margin: 10px;'><b>Officiating Pay:</b> " + datarecord.off_pay + "</div>";


                    //var ph_conv = "<div style='margin: 10px;'><b>Handicap Conv:</b> " + datarecord.ph_conv + "</div>";
                  // var hardship_all = "<div style='margin: 10px;'><b>Hardship All:</b>" + datarecord.hardship_all + "</div>";
                 //  $(Middlecolumn1).append(edu_exp);
                    $(Middlecolumn1).append(fpp);
                    $(Middlecolumn1).append(hra);
                    $(Middlecolumn1).append(np_all);
                    $(Middlecolumn1).append(off_pay);

                    //$(Middlecolumn1).append(ph_conv);

                   // $(Middlecolumn1).append(hardship_all);
                    
                   // var home_travel = "<div style='margin: 10px;'><b>Home Travel:</b> " + datarecord.home_travel + "</div>";
                    //var house_cl_all = "<div style='margin: 10px;'><b>House Clean All:</b> " + datarecord.house_cl_all + "</div>";
                  //  var lumsum_all = "<div style='margin: 10px;'><b>Lumsum All:</b> " + datarecord.lumsum_all + "</div>";
                   // var lumsum_all_pilot = "<div style='margin: 10px;'><b>Lumsum Pilot:</b>" + datarecord.lumsum_all_pilot + "</div>";
                   // $(centercolumn1).append(home_travel);
                   // $(centercolumn1).append(house_cl_all);
                  //  $(centercolumn1).append(lumsum_all);
                  //  $(centercolumn1).append(lumsum_all_pilot);
                    
                    var pqp = "<div style='margin: 10px;'><b>PQP:</b> " + datarecord.pqp + "</div>";
                    var spl_all = "<div style='margin: 10px;'><b>Special All:</b> " + datarecord.spl_all + "</div>";
                    var sd_all = "<div style='margin: 10px;'><b>Splid Duty All:</b> " + datarecord.sd_all + "</div>";
                    //var veh_maint = "<div style='margin: 10px;'><b>Vehicle Maint:</b>" + datarecord.veh_maint + "</div>";
                    var wash_all = "<div style='margin: 10px;'><b>Washing Allow:</b>" + datarecord.wash_all + "</div>";
                    $(rightcolumn1).append(pqp);
                    $(rightcolumn1).append(spl_all);
                  //  $(rightcolumn1).append(home_travel);
                  //  $(rightcolumn1).append(house_cl_all);
                    $(rightcolumn1).append(wash_all);

                    // var notescontainer = $('<div style="white-space: normal; margin: 5px;"><span>' + datarecord.Reason + '</span></div>');
                    //     $(notes).append(notescontainer);
                // Trasaction End
                //  Fixed Component 2 start
                    var container2 = $('<div style="margin: 5px;"></div>')
                    container2.appendTo($(custom));    
                    var leftcolumn2 = $('<div style="float: left; width: 25%;"></div>');
                    var Middlecolumn2 = $('<div style="float: left; width: 25%;"></div>');
                    var centercolumn2 = $('<div style="float: left; width: 25%;"></div>');
                    var rightcolumn2 = $('<div style="float: left; width: 25%;"></div>');
                    container2.append(leftcolumn2);
                    container2.append(Middlecolumn2);
                    container2.append(centercolumn2);
                    container2.append(rightcolumn2);
                   // var add_upcntry_all = "<div style='margin: 10px;'><b>Addl Upcountry All:</b> " + datarecord.add_upcntry_all + "</div>";
                    var deputa_all = "<div style='margin: 10px;'><b>Deputation All:</b>" + datarecord.deputa_all + "</div>";
                    var hac = "<div style='margin: 10px;'><b>HAC:</b> " + datarecord.hac + "</div>";
                    var proj_area_all = "<div style='margin: 10px;'><b>Proj Area All:</b> " + datarecord.proj_area_all + "</div>";
                    var road_trvl_all = "<div style='margin: 10px;'><b>Road Travel All:</b> " + datarecord.road_trvl_all + "</div>";
                    //var holiday_working = "<div style='margin: 10px;'><b>Holiday Working:</b> " + datarecord.holiday_working + "</div>";
                 
                  //  $(leftcolumn2).append(add_upcntry_all);
                    $(leftcolumn2).append(deputa_all);
                    $(leftcolumn2).append(hac);
                    $(leftcolumn2).append(proj_area_all);
                    $(leftcolumn2).append(road_trvl_all);
                  //  $(leftcolumn2).append(holiday_working);
                   

                    
                   // var fa_lop = "<div style='margin: 10px;'><b>Special Allow:</b> " + datarecord.fa_lop + "</div>";
                  //  var lunch_1 = "<div style='margin: 10px;'><b>Lunch 1:</b> " + datarecord.lunch_1 + "</div>";
                   // var lunch_2 = "<div style='margin: 10px;'><b>Lunch 2:</b> " + datarecord.lunch_2 + "</div>";
                    //var paradip_port_all = "<div style='margin: 10px;'><b>Port All:</b> " + datarecord.paradip_port_all + "</div>";
                   // $(Middlecolumn2).append(fa_lop);
                   // $(Middlecolumn2).append(lunch_1);
                   // $(Middlecolumn2).append(lunch_2);
                    //$(Middlecolumn2).append(paradip_port_all);
                   
                    
                  
                    var spl_area_all = "<div style='margin: 10px;'><b>Spl Area All:</b> " + datarecord.spl_area_all + "</div>";
                    var sub_all = "<div style='margin: 10px;'><b>Subsistance All:</b> " + datarecord.sub_all + "</div>";
                    var travel_halting_all = "<div style='margin: 10px;'><b>TAHA:</b> " + datarecord.travel_halting_all + "</div>";
                    var transport = "<div style='margin: 10px;'><b>Transport:</b> " + datarecord.transport + "</div>";
                    $(centercolumn2).append(spl_area_all);
                    $(centercolumn2).append(sub_all);
                    $(centercolumn2).append(travel_halting_all);
                    $(centercolumn2).append(transport);
                  //  var upcntry_all = "<div style='margin: 10px;'><b>Upcountry All:</b> " + datarecord.upcntry_all + "</div>";
                   
                  //  $(rightcolumn2).append(upcntry_all);

                    // Alert end
                //  Fixed Component 3 start
                    var container3 = $('<div style="margin: 5px;"></div>')
                    container3.appendTo($(frad));    
                    var leftcolumn3  = $('<div style="float: left; width: 25%;"></div>');
                    var middlecolumn3 = $('<div style="float: left; width: 25%;"></div>');
                    var centercolumn3 = $('<div style="float: left; width: 25%;"></div>');
                    var rightcolumn3 = $('<div style="float: left; width: 25%;"></div>');
                    container3.append(leftcolumn3); 
                    container3.append(middlecolumn3);
                    container3.append(centercolumn3);
                    container3.append(rightcolumn3);
                    var briefcase = "<div style='margin: 10px;'><b>Briefcase:</b> " + datarecord.briefcase + "</div>";
                    var c_tr = "<div style='margin: 10px;'><b>C Transfer:</b> " + datarecord.c_tr + "</div>";
                    var health_checkup = "<div style='margin: 10px;'><b>Health Checkup:</b> " + datarecord.health_checkup + "</div>";

                    //var c_fee = "<div style='margin: 10px;'><b>College Fee:</b> " + datarecord.c_fee + "</div>";
                    //var award_grad_ss = "<div style='margin: 10px;'><b>Grad Award:</b> " + datarecord.award_grad_ss + "</div>";

                    $(leftcolumn3).append(briefcase);
                    $(leftcolumn3).append(c_tr);
                   // $(leftcolumn3).append(c_fee);
                   // $(leftcolumn3).append(award_grad_ss);
                    $(leftcolumn3).append(health_checkup);

                    //var d_hon = "<div style='margin: 10px;'><b>Honorarium Diploma:</b> " + datarecord.d_hon + "</div>";
                   // var hon_uy_i = "<div style='margin: 10px;'><b>Honorarium Intl:</b> " + datarecord.hon_uy_i + "</div>";
                    //var mba_hon = "<div style='margin: 10px;'><b>Honorarium MBA:</b> " + datarecord.mba_hon  + "</div>";              
                    //var hon_uy_n = "<div style='margin: 10px;'><b>Honorarium National:</b> " + datarecord.hon_uy_n + "</div>";
                   // var s_hon = "<div style='margin: 10px;'><b>Honorarium School:</b> " + datarecord.s_hon + "</div>";
                  //  $(middlecolumn3).append(d_hon);

                   // $(middlecolumn3).append(hon_uy_i);
                    //$(middlecolumn3).append(mba_hon);
                    //$(middlecolumn3).append(hon_uy_n);
                    //$(middlecolumn3).append(s_hon);
            
                    
                   // var hon_uy_s = "<div style='margin: 10px;'><b>Honorarium State:</b> " + datarecord.hon_uy_s + "</div>";
                    var mid_aca_trsfr_all = "<div style='margin: 10px;'><b>MAY TA:</b> " + datarecord.mid_aca_trsfr_all + "</div>";
                    var med_aid = "<div style='margin: 10px;'><b>Medical Aid:</b> " + datarecord.med_aid + "</div>";
                   // var merit_award = "<div style='margin: 10px;'><b>Merit Award:</b> " + datarecord.merit_award + "</div>";
                    var pli = "<div style='margin: 10px;'><b>PLI:</b> " + datarecord.pli + "</div>";

                   // $(centercolumn3).append(hon_uy_s);
                    $(centercolumn3).append(mid_aca_trsfr_all);
                    $(centercolumn3).append(med_aid);
                    $(centercolumn3).append(pli);

                   // var s_fee = "<div style='margin: 10px;'><b>School Fee:</b> " + datarecord.s_fee + "</div>";
                    var s_ss = "<div style='margin: 10px;'><b>School Scholarship:</b> " + datarecord.s_ss + "</div>";
                    var shifting_all = "<div style='margin: 10px;'><b>Shifting All	:</b> " + datarecord.shifting_all + "</div>";
                    var transfer = "<div style='margin: 10px;'><b>Transfer:</b> " + datarecord.transfer + "</div>";
                   // $(rightcolumn3).append(s_fee);
                    $(rightcolumn3).append(s_ss);
                    $(rightcolumn3).append(shifting_all);
                    $(rightcolumn3).append(transfer);
                    //pay
                    var container4 = $('<div style="margin: 5px;"></div>')
                    container4.appendTo($(pay));    
                    var leftcolumn4  = $('<div style="float: left; width: 25%;"></div>');
                    var middlecolumn4 = $('<div style="float: left; width: 25%;"></div>');
                    var centercolumn4 = $('<div style="float: left; width: 25%;"></div>');
                    var rightcolumn4 = $('<div style="float: left; width: 25%;"></div>');
                    container4.append(leftcolumn4); 
                    container4.append(middlecolumn4);
                    container4.append(centercolumn4);
                    container4.append(rightcolumn4);
                    var pf = "<div style='margin: 10px;'><b>PF:</b> " + datarecord.pf + "</div>";
                    var vpf = "<div style='margin: 10px;'><b>VPF:</b> " + datarecord.vpf + "</div>";
                    var pt = "<div style='margin: 10px;'><b>PT:</b> " + datarecord.pt + "</div>";
                    var it = "<div style='margin: 10px;'><b>IT:</b> " + datarecord.it + "</div>";
                    var esi_ee = "<div style='margin: 10px;'><b>Employee ESI:0</b></div>";
                    $(leftcolumn4).append(pf);
                    $(leftcolumn4).append(vpf);
                    $(leftcolumn4).append(pt);
                    $(leftcolumn4).append(it);
                    $(leftcolumn4).append(esi_ee);
                    var esi_er = "<div style='margin: 10px;'><b>Employer ESI:0</b></div>";
                    var lwf = "<div style='margin: 10px;'><b>LWF:</b> " + datarecord.lwf + "</div>";
                    var wl2 = "<div style='margin: 10px;'><b>2 Wheeler Loan:</b> " + datarecord.wl2 + "</div>";
                    var assoc_sub = "<div style='margin: 10px;'><b>Assoc Subscription:</b> " + datarecord.assoc_sub + "</div>";
                    var wl4 = "<div style='margin: 10px;'><b>Car Loan:</b> " + datarecord.wl4 + "</div>";
                    var comp_l = "<div style='margin: 10px;'><b>Computer Loan:</b> " + datarecord.comp_l + "</div>";

                            
                 //   $(middlecolumn4).append(esi_er);
                    $(middlecolumn4).append(lwf);
                    $(middlecolumn4).append(wl2);
                    $(middlecolumn4).append(assoc_sub);
                    $(middlecolumn4).append(wl4);
                    $(middlecolumn4).append(comp_l);
                   

                    var cons_l = "<div style='margin: 10px;'><b>Construction Loan:</b> " + datarecord.cons_l + "</div>";
                    var fest_adv = "<div style='margin: 10px;'><b>Festival Adv:</b> " + datarecord.fest_adv + "</div>";
                    var fl = "<div style='margin: 10px;'><b>Furniture Loan:</b> " + datarecord.fl + "</div>";
                    var gl = "<div style='margin: 10px;'><b>Gold Loan:</b> " + datarecord.gl + "</div>";
                    var hl = "<div style='margin: 10px;'><b>Home Loan:</b> " + datarecord.hl + "</div>";


                    $(centercolumn4).append(cons_l);

                    $(centercolumn4).append(fest_adv);
                    $(centercolumn4).append(fl);
                    $(centercolumn4).append(gl);
                    $(centercolumn4).append(hl);

                    var hl2 = "<div style='margin: 10px;'><b>Home Loan 2:</b> " + datarecord.hl2 + "</div>";
                    var hli = "<div style='margin: 10px;'><b>Home Loan Int:</b> " + datarecord.hli + "</div>";
                    var hli2 = "<div style='margin: 10px;'><b>Home Loan Int 2:</b> " + datarecord.hli2 + "</div>";
                    var l_ins = "<div style='margin: 10px;'><b>Home Loan Insu:</b> " + datarecord.l_ins + "</div>";
                    
                    $(rightcolumn4).append(hl2);
                    $(rightcolumn4).append(hli);
                    $(rightcolumn4).append(hli2);
                    $(rightcolumn4).append(l_ins);

                    //Reimbursements
                    var container5 = $('<div style="margin: 5px;"></div>')
                    container5.appendTo($(ded));    
                    var leftcolumn5  = $('<div style="float: left; width: 25%;"></div>');
                    var middlecolumn5 = $('<div style="float: left; width: 25%;"></div>');
                    var centercolumn5 = $('<div style="float: left; width: 25%;"></div>');
                    var rightcolumn5 = $('<div style="float: left; width: 25%;"></div>');
                   
                    container5.append(leftcolumn5); 
                    container5.append(middlecolumn5);
                    container5.append(centercolumn5);
                    container5.append(rightcolumn5);
                    var h_sch = "<div style='margin: 10px;'><b>Housing Scheme:</b> " + datarecord.h_sch + "</div>";
                    var levy = "<div style='margin: 10px;'><b>Levy:</b> " + datarecord.levy + "</div>";
                    var lic = "<div style='margin: 10px;'><b>LIC:</b> " + datarecord.lic + "</div>";
                    var lic_js = "<div style='margin: 10px;'><b>LIC Jeevan Suraksha:</b> " + datarecord.lic_js + "</div>";
                    var mcdrf = "<div style='margin: 10px;'><b>MCDRF:</b> " + datarecord.mcdrf + "</div>";
                   

                    $(leftcolumn5).append(h_sch);
                    $(leftcolumn5).append(levy);
                    $(leftcolumn5).append(lic);
                    $(leftcolumn5).append(lic_js);
                    $(leftcolumn5).append(mcdrf);

                    var misc_l = "<div style='margin: 10px;'><b>Miscellaneous Loan:</b> " + datarecord.misc_l + "</div>";
                    var nps = "<div style='margin: 10px;'><b>NPS:</b> " + datarecord.nps + "</div>";
                    var o_ded = "<div style='margin: 10px;'><b>Other Ded:</b> " + datarecord.o_ded + "</div>";
                    var payroll = "<div style='margin: 10px;'><b>Payroll:</b> " + datarecord.payroll + "</div>";
                    var pfl = "<div style='margin: 10px;'><b>PF Loan:</b> " + datarecord.pfl + "</div>";

                    $(middlecolumn5).append(misc_l);
                    $(middlecolumn5).append(nps);
                    $(middlecolumn5).append(o_ded);
                    $(middlecolumn5).append(payroll);
                    $(middlecolumn5).append(pfl);


                    var qtrs = "<div style='margin: 10px;'><b>Quarters:</b> " + datarecord.qtrs + "</div>";
                    var sec_l = "<div style='margin: 10px;'><b>Security Loan:</b> " + datarecord.sec_l + "</div>";
                    var society = "<div style='margin: 10px;'><b>Society:</b> " + datarecord.society + "</div>";
                    var sl = "<div style='margin: 10px;'><b>Special Loan:</b> " + datarecord.sl + "</div>";
                    var trust_l = "<div style='margin: 10px;'><b>Trust Loan:</b> " + datarecord.trust_l + "</div>";
                    $(centercolumn5).append(qtrs);
                    $(centercolumn5).append(sec_l);
                    $(centercolumn5).append(society);
                    $(centercolumn5).append(sl);
                    $(centercolumn5).append(trust_l);
                    
                    var trust_int = "<div style='margin: 10px;'><b>Trust Loan Int:</b> " + datarecord.trust_int + "</div>";
                    var u_sub = "<div style='margin: 10px;'><b>Union Subscription:</b> " + datarecord.u_sub + "</div>";
                    $(rightcolumn5).append(trust_int);
                    $(rightcolumn5).append(u_sub);

     
                   

                    
                        $(tabsdiv).jqxTabs({ width: 1100, height: 200, theme:'energyblue'})

          
            }
            }
            var dataAdapter = new $.jqx.dataAdapter(source);
            
            

   //         var dataAdapter1 = new $.jqx.dataAdapter(source);
   


 $("#grid").jqxGrid(
            {
                width: 1170,

                source: dataAdapter,
                rowdetails: true,
               
               
                columnsreorder:true,
                rowdetails: true,
                rowdetailstemplate: { rowdetails:  "<div style='margin: 10px;'><ul style='margin-left: 30px;'><li>Personal Info</li><li>Fixed Components</li><li>Incidental</li><li>Reimbursement</li><li>Deduction </li><li>Deduction 2</li></ul><div class='information'></div><div class='notes'></div><div class='custom'></div><div class='frad'></div><div class='pay'></div><div class='ded'></div></div>",
                	                 	 
                rowdetailsheight: 260}, 
                
                
               
                columnsresize: true,
                
                autoheight: true,
               
                selectionmode: 'multiplecellsextended',
                ready: function () {
                    $("#grid").jqxGrid('showrowdetails', 0);
                  
                },
                
                
                initrowdetails: initrowdetails,
                columns: [
            	      {text: 'Emp Code', datafield: 'ec', width: 70},
                      {text: 'Name', datafield: 'ename', width: 120},
                      {text: 'Gen', datafield: 'gen', width: 40},
                      {text: 'Category', datafield: 'cat', width: 70},
                      {text: 'Role', datafield: 'role', width: 80},
                      {text: 'PR. Exp', datafield: 'pexp', width: 60, cellsalign: 'right'},
                      {text: 'Location', datafield: 'loc', width: 70},
                      {text: 'Branch', datafield: 'bcode', width: 50, cellsalign: 'right'},
                      {text: 'Mobile', datafield: 'mobile', width: 90},
                      {text: 'Department', datafield: 'dept', width: 70},
                      {text: 'Manager', datafield: 'manager', width: 80},
                      {text: 'Basic', datafield: 'bpay', width: 70, cellsalign: 'right'},
                      {text: 'Gross Pay', datafield: 'total_payable', width: 90, cellsalign: 'right'},
                       {text: 'Deduction', datafield: 'total_deduct', width: 90, cellsalign: 'right'},
                      {text: 'Net Pay', datafield: 'net_pay', width: 90, cellsalign: 'right'}
               ]
            });

        });
     function excelClick() {
    	   var myurl = "${pageContext.request.contextPath}";
    	   alert("Wait while it's downloading");
    	 window.location.href = myurl + '/print/Export?ReportName=MYARREAR&Format=Excel&VURL=/grid/getMyarr&VJRXML=/static/jrxml/MYArrear_E.jrxml';
    
};

function pdfClick() {
	   var myurl = "${pageContext.request.contextPath}";
	   alert("Wait while it's downloading");
	 window.location.href = myurl + '/print/Export?ReportName=MYARREAR&Format=Pdf&VURL=/grid/getMyarr&VJRXML=/static/jrxml/MYArrear_P.jrxml';

};
    </script>
</head>
<body class='default'>

       <table style="width:99%">
  <tr>
    <th style="width:90%" align="center"><B>My Arrear </B> </th>

         <th style="width:15%" align="right"><input type="image" src="../images/excel.png" alt="Submit" width="20" height="20" onclick="excelClick()" id='excelExport' /></th>
    
     <th style="width:15%"  align="left"><input type="image" src="../images/pdf.png" alt="Submit" width="20" height="20" onclick="pdfClick()" onclick="pdfClick()" id='pdfExport' /></th>
  </tr>
  </table>
             
    <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: left;">
        <div id="grid"></div>
    </div>
</body>
</html>