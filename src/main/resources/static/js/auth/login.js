window.addEventListener('load', (e) => {
    const loginBtn = document.querySelector('.login-btn');
    const form = document.querySelector('.form');

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
    
});


