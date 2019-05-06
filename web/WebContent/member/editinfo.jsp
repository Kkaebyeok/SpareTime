<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Spare Time</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/editinfo.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
if (sessionStorage.getItem("id") == null) {
	alert("세션이 만료되었습니다. 재로그인 해주세요.");
	location.replace("index");
}
</script>
</head>
<body>
<div id="container">
	<jsp:include page="../common/header.jsp"></jsp:include>
	<section id="content">
		<article class="myinfo">
        	<div class="box">
            	<div class="top">
                	<h1>정보수정</h1>
				</div>
                <div class="middle">
                	<form method="post" autocomplete="off" onsubmit="return editCheck()">
                		<input type="hidden" name="id" value="${loginUser.id}">
                       <div class="info">
                        	<div class="left">
                        		<div>
                            		<label for="id">아이디</label>
                                	<br>
                                	<input type="text" name="id" id="id" size="34" class="border" value="${loginUser.id}" readonly>
								</div>
								<div>
                            		<label for="pw">비밀번호</label>
                                	<br>
                                	<input type="password" name="pw" id="pw" size="34" class="border" placeholder="Change Password" required>
								</div>
                            	<div>
                            		<label for="pw_check">비밀번호확인</label>
                                	<br>
									<input type="password" name="pw_check" id="pw_check" size="34" class="border" placeholder="Re-enter Password " required>
								</div>
                            	<div>
                            		<label for="name">이름</label>
                               		<br>
                                	<input type="text" name="name" id="name" size="34" class="border" placeholder="Change Nickname" required>
								</div>
							</div>
							<div class="right">
                            	<div>
                            		<label for="nik">Nikename</label>
                                	<br>
                                	<input type="text" name="nik" id="nik" size="34" class="border" placeholder="Change Nickname" required>
								</div>
                            	<div>
                            		<label for="email">이메일</label>
                                	<br>
                                    <input type="email" name="email" id="email" size="34" class="border" placeholder="emall" required>
								</div>
                            	<div>
                            		<label for="tel">휴대전화</label>
                                	<br>
                                    <input type="tel" name="tel" id="tel" size="34" class="border" placeholder="Tel" required>
								</div>
                            	<div>
                            		<label for="admin">회원등급</label>
                                	<br>
                                    <input type="radio" name="admin" value="0" checked="checked" class="radio">일반회원
                            		<input type="radio" name="admin" value="1" class="radio">관리자
								</div>
                            	<div class="button">
                            		<input type="reset" value="다시입력">
									<input type="submit" value="수정완료">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="side">
				<img alt="logo2" src="images/logo2.jpg">
			</div>
            <div class="back-icon">
            	<a href="info" onclick="confirm('입력한 내용은 저장되지않습니다.')"><p>돌아가기</p></a>
			</div>
		</article>
	</section>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>