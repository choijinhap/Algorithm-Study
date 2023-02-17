/**
 *
 * 각 지점 사이의 거리의 최솟값 중에 가장 큰 값을 이분탐색
 *
 */
function solution(distance, rocks, n) {
	let left = 1;
	let right = distance;
	rocks.sort((a, b) => a - b);

	while (left <= right) {
		const mid = Math.floor((left + right) / 2);
		let remove = 0;
		let prev = 0;

		for (let i = 0; i < rocks.length; i++) {
			// mid : 각 지점 사이의 거리의 최솟값 중에 가장 큰 값
			// 이전 지점과의 거리가 mid보다 작으면 안되므로 제거 해야함.
			if (rocks[i] - prev < mid) {
				remove++;
			} else {
				prev = rocks[i];
			}
		}

		//제거한 지점의 개수가 n이하면 만족! 최대값을 구하기위해 left를 옮긴다
		if (remove <= n) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}

	return left - 1;
}
