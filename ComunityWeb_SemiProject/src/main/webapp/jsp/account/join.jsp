<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/static/css/style2.css">
<script src="main.js" defer></script>
<title>회원가입</title>

</head>
<body>
 <div class="wrapper">
    <h2>회원가입</h2>
    <form action="#">
      <div class="input-box id">
        <input type="text" name="id" placeholder="Enter your ID" required>
        <button class="id_check_btn">중복확인</button>
      </div>
      <div class="input-box">
        <input class="pass_ipt" type="password" name="password"placeholder="Create password" required>   
      </div>
      <div class="input-box">
        <input class="pass_confirm" type="password" placeholder="Confirm password" required>
        <span id="error"></span>
      </div>

      <div class="input-box button">
        <input class="submit_btn"type="Submit" value="Sign Up Now">
      </div>
      <div class="text">
        <h3>가입된 계정이 있으신가요? <a href="#">Sign In</a></h3>
      </div>
    </form>
  </div>

</body>
</html>