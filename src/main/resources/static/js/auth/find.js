window.addEventListener('load', (e) => {
    const findBtn = document.querySelector('.find-btn');

    findBtn.addEventListener('click', (e) => {
        const loginId = document.querySelector('.login-id').value;
        const email = document.querySelector('.email').value;
		const center = document.querySelector('.center');

        console.log(loginId);
        console.log(email);

        fetch(`/auth/pwd/find?loginId=${loginId}&email=${email}`)
            .then(response => response.json())
            .then(response => {
				console.log(response);
				fetch(`/auth/emailAuth?email=${email}`)
				.then(response=>response.json())
				.then(response=>{
					
					let html = `<div class="input-container">
	                    <div>인증번호</div>
	                    <input type="text" class="info auth" name="auth" placeholder="6자리 인증번호" required><input class="btnAuth" type="button" value="인증">
	                </div>`;
					center.insertAdjacentHTML("afterend",html);
					let btnAuth = document.querySelector('.btnAuth');
					btnAuth.addEventListener("click",()=>{
						let authNum = response;
						let input = document.querySelector('.auth').value;
						
						if(input == authNum){
			                location.href = `/auth/pwd/change?loginId=${loginId}`;
						}
						else{
							alert("인증번호가 틀렸습니다.");
						}
					});
					console.log(response);
				});
            })
            .catch(err => {
                alert('아이디 또는 휴대폰 번호를 확인해 주세요.');
            });
    });
});