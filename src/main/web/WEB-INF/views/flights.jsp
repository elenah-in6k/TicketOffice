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
    <title>Flight</title>
</head>
<body>
<h1>Flight</h1>

<table width="80%"  border="1px inset black">
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
    <input type="date" name="date" id="date">
    <br> <br>
    <label for="numberOfPlace"> numberOfPlace: </label>
    <input type="number" name="numberOfPlace" id="numberOfPlace">
    <br> <br>
    <input type="submit" name="addFlight" value="addFlight">
</form>

<font color="green">${ifAdd}</font>

<h3><a href="/">Go home</a></h3>
</body>
</html>
