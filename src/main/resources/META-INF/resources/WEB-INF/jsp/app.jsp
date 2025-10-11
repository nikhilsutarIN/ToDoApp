<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>App</title>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">--%>
<%--    <link href="https://fonts.cdnfonts.com/css/koverwatch" rel="stylesheet">--%>
    <link href="https://fonts.cdnfonts.com/css/config-condensed" rel="stylesheet">
    <link rel="stylesheet" href="/css/todo.css">
</head>
<body>

<header>
    <nav>
        <div class="nav-logo">
            <a href="/">ToDo</a>
        </div>
        <div>
            <ul class="nav-links">
                <li><a class="nav-link" href="/logout">Logout</a></li>
            </ul>
        </div>
    </nav>
</header>

<section class="container">

    <div class="add-todo">
    <form class="add-todo-form" action="/app/" method="POST">
        <div>
            <input class="add-todo-input" type="text" name="title" minlength="1" maxlength="50" placeholder="Add a new task" required>
        </div>
        <div>
            <input class="add-todo-input" type="text" name="description" minlength="1" maxlength="50" placeholder="Description">
        </div>
        <div>
            <input class="add-todo-submit" type="submit" value="Add">
        </div>
    </form>
    </div>

    <div class="todos">
    <c:forEach var="todo" items="${todos}">
        <div class="todo-item">
            <div class="${todo.status ? 'todo-icon completed' : 'todo-icon not-completed'}">
                <img src="${todo.status ? '/images/done_icon.svg' : '/images/incomplete_circle.svg'}" alt="icon">
            </div>

            <div class="todo-content">
                <div class="todo-title">${todo.title}</div>
                <div class="todo-description">${todo.description}</div>
            </div>

            <div class="todo-actions">
                <a class="action-toogle" href="/app/${todo.id}/toggle"><img src="/images/done_icon.svg"></a>
                <a class="action-delete" href="/app/${todo.id}/delete"><img src="/images/delete_icon.svg"></a>
            </div>
        </div>
    </c:forEach>
    </div>

</section>

<%--<script src="https://c.webfontfree.com/c.js?f=Koverwatch" type="text/javascript"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>--%>

</body>
</html>