<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Username</td>
        <td>Email</td>
        <td>Password hash</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${users}" var = "user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getUsername()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getPassword_hash()}</td>
            <td>
                <form action = "updateUser.jsp" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="hidden" name="username" value="${user.getUsername()}">
                    <input type="hidden" name="email" value="${user.getEmail()}">
                    <input type="hidden" name="password" value="${user.getPassword_hash()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
                <form action="deleteUser.jsp" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addUser.jsp">
    <input type="submit" value="Добавить нового пользователя">
</form>
</body>
</html>