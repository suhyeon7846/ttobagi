<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/css/user/letter/list.css">
<link rel="stylesheet" href="/css/user/letter/visual.css">

        <!----------------------------------------------main--------------------------------------->
    
    <section id="main">
        <div class="panel">
            <div class="letter-box">
                <div class="header">
                    편지함
                </div>
                
                <div class="body">
                    <c:forEach var="l" items="${list}">
                    <div class="letter">
                        <div class="title">
                            <span>${l.title }</span>
                        </div>
                        <div class="img" style="margin-right: 9px;">
                            <img src="../../images/letter/letter1.png"width="90px" height="70px">
                        </div>
                    </div>
                    </c:forEach>                    
                </div>
            </div>
            <div class="letter-leg">

            </div>
        </div>
    </section>
    
    
