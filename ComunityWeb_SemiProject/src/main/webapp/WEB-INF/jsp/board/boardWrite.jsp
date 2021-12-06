<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="/static/css/boardWrite.css" type="text/css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css" integrity="sha384-jLKHWM3JRmfMU0A5x5AkjWkw/EYfGUAGagvnfryNV3F9VqM98XiIH7VBGVoxVSc7" crossorigin="anonymous">    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 
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
                    <c:forEach var="i" items="${board}">
                    	<option value="${i.boardNum}">${i.boardName}</option>
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