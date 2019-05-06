<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="script/member.js"></script>
</head>
<body>
<h1>아이디 중복확인</h1>
<p>아이디는 4글자 이상만 가능합니다.</p>
<form action="idcheck" method="get" name="frm">
<label for="id">아이디</label>
<input type="text" name="id" value="${id}"><input type="submit" value="중복체크">
<br>

<c:if test="${result == 1}">
	<script>opener.document.frm.id.value = ''</script>
	${id}는 이미 사용중인 아이디입니다.
</c:if>
<c:if test="${result == -1}">
	${id}는 사용가능한 아이디입니다.
	<button type="button" onclick="choose()">사용</button>
</c:if>
</form>
</body>
</html>