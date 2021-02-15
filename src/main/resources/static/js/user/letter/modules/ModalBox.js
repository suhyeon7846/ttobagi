import CSS from "./CSS.js";

class ModalBox{
    static alert(message){
        // static alert(message, resolve){
		return new Promise(resolve=>{
			let screen = document.createElement("div");
            let screen2 = document.createElement("div");
			let frame = document.createElement("div");

			CSS.set(screen,{
				position:"fixed",
				left:"0px",top:"0px",
				width:"100%", height:"100%",background:"#000",
                // backgroundImage:"url('/src/main/resources/static/images/user/letter/background1.png')",
				opacity:"0",
                transition:"0.5s"
			});
            
            setTimeout(()=>{//한번에 처리되기때문에 얘를 한번에 처리 안되게 setTimeout 해준다          
                CSS.set(screen,{
                    opacity:"0.7",
                });
            })

            screen.addEventListener("transitionend",()=>{
                CSS.set(frame,{
                    
                    opacity:"1"
                })
            });

            // CSS.set(screen2,{
            //     position:"fixed",
            //     top: "calc(50% - 300px)",
            //     left:"calc(50% - 350px)",
            //     background: "#bf3032",
            //     width:"700px",
            //     minHeight: "600px",
            //     display: "flex",
            //     flexDirection: "column",
            //     opacity:"1",
            //     transition:"1s"           
            // });

			CSS.set(frame, {
                position:"fixed",
                top: "calc(50% - 250px)",
                left:"calc(50% - 300px)",
                // background: "#fff",
                width:"600px", //얇은거 넓은거 비교
                Height: "486px",
                display: "flex",
                flexDirection: "column",
                opacity:"0",
                transition:"1s",
                borderRadius:"10px",
                overflow:"hidden"
            });
            // frame.style.borderRadius="10px";
			

			frame.innerHTML = `
            <div class="modal" style="background-image:URL(/src/main/resources/static/images/user/letter/header1.jpg);">
                <header>
                    <div class="to">
                        <span >To. 누구누구에게</span><!--보내는 사람 없으면 자동으로 상대방 이름-->
                        <!-- <span >2021-02-09</span> -->
                    </div>
                    <div class="title">
                        ${message}
                    </div>
                </header>
                <textarea class="content" disabled >내용</textarea>
                <div class="button-box">
                    <input type="button" value="답장쓰기">
                    <input type="button" value="닫기">
                </div>
                
            </div>
            `;
            // document.body.append(screen2);
			document.body.append(screen);
			document.body.append(frame);

            const okButton = frame.querySelector("input[value=답장쓰기]");
            console.log(okButton);
            const cancelButton = frame.querySelector("input[value=닫기]");
            okButton.onclick = ()=>{
                resolve("답장쓰기");
                screen.remove();
                frame.remove();
            };
            cancelButton.onclick = ()=>{
                resolve("닫기");                
                screen.remove();
                frame.remove();
            };
		})
	}
	static confirm(){

	}
}
export default ModalBox;
