<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить роль</title>
</head>
<body>

Вы действительно хотите удалить роль ${param.id}?

<form action="/lab4/roles/${param.id}" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Удалить">
</form>

</body>
</html>