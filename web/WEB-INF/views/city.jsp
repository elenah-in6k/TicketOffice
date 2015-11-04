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
${city}

<h3>Add new city</h3>
<form method="POST" action="/city">
<label for="nameCity"> Enter name city: </label>
<input type="text" name="nameCity" id="nameCity">
<input type="submit" name="addCity" value="addCity">
</form>

${goHome}
</body>
</html>
