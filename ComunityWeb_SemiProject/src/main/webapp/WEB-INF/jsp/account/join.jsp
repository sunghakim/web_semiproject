<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.model.AccountDTO"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/static/css/style2.css">
<title>회원가입</title>
</head>
<body>
<%
	String preUserID = "";
	if (request.getAttribute("UserID") != null) {
		preUserID = (String)request.getAttribute("UserID");
	}
	
	String result = "";
	if (request.getAttribute("result") != null) {
		switch((String)request.getAttribute("result")) {
		case ("1"):
			result = "오류가 발생하였습니다 잠시 후 다시 시도해주세요";
			break;
		case ("2"):
			result = "이미 존재하는 아이디입니다.";
			break;
		}
	}
%>

	<div class="wrapper">
		<h2>회원가입</h2>
		<form action="/join" method="post">
			<div class="input-box">
				<input type="text" id="confirmed_id" name="UserID" value="<%=preUserID%>" placeholder="click here"required>
				<span><%=result%></span>
			</div>
			<div class="input-box">
		        <input class="pass_ipt" type="password" name="UserPassword" placeholder="Create password" required>   
			</div>
			<div class="input-box">
		        <input class="pass_confirm" type="password" placeholder="Confirm password" required>
		        <span id="error"></span>
			</div>
			<div class="input-box button">
		        <input class="submit_btn"type="submit" value="Sign Up Now">
			</div>
			<div class="text">
		        <h3>가입된 계정이 있으신가요? <a href="/login">Sign In</a></h3>
			</div>
		</form>
	</div>
</body>
</html>