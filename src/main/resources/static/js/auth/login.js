window.addEventListener('load', (e) => {
    const loginBtn = document.querySelector('.login-btn');

    loginBtn.addEventListener('click', (e) => {
        let loginId = document.querySelector('.login-id').value;
        let password = document.querySelector('.password').value;
        console.log(loginId);
        console.log(password);

        let loginData = {
            method: 'POST',
            body: JSON.stringify(1),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        fetch(`/auth/login`, loginData)
            .then(response => response.json())
            .then(response => {
                if (response)
                    alert('로그인에 성공했습니다.');
                
            })
            .catch(err => {
                e.preventDefault();
                alert('아이디 또는 패스워드를 확인해 주세요.');
            });

    });
    
});