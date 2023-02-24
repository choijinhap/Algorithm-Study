function solution(play_time, adv_time, logs) {
	var answer = '';
	const arr = Array.from({ length: timeToSec(play_time) + 2 }, () => 0);
	logs.forEach((time) => {
		const [startTime, endTime] = time.split('-');
		arr[timeToSec(startTime)] += 1;
		arr[timeToSec(endTime)] -= 1;
	});
	let sum = 0;
	for (let i = 0; i < arr.length; i++) {
		sum += arr[i];
		arr[i] = sum;
	}

	let max = 0;
	let maxIdx = 0;
	sum = 0;
	const duration = timeToSec(adv_time);
	for (let i = 0; i < duration - 1; i++) {
		max += arr[i];
		sum += arr[i];
	}
	for (let i = 1; i < arr.length - duration; i++) {
		sum -= arr[i - 1];
		sum += arr[i + duration - 1];

		if (sum > max) {
			max = sum;
			maxIdx = i;
		}
	}

	return secToTime(maxIdx);
}
function timeToSec(time) {
	const [hour, min, sec] = time.split(':').map(Number);
	return hour * 60 * 60 + min * 60 + sec;
}
function secToTime(sec) {
	const h = Math.floor(sec / (60 * 60));
	const m = Math.floor((sec - h * 60 * 60) / 60);
	const s = sec - h * 60 * 60 - m * 60;
	return `${pad(h)}:${pad(m)}:${pad(s)}`;
}
function pad(num) {
	return String(num).padStart(2, '0');
}
