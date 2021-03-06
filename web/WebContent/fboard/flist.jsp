<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/flist.css">
<script>
</script>
</head>
<body>
<div id="container">
<jsp:include page="../common/header.jsp"></jsp:include>
<section id="content">
	<article class="notice">
		<div class="header">
			<h1>게시판</h1>
		</div>
		<table class="table">
			<tr class="box">
    			<th>번호</th>
        		<th>제목</th>
        		<th>등록일</th>
        		<th>작성자</th>
			</tr>
		<c:forEach items="${list}" var="i">
    		<tr>
    			<td>${i.boardNo}</td>
	    		<td><a href="fview?no=${i.boardNo}">${fn:escapeXml(i.title)}<small>[${i.cnt}]</small></a></td>
	    		<td>${i.regDate}</td>
	    		<td>${i.writer}</td>
	    	</tr>
		</c:forEach>
		</table>
    	<div class="number">
    		<c:if test="${page > 1}">
    		<a href="flist?page=${minPage}"><button type="button">처음</button></a>
    		</c:if>
    		<c:if test="${page > 1}">
    		<a href="flist?page=${page-1}"><button type="button">이전</button></a>
    		</c:if>
    		<c:if test="${page < maxPage}">
    		<a href="flist?page=${page+1}"><button type="button">다음</button></a>
    		</c:if>
    		<c:if test="${page < maxPage}">
    		<a href="flist?page=${maxPage}"><button type="button">끝</button></a>
    		</c:if>
			<c:if test="${sessionScope.loginUser.id !=null}">
    		<a href="fwrite"><button type="button">글 추가</button></a>
    		</c:if>
    	</div>
    </article>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>

</div>
</body>
</html>