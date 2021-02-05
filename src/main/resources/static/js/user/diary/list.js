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

	let pageIndex=1; //fetch에서 페이지할때 쓸 변수
		
    for (let i = 0; i < checkBox.length; i++) {
        checkBox[i].onclick = () => {
            //이 조건문을 어케하면 더 좋게 될까..
            if (checkBox[0].checked == true || checkBox[1].checked == true || checkBox[2].checked == true || checkBox[3].checked == true) {//비교를 할때 또 for문돌려서 다 비교해보자
                delBtn.style.display = 'block';
                regBtn.style.display = 'none';
                // currentPage.querySelector(".diary-list").style.top='49px';
            }
            else {
                delBtn.style.display = 'none';
                regBtn.style.display = 'block';
                // currentPage.querySelector(".diary-list").style.top='79px';
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
//날짜 월-일 만 나오게 -> api컨트롤러가 가지고 오는 db의 regDate를 %m-%d 로 가져오면 해결
//check박스 누르면 동적으로 삭제버튼
//1,2면 위쪽 패널, 3,4면 아래쪽 패널
//위쪽 패널, 아래쪽 패널 글씨 크기
//페이지 문제
    let nextBtnListener = function (e) {
		
		e.preventDefault();//a태그 효과 막음
		//console.log(e.target)
		console.log(e.target.href);
		
		let pageFetch = e.target.innerText;// = '다음' 이라는 text
		currentPage.classList.add('active');
        backPage = section.querySelectorAll(".active");


		
		fetch("/api/diary/list?p="+pageIndex++)
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
			
			let diaryList = currentPage.nextElementSibling.querySelector(".diary-list");
			for(let d of json){
				let item = `
                        <div class="diary-panel-top"> 
                            <div class="head"> 
                                <div class="deco"> 
                                    <span class="reborn">${d.regDate}</span> 
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
                                <textarea class="content"> 
                                    ${d.content}
                                </textarea> 
                            </div> 
                        </div> 
						`;
				//console.log(item);		
				diaryList.insertAdjacentHTML('beforeend',item);	
			}
			console.log(checkBox);
			let checkBoxFetch = currentPage.nextElementSibling.querySelector(".check-box");
			console.log(checkBoxFetch);
			
			for (let i = 0; i < checkBoxFetch.length; i++) {
        checkBoxFetch[i].onclick = () => {
            //이 조건문을 어케하면 더 좋게 될까..
            if (checkBoxFetch[0].checked == true || checkBoxFetch[1].checked == true || checkBoxFetch[2].checked == true || checkBoxFetch[3].checked == true) {//비교를 할때 또 for문돌려서 다 비교해보자
                delBtn.style.display = 'block';
                regBtn.style.display = 'none';
                // currentPage.querySelector(".diary-list").style.top='49px';
            }
            else {
                delBtn.style.display = 'none';
                regBtn.style.display = 'block';
                // currentPage.querySelector(".diary-list").style.top='79px';
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
			
		});
		setTimeout(function () {
            // currentPage.style["background-color"]='rgb(239,153,166)';
            currentPage.querySelector(".diary-list").style.display = 'none';
    	}, 300);
		nextBtn.removeEventListener("click", nextBtnListener);
    };//nextBtnListener 마지막 괄호


    

    var pageContainer = section.querySelector(".page");

//========================================== 이전 버튼 (이전 페이지)
    let prevBtnListener = function (e) {

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
prevBtn.addEventListener("click",(e)=>{
		e.preventDefault();
		console.log(e.target)
		
		fetch("/api/diary/list")
		.then(response=>{
			return response.json();
		});	
	});
    

//============================================= 다음페이지, 이전페이지 버튼 이벤트 실행 및 트랜지션이 끝나면 이벤트
	nextBtn.addEventListener('click', nextBtnListener);
	prevBtn.addEventListener('click', prevBtnListener);
    pageContainer.addEventListener("transitionend", () => {
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