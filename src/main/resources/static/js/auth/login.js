window.addEventListener('load', (e) => {
    const loginBtn = document.querySelector('.login-btn');
    const form = document.querySelector('.form');
    //const findPwdBtn = document.querySelector('.find-pwd-btn');

    loginBtn.addEventListener('click', (e) => {
        e.preventDefault(); // 기본 폼 동작 막기

        let loginId = document.querySelector('.login-id').value;
        let password = document.querySelector('.password').value;
        console.log(loginId);
        console.log(password);
        
        let loginData = {
            method: 'POST',
            body: JSON.stringify({ loginId, password }),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        fetch(`/auth/login/validate`, loginData)
            .then(response => response.json())
            .then(response => {
                if (response) 
                    form.submit(); // 기본 폼 동작 풀기
                
            })
            .catch(err => {
                alert('아이디 또는 패스워드를 확인해 주세요.');
            });

    });
    
    // findPwdBtn.addEventListener('click', (e) => {
    //     e.preventDefault(); // a태그 기본 동작 막기
    //     window.open('/auth/find', '비밀번호 찾기', 'width=500px,height=500px,top:300px,left:700px');
    // });
	
	let googleBtn = document.querySelector(".googleBtn");
	googleBtn.addEventListener("click",()=>{
		location.href="http://localhost:8080/auth/GOOGLE";
	});
	
});


