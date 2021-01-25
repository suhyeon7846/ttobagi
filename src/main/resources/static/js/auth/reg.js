window.addEventListener('load', () => {
    const loginIdChkBtn = document.querySelector('.dup-login-id-btn');
    const nicknameChkBtn = document.querySelector('.dup-nickname-btn');

    const loginId = document.querySelector('.login-id');
    const password = document.querySelector('.password');
    const passwordConfirm = document.querySelector('.password-confirm');
    const name = document.querySelector('.name');
    const nickname = document.querySelector('.nickname');
    const gender = document.querySelector('.gender-radio-btn:checked');
    const birthday = document.querySelector('.birthday');
    const phone = document.querySelector('.phone');

    const submitBtn = document.querySelector('.submit-btn');

    let isLoginIdCheck = false;     // 로그인 아이디 중복 체크 여부
    let isNicknameCheck = false;    // 닉네임 중복 체크 여부

    // 로그인 아이디 중복 체크버튼 클릭 이벤트
    loginIdChkBtn.addEventListener('click', (e) => {
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
                
                loginIdChkBtn.value = '사용 가능';
                loginIdChkBtn.style.background = '#C4F0E3';
                loginIdChkBtn.style.border = '1px solid #A5F0E3';
                isLoginIdCheck = true;

                if (isDuplication) {
                    loginIdChkBtn.value = '사용 불가';
                    loginIdChkBtn.style.background = '#E08080';
                    loginIdChkBtn.style.border = '1px solid #E05B59';
                    isLoginIdCheck = false;
                } 
                
                checkForm();
            });

    });

    // 닉네임 중복 체크버튼 클릭 이벤트
    nicknameChkBtn.addEventListener('click', (e) => {
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
                
                nicknameChkBtn.value = '사용 가능';
                nicknameChkBtn.style.background = '#C4F0E3';
                nicknameChkBtn.style.border = '1px solid #A5F0E3';
                isNicknameCheck = true;
                
                if (isDuplication) {
                    nicknameChkBtn.value = '사용 불가';
                    nicknameChkBtn.style.background = '#E08080';
                    nicknameChkBtn.style.border = '1px solid #E05B59';
                    isNicknameCheck = false;
                } 

                checkForm();
            });

    });

    // 회원가입 완료 버튼 클릭 이벤트
    submitBtn.addEventListener('click', (e) => {
        // 하나라도 빈 input이 있다면 회원가입 버튼 비활성
        if (!checkForm()) {
            e.preventDefault();
            return false;
        }

        // 로그인 아이디 및 닉네임 중복체크 확인
        if (isLoginIdCheck === false || isNicknameCheck === false) {
            alert('로그인 아이디 또는 닉네임 중복체크가 필요합니다.');
            e.preventDefault();
            return false;
        }

        // 패스워드, 패스워드 확인 비교
        if (password.value !== passwordConfirm.value) {
            alert('동일한 비밀번호를 입력해 주세요.');
            e.preventDefault();
            return false;
        }

        alert('회원가입이 정상적으로 완료되었습니다.');
    });

    loginId.addEventListener('keyup', (e) => {
        checkForm();
    });

    password.addEventListener('keyup', (e) => {
        checkForm();
    });

    passwordConfirm.addEventListener('keyup', (e) => {
        checkForm();
    });

    name.addEventListener('keyup', (e) => {
        checkForm();
    });

    nickname.addEventListener('keyup', (e) => {
        checkForm();
    });

    gender.addEventListener('keyup', (e) => {
        checkForm();
    });

    birthday.addEventListener('keyup', (e) => {
        checkForm();
    });

    phone.addEventListener('keyup', (e) => {
        checkForm();
    });

    function checkForm() {
        // loginId, nickname은 isLoginIdCheck, isNicknameCheck로 대체
        const password = document.querySelector('.password').value;
        const passwordConfirm = document.querySelector('.password-confirm').value;
        const name = document.querySelector('.name').value;
        const gender = document.querySelector('.gender-radio-btn:checked').value;
        const birthday = document.querySelector('.birthday').value;
        const phone = document.querySelector('.phone').value;

        // 모든 input이 채워지면 회원가입 완료 버튼 활성화
        if (isLoginIdCheck == true && isNicknameCheck == true &&
            password != '' && passwordConfirm != '' && name != '' &&
            gender != '' && birthday != '' && phone != '') {
                submitBtn.style.opacity = '1';
                return true;
            }

        submitBtn.style.opacity = '0.6'; // 하나라도 input이 비어있으면 회원가입 완료 버튼 비활성화
        return false
    }

    
});