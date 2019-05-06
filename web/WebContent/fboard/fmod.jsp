<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/mod.css">
<link rel="stylesheet" href="css/common.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/12.1.0/classic/ckeditor.js"></script>
<script>
if (sessionStorage.getItem('id') == null) {
	alert("세션이 만료되었습니다. 재로그인 해주세요.");
	location.replace("index");
}
$(()=>{
	ClassicEditor
	.create(document.querySelector('#editor'), {
		removePlugins: [ 'ImageUpload' ],
		
	})
	.catch( error => {
	    console.error( error );
	});
});
</script>
</head>
<body>
<div id="container">
<jsp:include page="../common/header.jsp"/>
<section id="content">
	<article class="notice">
		<div class="header">
			<h1>게시판</h1>
		</div>
		<form name="frm" method="post" onsubmit="return submitCheck()" enctype="multipart/form-data">
			<input type="hidden" name="boardNo" value="${fboard.boardNo}">
			<table class="table">
				<tr>
					<th class="text">제목</th>
					<td colspan="3"><input type="text" name='title' class="box" value="${fboard.title}" required="required"></td>
				</tr>
				<tr>
					<th class="text">작성자</th>
					<td colspan="3"><input type="text" name='writer' class="box" readonly="readonly" value="${loginUser.id}"></td>
				</tr>
				<tr>
					<th class="text">업로드</th>
					<td>
						<input type="file" name="pic" accept=".png, .jpg, .jpeg, .gif" multiple="multiple">
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<div>
							<textarea name="content" id="editor">${fboard.content}</textarea>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="buttons">
						<a href="flist" onclick="return confirm('목록으로 가시겠습니까?')"><button type="button">취소</button></a>
						<button type="reset">초기화</button>
						<button type="submit">수정</button>
					</td>
				</tr>
			</table>
		</form>
	</article>
</section>
<jsp:include page="../common/footer.jsp"/>
</div>
</body>
</html>