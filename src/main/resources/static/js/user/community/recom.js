window.addEventListener("load", () => {
	const section = document.querySelector("#main");
	let type = section.querySelector(".community-type").value;
	let communityId = section.querySelector(".community-id").value;
	let sessionId = section.querySelector("input[name=sessionId]").value;

	//추천,비추천
	let recomArea = section.querySelector(".recom-area");

	recomArea.addEventListener("click", (e) => {
		if (e.target.classList.contains("like-button")) {
			let check = confirm("이 글을 추천 하시겠습니까?");
			if(check == false)
				return;

			fetch(`/api/community/recom/like?t=${type}&cid=${communityId}`)
				.then(response => response.json())
				.then(json => {
					let likeBody = section.querySelector(".like-body");
					likeBody.innerHTML = "";
					console.log(json);
					let tr = `
								<th>좋아요 수</th>
								<td>${json.recomCnt}</td>
								`;

					likeBody.insertAdjacentHTML("beforeend", tr);
				});
		}

		else if (e.target.classList.contains("hate-button")) {
			let check = confirm("이 글을 비추천 하시겠습니까?");
			if(check == false)
				return;

			fetch(`/api/community/recom/hate?t=${type}&cid=${communityId}`)
				.then(response => response.json())
				.then(json => {
					let hateBody = section.querySelector(".hateBody");
					hateBody.innerHTML = "";
					let tr = `
								<th>싫어요 수</th>
								<td>${json.negativeCnt}</td>
								`;

					hateBody.insertAdjacentHTML("beforeend", tr);
				});
		}
	});
});
