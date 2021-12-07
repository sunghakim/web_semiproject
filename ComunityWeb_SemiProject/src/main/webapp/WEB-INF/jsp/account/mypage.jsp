<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.web.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>내정보</title>
    <link rel="stylesheet" href="/static/css/style.css">
    <script src="https://kit.fontawesome.com/59bfbac17d.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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

/* mypage */
h4 {
  width: 150px;
}
.navBar-item li a {
  color: black;
  text-decoration: none;
  display: inline-block;
  transition: all 100ms ease-in-out;
}
.navBar-item li a:hover {
  transform: scale(1.02);
}

.card.info {
  width: 60%;
}
.info_box {
  display: flex;
  margin-top: 40px;
}

.info_img {
  margin: 0 60px 40px 40px;
}
.info_id,
.info_psw {
  display: flex;
}
.info_details > a {
  text-decoration: none;
  display: block;
}

.info_details > button {
  position: absolute;
  right: 40px;
  font-size: 15px;
}

</style>
<body>
<div class="wrap">

    <nav class="navBar">
      <div class="navBar-container">
        <div class="navBar-home">
          <a href="index.jsp"><i class="fas fa-home"> home</i></a>
        </div>
        <div class="navBar-right">
          <ul class="navBar-item">

            <li><a href="/mypage"><%=(String) request.getSession().getAttribute("UserID")%>님 환영합니다.</a></li>
            <li><button  type="submit" class="LogOut_btn" onclick="location.href='/logout'">Log Out</button></li>
          </ul>
        </div>

          </div>
    </nav>

 <section class="main">

    <div id="catecol" class="d-flex align-items-start col-lg-3 col-md-3">
        <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical">
          <button class="nav-link active" id="v-pills-home-tab" data-bs-toggle="pill" data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home" aria-selected="false" onclick="location.href=''">마이 페이지</button>
        </div>
    </div>



    <div class="card info">

      <div class="info_box">
        <div class="info_img">
          <i class="fas fa-user fa-7x"></i>
        </div>

        <div class="info_details">
          <div class="info_id">
            <h4>ID</h4>
          </div>
          <div class="info_psw">
            <h4>PassWord</h4>
          </div>
          <a href="/changepsw">비밀번호 변경</a>
          <button id="info_psw_change_btn" class="btn btn-outline-primary" type="button" onclick="quiteCommunity()"> 탈퇴하기 </button>
        </div>
      </div>
    </div>
    </section>


    <footer class="footer">
      <div class="footer-container"> 
    <hr>
      </div>
      
    </footer>
  </div>
  

  <script type="text/javascript">
  
	  function quiteCommunity(){
		  if(confirm("탈퇴하시겠습니까.")==true){
			  location.href="/quitAction";
		  }else{
			  return;
		  }
	}
	  
  </script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>