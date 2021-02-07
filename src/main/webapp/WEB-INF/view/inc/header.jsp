<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<script src="/js/inc/header.js"></script>

<header id="header" class="header">
    <div class="sub-header">
        <a href="/index"><img class="logo" src="/images/logo.png"></a>
        <nav>
            <ul>
                <li><a href="/user/coupleNote">커플노트</a></li>
                <li><a href="/user/community/index">커뮤니티</a></li>
                <s:authorize access="isAnonymous()">
                <li><a href="/auth/login">로그인</a></li>
                <li></li>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                <li class="sub-menu">
                    <img class="pic-login" src="/images/login.png">
                    <div class="mega-menu">
                        <ul>
                            <li><a href="/user/mypage">마이페이지</a></li>
                            <li><a href="/auth/logout">로그아웃</a></li>
                        </ul>
                    </div>
                </li>
                <li><i class="fas fa-bell bell"></i></li>
                </s:authorize>
                
            </ul>
        </nav>
        <s:authorize access="isAuthenticated()">
	        <div class="tooltip">
	            <div class="bell-num ${notification == true ? '' : 'd-none'}">1</div>
	            <div class="bell-content d-none">
	            	<c:if test="${notification == true}">
	            		<span>커플 요청이 도착했습니다.</span>
	                	<input type="button" class="detail-btn header-modal-open" value="자세히 보기">
	            	</c:if>
	            	<c:if test="${notification == false}">
						<span>새로운 알림이 없습니다.</span>
					</c:if>
	            </div>
	        </div>
        </s:authorize>
    </div>

    <section class="header-modal-sec">
        <main class="header-modal-main">
            <div class="header-exit-container">
                <a href="" class="header-modal-close">
                    <i class="fas fa-times"></i>
                </a>
            </div>
            <h1 class="header-h1">${coupleView.name}님으로부터 커플 요청이 왔어요!</h1>
            <form action="/user/couple/response" method="post" class="header-response-form">
                <table class="header-sender-info-table">
                    <thead>
                        <tr>
                            <td class="header-col-s">이름</td>
                            <td class="header-col-s">성별</td>
                            <td class="header-col-m">연락처</td>
                            <td class="header-col-m">요청일</td>
                        </tr>
                    </thead>
                    <tbody class="header-tbody">
                        <tr>
                            <td>${coupleView.name}</td>
                            <td>${coupleView.gender}</td>
                            <td>${coupleView.phone}</td>
                            <td>
                            	<fmt:formatDate value="${coupleView.sendDate}" pattern="yyyy-MM-dd"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="header-response-btn-container">
                    <input type="submit" name="response" class="header-response-btn header-ok-btn" value="요청 수락">
                    <input type="submit" name="response" class="header-response-btn header-no-btn" value="요청 거절">
                </div>
            </form>
        </main>
    </section>
</header>