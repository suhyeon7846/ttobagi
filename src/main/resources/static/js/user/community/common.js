window.addEventListener("load", ()=>{
    const section = document.querySelector("#main");
	let recomArea = section.querySelector(".recom-area");
	let recomButton = recomArea.querySelector(".recom-button");
	let negativeButton = recomArea.querySelector(".negative-button");
	let recom = recomArea.querySelector("input[name=recom]");
	let negative = recomArea.querySelector("input[name=negative]");
	let delButton = section.querySelector(".del-button");
	
	function ButtonCheck(item,e) {
		let itemKorName = ""; 
		switch(item){
			case "recom":
				itemKorName = "추천";
				recom.value = "recom";
			break;
			
			case "negative":
				itemKorName = "신고";
				negative.value = "negative";
			break;
			case "del":
				itemKorName = "삭제";
				text = " 삭제 시 복구가 불가능합니다.";
		}
		
		let check = confirm("이 글을 "+ itemKorName + "하시겠습니까?" + text);
		if( check != true){
			e.preventDefault();						
		}
	};
	
	recomButton.addEventListener("click", (e)=>{
		ButtonCheck("recom",e);
	});
	
	negativeButton.addEventListener("click", (e)=>{
		ButtonCheck("negative",e);		
	});
	
	delButton.addEventListener("click", (e)=>{
		ButtonCheck("del",e);
	});
	
});
