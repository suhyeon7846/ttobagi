<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<script src="/js/inc/header.js"></script>

<header id="header" class="header">
    <div class="sub-header">
        <a href=""><img class="logo" src="/images/logo.png"></a>
        <nav>
            <ul>
                <li><a href="">커플노트</a></li>
                <li><a href="">커뮤니티</a></li>
                <s:authorize access="isAnonymous()">
                	<li><a href="/auth/login">로그인</a></li>
                </s:authorize>
                <s:authorize access="isAuthenticated()">
                	<li><a href="/auth/logout">로그아웃</a></li>
                </s:authorize>
                <li><i class="fas fa-bell bell"></i></li>
                
            </ul>
        </nav>
        <div class="tooltip">
            <div class="bell-num">1</div>
            <div class="bell-content d-none">
                <span>커플 요청이 도착했습니다.</span>
                <input type="button" class="detail-btn header-modal-open" value="자세히 보기">
            </div>
        </div>
        
    </div>

    <section class="header-modal-sec">
        <main class="header-modal-main">
            <div class="header-exit-container">
                <a href="#" class="header-modal-close">
                    <i class="fas fa-times"></i>
                </a>
            </div>
            <h1 class="header-h1">조재희님으로부터 커플 요청이 왔어요!</h1>
            <form action="list" method="post" class="header-response-form">
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
                            <td>조재희</td>
                            <td>남성</td>
                            <td>010-1111-1111</td>
                            <td>2020-12-31</td>
                        </tr>
                    </tbody>
                </table>
                <div class="header-response-btn-container">
                    <input type="submit" class="header-response-btn header-ok-btn" value="요청 수락">
                    <input type="submit" class="header-response-btn header-no-btn" value="요청 거절">
                </div>
            </form>
        </main>
    </section>
</header>