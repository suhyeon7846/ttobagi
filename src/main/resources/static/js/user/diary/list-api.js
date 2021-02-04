addEventListener("load",(e)=>{
	const nextBtn=document.querySelector(".next");
	const prevBtn=document.querySelector(".prev");
	
	nextBtn.addEventListener("click",(e)=>{
		e.preventDefault();
		console.log(e.target)
		
		/*let request = new XMLHttpRequest();
		
		request.addEventListener("load",(e)=>{
			console.log(e.target.responseText);
		});
		request.open("GET","/api/diary/list");
		request.send();*/
		
		//fetch("/api/diary/list");//위에 데이터 가져오는 리퀘스트가 이거 한줄로 끝나
		fetch("/api/diary/list")
		.then(response=>response)
	});
})