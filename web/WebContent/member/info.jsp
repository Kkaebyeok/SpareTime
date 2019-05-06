<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/info.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://jqueryui.com//resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(function() {
	$("#button").click(function() {
		$("#dialog-confirm").dialog({
			resizable : false,
			height : "auto",
			width : 400,
			modal : true,
			buttons : {
				"예" : function() {
					$(this).dialog("close");
					location.href = "delect?id=${loginUser.id}&pw=${loginUser.pw}";
				},
				"아니요" : function() {
					$(this).dialog("close");
				}
			}
		});
	})
	$("#dialog-confirm").hide();
	
	if (sessionStorage.getItem("id") == null) {
		alert("세션이 만료되었습니다. 재로그인 해주세요.");
		location.replace("index");
	}
});
</script>
</head>
<body>
<div id="container">
	<jsp:include page="../common/header.jsp"></jsp:include>
	<section id="content">
    	<article class="myinfo">
        	<div class="box">
            	<div class="top">
                	<h1>내정보</h1>
				</div>
				<div class="middle">
                	<div class="mid-content">
                		<div class="text">
                    		<span>
                    			<p>- <b>${loginUser.nik}</b>님, 반갑습니다. :p</p>
                    		</span>
                        	<span><a href="editinfo">정보수정</a></span>
                        	<span><button type="button" id="button">회원탈퇴</button></span>
						</div>
                    	<div class="firstline">
                    		<p>포인트</p>
							<p>등급</p>
                        	<p>내 글</p>
                        	<p>내 댓글</p>
						</div>
                    	<div class="secondline">
                    		<p>0</p>
							<p>
								<c:if test="${loginUser.admin ==0}">(N)일반회원</c:if>
                            	<c:if test="${loginUser.admin ==1}">(M)관리자</c:if>
                            </p>
                        	<p>0</p>
                        	<p>0</p>
						</div>
					</div>
				</div>
				<div class="side">
					<img alt="logo2" src="images/logo2.jpg">
				</div>
                <div class="back-icon">
                	<a href="index"><p>첫화면으로 가기</p></a>
				</div>
			</div>
		</article>
	</section>
	<div id="dialog-confirm">
		<p>아이디가 삭제됩니다. 진행하시겠습니까?</p>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>