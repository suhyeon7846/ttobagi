<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/css/user/couple/list.css">
<script src="/js/user/couple/list.js"></script>

<section class="main-sec">
    <main class="main">
        <h1 class="h1">조재희님으로부터 커플 요청이 도착했습니다!</h1>
        <h2 class="h2">상대방 정보</h2>

        <div class="form-container">
            <form action="list" method="post" class="response-form d-none">
                <table class="sender-info-table">
                    <thead>
                        <tr>
                            <td class="col-s">이름</td>
                            <td class="col-s">성별</td>
                            <td class="col-m">연락처</td>
                            <td class="col-m">요청일</td>
                        </tr>
                    </thead>
                    <tbody class="tbody">
                        <tr>
                            <td>조재희</td>
                            <td>남성</td>
                            <td>010-1111-1111</td>
                            <td>2020-12-31</td>
                        </tr>
                    </tbody>
                </table>
                <div class="response-btn-container">
                    <input type="submit" class="response-btn ok-btn" value="요청 수락">
                    <input type="submit" class="response-btn no-btn" value="요청 거절">
                </div>
            </form>
        </div>
        
    </main>
</section>