<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/css/user/mypage.css">
<script src="/js/user/mypage.js"></script>

<section class="mypage-sec">
    <h1>마이페이지 / MyPage</h1>
    <div class="both-sec-container">
        <section class="both-sec left-sec">
            <h1>회원정보</h1>
            <form action="" method="post"class="form member-info-form">
                <div class="member-info-sub-container">
                    <div class="member-info-title">로그인 아이디</div>
                    <input type="text" class="member-info login-id" disabled>
                </div>
                <div class="member-info-sub-container">
                    <div class="member-info-title">비밀번호</div>
                    <input type="password" class="member-info password" required>
                </div>
                <div class="member-info-sub-container">
                    <div class="member-info-title">비밀번호 확인</div>
                    <input type="password" class="member-info password-confirm" required>
                </div>
                <div class="member-info-sub-container">
                    <div class="member-info-title">이름</div>
                    <input type="text" class="member-info name" disabled>
                </div>
                <div class="member-info-sub-container">
                    <div class="member-info-title">닉네임</div>
                    <input type="text" class="member-info nickname" disabled>
                </div>
                <div class="member-info-sub-container">
                    <div class="member-info-title">성별</div>
                    <input type="text" class="member-info gender" disabled>
                </div>
                <div class="member-info-sub-container">
                    <div class="member-info-title">연락처</div>
                    <input type="tel" class="member-info phone" disabled>
                </div>
                <input type="button" name="member-info-edit" 
                    class="member-info-edit-btn" value="수정하기"> 
            </form>
        </section>
    
        <section class="both-sec right-sec">
            <h1>커플정보</h1>
            <c:if test="${not empty coupleView}">
            	<div class="wait-ment">상대방의 수락 여부를 기다리고 있습니다.</div>
            </c:if>
            <c:if test="${empty coupleView}">
	            <form action="" method="post" class="form couple-info-form">
	                <div class="couple-info-sub-container">
	                    <div class="couple-info-title">이름</div>
	                    <input type="text" class="couple-info name" disabled>
	                </div>
	                <div class="couple-info-sub-container">
	                    <div class="couple-info-title">닉네임</div>
	                    <input type="text" class="couple-info nickname" disabled>
	                </div>
	                <div class="couple-info-sub-container">
	                    <div class="couple-info-title">연애시작일</div>
	                    <input type="date" class="couple-info loveStartDate">
	                </div>
	                <div class="couple-info-sub-container">
	                    <div class="couple-info-title">커플등록일</div>
	                    <input type="text" class="couple-info regDate" disabled>
	                </div>
	                <input type="button" name="couple-info-delete" 
	                    class="couple-info-delete-btn" value="커플 끊기"> 
	            </form>
            </c:if>
            
        </section>
    </div>
</section>