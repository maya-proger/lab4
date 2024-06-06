<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Список ролей</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID</td>
        <td>name</td>
    </tr>
    <c:forEach items="${roles}" var = "role">
        <tr>
            <td>${role.getId()}</td>
            <td>${role.getName()}</td>
            <td>
                <form action = "updateRole.jsp" method="post">
                    <input type="hidden" name="id" value="${role.getId()}">
                    <input type="hidden" name="name" value="${role.getName()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
                <form action="deleteRole.jsp" method="post">
                    <input type="hidden" name="id" value="${role.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addRole.jsp">
    <input type="submit" value="Добавить новую роль">
</form>
</body>
</html>