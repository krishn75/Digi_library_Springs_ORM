<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#username").change(function(){
		$.ajax({
			url:"checkId",
			data:{eun:$("#username").val()},
			success:function(resTxt){
				$("#msg").text(resTxt);
				if(resTxt!=""){
					$("#username").val("");
					$("#username").focus();
				}
					
			}
		});
	});
});
</script>

</head>
<body>
<div ng-controller="user_Controller">
<h1>Welcome to Register Page</h1>
<form name="uform  method="post" >
<pre>
userName: <input ng-model="username" id="username" required="required"  /><errors path="username"/>
Email   : <input ng-model="username" required="required"/><errors path="email"/>
Password: <password ng-model="password" required="required"/> <errors path="password"/>
Phno    : <input ng-model="phno" required="required"/> <errors path="phno"/>
<hidden ng-model="role" value="" /> 
<hidden ng-model="approved" value="No"  /> 


<button type="submit" ng-click="user()">save</button>
<span id="msg"/>
</pre>

</form>
${msg}
</div>
</body>
</html>