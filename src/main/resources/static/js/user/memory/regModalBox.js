import CSS from "../../modules/CSS.js";
class ModalBox{

    static alert(){
        return new Promise(resolve=>{
			let section = document.querySelector(".section-1")
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
		 section.append(screen);
           /* document.body.append(screen);*/
           
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
                minHeight: "600px",
                marginLeft : "-450px",
                marginTop : "-300px",
                display: "flex",
                flexDirection: "column",
                opacity:"0",
                transition:"top 0.7s",
                zIndex:"3"             
            });

            frame.innerHTML = `
                 <div class="frame-top">
               		추억 등록
				</div>
                <div class="frame-file-wrap">
                    <h1>원하는 사진을 선택해 주세요</h1>
                   <img style="width: 100px;" id="edit-preview-image" src="">
					<input type="file" name="file" id="file-input" accept=".jpg, .png">
                </div>
                <div class="frame-text-wrap">
                  
	                 <textarea rows="50" cols="50" name="content" id="text-input"></textarea>
                </div>
                <div class="frame-btn-wrap">
                    <input type="button" value="등록">
                    <input type="button" value="취소">
                </div>
            `;
			section.append(frame);
			CKEDITOR.replace( 'text-input' );
           /* document.body.append(frame);*/
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
				let textInput = CKEDITOR.instances['text-input'].getData();
				const formData = new FormData();
				
				formData.append('file', fileInput.files[0]);
				formData.append('content', textInput);
				
				fetch(`/api/memory/reg`,{
					method: 'POST',
					body : formData
				})
				.then(response=>response.json())
				.then(json=>{
				thumbnails.innerHTML="";
				for(let m of json){
					let tr =`
					  <div class="flip-box"> 
                    <div class="flip">
                        <div class="front">
                            <div class="img-wrap">
                               <img src="/resources/static/images/user/memory/upload/${m.fileName}" alt="${m.fileName}" />
                            </div>
                        </div>
                        <div class="back">
                            <div class="text-wrap">
                                <h1>${m.regDate}</h1>
                                ${m.content}
                            </div>
							<input type="button" value="수정" class="cardEditBtn">
                            <input type="hidden" value="${m.fileName}">
                           	<input type="button" value="삭제" class="cardDelBtn">
							<input type="hidden" value="${m.id}">
                        </div>
                    </div>
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
