<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="java.util.*" %>
<%@ page import="com.web.model.*" %>
    
<script type="text/javascript" src="/static/js/jquery-3.6.0.min.js"></script>
<style type="text/css">
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

</style>

<div class="catecol">
    <div style="margin-bottom: 10px;">
        <button id="writePost" type="button" onclick="location.href='/'">글쓰기</button>
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