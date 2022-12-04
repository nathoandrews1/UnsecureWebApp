<%--
  Created by IntelliJ IDEA.
  User: losma
  Date: 02/12/2022
  Time: 05:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XSS</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/navbar.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/loginPage.css" />
</head>
<body>
<!-- navbar -->
<div class="topnav">
    <a class="active" href="index.jsp">Home</a>
    <a href="xssPage.jsp">XSS Example</a>
    <a href="sqlPage.jsp">SQL Injection Example</a>
    <a href="loginPage.jsp">Login</a>
</div>
<!-- navbar end -->

<center>
    <H1 style="margin:0 auto;">HOW TO USE</H1>
    <p style="padding-left:2%">Use the code below in any of the input fields and search<br><br><b>&lt/p&gt&ltimg src="/" onerror='alert("hacked")'&gt</b></p>
</center>

<p id="searchP"></p>

<div class="container">
    <label for="username"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="username" id="username"required>

    <label for="password"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="password" id="password"required>

    <button type="submit" onclick="returnSearch()">Search</button>
</div>

<script>
    function returnSearch(){
        var firstName = document.getElementById("username").value;
        var lastName = document.getElementById("password").value;
        document.getElementById("searchP").innerHTML = "Searching for user with Name: "+firstName + " " + lastName;
    }
</script>
</body>
</html>
