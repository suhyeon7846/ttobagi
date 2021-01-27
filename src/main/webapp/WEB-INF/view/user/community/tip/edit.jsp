<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="/css/user/community/common.css">
<link rel="stylesheet" href="/css/user/community/api.css">
<link rel="stylesheet" href="/css/user/community/sub.css">
<script src="/js/user/community/common.js"></script>

<!-- main -->
<main id="main" class="main">
	<section class="content">
		<div class="container">
			<h1 class="d-none">연애 꿀팁 상세 게시판 수정</h1>
			<form method="post" enctype="multipart/form-data">
				<table class="table">
					<tbody>
						<tr>
							<th>제목</th>
							<td><input name="title" type="text" value="${e.title}"></td>
						</tr>
						<tr>
							<th>닉네임</th>
							<td>${e.memNicName}</td>
						</tr>
						<tr>
							<th>파일 등록</th>
							<td><input type="file" name="file" class="file" /></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content">${e.content}</textarea></td>
						</tr>
					</tbody>
				</table>
				<div class="button-area">
					<input class="button" type="submit" value="확인">
					<a class="button" href="../${e.id}">취소</a>
				</div>
			</form>
		</div>
	</section>
</main>