function solution(bridge_length, weight, truck_weights) {
	var answer = 0;
	const queue = [];
	const loc = [];
	truck_weights.forEach((truck, idx) => {
		let sum = queue.reduce((acc, cur) => acc + cur, 0);
		if (sum + truck <= weight) {
			queue.unshift(truck);
			loc.forEach((v, i) => loc[i]++);
			loc.unshift(0);
			answer++;
		} else {
			while (sum + truck - queue.pop() > weight) {
				const dis = bridge_length - loc.pop();

				answer += dis;
				loc.forEach((v, i) => (loc[i] += dis));
				sum = queue.reduce((acc, cur) => acc + cur, 0);
			}
			const dis = bridge_length - loc.pop();
			answer += dis;
			queue.unshift(truck);
			loc.forEach((v, i) => (loc[i] += dis));
			loc.unshift(0);
		}
		if (loc[loc.length - 1] >= bridge_length) {
			queue.pop();
			loc.pop();
		}
		console.log(queue, loc, answer);
	});
	answer += bridge_length;
	return answer;
}

console.log(solution(5, 5, [1, 1, 1, 1, 1, 2, 2, 2, 2]));
