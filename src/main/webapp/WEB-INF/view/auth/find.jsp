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
                <div class="input-container">
                    <div>휴대폰 번호</div>
                    <input type="tel" class="info phone" name="phone" placeholder="ex) 010-0000-0000" required>
                </div>
                <div class="input-container">
                    <input type="submit" class="find-btn" value="비밀번호 찾기">
                </div>
            </div>
        </main>
    </section>
</div>