<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

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
                
            </ul>
        </nav>
    </div>
</header>