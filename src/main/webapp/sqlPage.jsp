<%--
  Created by IntelliJ IDEA.
  User: losma
  Date: 02/12/2022
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/navbar.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/loginPage.css" />
</head>
<body>
<div class="topnav">
  <a class="active" href="index.jsp">Home</a>
  <a href="xssPage.jsp">XSS Example</a>
  <a href="sqlPage.jsp">SQL Injection Example</a>
  <a href="loginPage.jsp">Login</a>
</div>

<center>
  <H1 style="margin:0 auto;">HOW TO USE</H1>
  <p style="padding-left:2%">Use the code below to use SQL Injection</p>
  <p style="padding-left: 2%">Add the following to the end of the search bar <b>AFTER YOU SEARCH</b><br> '+OR+1=1-- </p>
  <p style="padding-left: 2%">This will make the search query inject like, SELECT * FROM staff WHERE firstname='firstname' AND lastname='lastname' OR 1=1--</p>
  <p style="padding-left: 2%">Won't work here:</br>http://securewebapp-env.eba-muitvv4z.us-east-1.elasticbeanstalk.com/sqlInjectionServlet?username=Nathan&password=Andrews'+OR+1=1--</p>
</center>

<p id="results"></p>

<div class="container">
  <form method="get" action="sqlInjectionServlet">
  <label for="username"><b>First Name</b></label>
  <input type="text" placeholder="Enter First Name" name="username" id="username"required>

  <label for="password"><b>Last Name</b></label>
  <input type="text" placeholder="Enter Last Name" name="password" id="password"required>

  <button type="submit">Search</button>
  </form>
</div>

</body>
</html>
