const readline = require('readline');
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
const input = [];
rl.on('line', (line) => {
	input.push(line);
}).on('close', () => {
	let [W, N] = input[0].split(' ').map((v) => Number(v));
	console.log(
		input
			.slice(1)
			.map((v) => v.split(' ').map((v) => Number(v)))
			.sort((a, b) => b[1] - a[1])
			.reduce((prev, cur) => {
				if (W > cur[0]) {
					W -= cur[0];
					return prev + cur[0] * cur[1];
				} else {
					let tmp = W;
					W = 0;
					return prev + tmp * cur[1];
				}
			}, 0)
	);
});
