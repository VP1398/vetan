<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>Vetan Chart</title>

    <style type="text/css">
        .labels {
            font-size: smaller;
        }
    </style>
        <link rel="stylesheet" href="../jqwidgets/styles/jqx.base.css" type="text/css" />
    
	<script type="text/javascript" src="../scripts/jquery-1.12.4.min.js"></script>
         <%@include file="externalJsImports.jsp"%>
        
        
        <script type="text/javascript" src="../jqwidgets/jqxgrid.filter.js"></script>
        <script type="text/javascript" src="../jqwidgets/jqxgrid.grouping.js"></script>
        <script type="text/javascript" src="../jqwidgets/jqxgrid.columnsreorder.js"></script>
 		<script type="text/javascript" src="../jqwidgets/jqxgrid.aggregates.js"></script>
 		
    

    <script type="text/javascript">
        $(document).ready(
            function() {
                var source = {
                    datatype: "json",
                    datafields: [{
                        name: 'componentName',
                        type: 'string'
                    }, {
                        name: 'componentValue',
                        type: 'int'
                    }],
                    url: '${pageContext.request.contextPath}/chart/getScaleamt',
                    type: 'POST',
                    async: true
                };
                var dataAdapter = new $.jqx.dataAdapter(source);

                var settings = {
                    title: "Salary by Category",
                    description: "in Category ",
                    padding: {
                        left: 5,
                        top: 5,
                        right: 15,
                        bottom: 5
                    },
                    titlePadding: {
                        left: 90,
                        top: 0,
                        right: 0,
                        bottom: 10
                    },
                    source: dataAdapter,
                    xAxis: {
                        dataField: 'componentName',
                        displayText: 'Category',
                        gridLines: {
                            visible: true
                        },
                        valuesOnTicks: false,
                        type: 'basic',
                        labels: {
                            class: 'labels',
                            angle: 90,
                            formatFunction: function(value) {
                                return value.replace(/\?/g, '');
                            }
                        },
                        flip: false
                    },
                    colorScheme: 'scheme01',
                    seriesGroups: [{
                        type: 'column',
                        columnsGapPercent: 30,
                        seriesGapPercent: 0,
                        orientation: 'horizontal',
                        valueAxis: {
                            minValue: 0,
                            unitInterval: 10,
                            description: 'Total Categorywise',
                            flip: true
                        },
                        series: [{
                            dataField: 'componentValue',
                            displayText: 'Total Categorywise'
                        }]
                    }]
                };

                $('#chartContainer').jqxChart(settings);
            });
    </script>
</head>
<body>
    <div id='chartContainer' style="width: 860px; height: 600px; margin-bottom: 25px;"></div>
</body>
</html>