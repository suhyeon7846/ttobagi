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

    let count = 1;

    let checkBox = section.querySelector("input[type=checkbox]");
    let delBtn = section.querySelector(".del-button");
    let regBtn = section.querySelector(".reg-button");
    let submitBtn = section.querySelector(".submit-button");
    

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
            
    checkBox.onclick = ()=>{
        if(checkBox.checked==true){
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

    //삭제버튼 트리거
    delBtn.onclick = (e)=>{
        let event = new MouseEvent('click',{
            bubbles:true,
            cancelable:true,
            view:window
        });
        submitBtn.dispatchEvent(event);
    }

    submitBtn.onclick=()=>{
        alert("삭제 제출");
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


    nextBtn.onclick=()=>{
        
        //더이상 불러올 데이터가 없으면 null
        // if(currentPage.nextElementSibling != null){
            
            currentPage.classList.add('active');
            book.insertAdjacentHTML('beforeend',item);
            setTimeout(function(){
                // currentPage.style["background-color"]='rgb(239,153,166)';
                currentPage.querySelector(".diary-list").style.display='none';    
            },500);
            
            
            
            
            count++;
            
            setTimeout(function(){
                currentPage=currentPage.nextElementSibling;
            },2000)
        // }
    }

    prevBtn.onclick=()=>{
        if(currentPage.previousElementSibling != null){
            currentPage=currentPage.previousElementSibling;
            if(currentPage.classList.contains('active')){
                currentPage.classList.remove('active');
            }          
            setTimeout(function(){
                currentPage.querySelector(".diary-list").style.display='flex';    
            },700)
            currentPage.classList.add('reactive');
            setTimeout(function(){
                currentPage.classList.remove('reactive');
                currentPage.nextElementSibling.remove();
            },2000)
        }  
    }
})