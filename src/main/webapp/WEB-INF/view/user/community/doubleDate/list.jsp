<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- main -->
<main id="main" class="main">
	<h1 class="d-none">${type} 글 리스트</h1>
	<section class="content">
		<div class="write-button button-area">
			<a class="button" href="${type}/reg">직접 ${cate.typeKoreanName} 글 작성하기</a>
		</div>
		<div class="inner">
			<!-- Boxes -->
			<div class="thumbnails">
				<div class="menu-title">BEST ${cate.typeKoreanName}</div>
				<c:forEach var="bl" items="${bestList}">
					<div class="box">
						<a href="${type}/${bl.id}" class="image fit">
							<c:choose>
								<c:when test="${empty bl.fileName}">
									<img src="<spring:url value='/resources/static/images/user/community/${type}_bagic.jpg'/>">
								</c:when>
								<c:when test="${not empty bl.fileId}">
									<img src="<spring:url value='/resources/static/images/user/community/${type}/${bl.id}/${bl.fileName}'/>">
								</c:when>
							</c:choose>
						</a>
						<div class="inner">${bl.title}</div>
						
					</div>
				</c:forEach>
				
				<div class="menu-title">${cate.typeKoreanName}</div>
				<c:forEach var="list" items="${list}">
					<div class="box">
						<a href="${type}/${list.id}" class="image fit">
							<c:choose>
								<c:when test="${empty list.fileName}">
									<img src="<spring:url value='/resources/static/images/user/community/${type}_bagic.jpg'/>">
								</c:when>
								<c:when test="${not empty list.fileId}">
									<img src="<spring:url value='/resources/static/images/user/community/${type}/${list.id}/${list.fileName}'/>">
								</c:when>
							</c:choose>
						</a>
						<div class="inner">${list.title}</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
</main>