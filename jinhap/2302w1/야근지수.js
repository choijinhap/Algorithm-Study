function solution(n, works) {
	let max = Math.max(...works);
	works = works.sort((a, b) => b - a);
	while (max > 0 && n > 0) {
		for (let i = 0; i < works.length; i++) {
			if (works[i] === max && n > 0) {
				works[i] -= 1;
				n--;
			} else break;
		}
		max--;
	}
	return works.reduce((acc, cur) => acc + cur ** 2, 0);
}
