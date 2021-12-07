<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="java.util.*" %>
<%@page import="com.web.model.BoardDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style type="text/css">
html,
body {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
}

.wrap {
  min-height: 100%;
  position: relative;
  padding-bottom: 60px;
}

ul {
  list-style: none;
}

.navBar {
  width: 100%;
  height: auto;
  box-shadow: 0 1px 3px rgb(0 0 0 / 10%), 0 2px 2px rgb(0 0 0 / 6%),
    0 0 2px rgb(0 0 0 / 7%);
}

.navBar-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 1440px;
  margin: 0 auto;
}
.navBar-home > a {
  list-style: none;
  margin-left: 10px;
}

.navBar-right {
  margin-top: 15px;
}
.navBar ul {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
  font-size: 10px;
}
.navBar ul li {
  margin-right: 10px;
}
.navBar-right .navBar-item > li > button {
  cursor: pointer;
  display: inline-block;
  border: 1px #000 solid;
  border-radius: 50px;
  padding: 7px 16px;
  line-height: 1.2;
  text-align: center;
  text-decoration: none;
}

.SignIn_btn {
  background-color: white;
  color: black;
}
.SignIn_btn:hover {
  background-color: rgba(0, 0, 0, 0.06);
}

.SignUp_btn,
.LogOut_btn {
  background-color: black;
  color: white;
}
.SignUp_btn:hover {
  background-color: #333;
}
.nav_right .na .navBar a {
  color: #000;
  text-decoration: none;
}

.catecol {
    margin-right: 20px;
}

#writePost {
    display:block;
    padding:.5rem 1rem;
    color:#ffffff;
    height: 50px;
    width: 200px;
    font-size: 17px;
    font-weight: bold;

    flex:1 1 auto;
    text-align:center;
    margin-bottom:-1px;

    background:0 0;
    background-color: #3D84A8;
    border:1px solid transparent;
    border-radius:.25rem;
}

#writePost:hover{
    color:#3D84A8;
    border-color:#e9ecef #e9ecef #dee2e6;
    background-color: #ffffff;
    isolation:isolate
}

.category{
    display:block;
    padding:.5rem 1rem;
    color:#46CDCF;
    height: 50px;
    width: 200px;
    font-size: 17px;
    font-weight: bold;

    flex:1 1 auto;
    text-align:center;
    margin-bottom:-1px;

    background:0 0;
    border:1px solid transparent;
    border-radius:.25rem;
}

.category:focus,.category:hover{
    color:#46CDCF;
    border-color:#e9ecef #e9ecef #dee2e6;
    isolation:isolate
}

.category.active, .show>.category{
    color:#fff;
    background-color:#46CDCF;
}

#content {
    width: 100%;
    height: 800px;
    margin: 10px;
    padding: 20px;
}

h1 {
    color: #46CDCF;
    font-weight: bold;
}

tbody > tr > th, td:nth-child(3), td:nth-child(4) {
    text-align: center;
}

#search {
    display: flex;
    justify-content: center;
    margin-top: 40px;
}

select {
    outline: none;
    border-width: 1px;
    border-color: rgba(0, 0, 0, 0.418);
    border-radius: 4px;
    margin: 4px;
    padding: 3px 8px;
}

select:hover {
    border-color: #46CDCF;
}

.search {
    outline: none;
    border: 1px solid rgba(0, 0, 0, 0.418);
    border-radius: 4px;
    margin: 4px;
    padding: 3px 8px;
}

.search:hover {
    border-color: #46CDCF;
}

.searchBtn {
    outline: none;
    color: #46CDCF;
    font-weight: bold;
    border: 1px solid rgba(0, 0, 0, 0.418);
    border-radius: 4px;
    background-color: white;
    margin: 4px;
    padding: 3px 8px;
}

.searchBtn:hover {
    color: #ffffff;
    font-weight: bold;
    border: 1px solid rgba(160, 160, 160, 0.418);
    background-color: #46CDCF;
}

.footer-container {
  height: 60px;
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
}
</style>
<title>게시판</title>
</head>
<body>

 <div class="wrap">
    <nav class="navBar">
        <div class="navBar-container">
          <div class="navBar-home">
            <a href="/main"><i class="fas fa-home"> home</i></a>
          </div>
          <div class="navBar-right">
            <ul class="navBar-item">
			<c:choose>
            	<c:when test="${!empty sessionScope.UserID}">
              		<li><a href="/mypage"><%=(String) request.getSession().getAttribute("UserID")%>님 환영합니다.</a></li>
              		<li><button  type="submit" class="LogOut_btn" onclick="location.href='/logout'">Log Out</button></li>
            	</c:when>
            	<c:otherwise>
            		<li><button type="button" class="SignIn_btn" onclick="location.href='/login'">Sign In</button></li>
                   	<li><button  type="button" class="SignUp_btn" onclick="location.href='/join'">Sign Up</button></li>
            	</c:otherwise>
            </c:choose>
			</ul>
          </div>

            </div>
      </nav>

<div style="display: flex; margin: 10px 10px; width: 95%;">
	<div class="catecol">
    <div style="margin-bottom: 10px;">
        <button id="writePost" type="button" onclick="location.href='/PostController'">글쓰기</button>
    </div>
    <div class="tab-list">
      <button class="category active" onclick="location.href='/BoardSelectController?board_num=0&page_num=1'">공지사항</button>
      <c:if test="${not empty blist}">
      	<c:forEach var="i" items="${blist}">
      		<c:if test="${i.getBOARD_NUM() ne 0}">
      			<button class="category" onclick="location.href='/BoardSelectController?board_num=${i.getBOARD_NUM()}&page_num=1'">${i.getBOARD_NAME()}</button>
      		</c:if>
      	</c:forEach>
      </c:if>
    </div>
  </div>

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
        <form action="/BoardSelectController" method="post">
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
<footer class="footer">
	<div class="footer-container">
	    <hr>
	</div>
</footer>
</div>
</body>
</html>