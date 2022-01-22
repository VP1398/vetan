
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import=" java.net.URL"%>

<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="net.sf.jasperreports.engine.export.JRPdfExporter"%>
<%@ page import="net.sf.jasperreports.export.*"%>


<%@ page import = "net.sf.jasperreports.engine.query.JsonQueryExecuterFactory"%>
<%@ page import ="net.sf.jasperreports.engine.util.JsonUtil"%>
<%@ page import ="net.sf.jasperreports.engine.data.JsonDataSource"%>
<%@ page import="java.io.*"%>

<%@ page import="java.util.*"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.InputStream"%>

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
                    {name: 'type1', type: 'number'}, 
                    {name: 'type2', type: 'number'},
                    {name: 'type3', type: 'number'}, 
                    {name: 'type4', type: 'number'},
                    {name: 'type5', type: 'number'}, 
                    {name: 'total', type: 'number'}
               ],
                id: 'id',
                url: '${pageContext.request.contextPath}/table/getEsi',
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
                width: 900,
          
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
            	      {text: 'Code', datafield: 'ec', width: 100},
                      {text: 'Name', datafield: 'ename', width: 200},
                      {text: 'Gross', datafield: 'area', cellsalign: 'right', width: 100},
                      {text: 'Department', datafield: 'bcode',  width: 100 },
                      {text: 'Employee Contribute', datafield: 'type1', cellsalign: 'right', width: 150, aggregates: ['sum'] },
                      {text: 'Employer Contribute', datafield: 'type2', cellsalign: 'right', width: 150, aggregates: ['sum'] },

                      {text: 'Total Amount', datafield: 'total', cellsalign: 'right', width: 100, aggregates: ['sum'] }

                      ]
                      
            });
   
        });

     function excelClick() {
    	   var myurl = "${pageContext.request.contextPath}";
    	   alert("Wait while it's downloading");
    	 window.location.href = myurl + '/print/Export?ReportName=ESI&Format=Excel&VURL=/table/getEsi&VJRXML=/static/jrxml/Esi_E.jrxml';
    
};

function pdfClick() {
	   var myurl = "${pageContext.request.contextPath}";
	   alert("Wait while it's downloading");
	 window.location.href = myurl + '/print/Export?ReportName=ESI&Format=Pdf&VURL=/table/getEsi&VJRXML=/static/jrxml/Esi_P.jrxml';

};

     
    </script>
</head>
<body class='default'>
   <table style="width:70%">
  <tr>
    <th style="width:90%" align="center"><B>ESI  Statement for November 2021</B> </th>


         <th style="width:25%" align="right"><input type="image" src="../images/excel.png" alt="Submit" width="20" height="20"  onclick="excelClick()" id='excelExport' /></th>
    
     <th style="width:25%"  align="left"><input type="image" src="../images/pdf.png" alt="Submit" width="20" height="20"  onclick="pdfClick()" id='pdfExport' /></th>
   </tr>
  </table>
  
       <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: center;">
        <div id="grid"></div>

</div>
     
             

</body>
</html>