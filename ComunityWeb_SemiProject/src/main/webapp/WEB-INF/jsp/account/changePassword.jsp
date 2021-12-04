<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="style.css">
	<script src="main.js" defer></script>
	<script src="IDOverlap.js"></script>
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
		        <input class="pass_ipt" type="password" name="NewUserPassword"placeholder="Create password" required>   
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
			if (result.equals("CPsuccess")) {
			%>
				<h3>비밀번호 변경 성공</h3>
			<% 
			} else if (result.equals("CPfailure1")) {
			%>
				<h3>오류가 발생했습니다. 다시 시도하거나 다음에 시도해주세요</h3>
				<h3>오류코드: CPfailure1</h3>
			<% 
			} else if (result.equals("CPfailure2")) {
			%>
				<h3>비밀번호 변경 실패: 입력하신 현재 비밀번호가 틀립니다.</h3>
				<h3>오류코드: CPfailure2</h3>
			<% 
			} else if (result.equals("CPfailure3")) {
			%>
				<h3>오류가 발생했습니다. 다시 시도하거나 다음에 시도해주세요</h3>
				<h3>오류코드: CPfailure3</h3>
			<% 
			} else {}
			%>
			
    	</form>
	</div>
</body>
</html>