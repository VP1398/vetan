<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
   
  
	
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
                url: '${pageContext.request.contextPath}/report/getNps',
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
                width: 800,
                height: 800,
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
                ready: function () {
                    $("#grid1").jqxGrid('showrowdetails', 0);
                    $("#grid1").jqxGrid('showrowdetails', 1);
                },
                
                columns: [
            	      {text: 'Code', datafield: 'ec', width: 100},
                      {text: 'Name', datafield: 'ename', width: 200},
                      {text: 'Department', datafield: 'area', width: 100},
                      {text: 'Branch', datafield: 'bcode', width: 100, cellsalign: 'right'},
                      {text: 'Loan Type', datafield: 'loan_type', width: 100},
                      { text: 'Loan Amt', datafield: 'loan_amt', cellsalign: 'right', cellsformat: 'c2', aggregates: [{ '<b>Total</b>':
                          function (aggregatedValue, currentValue, column, record) {
                              var aggregatedValue = aggregatedValue + parseInt(record['loan_amt']);
                              return aggregatedValue ;
                          }
                    }]                  
                      }
                      ]
                      
            });
    $("#excelExport").jqxButton();
    $("#xmlExport").jqxButton();
    $("#csvExport").jqxButton();
    $("#tsvExport").jqxButton();
    $("#htmlExport").jqxButton();
    $("#jsonExport").jqxButton();
    $("#pdfExport").jqxButton();

    $("#excelExport").click(function () {
        $("#grid").jqxGrid('exportdata', 'xls', 'jqxGrid');           
    });
    $("#xmlExport").click(function () {
        $("#grid").jqxGrid('exportdata', 'xml', 'jqxGrid');
    });
    $("#csvExport").click(function () {
        $("#grid").jqxGrid('exportdata', 'csv', 'jqxGrid');
    });
    $("#tsvExport").click(function () {
        $("#grid").jqxGrid('exportdata', 'tsv', 'jqxGrid');
    });
    $("#htmlExport").click(function () {
        $("#grid").jqxGrid('exportdata', 'html', 'jqxGrid');
    });
    $("#jsonExport").click(function () {
        $("#grid").jqxGrid('exportdata', 'json', 'jqxGrid');
    });
    $("#pdfExport").click(function () {
        $("#grid").jqxGrid('exportdata', 'pdf', 'jqxGrid');
    });
        });
 
    </script>
</head>
<body class='default'>
   

       <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: center;">
        <div id="grid"></div>
    </div>
    <div style='float: left;'>
        <div > <B>vehicle Loan</B> </div>
 <div style='float: left;'>
                <input type="button" value="Export to Excel" id='excelExport' />
                <br /><br />
                <input type="button" value="Export to XML" id='xmlExport' />
            </div>
            <div style='margin-left: 10px; float: left;'>
                <input type="button" value="Export to CSV" id='csvExport' />
                <br /><br />
                <input type="button" value="Export to TSV" id='tsvExport' />
            </div>
            <div style='margin-left: 10px; float: left;'>
                <input type="button" value="Export to HTML" id='htmlExport' />
                <br /><br />
                <input type="button" value="Export to JSON" id='jsonExport' />
            </div>
            <div style='margin-left: 10px; float: left;'>
                <input type="button" value="Export to PDF" id='pdfExport' />
            </div>

</div>
     
             

</body>
</html>