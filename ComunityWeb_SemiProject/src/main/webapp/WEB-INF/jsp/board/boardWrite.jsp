<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 
<title>글쓰기</title>
</head>
<div id="content">
        <div style="display: flex; justify-content: left; margin: 0 20px; padding: 10px 0;">
            <button class="btnn back">  </button>
            <h1><label class="textLabel">글쓰기</label></h1>
        </div>
        <form class="frmWrite">
            <div class="writeHd">
                <select class="frm" id="writeSelect" name="board" style="margin-right: 5px;" required>
                    <option value="">카테고리 선택</option>
                    <c:forEach var="i" items="${category}">
                    	<option value="${i.getBOARD_NUM()}">${i.getBOARD_NAME()}</option>
                    </c:forEach>
                </select>
                <input class="frm" id="writeTitle" name="post_title" placeholder="제목" style="margin-left: 4px;" required>
            </div>
            <hr>
            <div class="writeHd">
              <textarea class="frm" id="writeContent" placeholder="내용" name="post_content" style="overflow: auto;" required></textarea>
            </div>
            <div style="display: flex; justify-content: space-between; margin: 0 20px; padding: 10px 0;">
              <button class="btnn back2">취소</button>
              <span>
                <button class="btnn reset" type="reset">다시 작성</button>
                <button class="btnn submit" type="submit">작성</button>
              </span>
            </div>
        </form>
    </div> <!-- content end -->
</body>
</html>