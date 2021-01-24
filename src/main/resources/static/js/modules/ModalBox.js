import CSS from "../../js/modules/CSS.js";

class ModalBox{

    static alert(message,title="버킷리스트 등록"){
        return new Promise(resolve=>{
            let screen = document.createElement("div");
            let frame = document.createElement("div");
          
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

            // screen.addEventListener("transitionend", ()=>{
            //     CSS.set(frame, {
            //         opacity:"1",
            //         top:"50%"
            //     });
            // });
            
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
                <div style="flex-grow: 0; display:flex;justify-content: center;align-items: center;background-color:#ee79bd;height:50px;font-size:25px">
                   ${title}
                </div>
                <div style="flex-grow: 0; display:flex;justify-content: center;align-items: center;height:250px;font-size:20px; flex-direction: column;">
                    <h1 style="font-size:20px;height:50px;line-height:50px">원하는 사진을 선택해 주세요</h1>
                    <ul style="width:900px;display:flex;justify-content:space-around ">
                        <li style=" height:200px; display:flex;flex-direction: column;justify-content: space-between;align-items: center; "> <img style="width:120px;" src="/images/user/bucketlist/01.jpg" alt="" /><input type="radio" name="pic"></li>
                        <li style=" height:200px; display:flex;flex-direction: column;justify-content: space-between;align-items: center; "> <img style="width:120px;" src="/images/user/bucketlist/04.jpg" alt="" /><input type="radio" name="pic"></li>
                        <li style=" height:200px; display:flex;flex-direction: column;justify-content: space-between;align-items: center; "> <img style="width:120px;" src="/images/user/bucketlist/05.jpg" alt="" /><input type="radio" name="pic"></li>
                        <li style=" height:200px; display:flex;flex-direction: column;justify-content: space-between;align-items: center; "> <img style="width:120px;" src="/images/user/bucketlist/06.jpg" alt="" /><input type="radio" name="pic"></li>
                        <li style=" height:200px; display:flex;flex-direction: column;justify-content: space-between;align-items: center; "> <img style="width:120px;" src="/images/user/bucketlist/07.jpg" alt="" /><input type="radio" name="pic"></li>
                    </ul>
                </div>
                <div style="flex-grow: 0; display:flex; flex-direction: column;justify-content: space-around;align-items: center;height:140px;">
                   <h1 style="font-size:23px">제목</h1>
                   <p style="color:#979797;">EX) 버킷리스트는 최고야!</p>
                   <input type="text" maxlength="30" style="width:200px;">
                </div>
                <div style="display:flex;justify-content: space-around; align-items: center;border-top: 1px solid #e9e9e9;height:60px;">
                    <input type="button" value="등록" style="width:200px; height:50px; background-color: #ff73c5;border: none;cursor: pointer;font-size:18px">
                    <input type="button" value="취소" style="width:200px; height:50px; background-color: #ff73c5;border: none;cursor: pointer;font-size:18px">
                </div>
            `;

            document.body.append(frame);

            const okButton = frame.querySelector("input[value=등록]");
            const cancelButton = frame.querySelector("input[value=취소]");
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
