<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/allLogin.css">
<link rel="stylesheet" href="css/login.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="script/member.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
history.go(1);
</script>
</head>
<body>
<div id="container">
	<jsp:include page="../common/loginHeader.jsp"></jsp:include>
	<section id="content">
    	<article class="login">
        	<form action="login" name="frm" autocomplete="off" method="post" onsubmit="return loginCheck()">
				<div class="id-border">
					<label for="id">
						<input type="text" name="id" id="id" size="25" class="idbox" placeholder="아이디를 입력하세요." required>
					</label>
				</div>
                <br>
                <div class="pw-border">
                	<label for="pw">
                    	<input type="password" name="pw" id="pw" size="25" class="pwbox" placeholder="비밀번호를 입력하세요." required>
					</label>
				</div>
                <div class="loginbox">
					<input type="image" class="loginbox" id="butt" src="images/submit.PNG" alt="login">
				</div>
			</form>
			<div>
				<div class="find">
					<a href="signup"><p><small>회원가입</small></p></a>
				</div>
			</div>
		</article>
	</section>
	<jsp:include page="../common/loginFooter.jsp"></jsp:include>
</div>
</body>
</html>