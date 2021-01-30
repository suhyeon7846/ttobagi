window.addEventListener('load', (e) => {
    const modalOpenBtn = document.querySelector('.modal-open');
    const modalCloseBtn = document.querySelector('.modal-close');
    const modalSecion = document.querySelector('.modal-sec');

    const requestBtn = document.querySelector('.request-btn');

    let findBtn = document.querySelector('.find-btn');
    
    let phoneInput = document.querySelector('.input-phone');
    let requestForm = document.querySelector('.request-form');
    let noResult = document.querySelector('.no-result');

    let receiverId = 0;
    
    modalOpenBtn.addEventListener('click', () => {
        fetch(`/api/couple/list`)
            .then(response => response.json())
            .then(response => {
                console.log(response);
                modalSecion.style.display = 'flex';
                //modalSecion.style.transition = '0.5s';
            })
            .catch(err => {
                alert(`다음과 같은 회원은 커플 등록을 하실 수 없습니다.\n1. 이미 커플을 등록한 회원\n2. 상대방에게 커플을 요청하여 수락 대기중인 회원\n3. 상대방에게 커플 요청이 와서 응답을 해야하는 회원`);
            })

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

                receiverId = receiver.id;

                let tr = `
                    <tr>
                        <input type="hidden" name="id" value="${receiverId}">
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

    requestBtn.addEventListener('click', (e) => {
        e.preventDefault();
        console.log(receiverId + "에게 커플요청 전송");

        if (!confirm('커플요청은 취소가 불가능합니다. 커플요청을 하시겠습니까?'))
            return false;

        fetch(`/api/couple/list?receiverId=${receiverId}`)
            .then(response => response.json()) 
            .then(response => {

                alert('정상적으로 요청되었습니다. \n상대방의 수락여부는 마이페이지에서 확인이 가능합니다.');
                location.href = '/user/mypage';
            })
            .catch(err => {
                alert(`상대방은 커플요청을 받을 수 없는 상태입니다.\n아래와 같은 경우에는 커플요청을 받을 수 없습니다.\n1. 상대방이 이미 커플을 등록한 회원인 경우\n2. 상대방이 제 3자에게 커플을 요청하여 수락 대기중인 회원인 경우\n3. 상대방이 제 3자로부터 커플 요청이 와서 응답 대기중인 경우`);
            });

        

    });
});