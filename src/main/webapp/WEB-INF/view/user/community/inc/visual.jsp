<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/user/community/common.css">
<link rel="stylesheet" href="/css/user/community/api.css">
<link rel="stylesheet" href="/css/user/community/sub.css">
<script src="/js/user/community/visual.js"></script>
	<c:if test="${empty type}">
	<section class="visual" style="background-image: url('/images/user/community/visual/community.png');">
		<h1 class="d-none">커뮤니티 메인페이지</h1>
		 <p class="visual-text">
		 	<span class="title">커뮤니티</span><br>
		 	<span class="content"></span>
		 </p>
	</c:if>
	
	<c:if test="${not empty type}">
	<section class="visual" style="background-image: url('/images/user/community/visual/${type}.png');">
		<h1 class="d-none">${type} 페이지</h1>
		<p class="visual-text">
		 	<span class="title">${cate.typeKoreanName}</span><br>
		 	<span class="content"></span>
		 </p>
	</c:if>
	
		<input type="hidden" class="type" value="${type}">
	</section>
	