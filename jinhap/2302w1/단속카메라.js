function solution(routes) {
	let lastCam = -30001;
	let answer = 0;
	routes = routes.sort((routeA, routeB) => routeA[1] - routeB[1]);
	routes.forEach(([start, end]) => {
		if (lastCam >= start) {
			return;
		}
		lastCam = end;
		answer++;
	});

	return answer;
}
