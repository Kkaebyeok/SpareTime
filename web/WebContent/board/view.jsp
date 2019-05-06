<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/view.css">
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
						location.href = "del?no=${board.boardNo}";
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
                        <h1>공지사항</h1>
                        <h4>[공지] ${board.title}</h4>
                        <p>${board.regDate}</p>
                        <span>${board.cnt}</span>
                        <span>조회수</span>
                        <hr>
                    </div>
                    <div class="text">
                        <p>${board.content}</p>
                    </div>
                    <hr>
                    <div class="modify">
                    <c:if test="${loginUser.admin == 1}">
                        <a href="mod?no=${board.boardNo}"><p>수정</p></a>
                        <button type="button" id="button">삭제</button>
                    </c:if>
                    </div>
                    <div class="back-icon">
                        <a href="list"><p>목록으로</p></a>
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