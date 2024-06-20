<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>

Редактировать пользователя

<form action="/lab4/users/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="username" value="${param.username}" placeholder=${param.username}>
    <input type="text" name="email" value="${param.email}" placeholder=${param.email}>
    <input type="password" name="password" value="${param.password_hash}">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>