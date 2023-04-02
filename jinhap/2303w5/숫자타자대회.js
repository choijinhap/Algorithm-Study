function solution(numbers) {
	const weights = Array.from({ length: 10 }, () => Array.from({ length: 10 }, () => 0));
	const dp = Array.from({ length: numbers.length + 1 }, () =>
		Array.from({ length: 10 }, () => Array.from({ length: 10 }, () => Infinity))
	);
	dp[0][4][6] = 0;
	for (let idx = 0; idx < numbers.length; idx++) {
		const prevDp = dp[idx];
		const curDp = dp[idx + 1];
		const num = Number(numbers[idx]);
		for (let i = 0; i < 10; i++) {
			for (let j = 0; j < 10; j++) {
				if (i === j || prevDp[i][j] === Infinity) continue;
				const prevValue = prevDp[i][j];

				if (curDp[num][j] > prevValue + getCost(i, num)) {
					curDp[num][j] = prevValue + getCost(i, num);
				}
				if (curDp[i][num] > prevValue + getCost(num, j)) {
					curDp[i][num] = prevValue + getCost(num, j);
				}
			}
		}
	}
	return Math.min(...dp[numbers.length].flat().flat());

	function getCost(from, to) {
		if (from === to) return 1;
		const ret = calculate(from, to);
		return ret === 0 ? 1 : ret;
	}

	function calculate(from, to) {
		if (weights[from][to]) return weights[from][to];
		if (weights[to][from]) return weights[to][from];
		if (from === to) return 0;
		if (to === 0) return (weights[to][from] = calculate(to, from));
		if (from === 0) {
			if (to % 3 === 2) {
				return (weights[from][to] = 2 + calculate(8, to));
			} else if (to % 3 === 1) return (weights[from][to] = 3 + calculate(7, to));
			else return (weights[from][to] = 3 + calculate(9, to));
		}
		if (from % 3 === to % 3) {
			return (weights[from][to] =
				from > to ? 2 + calculate(from - 3, to) : 2 + calculate(from + 3, to));
		} else {
			if (Math.floor((from - 1) / 3) === Math.floor((to - 1) / 3)) {
				return (weights[from][to] =
					from > to ? 2 + calculate(from - 1, to) : 2 + calculate(from + 1, to));
			}
			if (Math.floor((from - 1) / 3) > Math.floor((to - 1) / 3)) {
				return (weights[from][to] =
					(from - 1) % 3 > (to - 1) % 3
						? 3 + calculate(from - 4, to)
						: 3 + calculate(from - 2, to));
			}
			return (weights[from][to] =
				(from - 1) % 3 > (to - 1) % 3 ? 3 + calculate(from + 2, to) : 3 + calculate(from + 4, to));
		}
	}
}
