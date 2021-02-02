 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="/css/user/memory/list.css">
<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<script type="module" src="/js/user/memory/list.js"></script>    
 <section class="section-1">
        <section id="main">
	        <div class="screen"></div>
	        <div class="frame">
		        <div class="frame-top">
		          <h1>추억 등록</h1>     
				</div>
				<form id="memoryForm" name="memoryForm" action="reg" method="post" enctype="multipart/form-data">
		               <div class="frame-file-wrap">
		                   <h1>원하는 사진을 선택해 주세요</h1>
		                   <img style="width: 100px;" id="preview-image" src="">
		                  <input type="file" name="file" accept=".jpg, .png" id="input-image">
		               </div>
		               <div class="frame-text-wrap">
		                  <h1>내용</h1>
		                  <!-- <p>EX) 버킷리스트는 최고야!</p> -->
		                 <textarea rows="50" cols="50" name="content"></textarea>
		               </div>
		               <div class="frame-btn-wrap">
		               		<input type="hidden" value=${coupleId} name="coupleId">
		                   <input type="submit" value="등록" class="sbtn" >
		                   <input type="button" value="취소" >
		               </div>
				</form>
			</div>
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
                                <p>
                                ${m.content}
                                </p>
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