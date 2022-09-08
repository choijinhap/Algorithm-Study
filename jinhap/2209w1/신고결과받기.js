function solution(id_list, report, k) {
	const answer = new Array(id_list.length);
	answer.fill(0);

	const reportList = {};
	id_list.map((user) => {
		reportList[user] = [];
	});

	report.map((user) => {
		const [user_id, report_id] = user.split(' ');
		if (!reportList[report_id].includes(user_id)) {
			reportList[report_id].push(user_id);
		}
	});

	for (const key in reportList) {
		if (reportList[key].length >= k) {
			reportList[key].map((user) => {
				answer[id_list.indexOf(user)] += 1;
			});
		}
	}
	return answer;
}
solution(
	['muzi', 'frodo', 'apeach', 'neo'],
	['muzi frodo', 'apeach frodo', 'frodo neo', 'muzi neo', 'apeach muzi'],
	2
);
