<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" type="text/css" href="/css/category.css">
<script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/js/category.js"></script>

<div class="catecol">
    <div style="margin-bottom: 10px;">
        <button id="writePost" type="button" onclick="location.href='/user/board/boardWrite.jsp'">글쓰기</button>
    </div>
    <div class="tab-list">
      <button class="category active">공지사항</button>
      <button class="category">카테고리1</button>
      <button class="category">카테고리2</button>
      <button class="category">카테고리3</button>
    </div>
  </div>