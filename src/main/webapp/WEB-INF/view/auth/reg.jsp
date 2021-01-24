<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/css/auth/reg.css">
<script src="/js/auth/reg.js"></script>

<section class="main-sec">
    <main class="main">
        <div class="img-container">
            <img src="/images/logo.png" alt="">
        </div>
        <div class="form-container">
            <form action="reg" method="post" class="form">
                <!--loginId, pwd1, pwd2, name, nickname, gender, birthday, phone-->
                <div class="info-container">
                    <div class="icon-container"> 
                        <i class="far fa-id-card icon"></i>
                    </div>
                    <div class="input-container">
                        <input type="text" class="info-input login-id" name="loginId" placeholder="로그인 아이디" autocomplete="off" required>
                        <input type="button" class="dup-check-btn dup-login-id-btn" value="중복 검사">
                    </div>
                </div>
                <div class="info-container">
                    <div class="icon-container">
                        <i class="fas fa-lock icon"></i>
                    </div>
                    <div class="input-container">
                        <input type="password" class="info-input password" name="password" placeholder="비밀번호" autocomplete="off" required>
                    </div>
                </div>
                <div class="info-container">
                    <div class="icon-container">
                        <i class="fas fa-lock icon"></i>
                    </div>
                    <div class="input-container">
                        <input type="password" class="info-input password-confirm" name="password-confirm" placeholder="비밀번호확인" autocomplete="off" required>
                    </div>
                </div>
                <div class="info-container">
                    <div class="icon-container">
                        <i class="fas fa-user icon"></i>
                    </div>
                    <div class="input-container">
                        <input type="text" class="info-input name" name="name" placeholder="이름" autocomplete="off" required>
                    </div>
                </div>
                <div class="info-container">
                    <div class="icon-container">
                        <i class="fas fa-user icon"></i>
                    </div>
                    <div class="input-container">
                        <input type="text" class="info-input nickname" name="nickname" placeholder="닉네임" autocomplete="off" required>
                        <input type="button" class="dup-check-btn dup-nickname-btn" value="중복 검사">
                    </div>
                </div>
                <div class="info-container">
                    <div class="icon-container">
                        <i class="fas fa-venus-mars icon"></i>
                    </div>
                    <div class="radio-container">
                        <input type="radio" class="info-input gender-radio-btn" name="gender" value="남" checked required><span>남성</span>
                        <input type="radio" class="info-input gender-radio-btn" name="gender" value="여" required><span>여성</span>
                    </div>
                </div>
                <div class="info-container">
                    <div class="icon-container">
                        <i class="fas fa-birthday-cake icon"></i>
                    </div>
                    <div class="input-container">
                        <input type="text" class="info-input birthday" name="birthday" placeholder="ex) 1990-12-31" autocomplete="off" pattern="^\d{4}-\d{2}-\d{2}$" required>
                    </div>
                </div>
                <div class="info-container">
                    <div class="icon-container">
                        <i class="fas fa-mobile-alt icon"></i>
                    </div>
                    <div class="input-container">
                        <input type="tel" class="info-input phone" name="phone" placeholder="ex) 010-0000-0000" autocomplete="off" pattern="^01[01678]-\d{3,4}-\d{4}$" required>
                    </div>                        
                </div>
                <div>
                    <input type="submit" class="submit-btn" value="회원가입">
                </div>
            </form>
        </div>
    </main>
</section>