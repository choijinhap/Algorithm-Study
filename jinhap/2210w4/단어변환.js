function solution(begin, target, words) {
	let answer = 0;
	let queue = [];
	let visited = new Set();
	queue.push(begin);
	visited.add(begin);
	while (queue.length > 0) {
		const size = queue.length;
		for (let i = 0; i < size; i++) {
			const curWord = queue.shift();
			for (let j = 0; j < words.length; j++) {
				if (!visited.has(words[j]) && canConvert(words[j], curWord)) {
					if (words[j] === target) return ++answer;
					queue.push(words[j]);
					visited.add(words[j]);
				}
			}
		}
		answer++;
	}
	return 0;
}

function canConvert(fromWord, toWord) {
	if (fromWord.length !== toWord.length) return false;
	let cnt = 0;
	for (let i = 0; i < fromWord.length; i++) {
		if (fromWord[i] !== toWord[i]) cnt++;
		if (cnt > 1) return false;
	}
	return cnt === 1 ? true : false;
}
