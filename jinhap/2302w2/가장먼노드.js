/*
* 인접리스트와 플루이드 마샬로 푸니까 시간초과
*
function solution(n, edge) {
  var answer = 0;
  const dp=Array.from({length:n+1},()=>Array.from({length:n+1},()=>Number.MAX_SAFE_INTEGER));
  for(let i=0;i<dp.length;i++){
      dp[i][i]=1;
  }
  edge.forEach(([from,to])=>{
      dp[from][to]=1;
      dp[to][from]=1;
  })
  for(let k=1;k<=n;k++){
      for(let i=1;i<=n;i++){
          for(let j=1;j<=n;j++){
              dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
          }
      }
  }
  
  const max=Math.max(...dp[1].slice(1));
  return dp[1].filter(v=>v===max).length;
}
*/

// bfs로 해결
// 인접행렬로 했다가 메모리 에러
function solution(n, edge) {
	const edges = Array.from({ length: n + 1 }, () => []);
	const visited = Array.from({ length: n + 1 }, () => false);
	edge.forEach(([from, to]) => {
		edges[from].push(to);
		edges[to].push(from);
	});

	let max = 0;
	let answer = 0;

	visited[1] = true;
	bfs(1);

	function bfs(start) {
		const queue = [[start, 0]];

		while (queue.length > 0) {
			const [v, level] = queue.shift();

			if (level === max) {
				answer++;
			}
			if (level > max) {
				max = level;
				answer = 1;
			}

			for (let i = 0; i < edges[v].length; i++) {
				const nv = edges[v][i];
				if (visited[nv]) continue;
				visited[nv] = true;
				queue.push([nv, level + 1]);
			}
		}
	}
	return answer;
}
