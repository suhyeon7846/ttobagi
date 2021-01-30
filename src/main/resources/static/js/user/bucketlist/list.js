import ModalBox from "../../../js/modules/ModalBox.js";


window.addEventListener("load",(event)=>{
    let section = document.querySelector(".section-1");
	let screen = section.querySelector(".screen");
    let frame = section.querySelector(".frame");
 	const cancelButton = frame.querySelector("input[value=취소]");
    let contentPlusWrap = document.querySelector(".content-plus-wrap");	
/* 등록 페이지 modal */
    contentPlusWrap.addEventListener("click",(evnet)=>{
	       /* ModalBox.alert()
	        .then((result)=>{
	            console.log(result+"가 눌렸다")
	    });*/
		screen.style.display = 'block';
		screen.style.zIndex = '3';
    	frame.style.opacity='1';
    	frame.style.top='50%';
		frame.style.zIndex = '3';
    });
    cancelButton.onclick = ()=>{
               screen.style.display = 'none';
		screen.style.zIndex = '1';
    	frame.style.opacity='0';
    	frame.style.top='-900px';
		frame.style.zIndex = '1';
            };
/* ===================================================================*/
/* 추천버튼 누르면 top-content 내려오는 코드 */
    let dropbtn = document.querySelector(".dropbtn");
    let dropdownContent = document.querySelector(".dropdown-content");
    
    dropbtn.onclick=()=>{
        if(!dropbtn.classList.contains("show")){
        dropbtn.classList.add("show")
        dropbtn.style.top = '700px';
        dropdownContent.style.top = '0px';
        }else{
        dropbtn.style.top = '0px';
        dropdownContent.style.top = '-700px';   
         dropbtn.classList.remove("show")
        }
    }
	const addCard = section.querySelector(".addCard");
	const newCard = section.querySelector(".newCard");
	const recommendBoxWrap= section.querySelector(".recommend-box-wrap");
	newCard.onclick=()=>{
		fetch(`/api/bucketlist/refresh`)
			.then(response=>response.json())
			.then(json=>{
				recommendBoxWrap.innerHTML="";
				for(let r of json){
					let tr =`
					   <li class="recommend-box">
	                      	<div class="img-wrap">
	                            <img src="/resources/static/images/user/bucketlist/upload/${r.fileName}" alt="${r.fileName}" />
	                            <p class="recommend-title">${r.title}</p>
	                            <input type="radio" name="recommend-pic" value="${r.fileName}">
	                        </div>
	                   </li>
					`;
					recommendBoxWrap.insertAdjacentHTML("beforeend",tr);
				}
			});
	}
	let recommendTitle = document.querySelector(".recommend-title");
	addCard.onclick=()=>{
		var checkCount = document.getElementsByName("recommend-pic").length;
		let coupleId='';
		let pickFile ='';
		let cardTitle=''; 
			for (var i=0; i<checkCount; i++) {
	            if (document.getElementsByName("recommend-pic")[i].checked == true) {
	                pickFile = document.getElementsByName("recommend-pic")[i].value;
	            	cardTitle=document.getElementsByName("recommend-pic")[i].previousElementSibling.innerText;
					coupleId = addCard.previousElementSibling.value;
					console.log(coupleId)
				}
	        };

		
		fetch(`/api/bucketlist/reg?t=${cardTitle}&p=${pickFile}&c=${coupleId}`)
				.then(response=>response.json())
				.then(json=>{
				thumbnails.innerHTML="";
				for(let b of json){
					let tr =`
					  <div class="box">
                        <div class="img-wrap">
                            <img src="/resources/static/images/user/bucketlist/upload/${b.fileName}" alt="${b.fileName}" />
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
/* ===================================================================*/
/* 버킷 완료와 삭제시 ajex */	
	let thumbnails = document.querySelector(".thumbnails");
	let switchWrap = document.querySelector(".switch-wrap");
	
	thumbnails.onclick=(event)=>{
		if(event.target.classList.contains("update")){
			event.preventDefault();
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
                          <img src="/resources/static/images/user/bucketlist/upload/${b.fileName}" alt="${b.fileName}" />
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
                            <img src="/resources/static/images/user/bucketlist/upload/${b.fileName}" alt="${b.fileName}" />
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
			
		}else if(event.target.classList.contains("completeDelete")){
			event.preventDefault();
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
                            <img src="/resources/static/images/user/bucketlist/upload/${b.fileName}" alt="${b.fileName}" />
                        </div>
                        <figcaption>
                            <h2>${b.title}</h2>
							<p style="text-align:center;">
							 <a href="#">
                               		<input type="button" class="btn">
                               		 <span class="icon-container">
                                   	<i class="fas fa-times icon"></i>
                                   	</span>
                                   	<span class="btn-wrap completeDelete"> 
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
	}
/* ===================================================================*/
/* 완료 페이지와 비완료 페이지 전화하는 ajex */	
	switchWrap.onclick=(event)=>{
		if(event.target.classList.contains("check")){
			event.target.classList.remove("check");
			event.target.classList.add("complete");
			/*section.style.background = '#000'; */
			let status = 1;
			fetch(`/api/bucketlist/list?s=${status}`)
			.then(response=>response.json())
			.then(json=>{
				thumbnails.innerHTML="";
				for(let b of json){
					let tr =`
					  <div class="box">
                        <div class="img-wrap">
                            <img src="/resources/static/images/user/bucketlist/upload/${b.fileName}" alt="${b.fileName}" />
                        </div>
                        <figcaption>
                            <h2>${b.title}</h2>
							<p style="text-align:center;">
							 <a href="#">
                               		<input type="button" class="btn">
                               		 <span class="icon-container">
                                   	<i class="fas fa-times icon"></i>
                                   	</span>
                                   	<span class="btn-wrap completeDelete"> 
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
                            <img src="/resources/static/images/user/bucketlist/upload/${b.fileName}" alt="${b.fileName}" />
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
