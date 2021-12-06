<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="/static/css/style2.css">
    <title>비밀번호 변경</title>
</head>
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
        <input class="new_pass_ipt" type="password" name="NewUserPassword"placeholder="Create password" required> 
        <span id="error4"></span>
          
      </div>
      <div class="input-box">
        <label>비밀번호 확인</label>
        <input class="new_pass_confirm" type="password" placeholder="Confirm password" required>
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