<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>아이디 중복확인</title>
    <style>
        html,body{
            margin: 15px;
        }
    </style>
</head>
<body>

    <h3>아이디 중복확인</h3>
    <form action="/join_checkId">
        <input type="text" name="userId" placeholder="Enter your ID" required>
        <button class="id_check_btn">중복확인</button>
    </form>
    
    
</body>
</html>