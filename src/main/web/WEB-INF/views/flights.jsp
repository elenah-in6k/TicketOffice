<%@ page import="core.entity.Flight" %>
<%@ page import="java.util.List" %>
<%@ page import="core.entity.City" %>
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
    <title>Flight</title>
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
        <h1>Flight</h1>
    </div></div>

        <div class="container">
            <div class="jumbotron">
<table class="table-striped table-bordered" align="center">

    <%
        List<Flight> flights = (List<Flight>) request.getAttribute("flight");
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
    <tr >
        <td class="active"><%=flight.getName() %>
        </td>
        <td><%=flight.getDateTime() %>
        </td>
        <td><%=flight.getNumberOfPlace() %>
        </td>
        <td><%=flight.getNumberOfEmptyPlaces()%>
        </td>
        <td><%=flight.getCity().getName() %>
        </td>
        <td> <form method="POST" action="/flights/delete/?idFlight=<%=flight.getId()%>">
                <input type="submit" name="delete" value="delete">
            </form>
        </td>
    </tr>
    <% }
    } else {%>
    Flights don't found
    <% }%>
</table>

    </div></div>

<div class="container" align="center">
    <div class="jumbotron">
<h3>Add new flight</h3>

<form method="POST" action="/flights">
    <label for="idCity">City: </label>
    <select name=idCity id="idCity">
        <% for (City city : (List<City>) request.getAttribute("cities")) {%>
        <option value=<%=city.getId()%>><%=city.getName()%>
        </option>
        <% }%>
    </select>
    <br> <br>
    <label for="name"> Name: </label>
    <input type="text" name="name" id="name">
    <br> <br>
    <label for="date"> Date (yyyy-MM-dd): </label>
    <input type="text" name="date" id="date">
    <br> <br>
    <label for="numberOfPlace"> numberOfPlace: </label>
    <input type="number" name="numberOfPlace" id="numberOfPlace">
    <br> <br>
    <input type="submit" name="addFlight" value="addFlight">
</form>

<font color="green">${ifAdd}</font>
    </div>
</div>

</body>
</html>
