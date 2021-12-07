<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="java.util.*" %>
<%@page import="com.web.model.PostDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/static/css/boardList.css">

<title>게시판</title>
</head>
<body>
<div style="display: flex; margin: 10px 10px; width: 95%;">
	<c:import url="./category.jsp" />

    <div id="content">
        <h1></h1>
        <fmt:formatDate value="<%=new Date() %>" pattern="yyMMdd" var="now" />
        <div class="boardTable">
            <table class="table table-hover">
                <thead>
                    <tr style="text-align: center;">
                    <th scope="col" style="width:5%">#</th>
                    <th scope="col" style="width:30%">제목</th>
                    <th scope="col" style="width:10%">작성자</th>
                    <th scope="col" style="width:10%">작성일</th>
                    </tr>
                </thead>
                <tbody>
	                <c:if test ="${not empty datas}">
	                	<c:forEach var="i" items="${datas}">
	                    <tr>
	                    <th scope="row">${i.getPost_num()}</th>
	                    <td><a href="/Writeview?post_id=${i.getPost_num()}">${i.getPost_title()}</a></td>
	                    <td>${i.getUser_id()}</td>
                        <fmt:formatDate value="${i.getPost_date()}" pattern="yyMMdd" var="date" />
	                    <td>
	                    <c:if test="${date eq now}">
                            <fmt:formatDate value="${i.getPost_date()}" type="time" pattern="HH:mm" />
                        </c:if>
                        <c:if test="${date lt now}">
                           	<fmt:formatDate value="${i.getPost_date()}" type="date" pattern="yy-MM-dd" />
                        </c:if>
                        </td>
	                    </tr>
	                    </c:forEach>
	                </c:if>
                </tbody>
            </table>
        </div> <!-- boardTable end -->
        <form action="" method="post">
            <div id="search">
                <select name="searchKeyword">
                    <option value="0">제목 + 작성자</option>
                    <option value="1">제목</option>
                    <option value="2">작성자</option>
                </select>
                <input type="text" class="search" name="search" placeholder="검색어 입력" />
                <button class="searchBtn">검색</button>
            </div> <!-- serch end -->
        </form>
    </div> <!-- content end -->
</div>
</body>
</html>