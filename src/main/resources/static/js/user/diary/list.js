window.addEventListener("load",()=>{
    let section = document.querySelector("#main");
    let btn = section.querySelector(".note-button");
    let cover = section.querySelector(".cover");

    let page = section.querySelector(".page1");

    let openBtn= section.querySelector(".open-close");
    let nextBtn= section.querySelector(".next");
    let prevBtn=section.querySelector(".prev");

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
                nextBtn.style.transform='rotateY(-180deg)';
                prevBtn.style.transform='rotateY(-180deg)';
                
            },1500);

            setTimeout(function(){   
                openBtn.style.opacity='1';
                openBtn.innerHTML="닫기"
                nextBtn.style.opacity='1';
                prevBtn.style.opacity='1';
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
        
    }
})