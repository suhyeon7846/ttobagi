window.addEventListener('load', () => {
    const dupLoginIdBtn = document.querySelector('.dup-login-id-btn');
    const dupNicknameBtn = document.querySelector('.dup-nickname-btn');

    const loginId = document.querySelector('.login-id');
    const password = document.querySelector('.password');
    const passwordConfirm = document.querySelector('.password-confirm');
    const name = document.querySelector('.name');
    const nickname = document.querySelector('.nickname');
    const gender = document.querySelector('.gender-radio-btn:checked');
    const birthday = document.querySelector('.birthday');
    const phone = document.querySelector('.phone');

    const submitBtn = document.querySelector('.submit-btn');

    let isLoginIdCheck = false;
    let isNicknameCheck = false;
    
    dupLoginIdBtn.addEventListener('click', (e) => {
        let isDuplication = false;

        if (loginId.value == '') {
            alert('로그인 아이디를 입력해 주세요.');
            return;
        }

        fetch(`/auth/loginIdCheck/${loginId.value}`)
            .then(response => response.json())
            .then(response => {
                if (response)
                    isDuplication = true; // 중복된 상태
                
                dupLoginIdBtn.value = '사용 가능';
                dupLoginIdBtn.style.background = '#C4F0E3';
                dupLoginIdBtn.style.border = '1px solid #A5F0E3';
                isLoginIdCheck = true;

                if (isDuplication) {
                    dupLoginIdBtn.value = '사용 불가';
                    dupLoginIdBtn.style.background = '#E08080';
                    dupLoginIdBtn.style.border = '1px solid #E05B59';
                    isLoginIdCheck = false;
                } 
            });

    });

    dupNicknameBtn.addEventListener('click', (e) => {
        let isDuplication = false;
    
        if (nickname.value == '') {
            alert('닉네임을 입력해 주세요.');
            return;
        }

        fetch(`/auth/nicknameCheck/${nickname.value}`)
            .then(response => response.json())
            .then(response => {
                if (response)
                    isDuplication = true; // 중복된 상태
                
                dupNicknameBtn.value = '사용 가능';
                dupNicknameBtn.style.background = '#C4F0E3';
                dupNicknameBtn.style.border = '1px solid #A5F0E3';
                isNicknameCheck = true;
                
                if (isDuplication) {
                    dupNicknameBtn.value = '사용 불가';
                    dupNicknameBtn.style.background = '#E08080';
                    dupNicknameBtn.style.border = '1px solid #E05B59';
                    isNicknameCheck = false;
                } 
            });

    });

    submitBtn.addEventListener('click', (e) => {
        // 1. 로그인 아이디 및 닉네임 중복체크 확인
        if (isLoginIdCheck === false || isNicknameCheck === false) {
            alert('로그인 아이디 또는 닉네임 중복체크가 필요합니다.');
            e.preventDefault();
            return false;
        }

        // 2. 패스워드, 패스워드 확인 비교
        if (password.value !== passwordConfirm.value) {
            alert('동일한 비밀번호를 입력해 주세요.');
            return false;
        }

        //alert('회원가입이 정상적으로 완료되었습니다.');
    });
});