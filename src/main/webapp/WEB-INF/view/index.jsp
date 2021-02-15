<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<link rel="stylesheet" href="/css/index.css">
<script src="/js/index.js"></script>

<section class="section-1">
	<div class="sub-section-1">
		<div class="intro-container">
			<div class="intro-img-container" data-aos="fade-right"
				data-aos-duration="1200">
				<img class="intro-img" src="/images/intro.gif">
			</div>
			<div class="intro-ment-container" data-aos="fade-left"
				data-aos-duration="1200">
				<div class="intro-ment">
					<h1>멘트멘트멘트멘트</h1>
					<div class="ment">멘트멘트멘트멘트멘트멘트멘트멘트</div>
					<div class="ment">멘트멘트멘트멘트멘트멘트멘트멘트멘트멘트멘트멘트멘트</div>
					<div class="ment">멘트멘트멘트멘트멘트멘트멘트멘트멘트</div>
					<div>
						<s:authorize access="isAnonymous()">
							<a href="/auth/login"> <input type="button"
								class="service-btn" value="서비스 이용하기">
							</a>
						</s:authorize>
						<s:authorize access="isAuthenticated()">
							<a href="/user/couple/reg"> <input type="button"
								class="service-btn" value="서비스 이용하기">
							</a>
						</s:authorize>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<div class="empty-line"></div>
<section class="section-2" style="display: flex; justify-content: center; align-items: center;">
    <div class="calendar" style="display: flex; justify-content: center; align-items: center;">

        <img style="width: 400px;" src="/images/calendar.png" alt="" data-aos="fade-right" data-aos-duration="1200">
        <div style="padding-left: 150px;" data-aos="fade-left" data-aos-duration="1200">
            <h1 style="font-size: 40px; font-weight: bold; margin-top:0px; margin-bottom: 40px;">연인과 함께 일정을 공유해보세요!</h1>
            <button class="btn">일정 공유하기</button>
        </div>
    </div>
</section>
<div class="empty-line"></div>
<section class="section-3">
	<div class="sub-section-1">
		<div class="intro-container">

			<div class="intro-ment-container" data-aos="fade-right"
				data-aos-duration="1200">
				<div class="intro-ment" style="padding-top: 150px;">
					<h1 style="font-size: 35px">특별한 하루를 모아보세요!</h1>
					<div class="ment">사랑하는 연인과 함께한 날들을</div>
					<div class="ment">여기에 기록해보세요</div>
					<div>
						<s:authorize access="isAnonymous()">
							<a href="/auth/login"> <input type="button"
								class="service-btn" value="서비스 이용하기">
							</a>
						</s:authorize>
						<s:authorize access="isAuthenticated()">
							<a href="/user/couple/reg"> <input type="button"
								class="service-btn" value="서비스 이용하기">
							</a>
						</s:authorize>
					</div>
				</div>
			</div>
			<div class="intro-img-container" data-aos="fade-left"
				data-aos-duration="1200">
				<img class="intro-img" src="/images/memoryMainIcon.png">
			</div>
		</div>
	</div>
</section>
<div class="empty-line"></div>
<section class="section-4">
	<div class="sub-section-1">
		<div class="intro-container">
			<div class="intro-img-container" data-aos="fade-right"
				data-aos-duration="1200">
				<img class="intro-img" src="/images/bucketMainIcon.png">
			</div>
			<div class="intro-ment-container" data-aos="fade-left"
				data-aos-duration="1200">
				<div class="intro-ment" style="padding-top: 150px;">
					<h1 style="font-size: 35px">특별한 경험을 같이 해봐요!</h1>
					<div class="ment">연인과 함께 하고 싶은 일들을</div>
					<div class="ment">여기에 기록해보세요</div>
					<div>
						<s:authorize access="isAnonymous()">
							<a href="/auth/login"> <input type="button"
								class="service-btn" value="서비스 이용하기">
							</a>
						</s:authorize>
						<s:authorize access="isAuthenticated()">
							<a href="/user/couple/reg"> <input type="button"
								class="service-btn" value="서비스 이용하기">
							</a>
						</s:authorize>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>