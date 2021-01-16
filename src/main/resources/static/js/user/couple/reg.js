window.addEventListener('load', (e) => {
    const modalOpenBtn = document.querySelector('.modal-open');
    const modalCloseBtn = document.querySelector('.modal-close');
    const modalSecion = document.querySelector('.modal-sec');

    const requestBtn = document.querySelector('.request-btn');
    
    modalOpenBtn.addEventListener('click', () => {
        console.log('modal close');
        modalSecion.style.display = 'flex';
        //modalSecion.style.transition = '0.5s';
    });

    modalCloseBtn.addEventListener('click', () => {
        console.log('modal open');
        modalSecion.style.display = 'none';
    });

    requestBtn.addEventListener('click', () => {
        alert('정상적으로 요청되었습니다.');
    });
});