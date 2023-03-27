/**
 * map greedy
 */
function solution(weights) {
	let answer = 0;
	const map = {};
	const cal = [1, 3 / 2, 2, 4 / 3];
	const a = weights
		.sort((a, b) => b - a)
		.forEach((weight) => {
			cal.forEach((v) => {
				let s = weight * v;
				if (map[s]) answer += map[s];
			});
			if (!map[weight]) map[weight] = 1;
			else map[weight]++;
		});
	return answer;
}
