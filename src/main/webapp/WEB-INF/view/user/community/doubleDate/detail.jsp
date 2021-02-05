<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/js/user/community/common.js"></script>

<!-- main -->
<main id="main" class="main">
	<section class="content">
		<div class="container">
			<h1 class="d-none">${type}상세 글</h1>
			<table class="table">
				<tbody>
					<tr>
						<th>글 번호</th>
						<td>${d.id}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>${d.title}</td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td>${d.memNicName}</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${d.hit}</td>
					</tr>
					<tr>
						<th>추천수</th>
						<td>${d.recomCnt}</td>
					</tr>
					<tr>
						<th>등록일자</th>
						<td>${d.regDate}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
						<c:if test="${d.fileId ne null && d.fileId ne 0}">
							<img class="uploadImg" src="<spring:url value='/resources/static/images/user/community/${type}/${d.id}/${d.fileName}'/>">
							<br>
						</c:if> 
						${d.content}
						</td>
					</tr>
				</tbody>
			</table>
			
			<form method="post">
				<div class="recom-area">
					<input type="hidden" name="recom">
					<input type="hidden" name="negative">
					<button class="recom-button" type="submit" value="recom"><i class="far fa-thumbs-up fa-2x"></i>좋아요</button> 
					<button class="negative-button" type="submit" value="negative"><i class="far fa-angry fa-2x"></i>싫어요</button>
				</div>
				
				<div>
					<table>
						<tr>
							<th>아이디</th>
							<c:set var="nickName" value="${nickName}" scope="session"></c:set>	
							<td>${nicName}</td>
							<th>내용</th>
							<td>
								<input type="text">
								<button class="" type="submit">댓글 달기</button>								
							</td>
						</tr>
					</table>
				</div>
			</form>

			<div class="button-area">
				<a class="button" href="../${type}">목록</a>
				<c:set var="memId" value="${id}" scope="session"></c:set>
				<c:if test="${memId eq d.memberId}">
					<a class="button" href="${communityId}/edit">수정</a> 
					<a class="button del-button" href="${communityId}/del">삭제</a>
				</c:if>
			</div>

			<!-- POPUP -->
			<div id="report-popup" class="popup-container d-none">
				<h1>신고리스트</h1>

				<div class="report-popup-container">
					<input type="hidden" name="reportType" value="1">
				</div>
				<div class="button-area">
					<input type="submit" value="확인">
					<button type="button" class="popup-cancel">취소</button>
				</div>

			</div>
		</div>
	</section>
</main>