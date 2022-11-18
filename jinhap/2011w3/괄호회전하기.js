function solution(s) {
	let answer = 0;
	let str = s;
	for (let i = 0; i < s.length; i++) {
		if (check(str)) {
			answer++;
		}
		str = str.substring(1, str.length) + str[0];
	}
	return answer;
}
function check(str) {
	const stack = [];
	for (let i = 0; i < str.length; i++) {
		if (str[i] === '(' || str[i] === '[' || str[i] === '{') {
			stack.push(str[i]);
		} else {
			if (str[i] === ']' && stack.pop() === '[') {
				continue;
			} else if (str[i] === '}' && stack.pop() === '{') {
				continue;
			} else if (str[i] === ')' && stack.pop() === '(') {
				continue;
			}
			return false;
		}
	}
	if (stack.length > 0) return false;
	return true;
}
