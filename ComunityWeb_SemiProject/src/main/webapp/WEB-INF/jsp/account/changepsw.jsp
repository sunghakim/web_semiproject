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
    <form action="#">
      <div class="input-box">
        <label>현재 비밀번호</label>
        <input class="pass_ipt" type="password" name="password"placeholder="" required>   
      </div>
      <div class="input-box">
        <label>새로운 비밀번호</label>
        <input class="pass_ipt" type="password" name="password"placeholder="Create password" required>   
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
        <h3>변경 취소 <a href="/mypage/mypage.html">My Page</a></h3>
      </div>
    </form>
  </div>
  
<script type="text/javascript">
	const pwconfirm = document.querySelector('#error');
	
	const pass = document.querySelector('.pass_ipt');
	const passCon = document.querySelector('.pass_confirm');
	
	
	passCon.addEventListener('blur', ()=>{
	if(pass.value !== passCon.value){
	        pwconfirm.innerHTML = "비밀번호가 일치하지 않습니다.";
	        pwconfirm.style.display = "block";
	    } else{
	        pwconfirm.style.display = "none";
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