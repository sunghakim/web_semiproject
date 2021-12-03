<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <script src="https://kit.fontawesome.com/59bfbac17d.js" crossorigin="anonymous"></script>
    <script src="/static/main.js" defer></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="wrap">
    <!-- nav -->
  <nav class="navBar">
    <div class="navBar-container">
      <div class="navBar-home">
        <a href="#"><i class="fas fa-home"> home</i></a>
      </div>
      <div class="navBar-right">
         <ul class="navBar-item">
            <li>관리자님 환영합니다.</li>
            <li><button  type="submit" class="LogOut_btn">Log Out</button></li>
          </ul>
    </div>

    </div>
    </nav>
    <!-- main -->
 <section class="main">
   <!-- categories -->
    <div id="catecol" class="d-flex align-items-start col-lg-3 col-md-3">
        <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
          <button class="nav-link" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home" aria-selected="false" onclick="location.href=''">회원관리</button>
          <button class="nav-link" id="v-pills-profile-tab" data-bs-toggle="pill" data-bs-target="#v-pills-profile" type="button" role="tab" aria-controls="v-pills-profile" aria-selected="false" onclick="location.href=''">게시판관리</button>
          <button class="nav-link active" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-messages" type="button" role="tab" aria-controls="v-pills-messages" aria-selected="true" onclick="location.href=''">공지사항</button>
        </div>
    </div>
   <!-- notice form -->
    <div class="container col-md-12">
    <form id="notice_form" class="" action="">
        <div class="mb-3">
          <label for="notice_form" class="form-label">공지사항</label>
          <input  id="notice_title" class="form-control" type="text" placeholder="제목">
        </div>
        <div class="mb-3">
          <textarea class="form-control" id="notice_textarea" placeholder="내용" style="height: 400px;"></textarea>
        </div>
      
        <div class="mb-3">
          <button id="notic-btn"class="btn btn-outline-primary" type="submit" onclick="noticeAdd()">등록</button>
        </div>
      </form>
    </div>
    </section>

    <!-- footer? -->
    <footer class="footer">
      <div class="footer-container">
        <div class="social">
    
        </div>
        <p></p>
      </div>
      
    </footer>
  </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>