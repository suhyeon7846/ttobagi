<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/user/bucketlist/list.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<script type="module" src="/js/user/bucketlist/list.js"></script>
<section class="section-1">
        <section id="main">
            <section class="top-content">
                <div class="dropdown">
                    <button onclick="myFunction()" class="dropbtn">추천</button>
                    <div id="myDropdown" class="dropdown-content">
                      <ul>
                          <li><a href="#">link1</a></li>
                          <li><a href="#">link1</a></li>
                          <li><a href="#">link1</a></li>
                          <li><a href="#">link1</a></li>
                      </ul>
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
                                   	<i class="fas fa-check"></i>
                               		<span class="btn-wrap"> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
                                </a>
                               
                              
                                <a href="#">
                               		<input type="button" class="btn">
                                   	<i class="fas fa-times"></i>
                                   	<span class="btn-wrap"> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
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
        <span>
            <i class="fas fa-pencil-alt"></i>
        </span>
        </div>
    </div>
    <div class="switch-wrap">
        <input type="checkbox" id="switch1" name="switch1" class="input__on-off">
        <label for="switch1" class="label__on-off">
        <span class="marble"></span>
        <span class="on">on</span>
        <span class="off">off</span>
        </label>
    </div>