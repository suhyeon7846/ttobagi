 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/css/user/memory/list.css">
<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<script type="module" src="/js/user/memory/list.js"></script>   
<script type="text/javascript" src="/libs/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<!-- <script src="/libs/smartEditor/ckeditor.js"></script> -->
 <section class="section-1">
        <section id="main">
	        
            <!-- Thumbnails -->
            <div class="memorylogo"></div>
            <div class ="search-wrap">
            	<select id="search-option">
            		<option value="" disabled>옵션</option>
            		<option value="키워드">키워드</option>
            		<option value="날짜">날짜</option>
            	</select>
            	<div class="text-wrap">
            		<input type="text" name="content" class="text-box">
            		<input type="button" value="검색" class="search-button">
            	</div>
            </div>
            <section class="thumbnails">
            <c:forEach var="m" items="${list}">
                <div class="flip-box"> 
                    <div class="flip">
                        <div class="front">
                            <div class="img-wrap">
                               <img src="<spring:url value='/resources/static/images/user/memory/upload/${m.fileName}'/>" alt="${m.fileName}" />
                            </div>
                        </div>
                        <div class="back">
                            <div class="text-wrap">
                                <h1>${m.regDate}</h1>
                                <p style="white-space:pre;">${m.content}</p>
                            </div>
                            <input type="button" value="수정" class="cardEditBtn">
                            <input type="hidden" value="${m.fileName}">
                           	<input type="button" value="삭제" class="cardDelBtn">
                           	<input type="hidden" value="${m.id}">
                        </div>
                    </div>
                </div>
                </c:forEach>
            </section>
        </section>
    </section>
    <div class="content-plus-wrap">
        <div class="content-plus">
         <span class="icon-container">
            <i class="fas fa-pencil-alt"></i>
        </span>
        </div>
    </div>
