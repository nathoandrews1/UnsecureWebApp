<%--
  Created by IntelliJ IDEA.
  User: nathan andrews
  Date: 01/12/2022
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register User</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/register.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/navbar.css" />
</head>
<body>
<div class="topnav">
    <a class="active" href="index.jsp">Home</a>
    <a href="xssPage.jsp">XSS Example</a>
    <a href="sqlPage.jsp">SQL Injection Example</a>
    <a href="loginPage.jsp">Login</a>
</div>
<form action="registerUser" method="post">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" id="email" required>

        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" id="username" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="password" required>

        <label for="password-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="password-repeat" id="password-repeat" required>

        <label for="firstname"><b>First Name</b></label>
        <input type="text" placeholder="First Name" name="firstname" id="firstname" required>

        <label for="lastname"><b>Last Name</b></label>
        <input type="text" placeholder="Last Name" name="lastname" id="lastname" required>

        <label for="role"><b>Role</b></label>
        <input type="text" placeholder="Role" name="role" id="role" required>

        <label for="salary"><b>Salary</b></label>
        <input type="text" placeholder="Salary" name="salary" id="salary" required>
        <hr>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="loginPage.jsp">Sign in</a>.</p>
    </div>
</form>
</body>
</html>
