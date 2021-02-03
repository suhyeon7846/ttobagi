window.addEventListener("load", ()=>{
    const section = document.querySelector("#main");
    let recomButton = section.querySelector(".recom-button");
    let reportButton = section.querySelector(".report-button");
    let popupContainer = section.querySelector(".popup-container");
    let popupCancelButton = section.querySelector(".popup-cancel-button");

    recomButton.onclick = function(){
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