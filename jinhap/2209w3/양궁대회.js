function solution(n, info) {
	let result=Array.from({length:11},()=>0);
    let max=0;

	function find(peachScore,ryanScore,count,idx,scoreBoard) {
        if(n<count) return;
        
        // 마지막까지 쐈으면
        if(idx>10){
            const scoreDiff=ryanScore-peachScore;
            if(max<scoreDiff){
                //가장 낮은 0점 짜리를 최대한 쏜다.
                scoreBoard[10]=n-count;
                
                max=scoreDiff;
                result=scoreBoard;
            }
            return;
        }
        
        //더 쏠 수 있다면 낮은거 부터 차례로 쏜다
        if(n>count){
            let candidate=[...scoreBoard];
            candidate[10-idx]=info[10-idx]+1;
            find(peachScore,ryanScore+idx,count+info[10-idx]+1,idx+1,candidate);
        }
        
        //더 쏠 수 없는데 peach는 점수가 있다면
        if(info[10-idx]>0){
            find(peachScore+idx,ryanScore,count,idx+1,scoreBoard);
        //그냥 넘기기
        }else{
            find(peachScore,ryanScore,count,idx+1,scoreBoard)
        }
    }
    find(0,0,0,0,result);
    if(max<=0) return [-1];
    return result;
}
