import ModalBox from "../../../js/modules/ModalBox.js";

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
                                <p>
                                ${m.content}
                                </p>
                            </div>
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
	/* 추억 삭제시 ajex */	
	let thumbnails = document.querySelector(".thumbnails");
	
	thumbnails.onclick=(event)=>{
		if(event.target.classList.contains("cardDelBtn")){
			event.preventDefault();
			let deleteConfirm = confirm("정말 지우시겠습니까?");
			if(deleteConfirm){
				let eTarget = event.target.nextElementSibling;
				let cardId = eTarget.value;
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
			console.log(event.target.nextElementSibling.value)
			let fileName = event.target.nextElementSibling.value;
			console.log(event.target.previousElementSibling.lastElementChild.innerText)
			let content = event.target.previousElementSibling.lastElementChild.innerText;
			ModalBox.alert(fileName,content)
			.then((result)=>{
				console.log("hi")
			})
		}
	}
/* ===================================================================*/
	const inputImage = document.getElementById("input-image")
	inputImage.addEventListener("change", e => {
	    readImage(e.target)
	})
	function readImage(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            const previewImage = document.getElementById("preview-image")
            previewImage.src = e.target.result
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0])
    }
}
	
});