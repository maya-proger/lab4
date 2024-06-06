<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "/lab4/articles" method="post">
    <input required type="text" name="title" placeholder="title">
    <input required type="text" name="announcement" placeholder="announcement">
    <input required type="text" name="text" placeholder="text">
    <input required type="text" name="author_id">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>