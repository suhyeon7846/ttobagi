<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/css/auth/find.css">
<script src="/js/auth/find.js"></script>

<div class="sec-container">
    <section class="main-sec">
        <main class="main">
            <h1>비밀번호 찾기</h1>
            <div>
                <div class="input-container">
                    <div>로그인 아이디</div>
                    <input type="text" class="info login-id" name="username" placeholder="아이디" required>
                </div>
                <div class="input-container center">
                    <div>이메일</div>
                    <input type="email" class="info email" name="email" placeholder="ex) ttobagi@gmail.com" required>
                </div>
                <div class="input-container">
                    <input type="submit" class="find-btn" value="비밀번호 찾기">
                </div>
            </div>
        </main>
    </section>
</div>