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
        <td>Title</td>
        <td>Announcement</td>
        <td>Text</td>
        <td>Author ID</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${articles}" var = "article">
        <tr>
            <td>${article.getId()}</td>
            <td>${article.getTitle()}</td>
            <td>${article.getAnnouncement()}</td>
            <td>${article.getText()}</td>
            <td>${article.getAuthor().getId()}</td>
            <td>
                <form action = "updateArticle.jsp" method="post">
                    <input type="hidden" name="id" value="${article.getId()}">
                    <input type="hidden" name="title" value="${article.getTitle()}">
                    <input type="hidden" name="announcement" value="${article.getAnnouncement()}">
                    <input type="hidden" name="text" value="${article.getText()}">
                    <input type="hidden" name="author_id" value="${article.getAuthor().getId()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
                <form action="deleteArticle.jsp" method="post">
                    <input type="hidden" name="id" value="${article.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addArticle.jsp">
    <input type="submit" value="Добавить новую статью">
</form>
</body>
</html>