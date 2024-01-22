<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ToDo App</title>
</head>
<body>
<h1>ToDo App</h1>
<ul id="todoList"></ul>

<form id="addTodoForm">
    <label for="title">Title:</label>
    <input type="text" id="title" required>
    <button type="submit">Add ToDo</button>
</form>

<script src="${pageContext.request.contextPath}/webjars/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/toastr/toastr.min.js"></script>
<script src="${pageContext.request.contextPath}/js/todo.js"></script>
</body>
</html>