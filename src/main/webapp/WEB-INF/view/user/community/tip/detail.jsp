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
			
			<div class="recom-area">
				<input type="hidden" class="community-type" value="${type}">
				<input type="hidden" class="community-id" value="${d.id}">
				<button class="recom-button" type="button" name="recom">
					<i class="far fa-thumbs-up fa-2x"></i>좋아요
				</button> 
				<button class="negative-button" type="button" name="negative">
					<i class="far fa-angry fa-2x"></i>싫어요
				</button>
			</div>

			<div class="comment">
				<div class="title">
					<span>댓글</span>				
				</div>
				<c:forEach var="m" items="${comment}">			
				<form class="comment-form" method="post" action="${m.id}/commentDel">
				<div class="list"><!-- 댓글 리스트 -->
					<input name="communityId" type="hidden" value="${d.id}" >
					<span class="nickname">${m.nickname}</span>
					<span class="text">${m.content}</span>
					<c:if test="${id eq m.memId}">
						<a href="${m.id}/commentDel">						
							<button class="del-button" name="commentId" value="${m.id}" type="submit">삭제</button>
						</a>
					</c:if>
				</div>
				</form>
				</c:forEach>
				
				<div class="reg"><!-- 댓글 등록 -->
					<span class="nickname">${nickName}</span>
					<input class="text" name="commentText" type="text">
					<a href="${communityId}/commentInsert">					
						<button class="comment-reg-button" type="submit">댓글 달기</button>
					</a>
				</div>
			</div>

			<div class="button-area">
				<a class="button" href="../${type}">목록</a>
				<c:if test="${id eq d.memberId}">
					<a class="button" href="${communityId}/edit">수정</a> 
					<a class="button comment-del-button" href="${communityId}/del">삭제</a>
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