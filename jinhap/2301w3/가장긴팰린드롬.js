function solution(s)
{
    let answer = 1;
    const dp=Array.from({length:s.length},()=>Array.from({length:s.length},()=>false));
    for(let i=0;i<dp.length;i++){
        dp[i][i]=true;
    }
    for(let i=0;i<s.length;i++){
        if(s[i]===s[i+1]){
            dp[i][i+1]=true;
            answer=2;
        }
    }
    
    for(let i=3;i<=s.length;i++){
        for(let start=0;start<=s.length-i;start++){
            const end=start+i-1;
            if(s[start]===s[end]&&dp[start+1][end-1]){
                dp[start][end]=true;
                answer = Math.max(answer, i);
            }
        }
    }
    return answer;
}
