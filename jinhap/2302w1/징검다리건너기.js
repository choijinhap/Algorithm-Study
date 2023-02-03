/*
function solution(stones, k) {
  var answer = 0;
  while(true){
      let skip=0;
      for(let i=0;i<stones.length;i++){
          if(stones[i]) {
              stones[i]-=1;
              skip=0;
          }else{
              if(skip<k-1) {
                  skip++;
              }else{
                  return answer;
              }
          }
      }
      answer++;
  }
  return answer;
}
*/

//이분 탐색으로 해결
function solution(stones, k) {
	let left = 0;
	let right = 200000000;

	while (left <= right) {
		const mid = ((left + right) / 2) >> 0;

		if (check(mid)) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}
	//최종적으로 right === left-1
	return right;

	function check(num) {
		let skip = 0;
		for (let i = 0; i < stones.length; i++) {
			skip = stones[i] < num ? skip + 1 : 0;
			if (skip === k) {
				return false;
			}
		}
		return true;
	}
}
