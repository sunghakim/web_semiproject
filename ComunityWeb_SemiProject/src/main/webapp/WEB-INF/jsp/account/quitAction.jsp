<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴</title>
</head>
<body>


  
    <% 
	    	String result = (String)request.getAttribute("result");
			if (result.equals("QCfailure")) {
	%>			
				<script>
				alert("회원 탈퇴 실패: 관리자에게 문의해주세요.");
				</script>
	<% 
			}else{
	%>
				<script>
				alert("정상적으로 탈퇴되었습니다.");
				</script>
				<% 
			}

    %>
</body>
</html>