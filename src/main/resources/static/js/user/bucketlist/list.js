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
})  