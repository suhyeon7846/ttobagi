window.addEventListener("load", (e)=>{
    const section = document.querySelector("#main");
    let buttons = section.querySelector(".button-area");
    let recomButton = section.querySelector(".recom-button");
    let reportButton = section.querySelector(".report-button");
    let popupContainer = section.querySelector(".popup-container");
    let popupCancelButton = section.querySelector(".popup-cancel-button");

    buttons.onclick = function(e){
        let buttonVal = e.target.value;
		let request = new XMLHttpRequest();
		request.onload = function(){
			let id = JSON.parse(request.responseText);
		}
        switch(buttonVal){
            case "list":
                console.log("리스트");
                location.href="list";
                break;
            case "update":
                console.log("수정");
                location.href="edit/"+id;
                break;
            case "delete":
                console.log("삭제");
                break;
            case "write":
                console.log("글쓰기");
                location.href="reg";
        }
    };

    recomButton.onclick = function(e){
        console.log("추천");
        alert("추천되었습니다.");
    };

	reportButton.onclick = function() {
		console.log("신고");
		popupContainer.classList.remove("d-none");
	}

	popupCancelButton.onclick = function() {
		popupContainer.classList.add("d-none");
    }
});