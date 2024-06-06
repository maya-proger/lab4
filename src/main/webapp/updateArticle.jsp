<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные статьи</title>
</head>
<body>

Редактировать статью

<form action="/lab4/articles/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="title" value="${param.title}" placeholder=${param.title}>
    <input type="text" name="announcement" value="${param.announcement}" placeholder=${param.announcement}>
    <input type="text" name="text" value="${param.text}" placeholder=${param.text}>
    <input type="text" name="author_id" value="${param.author_id}"  placeholder=${param.author_id}>
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>