<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="/css/admin/member/list.css">
<script src="/js/admin/member/list.js"></script>

<main>
    <section class="body">
        <aside id="aside" class="aside">
            <h1>관리자 페이지</h1>
                <ul>
                    <li><a href="/admin/member/list">회원 관리</a></li>
                    <li><a href="/admin/community/list">커뮤니티 관리</a></li>
                </ul>
        </aside>
        <div class="container">
            <main id="main" class="main">
                <div class="sub-container">
                    <div class="breadcrumb">
                        <ul class="breadcrumb-list">
                               <li><i class="fas fa-home"></i>&nbsp;&nbsp;관리자 페이지&nbsp;&nbsp;&nbsp;<i class="fas fa-angle-right"></i></li>
                               <li>&nbsp;&nbsp;&nbsp;회원 관리</li>
                           </ul>
                    </div>
                    <form action="list" class="search-form">
                           <h1>회원 리스트</h1>
                           <div>
                               <input type="text" class="input-search" placeholder="회원 이름 또는 로그인 ID" value="${param.search}" name="search">
                               <input type="submit" class="search-submit-btn" value="검색">
                           </div>
                       </form>
                    <section>
                        <form action="list" method="post" class="list-board">
                        	<input type="hidden" name="id" value="${event.id}">
                            <table>
                                <thead>
                                    <tr>
                                        <td class="col-s">No.</td>
                                        <td class="col-s">이름</td>
                                        <td class="col-s">로그인 ID</td>
                                        <td class="col-m">닉네임</td>
                                        <td class="col-s">커플유무</td>
                                        <td class="col-m">생년월일</td>
                                        <td class="col-m">연락처</td>
                                        <td class="col-m">가입일</td>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="mv" items="${list}">
	                                	<tr>
	                                        <td>1</td>
	                                       	<td>${mv.name}</td>
	                                        <td>${mv.loginId}</td>
	                                        <td>${mv.nickname}</td>
	                                        <td>${mv.isCouple == null ? 'X' : 'O'}</td>
	                                        <td>${mv.birthday}</td>
	                                        <td>${mv.phone}</td>
	                                        <td>
	                                        	<fmt:formatDate value="${mv.regDate}" pattern="yyyy-MM-dd"/>
	                                        </td>
	                                    </tr>
                                	</c:forEach>
                                    
                                    <!-- <tr>
                                        <td colspan="8" class="no-border btn-row">
                                        	<c:set var="ids" value=""/>
                                        	<c:forEach var="event" items="${list}">
                                        		<c:set var="ids" value="${ids} ${event.id}"/>
                                        	</c:forEach>
                                        	<input type="hidden" name="ids" value="${ids}">
                                            <input type="button" onclick="location.href='reg'" value="글쓰기">
                                            <input type="submit" class="open-btn" name="cmd" value="일괄공개">
                                            <input type="submit" class="del-btn" name="cmd" value="일괄삭제">
                                        </td>
                                    </tr> -->
                                    <tr>
                                    	<c:set var="page" value="${(empty param.p) ? 1 : param.p}"/>
                                    	<c:set var="startNum" value="${page - (page - 1) % 5}"/>
                                    	<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count / 10), '.')}"/>
                                    	<td colspan="8" class="no-border">
                                    		<div class="pager-container">
					                            <div class="btn btn-prev">
				                            	<c:if test="${startNum > 1}">
					                            	<span><a href="?p=${startNum - 1}&search=">이전</a></span>
				                            	</c:if>
				                            	<c:if test="${startNum <= 1}">
					                            	<span><a href="?p=${startNum - 1}&search=" onclick="alert('이전 페이지가 없습니다.')">이전</a></span>
				                            	</c:if>
					                            </div>
					                            
					                            <ul class="pager-list">
				                            	<c:forEach var="i" begin="0" end="4">
					                            	<c:if test="${(startNum + i) <= lastNum}">
					                            		<li class="${(page == (startNum + i)) ? 'active-page' : ''}">
						                                	<a href="?p=${startNum + i}&search=${param.search}">${startNum + i}</a>
						                                </li>
						                            </c:if>
			                            		</c:forEach>
					                            </ul>
					                            
					                            <div class="btn btn-next">
				                                <c:if test="${startNum + 4 < lastNum}">
					                            	<span><a href="?p=${startNum + 5}&search=">다음</a></span>
				                            	</c:if>
				                            	<c:if test="${startNum + 4 >= lastNum}">
					                            	<span><a href="?p=${startNum + 5}&search=" onclick="alert('다음 페이지가 없습니다.')">다음</a></span>
				                            	</c:if>
					                            </div>
					                       	</div>
                                    	</td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </section>
                </div>
            </main>
        </div>
    </section>
</main>