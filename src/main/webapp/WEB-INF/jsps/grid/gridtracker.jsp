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
                	
                    {name: 'claimdate', type: 'date'}, 
                    {name: 'claimid', type: 'number'}, 
                    {name: 'description', type: 'string'}, 
                    {name: 'status', type: 'string'}, 
                    {name: 'payment', type: 'string'}, 
                    {name: 'amount', type: 'number'}
               ],
                id: 'id',
                url: '${pageContext.request.contextPath}/tracker/getTracker',
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
            	      {text: 'Claim Date', datafield: 'claimdate', width: 100, cellsformat: 'd'},
                      {text: 'Claim Id', datafield: 'claimid', width: 100},
                      {text: 'Description', datafield: 'description', width: 150},
                      {text: 'Approval Status', datafield: 'status', width: 150},
                      {text: 'Payment Status', datafield: 'amount', width: 170},
                
                      { text: 'Amount ', datafield: 'payment', width: 130, cellsalign: 'right', cellsformat: 'c2', aggregates: [{ 'Sum':
                          function (aggregatedValue, currentValue, column, record) {
                              var aggregatedValue = aggregatedValue + parseInt(record['payment']);
                              return aggregatedValue ;
                          }
                    }]                  
                      }
                      ]
                      
            });
        });
     function excelClick() {
    	   var myurl = "${pageContext.request.contextPath}";
    	 window.location.href = myurl + '/print/Export?ReportName=ClaimTracker&Format=Excel&VURL=/tracker/getTracker&VJRXML=/static/jrxml/ClaimTracker_E.jrxml';
    
};

function pdfClick() {
	   var myurl = "${pageContext.request.contextPath}";
	 window.location.href = myurl + '/print/Export?ReportName=ClaimTracker&Format=Pdf&VURL=/tracker/getTracker&VJRXML=/static/jrxml/ClaimTracker_P.jrxml';

};
 
    </script>
</head>
<body class='default'>
   <table style="width:63%">
  <tr>
    <th style="width:90%" align="center"><B>My Claims Tracker</B> </th>

         <th style="width:15%" align="right"><input type="image" src="../images/excel.png" alt="Submit" width="20" height="20" onclick="excelClick()" id='excelExport' /></th>
    
     <th style="width:15%"  align="left"><input type="image" src="../images/pdf.png" alt="Submit" width="20" height="20" onclick="pdfClick()" id='pdfExport' /></th>
  </tr>
  </table>
  
       <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: center;">
        <div id="grid"></div>

</div>
     
             

</body>
</html>