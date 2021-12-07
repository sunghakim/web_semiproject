<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.web.model.*" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>home</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <script src="https://kit.fontawesome.com/59bfbac17d.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
</head>
<style>
html,
body {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
}
.container {
  min-width: 700px;
}

/* categories */
.main {
  padding: 20px;
  display: flex;
}

#catecol {
  margin-right: 50px;
}
.nav-link {
  height: 50px;
  width: 200px;
  font-size: 17px;
}


/* footer */
.wrap {
  min-height: 100%;
  position: relative;
  padding-bottom: 60px;
}

.footer-container {
  height: 60px;
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
}
/* nav */
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

.SignUp_btn,.LogOut_btn {
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

  table>tbody>tr>td>a{
    text-decoration: none;
    color:black;
  }



</style>
<body>
    <div class="wrap">
       <nav class="navBar">
    	<div class="navBar-container">
      		<div class="navBar-home">
        		<a href="/index.jsp"><i class="fas fa-home"> home</i></a>
      		</div>
      	<div class="navBar-right">
         <ul class="navBar-item">
            <li>관리자님 환영합니다.</li>
            <li><button  type="submit" class="LogOut_btn" onclick="location.href='/logout'">Log Out</button></li>
          </ul>
   		</div>

       </div>
      </nav>
       
      <!-- main -->
<section class="main">
   <!-- categories -->
    <div id="catecol" class="d-flex align-items-start col-lg-3 col-md-3">
        <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
          <button class="nav-link" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home" aria-selected="false" onclick="location.href='/memberlist'">회원관리</button>
          <button class="nav-link" id="v-pills-profile-tab" data-bs-toggle="pill" data-bs-target="#v-pills-profile" type="button" role="tab" aria-controls="v-pills-profile" aria-selected="false" onclick="location.href='/board'">게시판관리</button>
          <button class="nav-link active" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-messages" type="button" role="tab" aria-controls="v-pills-messages" aria-selected="true" onclick="location.href='/noticeList'">공지사항</button>
        </div>
    </div>
      
      
          <!-- main_contents -->
          <section class="container latestboard">
      
            <!-- list of board -->
            <table class="table table-hover">
              <thead>
                <tr>
                  <th scope="col" class="text-center">글 번호</th>
                  <th scope="col" class="text-center">제목</th>
                  <th scope="col" class="text-center">작성자</th>
                  <th scope="col" class="text-center">작성일</th>
                </tr>
              </thead>
              <tbody>
                <%
                List<PostDTO> postList = (List<PostDTO>) request.getAttribute("postList");					 
			   for(PostDTO dto : postList){
            
                %>
                <tr>
                  <td style="width: 15%;"><%=dto.getPost_num() %></td>
                  <td style="width: 50%;"><a href="notice?postNum=<%=dto.getPost_num()%>"><%=dto.getPost_title() %></a></td>                  
                  <td style="width: 15%;"><%=dto.getUser_id() %></td>
                  <td style="width: 20%;"><%=dto.getPost_date() %></td>
                </tr>
                  
                  <%
			    }
                  %>
              </tbody>
            </table>
            
 		<button class="btn btn-outline-secondary" style="font-size:13px;" onclick="location.href='noticeWrite?name=post'">게시글 등록</button>
 
        </section>
        
        <!-- send to noticeWrite -->
</section>
        <!-- footer? -->
    <footer class="footer">
        <div class="footer-container">
        <hr>
        </div>
        
      </footer>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>