<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.util.List,com.app.model.Category"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="logout">Logout</a><br><br><br>
<% 
List<Category> l=(List<Category>)request.getAttribute("cat");
%>
<h1>Welcome to Books entry Page</h1>
<form:form action="bookreg" method="post" modelAttribute="book">
<pre>
Title	    : <form:input path="title" required="required" /><form:errors path="title"/>
Description : <form:textarea path="description" required="required"/><form:errors path="description"/>
year		: <form:input path="year" required="required"/> <%-- <form:errors path="year"/> --%>
publisher   : <form:input path="publisher" required="required"/> <form:errors path="publisher"/>
category    :<form:select path="category">
				<form:option value="select" /> 
				<%for(Category c:l){ %>
					<form:option value='<%=c.getC_name() %>' /> 
				<%} %>
		 	</form:select>
quantity	: <form:input path="quantity" required="required"/> <%-- <form:errors path="quantity"/>
 --%>
<input type="submit" value="Create book entry"/>
</pre>

</form:form>
${msg}
</body>
</html>