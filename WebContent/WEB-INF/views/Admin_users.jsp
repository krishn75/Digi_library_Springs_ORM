<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>users_list</title>
</head>
<body><table border="1">
<tr>
<th>user_id</th>
<th>username</th>
<th>password</th>
<th>Email_id</th>
<th>Phonenumber</th>
<th>Role</th>
<th>Approved</th>
<th>Update_link</th>


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
		
		%>
		
		<td><button><a href="Admin_update_user.jsp?id=<%=id%>">update</a></button></td>
		</tr>
		
		
		<%
		
		}
		}
		%>



</table>

</body>
</html>