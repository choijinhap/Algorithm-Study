function solution(storey) {
	let answer = Math.MAX_SAFE_INTEGER;
	dfs(storey, 0);
	return answer;

	function dfs(num, counter) {
		if (counter >= answer) return;

		if (num === 0) {
			answer = counter;
			return;
		}

		const lastNum = num % 10;
		const restNum = Math.floor(num / 10);

		//내려갈 경우
		dfs(restNum, counter + lastNum);
		//올라갈 경우
		dfs(restNum + 1, counter + 10 - lastNum);
	}
}
