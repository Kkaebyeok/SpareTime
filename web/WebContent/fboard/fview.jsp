<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/fview.css">
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
						location.href = "fdel?no=${fboard.boardNo}";
					},
					"아니요" : function() {
						$(this).dialog("close");
					}
				}
			});
		})
		$("#dialog-confirm").hide();
	});
</script>
</head>
<body>
	<div id="container">
		<jsp:include page="../common/header.jsp"></jsp:include>
		 <section id="content">
            <article class="notice">
                <div class="box">
                    <div class="top">
                        <h1>게시판</h1>
                        <h4>${fboard.title}</h4>
                        <h5>${fboard.writer}</h5>
                        <p>${fboard.regDate}</p>
                        <span>${fboard.cnt}</span>
                        <span>조회수</span>
                        <hr>
                    </div>
                    <div class="text">
						<c:if test="${fboard.pic==null}">
							<img alt="NoImg" src="images/noImg.gif">
						</c:if>
						<img alt="${fboard.pic}" src="upload/${fboard.pic}">
                        <p>${fboard.content}</p>
                    </div>
                    <hr>
                    <div class="modify">
                    <c:if test="${loginUser.id == fboard.writer}">
                        <a href="fmod?no=${fboard.boardNo}"><p>수정</p></a>
					</c:if>
                    <c:if test="${loginUser.id == fboard.writer || loginUser.admin==1}">
                        <button type="button" id="button">삭제</button>
                    </c:if>
                    </div>
                    <div class="back-icon">
                        <a href="flist"><p>목록으로</p></a>
                    </div>
                </div>
            </article>
        </section>
	<div id="dialog-confirm">
		<p>게시글이 삭제됩니다. 진행하시겠습니까?</p>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
</html>