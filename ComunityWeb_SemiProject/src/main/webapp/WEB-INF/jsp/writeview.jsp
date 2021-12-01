<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.web.writeview.model.*" %>
<%@ page import="com.web.post.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/static/js/writeview.js"></script>
<title>Insert title here</title>
</head>
<body>
	<% PostDTO p_dto = (PostDTO)request.getAttribute("post_info"); %>
	<div><%= p_dto.getPost_num() %></div>
	<div><%= p_dto.getUser_id() %></div>
	<div><%= p_dto.getPost_title() %></div>
	<div><%= p_dto.getPost_content() %></div>
	<div><%= p_dto.getPost_date() %></div>
	<div><%= p_dto.getBoard_num() %></div>
	<button type="button"><a href="/PostChange?post_id=<%= p_dto.getPost_num() %>">수정</a></button>
	<button type="button"><a href="/PostDelete?post_id=<%= p_dto.getPost_num() %>">삭제</a></button>
	<hr>
	<hr>
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
					<button type="button"><a href="/CommentChange?comment_id=<%= dto.getCommentId() %>&post_id=<%= p_dto.getPost_num() %>">수정</a></button>
					<button type="button"><a href="/CommentDelete?comment_id=<%= dto.getCommentId() %>">삭제</a></button>
				</div>
				<hr>
				<%
			}
		}
	%>
	<form id="comment_form" action="/Writeview" method="post">
		<input type="text" name="context" value="<%= request.getAttribute("comments") %>" required>
		<input type="hidden" name="date">
		<input type="hidden" name="post_id" value="<%= p_dto.getPost_num() %>">
		<input type="hidden" name="comment_id" value="<%= request.getAttribute("comment_id") %>">
		<button type="submit">등록</button>
	</form>
</body>
</html>