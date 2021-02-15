<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<link rel="stylesheet" href="/css/index.css">
<script src="/js/index.js"></script>

<section class="section-1">
    <div class="sub-section-1">
        <div class="intro-container">
            <div class="intro-img-container" data-aos="fade-right" data-aos-duration="1200">
                <img class="intro-img" src="/images/intro.gif">
            </div>
            <div class="intro-ment-container" data-aos="fade-left" data-aos-duration="1200">
                <div class="intro-ment">
                    <h1>멘트멘트멘트멘트</h1>
                    <div class="ment">멘트멘트멘트멘트멘트멘트멘트멘트</div>
                    <div class="ment">멘트멘트멘트멘트멘트멘트멘트멘트멘트멘트멘트멘트멘트</div>
                    <div class="ment">멘트멘트멘트멘트멘트멘트멘트멘트멘트</div>
                    <div>
                        <s:authorize access="isAnonymous()">
                            <a href="/auth/login">
                                <input type="button" class="service-btn" value="서비스 이용하기">
                            </a>
                        </s:authorize>
                        <s:authorize access="isAuthenticated()">
                            <a href="/user/couple/reg">
                                <input type="button" class="service-btn" value="서비스 이용하기">
                            </a>
                        </s:authorize>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="empty-line"></div>
<section class="section-2">
    
</section>
<div class="empty-line"></div>
<section class="section-3">
    
</section>
<div class="empty-line"></div>
<section class="section-4">
</section>
<div class="empty-line"></div>
<section class="section-5" >
	<section id ="letter">
		
	        <div class="img" data-aos="fade-right" data-aos-duration="1200">
	            
	        </div>
	        <div class="content" data-aos="fade-left" data-aos-duration="1200">
	            <span>원하는 날에 줄수있는
	                <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;한통의 편지</span>
	            <div>
                        <s:authorize access="isAnonymous()">
                            <a href="/auth/login">
                                <input type="button" class="letter-btn" value="편지 쓰러가기">
                            </a>
                        </s:authorize>
                        <s:authorize access="isAuthenticated()">
                            <a href="/user/letter/list">
                                <input type="button" class="letter-btn" value="편지 쓰러가기">
                            </a>
                        </s:authorize>
                </div>
	        </div>
    </section>
</section>
<div class="empty-line"></div>
<section class="section-6">
	<section id ="diary">
        <div class="img" data-aos="fade-right" data-aos-duration="1200">
            
        </div>
        <div class="content" data-aos="fade-left" data-aos-duration="1200">
            <span>함께 채워가는 
                <br>&nbsp;&nbsp;&nbsp;커플 일기장</span>
            <div>
                        <s:authorize access="isAnonymous()">
                            <a href="/auth/login">
                                <input type="button" class="diary-btn" value="일기 쓰러가기">
                            </a>
                        </s:authorize>
                        <s:authorize access="isAuthenticated()">
                            <a href="/user/diary/list">
                                <input type="button" class="diary-btn" value="일기 쓰러가기">
                            </a>
                        </s:authorize>
                    </div>
        </div>
    </section>
</section>
