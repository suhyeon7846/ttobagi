<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <!----------------------------------------------main--------------------------------------->
    
    <section id="main">
        <div class="panel">
            <div class="well">
                <span>일기장 글쓰기</span>
            </div>
            <form name="reg" action="" method="POST" class="form">
                <div class="title">
                    <label for="input-title" >제목  </label>
                    <input type="text" name="title" id="input-title">
                </div>
                <span class="mood-span">기분</span>
                <div class="mood">
                    <input type="radio" name="mood" value="smile1" id="smile1">
                    <label for="smile1"><img src="../../images/diary/smile1.png" width="50px" height="50px"></label>
                    <input type="radio" name="mood" value="smile2" id="smile2">
                    <label for="smile2"><img src="../../images/diary/smile2.png" width="50px" height="50px"></label>
                    <input type="radio" name="mood" value="smile3" id="smile3">
                    <label for="smile3"><img src="../../images/diary/smile3.png" width="50px" height="50px"></label>
                    <input type="radio" name="mood" value="normal" id="normal">
                    <label for="normal"><img src="../../images/diary/normal.png" width="50px" height="50px"></label>
                    <input type="radio" name="mood" value="love" id="love">
                    <label for="love"><img src="../../images/diary/love.png" width="50px" height="50px"></label>
                    <input type="radio" name="mood" value="sad" id="sad">
                    <label for="sad"><img src="../../images/diary/sad.png" width="50px" height="50px"></label>
                    <input type="radio" name="mood" value="upset" id="upset">
                    <label for="upset"><img src="../../images/diary/upset.png" width="50px" height="50px"></label>
                    <input type="radio" name="mood" value="angry" id="angry">
                    <label for="angry"><img src="../../images/diary/angry.png" width="50px" height="50px"></label>
                    <input type="radio" name="mood" value="sunglasses" id="sunglasses">
                    <label for="sunglasses"><img src="../../images/diary/sunglasses.png" width="50px" height="50px"></label>
                </div>
                
                <div class="content">
                    <label for="input-content" >내용  </label>
                    <textarea name="" id="" cols="30" rows="10"></textarea>
                </div>
                <div class="btns">
                    <input type="submit" value="보내기" class="button">
                    <a href="http://www.naver.com" class="button">취소</a>
                </div>
            </form>
        </div>
    </section>
   