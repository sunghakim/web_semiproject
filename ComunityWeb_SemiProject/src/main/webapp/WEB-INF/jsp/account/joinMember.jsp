<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.model.AccountDTO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
	<title>회원가입</title>
	<script>
		function showPopup() { 
			window.open("/IDcheck", "아이디 중복 확인", 
			"width=400, height=300, left=100, top=50"); 
		}
	</script>
</head>
<body>
	<%
		AccountDTO initData = new AccountDTO();
		if(request.getAttribute("init") != null) {
			initData = (AccountDTO)request.getAttribute("init");
		}
	%>
	<div class="wrapper">
		<h2>회원가입</h2>
		<form action="/join" method="post">
			<div class="input-box id">
				<input type="text" class="82462481" name="UserID" value="<%=initData.getUserID() %>" placeholder="Enter your ID" required>
				<button class="id_check_btn" type="button" onclick="showPopup();">중복확인</button>
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