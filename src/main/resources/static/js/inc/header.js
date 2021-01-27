window.addEventListener('load', (e) => {
    const modalOpenBtn = document.querySelector('.header-modal-open');
    const modalCloseBtn = document.querySelector('.header-modal-close');
    const modalSecion = document.querySelector('.header-modal-sec');

    const bell = document.querySelector('.bell');
    const bellNum = document.querySelector('.bell-num');
    const bellContent = document.querySelector('.bell-content');

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

});