<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "/lab4/users" method="post">
    <input required type="text" name="username" placeholder="username">
    <input required type="text" name="email" placeholder="email">
    <input required type="password" name="password">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>