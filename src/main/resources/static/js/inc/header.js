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
        
    });

    noBtn.addEventListener('click', (e) => {

    });

});