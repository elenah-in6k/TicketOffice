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
    <title>${name}</title>
</head>
<body>
<h1>${name}</h1>

<table>
    <%
        List<City> cities = (List<City>) request.getAttribute("cities");
        if (cities.size() != 0) {
            for (City city : cities) {
    %>
    <tr>
        <td><%=city.getName()%>
        </td>
    </tr>
    <% }
    } else {%>
    City don't found
    <% }%>
</table>

<h3>Add new city</h3>

<form method="POST" action="/city">
    <label for="nameCity"> Enter name city: </label>
    <input type="text" name="nameCity" id="nameCity">
    <input type="submit" name="addCity" value="addCity">
</form>
<font color="green">${ifAdd}</font>

<h3><a href="/">Go home</a></h3>
</body>
</html>
