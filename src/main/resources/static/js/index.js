window.addEventListener('load', e => {
    AOS.init();

	const calendarBtn = document.querySelector(".calendar .btn");
	calendarBtn.addEventListener("click",()=>{
		location.href = "http://localhost:8080/user/calendar/list";
	})
});