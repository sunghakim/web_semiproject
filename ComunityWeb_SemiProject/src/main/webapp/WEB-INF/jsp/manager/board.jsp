<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.web.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판관리</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <script src="https://kit.fontawesome.com/59bfbac17d.js" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
</head>
<body>
  <div class="wrap">
    <!-- nav -->
    <nav class="navBar">
      <div class="navBar-container">
        <div class="navBar-home">
          <a href="/main"><i class="fas fa-home"> home</i></a>
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
    <div id="catecol" class="d-flex align-items-start col-lg-3 col-md-3" >
        <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
          <button class="nav-link" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home" aria-selected="true" onclick="location.href='/memberlist'">회원관리</button>
          <button class="nav-link active" id="v-pills-profile-tab" data-bs-toggle="pill" data-bs-target="#v-pills-profile" type="button" role="tab" aria-controls="v-pills-profile" aria-selected="false" onclick="location.href='/board'">게시판관리</button>
          <button class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-messages" type="button" role="tab" aria-controls="v-pills-messages" aria-selected="false" onclick="location.href='/noticeList'">공지사항</button>
        </div>
    </div>

    <!-- main_contents -->

    <section class="container">

      <!-- list of board -->
      
      <div class="row">
          <div class="col-md-12">
              <div class="card">
                  <div class="card-body">
                      <h5 class="card-title text-uppercase mb-0">게시판 목록</h5>
                  </div>
                  <div class="table-responsive">
                      <table class="table no-wrap user-table mb-0">
                        <thead>
                          <tr>
                            <th scope="col" class="border-0 text-uppercase font-medium">ID</th>    
                            <th scope="col" class="border-0 text-uppercase font-medium">Name</th>
                            <th scope="col" class="border-0 text-uppercase font-medium">Manage</th>
                          </tr>
                        </thead>
                        <tbody>
                        
                          <%
                         List<BoardManageDTO> datas = (List<BoardManageDTO>) request.getAttribute("datas");					 
                         					for(BoardManageDTO dto : datas){
                         %>
                         <form action="board" method="post">
                         <tr>
                            <td class="pl-4">
                            	<h5 class="font-medium mb-0"><%=dto.getBOARD_NUM() %></h5>
                            	<input type="hidden" name="delete" value="<%=dto.getBOARD_NUM() %>">
                            </td>
                            <td>
                                <h5 class="font-medium mb-0" id="<%=dto.getBOARD_NUM() %>"><%=dto.getBOARD_NAME() %></h5>
<                               <div class="input_hidden">
								  <input type="hidden" name="update" value="<%=dto.getBOARD_NUM() + " " +dto.getBOARD_NAME()%>"/>
                                  <input type="text" name="update" placeholder="게시판 아이디"/>
                                  <input type="text" name="update" placeholder="게시판 이름"/>
                                  <button class="hidden_input_Btn" type="submit" name="send" value="updateSubmit"><i class="fas fa-check"></i></button>
                                </div>
                            </td>

                            <td>
                              
                             <button type="button" id="memberlist-edit" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2" onclick="updateBoard()"><i class="fas fa-edit"></i></button>
                             <button type="submit" name="send" value="deleteSubmit" id="memberlist-edit" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2" onclick="deleteBoard()"><i class="fas fa-trash-alt"></i></button>
                             
                            </td>
                          </tr>  
                          </form>
                        <%
                        }
                        %> 
                        
                        
                        </tbody>
                      
                      </table>
                  </div>
              </div>
              
          </div>
          
      </div>

   
      <hr>

      
      <!-- add board -->
	
 
      <div class="card">
        <div class="card-body">
          <h5 class="card-title text-uppercase mb-0">게시판 등록</h5>
        </div>
        <form class="addboard_form" action="board" method="post">
            <input type="text" name="create" id="board_name" placeholder="게시판 아이디">
            <input type="text" name="create" id="board_name" placeholder="게시판 이름">
            
            <button type="submit" name="send" value="createSubmit" id="addboard_btn" class="btn btn-outline-primary" onclick="boardAdd()">등록</button>

        </form>

      </div>

      </section>

  

    <!-- footer? -->
    <footer class="footer">
        <div class="footer-container">
          <hr>
        </div>
        
      </footer>
    </div>
    
    <script type="text/javascript">
    const input_type =  document.querySelector(".input_hidden");

    function updateBoard(){
        input_type.classList.toggle('visible');
    }
    
    function deleteBoard(){
    	document.form.submit();
    }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>