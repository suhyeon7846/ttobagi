
//import CSS from "./CSS.js";

class ModalBox{
    
    // 1. 객체를 모두 직접 생성했을 때의 장점/단점
    // createElement/appendChild
    // 2. 객체를 모두 문자열로 생성했을 때의
    // innertHTML
    // 3. 객체 생성과 문자열을 조합
    // outer Element만 생성 -> inner는 html로   
    static alert(message=""){
        
        
        return new Promise(resolve=>{
            
            let screen = document.createElement("div");
            let frame = document.createElement("div");
            // 차트, 탐색기, 드래그 업로드 박스, 모달박스, 편집기, ...
            CSS.set(screen, {
                position:"fixed",
                left:"0px",
                top:"0px",
                width:"100%",
                height:"100%",
                background:"#000",
                opacity:"0",
                transition:"opacity 1s"
            });
            document.body.append(screen);

            setTimeout(()=>{
                CSS.set(screen,{
                    opacity:"0.7"
                })
            });

            screen.addEventListener("transitionend", ()=>{
                CSS.set(frame, {
                    opacity:"1",
                    top:"100px"
                });
            });

            
            CSS.set(frame, {
                position:"fixed",
                top: "50px",
                left:"100px",
                background: "#fff",
                width:"300px",
                minHeight: "150px",
                display: "flex",
                flexDirection: "column",
                opacity:"0",
                transition:"top 1s"
            });
            
            frame.innerHTML = `
            <div>
            알림
            </div>
            <div style="flex-grow: 1; display:flex;justify-content: center;align-items: center;">
            ${message}
            </div>
            <div style="display:flex;justify-content: center; border-top: 1px solid #e9e9e9;">
            <input type="button" value="OK">
            <input type="button" value="CANCEL">
            </div>
            `;

            document.body.append(frame);

            const okButton = frame.querySelector("input[value=OK]");
            const cancelButton = frame.querySelector("input[value=CANCEL]");
            okButton.onclick = ()=>{
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
    static confirm(){
        
    }    
}

export default ModalBox;