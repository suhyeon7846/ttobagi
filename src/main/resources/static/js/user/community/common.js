window.addEventListener("load", () => {
	const section = document.querySelector("#main");
	let recomForm = section.querySelector(".recomForm");
	let recomArea = section.querySelector(".recom-area");
	let comment = section.querySelector("input[name=commentText]");
	let commentRegButton = section.querySelector(".comment-reg-button");	
	 
	let type = section.querySelector(".community-type").value;

	commentRegButton.addEventListener("click", (e)=>{
		e.preventDefault();
		let commentText = comment.value;
		console.log(commentText);
		
		let communityId = section.querySelector(".community-id").value;
		
		fetch(`/api/community/${type}/${communityId}/commentInsert/${commentText}`)
		.then(response=>response.json())
		
		//let url = `/user/community/${type}/${id}/${commentText}/commentInsert`;

		//location.href=`/user/community/${type}/${id}`;
	});
	
	/*recomArea.addEventListener("click", (e) => {
		e.preventDefault(); //일단 버튼 작동 해제
		if (e.target.tagName != "BUTTON")
			return;

		let itemName = e.target.name;
		let itemKorName = "";
		switch (itemName) {
			case "recom":
				itemKorName = "추천";
				break;
				
			case "negative":
				itemKorName = "신고";
				break;
		}
		
		let buttonCheck = confirm("이 글을 " + itemKorName + " 하시겠습니까?");
		if (buttonCheck != true) return;
		
		fetch(`/api/community/${type}/${communityId}/commentInsert`)
		.then(response=>response.json())
			
	});*/
	
	
/*	recomArea.addEventListener("click", (e) => {
		let val = itemName;
		let id = section.querySelector(".community-id").value;
		let url = `/user/community/${type}/${id}/${val}`;
		/*let fd = new FormData();
		fd.append("id", id);
		fd.append("val", e.target.value);*/

		//ajax(url);
		
		//location.replace(`/user/community/${type}/${id}`);






	/*
	let negativeButton = recomArea.querySelector(".negative-button");
	let delButton = section.querySelector(".del-button");
	const comment =document.querySelector(".del-comment");
	
	function ButtonCheck(item,e) {
		let itemKorName = ""; 
		switch(item){
			case "recom":
				itemKorName = "추천";
				e.target.value = "recom";
			break;
			
			case "negative":
				itemKorName = "신고";
				e.target.value = "negative";
			break;
			
			case "del":
				itemKorName = "삭제";
				text = " 삭제 시 복구가 불가능합니다.";
		}
		
		console.log(e.target.value);
		return;
		let check = confirm("이 글을 "+ itemKorName + "하시겠습니까?" + text);
		
	};
	
	recomButton.addEventListener("click", (e)=>{
		e.preventDefault();
		let check = confirm("이 글을 "+ itemKorName + "하시겠습니까?" + text);
		if( check != true ) return;
		else{
			console.log(e.target.value);
			e.target.value = "1";
			recomForm.submit();
		}
		
		ButtonCheck("recom",e);
	});
	
	negativeButton.addEventListener("click", (e)=>{
		e.preventDefault();
		ButtonCheck("negative",e);		
	});
	
	comment.addEventListener("click", (e)=>{
		e.preventDefault();
		if(e.target.classList.contains("del-button")){
		ButtonCheck("del",e);
		let id = e.target.value;
		fetch(`/user/community/delete/${id}`,{method:"POST"});
		}
	});
	*/

});
