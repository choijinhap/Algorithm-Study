/**
 * 처음 시도한 방법 , 모든 순열을 구해서 k번쨰 값 리턴 시간 초과...
 * function solution(n, k) {
    var answer = [];
    const arr=Array.from({length:n},(a,b)=>b+1);
    answer=combination(arr,n)[k-1]
    return answer;
}

function combination(arr,r){
    if(r===1) return arr.map(el=>[el]);
    let ret=[];
    arr.forEach((el,idx)=>{
        const restArr=[...arr.slice(0,idx),...arr.slice(idx+1)];
        const restCombi=combination(restArr,r-1);
        restCombi.forEach(combi=>{
            ret.push([el,...combi])
        })
    })
    return ret;
}
 */
function solution(n, k) {
	const answer = [];
	const arr = Array.from({ length: n }, (a, b) => b + 1);
	let K = k - 1;
	while (arr.length > 0) {
		const facto = factorial(n - 1);
		let idx = parseInt(K / facto);
		answer.push(...arr.splice(idx, 1));
		K %= facto;
		n -= 1;
	}
	return answer;
}

function factorial(n) {
	if (n === 1 || n === 0) return 1;
	return n * factorial(n - 1);
}
