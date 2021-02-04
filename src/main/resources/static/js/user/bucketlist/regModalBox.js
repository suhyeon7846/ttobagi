import CSS from "../../modules/CSS.js";
class ModalBox{

    static alert(){
        return new Promise(resolve=>{
            let screen = document.createElement("div");
            let frame = document.createElement("div");
         	let thumbnails = document.querySelector(".thumbnails");
            CSS.set(screen, {
                position:"fixed",
                left:"0px",
                top:"0px",
                width:"100%",
                height:"100%",
                background:"#000",
                opacity:"0",
                transition:"0.7s",
                zIndex:"3"
            });

            document.body.append(screen);
           
            setTimeout(()=>{
                CSS.set(screen, {
                    opacity:"0.4"
                });
                CSS.set(frame, {
                    opacity:"1",
                    top:"50%"
                });
            });

            CSS.set(frame, {
                position:"fixed",
                top: "30%",
                left:"50%",
                background: "#fff",
                width:"900px",
                minHeight: "500px",
                marginLeft : "-450px",
                marginTop : "-250px",
                display: "flex",
                flexDirection: "column",
                opacity:"0",
                transition:"top 0.7s",
                zIndex:"3"             
            });

            frame.innerHTML = `
                 <div class="frame-top">
		          <h1>버킷리스트 등록</h1>     
				</div>
                <div class="frame-file-wrap">
                    <h1>원하는 사진을 선택해 주세요</h1>
                   <img style="width: 100px;" id="edit-preview-image" src="">
					<input type="file" name="file" id="file-input" accept=".jpg, .png">
                </div>
                <div class="frame-text-wrap">
                  <h1>제목</h1>
                  <p>EX) 버킷리스트는 최고야!</p>
				  <p><40글자 내외로 기입해주세요></p>
                  <input type="text" maxlength="40" name="titlename" id="text-input" required>
               </div>
                <div class="frame-btn-wrap">
                    <input type="button" value="등록">
                    <input type="button" value="취소">
                </div>
            `;
            document.body.append(frame);
			//썸네일 미리보기 
				const fileInput = document.querySelector("#file-input");
				fileInput.addEventListener("change", e => {
				    readImage(e.target)
				})
				function readImage(input) {
			    // 인풋 태그에 파일이 있는 경우
			    if(input.files && input.files[0]) {
			        // 이미지 파일인지 검사 (생략)
			        // FileReader 인스턴스 생성
			        const reader = new FileReader()
			        // 이미지가 로드가 된 경우
			        reader.onload = e => {
			            const previewImage = document.getElementById("edit-preview-image")
			            previewImage.src = e.target.result
			        }
			        // reader가 이미지 읽도록 하기
			        reader.readAsDataURL(input.files[0])
			    }
			}
			//================================
            const okButton = frame.querySelector("input[value=등록]");
            const cancelButton = frame.querySelector("input[value=취소]");
			okButton.onclick = ()=>{
				let textInput = document.querySelector("#text-input").value;
				const formData = new FormData();
				
				formData.append('file', fileInput.files[0]);
				formData.append('titleName', textInput);
				
				fetch(`/api/bucketlist/reg`,{
					method: 'POST',
					body : formData
				})
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
                resolve("OK");
                screen.remove();
                frame.remove();
            };
            cancelButton.onclick = ()=>{
                resolve("CANCEL");
                screen.remove();
                frame.remove();
            };
        });
    }
}

export default ModalBox;
