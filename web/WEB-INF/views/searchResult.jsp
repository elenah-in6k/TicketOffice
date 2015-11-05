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
    <title>${name}</title>
</head>
<body>
<h1>${name}</h1>
<table width="80%" border="1px inset black">
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

<h3><a href="/">Go home</a></h3>
</body>
</html>
