<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>***</title>
    <style>
        html,body{
            margin: 15px;
        }
    </style>
</head>
<body>


    <h3>아이디 중복체크</h3>
    <form action="/join_checkId">
        <input id="checked_id" type="text" name="UserID" placeholder="Enter your ID" required>
        <button type="button" class="id_check_btn">중복확인</button>
    </form>
    
    	<%
		String UserID = "";
		if(request.getAttribute("UserID") != null) {
			UserID = (String)request.getAttribute("UserID");
		}
		String result = ""; 
		if(request.getAttribute("result") != null) {
			result = (String)request.getAttribute("result");
		}
		if(result == "0") {result = "사용 가능한 아이디입니다.";}
		else if(result == "1") {result = "이미 존재하는 아이디입니다.";}
		%>
   
   		 <h3><%= result%></h3>
   		 <%
   			 if(result =="0"){
        %>
				<button type="submit" onclick="apply()">아이디 사용하기</button>
        <%		
        	} 
        %>
   <script type="text/javascript">
   function apply(){
	    const id =document.getElementById("checked_id").value;
	    window.opener.document.getElementById("confirmed_id").value = id;
	    window.close();
   }
   </script>
    
</body>
</html>