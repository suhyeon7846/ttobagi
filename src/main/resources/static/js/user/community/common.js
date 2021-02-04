window.addEventListener("load", ()=>{
    const section = document.querySelector("#main");
	let recomArea = section.querySelector(".recom-area");
	let recomButton = recomArea.querySelector(".recom-button");
	let negativeButton = recomArea.querySelector(".negative-button");
	let recom = recomArea.querySelector("input[name=recom]");
	let negative = recomArea.querySelector("input[name=negative]");
	
	console.log("기본:"+recom.value);
	function recomCheck(item) {
		console.log(item);
		let itemKorName = ""; 
		switch(item){
			case "recom":
				itemKorName = "추천";
			break;
			
			case "negative":
				itemKorName = "신고";
			break;
		}
		
		let recomCheck = confirm("이 글을 "+ itemKorName + "하시겠습니까?");
		if( recomCheck == true){
			console.log("여기까진 오냐?"+ item);
			if( item = negative){
				console.log("여기로 들어오냐 안들어오냐?");
				recom.value = 1;
				negative.value = 2;				
			}
			else if( item = recom){
				negative.value = 1;
				recom.value = 2;
			}
		}
	};
	
	recomButton.addEventListener("click", ()=>{
		recomCheck("recom");
	});
		
	
	negativeButton.addEventListener("click", ()=>{
		recomCheck("negative");		
	});
	
});
