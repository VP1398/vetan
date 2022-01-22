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
                	   {name: 'gen', type: 'string'},
                	   {name: 'designation', type: 'string'},
                	   {name: 'cat', type: 'string'},
                	   {name: 'comm_add', type: 'string'},
                	   {name: 'dob', type: 'string'},
                	   {name: 'doj', type: 'string'},
                	   {name: 'dop', type: 'string'},
                	   {name: 'retire_date', type: 'string'},
                	   {name: 'age', type: 'string'},
                	   {name: 'texp', type: 'string'},
                	   {name: 'pexp', type: 'string'},
                	   {name: 'bpay', type: 'string'},
                	   {name: 'spl_all', type: 'string'},
                	   {name: 'retire_class', type: 'string'},
                	   {name: 'bcode', type: 'string'},
                	   {name: 'mobile', type: 'string'},
                	   {name: 'email', type: 'string'},
                	   {name: 'pan', type: 'string'},
                	   {name: 'aadhaar', type: 'string'},
                	   {name: 'bcode_credit', type: 'string'},
                	   {name: 'app_date', type: 'string'},
                	   {name: 'qualify_yrs', type: 'string'},
                	   {name: 'qualify_yrs_add', type: 'string'},
                	   {name: 'qualify_yrs_tot', type: 'string'},
                	   {name: 'l_s_month', type: 'string'},
                	   {name: 'pension_type', type: 'string'},
                	   {name: 'pension_rate', type: 'string'},
                	   {name: 'bps_settle', type: 'string'},
                	   {name: 'commutation', type: 'string'},
                	   {name: 'med_exam_reqd', type: 'string'},
                	   {name: 'commutation_frac', type: 'string'},
                	   {name: 'dom_checkup', type: 'string'},
                	   {name: 'commutation_dt', type: 'string'},
                	   {name: 'fpp', type: 'string'},
                	   {name: 'pqp', type: 'string'},
                	   {name: 'off_pay', type: 'string'},
                	   {name: 'total_pay', type: 'string'}
               ],
                id: 'id',
                url: '${pageContext.request.contextPath}/pension/getPension',
                type: 'POST',
                async: true
            };
            var initrowdetails = function (index, parentElement, gridElement, datarecord) {
                var tabsdiv  = null;
                var custom = null;
                
                tabsdiv  = $($(parentElement).children()[0]);

            if (tabsdiv  != null) {

            	custom = tabsdiv .find('.custom');
             
                // title.text(datarecord.CustomerName);
                if (custom && custom.length > 0) {
                    tabsdiv.css('margin-top', '20px');
                }
                var container = $('<div style="margin: 5px;"></div>')
                container.appendTo($(custom));    
                var leftcolumn = $('<div style="float: left; width: 25%;"></div>');
                var middlecolumn = $('<div style="float: left; width: 25%;"></div>');
                var centercolumn = $('<div style="float: left; width: 25%;"></div>');
                var rightcolumn = $('<div style="float: left; width: 25%;"></div>');
  
                container.append(leftcolumn);            
                container.append(middlecolumn);
                container.append(centercolumn);               
                container.append(rightcolumn);
                

                
                var designation = "<div style='margin: 10px;'><b>Designation:</b> " + datarecord.designation + "</div>";
                var comm_add = "<div style='margin: 10px;'><b>Address:</b>" + datarecord.comm_add + "</div>";
                var dob = "<div style='margin: 10px;'><b>Birth Date:</b> " + datarecord.dob + "</div>";
                var retire_date = "<div style='margin: 10px;'><b>Retirement Date:</b> " + datarecord.retire_date + "</div>";
                var retire_class = "<div style='margin: 10px;'><b>Retirement Class:</b> " + datarecord.retire_class + "</div>";
                var texp = "<div style='margin: 10px;'><b>Experience:</b>" + datarecord.texp + "</div>";

                $(leftcolumn).append(designation);
                $(leftcolumn).append(comm_add);
                $(leftcolumn).append(dob);
                $(leftcolumn).append(retire_date);
                $(leftcolumn).append(retire_class);
                $(leftcolumn).append(texp);
                var age = "<div style='margin: 10px;'><b>Age:</b> " + datarecord.age + "</div>";
                var pan = "<div style='margin: 10px;'><b>PAN:</b>" + datarecord.pan + "</div>";
                var aadhaar = "<div style='margin: 10px;'><b>Aadhaar:</b>" + datarecord.aadhaar + "</div>";
                var qualify_yrs = "<div style='margin: 10px;'><b>Qualify Yrs:</b> " + datarecord.qualify_yrs + "</div>";
                var qualify_yrs_add = "<div style='margin: 10px;'><b>Qualify Add:</b> " + datarecord.qualify_yrs_add + "</div>";
                var qualify_yrs_tot = "<div style='margin: 10px;'><b>Qualify Tot:</b> " + datarecord.qualify_yrs_tot + "</div>";

                $(middlecolumn).append(age);
                $(middlecolumn).append(pan);
                $(middlecolumn).append(aadhaar);
                $(middlecolumn).append(qualify_yrs);
                $(middlecolumn).append(qualify_yrs_add);
                $(middlecolumn).append(qualify_yrs_tot);

                var app_date = "<div style='margin: 10px;'><b>App Date:</b> " + datarecord.app_date + "</div>";
                var bcode_credit = "<div style='margin: 10px;'><b>bcode_credit:</b>" + datarecord.bcode_credit + "</div>";
                var l_s_month = "<div style='margin: 10px;'><b>l_s_month:</b>" + datarecord.l_s_month + "</div>";
                var pension_type = "<div style='margin: 10px;'><b>pension_type:</b> " + datarecord.pension_rate + "</div>";
                var pension_rate = "<div style='margin: 10px;'><b>pension_rate:</b> " + datarecord.pension_rate + "</div>";
                var bps_settle = "<div style='margin: 10px;'><b>bps_settle:</b> " + datarecord.bps_settle + "</div>";

                $(centercolumn).append(app_date);
                $(centercolumn).append(bcode_credit);
                $(centercolumn).append(l_s_month);
                $(centercolumn).append(pension_rate);
                $(centercolumn).append(pension_type);
                $(centercolumn).append(bps_settle);

              
                
                var commutation = "<div style='margin: 10px;'><b>commutation:</b> " + datarecord.commutation + "</div>";
                var med_exam_reqd = "<div style='margin: 10px;'><b> med_exam_reqd:</b> " + datarecord.med_exam_reqd + "</div>";
                var commutation_frac = "<div style='margin: 10px;'><b>commutation_frac.:</b> " + datarecord.dom_checkup + "</div>";
                var dom_checkup = "<div style='margin: 10px;'><b>dom_checkup:</b> " + datarecord.email + "</div>";
                var commutation_dt = "<div style='margin: 10px;'><b>commutation_dt:</b>" + datarecord.commutation_dt + "</div>";
                $(rightcolumn).append(commutation);
                $(rightcolumn).append(med_exam_reqd);
                $(rightcolumn).append(commutation_frac);
                $(rightcolumn).append(dom_checkup);
                $(rightcolumn).append(commutation_dt);

           

                
                    $(tabsdiv).jqxTabs({ width: 1100, height: 200, theme:'energyblue'})
            }
            }
            var dataAdapter = new $.jqx.dataAdapter(source);
            
            var getLocalization = function () {
                var localizationobj = {};

                localizationobj.currencysymbol = "Rs. ";
                localizationobj.currencysymbolposition = "before";
                localizationobj.decimalseparator = ".";
                localizationobj.thousandsseparator = ",";

                return localizationobj;
            }

   //         var dataAdapter1 = new $.jqx.dataAdapter(source);
   


 $("#grid").jqxGrid(
            {
                width: 1170,

                source: dataAdapter,
                rowdetails: true,
                autoshowfiltericon: true,
                groupable:true,
                columnsreorder:true,
                rowdetails: true,
                rowdetailstemplate: { rowdetails:  "<div style='margin: 10px;'><ul style='margin-left: 30px;'><li>Personal Info</li></ul><div class='custom'></div>",
                	                 	 
                rowdetailsheight: 260}, 
                statusbarheight: 25,
                showstatusbar: true,
                showaggregates: true,
                sortable: true,
                localization: getLocalization(),

                columnsresize: true,
                pageable: true,
                autoheight: true,
                showfilterrow: true,
                filterable: true,
                selectionmode: 'multiplecellsextended',
               
                
                initrowdetails: initrowdetails,
                columns: [
            	      {text: 'Code', datafield: 'ec', width: 60},
                      {text: 'Name', datafield: 'ename', width: 100},
                      {text: 'Gen', datafield: 'gen', width: 35 },
                      {text: 'Category', datafield: 'cat', width: 50},
                      {text: 'Role', datafield: 'designation', width: 60},
                      {text: 'Exp', datafield: 'pexp', width: 50, cellsalign: 'right'},
                
                      {text: 'Branch', datafield: 'bcode', width: 55, cellsalign: 'right'},
                      {text: 'Mobile', datafield: 'mobile', width: 85},
                      {text: 'Email', datafield: 'email', width: 50},
                      {text: 'Basic', datafield: 'bpay', width: 110, cellsalign: 'right', aggregates: ['sum']},
                      {text: 'Spl.All.', datafield: 'spl_all', width: 100, cellsalign: 'right', aggregates: ['sum']},
                      {text: 'PQP', datafield: 'pqp', width: 100, cellsalign: 'right', aggregates: ['sum']},
                      {text: 'FPP', datafield: 'fpp', width: 100, cellsalign: 'right', aggregates: ['sum']},
                       {text: 'Off. Pay', datafield: 'off_pay', width: 70, cellsalign: 'right', aggregates: ['sum']},
                       {text: 'Total Amount', datafield: 'total_pay', cellsalign: 'right', width: 100, aggregates: ['sum'] }

                       ]
            });
 $("#excelExport").jqxButton();

 $("#pdfExport").jqxButton();

 $("#excelExport").click(function () {
     $("#grid").jqxGrid('exportdata', 'xls', 'jqxGrid');           
 });

 $("#pdfExport").click(function () {
     $("#grid").jqxGrid('exportdata', 'pdf', 'jqxGrid');
 });
        });
    
    </script>
</head>
<body class='default'>

       <table style="width:99%">
  <tr>
    <th style="width:90%" align="center"><B>Pension Statement</B> </th>

         <th style="width:5%" align="right"><input type="image" src="../images/excel.png" alt="Submit" width="20" height="20" id='excelExport' /></th>
    
     <th style="width:5%"  align="left"><input type="image" src="../images/pdf.png" alt="Submit" width="20" height="20" id='pdfExport' /></th>
  </tr>
  </table>
             
    <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: left;">
        <div id="grid"></div>
    </div>
</body>
</html>