<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.account.model.AccountDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 검사</title>
</head>
<body>
	<%
		String UserID = "";
		if(request.getAttribute("UserID") != null) {
			UserID = (String)request.getAttribute("UserID");
		}
		String result = ""; 
		if(request.getAttribute("result") != null) {
			result = (String)request.getAttribute("result");
		}
		if(result == "0") {result = "사용 가능한 아이디입니다.";}
		else if(result == "1") {result = "이미 존재하는 아이디입니다.";}
	%>
	<h3>아이디 중복검사</h3>
	<form action="/IDcheck" method="post">
		<input type="text" name="UserID" value="<%= UserID%>" placeholder="Enter your ID" required>
		<button type="Submit">중복확인</button>
	</form>
		<h3><%= result%></h3>
	<button type="submit">아이디 사용하기</button>
</body>
</html>