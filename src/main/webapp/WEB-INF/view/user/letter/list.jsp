<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/css/user/letter/list.css">
<link rel="stylesheet" href="/css/user/letter/visual.css">
<script type="module" src = "/js/user/letter/list.js"></script>

        <!----------------------------------------------main--------------------------------------->
    
    <section id="main">
    	<form action="list" method="post">
	        <div class="panel" >
	            <div class="letter-box">
	                <div class="head">
	                    L E T T E R
	                </div>
	                
	                <div class="letter-content" id="letter-content">
	                    <c:forEach var="l" items="${list}" varStatus="status">
	                    <div class="letter" id="letter">
	                    	<div class="inputbox" id="inputbox" onclick="event.stopPropagation()">
                                <input type="checkbox" id="checkbox${status.index}" name="del" value="${l.id}">
                                <label for="checkbox${status.index}" ></label>
                            </div>
	                        <div class="title" id="title">
	                            <span id="span">${l.title }</span>
	                        </div>
	                        <div class="img" style="margin-right: 9px;" id="img-div">
	                        	<c:choose>
		                        	<c:when test="${l.readCheck == 1}">
		                            	<img src="../../images/user/letter/letter1.png" width="90px" height="70px" id="img" style="margin-right:10px;">
		                            </c:when>
		                            <c:otherwise>
		                            	 <img src="../../images/user/letter/letter2.png"width="100px" height="70px" id="img">
		                            </c:otherwise>
	                            </c:choose>
	                        </div>
	                        <input type ="hidden" class="id" value="${l.id}"/>
	                        <input type="hidden" value="${name}"/>
	                    </div>
	                    </c:forEach>                    
	                </div><!-- body -->
	            </div><!-- letter-box -->
	        </div>
	        <div class="reg-del-panel">
                <div class="reg-del-box">
                    <a href="reg"><div class="reg"></div></a>
                    <div class="del"></div>
                    <input type="submit" style="display:none" class="del-input">
                </div>
            </div>  
            <div class="change-reg"></div>
            <div class="change-del"></div>
        </form>
    </section>
    
    
