<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  
<!-- Mirrored from pratikborsadiya.in/vali-admin/dashboard.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 15 May 2020 11:18:49 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>


 
 
 
	
		<script type="text/javascript" src="../jqwidgets/jquery-1.12.4.min.js"></script>

    <script type="text/javascript">


// menu function 3

          var y = document.getElementById("con1");
 
	    y.style.display = "none";

      function go(loc) {
       document.getElementById('urlf').src = loc;
        }
         
</script>



	  
	  <style>
body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 0px solid #ccc;
 /* background-color: #f1f1f1;*/
 background-color: 	rgba(255, 255, 255, 0.884);
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 12px 22px;
  transition: 0.3s;
  font-size: 16px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}

.tab1 {
  overflow: hidden;
  border: 0px solid #ccc;
 /* background-color: #f1f1f1;*/
 background-color: 	#055bac;
}
/* Style the buttons inside the tab */
.tab1 button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 14px;
}



* {
  box-sizing: border-box;
}
body {
  font-family: "Open Sans";
  background: ##ffffff;
  color: #ecf0f1;
  line-height: 1.618em;
}
.wrapper {
  max-width: 50rem;
  width: 190%;
  margin: 0 auto;
}
.tabs {
  position: relative;
  margin: 3rem 0;
  background: #1abc9c;
  height: 14.75rem;
}
.tabs::before,
.tabs::after {
  content: "";
  display: table;
}
.tabs::after {
  clear: both;
}
.tab {
  float: left;
}
.tab-switch {
  display: none;
}
.tab-label {
  position: relative;
  display: block;
  line-height: 2.75em;
  height: 3em;
  padding: 0 1.618em;
  background: #1abc9c;
  border-right: 0.125rem solid #16a085;
  color: #fff;
  cursor: pointer;
  top: 0;
  transition: all 0.25s;
}
.tab-label:hover {
  top: -0.25rem;
  transition: top 0.25s;
}
.tab-content {
  height: 12rem;
  position: absolute;
  z-index: 1;
  top: 2.75em;
  left: 0;
  padding: 1.618rem;
  background: #fff;
  color: #2c3e50;
  border-bottom: 0.25rem solid #bdc3c7;
  opacity: 0;
  transition: all 0.35s;
}
.tab-switch:checked + .tab-label {
  background: #fff;
  color: #2c3e50;
  border-bottom: 0;
  border-right: 0.125rem solid #fff;
  transition: all 0.35s;
  z-index: 1;
  top: -0.0625rem;
}
.tab-switch:checked + label + .tab-content {
  z-index: 2;
  opacity: 1;
  transition: all 0.35s;
}
</style>
<!-- grid chart -->

<!-- grid chart end -->
  
</head>
<body class="app sidebar-mini"  onload="go('grid/vetanpie')">


  <div id="main">
    <main class="app-content">
   
       <div id="con1">
        <div class="container-fluid text-center">    
 
   

     
   
    <div class="tab"   style="width:100%;">

 
    <button class="tablinks"  id="pat" data-toggle="modal" data-target="#myModal1" onclick="go('grid/vetanpie')">Dashboard</button>
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/gridemp')">11 Bipartite</button>
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/gridmy10')">10 Bipartite</button>
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/gridmyarr')">Arrears</button>
      <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/gridmyvar')">Variance</button>
       <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('report/gridmyit')">IT</button>
   <!--   <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/row.jsp')">Scale3</button>
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/row.jsp')">Scale4</button>
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/row.jsp')">Scale5</button>
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/row.jsp')">Scale6</button>
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/row.jsp')">Scale7</button>-->
    <!--<button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/row.jsp')">PTS</button>
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/row.jsp')">FTS</button>
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/row.jsp')">FTS13</button>
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/row.jsp')">FTS23</button>  
    <button class="tablinks" id="pat" data-toggle="modal" data-target="#myModal" onclick="go('grid/row.jsp')">FT34</button>-->
    


  

    
  </div>
  <iframe id="urlf" src="about:blank" width="100%" height="900" frameborder="0" scrolling="no"></iframe>   
  </div>
  </div>

    </main>
    </div>
  
  




  



</body>

<!-- Mirrored from pratikborsadiya.in/vali-admin/dashboard.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 15 May 2020 11:18:49 GMT -->
</html>