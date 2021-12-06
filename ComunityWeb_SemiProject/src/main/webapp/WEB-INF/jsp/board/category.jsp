<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<link rel="stylesheet" type="text/css" href="/static/css/category.css">
<script type="text/javascript" src="/static/js/jquery-3.6.0.min.js"></script>

<div class="catecol">
    <div style="margin-bottom: 10px;">
        <button id="writePost" type="button" onclick="location.href=''">글쓰기</button>
    </div>
    <div class="tab-list">
      <button class="category active">공지사항</button>
      <c:if test="${not empty board}">
      	<c:forEach var="i" items="${board}">
      		<button class="category" onclick="location.href=''">${i.getBOARD_NAME()}</button>
      	</c:forEach>
      </c:if>
    </div>
  </div>