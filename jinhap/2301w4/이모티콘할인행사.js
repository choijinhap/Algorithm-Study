function solution(users, emoticons) {
	let answer = [0, 0];
	//emoticon의 가격을 모두 10 20 30 40 할인해보면서 가입자, 판매액 확인?
	dfs(
		0,
		emoticons.map((emoticon, idx) => [10, emoticon])
	);
	return answer;

	function dfs(start, emoticons) {
		if (start >= emoticons.length) return;
		for (let j = 1; j <= 4; j++) {
			emoticons[start][0] = j * 10;
			dfs(start + 1, emoticons);
			const [joinCnt, total] = calc(users, emoticons);
			if (joinCnt >= answer[0]) {
				if (total >= answer[1]) {
					answer = [joinCnt, total];
				}
				if (joinCnt > answer[0]) {
					answer = [joinCnt, total];
				}
			}
		}
	}
}

function calc(users, emoticons) {
	let joinCnt = 0;
	let total = 0;
	users.forEach((user) => {
		const [rat, max] = user;
		let sum = 0;
		emoticons.forEach((emoticon) => {
			const [discount, price] = emoticon;
			if (discount >= rat) sum += (price * (100 - discount)) / 100;
		});
		if (sum >= max) joinCnt++;
		else total += sum;
	});
	return [joinCnt, total];
}
