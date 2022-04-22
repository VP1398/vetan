<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Vetan.</title>
        <link rel="stylesheet" href="../jqwidgets/styles/jqx.base.css" type="text/css" />
        <link rel="stylesheet" href="../jqwidgets/styles/jqx.arctic.css" type="text/css" />
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />	
    <script type="text/javascript" src="../scripts/jquery-1.12.4.min.js"></script>
         <%@include file="externalJsImports.jsp"%>
        
        
        <script type="text/javascript" src="../jqwidgets/jqxgrid.filter.js"></script>
        <script type="text/javascript" src="../jqwidgets/jqxgrid.grouping.js"></script>
        <script type="text/javascript" src="../jqwidgets/jqxgrid.columnsreorder.js"></script>
 		<script type="text/javascript" src="../jqwidgets/jqxgrid.aggregates.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            // prepare the data
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
                    {name: 'claimed_amt', type: 'number'}, 
                    {name: 'remarks', type: 'string'},
                    {name: 'data', type: 'image'}
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
             
           
            var initrowdetails = function (index, parentElement, gridElement, datarecord) {
                var tabsdiv = null;
                var information = null;
                var notes = null;
				var custom = null;
				
                tabsdiv = $($(parentElement).children()[0]);
			
				if (tabsdiv != null) {
				
					information = tabsdiv.find('.information');
                    notes = tabsdiv.find('.notes');
                    custom = tabsdiv.find('.custom');
                    var title = tabsdiv.find('.title');
                    title.text(datarecord.firstname);

					if (custom && custom.length > 0) {
						custom[0].innerHTML = "<div style='margin: 5px;'>The height of the item is set to a different value than the other items.</div>";
						tabsdiv.css('margin-top', '60px');
					}
					
                    var container = $('<div style="margin: 5px;"></div>')
                    container.appendTo($(information));
                    var photocolumn = $('<div style="float: left; width: 15%;"></div>');
                    var leftcolumn = $('<div style="float: left; width: 45%;"></div>');
                    var rightcolumn = $('<div style="float: left; width: 40%;"></div>');
                    container.append(photocolumn);
                    container.append(leftcolumn);
                    container.append(rightcolumn);

                    var photo = $("<div class='jqx-rc-all' style='margin: 10px;'><b>Photo:</b></div>");
                    var image = $("<div style='margin-top: 10px;'></div>");
                    var img = $('<img height="60" src="' + datarecord.data + '"/>');
                    image.append(img);
                    image.appendTo(photo);
                    photocolumn.append(photo);

                    var expense = "<div style='margin: 10px;'><b>Expense:</b> " + datarecord.expense + "</div>";
                    var vendor = "<div style='margin: 10px;'><b>Vendor:</b> " + datarecord.vendor + "</div>";
                    var inv_no = "<div style='margin: 10px;'><b>Invoice Number:</b> " + datarecord.inv_no + "</div>";
                    var inv_amt = "<div style='margin: 10px;'><b>Invoice Amount:</b> " + datarecord.inv_amt + "</div>";
                    $(leftcolumn).append(expense);
                    $(leftcolumn).append(vendor);
                    $(leftcolumn).append(inv_no);
                    $(leftcolumn).append(inv_amt);

                    var inv_date = "<div style='margin: 10px;'><b>Invoice Date:</b> " + datarecord.inv_date + "</div>";
                    var ent_amt = "<div style='margin: 10px;'><b>Amount:</b> " + datarecord.ent_amt + "</div>";
                    var claimed_amt = "<div style='margin: 10px;'><b>Claimed Amount:</b> " + datarecord.claimed_amt + "</div>";
                    var remarks = "<div style='margin: 10px;'><b>Remarks:</b> " + datarecord.remarks + "</div>";

                    $(rightcolumn).append(inv_date);
                    $(rightcolumn).append(ent_amt);
                    $(rightcolumn).append(claimed_amt);
                    $(rightcolumn).append(remarks);

                    var notescontainer = $('<div style="white-space: normal; margin: 5px;"><span>' + datarecord.notes + '</span></div>');
                    $(notes).append(notescontainer);
                    $(tabsdiv).jqxTabs({ width: 750, height: 170});
                }
            }
            var dataAdapter = new $.jqx.dataAdapter(source);

            $("#grid").jqxGrid(
            {
                width: getWidth('Grid'),
                height: 400,
                source: dataAdapter,
                rowdetails: true,
                rowdetailstemplate: function(index)
				{
					var details = {
						rowdetails: "<div style='margin: 10px;'><ul style='margin-left: 30px;'><li class='title'></li><li>Notes</li></ul><div class='information'></div><div class='notes'></div></div>",
						rowdetailsheight: 200
					};
					
					if (index === 0 || index === 3) {
						details.rowdetailsheight = 300;
						details.rowdetails = "<div style='margin: 10px;'><ul style='margin-left: 30px;'><li class='title'></li><li>Notes</li><li>Custom</li></ul><div class='information'></div><div class='notes'></div><div class='custom'></div>";
					}
					
					return details;
                },
				ready: function () {
                    $("#grid").jqxGrid('showrowdetails', 0);
                    $("#grid").jqxGrid('showrowdetails', 1);
                },
                initrowdetails: initrowdetails,
                columns: [
                      { text: 'Expense', datafield: 'expense', width: 200 },
                      { text: 'Vendor', datafield: 'vendor', width: 200 },
                      { text: 'Invoice Number', datafield: 'inv_no', width: 180 },
                      { text: 'Invoice amount', datafield: 'inv_amt', width: 100 },
                      { text: 'Invoice Date', datafield: 'inv_date', width: 100 },
                      { text: ' amount', datafield: 'ent_amt', width: 100 },
                      { text: 'Claimed Amount', datafield: 'claimed_amt', width: 100 },
                      { text: 'Remarks', datafield: 'remarks'}
                  ]
            });
        });
    </script>
</head>
<body class='default'>
    <div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: left;">
        <div id="grid"></div>
    </div>
</body>
</html>
