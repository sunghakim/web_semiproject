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




/* main */

.d-sm-flex {
  justify-content: space-around;
}

.d-sm-flex > img {
  max-width: 400px;
}
.d-sm-flex > div > h1 {
  margin-bottom: 50px;
}

.sidebar {
  padding-left: 50px;
}
.sidebar > header {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 15px;
}
.sidebar > ul > li > a {
  text-decoration: none;
  color: darkgrey;
  height: 100%;
  width: 100%;
  display: inline-block;

  font-size: 18px;
  transition: 0.4s;
  margin-bottom: 10px;
}

.sidebar > ul > li:hover a {
  padding-left: 5px;
  color: #000;
}

.container.latestboard {
  width: 60%;
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
                <a href="/main"><i class="fas fa-home"> home</i></a>
              </div>
              <div class="navBar-right">
                <ul class="navBar-item">
      
                   <li><button type="button" class="SignIn_btn" onclick="location.href='/login'">Sign In</button></li>
                   <li><button  type="button" class="SignUp_btn" onclick="location.href='/join'">Sign Up</button></li>
                 </ul>
               </div>
             </div>
      
             
             </nav>
       
      <!-- main -->
      <section class="bg-dark text-light p-5 text-center">
          <div class="container">
              <div class="d-sm-flex">
                  <div>
                      <h1>Feel Free to Post <br>Anything You Want</h1>
                      <button class="btn btn-primary btn-lg" onclick="location.href='/join'">Start now</button>
                  </div>
                  <img class="img-fluid w-50" src="/static/imgsss.jpg" alt="" style="box-shadow:5px 5px 10px black;">
              </div>
          </div>
      </section>


   
   
        <!-- categories -->
        <section class="main">
          <div class="sidebar">
            <header>Category</header>
            <ul>
            <%
            List<BoardManageDTO> datas = (List<BoardManageDTO>) request.getAttribute("datas");					 
			for(BoardManageDTO dto : datas){
            
            %>
              <li><a href="/BoardSelectController?board_select=<%= dto.getBOARD_NUM() %>&page_num=1"><%= dto.getBOARD_NAME() %></a></li>
              <%
			}
              %>
 
            </ul>
          </div>
      
          <!-- main_contents -->
          <section class="container latestboard">
      
            <!-- list of board -->
            <table class="table table-hover">
            <h3>최신글</h3>
              <thead>
                <tr>
                  <th scope="col" class="text-center">카테고리</th>
                  <th scope="col" class="text-center">제목</th>
                  <th scope="col" class="text-center">작성자</th>
                  <th scope="col" class="text-center">작성일</th>
                </tr>
              </thead>
              <tbody>
               
                <%
                List<MainpageDTO> boardlist = (List<MainpageDTO>) request.getAttribute("boardlist");					 
			   for(MainpageDTO dto : boardlist){
            
                %>
                 <tr>
	                  <td style="width: 15%;"><a href="/BoardSelectController?board_num=<%= dto.getBoard_num() %>&page_num=1"><%= dto.getBoard_name() %></a></td>
	                  <td style="width: 50%;"><a href="/Writerview?post_id=<%= dto.getPost_num() %>"><%=dto.getPost_title() %></a></td>
	                  <td style="width: 15%;"><%=dto.getUser_id() %></td>
	                  <td style="width: 20%;"><%=dto.getPost_date() %></td>
                  </tr>
                  <%
			    }
                  %>
                
              </tbody>
            </table>
 
        </section>
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