<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Furniture Manager - Rooms</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
        }
        .room-list {
            margin-top: 20px;
        }
        .room-item {
            border: 1px solid #ddd;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 3px;
        }
        .add-form {
            margin-top: 20px;
            padding: 10px;
            background-color: #f9f9f9;
            border-radius: 3px;
        }
        input[type="text"] {
            padding: 5px;
            margin-right: 10px;
        }
        button {
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        .delete-btn {
            background-color: #f44336;
        }
        .delete-btn:hover {
            background-color: #da190b;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Room Management</h1>
        
        <div class="add-form">
            <form action="rooms" method="post">
                <input type="hidden" name="action" value="add">
                <input type="text" name="name" placeholder="Room name" required>
                <button type="submit">Add Room</button>
            </form>
        </div>
        
        <div class="room-list">
            <c:forEach items="${rooms}" var="room">
                <div class="room-item">
                    <h3>${room.name}</h3>
                    <form action="rooms" method="post" style="display: inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${room.id}">
                        <button type="submit" class="delete-btn">Delete</button>
                    </form>
                    <a href="furniture?roomId=${room.id}">
                        <button>View Furniture</button>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html> 