<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판관리</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <script src="https://kit.fontawesome.com/59bfbac17d.js" crossorigin="anonymous"></script>
    <script src="/static/main.js"defer></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
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
    <div id="catecol" class="d-flex align-items-start col-lg-3 col-md-3" >
        <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
          <button class="nav-link" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home" aria-selected="true" onclick="location.href=''">회원관리</button>
          <button class="nav-link active" id="v-pills-profile-tab" data-bs-toggle="pill" data-bs-target="#v-pills-profile" type="button" role="tab" aria-controls="v-pills-profile" aria-selected="false" onclick="location.href=''">게시판관리</button>
          <button class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill" data-bs-target="#v-pills-messages" type="button" role="tab" aria-controls="v-pills-messages" aria-selected="false" onclick="location.href=''">공지사항</button>
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
                            <th scope="col" class="border-0 text-uppercase font-medium pl-4">#</th>
                            <th scope="col" class="border-0 text-uppercase font-medium">ID</th>    
                            <th scope="col" class="border-0 text-uppercase font-medium">Name</th>
                            <th scope="col" class="border-0 text-uppercase font-medium">Manage</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td class="pl-4"><input type="checkbox" value=""> 1</td>
                            <td class="pl-4"><h5 class="font-medium mb-0">asdlasdkjals</h5></td>
                            <td>
                                <h5 class="font-medium mb-0">ㅁㄴㅇㅁㅇ;ㅏㅁ</h5>
                           </td>

                            <td>
                              <button type="button" id="memberlist-edit" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2"><i class="fas fa-edit"></i></button>
                            </td>
                          </tr>  
                        </tbody>
                        <tfoot>
                          <tr>
                            <td><input type="checkbox" value="selectall" onclick="selectAll(this)"> 전체 선택</td>
                            <td></td>
                            <td></td>
                            <td><button type="button" id="memberlist-clearall" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2" onclick="deleteall(this)"><i class="fas fa-trash-alt"></i> </button></td>
                          </tr>
                        </tfoot>
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
        <form class="addboard_form" action="" method="">
            <input type="text" name="" id="board_name" placeholder="게시판 이름">
            <button type="submit" id="addboard_btn" class="btn btn-outline-primary" onclick="boardAdd()">등록</button>

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