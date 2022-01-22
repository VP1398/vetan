<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Vetan IBA</title>
       <link rel="stylesheet" href="/vetan/resources/jqwidgets/styles/jqx.base.css" type="text/css" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />
    
	<script type="text/javascript" src="../scripts/jquery-1.12.4.min.js"></script>
         <%@include file="externalJsImports.jsp"%>
        
        
        <script type="text/javascript" src="../jqwidgets/jqxgrid.filter.js"></script>
        <script type="text/javascript" src="../jqwidgets/jqxgrid.grouping.js"></script>
        <script type="text/javascript" src="../jqwidgets/jqxgrid.columnsreorder.js"></script>
 		<script type="text/javascript" src="../jqwidgets/jqxgrid.aggregates.js"></script>
 		
    
        <script type="text/javascript">
            $( document ).ready( function () {
                var data = new Array();
                var firstNames = [
                    "Andrew", "Nancy", "Shelley", "Regina", "Yoshi", "Antoni", "Mayumi", "Ian", "Peter", "Lars", "Petra", "Martin", "Sven", "Elio", "Beate", "Cheryl", "Michael", "Guylene" ];
                var lastNames = [
                    "Fuller", "Davolio", "Burke", "Murphy", "Nagase", "Saavedra", "Ohno", "Devling", "Wilson", "Peterson", "Winkler", "Bein", "Petersen", "Rossi", "Vileid", "Saylor", "Bjorn", "Nodier" ];
                var productNames = [
                    "Black Tea", "Green Tea", "Caffe Espresso", "Doubleshot Espresso", "Caffe Latte", "White Chocolate Mocha", "Cramel Latte", "Caffe Americano", "Cappuccino", "Espresso Truffle", "Espresso con Panna", "Peppermint Mocha Twist" ];
                var priceValues = [
                    "2.25", "1.5", "3.0", "3.3", "4.5", "3.6", "3.8", "2.5", "5.0", "1.75", "3.25", "4.0" ];
                for ( var i = 0; i < 1000; i++ ) {
                    var row = {};
                    var productindex = Math.floor( Math.random() * productNames.length );
                    var price = parseFloat( priceValues[ productindex ] );
                    var quantity = 1 + Math.round( Math.random() * 10 );
                    row[ "firstname" ] = firstNames[ Math.floor( Math.random() * firstNames.length ) ];
                    row[ "lastname" ] = lastNames[ Math.floor( Math.random() * lastNames.length ) ];
                    row[ "productname" ] = productNames[ productindex ];
                    row[ "price" ] = price;
                    row[ "quantity" ] = quantity;
                    row[ "total" ] = price * quantity;
                    data[ i ] = row;
                }
                var source = {
                    localdata: data,
                    datatype: "array"
                };
                var dataAdapter = new $.jqx.dataAdapter( source, {
                    loadComplete: function ( data ) { },
                    loadError: function ( xhr, status, error ) { }
                } );
                $( "#jqxgrid" ).jqxGrid( {
                    altrows: true,
                    width: 800,
                    source: dataAdapter,
                    editable: true,
					sortable: true,
					selectionmode: 'multiplecellsadvanced',
                    cardview: true,
					cardviewcolumns: [
                        {
                            width: 'auto',
                            datafield: 'firstname'
                        },
                        {
                            width: 'auto',
                            datafield: 'lastname'
                        },
                        {
                            width: 300,
                            datafield: 'productname'
                        }
                    ],
                    columns: [ {
                        text: 'First Name',
                        datafield: 'firstname',
                        width: 100
                    }, {
                        text: 'Last Name',
                        datafield: 'lastname',
                        width: 100
                    }, {
                        text: 'Product',
                        datafield: 'productname',
                        width: 180
                    }, {
                        text: 'Quantity',
                        datafield: 'quantity',
                        width: 120,
                        cellsalign: 'right'
                    }, {
                        text: 'Unit Price',
                        datafield: 'price',
                        width: 90,
                        cellsalign: 'right',
                        cellsformat: 'c2'
                    }, {
                        text: 'Total',
                        datafield: 'total',
                        cellsalign: 'right',
                        cellsformat: 'c2'
                    } ]
                } );
				
				
				$("#jqxbutton").jqxButton();
				$("#jqxbutton").on('click', function() {
					var cardView = $("#jqxgrid").jqxGrid('cardview');
					
					$("#jqxgrid").jqxGrid({cardview: !cardView});
				});
				
            } );
        </script>
    </head>
    <body class='default'>
        <div id="jqxgrid"></div>
		<br/>
	   <button id="jqxbutton">Switch CardView</button>
    </body>
</html>