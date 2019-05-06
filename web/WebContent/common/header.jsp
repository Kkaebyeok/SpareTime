<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<div class="main">
		<span><a href="index"><h1>Spare Time</h1></a></span>
		<ul class="user-state">
		<c:if test="${loginUser.id != null}">
			<li><a href="logout" onclick="return comfirm(로그아웃 하시겠습니까?)">로그아웃</a></li>
			<li><a href="info">내정보</a></li>
		</c:if>
		<c:if test="${loginUser.id == null}">
			<li><a href="signup">회원가입</a></li>
			<li><a href="login">로그인</a></li>
		</c:if>
		
		</ul>
	</div>
		<nav>
			<ul class="main-nav">
				<a href="list"><li>공지</li></a>
            	<a href="flist"><li>게시판</li></a>
            </ul>
        </nav>
</header>
<hr>
