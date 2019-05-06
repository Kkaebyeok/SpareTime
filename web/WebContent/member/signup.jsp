<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/allLogin.css">
<link rel="stylesheet" href="css/signup.css">
<script src="script/member.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
<div id="container">
	<jsp:include page="../common/loginHeader.jsp"></jsp:include>
	<section id="content">
		<article class="join">
        	<div class="translucent-box">
            	<div class="topbox">
                	<form action="signup" name="frm" method="post" autocomplete="off" onsubmit="return joinCheck()">
                    	<div class="member-id">
                        	<label for="ID">아이디</label>
                        	<input type="hidden" name = "reid" size="20">
                        	<button type="button" class="check" onclick="return idCheck()">중복확인</button>
                            <br>
                            <input type="text" name="id" size="34" class="border" placeholder="아이디를 입력하세요." required>
						</div>
                        <div class="member-pw">
                        	<label for="pass">비밀번호</label>
                            <br>
                            <input type="password" name="pw" size="34" class="border" placeholder="비밀번호를 입력하세요." required>
						</div>
                        <div class="member-pw">
                            <label for="pw">비밀번호확인</label>
                            <br>
                            <input type="password" name="pw_check" size="34" class="border" placeholder="위와같은 비밀번호를 입력하세요." required>
                        </div>
                        <div class="member-etc">
                            <label for="nikename">이름</label>
                            <br>
                            <input type="text" name="name" size="34" class="border" placeholder="이름을 입력하세요." required>
                        </div>
                        <div class="member-etc">
                            <label for="nikename">Nikename</label>
                            <br>
                            <input type="text" name="nik" size="34" class="border" placeholder="사용할 닉네임을 입력하세요." required>
                        </div>
                        <div class="member-etc">
                            <label for="email">이메일</label>
                            <br>
                            <input type="email" name="email" size="34" class="border" placeholder="이메일을 입력하세요." required>
                        </div>
                        <div class="member-etc">
                            <label for="tel">휴대전화</label>
                            <br>
                            <input type="tel" name="tel" size="34" class="border" placeholder="번호를 입력하세요." required>
                        </div>
                        <div class="member-etc">
                            <label for="post">회원등급</label>
                            <br>
                            <input type="radio" name="admin" value="0" checked="checked" class="radio">일반회원
                            <input type="radio" name="admin" value="1" class="radio">관리자
                        </div>
                        <hr>
                        <div class="button">
                            <a href="login" onclick="return confirm('취소하시겠습니까?')"><span>취소</span></a>
                            <input type="submit" value="확인">
                        </div>
					</form>
				</div>
			</div>
		</article>
	</section>
	<jsp:include page="../common/loginFooter.jsp"></jsp:include>
</div>
</body>
</html>