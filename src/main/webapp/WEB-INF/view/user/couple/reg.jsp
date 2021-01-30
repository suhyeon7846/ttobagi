<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/css/user/couple/reg.css">
<script src="/js/user/couple/reg.js"></script>

<section class="main-sec">
    <main class="main">
        <h1 class="h1">사랑하는 연인과 최고의 추억을 또바기에서 만들어 보세요.</h1>
        <h2 class="h2">커플을 등록하시면 아래의 서비스를 이용하실 수 있습니다.</h2>
        <ul class="service-list">
            <li>일정공유</li>
            <li>버킷리스트</li>
            <li>편지</li>
            <li>일기장</li>
            <li>커뮤니티</li>
        </ul>
        <input type="button" class="modal-open" value="커플 등록하기">
    </main>
</section>

<section class="modal-sec">
    <main class="modal-main">
        <div class="exit-container">
            <a href="#" class="modal-close">
                <i class="fas fa-times"></i>
            </a>
        </div>
        <h1 class="h1">휴대폰 번호로 상대방을 검색해 보세요!</h1>
        <div action="" method="post" class="search-container">
            <input type="text" class="input-phone" placeholder="ex) 010-1111-2222" required>
            <input type="button" class="find-btn" value="검색">
        </div>
        <form action="reg" method="post" class="request-form d-none">
            <table class="result-table">
                <thead>
                    <tr>
                        <td class="col-s">이름</td>
                        <td class="col-s">성별</td>
                        <td class="col-m">가입일</td>
                    </tr>
                </thead>
                <tbody class="tbody">
                    <!-- <tr>
                        <td>조재희</td>
                        <td>남성</td>
                        <td>2020-12-31</td>
                    </tr> -->
                </tbody>
            </table>
            <div class="request-btn-container">
                <!-- <input type="hidden" name="id" value="${session.id}"> -->
                <input type="submit" class="request-btn" value="커플 요청">
            </div>
        </form>
        <div class="no-result d-none">검색 결과가 없습니다.</div>
    </main>
</section>