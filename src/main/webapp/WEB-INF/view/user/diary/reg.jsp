<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/css/user/diary/reg.css">
<link rel="stylesheet" href="/css/user/diary/visual.css">
        <!----------------------------------------------main--------------------------------------->
    
    <section id="main">
        <div class="panel">
            <div class="well">
                <span>일기장 글쓰기</span>
            </div>
            <form name="reg" method="POST" class="form">
                <div class="title">
                    <label for="input-title" >제목  </label>
                    <input type="text" name="title" id="input-title">
                </div>
                <span class="mood-span">기분</span>
                <div class="mood">
                    <input type="radio" id="smile1" name="moodId" value="1">
                    <label for="smile1"><img src="../../images/user/diary/smile1.png" width="50px" height="50px"></label>
                    <input type="radio" id="smile2" name="moodId" value="2">
                    <label for="smile2"><img src="../../images/user/diary/smile2.png" width="50px" height="50px"></label>
                    <input type="radio" id="smile3" name="moodId" value="3">
                    <label for="smile3"><img src="../../images/user/diary/smile3.png" width="50px" height="50px"></label>
                    <input type="radio" id="normal" name="moodId" value="4">
                    <label for="normal"><img src="../../images/user/diary/normal.png" width="50px" height="50px"></label>
                    <input type="radio" id="love" name="moodId" value="5">
                    <label for="love"><img src="../../images/user/diary/love.png" width="50px" height="50px"></label>
                    <input type="radio" id="sad" name="moodId" value="6">
                    <label for="sad"><img src="../../images/user/diary/sad.png" width="50px" height="50px"></label>
                    <input type="radio" id="upset" name="moodId" value="7">
                    <label for="upset"><img src="../../images/user/diary/upset.png" width="50px" height="50px"></label>
                    <input type="radio" id="angry" name="moodId" value="8">
                    <label for="angry"><img src="../../images/user/diary/angry.png" width="50px" height="50px"></label>
                </div>
                
                <div class="content">
                    <label for="input-content" >내용  </label>
                    <textarea name="content" id="" cols="30" rows="10"></textarea>
                </div>
                <div class="btns">
                    <input type="submit" value="보내기" class="button">
                    <a href="list" class="button">취소</a>
                </div>
                <div style="display:hidden">
                	<input type="hidden" name="memberId" value="${memberId}"/>
                </div>
            </form>
        </div>
    </section>
   