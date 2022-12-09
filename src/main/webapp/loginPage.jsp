<%--
  Created by IntelliJ IDEA.
  User: nathan andrews
  Date: 01/12/2022
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page HR</title>
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

<form action="login" method="post">
    <div class="imgcontainer">
        <img src="imgs/img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" id="username"required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password"required>

        <button type="submit">Login</button>
        <label>
            <input type="checkbox" name="remember"> Remember me
        </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn" onclick="location.href ='index.jsp'">Cancel</button>
        <button type="button" class="signupbtn" onclick="location.href = 'registerPage.jsp'">Sign Up</button>
    </div>
</form>
</body>
</html>
