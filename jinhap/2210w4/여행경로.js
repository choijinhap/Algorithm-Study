function solution(tickets) {
	let answer = [];
	tickets.sort();
	function DFS(start, restTickets, visited = ['ICN']) {
		if (restTickets.length === 0) {
			answer.push(visited);
		}
		for (let i = 0; i < restTickets.length; i++) {
			const [from, to] = restTickets[i];

			if (start === from) {
				const ticket = restTickets.splice(i, 1);
				visited.push(to);
				DFS(to, restTickets, [...visited]);
				restTickets.splice(i, 0, ...ticket);
				visited.pop();
			}
		}
	}
	DFS('ICN', tickets);
	return answer[0];
}
