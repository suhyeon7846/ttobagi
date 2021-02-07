window.addEventListener("load", () => {
    const section = document.querySelector("#main");
    let book = section.querySelector(".page");
    const btn = section.querySelector(".note-button");
    let cover = section.querySelector(".cover");
    let coverSpan = section.querySelector(".cover-panel span");
	let currentPage = section.querySelector(".page1");
    // let currentPage_div = currentPage.querySelector("div");

    let openBtn = section.querySelector(".open-close");
    let nextBtn = section.querySelector(".next");
    let prevBtn = section.querySelector(".prev");

    let backPage = undefined;

    let count = 1;

    let checkBox = currentPage.querySelectorAll(".check-box");
    let delBtn = section.querySelector(".del-button");
    let regBtn = section.querySelector(".reg-button");
    let submitBtn = section.querySelectorAll(".submit-button");
	let checkState =false;//체크박스들이 공통으로 쓸 checked인거지

	let pageIndex=1; //fetch에서 페이지할때 쓸 변수
	
	
		
    for (let i = 0; i < checkBox.length; i++) {
        checkBox[i].onclick = () => {
	
			for(let j = 0;j<checkBox.length;j++){//체크박스 클릭 이벤트 안에서 for문으로 체크를 확인해 하나라도 체크가 되어있으면 break를 줘서 checkState를 true하고 빠져나와 하나도 안되있으면 else로 가서 false가 되겠지
				if(checkBox[j].checked==true){
					checkState=true;
					break;
					}
				else
					checkState=false;
			}
            
			if(checkState==true){
				delBtn.style.display = 'block';
                regBtn.style.display = 'none';
			}
			else{
				delBtn.style.display = 'none';
                regBtn.style.display = 'block';
			}
        }
    }

    //삭제버튼 트리거
    delBtn.onclick = (e) => {
        let event = new MouseEvent('click', {
            bubbles: true,
            cancelable: true,
            view: window
        });
        for (let i = 0; i < submitBtn.length; i++)
            submitBtn[i].dispatchEvent(event);
    }

    for (let i = 0; i < submitBtn.length; i++) {
        submitBtn[i].onclick = () => {
            alert("삭제 제출");
        }
    }

//=====================================open close 버튼
    openBtn.onclick = () => {
        if (btn.style.transform != 'rotateY(180deg)') {//y축이 반대가 아니면 '열기'상태
            btn.style.transform = 'rotateY(180deg)';
            openBtn.style.opacity = '0';
            nextBtn.style.display = 'inline-block'
            prevBtn.style.display = 'inline-block'

            setTimeout(function () {
                btn.style.zIndex = '0';
            }, 1000);

            setTimeout(function () {
                openBtn.style.transform = 'rotateY(-180deg)';
                cover.style.transform = 'rotateY(-180deg)';
                // cover.style.background='rgb(239, 153, 166)';
                nextBtn.style.transform = 'rotateY(-180deg)';
                prevBtn.style.transform = 'rotateY(-180deg)';

            }, 1500);



            setTimeout(function () {
                openBtn.style.opacity = '1';
                openBtn.innerHTML = "닫기"
                nextBtn.style.opacity = '1';
                prevBtn.style.opacity = '1';
                coverSpan.style.display = 'none';
            }, 2000);
        }
        else {//y축이 반대면 '닫기' 상태
            //데이터는 놔두고 닫자
            //

            if (backPage != undefined) {
                console.log(backPage);
                console.log(backPage.length);
                console.log(backPage[0].style);
                for (let i = 0; i < backPage.length; i++) {
                    backPage[i].classList.remove('active');
                    backPage[i].classList.add('reactive');
                }
            }
            cover.style.transform = 'rotateY(0deg)';

            openBtn.style.opacity = '0';
            nextBtn.style.opacity = '0';
            prevBtn.style.opacity = '0';
            nextBtn.style.display = 'none'
            prevBtn.style.display = 'none'

            setTimeout(function () {

                cover.style.zIndex = '7';
            }, 100);

            setTimeout(function () {
                coverSpan.style.display = 'inline-block';

            }, 700);

            setTimeout(function () {
                btn.style.zIndex = '10';
            }, 1500);



            setTimeout(function () {
                btn.style.transform = 'rotateY(0deg)';
                openBtn.style.transform = 'rotateY(0deg)';
                nextBtn.style.transform = 'rotateY(-180deg)';
                prevBtn.style.transform = 'rotateY(-180deg)';

            }, 2100);

            setTimeout(function () {
                openBtn.style.opacity = '1';
                openBtn.innerHTML = "열기";
            }, 2500);
        }
    }




//================여기서부터 fetch 사용 기존에 있던 변수들을 못씀 새로 만들어진 페이지라서 그런듯 
//게다가 현재페이지라고 해주지도 못함 현재페이지의 트랜잭션이 끝난 뒤에 다음페이지==현재페이지가 되기때문
//============================================================다음 버튼(다음페이지)
//날짜 월-일 만 나오게 -> js 날짜 포맷 변경하는 함수 만들어서 해결
//check박스 누르면 동적으로 삭제버튼 -> 해결
//1,2면 위쪽 패널, 3,4면 아래쪽 패널
//위쪽 패널, 아래쪽 패널 글씨 크기
//페이지 문제 -> pageIndex=1이면 첫페이지 따라서 두번째 페이지부터 만드니까 2부터 시작했음
//다음페이지, 이전페이지 없을때 지금 화면과 기능을 유지하는것? 질문
//이전 버튼 -> 딱히 할거 없이 페이지 카운트만 잘 세주면 되는거였음
//삭제 구현
//이름정보 받아오기 -> id , opponentId로 memberservice get(id) 해서 가져옴 -> principal 에서 getName으로 가져옴
//reg페이지 만들면 끝 -> 만듬!

//================fetch에서 쓰기위한 함수 정의
//날짜 데이터 포맷 
//2021-02-04T16:13:30.000+00:00 날짜가 이렇게 되어있어 mm-dd로 만들거야 
function formatDate(strDate, saper){//함수 호출 할때 saper 부분에 '-' 이거 넣으면 되는거구나 근데 saper가 뜻이 안나오는데 뭘까
	if(strDate == ""|| strDate==null){
		return "";
	}
	else 
		return strDate.substring(5,7)+saper+strDate.substring(8,10);
}

    let nextBtnListener = function (e) {
	
	
		
		e.preventDefault();//a태그 효과 막음
		//console.log(e.target)
		//console.log(e.target.href);
		
		


		
		fetch("/api/diary/list?p="+(++pageIndex))
		.then(response=>response.json())
		.then(json=>{
			
			console.log(json);
			if(json.length==0){
				alert("다음페이지가 없습니다.");
				return currentPage;
			}
			
			let makePage1 = `
						<div class="page1">
							<div class="del-button"> 
                    			삭제 
		                    </div> 
		                    <div class="reg-button">
								<a href="reg"> 
		                        글쓰기
 								</a>
		                    </div>
							<div class="diary-list">
								
							</div>
						</div>
						`;
        	book.insertAdjacentHTML('beforeend',makePage1);
			
			let diaryList = currentPage.nextElementSibling.querySelector(".diary-list");
			let panelCount=1;
			for(let d of json){
				let regDate=formatDate(`${d.regDate}`,"-"); //regDate 포맷
				if(panelCount==1 || panelCount ==2){
					let item = `
                        <div class="diary-panel-top"> 
                            <div class="head"> 
                                <div class="deco"> 
                                    <span class="reborn">${regDate}</span> 
                                </div> 
                                <span class="title">${d.title}</span> 
                                <div class="mood"> 
                                    <img src="${d.file} " style="width: 50px; height: 50px;"> 
                                </div> 
                                <form>
                                    <input type="checkbox" class="check-box"/> 
                                    <input type="submit" value="삭제" class="submit-button"> 
                                </form> 
                            </div> 
                            <div class="body"> 
                                <textarea class="content">${d.content}</textarea> 
                            </div> 
                        </div> 
						`;
						diaryList.insertAdjacentHTML('beforeend',item);	
				}
				else{
					let item = `
                        <div class="diary-panel-bottom"> 
                            <div class="head"> 
                                <div class="deco"> 
                                    <span class="reborn">${regDate}</span> 
                                </div> 
                                <span class="title">${d.title}</span> 
                                <div class="mood"> 
                                    <img src="${d.file} " style="width: 50px; height: 50px;"> 
                                </div> 
                                <form>
                                    <input type="checkbox" class="check-box"/> 
                                    <input type="submit" value="삭제" class="submit-button"> 
                                </form> 
                            </div> 
                            <div class="body"> 
                                <textarea class="content">${d.content}</textarea> 
                            </div> 
                        </div> 
						`;
						diaryList.insertAdjacentHTML('beforeend',item);	
				}
				
				
				//console.log(item);		
				//diaryList.insertAdjacentHTML('beforeend',item);	
				panelCount++;
			}//son for문 닫기
			currentPage.classList.add('active');
        	backPage = section.querySelectorAll(".active");
			//새 페이지를 만들었으니 변수를 다시 정의해줘야한다.
			checkBox = section.querySelectorAll(".check-box");
			checkState= false;
			 delBtn = currentPage.nextElementSibling.querySelector(".del-button");
		     regBtn = currentPage.nextElementSibling.querySelector(".reg-button");
		console.log(regBtn);
			regBtn.onclick=()=>{
				alert("등록")
			}
		    submitBtn = currentPage.nextElementSibling.querySelectorAll(".submit-button");
			
		 for (let i = 0; i < checkBox.length; i++) {
	        checkBox[i].onclick = () => {
				console.log("체크박스 클릭")
				
				console.log(checkState);
		
				for(let j = 0;j<checkBox.length;j++){//체크박스 클릭 이벤트 안에서 for문으로 체크를 확인해 하나라도 체크가 되어있으면 break를 줘서 checkState를 true하고 빠져나와 하나도 안되있으면 else로 가서 false가 되겠지
					if(checkBox[j].checked==true){
						checkState=true;
						break;
						}
					else
						checkState=false;
				}
				console.log(checkState);
	            
				if(checkState==true){
					delBtn.style.display = 'block';
	                regBtn.style.display = 'none';
				}
				else{
					delBtn.style.display = 'none';
	                regBtn.style.display = 'block';
				}
	        }
	    }
    

		    //삭제버튼 트리거
		    delBtn.onclick = (e) => {
		        let event = new MouseEvent('click', {
		            bubbles: true,
		            cancelable: true,
		            view: window
		        });
		        for (let i = 0; i < submitBtn.length; i++)
		            submitBtn[i].dispatchEvent(event);
		    }
		    for (let i = 0; i < submitBtn.length; i++) {
			//제출이 4번 눌려
			//체크된것만 제출하게할순 있는데 그래야하나? 일괄삭제 구현하면서 테스트 해보자
		        submitBtn[i].onclick = (e) => {
					console.log(e);
					e.preventDefault();
		            alert("삭제 제출");
		        }
		    }
			
		});//fetch 닫기
			setTimeout(function () {//페이지 넘기는 효과에서 넘어가는 페이지 내용 안보이게
	            currentPage.querySelector(".diary-list").style.display = 'none';
	    	}, 500);
			nextBtn.removeEventListener("click", nextBtnListener);
    };//nextBtnListener 마지막 괄호


    

    var pageContainer = section.querySelector(".page");

//========================================== 이전 버튼 (이전 페이지)
    let prevBtnListener = function (e) {
		e.preventDefault();//a태그 효과 막음
			if(pageIndex==1){
				alert("이전페이지가 없습니다.");
				return ;
			}
			pageIndex-=1;
			/*fetch("/api/diary/list?p="+(--pageIndex))
			.then(response=>response.json())
			.then(json=>{
				let makePage1 = `
						<div class="page1">
							<div class="del-button"> 
                    			삭제 
		                    </div> 
		                    <div class="reg-button"> 
		                        글쓰기 
		                    </div>
							<div class="diary-list">
								
							</div>
						</div>
						`;
	        	book.insertAdjacentHTML('beforeend',makePage1);
				
				let diaryList = currentPage.previousElementSibling.querySelector(".diary-list");
				let panelCount=1;
				for(let d of json){
					let regDate=formatDate(`${d.regDate}`,"-"); //regDate 포맷
					if(panelCount==1 || panelCount ==2){
						let item = `
	                        <div class="diary-panel-top"> 
	                            <div class="head"> 
	                                <div class="deco"> 
	                                    <span class="reborn">${regDate}</span> 
	                                </div> 
	                                <span class="title">${d.title}</span> 
	                                <div class="mood"> 
	                                    <img src="${d.file} " style="width: 50px; height: 50px;"> 
	                                </div> 
	                                <form>
	                                    <input type="checkbox" class="check-box"/> 
	                                    <input type="submit" value="삭제" class="submit-button"> 
	                                </form> 
	                            </div> 
	                            <div class="body"> 
	                                <textarea class="content">${d.content}</textarea> 
	                            </div> 
	                        </div> 
							`;
							diaryList.insertAdjacentHTML('beforeend',item);	
					}
					else{
						let item = `
	                        <div class="diary-panel-bottom"> 
	                            <div class="head"> 
	                                <div class="deco"> 
	                                    <span class="reborn">${regDate}</span> 
	                                </div> 
	                                <span class="title">${d.title}</span> 
	                                <div class="mood"> 
	                                    <img src="${d.file} " style="width: 50px; height: 50px;"> 
	                                </div> 
	                                <form>
	                                    <input type="checkbox" class="check-box"/> 
	                                    <input type="submit" value="삭제" class="submit-button"> 
	                                </form> 
	                            </div> 
	                            <div class="body"> 
	                                <textarea class="content">${d.content}</textarea> 
	                            </div> 
	                        </div> 
							`;
							diaryList.insertAdjacentHTML('beforeend',item);	
					}
				}
			})
*/
        if (currentPage.previousElementSibling != null) {
            currentPage = currentPage.previousElementSibling;
            if (currentPage.classList.contains('active')) {
                currentPage.classList.remove('active');
            }

            currentPage.classList.add('reactive');


            setTimeout(function () {
                //디스플레이가 NONE이었다가 다시 원래의 FLEX가 생김
                currentPage.querySelector(".diary-list").style.display = 'flex';
            }, 700)
            prevBtn.removeEventListener("click", prevBtnListener);
        };
    }

//============================================= 다음페이지, 이전페이지 버튼 이벤트 실행 및 트랜지션이 끝나면 이벤트
	nextBtn.addEventListener('click', nextBtnListener);
	prevBtn.addEventListener('click', prevBtnListener);
    book.addEventListener("transitionend", () => {
        if (currentPage.classList.contains("active")) {
            currentPage = currentPage.nextElementSibling;
            console.log(currentPage);
            //삭제되었던 이벤트리스너 활성화
            nextBtn.addEventListener('click', nextBtnListener);
        }
        else if (currentPage.classList.contains("reactive")) {
            currentPage.classList.remove('reactive');

            prevBtn.addEventListener("click", prevBtnListener);

            // setTimeout(function(){
            currentPage.nextElementSibling.remove();
            // },200);
        }
    })

})