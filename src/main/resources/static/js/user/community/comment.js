window.addEventListener("load", () => {
	const section = document.querySelector("#main");
	let type = section.querySelector(".community-type").value;
	let communityId = section.querySelector(".community-id").value;
	let sessionId = section.querySelector("input[name=sessionId]").value;
	let comment = section.querySelector(".comment");
	let commentList = comment.querySelector(".comment-list");
	let commentRegButton = comment.querySelector(".comment-reg-button");

	//등록
	commentRegButton.addEventListener("click", (e) => {
		e.preventDefault();
		let commentText = comment.querySelector("input[name=commentText]");
		let commentTextValue = commentText.value;
		if (commentTextValue == null || commentTextValue == "") {
			alert("댓글을 입력하세요");
			return;
		}

		fetch(`/api/community/comment/insert?t=${type}&cid=${communityId}&ct=${commentTextValue}`)
			.then(response => response.json())
			.then(json => {
				commentList.innerHTML = "";
				commentText.value = "";
				for (m of json) {
					let div = `
					<div class="list"><!-- 댓글 리스트 -->
						<span class="nickname">${m.nickname}</span>
						<span class="text">${m.content}</span>
						<input name="sessionId" type="hidden" value="${sessionId}">
						<input name="commentMemId" type="hidden" value="${m.memId}">
						<button type="button" class="comment-del-button" name="commentId" value="${m.id}">삭제</button>
					</div>
				`;

					commentList.insertAdjacentHTML("beforeend", div);
				}
				
			});
	});

	//삭제
	commentList.addEventListener("click", (e) => {
		if (e.target.classList.contains("comment-del-button")) {
			let commentId = e.target.value;
			let commentMemId = e.target.previousElementSibling.value;
			console.log(`session:${sessionId}, commentMem:${commentMemId}`);
			if (sessionId != commentMemId) {
				alert("본인이 아니면 삭제할 수 없습니다.");
				return;
			}

			fetch(`/api/community/comment/del?t=${type}&cmid=${commentId}&cid=${communityId}`)
				.then(response => response.json())
				.then(json => {
					commentList.innerHTML = "";
					for (m of json) {
						let div = `
							<div class="list"><!-- 댓글 리스트 -->
								<span class="nickname">${m.nickname}</span>
								<span class="text">${m.content}</span>
								<input name="sessionId" type="hidden" value="${sessionId}">
								<input name="commentMemId" type="hidden" value="${m.memId}">
								<button type="button" class="comment-del-button" name="commentId" value="${m.id}">삭제</button>
							</div>
						`;

						commentList.insertAdjacentHTML("beforeend", div);
					}
				});
		}
	});
});
