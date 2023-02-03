/*

모든 단어 앞에서 부터 찾아가면 시간초과

function solution(gems) {
	let answer = [1, gems.length];
	const map = {};
	gems.forEach((gem, idx) => {
		if (map[gem]) map[gem].push(idx + 1);
		else map[gem] = [idx + 1];
	});
	const arr = [];
	for (const v in map) {
		arr.push(map[v]);
	}
	const tmp = Array.from({ length: Object.keys(map).length }, () => 0);

	while (true) {
		const min = Math.min(...tmp.map((v, i) => arr[i][v]));
		const max = Math.max(...tmp.map((v, i) => arr[i][v]));
		if (max - min < answer[1] - answer[0]) answer = [min, max];
		const nextIdx = tmp.findIndex((v, i) => arr[i][v] === min);
		if (nextIdx >= 0 && tmp[nextIdx] === arr[nextIdx].length - 1) break;
		tmp[nextIdx]++;
	}
	return answer;
}
*/

/**
 * 슬라이딩 윈도우 활용하여 풀이
 */
function solution(gems) {
	const map = {};
	gems.forEach((gem) => {
		if (!map[gem]) map[gem] = 0;
	});
	const kind = Object.keys(map).length;

	let left = 0;
	let right = 0;
	let size = 1;
	map[gems[0]] = 1;
	let answer = [1, gems.length];
	while (right < gems.length) {
		if (size !== kind) {
			right++;
			if (map[gems[right]]) map[gems[right]] += 1;
			else {
				size++;
				map[gems[right]] += 1;
			}
		} else {
			if (size === kind && right - left < answer[1] - answer[0]) answer = [left + 1, right + 1];
			map[gems[left]] -= 1;
			if (map[gems[left]] === 0) size--;
			left++;
		}
	}
	return answer;
}
