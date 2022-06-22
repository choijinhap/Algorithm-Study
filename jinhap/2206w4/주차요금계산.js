function solution(fees, records) {
	let answer = [];
	let map = [];
	records.forEach((record) => {
		const data = record.split(' ');
		let idx = map.findIndex((car) => car.num === data[1]);
		if (idx === -1) {
			map.push({ num: data[1], state: data[2], time: data[0], accTime: 0 });
		} else {
			if (data[2] === 'OUT') {
				map[idx] = {
					num: data[1],
					state: data[2],
					time: data[0],
					accTime: map[idx].accTime + getTime(map[idx].time, data[0]),
				};
			} else {
				map[idx] = {
					num: data[1],
					state: data[2],
					time: data[0],
					accTime: map[idx].accTime,
				};
			}
		}
	});
	map.sort((a, b) => a.num * 1 - b.num * 1);
	map.forEach((data) => {
		if (data.state === 'IN') {
			data.accTime += getTime(data.time, '23:59');
		}
	});

	map.forEach((data) => {
		const fee = getFee(data.accTime, fees);
		answer.push(fee);
	});

	//주차요금 구하기
	//time : 주차시간
	//fees : 주차 요금 정보
	function getFee(time, fees) {
		const [defaultTime, defaultFee, timeUnit, unitFee] = fees;
		const fee =
			time > defaultTime
				? unitFee * Math.ceil((time - defaultTime) / timeUnit) + defaultFee
				: defaultFee;
		return fee;
	}
	//시간으로 시간차 구하기
	//inTime: 입차시간
	//outTime: 출차시간
	function getTime(inTime, outTime) {
		return (
			outTime.split(':')[0] * 60 +
			outTime.split(':')[1] * 1 -
			(inTime.split(':')[0] * 60 + inTime.split(':')[1] * 1)
		);
	}

	return answer;
}
