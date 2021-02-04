window.addEventListener('load', (e) => {
    const findBtn = document.querySelector('.find-btn');

    findBtn.addEventListener('click', (e) => {
        const loginId = document.querySelector('.login-id').value;
        const phone = document.querySelector('.phone').value;

        console.log(loginId);
        console.log(phone);

        fetch(`/auth/pwd/find?loginId=${loginId}&phone=${phone}`)
            .then(response => response.json())
            .then(response => {
                location.href = `/auth/pwd/change?loginId=${loginId}`;
            })
            .catch(err => {
                alert('아이디 또는 휴대폰 번호를 확인해 주세요.');
            });
    });
});