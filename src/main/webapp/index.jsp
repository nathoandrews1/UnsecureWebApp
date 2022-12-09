<%--
  Created by IntelliJ IDEA.
  User: nathan andrews
  Date: 30/11/2022
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/navbar.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/index.css" />
</head>
<body>

<div class="topnav">
    <a class="active" href="index.jsp">Home</a>
    <a href="xssPage.jsp">XSS Example</a>
    <a href="sqlPage.jsp">SQL Injection Example</a>
    <a href="loginPage.jsp">Login</a>
</div>
<!-- Slide Show -->
<section class="slideshowContainer">
    <div class="slideshowDiv">
        <img class="mySlides" src="imgs/xss.png">
        <img class="mySlides" src="imgs/sql.png">
        <img class="mySlides" src="imgs/http.png">
    </div>
</section>

<!-- Project Description -->
<section class="w3-container w3-center w3-content" style="max-width:600px">
    <h2 class="w3-wide">THE PROJECT</h2>
    <p class="w3-opacity"><i>Insecure Web Application<br>Nathan Andrews</i></p>
    <p class="w3-justify">This website is to show an insecure website. Up above on the nav bar you can find links to examples. XSS cross site scripting, SQL Injection.<br><br>There is many more vulnerabilities around. The purpose of purposely coding an insecure application is to gain further understanding of the concepts and how to defend against them.</p>
</section>

<!-- Small pictures Section -->
<section class="w3-row-padding w3-center w3-light-grey">
    <article class="w3-third">
        <p>XSS</p>
        <img src="imgs/xss_small.png" alt="Random Name" style="width:50%">
        <p>Cross Site Scripting.</p>
    </article>
    <article class="w3-third">
        <p>SQL Injection</p>
        <img src="imgs/sql_small.png" alt="Random Name" style="width:50%">
        <p>One of the nastiest</p>
    </article>
    <article class="w3-third">
        <p>HTTPS</p>
        <img src="imgs/https_small.png" alt="Random Name" style="width:50%">
        <p>Secure Encrypted Connection</p>
    </article>
</section>

<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-black w3-xlarge">

</footer>

<script>
    // Automatic Slideshow - change image every 4 seconds
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("mySlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {myIndex = 1}
        x[myIndex-1].style.display = "block";
        setTimeout(carousel, 4000);
    }
</script>
</body>
</html>