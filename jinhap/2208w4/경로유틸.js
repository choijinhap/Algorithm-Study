function solution(paths) {
	let answer = '';
	paths.forEach((path) => (answer += normalizePath(path)));
	function normalizePath(path) {
		return path
			.split('/')
			.filter((name) => name !== '')
			.reduce((prev, cur, _, arr) => {
				return prev + '/' + cur;
			}, '');
	}
	function getPath(path) {
		const calculatedPath = path
			.split('/')
			.filter((name) => name !== '')
			.reduce((prev, cur, _, arr) => {
				if (cur === '.') {
					return prev;
				} else if (cur === '..') {
					const prevPath = prev.split('/');
					return prevPath.slice(1, prevPath.length - 1).join('/');
				} else if (cur === '...') {
					const prevPath = prev.split('/');
					return prevPath.slice(1, prevPath.length - 2).join('/');
				} else {
					return prev + '/' + cur;
				}
			}, '');
		return calculatedPath === '' ? '/' : calculatedPath;
	}
	answer = getPath(answer);
	console.log(answer);
	return answer;
}

solution(['/foo', '..']);
