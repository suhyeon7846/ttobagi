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
			<a class="button" href="../${type}">직접 꿀팁 작성하기</a>
		</div>
		<div class="inner">
			<!-- Boxes -->
			<div class="thumbnails">
				<div class="menu-title">BEST 연애 꿀팁 5</div>
				<c:forEach var="bl" items="${bestList}">
					<div class="box">
						<a href="${type}/${bl.id}" class="image fit">
							<img src="/images/user/community/sub/${bl.id}.jpg" alt="" />
						</a>
						<div class="inner">${bl.title}</div>
						
					</div>
				</c:forEach>
				
				<div class="menu-title">연애 꿀팁</div>
				<c:forEach var="list" items="${list}">
					<div class="box">
						<a href="${type}/${list.id}" class="image fit">
							<img src="/images/user/community/sub/${list.id}.jpg" alt="" />
						</a>
						<div class="inner">${list.title}</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
</main>