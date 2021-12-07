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
            List<MainpageDTO> datas = (List<MainpageDTO>) request.getAttribute("datas");					 
			for(MainpageDTO dto : datas){
            
            %>
              <li><a href="#"><%=dto.getBOARD_NAME() %></a></li>
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
                <tr>
                <%
                List<MainpageDTO> boardlist = (List<MainpageDTO>) request.getAttribute("boardlist");					 
			   for(MainpageDTO dto : boardlist){
            
                %>
                  <td style="width: 15%;"><a href="/BoardSelectController?board_select=<%=<dto.getBoard_num> %>"><%=dto.getBOARD_NAME() %></a></td>
                  <td style="width: 50%;"><a href="/<%= %>"><%=dto.getPost_title() %></a></td>
                  <td style="width: 15%;"><a href="/<%= %>"><%=dto.getUser_id() %></a></td>
                  <td style="width: 20%;"><a href="/<%= %>"><%=dto.getPost_date() %></a></td>
                  
                  <%
			    }
                  %>
                </tr>
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