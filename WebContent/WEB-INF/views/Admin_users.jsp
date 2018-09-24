<%@page import="java.util.List,com.app.model.Users"%>
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
<th>Email_id</th>
<th>Phonenumber</th>
<th>Role</th>
<th>Approved</th>
<th>Update_link</th>


</tr>
<%
List<Users> result_data=(List<Users>)request.getAttribute("users");
if (result_data != null) {
	for(Users m:result_data)
	{
		%>
		<tr>
		


		<td><%=m.getUid()%></td>
		<td><%=m.getUsername()%></td>
		<td><%=m.getEmail()%></td>
		<td><%=m.getPhno()%></td>
		<td><%=m.getRole()%></td>
		<td><%=m.getApproved()%></td>
		
		
		<%		
		
		int id=(Integer)m.getUid();
		
		%>
		
		<td><button><a href="approve?id=<%=id%>">update</a></button></td>
		</tr>
		
		
		<%
		
		}
		}
		%>



</table>

</body>
</html>