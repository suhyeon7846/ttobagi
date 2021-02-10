<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="/js/user/community/comment.js"></script>
<script src="/js/user/community/recom.js"></script>

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
					<tr class="like-body">
						<th>좋아요 수</th>
						<td>${d.recomCnt}</td>
					</tr>
					<tr class="hateBody">
						<th>싫어요 수</th>
						<td>${d.negativeCnt}</td>
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
				<button class="like-button" type="button" name="like">
					<i class="far fa-thumbs-up fa-2x"></i>좋아요
				</button> 
				<button class="hate-button" type="button" name="hate">
					<i class="far fa-angry fa-2x"></i>싫어요
				</button>
			</div>

			<div class="comment">
				<input name="sessionId" type="hidden" value="${id}">
				<div class="title">
					<span>댓글</span>				
				</div>
				<div class="comment-list">
					<c:forEach var="m" items="${comment}">			
					<div class="list"><!-- 댓글 리스트 -->
						<span class="nickname">${m.nickname}</span>
						<span class="text">${m.content}</span>
						<input name="commentMemId" type="hidden" value="${m.memId}">
						<button  type="button" class="comment-del-button" name="commentId" value="${m.id}">삭제</button>
					</div>
					</c:forEach>
				</div>
				
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
