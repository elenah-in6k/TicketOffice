<%@ page import="core.entity.City" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/3/15
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet"  href="/resources/css/bootstrap-theme.css" >
    <link rel="stylesheet"  href="/WEB-INF/style/style.css" >
    <title>City</title>
</head>
<body>
<p>  </p>
<p>  </p>
<div class="navbar-wrapper" >


    <nav class="navbar navbar-default navbar-fixed-top ">
        <div class="container ">

            <a class="navbar-brand" href="/"> Home </a>
            <a class="navbar-brand" href="cities">  Cities  </a>
            <a class="navbar-brand" href="flights">  Flights  </a>
            <a class="navbar-brand" href="searchFlight">  Search flights  </a>

        </div>
    </nav>
</div>
<div class="container">
    <div class="jumbotron">
<h1>City</h1>
    </div></div>

<div class="container">
    <div class="jumbotron">
        <table class="table-striped table-bordered" align="center">

    <%
        List<City> cities = (List<City>) request.getAttribute("cities");
        if (cities.size() != 0) {
            for (City city : cities) {
    %>
    <tr>
        <td><%=city.getName()%> </td>
        <td> <form method="POST" action="/cities/delete/?idCity=<%=city.getId()%>">
            <input type="submit" name="delete" value="delete">
        </form>
        </td>

    </tr>
    <% }
    } else {%>
    City don't found
    <% }%>
</table>
<font color="red">${exception}</font>
    </div></div>
<div class="container">
    <div class="jumbotron">
<h3>Add new city</h3>

<form method="POST" action="/cities">
    <label for="nameCity"> Enter name city: </label>
    <input type="text" name="nameCity" id="nameCity">
    <input type="submit" name="addCity" value="addCity">
</form>
<font color="green">${ifAdd}</font>
</div></div>
</body>
</html>
