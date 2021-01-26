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
			<h1 class="d-none">연애 꿀팁 상세 게시판</h1>
			<table class="table">
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" value="${title}"></td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td>${memNicName}</td>
					</tr>
					<tr>
						<th>파일 등록</th>
						<td><input type="file" name="file" class="file"/></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea>${content}</textarea></td>
					</tr>
				</tbody>
			</table>
			<div class="recom">
				<span class="recom-button"> <i class="far fa-thumbs-up fa-2x"></i>추천
				</span> <span class="report-button"> <i class="fas fa-ban fa-2x"></i>신고
				</span>
			</div>
			<div class="button-area">
				<button type="button" value="list" class="go-list">목록</button>
				<button type="button" value="update" class="update-button">수정</button>
				<button type="button" value="delete" class="delete-button">삭제</button>
			</div>

			<!-- POPUP -->
			<div id="report-popup" class="popup-container d-none">
				<h1>신고리스트</h1>
				<form method="get" action="detail.html">
					<div class="report-popup-container">
						<label for="report-type1"><input type="radio"
							id="report-type1" name="report-type" value="type1"
							checked="checked">불건전한 컨텐츠</label> <label for="report-type2"><input
							type="radio" id="report-type2" name="report-type" value="type2">욕설
							컨텐츠</label> <label for="report-type3"><input type="radio"
							id="report-type3" name="report-type" value="type3">성적인
							컨텐츠</label>
					</div>
					<button type="submit" class="report-submit-button" value="submit">확인</button>
					<button type="button" class="popup-cancel-button">취소</button>
				</form>
			</div>
		</div>
	</section>
</main>