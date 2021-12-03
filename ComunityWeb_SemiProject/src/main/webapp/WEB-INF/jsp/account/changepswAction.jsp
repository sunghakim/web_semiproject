<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.model.AccountDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
		String result = (String)request.getAttribute("result");
  		if (result.equals("CPsuccess")) {
%>
		<script>
			alert("비밀번호가 정상적으로 변경되었습니다.");
		</script>
<%
		}else if (result.equals("CPfailure2")) {
%>
		<script>
			alert("비밀번호 변경에 실패했습니다.");

		</script>
<%		
		} else if (result.equals("CPfailure1")){
%>
	<script>
		alert("기존 비밀번호를 다시 확인해주세요.");

	</script>
<%		
	}
%>
</body>
</html>