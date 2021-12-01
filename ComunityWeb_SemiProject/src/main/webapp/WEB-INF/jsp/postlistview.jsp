<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="com.web.post.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getAttribute("datas") == null) {
			
		}
		else{
			List<PostDTO> pList = (List<PostDTO>)request.getAttribute("datas");
			%>
			<h1><%= pList.size() %></h1>
			<%
			for(int i = 0; i < pList.size(); i++) {
				%>
				<div><a href="/Writeview?post_id=<%= pList.get(i).getPost_num() %>">
					<div><%= pList.get(i).getPost_num() %></div>
					<div><%= pList.get(i).getUser_id() %></div>
					<div><%= pList.get(i).getPost_title() %></div>
					<div><%= pList.get(i).getPost_date() %></div>
				</a>
				</div>
				<hr>
				<%
			}
		}
	%>
</body>
</html>