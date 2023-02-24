function solution(n, roads, sources, destination) {
	const edges = Array.from({ length: n + 1 }, () => []);
	const visited = Array.from({ length: n + 1 }, () => false);
	roads.forEach(([from, to]) => {
		edges[from].push(to);
		edges[to].push(from);
	});
	const answer = Array.from({ length: n + 1 }, () => 0);
	const queue = [[destination, 0]];
	visited[destination] = true;
	while (queue.length) {
		const [cur, dis] = queue.shift();
		answer[cur] = dis;
		for (let i = 0; i < edges[cur].length; i++) {
			if (!visited[edges[cur][i]]) {
				queue.push([edges[cur][i], dis + 1]);
				visited[edges[cur][i]] = true;
			}
		}
	}
	return sources.map((source) => (visited[source] ? answer[source] : -1));
}

// function solution(n, roads, sources, destination) {
//     var answer = [];
//     const edges=Array.from({length:n+1},()=>[]);
//     roads.forEach(([from,to])=>{
//         edges[from].push(to);
//         edges[to].push(from);
//     });
//     return sources.map(source=>find(source,destination));

//     function find(source,destination){
//         const queue=[[source,0]];
//         const visited=Array.from({length:n+1},()=>false);
//         while(queue.length){
//             const [cur,cnt]=queue.shift();
//             visited[cur]=true;
//             if(cur===destination) return cnt;
//             queue.push(...edges[cur].filter(next=>!visited[next]).map(next=>[next,cnt+1]));
//         }
//         return -1;
//     }
// }
