<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내정보</title>
</head>
<body>
	<h3>마이페이지</h3>
	<a href="/changePassword">비밀번호 변경</a>
	<a href="/quitCommunity">회원탈퇴</a>
	<a href="/">홈(임시)</a>
	<%
		String result = (String)request.getAttribute("result");
		if (result.equals("QCfailure")) {
	%>
		<h3>회원 탈퇴 실패: 관리자에게 문의해주세요.</h3>
	<% 
		} else if (result.equals("CPsuccess")) {
	%>
		<h3>비밀번호 변경 성공</h3>
	<%		
		}
	%>
</body>
</html>