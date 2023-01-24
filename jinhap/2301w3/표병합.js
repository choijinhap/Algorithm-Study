function solution(commands) {
	let answer = [];
	const table = Array.from({ length: 51 }, () => Array.from({ length: 51 }, () => null));
	const parents = Array.from({ length: 51 }, (_, a) =>
		Array.from({ length: 51 }, (_, b) => [a, b])
	);

	commands.forEach((command) => {
		operate(answer, table, parents, command);
	});
	return answer;
}
function operate(answer, table, parents, command) {
	const [operation, ...args] = command.split(' ');
	switch (operation) {
		case 'UPDATE': {
			update(table, parents, args);
			break;
		}
		case 'MERGE': {
			merge(table, parents, args);
			break;
		}
		case 'UNMERGE': {
			unmerge(table, parents, args);
			break;
		}
		case 'PRINT': {
			answer.push(print(table, args));
			break;
		}
	}
}
function update(table, parents, args) {
	if (args.length === 3) {
		const [r, c, value] = args;
		const parent = parents[r][c];
		for (let i = 0; i < 51; i++) {
			for (let j = 0; j < 51; j++) {
				if (isSame(parents[i][j], parent)) {
					table[i][j] = value;
				}
			}
		}
	} else {
		const [v1, v2] = args;
		for (let i = 0; i < 51; i++) {
			for (let j = 0; j < 51; j++) {
				if (table[i][j] !== v1) continue;
				table[i][j] = v2;
			}
		}
	}
}
function merge(table, parents, args) {
	const [r1, c1, r2, c2] = args;
	if (r1 === r2 && c1 === c2) return;
	let value = table[r1][c1] ? table[r1][c1] : table[r2][c2];
	const parent1 = find(parents, [r1, c1]);
	const parent2 = find(parents, [r2, c2]);

	if (!isSame(parent1, parent2)) {
		parents[r2][c2] = parent1;
	}
	for (let i = 0; i < 51; i++) {
		for (let j = 0; j < 51; j++) {
			if (isSame(parents[i][j], parent2)) {
				parents[i][j] = parent1;
			}
			if (isSame(parents[i][j], parent1)) {
				table[i][j] = value;
			}
		}
	}
}

function unmerge(table, parents, args) {
	const [r, c] = args;
	const value = table[r][c];
	const target = find(parents, [r, c]);

	for (let i = 0; i < 51; i++) {
		for (let j = 0; j < 51; j++) {
			if (isSame(parents[i][j], target)) {
				table[i][j] = '';
				parents[i][j] = [i, j];
			}
		}
	}

	table[r][c] = value;
}
function print(table, args) {
	const [r, c] = args;
	return table[r][c] ? table[r][c] : 'EMPTY';
}
function isSame(a, b) {
	return a.toString() === b.toString();
}
function find(parents, a) {
	const [r, c] = a;
	if (isSame(parents[r][c], [r, c])) return [r, c];
	return (parents[r][c] = find(parents, parents[r][c]));
}
