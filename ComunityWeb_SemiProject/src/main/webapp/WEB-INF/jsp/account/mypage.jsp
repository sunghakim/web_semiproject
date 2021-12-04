<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<body>
<div class="wrap">

    <nav class="navBar">
      <div class="navBar-container">
        <div class="navBar-home">
          <a href="index.jsp"><i class="fas fa-home"> home</i></a>
        </div>
        <div class="navBar-right">
          <ul class="navBar-item">
            <li><a href="/mypage">님 환영합니다.</a></li>
            <li><button  type="submit" class="SignUp_btn" onclick="location.href='/logout'">Log Out</button></li>
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
          <a href="/account/changepsw.jsp">비밀번호 변경</a>
          <button id="info_psw_change_btn" class="btn btn-outline-primary" type="button" onclick="quiteCommnutiy()"> 탈퇴하기 </button>
        </div>
      </div>
    </div>
    </section>


    <footer class="footer">
      <div class="footer-container">
        <div class="social">
    
        </div>
        <p></p>
      </div>
      
    </footer>
  </div>
  

  <script type="text/javascript">
  
	  function quiteCommunity(){
	    if(confirm("탈퇴하시겠습니까?")==true){
	    	String result = (String)request.getAttribute("result");
			if (result.equals("QCfailure")) {
				alert("회원 탈퇴 실패: 관리자에게 문의해주세요.");
			}else{
				alert("정상적으로 탈퇴되었습니다.");
			}
	        
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