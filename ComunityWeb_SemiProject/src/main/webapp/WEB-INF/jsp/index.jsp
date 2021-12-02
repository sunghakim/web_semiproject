<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="">
<title>메인페이지</title>
</head>
<body>
    <h1>메인 페이지 입니다.</h1>
    <ul>
    	<%
			String UserID = (String)session.getAttribute("UserID");
	    	boolean loginStatus = (boolean) request.getAttribute("loginStatus");
        	if(loginStatus) {
        %>
        	<li><a href="/myPage">마이 페이지</a></li>
	        <li><a href="/logout">로그아웃 페이지</a></li>
	        <h1>로그인 되었습니다.</h1>
			<h3>로그인된 아이디: <%=UserID %></h3>
        <%
        	} else {
   		%>
	        <li><a href="/join">회원가입 페이지</a></li>
			<li><a href="/login">로그인 페이지</a></li>
			<h1>로그인을 하지 않았습니다.</h1>
        <%		
        	}
        %>
	</ul>
</body>
</html>