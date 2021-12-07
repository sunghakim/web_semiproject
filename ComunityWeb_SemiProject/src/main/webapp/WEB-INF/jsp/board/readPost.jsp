<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style type="text/css">
#content {
    width: 60%;
    height: 800px;
    padding: 5px;
}

label {
    margin: 0 10px;
    padding: 0;
}

#postInfo {
    margin: 0 20px;
    font-size: 14px;
    color: rgb(110, 110, 110);
}

#postInfo > label {
    margin: 0;
}

#contentBox {
    margin: 0 20px;
    padding: 5px 10px;
    width: 95%;
}

p {
    width: 100%;
}

.btnn {
    outline: none;
    color: #46CDCF;
    font-weight: bold;
    border: 1px solid rgba(0, 0, 0, 0.418);
    border-radius: 4px;
    border-color: rgba(230, 230, 230, 0.527);
    background-color: white;

    margin-left: 5px;
    padding: 5px 10px;
}

.btnn.back {
    background-color: #46CDCF;
}

.btnn:hover {
    color: #ffffff;
    font-weight: bold;
    background-color: #46CDCF;
}


/* comments */
.comments {
  width: 80%;
}
.comment_header {
  display: flex;
  justify-content: space-between;
}

#unlogInedcase_comment {
  width: 100%;
  text-decoration: none;
  margin-top: 10px;
}

#comment_textarea {
  width: 100%;
}

#comment_btn {
  font-size: 15px;
  margin-top: 10px;
}

.comment_btn_case {
  display: flex;
  justify-content: space-between;
}
</style>
<script type="text/javascript">
function change(post_id) {
	location.href="/PostChange?post_id=" + post_id;
}

function delete(post_id){
	location.href="/PostDelete?post_id=" + post_id;
}

</script>
<title>${post_info.getPost_title()}</title>
</head>
<body>
<div style="display: flex; margin: 10px 10px; width: 95%;">
	<c:import url="./category.jsp" />
	 <div id="content">
	     <div style="display: flex; justify-content: space-between;">
	         <div style="display: flex; justify-content: left; height: 100px; margin: 0; padding: 10px 0;">
	             <div style="display: flex; flex-direction: column; align-content: flex-end;">
	                 <label style="color:#46CDCF; font: size 10px;">${post_info.getPost_num()}</label>
	                 <h1 style="margin: 0;"><label class="textLabel" style="font-weight: bold;">${post_info.getPost_title()}</label></h1>
	             </div>
	         </div>
	         <div style="display: flex; align-items: flex-end; margin: 0 20px; padding: 10px 0;">
			             <button class="btnn md" id="change" onclick="change(${post_info.getPost_num()})"><i class="fas fa-eraser"></i></button>
			             <button class="btnn delete" id="del" onclick="delete(${post_info.getPost_num()})"><i class="fas fa-trash-alt"></i></button>
			         </div>
	         <%--<c:if test="${!empty sessionScope.UserID}">
		         <c:if test="${post_info.getUser_id eq sessionScope.UserID}">
			         <div style="display: flex; align-items: flex-end; margin: 0 20px; padding: 10px 0;">
			             <button class="btnn md" id="change"><i class="fas fa-eraser"></i></button>
			             <button class="btnn delete" id="del" action="/PostDelete"><i class="fas fa-trash-alt"></i></button>
			         </div>
		         </c:if>
	         </c:if>--%>
	     </div>
	     <div id="postInfo">
	         <label>작성자 ${post_info.getUser_id()}</label> |
	         <label>작성일 <fmt:formatDate value="${post_info.getPost_date()}" type="date" pattern="yy-MM-dd HH:mm" /></label>
	     </div>
	     <hr>
	     <div id="contentBox">
	         <p name="Content" placeholder="내용" style="overflow: auto;" required>${post_info.getPost_content()}</p>
	     </div>
	    
	
	 
	      <hr>
	      <section class="response"></section>
	        <div class="container">
	          <header class="section-header">
	            <h6 class="section-title">${cList.size()}개의 댓글</h6>
	          </header>
			<ul class="list-group list-group-flush" id="comments">
				<c:forEach var="i" items="${cList}">
				<li class="list-group-item" style="padding: 0;">
					<div style="border: 1px solid transparent; border-radius:4px; border-color: #e9ecef; margin: 0; padding: 4px 8px;">
						<div style="display: flex; justify-content: space-between; margin: 0 4px; padding: 10px 0;">
							<label>${i.getWriter()}</label>
							<label><fmt:formatDate value="${i.getCommentDate()}" type="date" pattern="yyyy.MM.dd HH:mm" /></label>
						</div>
						<div style="margin: 0 14px;">
							<p>${i.getComment()}</p>
						</div>
						<c:if test="${empty sessionScope.UserID}">
		         			<c:if test="${i.getWriter() ne sessionScope.UserID}">
			         			<div style="display: flex; flex-direction:row-reverse; margin: 0 4px; padding: 10px 0;">
			             			<button class="btnn del" id="deleteCmt"><i class="fas fa-trash-alt"></i></button>
			             			<button class="btnn md" id="changeCmt"><i class="fas fa-eraser"></i></button>
			         			</div>
		         			</c:if>
	         			</c:if>
					</div>
				</li>
			</c:forEach>
			</ul>
	            <div class="comment_write">
	            <c:choose>
	            <c:when test="${empty sessionScope.UserID}">
		            <a  id="unlogInedcase_comment" class="form-control" href="/join">로그인 후 이용해주세요.</a>
	            </c:when>
	            <c:otherwise>
	              <form action="/Writeview" method="post" class="comment-form">
	                <textarea  class="form-control" id="comment_textarea" placeholder="댓글을 입력하세요"></textarea>
	                <div class="comment_btn_case">
	                  <input tyep="hidden" name="post_id" value="${post_info.getPost_num()}">
	                  <input tyep="hidden" name="date" value="<%= new Date() %>">
	                  <button class="btn btn-outline-primary" type="submit" id="comment_btn">댓글등록</button>
	                </div>
	              </form>
				</c:otherwise>
	            </c:choose>
	            </div>
	
	          </div>
	
	        </div>
	
	      </section>
	 </div> <!-- content end -->
</div>	      
 </body>
 </html>