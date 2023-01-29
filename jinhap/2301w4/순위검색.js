function solution(info, query) {
	const infos = getInfos(info);
	return query.map((query) => getResult(query, infos));
}
function binarySearch(arr, score) {
	let left = 0;
	let right = arr.length - 1;
	let mid = Math.floor((left + right) / 2);
	while (left <= right) {
		if (arr[mid] === score) {
			while (mid > 0 && arr[mid - 1] === score) {
				mid--;
			}
			return mid;
		}
		if (arr[mid] < score) left = mid + 1;
		else right = mid - 1;

		mid = Math.floor((left + right) / 2);
	}
	return mid + 1;
}

function getResult(query, infos) {
	const q = query.split(/ and | |-/i).filter((v) => v !== '');
	const score = parseInt(q.pop());
	const keys = Object.keys(infos);
	return keys
		.filter((key) => q.every((v) => key.includes(v)))
		.reduce((acc, key) => acc + infos[key].length - binarySearch(infos[key], score), 0);
}

function getInfos(info) {
	const infos = {};
	info.forEach((infoString) => {
		const i = infoString.split(' ');
		const score = parseInt(i.pop());
		const key = i.join('');
		if (infos[key]) infos[key].push(score);
		else infos[key] = [score];
	});
	for (const key in infos) {
		infos[key].sort((a, b) => a - b);
	}
	return infos;
}
