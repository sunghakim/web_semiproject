<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="/login" method="post">
		<div>
			<input type="text" name="UserID" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="UserPassword" placeholder="비밀번호">
		</div>
		<div>
			<button type="submit">로그인</button>
		</div>
	</form>
	<div>
		<%
			String result = (String)request.getAttribute("result");
			if (result.equals("failure")) {
		%>
		<h3>로그인 실패: 아이디나 비밀번호가 일치하지 않습니다.</h3>
		<% 
			}
		%>
	</div>
</body>
</html>