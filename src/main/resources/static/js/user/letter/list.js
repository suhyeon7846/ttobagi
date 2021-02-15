import ModalBox from "./modules/ModalBox.js";
import CSS from "./modules/CSS.js";

window.addEventListener('load', (e) => {
    let section = document.querySelector("#main");
    let letter = section.querySelectorAll(".letter");
    let body = section.querySelector(".letter-content");
    let regBtn = section.querySelector(".reg-del-box .reg");
    let delBtn = section.querySelector(".reg-del-box .del");
    let changeRegBtn = section.querySelector(".change-reg");
    let changeDelBtn = section.querySelector(".change-del");
    let rdBox = section.querySelector(".reg-del-box");
    let reg_del_state = true;

    let checkLabel = section.querySelectorAll("label");
    let delInput = section.querySelector(".del-input");




    delBtn.addEventListener("click", (e) => {
        var event = new MouseEvent('click', {
            bubbles: true,
            cancelable: true,
            view: window
        });
        delInput.dispatchEvent(event);
    });




    //버블링
    body.onclick = (e) => {
        let target = e.target;

        while (target.id != "letter") {
            target = target.parentNode;
        };
        console.log(target);
        console.log(target.lastElementChild.previousSibling.previousSibling.value);//id 확인
        console.log(target.lastElementChild.previousSibling.previousSibling.previousSibling.previousSibling);//name확인
        let id = target.lastElementChild.previousSibling.previousSibling.value;
        let img = target.lastElementChild.previousSibling.previousSibling.previousSibling.previousSibling.firstElementChild;
        img.src = "../../images/user/letter/letter1.png";
        img.style.width = "90px";
        img.style.marginRight = "10px";
        console.log(img.src);
        let name = target.lastChild.previousSibling.value;
        //오리지널 모달박스 -> 프론트작업할때 ajax안대니까 이걸로 하자
        //(async () => {
        //    let result = await ModalBox.alert("hello");
        //    console.log(result+"가 눌렸구나");
        //})();
        
        //fetch에서 분리해서 해봄
        let screen = document.createElement("div");
        let frame = document.createElement("div");

        CSS.set(screen, {
            position: "fixed",
            left: "0px", top: "0px",
            width: "100%", height: "100%", background: "#000",
            opacity: "0",
            transition: "0.5s"            
        });
        setTimeout((e) => {//한번에 처리되기때문에 얘를 한번에 처리 안되게 setTimeout 해준다          
            CSS.set(screen, {
                opacity: "0.7",
            });
        },1);

        CSS.set(frame, {
            position: "fixed",
            top: "calc(50% - 250px)",
            left: "calc(50% - 300px)",
            //background: "url(../../../images/user/letter/header1.jpg)",
            width: "600px", //얇은거 넓은거 비교
            Height: "486px",
            display: "flex",
            flexDirection: "column",
            opacity: "0",
            transition:"0.5s",
            borderRadius: "10px",
            overflow: "hidden"

        });
        screen.addEventListener("transitionend", () => {
            CSS.set(frame, {

                opacity: "1"
            })
        },1);
        document.body.append(screen);
        document.body.append(frame);
        //fetch에서 분리해서 해봄 끝

        fetch("/api/letter/" + id)
            .then(response => response.json())
            .then(json => {
                console.log(json);
                frame.innerHTML = `
            <div class="modal">
                <header>
                    <div class="to">
                        <span >To.${name}에게</span><!--보내는 사람 없으면 자동으로 상대방 이름-->
                        <!-- <span >2021-02-09</span> -->
                    </div>
                    <div class="title">
                        ${json.title}
                    </div>
                </header>
                <textarea class="content" disabled >${json.content}</textarea>
                <div class="button-box">
                    <a href="reg"><input type="button" value="답장쓰기"></a>
                    <input type="button" value="닫기">
                </div>
                
            </div>
            `;
                const okButton = frame.querySelector("input[value=답장쓰기]");
                const cancelButton = frame.querySelector("input[value=닫기]");
                okButton.onclick = () => {
                    screen.remove();
                    frame.remove();
                };
                cancelButton.onclick = () => {
                    screen.remove();
                    frame.remove();
                };


                console.log("fetch끝");
            })//fetch 끝
    }

    changeRegBtn.onclick = (e) => {
        if (reg_del_state == false) {
            rdBox.style.transform = "translateY(0px)";
            reg_del_state = true;
            console.log("체인지 레그");
            changeRegBtn.style.background = "pink";
            changeDelBtn.style.background = "gray";
            // for(var i=0;i<letter.length;i++){
            //     letter[i].style.transform="translateX(0px)";
            // }

            for (let i = 0; i < letter.length; i++) {
                checkLabel[i].style.display = "none";

            }
        }
    }

    changeDelBtn.onclick = (e) => {
        if (reg_del_state == true) {
            rdBox.style.transform = "translateY(-100px)";
            reg_del_state = false;
            changeRegBtn.style.background = "gray";
            changeDelBtn.style.background = "pink";

            // for(var i=0;i<letter.length;i++){
            //     letter[i].style.transform="translateX(-20px)";
            // }

            for (let i = 0; i < letter.length; i++) {
                checkLabel[i].style.display = "inline-block";
                checkLabel[i].style.transform = "translateX(10px)";
            }
        }
    }

})