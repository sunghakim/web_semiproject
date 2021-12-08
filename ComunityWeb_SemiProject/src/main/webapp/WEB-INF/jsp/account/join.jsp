<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.model.AccountDTO"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/static/css/style2.css">
<title>회원가입</title>
</head>
<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}
body {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  /* background: #4070f4; */
}
.wrapper {
  position: relative;
  max-width: 430px;
  width: 100%;
  background: #fff;
  padding: 34px;
  border-radius: 6px;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
}
.wrapper h2 {
  position: relative;
  font-size: 22px;
  font-weight: 600;
  color: #333;
}

.wrapper form {
  margin-top: 30px;
}
.wrapper form .input-box {
  height: 52px;
  margin: 18px 0;
}
form .input-box input {
  height: 100%;
  width: 100%;
  outline: none;
  padding: 0 15px;
  font-size: 17px;
  font-weight: 400;
  color: #333;
  border: 1.5px solid #c7bebe;
  border-bottom-width: 2.5px;
  border-radius: 6px;
  transition: all 0.3s ease;
}
.input-box input:focus,
.input-box input:valid {
  border-color: #4070f4;
}
.input-box {
  padding-bottom: 20px;
}
form .policy {
  display: flex;
  align-items: center;
}
form h3 {
  color: #707070;
  font-size: 14px;
  font-weight: 500;
  margin-left: 10px;
}
.input-box.button input {
  color: #fff;
  letter-spacing: 1px;
  border: none;
  background: #4070f4;
  cursor: pointer;
}
.input-box.button input:hover,
.id_check_btn:hover {
  background: #0e4bf1;
}
form .text h3 {
  color: #333;
  width: 100%;
  text-align: center;
}
form .text h3 a {
  color: #4070f4;
  text-decoration: none;
}
form .text h3 a:hover {
  text-decoration: underline;
}
.input-box.id {
  display: flex;
}

#error,#error1,#error3,#error4 {
  padding: 2px;
font-size: 5px;
  color: red;
}

.submit_btn {
  margin-top: 10px;

</style>
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
			    <span id="error1"></span>
			
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
	<script>
	const pwconfirm = document.querySelector('#error');
	const pwcheck =document.querySelector('#error1');
	const pass = document.querySelector('.pass_ipt');
	const passCon = document.querySelector('.pass_confirm');

	pass.addEventListener('blur',()=>{
	    if((pass.value).length<3) {
	        pwcheck.innerHTML = "3글자 이상 입력해주세요.";
	        pwcheck.style.display = "block";
	    } else{
	        pwcheck.style.display = "none";
	    }
	});

	passCon.addEventListener('blur', ()=>{

	if(pass.value !== passCon.value){
	        pwconfirm.innerHTML = "비밀번호가 일치하지 않습니다.";
	        pwconfirm.style.display = "block";
	    } else{
	        pwconfirm.style.display = "none";
	    }
	});
	

	
	</script>
	
</body>
</html>