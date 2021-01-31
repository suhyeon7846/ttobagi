window.addEventListener('load', (e) => {
    const memberInfoEditBtn = document.querySelector('.member-info-edit-btn');
    const coupleInfoDeleteBtn = document.querySelector('.couple-info-delete-btn');
    const loveStartDateEditBtn = document.querySelector('.love-start-date-edit-btn');

    memberInfoEditBtn.addEventListener('click', (e) => {
        const password = document.querySelector('.password').value;
        const passwordConfirm = document.querySelector('.password-confirm').value;

        if (password == '' || passwordConfirm == '') {
            alert('수정할 비밀번호를 입력해 주세요.');
            e.preventDefault();
            return false;
        }

        if (password !== passwordConfirm) {
            alert('동일한 비밀번호를 입력해 주세요.');
            e.preventDefault();
            return false;
        }

        if (!confirm('회원 정보를 수정하시겠습니까?')) {
            e.preventDefault();
            return false;
        }

        alert('회원 정보가 정상적으로 수정되었습니다.');
    });

    coupleInfoDeleteBtn.addEventListener('click', (e) => {
        if (!confirm('커플을 해제하면 데이터 복구가 불가능하며 일부 서비스 이용이 제한됩니다. \n정말 커플을 해제하시겠습니까?')) {
            e.preventDefault();
            return false;
        }

        alert('커플 해제가 정상적으로 처리되었습니다.');
    });

    loveStartDateEditBtn.addEventListener('click', (e) => {
        const loveStartDate = document.querySelector('.love-start-date').value;

        if (loveStartDate == '') {
            alert('연애 시작일을 설정해 주세요.');
            e.preventDefault();
            return false;
        }

        if (!confirm('연애 시작일을 설정하시겠습니까?')) {
            e.preventDefault();
            return false;
        }

        alert('연애 시작일이 정상적으로 설정되었습니다.');
    });
});