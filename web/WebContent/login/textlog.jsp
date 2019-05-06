<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="script/member.js"></script>
<script>
$(() => {
	var id = sessionStorage.getItem("id");
	var pw = sessionStorage.getItem("pw");
	
	$.ajax("loginAjax", {
		data : "id="+id+"&pw="+pw
		
	}).done(function(data){
		data = data.trim();
		console.log(data);
		var str = "";
		if(data == 0) {
			str = "아이디가 없습니다.";
		}
		else if(data == 1) {
			str = id + "님 로그인되었습니다."
		}
		else if(data == 2) {
			str = "비밀번호가 다릅니다.";
		}
		$("#respText").text(str);
	});
});
</script>
</head>
<body>
<h1>로그인</h1>
<p id="respText"></p>
<button type="button" onclick="self.close()">확인</button>
</body>
</html>