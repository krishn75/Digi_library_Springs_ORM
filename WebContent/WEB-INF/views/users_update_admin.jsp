<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="logout">Logout</a><br><br><br>
	<h1>Welcome to update Page</h1>
	<form:form action="Approvereg" method="post" modelAttribute="user">
		<pre>
<form:hidden path="uid" />
<form:hidden path="password"  /><form:errors	path="password" />
userName: <form:input path="username" required="required" /><form:errors path="username" />
Email   : <form:input path="email" required="required" /><form:errors path="email" />
Phno    : <form:input path="phno" required="required" /> <form:errors path="phno" />
Role    :<form:select path="role">
				<form:option value="USER" /> 
				<form:option value="ADMIN" />
		 </form:select>
Approval:<form:select path="approved">
				<form:option value="NO" /> 
				<form:option value="Yes" />
		 </form:select>

<input type="submit" value="Approve" />
</pre>

	</form:form>
	${msg}
</body>
</html>