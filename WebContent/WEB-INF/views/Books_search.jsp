<%@page import="java.util.List,com.app.model.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books_Available</title>
</head>
<body><table border="1">
<a href="logout">logout</a><br><br><br>
<tr>

<th>book_id</th>
<th>title</th>
<th>description</th>
<th>year</th>
<th>publisher</th>
<th>category</th>
<th>quantity</th>
<th>issue/reserve</th>

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
		<td><%=m.getQuantity()%></td>
		
		<%		
		
		int id=(Integer)m.getBook_id();
		int qty=(Integer)m.getQuantity();
		if(qty>0)
		{
		
		%>
		
		<%-- <td><button><a href="Issue_Book?bid=<%=id%>&qty=<%=qty%>&iuserid=10">issue</a></button></td>
		 --%>
		 <td><button><a href="Issue_Book/<%=id%>/<%=qty%>">issue</a></button></td>
		</tr>
		<%
		}
		else
		{
		%>
		<td><button><a href="Reserve_Book?b_id=<%=id%>">reserve</a></button></td>
		</tr>
		<%
		}
		%>
		
		
		<%
		
		}
		}
		%>



</table>

</body>
</html>