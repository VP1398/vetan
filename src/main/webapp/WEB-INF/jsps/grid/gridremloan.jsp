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
                    {name: 'loan', type: 'string'}, 
                    {name: 'prod_name', type: 'string'}, 
                    {name: 'prod_type', type: 'string'},
                    {name: 'vendor', type: 'string'},
                    {name: 'inv_no', type: 'number'}, 
                    {name: 'inv_date', type: 'date'}, 
                    {name: 'est_val', type: 'number'}, 
                     {name: 'tot_est', type: 'number'}, 
                    {name: 'ent_amt', type: 'number'}, 
                    {name: 'req_amt', type: 'number'}, 
                    {name: 'remarks', type: 'string'}
               ],
                id: 'id',
                url: '${pageContext.request.contextPath}/remloan/getRemLoan',
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
            



            $( "#grid" ).jqxGrid( {
                altrows: true,
                width: 1170,
                source: dataAdapter,
                editable: true,
                height: 500,
				sortable: true,
				selectionmode: 'multiplecellsadvanced',
                cardview: true,
				cardviewcolumns: [
                    {
                        width: 'auto',
                        datafield: 'loan'
                      
                    },
                    
                    {
                        width: 'auto',
                        datafield: 'inv_no'
                    },
                    {
                        width: 400,
                        datafield: 'inv_date',
                        	columntype: 'datetimeinput'
                    }
                ],
                
                columns: [
                    {text: 'Loan Type', datafield: 'loan', width: 100},
                    {text: 'Product Name', datafield: 'prod_name', width: 100},
                    {text: 'Product Type', datafield: 'prod_type', width: 100},
            
          	     	{text: 'Invoice No', datafield: 'inv_no', width: 100, cellsalign: 'right'},
                   
                    {text: 'Estimated Value', datafield: 'est_val', width: 100, cellsalign: 'right'},
                    {text: 'Total Estimate ', datafield: 'tot_est', width: 100, cellsalign: 'right'},
                    {text: 'Entitled Amount', datafield: 'ent_amt', width: 100, cellsalign: 'right'},
                    {text: 'Requested Amount', datafield: 'req_amt', width: 100, cellsalign: 'right'},
                     {text: 'Vendor', datafield: 'vendor', width: 200},
                      {text: 'Remarks', datafield: 'remarks', width: 270}

                      ]
                
                      
            });
    // events
    $("#grid").on('cellbeginedit', function (event) {
        var args = event.args;
        $("#cellbegineditevent").text("Event Type: cellbeginedit, Column: " + args.datafield + ", Row: " + (1 + args.rowindex) + ", Value: " + args.value);
    });
    $("#grid").on('cellendedit', function (event) {
        var args = event.args;
        $("#cellendeditevent").text("Event Type: cellendedit, Column: " + args.datafield + ", Row: " + (1 + args.rowindex) + ", Value: " + args.value);
    });
    
    $("#jqxbutton").jqxButton();
	$("#jqxbutton").on('click', function() {
		var cardView = $("#grid").jqxGrid('cardview');
		
		$("#grid").jqxGrid({cardview: !cardView});
	});
});
 
    </script>
</head>
<body class='default'>
    <table style="width:91%">
   <tr>
     <th style="width:90%" align="center"><B>Loan Reimbursements </B> </th>
 
      <th>   <button id="jqxbutton">Switch CardView</button></th>
   </tr>
   </table>
 
        <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: center;">
         <div id="grid"></div>
 
   
 </div>
      
              
 
 </body>
</html>