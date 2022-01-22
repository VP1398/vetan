<!DOCTYPE html>
<html lang="en">
<head>
    <title>In order to enter in edit mode, select a grid cell and start typing, "Click" or press the "F2" key. You 
    can also navigate through the cells using the keyboard arrows or with the "Tab" and "Shift + Tab" key combinations. To cancel the cell editing, press the "Esc" key. To save
    the changes press the "Enter" key or select another Grid cell. Pressing the 'Space' key when a checkbox cell is selected will toggle the check state.</title>
	<meta name="description" content="jQuery Grid Cells editing. jQWidgets Grid supports multiple built-in cell editors like checkbox, dropdownlist, combobox, etc." /> 	
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
                updaterow: function (rowid, rowdata, commit) {
                    // synchronize with the server - send update command
                    // call commit with parameter true if the synchronization with the server is successful 
                    // and with parameter false if the synchronization failder.
                    commit(true);
                },
                datafields:
                [
                    { name: 'firstname', type: 'string' },
                    { name: 'lastname', type: 'string' },
                    { name: 'productname', type: 'string' },
                    { name: 'available', type: 'bool' },
                    { name: 'quantity', type: 'number' },
                    { name: 'price', type: 'number' },
                    { name: 'date', type: 'date' }
                ]
            };
            var dataAdapter = new $.jqx.dataAdapter(source);
            // initialize jqxGrid
            $("#grid").jqxGrid(
            {
                width: getWidth('Grid'),
                source: dataAdapter,
                editable: true,
                enabletooltips: true,
                selectionmode: 'multiplecellsadvanced',
                columns: [
                  { text: 'First Name', columntype: 'textbox', datafield: 'firstname', width: 120 },
                  { text: 'Last Name', datafield: 'lastname', columntype: 'textbox', width: 120 },
                  { text: 'Product', columntype: 'dropdownlist', datafield: 'productname', width: 195 },
                  { text: 'Available', datafield: 'available', columntype: 'checkbox', width: 67 },
                  {
                      text: 'Ship Date', datafield: 'date', columntype: 'datetimeinput', width: 110, align: 'right', cellsalign: 'right', cellsformat: 'd',
                  validation: function (cell, value) {
                          if (value == "")
                             return true;
                          var year = value.getFullYear();
                          if (year >= 2020) {
                              return { result: false, message: "Ship Date should be before 1/1/2020" };
                          }
                          return true;
                      }
                  },
                  {
                      text: 'Quantity', datafield: 'quantity', width: 70, align: 'right', cellsalign: 'right', columntype: 'numberinput',
                      validation: function (cell, value) {
                          if (value < 0 || value > 150) {
                              return { result: false, message: "Quantity should be in the 0-150 interval" };
                          }
                          return true;
                      },
                      createeditor: function (row, cellvalue, editor) {
                          editor.jqxNumberInput({ decimalDigits: 0, digits: 3 });
                      }
                  },
                  { text: 'Price', datafield: 'price', align: 'right', cellsalign: 'right', cellsformat: 'c2', columntype: 'numberinput',
                      validation: function (cell, value) {
                          if (value < 0 || value > 15) {
                              return { result: false, message: "Price should be in the 0-15 interval" };
                          }
                          return true;
                      },
                      createeditor: function (row, cellvalue, editor) {
                          editor.jqxNumberInput({ digits: 3 });
                      }
                  }
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
        });
    </script>
</head>
<body class='default'>
    <div id='jqxWidget'>
        <div id="grid"></div>
        <div style="font-size: 12px; font-family: Verdana, Geneva, 'DejaVu Sans', sans-serif; margin-top: 30px;">
            <div id="cellbegineditevent"></div>
            <div style="margin-top: 10px;" id="cellendeditevent"></div>
       </div>
    </div>
</body>
</html>