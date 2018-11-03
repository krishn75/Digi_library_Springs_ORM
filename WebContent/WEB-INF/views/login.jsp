<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login page</title>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.3/angular-route.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular-animate.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.4.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
  

<script type="text/javascript" src="WEB-INF/js/schemeMonitorForm.js"></script>
<style type="text/css">
body {
	background-image: url("login.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}

.aa {
	width: 300px;
	height: 300px;
	background-color: rgba(0, 0, 0, 0.5);
	margin: 0 auto;
	margin-top: 40px;
	padding-top: 10px;
	padding-left: 50px;
	-webkit-border-color: 15px;
	-moz-border-color: 15px;
	-ms-border-color: 15px;
	-o-border-color: 15px;
	border-color: 15px;
	color: white;
	font-weight: bolder;
	-webkit-box-shadow: inset -4px -4px rgba(0, 0, 0, 0.5);
	box-shadow: inset -4px -4px rgba(0, 0, 0, 0.5);
	font-size: 18px;
}

.aa input[type="text"] {
	width: 200px;
	height: 35px;
	border: 0px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-ms-border-radius: 5px;
	-o-border-radius: 5px;
	border-radius: 5px;
	padding-left: 5px;
}

.aa input[type="password"] {
	width: 200px;
	height: 35px;
	border: 0px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-ms-border-radius: 5px;
	-o-border-radius: 5px;
	border-radius: 5px;
	padding-left: 5px;
}

.aa input[type="submit"] {
	width: 200px;
	height: 35px;
	border: 0px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-ms-border-radius: 5px;
	-o-border-radius: 5px;
	border-radius: 5px;
	background-color: skyblue;
	font-weight: bolder;
}

.aa a {
	width: 200px;
	height: 35px;
	border: 0px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	-ms-border-radius: 5px;
	-o-border-radius: 5px;
	border-radius: 5px;
	background-color: red;
	font-weight: bolder;
}
</style>

</head>
<body ng-app="digi_Module">
	<div class="aa">
		<marquee>
			<h1>Enter your credentials</h1>
		</marquee>
		<form name="f" action="<%=request.getContextPath()%>/loginPros"
			method="post">
			<input type="text" placeholder="Enter User_ID" id="username"
				name="username" required="required" pattern="[A-Z,0-9,a-z].{3,7}"
				title="enter userid of 4 to 8 digit number" /><br> <br> <input
				type="password" placeholder="Enter Your password" id="password"
				name="password" required="required" pattern="[0-9,a-z,A-Z,#,*]{3,}"
				title="you are allowed to use 0-9,A-Z,a-z,#,*" /><br> <br>
			<input type="submit" value="login"><br> <br> <a
				href="reg">sign up</a>
				</form>
		<!-- close form -->
		<c:if test="${param.error}">Invalid username and password.</c:if>
<c:if test="${param.logout}">You have been logged out.</c:if>
  

	</div>
	<!-- close aa -->
	<ng-view></ng-view>
</body>
</html>































