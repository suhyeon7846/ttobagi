window.addEventListener('load', (e) => {
    const modalOpenBtn = document.querySelector('.modal-open');
    const modalCloseBtn = document.querySelector('.modal-close');
    const modalSecion = document.querySelector('.modal-sec');

    const requestBtn = document.querySelector('.request-btn');

    let findBtn = document.querySelector('.find-btn');
    
    let phoneInput = document.querySelector('.input-phone');
    let requestForm = document.querySelector('.request-form');
    let noResult = document.querySelector('.no-result');
    
    modalOpenBtn.addEventListener('click', () => {
        modalSecion.style.display = 'flex';
        //modalSecion.style.transition = '0.5s';
    });

    modalCloseBtn.addEventListener('click', () => {
        modalSecion.style.display = 'none';

        requestForm.classList.add('d-none');
        noResult.classList.add('d-none');
        phoneInput.value = '';
    });
    
    findBtn.addEventListener('click', (e) => {
        let receiverPhone = phoneInput.value;
        let regExp =  /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;

        if (!regExp.test(receiverPhone)) {
            alert('휴대폰 번호를 정확히 입력해 주세요.');
            return false;
        }
        
        fetch(`/api/couple/search?rp=${receiverPhone}`)
            .then(response => response.json())
            .then(receiver => {
                // 검색 결과가 있으면 검색 결과 나타내기
                console.log(receiver);

                let tbody = document.querySelector('.tbody');
                tbody.innerHTML = '';
                noResult.classList.add('d-none');

                // 검색 결과가 없으면 검색 결과 없다고 나타내기
                if (receiver.status == 500) {
                    requestForm.classList.add('d-none');
                    noResult.classList.remove('d-none');
                    return false;
                }

                let tr = `
                    <tr>
                        <input type="hidden" name="id" value="${receiver.id}">
                        <td>${receiver.name}</td>
                        <td>${receiver.gender}</td>
                        <td>${receiver.regDate}</td></td>
                    </tr>
                `
                requestForm.classList.remove('d-none');
                tbody.insertAdjacentHTML('beforeend', tr);
            })
            .catch(err => {
                requestForm.classList.add('d-none');
                alert('본인 휴대폰 번호로는 검색할 수 없습니다.');
            });
    });

    requestBtn.addEventListener('click', () => {
        alert('정상적으로 요청되었습니다.');
    });
});


// <fmt:formatDate value="${receiver.regDate }" pattern="yyyy-MM-dd"/>