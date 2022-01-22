<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  
<!-- Mirrored from pratikborsadiya.in/vali-admin/employerdash.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 15 May 2020 11:18:49 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>


    <meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="blog/vali-admin/hero-social.png">
    <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>Vetan</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="css/main.css">
	<link href="https://fonts.googleapis.com/css?family=Work+Sans:400,600,700&display=swap" rel="stylesheet">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="jqwidgets/styles/jqx.base.css" type="text/css" />
    <!-- <link rel="stylesheet" href="jqwidgets/styles/jqx.classic.css" type="text/css" /> -->
    <link rel="stylesheet" href="jqwidgets/styles/jqx.energyblue.css" type="text/css" />
	
	
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1 minimum-scale=1" />	
    <script type="text/javascript" src="scripts/jquery-1.12.4.min.js"></script>
 
    <script type="text/javascript">
        function myFunction() {
          var x = document.getElementById("myDIV");
           var y = document.getElementById("myDIV1");
           var r = document.getElementById("myDIV2");
           var z= document.getElementById("fr");
           var r1 = document.getElementById("st");
           var mo = document.getElementById("mr");
           var mo1 = document.getElementById("mr1");
          if (x.style.display === "none") {
            x.style.display = "block";
	    y.style.display = "block";
      z.style.display ="block";
      mo.style.display ="block";
      mo1.style.display ="block";
      r.style.display ="none";
      r1.style.display ="none";
      
          } else {
            x.style.display = "none";
	    y.style.display = "none";
      z.style.display = "none";
      mo.style.display="none";
      mo1.style.display="none";
          }
        }
    	function myFunction1() {
          var x = document.getElementById("myDIV1");
          var y = document.getElementById("st");
          if (x.style.display === "none") {
            x.style.display = "block";
	    y.style.display = "block";
          } else {
            x.style.display = "none";
            y.style.display = "none";
          }
        }
	function myFunction2() {
          var x = document.getElementById("myDIV2");
          var y = document.getElementById("myDIV1");
          var z = document.getElementById("myDIV");
          var r = document.getElementById("st");
          var r1 = document.getElementById("fr");
          var mo = document.getElementById("mr");
          var mo1 = document.getElementById("mr1");

          
          if (x.style.display === "none") {
            x.style.display = "block";
            r.style.display = "block";
            r1.style.display = "none";
	    y.style.display = "none";
	    z.style.display="none";
      mo.style.display="none";
      mo1.style.display="none";
          } else {
            x.style.display = "none";
            r.style.display = "none";
            
          }
        }
        function go(loc) {
       document.getElementById('urlf').src = loc;
        }
        // function for menu 1
        function menf1() {
          var x = document.getElementById("con1");
           var y = document.getElementById("con2");
           var z = document.getElementById("con3");
           var a = document.getElementById("con4");
        //    var r = document.getElementById("myDIV2");
        //    var z= document.getElementById("fr");
        //    var r1 = document.getElementById("st");
          if (x.style.display === "none") {
            x.style.display = "block";
	    y.style.display = "none";
	    z.style.display = "none";
        a.style.display = "none";
    
    //   z.style.display ="block";
    //   r.style.display ="none";
    //   r1.style.display ="none";
      
          } else {
            x.style.display = "none";
	//     y.style.display = "none";
    //   z.style.display = "none";
          }
        }
        // menu function 2
        function menf2() {
            var x = document.getElementById("con2");
           var y = document.getElementById("con1");
           var z = document.getElementById("con3");
           var a = document.getElementById("con4");
        //    var r = document.getElementById("myDIV2");
        //    var z= document.getElementById("fr");
        //    var r1 = document.getElementById("st");
          if (x.style.display === "none") {
            x.style.display = "block";
	    y.style.display = "none";
	    z.style.display = "none";
        a.style.display = "none";
    
    //   z.style.display ="block";
    //   r.style.display ="none";
    //   r1.style.display ="none";
      
          } else {
            x.style.display = "none";
	//     y.style.display = "none";
    //   z.style.display = "none";
          }
        }
// menu function 3
        function menf3() {
            var x = document.getElementById("con3");
           var y = document.getElementById("con1");
           var z = document.getElementById("con2");
           var a = document.getElementById("con4");
        //    var r = document.getElementById("myDIV2");
        //    var z= document.getElementById("fr");
        //    var r1 = document.getElementById("st");
          if (x.style.display === "none") {
            x.style.display = "block";
	    y.style.display = "none";
	    z.style.display = "none";
        a.style.display = "none";
    //   z.style.display ="block";
    //   r.style.display ="none";
    //   r1.style.display ="none";
      
          } else {
            x.style.display = "none";
	//     y.style.display = "none";
    //   z.style.display = "none";
          }
        }

        function menf4() {
            var x = document.getElementById("con4");
           var y = document.getElementById("con1");
           var z = document.getElementById("con2");
           var a = document.getElementById("con3");
        //    var r = document.getElementById("myDIV2");
        //    var z= document.getElementById("fr");
        //    var r1 = document.getElementById("st");
          if (x.style.display === "none") {
            x.style.display = "block";
	    y.style.display = "none";
	    z.style.display = "none";
	    a.style.display = "none";
    //   z.style.display ="block";
    //   r.style.display ="none";
    //   r1.style.display ="none";
      
          } else {
            x.style.display = "none";
	//     y.style.display = "none";
    //   z.style.display = "none";
          }
        }
</script>
<script type="text/javascript">
  $("input[type='image']").click(function() {
              $("input[id='my_file']").click();
               });
  </script>
  <style>
          .comment {
          resize: none;
          height: 100px;
          width: 100%;
        }
          .sc {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: auto;
    height:auto;
  }
  
  td, th {
    border: 1px solid #0c0606;
    text-align: left;
  
  }
  th {
    background-color: #e7d19a;
  }
          canvas{
  
  width:350px !important;
  height:150px !important;
  
  }
          .top-buffer { margin-top:30px; }
  #myDIV {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 400px;
  }
  #myDIV td, #myDIV th {
    border: 1px solid #ddd;
    padding: 8px;
  }
  
  #myDIV tr:nth-child(even){background-color: #f2f2f2;}
  
  #myDIV tr:hover {background-color: #ddd;}
  
  #myDIV th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #305695;
    color: white;
  }
  #myDIV1 {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 400px;
  }
  #myDIV1 td, #myDIV1 th {
    border: 1px solid #ddd;
    padding: 8px;
  }
  
  #myDIV1 tr:nth-child(even){background-color: #f2f2f2;}
  
  #myDIV1 tr:hover {background-color: #ddd;}
  
  #myDIV1 th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #305695;
    color: white;
  }
  #myDIV2 {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 1000px;
  }
  #myDIV2 td, #myDIV1 th {
    border: 1px solid #ddd;
  
  }
  
  #myDIV2 tr:nth-child(even){background-color: #f2f2f2;}
  
  #myDIV2 tr:hover {background-color: #ddd;}
  
  #myDIV2 th {
  
    text-align: left;
    background-color: #305695;
    color: white;
  }
  .but {
    width: 250px;
    text-align: center;
    color: white;
    background-color:#305695;
  }
  .but:focus {
    background: #bbb9bc;
  }
  
  </style>
   <style>
          .top-buffer { margin-top:30px; }
  #myDIV {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 400px;
  }
  #myDIV td, #myDIV th {
    border: 1px solid #ddd;
    padding: 8px;
  }
  
  #myDIV tr:nth-child(even){background-color: #f2f2f2;}
  
  #myDIV tr:hover {background-color: #ddd;}
  
  #myDIV th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #0000FF;
    color: white;
  }
  #myDIV1 {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 400px;
  }
  #myDIV1 td, #myDIV1 th {
    border: 1px solid #ddd;
    padding: 8px;
  }
  
  #myDIV1 tr:nth-child(even){background-color: #f2f2f2;}
  
  #myDIV1 tr:hover {background-color: #ddd;}
  
  #myDIV1 th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #0000FF;
    color: white;
  }
  #myDIV2 {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 1000px;
  }
  #myDIV2 td, #myDIV1 th {
    border: 1px solid #ddd;
  
  }
  
  #myDIV2 tr:nth-child(even){background-color: #f2f2f2;}
  
  #myDIV2 tr:hover {background-color: #ddd;}
  
  #myDIV2 th {
  
    text-align: left;
    background-color: #0000FF;
    color: white;
  }
  .but {
    width: 250px;
    text-align: center;
    color: white;
    background-color:#0000FF;
  }
  
  </style>
  
  
  


    <style>
      
      
      .sidenav {
        height: 90%;
        width: 0;
        position: fixed;
        z-index: 1;
        top: 10%;
        right: 0;
        background-color: #111;
        overflow-x: hidden;
        transition: 0.5s;
        padding-top: 60px;
      }
      
      .sidenav a {
        padding: 8px 8px 8px 32px;
        text-decoration: none;
        font-size: 25px;
        color: #818181;
        display: block;
        transition: 0.3s;
      }
      
      .sidenav a:hover {
        color: #f1f1f1;
      }
      
      .sidenav .closebtn {
        position: absolute;
        top: 0;
        right: 25px;
        font-size: 25px;
        margin-left: 50px;
      }
      
      #main {
        transition: margin-left .5s;
        padding: 16px;
      }
      
      @media screen and (max-height: 450px) {
        .sidenav {padding-top: 15px;}
        .sidenav a {font-size: 18px;}
      }
      </style>
	  
	  <style>
body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 0px solid #ccc;
 /* background-color: #f1f1f1;*/
 background-color: 	rgba(198, 217, 226, 0.884);
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
  font-size: 16px;
}



* {
  box-sizing: border-box;
}
body {
  font-family: "Open Sans";
  background: #2c3e50;
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
<body class="app sidebar-mini"  onload="go('employerdash')" >
  <!-- Navbar-->
  <header class="app-header1" style="height: 55px;"><a class="app-header__logo" href="dashboard" style="font-family: Georgia, 'Times New Roman', Times, serif; width: 230px; background-color: #055bac;height:50px;"><img src="images/vetan.jpg" width="230px" height="50px" style="margin-top: -2px; margin-bottom: -2px; margin-left: -15px; "></a>
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar">&#9776;</a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">
      <li class="app-search">


    

<div class="tab" width="1500">
  <button class="tablinks"  target="main" onclick="go('employerdash')">Vetan</button>
  <button class="tablinks" target="main" onclick="go('statutory')">Statutory Reports</button>
  <button class="tablinks"  target="main" onclick="go('others')">Other Reports</button>
  
  <button class="tablinks"  target="main" onclick="go('report/gridit')">Income Tax</button>
  
  <button class="tablinks" target="main" onclick="go('PF')">PF Trust</button>
  <button class="tablinks"  target="main" onclick="go('grat/gridgrat')">Gratuity</button>
  <button class="tablinks"  target="main" onclick="go('pension/gridpen')">Pension</button>
  <button class="tablinks" target="main" onclick="go('fnf/gridfnf')">FnF</button>



</div>


      <!-- User Menu-->
      <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
        <ul class="dropdown-menu settings-menu dropdown-menu-right" >
          <li><a class="dropdown-item" href="page-user"><i class="fa fa-cog fa-lg"></i> Settings</a></li>
          <li><a class="dropdown-item" href="page-user"><i class="fa fa-user fa-lg"></i> Profile</a></li>
          <li><a class="dropdown-item" href="index"><i class="fa fa-sign-out fa-lg"></i> Logout</a></li>
        </ul>
      </li>
      <!-- <li class="dropdown"><a class="app-nav__item1" href="#" data-toggle="dropdown" aria-label="Open Profile Menu">&#9776;</a> -->
    
        <li class="dropdown"><a class="app-nav__item" href="index"><i class="fa fa-power-off" style="font-size:20px"></i></a>
        </li>
    
      </ul>
   
    



    <a class="app-sidebar__toggle" href="#" aria-label="Hide Sidebar"><span style="cursor:pointer" onclick="openNav()">&#9776;</span></a>
  </header>
  <!-- Right Sidebar trail -->
  <div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <div class="btn-group-vertical" style="padding: 15%;">
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="background-color:rgba(198, 217, 226, 0.884);color:#212529;">REPORT 1</button><br>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="background-color:rgba(198, 217, 226, 0.884);color:#212529;">REPORT 2</button><br>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="background-color:rgba(198, 217, 226, 0.884);color:#212529;">REPORT 3</button><br>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="background-color:rgba(198, 217, 226, 0.884);color:#212529;">REPORT 4</button><br>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="background-color:rgba(198, 217, 226, 0.884);color:#212529;">REPORT 5</button><br>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="background-color:rgba(198, 217, 226, 0.884);color:#212529;">REPORT 6</button><br>
	  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="background-color:rgba(198, 217, 226, 0.884);color:#212529;">REPORT 7</button><br>
	  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="background-color:rgba(198, 217, 226, 0.884);color:#212529;">REPORT 8</button><br>
	  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="background-color:rgba(198, 217, 226, 0.884);color:#212529;">REPORT 9</button><br>
	  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="background-color:rgba(198, 217, 226, 0.884);color:#212529;">REPORT 10</button><br>
    </div>
  </div>
  





  <script src="js/plugins/pace.min.js"></script>
  <!-- Page specific javascripts-->
  <!-- Data table plugin-->
  <script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>
  <script type="text/javascript">$('#sampleTable').DataTable();</script>
  <!-- Google analytics script-->
  <script type="text/javascript">
    if(document.location.hostname == 'pratikborsadiya.in') {
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','www.google-analytics.com/analytics.js','ga');
      ga('create', 'UA-72504830-1', 'auto');
      ga('send', 'pageview');
    }
  </script>


  <!-- **************************** -->
  <script>
    function openNav() {
      document.getElementById("mySidenav").style.width = "190px";
      document.getElementById("main").style.marginRight = "150px";
    }
    
    function closeNav() {
      document.getElementById("mySidenav").style.width = "0";
      document.getElementById("main").style.marginRight= "0";
    }
    </script>

<script>
  // Get the modal
  var modal = document.getElementById("myModal");
  
  // Get the button that opens the modal
  var btn = document.getElementById("myBtn");
  
  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];
  
  // When the user clicks the button, open the modal 
  btn.onclick = function() {
    modal.style.display = "block";
  }
  
  // When the user clicks on <span> (x), close the modal
  span.onclick = function() {
    modal.style.display = "none";
  }
  
  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
  </script>

  <!-- modal 2  start-->
  <script>
  // Get the modal
  var modal = document.getElementById("myModal");
  
  // Get the button that opens the modal
  var btn = document.getElementById("myBtn");
  
  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];
  
  // When the user clicks the button, open the modal 
  btn.onclick = function() {
    modal.style.display = "block";
  }
  
  // When the user clicks on <span> (x), close the modal
  span.onclick = function() {
    modal.style.display = "none";
  }
  
  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
  </script>
  <!-- modal 2 end -->

  <div id="main" >
    <main class="app-content">
   
       <div id="con1">
        <div class="container-fluid text-center">    
          <iframe id="urlf" src="about:blank" width="100%" height="900" frameborder="0" scrolling="no"></iframe>    

  </div>

    </main>
    </div>
  
  


  <!-- Sidebar menu-->
  <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
  <aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg" alt="User Image">
      <div>
        <p class="app-sidebar__user-name">USER</p>
        <p class="app-sidebar__user-designation">Senior Analyst</p>
      </div>
    </div>
    <ul class="app-menu">
      <li><a class="app-menu__item active" href="employerdash"><i class="app-menu__icon fa fa-dashboard"></i><span class="app-menu__label">Vetan</span></a></li>
      <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-laptop"></i><span class="app-menu__label">Loan</span></a>
      </li>
      <li><a class="app-menu__item" href="charts.jsp"><i class="app-menu__icon fa fa-pie-chart"></i><span class="app-menu__label">income Tax</span></a></li>
      <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">fnfSettlement</span> </i></a>
  </li>
      <li class="treeview"><a class="app-menu__item" href="#" data-toggle="treeview"><i class="app-menu__icon fa fa-file-text"></i><span class="app-menu__label"> Earnings</span></i></a>

      </li>
      <li><a class="app-menu__item" href="docs.jsp"><i class="app-menu__icon fa fa-file-code-o"></i><span class="app-menu__label">Deductions</span></a></li>
    </ul>
  </aside>
  <!-- right slidebar -->



  <!-- <script src="js/jquery-3.3.1.min.js"></script> -->

  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>
  <!-- The javascript plugin to display page loading on top-->
  <script src="js/plugins/pace.min.js"></script>


  



  <!-- Google analytics script-->
  <script type="text/javascript">
    if(document.location.hostname == 'pratikborsadiya.in') {
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','www.google-analytics.com/analytics.js','ga');
      ga('create', 'UA-72504830-1', 'auto');
      ga('send', 'pageview');
    }
  </script>
  
</body>

<!-- Mirrored from pratikborsadiya.in/vali-admin/employerdash.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 15 May 2020 11:18:49 GMT -->
</html>