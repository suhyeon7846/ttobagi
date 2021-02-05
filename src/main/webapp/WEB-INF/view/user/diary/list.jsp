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
                <span class="next"><a href="?p=${page}"=>다음</a></span>
                <span class="prev"><a href="?p=${page}"=>이전</a></span>
                <div class="note-button-circle1"></div>
                <div class="note-button-circle2">
                    <span class="open-close">열기</span>
                </div>
                
            </div>
            <div class="cover">
                <div class="cover-panel">
                    <span>이름과 이름의 커플일기장ㅋㅋ</span>
                </div>
            </div>
            <div class="page">
                <div class="page1" >
                    <div class="reg-button">
                        글쓰기
                    </div>
                    <div class="del-button">
                        삭제
                    </div>
                    <div class="diary-list">
                    <!-- 여기서부터 일기장 패널 1,2면 탑, 3,4면 바텀 -->
                    <c:set var="name" value="홍길동" />


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
                                <form>
                                    <input type="checkbox" class="check-box"/>
                                    <input type="submit" value="삭제" class="submit-button">
                                </form>
                            </div>

                            <div class="body">
                                <textarea class="content">
${d.content }
                                </textarea>
                            </div>
                        </div>
                    	</c:when>
                    	
                    	<c:when test="${status.count%4==3 or status.count%4==0}"> 
                    		<div class="diary-panel-bottom">
                            <div class="head">
                                <div class="deco">
                                    <span class="reborn">
										<%-- <fmt:formatDate value="${d.regDate}" pattern="MM-dd"/> --%>
										${d.regDate}
									</span>
                                </div>
                                
                                <span class="title">${d.title }</span>
                                <div class="mood">
                                    <img src="${d.file }" style="width: 50px; height: 50px;">
                                </div>
                                <form>
                                    <input type="checkbox" class="check-box"/>
                                    <input type="submit" value="삭제" class="submit-button">
                                </form>
                            </div>

                            <div class="body">
                                <textarea class="content">
${d.content }
                                </textarea>
                            </div>
                        </div>
                    	</c:when>
                    	</c:choose>
                    </c:forEach>                                            
                   </div>
                </div>
            </div>
        </div>

        
    </section>
<script src="/js/user/diary/list-api.js"></script>
