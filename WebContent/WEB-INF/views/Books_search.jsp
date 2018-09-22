<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books_Available</title>
</head>
<body><table border="1">
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
List<Object[]> result_data=(List<Object[]>)request.getAttribute("data");
if (result_data != null) {
	for(Object[] m:result_data)
	{
		%>
		<tr>
		<%
		for(int i=0;i<m.length;i++)
		{
%>


		<td><%=m[i]%></td>
		
		<%		
		}
		int id=(Integer)m[0];
		int qty=(Integer)m[6];
		if(qty>0)
		{
		
		%>
		
		<td><button><a href="Issue_Book?book_id=<%=id%>&qty=<%=qty%>&iuserid=10">issue</a></button></td>
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