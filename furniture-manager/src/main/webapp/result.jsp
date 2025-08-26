<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Grade Submission Result</title>
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
            color: #4CAF50;
        }
        .grade-list {
            margin-top: 20px;
        }
        .grade-item {
            border: 1px solid #ddd;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 3px;
        }
        .back-btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }
        .back-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Grade Successfully Recorded!</h1>
        
        <div class="grade-list">
            <h2>Student Records</h2>
            <p>File location: ${filePath}</p>
            
            <h3>Current Grades:</h3>
            <c:forEach items="${fileContent}" var="record">
                <div class="grade-item">
                    ${record}
                </div>
            </c:forEach>
        </div>
        
        <a href="index.jsp" class="back-btn">Back to Form</a>
    </div>
</body>
</html> 