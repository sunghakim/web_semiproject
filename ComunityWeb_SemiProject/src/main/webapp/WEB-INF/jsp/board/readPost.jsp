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
<script src="https://kit.fontawesome.com/59bfbac17d.js" crossorigin="anonymous"></script>
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

.navBar-right .navBar-item > li > a {
  color: black;
  text-decoration: none;
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

.footer-container {
  height: 60px;
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
}
</style>
<script>
function writeCheck() {
	 var login ='<%=(String)session.getAttribute("UserID")%>';

     if(login == "null"){ 
        alert("????????? ??? ???????????????."); 
     }
     else{
        location.replace("/PostController");
     }
}
</script>

<title>${post_info.getPost_title()}</title>
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
              		<li><a href="/mypage"><%=(String) request.getSession().getAttribute("UserID")%>??? ???????????????.</a></li>
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
        <button id="writePost" type="button" onclick="writeCheck()">?????????</button>
    </div>
    <div class="tab-list">
      <button class="category active" onclick="location.href='/BoardSelectController?board_num=0&page_num=1'">????????????</button>
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
	     <div style="display: flex; justify-content: space-between;">
	         <div style="display: flex; justify-content: left; height: 100px; margin: 0; padding: 10px 0;">
	             <div style="display: flex; flex-direction: column; align-content: flex-end;">
	                 <label style="color:#46CDCF; font: size 10px;">${post_info.getBoard_name()}</label>
	                 <h1 style="margin: 0;"><label class="textLabel" style="font-weight: bold;">${post_info.getPost_title()}</label></h1>
	             </div>
	         </div>
	         <c:if test="${!empty sessionScope.UserID}">
		         <c:if test="${post_info.getUser_id() eq sessionScope.UserID}">
			         <div style="display: flex; align-items: flex-end; margin: 0 20px; padding: 10px 0;">
			             <button class="btnn md" id="change" onclick="location.href='/PostController?post_id=${post_info.getPost_num()}'"><i class="fas fa-eraser"></i></button>
			             <button class="btnn delete" id="del" onclick="location.href='/PostDelete?post_id=${post_info.getPost_num()}'"><i class="fas fa-trash-alt"></i></button>
			         </div>
		         </c:if>
	         </c:if>
	     </div>
	     <div id="postInfo">
	         <label>????????? ${post_info.getUser_id()}</label> |
	         <label>????????? <fmt:formatDate value="${post_info.getPost_date()}" type="date" pattern="yy-MM-dd" /></label>
	     </div>
	     <hr>
	     <div id="contentBox">
	         <p style="overflow: auto;">${post_info.getPost_content()}</p>
	     </div>
	    
	
	 	<c:if test="${post_info.getBoard_num() ne 0}">
	      <hr>
	      <section class="response">
	        <div class="container">
	          <header class="section-header">
	            <h6 class="section-title">${cList.size()}?????? ??????</h6>
	          </header>
			<ul class="list-group list-group-flush" id="comments">
				<c:forEach var="i" items="${cList}">
				<li class="list-group-item" style="padding: 0;">
					<div style="border: 1px solid transparent; border-radius:4px; border-color: #e9ecef; margin: 0; padding: 4px 8px;">
						<div style="display: flex; justify-content: space-between; margin: 0 4px; padding: 10px 0;">
							<label>${i.getWriter()}</label>
							<label><fmt:formatDate value="${i.getCommentDate()}" type="date" pattern="yyyy.MM.dd" /></label>
						</div>
						<div style="display: flex; justify-content: space-between;">	
							<div style="width=80%; margin: 0 14px;">
								<p>${i.getComment()}</p>
							</div>
							<c:if test="${!empty sessionScope.UserID}">
			         			<c:if test="${i.getWriter() eq sessionScope.UserID}">
				         			<div style="margin: 0 4px; padding: 10px 0;">
				             			<button class="btnn md" id="changeCmt" onclick="location.href='/CommentChange?comment_id=${i.getCommentId()}'"><i class="fas fa-eraser"></i></button>
				             			<button class="btnn del" id="deleteCmt" onclick="location.href='/CommentDelete?comment_id=${i.getCommentId()}'"><i class="fas fa-trash-alt"></i></button>
				         			</div>
			         			</c:if>
		         			</c:if>
		         		</div>
					</div>
				</li>
				</c:forEach>
			</ul>
	            <div class="comment_write">
	            <fmt:formatDate value="<%=new Date() %>" pattern="YYYY-MM-dd" var="now" />
	            <c:choose>
	            <c:when test="${empty sessionScope.UserID}">
		            <a  id="unlogInedcase_comment" class="form-control" href="/login">????????? ??? ??????????????????.</a>
	            </c:when>
	            <c:otherwise>
	              <form action="/Writeview" method="post" accept-charset="utf-8" class="comment-form">
					<c:if test="${empty comments}"><textarea  class="form-control" id="comment_textarea" name="context" placeholder="????????? ???????????????"></textarea></c:if>
					<c:if test="${not empty comments}"><textarea  class="form-control" id="comment_textarea" name="context" placeholder="????????? ???????????????">${comments}</textarea></c:if>
	                <div class="comment_btn_case">
	                  <input type="hidden" name="post_id" value="${post_info.getPost_num()}">
	                  <input type="hidden" name="date" value="${now}">
	                  <input type="hidden" name="comment_id" value="${comment_id}">
	                  <button class="btn btn-outline-primary" type="submit" id="comment_btn">????????????</button>
	                </div>
	              </form>
				</c:otherwise>
	            </c:choose>
	            </div>
	
	          </div>
	      </section> <!-- response end -->
	 </c:if>
	 </div> <!-- content end -->
	 
	 <footer class="footer">
        <div class="footer-container">
            <hr>

        </div>

      </footer>
</div>	      
</div>
 </body>
 </html>