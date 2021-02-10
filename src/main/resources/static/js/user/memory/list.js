import editModalBox from "../memory/editModalBox.js";
import regModalBox from "../memory/regModalBox.js";

window.addEventListener("load",function(){
	let section = document.querySelector(".section-1");
	let contentPlusWrap = document.querySelector(".content-plus-wrap");	
	
	
	const searchOption = section.querySelector("#search-option")	
	const searchBtn = section.querySelector(".search-button");
	let textBox = section.querySelector(".text-box")
	
	/* 등록 페이지 modal */
	contentPlusWrap.addEventListener("click",()=>{
		
		regModalBox.alert()
    });
  
	/* 검색===================================================================*/
	searchBtn.onclick=()=>{
		let currentOption = searchOption.options[searchOption.selectedIndex].value;
		let text=textBox.value;
		fetch(`/api/memory/list?o=${currentOption}&t=${text}`)
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
                                ${m.content}
                            </div>
							<input type="button" value="수정" class="cardEditBtn">
                            <input type="hidden" value="${m.fileName}">
                           	<input type="button" value="삭제" class="cardDelBtn">
							<input type="hidden" value="${m.id}">
                        </div>
                    </div>
                </div>
					`;
					thumbnails.insertAdjacentHTML("beforeend",tr);
					}
		})
		
	}
	/* 추억 삭제 또는 수정 ajex */	
	let thumbnails = document.querySelector(".thumbnails");
	
	thumbnails.onclick=(event)=>{
		if(event.target.classList.contains("cardDelBtn")){
			event.preventDefault();
			let deleteConfirm = confirm("정말 지우시겠습니까?");
			if(deleteConfirm){
				let eTarget = event.target.nextElementSibling;
				let cardId = eTarget.value;
				let fileName = event.target.previousElementSibling.value;
			fetch(`/api/memory/delete?c=${cardId}&f=${fileName}`)
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
								<div>
                                ${m.content}
								</div>
                            </div>
							<input type="button" value="수정" class="cardEditBtn">
                            <input type="hidden" value="${m.fileName}">
                           	<input type="button" value="삭제" class="cardDelBtn">
							<input type="hidden" value="${m.id}">
                        </div>
                    </div>
                </div>
					`;
					thumbnails.insertAdjacentHTML("beforeend",tr);
						 }
				});
				
			}
		}else if(event.target.classList.contains("cardEditBtn")){
			let fileName = event.target.nextElementSibling.value;
			let content = event.target.previousElementSibling.lastElementChild.innerHTML;
			let cardId = event.target.nextElementSibling.nextElementSibling.nextElementSibling.value;
			
			editModalBox.alert(fileName,content,cardId)
		}
	}
/* ===================================================================*/
	
});