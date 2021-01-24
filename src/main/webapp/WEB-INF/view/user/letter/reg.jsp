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
            <form name="reg" action="" method="POST">
                <div class="title">
                    <label for="input-title" >제목  </label>
                    <input type="text" name="title" id="input-title">
                </div>
                
                <div class="content">
                    <label for="input-content" >내용  </label>
                    <textarea id="input-content"></textarea>
                </div>

                <div class="btns">
                    <input type="submit" value="보내기" class="button">
                    <a href="http://www.naver.com" class="button">취소</a>
                </div>
            </form>
        </div>
    </section>
  