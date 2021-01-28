window.addEventListener('load', (e) => {
    const modalOpenBtn = document.querySelector('.header-modal-open');
    const modalCloseBtn = document.querySelector('.header-modal-close');
    const modalSecion = document.querySelector('.header-modal-sec');

    const bell = document.querySelector('.bell');
    const bellNum = document.querySelector('.bell-num');
    const bellContent = document.querySelector('.bell-content');

    const okBtn = document.querySelector('.header-ok-btn');
    const noBtn = document.querySelector('.header-no-btn');

    bell.addEventListener('click', (e) => {
        bellContent.classList.toggle('d-none');
    });

    modalOpenBtn.addEventListener('click', () => {
        console.log('modal open')
        modalSecion.style.display = 'flex';
    });

    modalCloseBtn.addEventListener('click', () => {
        console.log('modal close');
        modalSecion.style.display = 'none';

        // requestForm.classList.add('d-none');
        // noResult.classList.add('d-none');
        // phoneInput.value = '';
    });

    // 커플 요청을 보내지도, 받지도 않은 사람
    // senderId, receiverId에 로그인한 id가 없을 경우
    // 1. 툴팁에 '새로운 알림이 없습니다.'

    // 커플 요청을 보낸 사람
    // ---> 1. 로그인한 id가 couple 테이블의 senderId에 있는 경우

        // 상대방이 요청을 수락한 경우
        // 1. 툴팁에 '커플 요청이 수락되었습니다.'

        // 상대방이 요청을 거절한 경우
        // 1. 툴팁에 '커플 요청이 거절되었습니다.'

        
    

    // 2번은 couple 테이블의 approvalDate가 null이면 응답x, null이 아니면 응답ok
    // ---> 2-1. receiver가 커플 요청을 응답하기 전에는 툴팁에 '상대방이 아직 응답하지 않았습니다.'

    // couple 테이블의 app
    // ---> 2-2. receiver가 커플 요청을 수락한 경우에는 툴팁에 '상대방이 커플 요청을 수락하였습니다.' (알림표시 1)
    // ---> 2-3. receiver가 커플 요청을 거절한 경우에는 툴팁에 '상대방이 커플 요청을 거절하였습니다.' (알림표시 1)

    // 커플 요청을 받은 사람
    // 1. 로그인한 id가 couple 테이블의 receiverId에 있는 경우
    // 1. 툴팁에 '커플 요청이 도착했습니다'

    // 1. 커플 요청을 수락하면 모달창 꺼져야 함
    // 2. 다시 자세히보기를 누르면 이미 처리한 요청이라고 알려줘야 한다.

    // 1. 커플 요청을 거절하면 모달창 꺼져야 함
    // 2. 다시 자세히보기를 누르면 이미 처리한 요청이라고 알려줘야 한다.

});