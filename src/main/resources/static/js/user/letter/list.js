import ModalBox from "./modules/ModalBox.js";
// import CSS from "./modules/CSS.js";

window.addEventListener('load',()=>{
    let section = document.querySelector("#main");
    let letter = section.querySelector(".letter");
    console.log(letter);
    letter.onclick=(e)=>{
        (async () => {
            let result = await ModalBox.alert("hello");
            console.log("가 눌렸구나");
        })
        alert("편지")
    }    
})