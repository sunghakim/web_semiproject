<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css" integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 
<style type= "text/css">
 #content {
    width: 60%;
    height: 800px;
    padding: 5px;
}

label {
    margin: 0 5px;
    padding: 10px;
    font-weight: bold;
}

.frmWrite {
    display: flex;
    flex-direction: column;
}

.writeHd {
    display: flex;
    flex-wrap: nowrap;
    justify-content: flex-start;
}

.writeHd > #writeSelect {
    flex:10%;
}
.writeHd > #writeTitle {
    flex:90%;
}

.frm {
    margin: 10px 20px;
    padding: 6px 10px;
    border-width: 1px;
    border-color: rgb(228, 228, 228);
    border-radius: 1mm;
    
}

.frm:hover {
    border-color: rgba(0, 0, 0, 0.418);
    box-shadow : 0 0 4px rgb(170, 170, 170) inset;
}

.frm:focus {
    outline: none;
    border-color: #a00000;
    box-shadow: 0px 0px 0px 6px #ffa1a17e;
    transition: opacity 0.3s ease-in-out;
}

.frm:focus::after {
    opacity: 1;
}

.frm:valid {
    outline: none;
    border-color: #00a028;
    box-shadow: 0px 0px 0px 6px #7cff6b7e;
    transition: opacity 0.3s ease-in-out;
}

.frm:valid::after {
    opacity: 1;
}

textarea {
    width: 100%;
    height: 600px;
}

.btnn {
    outline: none;
    color: #46CDCF;
    font-weight: bold;
    border: 1px solid rgba(0, 0, 0, 0.418);
    border-radius: 4px;
    border-color: rgba(230, 230, 230, 0.527);
    background-color: white;

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
 </style>
 
 <script type="text/javascript">

function back() {
 window.history.back();
}

</script>
 
<title>
<c:if test="${empty post_title}">글쓰기</c:if>
<c:if test="${not empty post_title}">수정하기</c:if>
</title>
</head>
<div id="content">
        <div style="display: flex; justify-content: left; margin: 0 20px; padding: 10px 0;">
            <button class="btnn back" onclick="back();">  </button>
            <c:if test="${empty post_id}"><h1><label class="textLabel">글쓰기</label></h1></c:if>
            <c:if test="${not empty post_id}"><h1><label class="textLabel">수정하기</label></h1></c:if>
        </div>
        <fmt:formatDate value="<%=new Date() %>" pattern="YYYY-MM-dd" var="now" />
        <form class="frmWrite" action="/PostController" method="post" accept-charset="utf-8">
            <div class="writeHd">
                <select class="frm" id="writeSelect" name="board" style="margin-right: 5px;" required>
                    <c:if test="${empty board}">
	                    <option value="">카테고리 선택</option>
	                    <c:forEach var="i" items="${category}">
	                    	<c:choose>
		                    	<c:when test="${category.size() eq 1}">
		                    		<option value="${i.getBOARD_NUM()}" selected>${i.getBOARD_NAME()}</option>
		                    	</c:when>
		                    	<c:otherwise>
		                    		<option value="${i.getBOARD_NUM()}">${i.getBOARD_NAME()}</option>	
		                    	</c:otherwise>
	                    	</c:choose>
	                    </c:forEach>
                    </c:if>
                </select>
                <c:if test="${empty post_title}"><input class="frm" id="writeTitle" name="post_title" placeholder="제목" style="margin-left: 4px;" required></c:if>
            	<c:if test="${not empty post_title}"><input class="frm" id="writeTitle" name="post_title" placeholder="제목" value="${post_title}" style="margin-left: 4px;" required></c:if>
            </div>
            <hr>
            <div class="writeHd">
            	<c:if test="${empty post_content}"><textarea class="frm" id="writeContent" placeholder="내용" name="post_content" style="overflow: auto;" required></textarea></c:if>
            	<c:if test="${not empty post_content}"><textarea class="frm" id="writeContent" placeholder="내용" name="post_content" style="overflow: auto;" required>${post_content}</textarea></c:if>
            </div>
            <input type="hidden" name="date" value="${now}">
            <div style="display: flex; justify-content: space-between; margin: 0 20px; padding: 10px 0;">
              <button class="btnn back2" onclick="back();">취소</button>
              <span>
                <button class="btnn reset" type="reset">다시 작성</button>
                <c:if test="${empty post_title}"><button class="btnn submit" type="submit">작성</button></c:if>
				<c:if test="${not empty post_title}"><button class="btnn submit" type="submit">수정</button></c:if>
                
              </span>
            </div>
        </form>
    </div> <!-- content end -->
</body>
</html>