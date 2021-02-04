<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- main -->
<main id="main" class="main">
	<section class="container">
		<div class="content">
			<h1 class="d-none">커뮤니티 메인 메뉴</h1>
			<div class="menu">
				<ul class="menu-container">
					<c:forEach var="c" items="${categorytype}">				
					<li class="menu-item">
						<a href="${c.typeEnglishName}"><img src="/images/user/community/menu/${c.typeEnglishName}.PNG"></a>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</section>
</main>