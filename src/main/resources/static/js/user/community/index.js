window.addEventListener("load", (e) => {
	let section = document.querySelector("#main");
	let menuItem = section.querySelector(".menu");
	let visual = section.querySelector(".visual");
	
	menuItem.onclick = function(e){
		let menuVal = e.target.value;
		console.log(menuVal);
	}
});