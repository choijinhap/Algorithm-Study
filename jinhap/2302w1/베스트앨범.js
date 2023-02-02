function solution(genres, plays) {
	const sum = {};
	genres.forEach((genre, idx) => {
		sum[genre] = sum[genre] ? sum[genre] + plays[idx] : plays[idx];
	});

	const tmp = {};
	return genres
		.map((genre, idx) => ({ genre, count: plays[idx], idx }))
		.sort((a, b) => {
			if (a.genre !== b.genre) return sum[b.genre] - sum[a.genre];
			if (a.count !== b.count) return b.count - a.count;
			return a.idx - b.idx;
		})
		.filter(({ genre, count, idx }) => {
			if (tmp[genre] > 1) return false;
			tmp[genre] = tmp[genre] ? tmp[genre] + 1 : 1;
			return true;
		})
		.map(({ genre, count, idx }) => idx);
}
