window.addEventListener("load",()=>{
    const section = document.querySelector("#main");
    let book =section.querySelector(".book");
    const btn = section.querySelector(".note-button");
    let cover = section.querySelector(".cover");
    let coverSpan = section.querySelector(".cover-panel span")

    let currentPage = section.querySelector(".page1");

    let openBtn= section.querySelector(".open-close");
    let nextBtn= section.querySelector(".next");
    let prevBtn=section.querySelector(".prev");

    let zindex_reverse =2;
    let zindex=1;

    openBtn.onclick = function(){
        if(btn.style.transform !='rotateY(180deg)'){//y축이 반대가 아니면 '열기'상태
            btn.style.transform='rotateY(180deg)';
            openBtn.style.opacity='0';
            nextBtn.style.display='inline-block'
            prevBtn.style.display='inline-block'

            setTimeout(function(){
                btn.style.zIndex='0';
            },1000);

            setTimeout(function(){
                openBtn.style.transform='rotateY(-180deg)';
                cover.style.transform='rotateY(-180deg)';
                // cover.style.background='rgb(239, 153, 166)';
                nextBtn.style.transform='rotateY(-180deg)';
                prevBtn.style.transform='rotateY(-180deg)';
                
            },1500);

            

            setTimeout(function(){   
                openBtn.style.opacity='1';
                openBtn.innerHTML="닫기"
                nextBtn.style.opacity='1';
                prevBtn.style.opacity='1';
                coverSpan.style.display='none';
            },2000);
        }
        else{//y축이 반대면 '닫기' 상태
        //데이터는 놔두고 닫자
        //
            cover.style.transform='rotateY(0deg)';
            openBtn.style.opacity='0';
            nextBtn.style.opacity='0';
            prevBtn.style.opacity='0';
            nextBtn.style.display='none'
            prevBtn.style.display='none'
            
            setTimeout(function(){
                btn.style.zIndex='2';
            },1500);
            setTimeout(function(){
                coverSpan.style.display='inline-block';


            },700);

            setTimeout(function(){
                btn.style.transform='rotateY(0deg)';
                openBtn.style.transform='rotateY(0deg)';
                nextBtn.style.transform='rotateY(-180deg)';
                prevBtn.style.transform='rotateY(-180deg)';

            },2100);

            setTimeout(function(){
                openBtn.style.opacity='1';
                openBtn.innerHTML="열기";
            },2500);
        }
    }


    nextBtn.onclick=function(){
        //페이지 넘기고 zindex를 기존보다 높게 줘서 위에 쌓이게 
        currentPage.style.transform='rotateY(-180deg)';
        console.log(zindex_reverse);
        currentPage.style.zIndex=zindex_reverse++;
        console.log(zindex_reverse);
        //페이지의 클래스를 바꿔서 백그라운드만 있는걸로 
        // currentPage.style.background= 'rgb(239, 153, 166)';
        currentPage.className="page0"
        

        let item = '<div class="page1"> \
                        <div class="diary-list"> \
                            <div class="diary-panel-top"> \
                                <div class="head"> \
                                    <div class="deco"> \
                        <span class="reborn">01-17</span> \
                    </div> \
                    <span class="title">제목을 입력하세요~</span> \
                    <div class="mood"> \
                        <img src="../../images/user/diary/love.png " style="width: 50px; height: 50px;"> \
                    </div> \
                </div> \
                <div class="body"> \
                    <textarea class="content"> \
일기내용을 여기다가 적어봐요 꽉 채워야되요ㅠㅠㅠb<br/> \
일기내용을 여기다가 적어봐요 꽉 채워야되요ㅠㅠㅠ<br/> \
일기내용을 여기다가 적어봐요 꽉 채워야되요ㅠㅠㅠ<br/> \
일기내용을 여기다가 적어봐요 꽉 채워야되요ㅠㅠㅠ<br/> \
일기내용을 여기다가 적어봐요 꽉 채워야되요ㅠㅠㅠ<br/> \
일기내용을 여기다가 적어봐요 꽉 채워야되요ㅠㅠㅠ<br/> \
                    </textarea> \
                </div> \
            </div> ';
        book.insertAdjacentHTML('beforeend',item);
        console.log("다음")
    }

    prevBtn.onclick=function(){

    }
})