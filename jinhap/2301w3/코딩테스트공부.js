/**
 * 완전탐색은 효율성에서 시간초과...
 * function solution(alp, cop, problems) {
    let answer = Infinity;
    let max_alp=0,max_cop=0;
    problems.forEach(([alp_req,cop_req,alp_rwd,cop_rwd,cost])=>{
        max_alp=Math.max(max_alp,alp_req);
        max_cop=Math.max(max_cop,cop_req);
    });
    
    dfs(alp,cop,0);
    return answer;
    
    function dfs(alp,cop,cost){
        if(cost>answer) return;
        if(alp>=max_alp&&cop>=max_cop){
            answer=Math.min(cost,answer);
            return;
        }
        if(alp<max_alp){
            dfs(alp+1,cop,cost+1);
        }
        if(cop<max_cop){
            dfs(alp,cop+1,cost+1);
        }
        problems.forEach(([alp_req,cop_req,alp_rwd,cop_rwd,pcost])=>{
        if(alp>=alp_req&&cop>=cop_req&&((alp<max_alp&&alp_rwd)||(cop<max_cop&&cop_rwd))) 
            dfs(alp+alp_rwd,cop+cop_rwd,cost+pcost);
    });
    }
}
 */

function solution(alp, cop, problems) {
	const dp = Array.from({ length: 151 }, () => Array.from({ length: 151 }, () => Infinity));
	dp[alp][cop] = 0;
	let max_alp = alp,
		max_cop = cop;
	problems.forEach(([alp_req, cop_req, alp_rwd, cop_rwd, cost]) => {
		max_alp = Math.max(max_alp, alp_req);
		max_cop = Math.max(max_cop, cop_req);
	});
	for (let i = alp; i <= max_alp; i++) {
		for (let j = cop; j <= max_cop; j++) {
			if (i + 1 <= max_alp) dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
			if (j + 1 <= max_cop) dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
			problems.forEach(([alp_req, cop_req, alp_rwd, cop_rwd, cost]) => {
				const targetAlp = i + alp_rwd > max_alp ? max_alp : i + alp_rwd;
				const targetCop = j + cop_rwd > max_cop ? max_cop : j + cop_rwd;
				if (i >= alp_req && j >= cop_req)
					dp[targetAlp][targetCop] = Math.min(dp[targetAlp][targetCop], dp[i][j] + cost);
			});
		}
	}

	return dp[max_alp][max_cop];
}
