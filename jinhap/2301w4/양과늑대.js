function solution(info, edges) {
	let answer = 0;
	let edgeList = Array.from({ length: info.length }, () => []);
	edges.forEach(([from, to]) => {
		edgeList[from].push(to);
	});
	dfs(0, 0, 0, [0]);
	return answer;

	function dfs(node, sheep, wolf, possibleNodes) {
		const newPossibleNodes = [...possibleNodes];

		info[node] ? wolf++ : sheep++;

		if (wolf === sheep) return;

		if (sheep > answer) answer = sheep;

		newPossibleNodes.push(...edgeList[node]);
		newPossibleNodes.splice(
			newPossibleNodes.findIndex((v) => v === node),
			1
		);
		newPossibleNodes.forEach((newNode) => {
			dfs(newNode, sheep, wolf, newPossibleNodes);
		});
	}
}
