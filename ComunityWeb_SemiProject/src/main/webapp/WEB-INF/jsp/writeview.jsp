<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.web.writeview.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/static/js/writeview.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getAttribute("cList") == null) {
			
		}
		else{
			List<CommentDTO> comList = (List<CommentDTO>)request.getAttribute("cList");
			%>
			<h1><%= comList.size() %></h1>
			<%
			for(CommentDTO dto : comList) {
				%>
				<div>
					<div><%= dto.getCommentId() %></div>
					<div><%= dto.getWriteId() %></div>
					<div><%= dto.getWriter() %></div>
					<div><%= dto.getComment() %></div>
					<div><%= dto.getCommentDate() %></div>
					<button type="button">수정</button>
					<button type="button">삭제</button>
				</div>
				<%
			}
		}
	%>
	
	<form id="comment_form" action="/Writeview" method="post">
		<input type="text" name="context" required>
		<input type="hidden" name="date">
		<button type="submit">등록</button>
	</form>
</body>
</html>