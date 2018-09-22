<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <title>Book Details</title>

 <style type="text/css">
 body{
  
  background-size: cover;
  background-repeat: no-repeat;
 
  
 }
 .aa{
  width: 300px;
  height: 350px;
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
 .aa input[type="text"]{
  width: 200px;
  height: 35px;
  border:0px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  -ms-border-radius: 5px;
  -o-border-radius: 5px;
  border-radius: 5px;
  padding-left: 5px;
 }
 .aa input[type="password"]{
  width: 200px;
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
 <div class="aa">
 <h2>Register</h2>
  <form action="BooksServlet" method="post">
<input type="text" placeholder="enter title" name="title"/><br/>
<input type="text" placeholder="enter description" name="description"/><br/>
<input type="number" placeholder="enter year" name="year"/><br/>
<input type="text" placeholder="enter publisher" name="publisher"/><br/>
<input type="text" placeholder="enter category" name="category"/><br/>
<input type="number" placeholder="enter quantity" name="quantity"/><br/><br/>
<input type="submit" value="go" style="width: 157px; "/>

</form><!-- close form -->
  
 </div><!-- close aa -->
</body>
</html>