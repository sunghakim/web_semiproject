<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.web.model.AccountDTO"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/static/css/style2.css">

<title>회원가입</title>

</head>
<body>
 <div class="wrapper">
    <h2>회원가입</h2>
    <form action="/join" method="post">
      <div class="input-box">
        <input type="text" id="confirmed_id" name="UserID" placeholder="click here" onclick="confirmId()"required>
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
   

<script type="text/javascript">
function confirmId(){
   window.open("join_checkId","중복 확인","width=400, height=300");
}

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