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
<h1>Welcome to category Page</h1>
<form:form action="catreg" method="post" modelAttribute="category">
<pre>
CategoryName: <form:input path="C_name" required="required" /><form:errors path="C_name"/>

<input type="submit" value="Create category"/>
</pre>

</form:form>
${msg}
</body>
</html>