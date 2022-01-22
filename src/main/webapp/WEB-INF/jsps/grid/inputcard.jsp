<!DOCTYPE html>
<html lang="en">
<head>
    <title>In order to enter in edit mode, click any of the 'Edit' buttons. To save the changes, click the 'Save' button in the popup dialog. To cancel the changes
    click the 'Cancel' button in the popup dialog.</title>
    <link rel="stylesheet" href="../jqwidgets/styles/jqx.base.css" type="text/css" />
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />
    
  <script type="text/javascript" src="../scripts/jquery-1.12.4.min.js"></script>
         <%@include file="externalJsImports.jsp"%>
        
        
        <script type="text/javascript" src="../jqwidgets/jqxgrid.filter.js"></script>
        <script type="text/javascript" src="../jqwidgets/jqxgrid.grouping.js"></script>
        <script type="text/javascript" src="../jqwidgets/jqxgrid.columnsreorder.js"></script>
 		<script type="text/javascript" src="../jqwidgets/jqxgrid.aggregates.js"></script>
 		
    <script type="text/javascript" src="generatedata.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            // prepare the data
            var data = generatedata(200);
            var source =
            {
                localdata: data,
                datatype: "array",
                datafields:
                [
                    { name: 'firstname', type: 'string' },
                    { name: 'lastname', type: 'string' },
                    { name: 'productname', type: 'string' },
                    { name: 'quantity', type: 'number' },
                    { name: 'price', type: 'number' }
                ],
                updaterow: function (rowid, rowdata, commit) {
                    // synchronize with the server - send update command
                    // call commit with parameter true if the synchronization with the server is successful 
                    // and with parameter false if the synchronization failder.
                    commit(true);
                }
            };
            // initialize the input fields.
            $("#firstName").jqxInput({ theme: theme });
            $("#lastName").jqxInput({ theme: theme });
            $("#product").jqxInput({ theme: theme });
        
            $("#firstName").width(150);
            $("#firstName").height(23);
            $("#lastName").width(150);
            $("#lastName").height(23);
            $("#product").width(150);
            $("#product").height(23);
            $("#quantity").jqxNumberInput({spinMode: 'simple', width: 150, height: 23, min: 0, decimalDigits: 0, spinButtons: true });
            $("#price").jqxNumberInput({ spinMode: 'simple', symbol: '$', width: 150, min: 0, height: 23, spinButtons: true });
            var dataAdapter = new $.jqx.dataAdapter(source);
            var editrow = -1;
            // initialize jqxGrid
            $("#grid").jqxGrid(
            {
                width: getWidth('Grid'),
                source: dataAdapter,
                pageable: true,
                autoheight: true,
                columns: [
                  { text: 'First Name', datafield: 'firstname', width: 200 },
                  { text: 'Last Name', datafield: 'lastname', width: 200 },
                  { text: 'Product', datafield: 'productname', width: 190 },
                  { text: 'Quantity', datafield: 'quantity', width: 90, cellsalign: 'right' },
                  { text: 'Price', datafield: 'price', width: 90, cellsalign: 'right', cellsformat: 'c2' },
                  { text: 'Edit', datafield: 'Edit', columntype: 'button', cellsrenderer: function () {
                     return "Edit";
                  }, buttonclick: function (row) {
                     // open the popup window when the user clicks a button.
                     editrow = row;
                     var offset = $("#grid").offset();
                     $("#popupWindow").jqxWindow({ position: { x: parseInt(offset.left) + 60, y: parseInt(offset.top) + 60 } });
                     // get the clicked row's data and initialize the input fields.
                     var dataRecord = $("#grid").jqxGrid('getrowdata', editrow);
                     $("#firstName").val(dataRecord.firstname);
                     $("#lastName").val(dataRecord.lastname);
                     $("#product").val(dataRecord.productname);
                     $("#quantity").jqxNumberInput({ decimal: dataRecord.quantity });
                     $("#price").jqxNumberInput({ decimal: dataRecord.price });
                     // show the popup window.
                     $("#popupWindow").jqxWindow('open');
                 }
                 }
                ]
            });
            // initialize the popup window and buttons.
            $("#popupWindow").jqxWindow({
                width: 250, resizable: false,  isModal: true, autoOpen: false, cancelButton: $("#Cancel"), modalOpacity: 0.01           
            });
            $("#popupWindow").on('open', function () {
                $("#firstName").jqxInput('selectAll');
            });
         
            $("#Cancel").jqxButton({ theme: theme });
            $("#Save").jqxButton({ theme: theme });
            // update the edited row when the user clicks the 'Save' button.
            $("#Save").click(function () {
                if (editrow >= 0) {
                    var row = { firstname: $("#firstName").val(), lastname: $("#lastName").val(), productname: $("#product").val(),
                        quantity: parseInt($("#quantity").jqxNumberInput('decimal')), price: parseFloat($("#price").jqxNumberInput('decimal'))
                    };
                    var rowID = $('#grid').jqxGrid('getrowid', editrow);
                    $('#grid').jqxGrid('updaterow', rowID, row);
                    $("#popupWindow").jqxWindow('hide');
                }
            });
        });
    </script>
</head>
<body class='default'>
    <div id='jqxWidget'>
        <div id="grid"></div>
        <div style="margin-top: 30px;">
            <div id="cellbegineditevent"></div>
            <div style="margin-top: 10px;" id="cellendeditevent"></div>
       </div>
       <div id="popupWindow">
            <div>Edit</div>
            <div style="overflow: hidden;">
                <table>
                    <tr>
                        <td align="right">First Name:</td>
                        <td align="left"><input id="firstName" /></td>
                    </tr>
                    <tr>
                        <td align="right">Last Name:</td>
                        <td align="left"><input id="lastName" /></td>
                    </tr>
                    <tr>
                        <td align="right">Product:</td>
                        <td align="left"><input id="product" /></td>
                    </tr>
                    <tr>
                        <td align="right">Quantity:</td>
                        <td align="left"><div id="quantity"></div></td>
                    </tr>
                    <tr>
                        <td align="right">Price:</td>
                        <td align="left"><div id="price"></div></td>
                    </tr>
                    <tr>
                        <td align="right"></td>
                        <td style="padding-top: 10px;" align="right"><input style="margin-right: 5px;" type="button" id="Save" value="Save" /><input id="Cancel" type="button" value="Cancel" /></td>
                    </tr>
                </table>
            </div>
       </div>
    </div>
</body>
</html>