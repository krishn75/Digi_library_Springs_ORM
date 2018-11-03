<%@page import="java.util.List,com.app.model.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books_Available</title>
</head>
<body>
<a href="logout">Logout</a><br><br><br>
<table border="1">
<tr>

<th>book_id</th>
<th>title</th>
<th>description</th>
<th>year</th>
<th>publisher</th>
<th>category</th>
<th>Return</th>

</tr>
<%
List<Books> result_data=(List<Books>)request.getAttribute("data");
if (result_data != null) {
	for(Books m:result_data)
	{
		%>
		<tr>
		<td><%=m.getBook_id()%></td>
		<td><%=m.getTitle()%></td>
		<td><%=m.getDescription()%></td>
		<td><%=m.getYear()%></td>
		<td><%=m.getPublisher()%></td>
		<td><%=m.getCategory()%></td>
		
		
		<%		
		
		int id=(Integer)m.getBook_id();
		int qty=(Integer)m.getQuantity();
		
		
		%>
		
		
		 <td><button><a href="Return_Book?i=<%=id%>&q=<%=qty%>">RETURN</a></button></td>
		</tr>
		
		
		
		<%
		
		}
		}
		%>



</table>

</body>
</html>