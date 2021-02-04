window.addEventListener('load', (e) => {
    const changeBtn = document.querySelector('.change-btn');

    changeBtn.addEventListener('click', (e) => {
        const password = document.querySelector('.password').value;
        const passwordConfirm = document.querySelector('.password-confirm').value;

        if (password == '' || passwordConfirm == '') {
            alert('새로운 비밀번호를 입력해 주세요.');
            e.preventDefault();
            return false;
        }

        if (password != passwordConfirm) {
            alert('동일한 비밀번호를 입력해 주세요.');
            e.preventDefault();
            return false;
        }

        alert('비밀번호가 정상적으로 수정되었습니다.');
        //window.close(); 이거끄면 비밀번호가 변경되기 전에 창이 꺼져버림
    });
});