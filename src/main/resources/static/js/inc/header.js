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
    });

    okBtn.addEventListener('click', (e) => {
        if (!confirm('커플 요청을 수락하시겠습니까?')) {
            e.preventDefault();
            return false;
        }

        alert('축하합니다. 또바기에서 멋진 추억을 만들어 보세요!');
    });

    noBtn.addEventListener('click', (e) => {
        if (!confirm('커플 요청을 거절하시겠습니까?')) {
            e.preventDefault();
            return false;
        }

        alert('커플 요청 거절이 정상적으로 처리되었습니다.');
    });

});