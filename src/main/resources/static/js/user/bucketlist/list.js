import ModalBox from "../../../js/modules/ModalBox.js";


window.addEventListener("load",(event)=>{
    let section = document.querySelector(".section-1");
    let contentPlusWrap = document.querySelector(".content-plus-wrap");
    //let modal = new ModalBox();
    contentPlusWrap.addEventListener("click",(evnet)=>{
	        ModalBox.alert("hello")
	        .then((result)=>{
	            console.log(result+"가 눌렸다")
	    });
    
    });
    
    let dropbtn = document.querySelector(".dropbtn");
    let dropdownContent = document.querySelector(".dropdown-content");
    
    dropbtn.onclick=()=>{
        if(!dropbtn.classList.contains("show")){
        dropbtn.classList.add("show")
        dropbtn.style.top = '500px';
        dropdownContent.style.top = '0px';
        }else{
        dropbtn.style.top = '0px';
        dropdownContent.style.top = '-500px';   
         dropbtn.classList.remove("show")
        }
    }
	
	let thumbnails = document.querySelector(".thumbnails");
	let switchWrap = document.querySelector(".switch-wrap");
	
	thumbnails.onclick=(event)=>{
		console.log("dd")
		console.log(event.target.className)
		if(event.target.classList.contains("update")){
			event.preventDefault();
			console.log(event.target.nextElementSibling.value)
			let eTarget = event.target.nextElementSibling;
			let cardId =eTarget.value;
			fetch(`/api/bucketlist/update?c=${cardId}`)
			.then(response=>response.json())
			.then(json=>{
				thumbnails.innerHTML="";
				for(let b of json){
					let tr =`
					  <div class="box">
                        <div class="img-wrap">
                            <img src="/images/user/bucketlist/${b.fileName}.jpg" alt="${b.fileName}" />
                        </div>
                        <figcaption>
                            <h2>${b.title}</h2>
                            <p>
                                <a href="#">
                               		<input type="button" class="btn">
                               		<span class="icon-container">
                                   	<i class="fas fa-check icon"></i>
                                   	</span>
                               		<span class="btn-wrap update"> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
                                </a>
                               
                              
                                <a href="#">
                               		<input type="button" class="btn">
                               		 <span class="icon-container">
                                   	<i class="fas fa-times icon"></i>
                                   	</span>
                                   	<span class="btn-wrap delete"> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
									<input type="hidden" value="${b.status}">
                                </a>
                               	
                            </p>
                        </figcaption>	
                    </div>
					`;
					thumbnails.insertAdjacentHTML("beforeend",tr);
				}
			});
			
		}else if(event.target.classList.contains("delete")){
			event.preventDefault();
			console.log(event.target.className)
			let deleteConfirm = confirm("정말 지우시겠습니까?")
			if(deleteConfirm){
				let eTarget = event.target.nextElementSibling;
				let cardId = eTarget.value
				let status =  eTarget.nextElementSibling.value;
			fetch(`/api/bucketlist/delete?c=${cardId}&s=${status}`)
			.then(response=>response.json())
			.then(json=>{
				thumbnails.innerHTML="";
				for(let b of json){
					let tr =`
					  <div class="box">
                        <div class="img-wrap">
                            <img src="/images/user/bucketlist/${b.fileName}.jpg" alt="${b.fileName}" />
                        </div>
                        <figcaption>
                            <h2>${b.title}</h2>
                            <p>
                                <a href="#">
                               		<input type="button" class="btn">
                               		<span class="icon-container">
                                   	<i class="fas fa-check icon"></i>
                                   	</span>
                               		<span class="btn-wrap update"> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
                                </a>
                               
                              
                                <a href="#">
                               		<input type="button" class="btn">
                               		 <span class="icon-container">
                                   	<i class="fas fa-times icon"></i>
                                   	</span>
                                   	<span class="btn-wrap delete"> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
									<input type="hidden" value="${b.status}">
                                </a>
                               	
                            </p>
                        </figcaption>	
                    </div>
					`;
					thumbnails.insertAdjacentHTML("beforeend",tr);
				}
			});
			}
			
		}
	};
	switchWrap.onclick=(event)=>{
		if(event.target.classList.contains("check")){
			event.target.classList.remove("check");
			event.target.classList.add("complete");
			let status = 1;
			fetch(`/api/bucketlist/list?s=${status}`)
			.then(response=>response.json())
			.then(json=>{
				thumbnails.innerHTML="";
				for(let b of json){
					let tr =`
					  <div class="box">
                        <div class="img-wrap">
                            <img src="/images/user/bucketlist/${b.fileName}.jpg" alt="${b.fileName}" />
                        </div>
                        <figcaption>
                            <h2>${b.title}</h2>
							<p style="text-align:center;">
							 <a href="#">
                               		<input type="button" class="btn">
                               		 <span class="icon-container">
                                   	<i class="fas fa-times icon"></i>
                                   	</span>
                                   	<span class="btn-wrap delete"> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
									<input type="hidden" value="${b.status}">
                                </a>
							</p>
                        </figcaption>	
                    </div>
					`;
					thumbnails.insertAdjacentHTML("beforeend",tr);
				}
			});
		}else if(event.target.classList.contains("complete")){
			event.target.classList.remove("complete");
			event.target.classList.add("check");
			let stateId = 0;
			fetch(`/api/bucketlist/list?s=${stateId}`)
			.then(response=>response.json())
			.then(json=>{
				thumbnails.innerHTML="";
				for(let b of json){
					let tr =`
					  <div class="box">
                        <div class="img-wrap">
                            <img src="/images/user/bucketlist/${b.fileName}.jpg" alt="${b.fileName}" />
                        </div>
                        <figcaption>
                            <h2>${b.title}</h2>
                            <p>
                                <a href="#">
                               		<input type="button" class="btn">
                               		<span class="icon-container">
                                   	<i class="fas fa-check icon"></i>
                                   	</span>
                               		<span class="btn-wrap update"> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
                                </a>
                                <a href="#">
                               		<input type="button" class="btn">
                               		 <span class="icon-container">
                                   	<i class="fas fa-times icon"></i>
                                   	</span>
                                   	<span class="btn-wrap delete"> 
                                	</span>
                                	<input type="hidden" value="${b.id}">
									<input type="hidden" value="${b.status}">
                                </a>
                               	
                            </p>
                        </figcaption>	
                    </div>
					`;
					thumbnails.insertAdjacentHTML("beforeend",tr);
				}
			});
		}
			
	};
	
		
})