<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import=""%>

<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <title>edit From</title>

 <style type="text/css">
 body{
  background-image: url("agriculture-apple-blur-257840.jpg");
  background-size: cover;
  background-repeat: no-repeat;
 
  
 }
 .aa{
  width: 300px;
  height: 250px;
  background-color: rgba(0,0,0,0.5);
  margin: 0 auto;
  margin-top: 40px;
  padding-top: 10px;
  padding-left: 50px;
  -webkit-border-color: 15px;
  -moz-border-color: 15px;
  -ms-border-color: 15px;
  -o-border-color: 15px;
  border-color: 15px;
  color:white;
  font-weight: bolder;
  -webkit-box-shadow: inset -4px -4px rgba(0,0,0,0.5);
  box-shadow: inset -4px -4px rgba(0,0,0,0.5);
  font-size: 18px;
 }
 .aa select{
  width: 150px;
  height: 35px;
  border:0px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  -ms-border-radius: 5px;
  -o-border-radius: 5px;
  border-radius: 5px;
  padding-left: 5px;
 }
 
 .aa input[type="submit"]{
  width: 200px;
  height: 35px;
  border:0px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  -ms-border-radius: 5px;
  -o-border-radius: 5px;
  border-radius: 5px;
  background-color: skyblue;
  font-weight: bolder;
 }</style>

</head>
<body>
<%

System.out.println(request.getParameter("id"));
    int uid = Integer.parseInt(request.getParameter("id"));
	request.setAttribute("id",uid); 

   
  %>
  
 <div class="aa">
 <h2>Edit Form</h2>
 <form action="User_grant_update" method="post">
 <input type="hidden" id="uid"  name="uid" value="<%=uid%>" /><br/>
  Userrole: 		
  <select name="role" >
           <option>Select</option>
           <option>USER</option>
           <option>ADMIN</option></select>  <br><br>
  	Approve: <select name="approved" >
          <option>Select</option>
           <option>NO</option>
           <option>YES</option></select>  <br><br>
   
  <input type="submit" value="Save Changes"><br>
  </form><!-- close form -->
  
 </div><!-- close aa -->
</body>
</html>