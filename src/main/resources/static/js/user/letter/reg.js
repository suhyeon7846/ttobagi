window.addEventListener("load",()=>{
    let section = document.querySelector("#main-reg");
    let form = section.querySelector("form");
    let submit = section.querySelector("input[type=submit]");
    console.log(submit);
    console.log(form);
    console.log(section);

    /*submit.onclick=(e)=>{
        let ckeditorData = CKEDITOR.instances['content'].getData();
        console.log(ckeditorData);
        const formData = new FormData();
				
        formData.append('content', ckeditorData);

        fetch(`/api/letter/reg`,{
            method:'POST',
            body:FormData
        })
        .then(response=>response.json())
        .then(json=>{

        })
    }*/
})