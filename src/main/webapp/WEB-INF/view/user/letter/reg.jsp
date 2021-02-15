<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="/css/user/letter/reg.css">
    <link rel="stylesheet" href="/css/user/letter/visual.css">
    
    
        <!----------------------------------------------main--------------------------------------->
    
    <section id="main-reg">
        <div class="panel">
            <div class="well">
                <span>편지 글쓰기</span>
            </div>
            <form  action="reg" method="post">
                <div class="title">
                    <label for="input-title" >제목  </label>
                    <input type="text" name="title" id="input-title">
                </div>
                <div class="date">
                	<label for="input-title" >받는 날짜</label>
                	<input type="date" name="senddate">
                </div>
                
                <div class="content">
                    <label for="input-content" >내용  </label>
                    <textarea id="input-content" name="content"></textarea>
                </div>

                <div class="btns">
                    <input type="submit" value="보내기" class="button">
                    <a href="list" class="button">취소</a>
                </div>
                <input type="hidden" name = "senderId" value="${senderId}">
                <input type="hidden" name = "receiverId" value="${receiverId}">
            </form>
        </div>
    </section>
  