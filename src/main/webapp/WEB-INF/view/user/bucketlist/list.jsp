<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/user/bucketlist/list.css">
<!-- <link rel="preconnect" href="https://fonts.gstatic.com"> -->
<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
<!-- <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/> -->
<script type="module" src="/js/user/bucketlist/list.js"></script>
<section class="section-1">
        <section id="main">
            <section class="top-content">
                <div class="dropdown">
                    <button onclick="myFunction()" class="dropbtn">추천</button>
                    <div id="myDropdown" class="dropdown-content">
                      <ul class="recommend-box-wrap">
	                      <li class="recommend-box">
	                      	<div class="img-wrap">
	                            <img src="/images/user/bucketlist/01.jpg" alt="01" />
	                            <p>2층 버스타고 런던 시내 관광하기</p>
	                            <input type="radio" name="recommend-pic">
	                        </div>
	                      </li>
	                       <li class="recommend-box">
	                      	<div class="img-wrap">
	                            <img src="/images/user/bucketlist/02.jpg" alt="01" />
	                            <p>해변에서 하루종일 놀아보기</p>
	                            <input type="radio" name="recommend-pic">
	                        </div>
	                      </li>
	                      <li class="recommend-box">
	                      	<div class="img-wrap">
	                            <img src="/images/user/bucketlist/03.jpg" alt="01" />
	                            <p>여름 프로방스의 만개한 라벤더 밭에서 걷기</p>
	                            <input type="radio" name="recommend-pic">
	                        </div>
	                      </li>
	                      <li class="recommend-box">
	                      	<div class="img-wrap">
	                            <img src="/images/user/bucketlist/04.jpg" alt="01" />
	                            <p>락 스타로 데뷔하기</p>
	                            <input type="radio" name="recommend-pic">
	                        </div>
	                      </li>
	                      <li class="recommend-box">
	                      	<div class="img-wrap">
	                            <img src="/images/user/bucketlist/05.jpg" alt="01" />
	                            <p>글램핑 즐기기</p>
	                            <input type="radio" name="recommend-pic">
	                        </div>
	                      </li>
	                       <li class="recommend-box">
	                      	<div class="img-wrap">
	                            <img src="/images/user/bucketlist/06.jpg" alt="01" />
	                            <p>쇄빙선 타고 남극기지 가보기</p>
	                            <input type="radio" name="recommend-pic">
	                        </div>
	                      </li>
	                      <li class="recommend-box">
	                      	<div class="img-wrap">
	                            <img src="/images/user/bucketlist/07.jpg" alt="01" />
	                            <p>귀농하기</p>
	                            <input type="radio" name="recommend-pic">
	                        </div>
	                      </li>
	                      <li class="recommend-box">
	                      	<div class="img-wrap">
	                            <img src="/images/user/bucketlist/08.jpg" alt="01" />
	                            <p>해리포터의 아치교를 지나는 증기기관차 타보기</p>
	                            <input type="radio" name="recommend-pic">
	                        </div>
	                      </li>
                      </ul>
                      <input type="button" value="추가하기">
                    </div>
                  </div>
            </section>
            <!-- Thumbnails -->
            <section class="thumbnails">
            	<c:forEach var="b" items="${list}">
                    <div class="box">
                        <div class="img-wrap">
                            <img src="/images/user/bucketlist/${b.fileName}.jpg" alt="${b.fileName}" />
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
        <span class="on">on</span>
        <span class="off">off</span>
        </label>
    </div>