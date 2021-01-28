<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %> 
<link rel="stylesheet" href="/css/user/bucketlist/list.css">
<!-- <link rel="preconnect" href="https://fonts.gstatic.com"> -->
<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
<!-- <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/> -->
<script type="module" src="/js/user/bucketlist/list.js"></script>
<section class="section-1">
        <section id="main">
        <div class="screen">
        </div>
	        <div class="frame">
		        <div class="frame-top">
		          <h1>버킷리스트 등록</h1>     
				</div>
				<form id="form" name="form" action="regs" method="post" enctype="multipart/form-data">
		               <div class="frame-file-wrap">
		                   <h1>원하는 사진을 선택해 주세요</h1>
		                  <input type="file" name="file" accept=".jpg, .png">
		               </div>
		               <div class="frame-text-wrap">
		                  <h1>제목</h1>
		                  <p>EX) 버킷리스트는 최고야!</p>
						  <p><40글자 내외로 기입해주세요></p>
		                  <input type="text" maxlength="40" name="titlename" required>
		               </div>
		               <div class="frame-btn-wrap">
		                   <input type="submit" value="등록" >
		                   <input type="button" value="취소" >
		               </div>
				</form>
			</div>
            <section class="top-content">
                <div class="dropdown">
                    <button class="dropbtn">추천</button>
                    <div id="myDropdown" class="dropdown-content">
                      <ul class="recommend-box-wrap">
                      <c:forEach var="r" items="${recommendList}">
	                      <li class="recommend-box">
	                      	<div class="img-wrap">
	                            <img src="<spring:url value='/resources/static/images/user/bucketlist/upload/${r.fileName}'/>" alt="${r.fileName}" />
	                            <p class="recommend-title">${r.title}</p>
	                            <input type="radio"  name="recommend-pic" value="${r.fileName}" >
	                            
	                        </div>
	                      </li>
	                  </c:forEach>
                      </ul>
                     	<div>
	                      	<input type="button" value="추가하기" class="addCard">
	                      	<input type="button" value="새로받기" class="newCard">
                    	</div>
                    </div>
                  </div>
            </section>
            <!-- Thumbnails -->
            <div class="bucketlogo"></div>
            <section class="thumbnails">
            	<c:forEach var="b" items="${list}">
                    <div class="box">
                        <div class="img-wrap">
                            <img src="<spring:url value='/resources/static/images/user/bucketlist/upload/${b.fileName}'/>" alt="${b.fileName}" />
                        </div>
                        <figcaption>
                            <h2>${b.title}</h2>
                            <p>
                                <a href="#">
                               		<input type="button" class="btn">
                               		<span class="icon-container">
                                   	<i class="fas fa-check icon"></i>
                                   	</span>
                               		<span class="btn-wrap update "> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
                                </a>
                                <a href="#">
                               		<input type="button" class="btn">
                               		 <span class="icon-container">
                                   	<i class="fas fa-times icon"></i>
                                   	</span>
                                   	<span class="btn-wrap delete"> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
                                	<input type="hidden" value="${b.status}">
                                </a>
                               	
                            </p>
                        </figcaption>	
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
    <div class="switch-wrap">
        <input type="checkbox" id="switch1" name="switch1" class="input__on-off check">
        <label for="switch1" class="label__on-off">
        <span class="marble"></span>
        <span class="on" >Done</span>
        <span class="off">Ing</span>
        </label>
    </div>