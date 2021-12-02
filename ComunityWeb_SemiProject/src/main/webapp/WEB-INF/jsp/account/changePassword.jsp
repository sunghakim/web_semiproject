<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="style.css">
	<script src="main.js" defer></script>
	<title>비밀번호 변경</title>
</head>
<body>
	<div class="wrapper">
		<h2>비밀번호 변경</h2>
		<form action="/changePassword" method="post">
			<div class="input-box">
				<label>현재 비밀번호</label>
				<input class="pass_ipt" type="password" name="UserPassword"placeholder="Old Password" required>   
			</div>
			<div class="input-box">
		        <label>새로운 비밀번호</label>
		        <input class="pass_ipt" type="password" name="newUserPassword"placeholder="Create password" required>   
			</div>
			<div class="input-box">
		        <label>비밀번호 확인</label>
		        <input class="pass_confirm" type="password" placeholder="Confirm password" required>
		        <span id="error"></span>
			</div>
			<div class="input-box button">
				<input class="submit_btn"type="Submit" value="비밀번호 변경하기">
			</div>
			<div class="text">
				<h3>변경 취소 <a href="/myPage">My Page</a></h3>
			</div>
			<%
			String result = (String)request.getAttribute("result");
			if (result.equals("CPfailure1")) {
			%>
				<h3>비밀번호 변경 실패: 입력하신 현재 비밀번호가 틀립니다.</h3>
			<% 
			} else if (result.equals("CPfailure1")) {
			%>
				<h3>비밀번호 변경 실패: 입력하신 현재 비밀번호가 틀립니다.</h3>
			<% 
			}
			%>
    	</form>
	</div>
</body>
</html>