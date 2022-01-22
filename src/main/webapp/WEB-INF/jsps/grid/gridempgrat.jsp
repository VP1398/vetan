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
                         commit(true);
                     },
                datatype: 'json',
                datafields: [
                    {name: 'id', type: 'string'}, 
                    {name: 'ec', type: 'string'}, 
                    {name: 'ename', type: 'string'}, 
                    {name: 'cat', type: 'string'}, 
                    {name: 'role', type: 'string'}, 
                    {name: 'area', type: 'string'}, 
                    {name: 'bcode', type: 'string'}, 
                    {name: 'bpay', type: 'number'}, 
                    {name: 'da', type: 'number'},
                    {name: 'fpp', type: 'number'}, 
                    {name: 'pqp', type: 'number'},
                    {name: 'spl_all', type: 'number'}, 
                    {name: 'grat_type', type: 'string'}, 
                    {name: 'grat_amt', type: 'number'}
               ],
                id: 'id',
                url: '${pageContext.request.contextPath}/grat/getempGratuity',
                type: 'POST',
                async: true
            };
           var dataAdapter = new $.jqx.dataAdapter(source);
            var getLocalization = function () {
                var localizationobj = {};
                localizationobj.currencysymbol = "";
                localizationobj.currencysymbolposition = "before";
                localizationobj.decimalseparator = ".";
                localizationobj.thousandsseparator = ",";
                return localizationobj;
            }
 	$("#grid").jqxGrid(
            {
                width: 1170,
                source: dataAdapter,
                columnsreorder:true,
                localization: getLocalization(),
                columnsresize: true,
                autoheight: true,
                selectionmode: 'multiplecellsextended',
                columns: [
            	      {text: 'Code', datafield: 'ec', width: 100},
                      {text: 'Name', datafield: 'ename', width: 110},
                      {text: 'Category', datafield: 'cat', width: 80},
                      {text: 'role', datafield: 'role', width: 130},
                      {text: 'Department', datafield: 'area', width: 80},
                      {text: 'Branch', datafield: 'bcode', width: 50},
                      {text: 'Basic', datafield: 'bpay',cellsalign: 'right',  width: 80},
                      {text: 'DA', datafield: 'da',cellsalign: 'right',  width: 80},
                      {text: 'FPP', datafield: 'fpp',cellsalign: 'right',  width: 70},
                      {text: 'PQP', datafield: 'pqp', cellsalign: 'right', width: 70},
                      {text: 'Spl. All.', datafield: 'spl_all', cellsalign: 'right', width: 80},
                      {text: 'Gratuity Type', datafield: 'grat_type', width: 110},
                      {text: 'Amount', datafield: 'grat_amt',cellsalign: 'right',  width: 130}

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
    <th style="width:90%" align="center"><B>My Gratuity </B> </th>

 </tr>
  </table>
  
       <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: center;">
        <div id="grid"></div>

</div>
     
             

</body>
</html>