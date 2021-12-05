<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/static/css/style2.css">
</head>
<body>

<div class="wrapper">
    <h2>로그인</h2>
    <form action="/login" method="post">
      <div class="input-box">
        <input type="text" id="confirmed_id" name="UserID" placeholder="insert ID" required>
      </div>
      <div class="input-box">
        <input class="pass_ipt" type="password" name="UserPassword" placeholder="insert password" required>   
      </div>

      <div class="input-box button">
        <input class="submit_btn"type="submit" value="LogIn Now">
      </div>
      <div class="text">
        <h3>가입된 계정이 없으신가요? <a href="/join">Sign up</a></h3>
      </div>
    </form>
  </div>


	<div>
		<%
			String result = (String)request.getAttribute("result");
			if (result.equals("failure")) {
		%>
		    <script>
				alert("로그인 실패: 아이디나 비밀번호가 일치하지 않습니다.");
			</script>
		<% 
			}
		%>
	</div>
</body>
</html>