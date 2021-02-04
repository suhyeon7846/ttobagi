window.addEventListener("load", () => {
	const visual = document.querySelector(".visual");
	const type = visual.querySelector(".type");

	//타입에 따라 버튼, div 색상 변경
	function ColorChange(color) {
		let buttonArea = document.querySelector(".button-area");
		let buttons = buttonArea.querySelectorAll(".button");
		let boxes = document.querySelectorAll(".box");
		
		for (let i = 0; i < buttons.length; i++)
			buttons[i].style.backgroundColor = color;

		for (let i = 0; i < boxes.length; i++) {
			boxes[i].style.background = color;
			boxes[i].addEventListener('mouseover', () => {
				boxes[i].style.border = "3px solid" + color;
			});
		}
	}
	
	switch (type.value) {
		case "tip":
			ColorChange("#e7c2ca");
			break;
		case "test":
			ColorChange("#d6dadf");
			break;
		case "item":
			ColorChange("#d8a8e2");
			break;
		case "adult":
			ColorChange("#f498a5");
			break;
		case "doubleDate":
			ColorChange("#e2d78f");
			break;
		case "placeRecom":
			ColorChange("#e7e1c2");
			break;
		case "story":
			ColorChange("#f2c1af");
			break;
		case "trubleAdvice":
			ColorChange("#8ae199");
			break;
		case "wedding":
			ColorChange("#c5c7ea");
			break;
	}
});