<%--
  Created by IntelliJ IDEA.
  User: Kapital
  Date: 30.10.2023
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> Войти или создать профиль! </h1> <br/>

<p>Name: ${user.name}</p>
<c:out value="${user.name}"/>
<form method="post" action="${pageContext.request.contextPath}/login">

    <div><label>Имя <input type="text" name="name"></label><br></div>
    <div><label>Пароль <input type="text" name="password"></label><br></div>


    <input type="submit" value="Войти" name="Ok"><br>

</form>

<form method="get" action="${pageContext.request.contextPath}/reg">

    <input type="submit" value="Регистрация"><br>

</form>


</body>
</html>
