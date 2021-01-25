<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/css/user/community/common.css">
<link rel="stylesheet" href="/css/user/community/api.css">
<link rel="stylesheet" href="/css/user/community/sub.css">
<script src="/js/user/community/sub.js"></script>

<!-- main -->
<main id="main" class="main">
	<section class="content">
		<div class="write-button button-area">
			<button value="write" class="button">직접 꿀팁 작성하기</button>
		</div>
		<div class="inner">
			<!-- Boxes -->
			<div class="thumbnails">
				<div class="menu-title">BEST 연애 꿀팁 5</div>
				<c:forEach var="i" begin="1" end="5">
					<div class="box">
						<a href="${type}/1" class="image fit">
							<img src="/images/user/community/sub/${i}.jpg" alt="" />
						</a>
						<div class="inner">남자친구가 좋아할만한 행동</div>
					</div>
				</c:forEach>
				
				<div class="menu-title">연애 꿀팁</div>
				<c:forEach var="i" begin="1" end="5">
					<div class="box">
						<a href="${id}" class="image fit">
							<img src="/images/user/community/sub/${i}.jpg" alt="" />
						</a>
						<div class="inner">남자친구가 좋아할만한 행동</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
</main>