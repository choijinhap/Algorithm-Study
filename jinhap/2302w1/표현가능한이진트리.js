function solution(numbers) {
	return numbers.map((number) => {
		let binary = number.toString(2);
		const padBinary = pad(binary);
		if (isAvailable(padBinary)) return 1;
		return 0;
	});
}

function pad(binary) {
	const height = getNodeNumber(binary.length);

	while (binary.length < height) {
		binary = '0' + binary;
	}
	return binary;
}

function getNodeNumber(number) {
	let i = 1;
	let max = 2 ** i - 1;
	while (max < number) {
		i++;
		max = 2 ** i - 1;
	}
	return max;
}

function isAvailable(padBinary) {
	if (padBinary.length === 1) return true;
	const mid = (padBinary.length / 2) >> 0;
	const left = padBinary.slice(0, mid);
	const right = padBinary.slice(mid + 1);
	if (padBinary[mid] === '0') {
		if (left.includes('1') || right.includes('1')) return false;
	}
	return isAvailable(left) && isAvailable(right);
}
