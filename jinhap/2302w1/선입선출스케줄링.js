/**
 * 브루트포스는 역시 시간초과...
function solution(n, cores) {
	const len = cores.length;
	const stack = Array.from({ length: cores.length }, (_, idx) => idx + 1);
	let i = 1;
	while (stack.length < n) {
		cores.forEach((core, idx) => {
			if (i % core === 0) stack.push(idx + 1);
		});
		i++;
	}
	return stack[n - 1];
}

 */
function solution(n, cores) {
	const len = cores.length;

	//len개는 처음에 작업시작
	let rest = n - len;
	let left = 1;
	//제일 오래걸리는거 기준으로 최대 몇번 해야하는지 계산
	let right = (Math.max(...cores) * rest) / len;

	while (left < right) {
		const mid = (left + right) >> 1;
		let capacity = 0;

		//mid 시간에 처리할수 있는 최대 갯수
		for (const core of cores) {
			capacity += (mid / core) >> 0;
		}

		if (capacity >= rest) {
			right = mid;
		} else {
			left = mid + 1;
		}
	}
	//right는 rest개 이상을 처리할 수 있는 최솟값

	// 최소시간전에 처리한 갯수들 카운트
	for (const core of cores) {
		rest -= ((right - 1) / core) >> 0;
	}

	//최소시간에 처리가능한 코어로 처리 마지막이라면 해당 코어 번호 리턴
	for (let i = 0; i < len; i++) {
		if (right % cores[i] === 0) {
			rest -= 1;
			if (!rest) {
				return i + 1;
			}
		}
	}
}
