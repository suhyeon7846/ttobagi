<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <link rel="stylesheet" href="/css/user/diary/list.css">
    <link rel="stylesheet" href="/css/user/diary/visual.css">
    <script src="/js/user/diary/list.js"></script>
   <%--  <c:set var="name" value="홍길동" />
                                <c:if test="${name eq '홍길동'}">
								    <c:out value="${name}" />								
								</c:if> --%>
<c:set var ="page" value ="${param.p}"/>
<c:set var ="size" value = "4"/>
<c:if test="${empty param.p}">
	<c:set var="page" value="1"/>
</c:if>
    <!----------------------------------------------main--------------------------------------->
    <section id="main">
        <div class="book">
            <div class="note-button" >
                <%-- <span class="next"><a href="?p=${page}"=>다음</a></span>
                <span class="prev"><a href="?p=${page}"=>이전</a></span> --%>
                <span class="next">다음</span>
                <span class="prev">이전</span>
                <div class="note-button-circle1"></div>
                <div class="note-button-circle2">
                    <span class="open-close">열기</span>
                </div>
                
            </div>
            <div class="cover">
                <div class="cover-panel">
                    <%-- <span>${name}과 ${opponentName} 커플일기장</span> --%>
                     <div class="covertitle">
                        <div>커</div>
                        <div>플</div>
                        <div>일</div>
                        <div>기</div>
                        <div>장</div>
                    </div>
                    <img src="../../images/user/diary/diarycover.jpg" width="300px" height="300px" style="border-radius: 30px;">
                </div>
            </div>
            <div class="page">
                <div class="page1" >
                <form action="list" method="post">
                    <div class="reg-button">
                    	<a href="reg">
                        	글쓰기
                        </a>
                    </div>
                    <input type="submit" class="del-button" value="삭제">
                    
	                    <div class="diary-list">
	                    <!-- 여기서부터 일기장 패널 1,2면 탑, 3,4면 바텀 -->
	                    <%-- <c:set var="name" value="홍길동" /> --%>
	
	
	                    <c:forEach var="d" items="${list}" varStatus="status">
	                    	<c:choose>
	                    	
	                    	<c:when test="${status.count%4==1 or status.count%4==2}"> 
	                    		<div class="diary-panel-top">
	                            <div class="head">
	                                <div class="deco">
	                                    <span class="reborn">
	                                    	<fmt:formatDate value="${d.regDate}" pattern="MM-dd"/> 
	                                    </span>
	                                </div>
	                                
	                                <span class="title">${d.title }</span>
	                                <div class="mood">
	                                    <img src="${d.file } " style="width: 50px; height: 50px;">
	                                </div>
	                                <div class="input">
	                                    <input type="checkbox" class="check-box" name ="del" value="${d.id}"/> 
	                                </div> 
	                            </div>
	
	                            <div class="body">
	                                <textarea class="content" readonly="readonly" disabled>${d.content }
	                                </textarea>
	                            </div>
	                        </div>
	                    	</c:when>
	                    	
	                    	<c:when test="${status.count%4==3 or status.count%4==0}"> 
	                    		<div class="diary-panel-bottom">
	                            <div class="head">
	                                <div class="deco">
	                                    <span class="reborn">
											<fmt:formatDate value="${d.regDate}" pattern="MM-dd"/>
										</span>
	                                </div>
	                                
	                                <span class="title">${d.title }</span>
	                                <div class="mood">
	                                    <img src="${d.file }" style="width: 50px; height: 50px;">
	                                </div>
	                                <div class="input">
	                                	<!-- <label for="checkbox" -->
	                                    <input type="checkbox" class="check-box" name ="del" value="${d.id}"/> 
	                                </div> 
	                            </div>
	
	                            <div class="body">
	                                <textarea class="content" readonly="readonly" disabled>${d.content }
	                                </textarea>
	                            </div>
	                        </div>
	                    	</c:when>
	                    	</c:choose>
	                    </c:forEach>                                            
	                   </div>
	               </form>
                </div>
            </div>
        </div>

        
    </section>
<!-- <script src="/js/user/diary/list-api.js"></script> -->
