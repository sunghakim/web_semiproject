<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.account.model.AccountDTO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
	<title>회원가입</title>
</head>
<body>
	<%
		AccountDTO initData = new AccountDTO();
		String error = "";
		
		if(request.getAttribute("init") != null) {
			initData = (AccountDTO) request.getAttribute("init");
		}
		if(request.getAttribute("error") != null) {
			error = (String)request.getAttribute("error");
		}
	%>
	<div class="wrapper">
		<h2>회원가입</h2>
		<form action="/join" method="post">
			<div class="input-box id">
				<input type="text" name="UserID" value="<%=initData.getUserID() %>" placeholder="Enter your ID" required>
				<button class="id_check_btn">중복확인</button>
			</div>
			<div class="input-box">
					<input class="pass_ipt" type="password" name="UserPassword" placeholder="Create password" required>   
			</div>
			<div class="input-box">
				<input class="pass_confirm" type="password" placeholder="Confirm password" required>
				<span id="error"></span>
			</div>
			<div>
				<button type="Submit">Sign Up Now</button>
			</div>
			<div class="text">
				<h3>가입된 계정이 있으신가요? <a href="/login">Sign In</a></h3>
			</div>
		</form>
	</div>
</body>
</html>