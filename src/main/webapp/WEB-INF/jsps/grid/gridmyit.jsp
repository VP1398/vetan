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
                    {name: 'loan_type', type: 'string'}, 
                    {name: 'loan_amt', type: 'number'}
               ],
                id: 'id',
                url: '${pageContext.request.contextPath}/report/getMyit',
                type: 'POST',
                async: true
            };
            

            var dataAdapter = new $.jqx.dataAdapter(source);
            var getLocalization = function () {
                var localizationobj = {};

                localizationobj.currencysymbol = " ";
                localizationobj.currencysymbolposition = "before";
                localizationobj.decimalseparator = ".";
                localizationobj.thousandsseparator = ",";

                return localizationobj;
            }
            



 	$("#grid").jqxGrid(
            {
                width: 1000,
          
                source: dataAdapter,
                autoshowfiltericon: true,
           
                columnsreorder:true,
                localization: getLocalization(),
           
                 statusbarheight: 25,
                 showstatusbar: true,
                columnsresize: true,
                showaggregates: true,
                autoheight: true,
              
                selectionmode: 'multiplecellsextended',
              
                
                columns: [
            	      {text: 'Code', datafield: 'ec', width: 100},
                      {text: 'Name', datafield: 'ename', width: 300},
                      {text: 'Department', datafield: 'area', width: 150},
                      {text: 'Taxable Income', datafield: 'bcode', width: 100, cellsalign: 'right'},
                      {text: 'Old Tax', datafield: 'loan_type', cellsalign: 'right', width: 200},
                      { text: 'New Tax ', datafield: 'loan_amt', width: 150, cellsalign: 'right',  aggregates: [{ '<b>Tot</b>':
                          function (aggregatedValue, currentValue, column, record) {
                              var aggregatedValue = aggregatedValue + parseInt(record['loan_amt']);
                              return aggregatedValue ;
                          }
                    }]                  
                      }
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
   <table style="width:70%">
  <tr>
    <th style="width:90%" align="center"><B>My IT   for May 2021</B> </th>

    </tr>
  </table>
 
       <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: center;">
        <div id="grid"></div>

  
</div>
     
             

</body>
</html>