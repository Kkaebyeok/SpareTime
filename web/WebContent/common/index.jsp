<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Spare Time</title>
<link rel="icon" href="images/favicon.ico">
<link rel="stylesheet" href="css/mainpage.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
    <div id="container">
		<header>
            <div class="main">
                <span><a href="index"><h1>Spare Time</h1></a></span>
            </div>
            <nav>
                <ul class="main-nav">
                    <a href="list"><li>공지</li></a>
                    <a href="flist"><li>게시판</li></a>
                </ul>
            </nav>
        </header>
        <section id="content">
            <article class="notice">
                <h2><em>공지사항</em></h2>
                <p class="link"><a href="list"><small>더보기 ></small></a></p>
                <c:forEach items="${list}" var="i" varStatus="stat">
                <c:if test="${stat.count <= 3}"> 
                <div>
                    <p><a href="view?no=${i.boardNo}"><b>[공지] ${i.title}</b></a></p>
                    <hr>
                </div>
                </c:if>
                </c:forEach>
            </article>
        </section>
        <div class="vl"></div>
        <aside id="sidebar">
        <c:if test="${loginUser == null}">
            <div class="login-one">
                <a href="login"><h3>사이트 로그인</h3></a>
                <p><a href="signup"><small>회원가입</small></a></p>
            </div>
		</c:if>
		<c:if test="${loginUser != null}">
		<div class="user-info">
                <div class="block"></div>
                <div class="login-two">
                    <p>${loginUser.nik}</p>
                    <div class="member">
                    <label class="level">회원등급</label>
                        <select onchange="option()" id="option">
                            <option value="${loginUser.admin}">
                            <c:if test="${loginUser.admin ==0}">(N)일반회원</c:if>
                            <c:if test="${loginUser.admin ==1}">(M)관리자</c:if>
                            </option>
                        </select>
                    </div>
                    <p><a href="logout" class="button" onclick="return confirm('로그아웃 하시겠습니까?')">로그아웃</a></p>
                    <p><a href="info" class="button">내정보</a></p>
                </div>
            </div>
		</c:if>
            <div class="photo">
                <img src="images/box.png" alt="sidephoto">
            </div>
        </aside>
        <footer>
            <div class="profile">
                <p>Copyright ⓒ<span>YoonHo,Yeom</span>,All Rights Reserved.</p>
                <hr>
                <a href="http://noldaga.shop"><p>profile</p></a>
            </div>
        </footer>
    </div>
</body>
</html>