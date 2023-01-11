/*
  map이용해 전부 다 찾으면 시간초과
  
  function solution(topping) {
    var answer = 0;
    const aToppingMap = {};
    const bToppingMap = {};
    topping.slice(0, 1).forEach((topping) => {
      addMap(aToppingMap, topping);
    });
    topping.slice(1).forEach((topping) => {
      addMap(bToppingMap, topping);
    });
    if (getNumOfToppingKind(aToppingMap) === getNumOfToppingKind(bToppingMap)) answer++;
    for (let i = 1; i < topping.length; i++) {
      addMap(aToppingMap, topping[i]);
      subMap(bToppingMap, topping[i]);
      if (getNumOfToppingKind(aToppingMap) === getNumOfToppingKind(bToppingMap)) answer++;
    }
    return answer;
  }
  function getNumOfToppingKind(map) {
    let num = 0;
    Object.entries(map).forEach(([key, value]) => {
      if (value) num++;
    });
    return num;
  }
  function addMap(map, topping) {
    if (map.hasOwnProperty(topping)) {
      map[topping]++;
    } else {
      map[topping] = 1;
    }
  }
  function subMap(map, topping) {
    map[topping]--;
  }
*/

function solution(topping) {
	const a = Array.from({ length: 10001 }, () => 0);
	const b = Array.from({ length: 10001 }, () => 0);
	let aCnt = 0;
	let bCnt = 0;
	let answer = 0;

	topping.forEach((kind) => {
		if (b[kind] === 0) bCnt++;
		b[kind]++;
	});

	topping.forEach((kind) => {
		a[kind]++;
		if (a[kind] === 1) aCnt++;
		b[kind]--;
		if (b[kind] === 0) bCnt--;
		if (aCnt === bCnt) answer++;
	});

	return answer;
}
