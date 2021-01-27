window.addEventListener('load',()=>{
    let section = document.querySelector("#main");
    let heartBtn = section.querySelector(".heart");
    let cover = section.querySelector(".cover");

    console.log(section);
    console.log(heartBtn);
    console.log(cover);
    heartBtn.onclick = ()=>{
        cover.style.transform='translateY(-500px)';
        console.log("하트")
    }
})