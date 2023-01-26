function solution(survey, choices) {
	let answer = '';
	const score = {
		R: 0,
		T: 0,
		C: 0,
		F: 0,
		J: 0,
		M: 0,
		A: 0,
		N: 0,
	};
	survey.forEach((question, idx) => {
		giveScore(score, question, choices[idx]);
	});
	answer = checkMbti(score);
	return answer;
}
function checkMbti(score) {
	let mbti = '';
	const keys = Object.keys(score);
	for (let i = 0; i < keys.length; i += 2) {
		const leftType = score[keys[i]];
		const rightType = score[keys[i + 1]];
		if (leftType >= rightType) {
			mbti += keys[i];
		} else {
			mbti += keys[i + 1];
		}
	}
	return mbti;
}
function giveScore(score, question, choice) {
	if (choice < 4) {
		score[question[0]] += 4 - choice;
	} else if (choice > 4) {
		score[question[1]] += choice - 4;
	}
	return;
}
