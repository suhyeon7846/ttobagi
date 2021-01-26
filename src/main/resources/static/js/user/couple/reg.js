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
        console.log('modal close');
        modalSecion.style.display = 'flex';
        //modalSecion.style.transition = '0.5s';
    });

    modalCloseBtn.addEventListener('click', () => {
        console.log('modal open');
        modalSecion.style.display = 'none';
    });

    findBtn.addEventListener('click', (e) => {
        let phone = phoneInput.nodeValue;
        
        fetch(`/api/couple/search?${phone}`)
            .then(response => response.json())
            .then(json => {
                // 검색 결과가 있으면 검색 결과 나타내기
                // 검색 결과가 없으면 검색 결과 없다고 나타내기
            });
    });

    requestBtn.addEventListener('click', () => {
        alert('정상적으로 요청되었습니다.');
    });
});