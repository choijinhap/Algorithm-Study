function solution(k, dungeons) {
	let answer = 0;
	permutation(dungeons, dungeons.length).forEach(
		(dungeon) => (answer = Math.max(check(dungeon, k), answer))
	);
	return answer;
}

function check(dungeon, k) {
	let cnt = 0;
	let restK = k;
	dungeon.forEach(([need, spend]) => {
		if (restK >= need) {
			cnt++;
			restK -= spend;
		}
	});
	return cnt;
}

function permutation(arr, selectNum) {
	if (selectNum === 1) return arr.map((v) => [v]);
	let result = [];
	arr.forEach((num, curIdx, array) => {
		const fixed = num;
		const restArr = array.filter((item, idx) => curIdx !== idx);
		const restPermutation = permutation(restArr, selectNum - 1);
		const fixedPermutation = restPermutation.map((item) => [fixed, ...item]);
		result.push(...fixedPermutation);
	});
	return result;
}
