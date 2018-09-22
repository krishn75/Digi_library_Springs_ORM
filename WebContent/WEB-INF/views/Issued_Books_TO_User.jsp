<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issued_Books</title>
</head>
<body><table border="1">
<tr>

<th>book_id</th>
<th>title</th>
<th>description</th>
<th>year</th>
<th>publisher</th>
<th>category</th>

<th>RETURN</th>

</tr>
<%
ArrayList<List<Object[]>> result_data=(ArrayList<List<Object[]>>)request.getAttribute("data");
if (result_data != null) {
	
	for(int j=0;j<result_data.size();j++){
		List<Object[]> obj=result_data.get(j);
		
	for(Object[] m:obj)
	{
		%>
		<tr>
		<%
		for(int i=0;i<m.length-1;i++)
		{
			
%>
		

		<td><%=m[i]%></td>
		
		<%		
		}
		int id=(Integer)m[0];
		int qty=(Integer)m[6];
		
		
		%>
		
		
		
		<td><button><a href="Return_Book?book_id=<%=id%>&quantity=<%=qty%>">RETURN</a></button></td>
		</tr>
		
		
		
		<%
		}
		}
		}
		%>



</table>

</body>
</html>