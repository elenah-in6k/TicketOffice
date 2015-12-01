<%@ page import="core.entity.Flight" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/3/15
  Time: 5:18 PM
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
    <title>Searched flights</title>
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
<h1>Searched flights</h1>
</div></div>

<div class="container">
    <div class="jumbotron">
        <table class="table-striped table-bordered" align="center">

    <%
        List<Flight> flights = (List<Flight>) request.getAttribute("searchFlight");
        if (flights.size() != 0) {
    %>
    <tr>
        <td>Name</td>
        <td>DateTime</td>
        <td>NumberOfPlace</td>
        <td>NumberOfEmptyPlaces</td>
        <td>CityName</td>
    </tr>
    <% for (Flight flight : flights) {%>
    <tr>
        <td><%=flight.getName() %>
        </td>
        <td><%=flight.getDateTime() %>
        </td>
        <td><%=flight.getNumberOfPlace() %>
        </td>
        <td><%=flight.getNumberOfEmptyPlaces()%>
        </td>
        <td><%=flight.getCity().getName() %>
        </td>
    </tr>
    <% }
    } else {%>
    Flights don't found
    <% }%>
</table>
</div></div>
</body>
</html>
