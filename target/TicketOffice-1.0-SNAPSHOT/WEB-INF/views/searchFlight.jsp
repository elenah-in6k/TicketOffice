<%@ page import="core.entity.City" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/3/15
  Time: 4:29 PM
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
    <title>${name}</title>
</head>
<body>
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
<h1>Searh flight</h1>

</div></div>

<div class="container">
    <div class="jumbotron">

        <form method="GET" action="/searchFlight/result/?idCity={idCity}&date={date}&numberOfPlace={numberOfPlace}">
    <label for=idCity>City: </label>
    <select name=idCity id="idCity">
        <% for (City city : (List<City>) request.getAttribute("cities")) {%>
        <option value=<%=city.getId()%>><%=city.getName()%>
        </option>
        <% }%>
    </select>
    <br> <br>
    <label for="date"> Date (yyyy-MM-dd): </label>
    <input type="date" name="date" id="date">
    <br> <br>
    <label for="numberOfPlace"> numberOfPlace: </label>
    <input type="number" name="numberOfPlace" id="numberOfPlace">
    <br> <br>
    <input type="submit"  value="searchAllOptions">
</form>

</div></div>

</body>
</html>
