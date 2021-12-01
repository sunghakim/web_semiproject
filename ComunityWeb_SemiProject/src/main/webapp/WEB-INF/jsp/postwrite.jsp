<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="/static/js/writeview.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form id="comment_form" action="/PostController" method="post">
		<input type="text" name="board" value="<%= request.getAttribute("board") %>">
		<input type="text" name="title" value="<%= request.getAttribute("post_title") %>">
		<textarea name="content"><%= request.getAttribute("post_content") %></textarea>
		<input type="hidden" name="date">
		<input type="hidden" name="post_id" value="<%= request.getAttribute("post_id") %>">
		<button type="submit">저장</button>
	</form>
</body>
</html>