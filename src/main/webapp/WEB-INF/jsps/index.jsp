<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Page -Vetan</title>
    <!--

    Template 2108 Dashboard

	http://www.tooplate.com/view/2108-dashboard

    -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600">
   <!--<link rel="stylesheet"  href="css/font-awesome.min.css">
     <link rel="stylesheet"  href="css/bootstrap.min.css">
     <link rel="stylesheet"  href="css/tooplate.css"> -->
     <link rel="stylesheet"  href="css/my_style.css">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

	<script type="text/javascript">
	    function redirect() {
		   // var textValue = document.getElementById("emp").value;
		    var textValue= document.querySelector('input[name="emp"]:checked').value
		   // alert("textValue::"+textValue);
           if(textValue == "employer")
		    {
		        location.href = "dashboard";

		    }
		    else if(textValue == "employee")
		    {
		        location.href = "employeedash";
		    }
		}
	</script>

</head>
<style>
.login{  
        width: 310px;  
        overflow: hidden;  
       /* margin: auto;  */
        margin: 20 0 0 30px;  
        padding: 5px;  
         margin-left:880px; 
        /*background-color: grey; */
		margin-top:230px;
          
}  
h2{  
    text-align: center;  
    color: #277582;  
    padding: 20px;  
}  
label{  
    color: white;  
    font-size: 17px;  
}  
#Uname{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 8px;  
}  
#Pass{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 8px;  
      
}  
#log{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 17px;  
    padding-left: 7px;  
    color: blue;  
  
  
}  
span{  
    color: white;  
    font-size: 17px;  
}  
a{  
    float: right;  
    background-color: grey;  
}  
</style>
<body background="images/salary.jpeg">


    <!-- <h2 style="color:#ffffff;"><img src="images/vetan.jpg" width="230px" height="50px" style="margin-top: 130px; margin-bottom: -2px; margin-left: 130px; "></h2>  -->
    <div class="login">    
    <form id="login" method="post" action="javascript:redirect();">   
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label><input type="radio" name="emp" id="employer"  value="employer" checked> <b>Employer     </label>   
        </b>
		<label><input type="radio" name="emp" id="employee"  value="employee" > <b>Employee     </label>  
        </b>		
       <br>  
		<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user fa-xs"></i></span>
							<input type="text" name="userName" id="userId"
								placeholder="Enter User ID" required="required"
							
								class="form-control input-lg" />
						</div>	
	<br />						
						<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-key fa-xs"></i></span>
					<input type="password" name="password" id="password"
					
						onkeydown="if (event.keyCode == 13) formSubmit();"
						placeholder="Enter Your Password" required="required"
						class="form-control input-lg" />
				</div>
				<br /> <input type="submit" id="submit" value="Login"
					class="btn btn-sm btn-success btn-block" /> <br />
					 
    </form>     
</div>
        <div class="user">
            <p style="text-align:left;"><i>
                
                <span style="float:right;">V.0.04 | About Us | Contact | Copyright   .              
                </span>
            </i> </p>
        </div>
</body>

</html>