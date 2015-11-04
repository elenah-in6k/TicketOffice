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
    <title>${name}</title>
</head>
<body>
<h1>${name}</h1>
${searchFlight}
<form method="GET" action="/searchResult">
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
    <input type="submit" name="searchFlight" value="searchAllOptions">
</form>
<h3><a href="/">Go home</a></h3>
</body>
</html>
