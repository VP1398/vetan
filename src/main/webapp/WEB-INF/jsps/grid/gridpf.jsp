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
            		 updaterow: function (rowid, rowdata, commit) {
                         // synchronize with the server - send update command   
                         commit(true);
                     },
                datatype: 'json',
                datafields: [
                    {name: 'id', type: 'string'}, 
                    {name: 'ec', type: 'string'}, 
                    {name: 'ename', type: 'string'}, 
                    {name: 'area', type: 'string'}, 
                    {name: 'bcode', type: 'string'}, 
                    {name: 'bpay', type: 'number'}, 
                    {name: 'da', type: 'number'},
                    {name: 'bpay_tot', type: 'number'}, 
                    {name: 'pf', type: 'number'},
                    {name: 'epf', type: 'number'}, 
                    {name: 'epsf', type: 'number'}, 
                    {name: 'vpf', type: 'number'}, 
                    {name: 'pfl', type: 'number'}, 
                    {name: 'total', type: 'number'}
               ],
                id: 'id',
                url: '${pageContext.request.contextPath}/fund/getFund',
                type: 'POST',
                async: true
            };
            

            var dataAdapter = new $.jqx.dataAdapter(source);
            var getLocalization = function () {
                var localizationobj = {};

                localizationobj.currencysymbol = "Rs. ";
                localizationobj.currencysymbolposition = "before";
                localizationobj.decimalseparator = ".";
                localizationobj.thousandsseparator = ",";

                return localizationobj;
            }
            



 	$("#grid").jqxGrid(
            {
                width: 1170,
          
                source: dataAdapter,
                autoshowfiltericon: true,
                groupable:true,
                columnsreorder:true,
                localization: getLocalization(),
                 sortable: true,
                 statusbarheight: 25,
                 showstatusbar: true,
                columnsresize: true,
                showaggregates: true,
                autoheight: true,
                showfilterrow: true,
                filterable: true,
                pageable: true,
                selectionmode: 'multiplecellsextended',
              
                
                columns: [
            	      {text: 'Emp Code', datafield: 'ec', width: 90},
                      {text: 'Name', datafield: 'ename', width: 120},

                      {text: 'Branch', datafield: 'bcode', cellsalign: 'right', width: 60},
                      {text: 'Basic', datafield: 'bpay', cellsalign: 'right', width: 80},
                      {text: 'DA', datafield: 'da', cellsalign: 'right', width: 80},
                      {text: 'Basic total', datafield: 'bpay_tot', cellsalign: 'right', width: 80},
                      { text: 'PF', datafield: 'pf', cellsalign: 'right', width: 110, aggregates: ['sum'] },
                      { text: 'VPF', datafield: 'vpf', cellsalign: 'right',  width: 110, aggregates: ['sum'] },
                      
                      { text: 'EPF', datafield: 'epf', cellsalign: 'right',  width: 110, aggregates: ['sum'] },
                      { text: 'EPSF', datafield: 'epsf', cellsalign: 'right', width: 110, aggregates: ['sum'] },
                     { text: 'PF Loan', datafield: 'pfl', cellsalign: 'right',  width: 110, aggregates: ['sum'] },
                      { text: 'Total Amount', datafield: 'total', cellsalign: 'right', width: 110, aggregates: ['sum'] }
                
                      ]
                      
            });
        });
     function excelClick() {
    	   var myurl = "${pageContext.request.contextPath}";
    	   alert("Wait while it's downloading");
    	 window.location.href = myurl + '/print/Export?ReportName=PF&Format=Excel&VURL=/fund/getFund&VJRXML=/static/jrxml/Pf_E.jrxml';
    
};

function pdfClick() {
	   var myurl = "${pageContext.request.contextPath}";
	   alert("Wait while it's downloading");
	 window.location.href = myurl + '/print/Export?ReportName=PF&Format=Pdf&VURL=/fund/getFund&VJRXML=/static/jrxml/Pf_P.jrxml';

};
     
    </script>
</head>
<body class='default'>
   <table style="width:94%">
  <tr>
    <th style="width:90%" align="center"><B>PF Statement for November 2021</B> </th>

         <th style="width:5%" align="right"><input type="image" src="../images/excel.png" alt="Submit" width="20" height="20" onclick="excelClick()" id='excelExport' /></th>
    
     <th style="width:5%"  align="left"><input type="image" src="../images/pdf.png" alt="Submit" width="20" height="20" onclick="pdfClick()"  id='pdfExport' /></th>
  </tr>
  </table>
  
       <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: center;">
        <div id="grid"></div>

</div>
     
             

</body>
</html>