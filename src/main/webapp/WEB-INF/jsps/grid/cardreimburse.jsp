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
                    {name: 'expense', type: 'string'}, 
                    {name: 'vendor', type: 'string'}, 
                    {name: 'inv_no', type: 'number'}, 
                    {name: 'inv_date', type: 'date'}, 
                    {name: 'inv_amt', type: 'number'}, 
                    {name: 'ent_amt', type: 'number'}, 
                    {n,ame: 'claimed_amt', type: 'number'}, 
                    {name: 'remarks', type: 'string'}
               ],
                id: 'id',
                url: '${pageContext.request.contextPath}/screen/getReimburse',
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
            
            Smart('#cardView', {
                get properties() {
                    return {
                        addNewButton: true,
                        dataSource: new Smart.DataAdapter(
                            {
                                dataSource: generateData(50),
                                dataFields:
                                    [
                                        'Expense: string',
                                        'Invoice No: number',
                                        'Amount: number',
                                        'Claimed Amount: number',
                                        'Entitled Amount: number',
                                        'Vendor: string',
                                        'price: number',
                                        'Remarks: string'
                                    ]
                            }),
                columns: [
                    {text: 'Expense', datafield: 'expense', width: 200},
          	     	{text: 'Invoice No', datafield: 'inv_no', width: 100, cellsalign: 'right'},
                    
                    {text: 'Amount', datafield: 'inv_amt', width: 100, cellsalign: 'right'},
                    {text: 'Claimed Amount', datafield: 'claimed_amt', width: 100, cellsalign: 'right'},
                    {text: 'Entitled Amount', datafield: 'ent_amt', width: 100, cellsalign: 'right'},
                     {text: 'Vendor', datafield: 'vendor', width: 200},
                      {text: 'Remarks', datafield: 'remarks', width: 270}

                      ]
                    
                      
            });
    // events
    smart("#cardview").on('cellbeginedit', function (event) {
        var args = event.args;
        smart("#cellbegineditevent").text("Event Type: cellbeginedit, Column: " + args.datafield + ", Row: " + (1 + args.rowindex) + ", Value: " + args.value);
    });
    smart("#cardview").on('cellendedit', function (event) {
        var args = event.args;
        $("#cellendeditevent").text("Event Type: cellendedit, Column: " + args.datafield + ", Row: " + (1 + args.rowindex) + ", Value: " + args.value);
    });
    
    smart("#jqxbutton").jqxButton();
	smart("#jqxbutton").on('click', function() {
		var cardView = smart("#cardview").jqxGrid('cardview');
		
		$("#grid").jqxGrid({cardview: !cardView});
	});
                
});
 
    </script>
</head>
<body class='default'>
    <table style="width:91%">
   <tr>
     <th style="width:90%" align="center"><B> Reimbursements </B> </th>
 
      <th>   <button id="jqxbutton">Switch CardView</button></th>
   </tr>
   </table>
 
        <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: center;">
         <div id="grid"></div>
 
   
 </div>
      
              
 
 </body>
</html>