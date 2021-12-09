<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="/static/css/style2.css">
    <title>비밀번호 변경</title>
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
<div class="wrapper">
    <h2>비밀번호 변경</h2>
    <form action="/changepsw" method="post">
      <div class="input-box">
        <label>현재 비밀번호</label>
        <input class="currentPsw" type="password" name="UserPassword"placeholder="현재비밀번호" required>   
      </div>
      <div class="input-box">
        <label>새로운 비밀번호</label>
        <input class="new_pass_ipt" type="password" name="NewUserPassword" placeholder="Create password" required> 
        <span id="error4"></span>
          
      </div>
      <div class="input-box">
        <label>비밀번호 확인</label>
        <input class="new_pass_confirm" type="password" name="ConfirmNewUserPassword" placeholder="Confirm password" required>
        <span id="error3"></span>
      </div>

      <div class="input-box button">
        <input class="submit_btn"type="submit" value="비밀번호 변경하기" onclick="passwdCheck(passForm);">
      </div>
      <div class="text">
        <h3>변경 취소 <a href="/mypage">My Page</a></h3>
      </div>
    </form>
  </div>
<%
	
		String result = (String)request.getAttribute("result");
  		if (result.equals("CPsuccess")) {
%>
		<script>
			alert("비밀번호가 정상적으로 변경되었습니다.");
		</script>
<%
		}else if (result.equals("CPfailure1")) {
%>
		<script>
			alert("오류가 발생했습니다. 다시 시도하거나 다음에 시도해주세요.");

		</script>
<%		
		} else if (result.equals("CPfailure2")){
%>
		<script>
		alert("비밀번호 변경 실패: 입력하신 현재 비밀번호가 틀립니다.");
		</script>
<%		
		} else if(result.equals("CPfailure3")){
%>		
		<script>
		alert("오류가 발생했습니다. 다시 시도하거나 다음에 시도해주세요.");
		</script>
<% 
		} else if(result.equals("CPfailure4")){
%>
		<script>
		alert("새비밀번호와 재입력한 새비밀번호가 같지 않습니다");
		</script>
<% 
		}
%>

<script type="text/javascript">


const new_pass = document.querySelector('.new_pass_ipt');
const new_passCon = document.querySelector('.new_pass_confirm');
const new_pwconfirm = document.querySelector('#error3');
const new_pwcheck =document.querySelector('#error4');



new_pass.addEventListener('blur',()=>{
    if((new_pass.value).length<3) {
        new_pwcheck.innerHTML = "3글자 이상 입력해주세요.";
        new_pwcheck.style.display = "block";
    } else{
        new_pwcheck.style.display = "none";
    }
});
new_passCon.addEventListener('blur', ()=>{
if(new_pass.value !== new_passCon.value){
        new_pwconfirm.innerHTML = "비밀번호가 일치하지 않습니다.";
        new_pwconfirm.style.display = "block";
    } else{
        new_pwconfirm.style.display = "none";
    }
});

function passwdCheck(form){
    if(form.currPasswd.value ==""){
        alert("현재 비밀번호를 입력해주세요");
        form.currPasswd.focus();
        return;

    }
    form.submit();
}

</script>
</body>
</html>