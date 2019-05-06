<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/write.css">
<link rel="stylesheet" href="css/common.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/12.1.0/classic/ckeditor.js"></script>
<script>
if (sessionStorage.getItem("id") == null) {
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
<jsp:include page="../common/header.jsp"></jsp:include>
<section id="content">
	<article class="notice">
		<div class="header">
			<h1>공지사항</h1>
		</div>
		<form name="frm" method="post" onsubmit="return submitCheck()">
		<table class="table">
			<tr>
				<th class="text">제목</th>
				<td colspan="3"><input type="text" name='title' class="box" placeholder="제목을 입력하세요." required="required"></td>
			</tr>
			<tr>
				<th class="text">작성자</th>
				<td colspan="3"><input type="text" name='writer' class="box" value="${loginUser.id}"></td>
			</tr>
			<tr>
				<td colspan="4">
					<textarea name="content" id="editor"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="buttons">
					<a href="list" onclick="return confirm('목록으로 가시겠습니까?')"><button type="button">취소</button></a>
					<button type="reset">초기화</button>
					<button type="submit">글쓰기</button>
				</td>
			</tr>
		</table>
		</form>
	</article>
</section>
<jsp:include page="../common/footer.jsp"></jsp:include>
</div>
</body>
</html>