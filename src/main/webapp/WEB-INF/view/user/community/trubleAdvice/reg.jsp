<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="/js/user/community/common.js"></script>

<!-- main -->
<main id="main" class="main">
	<section class="content">
		<div class="container">
			<h1 class="d-none">${type} 글 쓰기</h1>
			<form action="reg" method="post" enctype="multipart/form-data">
				<table class="table">
					<tbody>
						<tr>
							<th>제목</th>
							<td><input name="title" type="text"></td>
						</tr>
						<tr>
							<th>파일 등록</th>
							<td><input type="file" name="file" class="file"/></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content"></textarea></td>
						</tr>
					</tbody>
				</table>
				<div class="button-area">
					<input type="hidden" name="type" value="${type}">
					<input class="button" type="submit" value="확인">
					<a class="button" href="../${type}">취소</a>
				</div>
			</form>
		</div>
	</section>
</main>