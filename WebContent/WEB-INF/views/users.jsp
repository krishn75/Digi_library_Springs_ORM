<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Register Page</h1>
<form:form action="user_reg" method="post" modelAttribute="user">
<pre>
userName: <form:input path="username" required="required" /><form:errors path="username"/>
Email   : <form:input path="email" required="required"/><form:errors path="email"/>
Password: <form:password path="password" required="required"/> <form:errors path="password"/>
Phno    : <form:input path="phno" required="required"/> <form:errors path="phno"/>
<form:hidden path="role" value="" /> 
<form:hidden path="approved" value="No"  /> 

<input type="submit" value="Create User"/>
</pre>

</form:form>
${msg}
</body>
</html>