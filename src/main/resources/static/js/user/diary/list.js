window.addEventListener("load",()=>{
    const section = document.querySelector("#main");
    let book =section.querySelector(".page");
    const btn = section.querySelector(".note-button");
    let cover = section.querySelector(".cover");
    let coverSpan = section.querySelector(".cover-panel span")

    let currentPage = section.querySelector(".page1");
    // let currentPage_div = currentPage.querySelector("div");

    let openBtn= section.querySelector(".open-close");
    let nextBtn= section.querySelector(".next");
    let prevBtn=section.querySelector(".prev");

    let backPage=undefined;

    let count = 1;

    let checkBox = section.querySelectorAll(".check-box");
    console.log(checkBox[1]);
    let delBtn = section.querySelector(".del-button");
    let regBtn = section.querySelector(".reg-button");
    let submitBtn = section.querySelectorAll(".submit-button");
    
    



    
    let item = '<div class="page1" > \
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
                    '+count+' \
                    </textarea> \
                </div> \
            </div> '; 
    
    for(let i=0;i<checkBox.length;i++){
        checkBox[i].onclick = ()=>{
            if(checkBox[0].checked==true||checkBox[1].checked==true||checkBox[2].checked==true||checkBox[3].checked==true){//비교를 할때 또 for문돌려서 다 비교해보자
                delBtn.style.display='block';
                regBtn.style.display='none';
                // currentPage.querySelector(".diary-list").style.top='49px';
            }
            else{
                delBtn.style.display='none';
                regBtn.style.display='block';
                // currentPage.querySelector(".diary-list").style.top='79px';
            }
        }
    }

    //삭제버튼 트리거
    delBtn.onclick = (e)=>{
        let event = new MouseEvent('click',{
            bubbles:true,
            cancelable:true,
            view:window
        });
        for(let i=0;i<submitBtn.length;i++)
        submitBtn[i].dispatchEvent(event);
    }
    for(let i=0;i<submitBtn.length;i++){
        submitBtn[i].onclick=()=>{
            alert("삭제 제출");
        }
    }

    
        
    



    openBtn.onclick = ()=>{
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
            
            if(backPage !=undefined){
                console.log(backPage);
                console.log(backPage.length);
                console.log(backPage[0].style);
                for(let i=0;i<backPage.length;i++){
                    backPage[i].classList.remove('active');
                    backPage[i].classList.add('reactive');
                }
            }
            cover.style.transform='rotateY(0deg)';
            
            openBtn.style.opacity='0';
            nextBtn.style.opacity='0';
            prevBtn.style.opacity='0';
            nextBtn.style.display='none'
            prevBtn.style.display='none'
            
            setTimeout(function(){
                
                cover.style.zIndex='7';
            },100);

            setTimeout(function(){
                coverSpan.style.display='inline-block';
                
            },700);

            setTimeout(function(){
                btn.style.zIndex='10';
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

    let nextBtnListener = function(e){
            currentPage.classList.add('active');
            backPage = section.querySelectorAll(".active");
            book.insertAdjacentHTML('beforeend',item);
            // console.log(e);
            // console.log(this);
            
            setTimeout(function(){
                // currentPage.style["background-color"]='rgb(239,153,166)';
                currentPage.querySelector(".diary-list").style.display='none';    
            },500);
            nextBtn.removeEventListener("click",nextBtnListener);
    }
    

    nextBtn.addEventListener('click',nextBtnListener);

    var pageContainer = section.querySelector(".page");
    

    let prevBtnListener = function(e){
        
        if(currentPage.previousElementSibling != null){
            currentPage=currentPage.previousElementSibling;
            if(currentPage.classList.contains('active')){
                currentPage.classList.remove('active');
            }
            
            currentPage.classList.add('reactive');

            
            setTimeout(function(){
                //디스플레이가 NONE이었다가 다시 원래의 FLEX가 생김
                currentPage.querySelector(".diary-list").style.display='flex';    
            },700)
            prevBtn.removeEventListener("click",prevBtnListener);
        };
    }

    prevBtn.addEventListener('click',prevBtnListener);


    pageContainer.addEventListener("transitionend",()=>{
        if(currentPage.classList.contains("active")){
            currentPage=currentPage.nextElementSibling;
            console.log(currentPage);
            //삭제되었던 이벤트리스너 활성화
            nextBtn.addEventListener('click',nextBtnListener);
        }
        else if(currentPage.classList.contains("reactive")){
            currentPage.classList.remove('reactive');
            
            prevBtn.addEventListener("click",prevBtnListener);
            
            // setTimeout(function(){
                currentPage.nextElementSibling.remove();
            // },200);
        }
    })

})