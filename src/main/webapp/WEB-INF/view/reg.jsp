<%--
  Created by IntelliJ IDEA.
  User: Kapital
  Date: 31.10.2023
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reg</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/reg">

    <label>Имя <input type="text" name="name"></label><br>

    <label>Пароль <input type="text" name="password"></label><br>

    <input type="submit" value="Зарегистрироваться"><br>

</form>

</body>
</html>
