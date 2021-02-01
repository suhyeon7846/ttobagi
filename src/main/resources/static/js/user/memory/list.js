window.addEventListener("load",function(){
	let section = document.querySelector(".section-1");
	let screen = section.querySelector(".screen");
    let frame = section.querySelector(".frame");
 	const cancelButton = frame.querySelector("input[value=취소]");
	let contentPlusWrap = document.querySelector(".content-plus-wrap");	
	
	
	const searchOption = document.querySelector("#search-option")	
	const searchBtn = document.querySelector(".search-button");
	let textBox = document.querySelector(".text-box")
	
	/* 등록 페이지 modal */
	contentPlusWrap.addEventListener("click",(evnet)=>{
		screen.style.display = 'block';
		screen.style.zIndex = '3';
    	frame.style.opacity='1';
    	frame.style.top='50%';
		frame.style.zIndex = '3';
    });
    cancelButton.onclick = ()=>{
               screen.style.display = 'none';
		screen.style.zIndex = '1';
    	frame.style.opacity='0';
    	frame.style.top='-900px';
		frame.style.zIndex = '1';
            };
	/* ===================================================================*/
	searchBtn.onclick=()=>{
		let currentOption = searchOption.options[searchOption.selectedIndex].value;
		console.log(textBox.value+":"+currentOption)
	}
	/* 버킷 완료와 삭제시 ajex */	
	let thumbnails = document.querySelector(".thumbnails");
	
	
	thumbnails.onclick=(event)=>{
		if(event.target.classList.contains("cardDelBtn")){
			event.preventDefault();
			let deleteConfirm = confirm("정말 지우시겠습니까?")
			if(deleteConfirm){
				let eTarget = event.target.nextElementSibling;
				let cardId = eTarget.value
			fetch(`/api/memory/delete?c=${cardId}`)
			.then(response=>response.json())
			.then(json=>{
				thumbnails.innerHTML="";
				for(let m of json){
					let tr =`
					  <div class="flip-box"> 
                    <div class="flip">
                        <div class="front">
                            <div class="img-wrap">
                               <img src="/resources/static/images/user/memory/upload/${m.fileName}" alt="${m.fileName}" />
                            </div>
                        </div>
                        <div class="back">
                            <div class="text-wrap">
                                <h1>${m.regDate}</h1>
                                <p>
                                ${m.content}
                                </p>
                            </div>
                           	<input type="button" value="삭제" class="cardDelBtn">
                        </div>
                    </div>
                </div>
					`;
					thumbnails.insertAdjacentHTML("beforeend",tr);
					}
				});
				
			}
		}
	}
/* ===================================================================*/
	
	
});