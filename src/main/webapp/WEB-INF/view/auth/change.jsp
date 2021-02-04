<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/css/auth/change.css">
<script src="/js/auth/change.js"></script>

<section class="main-sec">
    <main class="main">
        <h1>비밀번호 수정</h1>
        <form action="change" method="post" class="form">
            <h1>새로운 비밀번호를 입력해 주세요.</h1>
            <div class="input-container">
                <div>비밀번호</div>
                <input type="password" class="info password" name="password" required>
            </div>
            <div class="input-container">
                <div>비밀번호 확인</div>
                <input type="password" class="info password-confirm" name="password-confirm" required>
            </div>
            <div class="input-container">
                <input type="hidden" name="loginId" value="${loginId}">
                <input type="submit" class="change-btn" value="수정하기">
            </div>
        </form>
    </main>
</section>