/* 
 첫번째 시도 : 메인컨테이너를 배열로 사용하니 시간이 너무 오래걸림
*/

/*
function solution(order) {
	const mainContainer = Array.from({ length: order.length }, (_, idx) => idx + 1);
	const subContainer = [];

	let answer = 0;
	for (let i = 0; i < order.length; i++) {
		if (takeFromContainer(mainContainer, subContainer, order[i])) {
			answer++;
		} else {
			break;
		}
	}
	return answer;
}

function takeFromContainer(mainContainer, subContainer, item) {
	if (subContainer[subContainer.length - 1] === item) {
		subContainer.pop();
		return true;
	}
	while (mainContainer.length) {
		const lastItem = mainContainer.shift();
		if (lastItem === item) {
			return true;
		}
		subContainer.push(lastItem);
	}
	return false;
}
*/

function solution(order) {
	let lastItem = 1;
	const subContainer = [];
	let answer = 0;
	for (let i = 0; i < order.length; i++) {
		if (takeFromContainer(order[i])) {
			answer++;
		} else {
			break;
		}
	}

	return answer;

	function takeFromContainer(item) {
		if (subContainer[subContainer.length - 1] === item) {
			subContainer.pop();
			return true;
		}
		while (lastItem <= order.length) {
			if (lastItem === item) {
				lastItem++;
				return true;
			}
			subContainer.push(lastItem);
			lastItem++;
		}
		return false;
	}
}
