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
    <form action="#">
      <div class="input-box">
        <input type="text" id="confirmed_id" name="UserID" placeholder="click here" onclick="confirmId()"required>
<!--         <button class="id_check_btn" onclick="confirmId()">중복확인</button> -->
      </div>
      <div class="input-box">
        <input class="pass_ipt" type="password" name="UserPassword" placeholder="Create password" required>   
      </div>
      <div class="input-box">
        <input class="pass_confirm" type="password" placeholder="Confirm password" required>
        <span id="error"></span>
      </div>

      <div class="input-box button">
        <input class="submit_btn"type="submit" value="Sign Up Now">
      </div>
      <div class="text">
        <h3>가입된 계정이 있으신가요? <a href="/login.jsp">Sign In</a></h3>
      </div>
    </form>
  </div>
   

<script type="text/javascript">
function confirmId(){
   window.open("join_checkId.jsp","중복 확인","width=600, height=500");
}

</script>

</body>
</html>