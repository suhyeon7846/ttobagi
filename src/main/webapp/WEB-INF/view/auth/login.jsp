<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/css/auth/login.css">
<script src="/js/auth/login.js"></script>

<div class="sec-container">
    <section class="main-sec">
        <main class="main" data-aos="fade-up" data-aos-duration="1000">
            <form action="login" method="post" class="form">
                <h1>로그인</h1>
                <h2>사랑하는 연인과 새로운 추억을 만들어 보세요!</h2>
                <div class="input-container">
                    <input type="text" class="info login-id" name="username" placeholder="아이디" required>
                </div>
                <div class="input-container">
                    <input type="password" class="info password" name="password" placeholder="비밀번호" required>
                </div>
                <div class="input-container login-container">
                    <input type="submit" class="login-btn" value="로그인">
                </div>
                <div class="find-password-container">
                    <span class="find-password"><a href="/auth/find" class="find-pwd-btn">비밀번호 찾기</a></span>
                </div>
                <div class="etc-container">
                    <span class="ment">회원이 아니신가요?</span>
                    <span class="signup"><a href="reg">회원가입 <i class="fas fa-angle-right"></i></a></span>
                </div>
                <div class="img-container">
                    <img src="/images/login_couple1.png">
                </div>
            </form>
        </main>
    </section>
</div>