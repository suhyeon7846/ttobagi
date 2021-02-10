import ModalBox from "./modules/ModalBox.js";
// import CSS from "./modules/CSS.js";

window.addEventListener('load',(e)=>{
    let section = document.querySelector("#main");
    let letter = section.querySelectorAll(".letter");
    let body = section.querySelector(".body");
    console.log(letter);
    //버블링
    body.onclick=(e)=>{
        
        (async () => {
            let result = await ModalBox.alert("hello");
            console.log(result+"가 눌렸구나");
        })();
        
    }    
})