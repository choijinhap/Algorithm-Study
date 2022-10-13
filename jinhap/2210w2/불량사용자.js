function solution(user_id, banned_id) {
	const permutation = (arr, selectNum) => {
		let result = [];
		if (selectNum === 1) return arr.map((item) => [item]);

		arr.forEach((num, curIdx, array) => {
			const fixed = num;
			const restArr = array.filter((item, idx) => curIdx !== idx);
			// const restArr=array.slice(curIdx+1);
			const restPermutation = permutation(restArr, selectNum - 1);
			const fixedPermutation = restPermutation.map((item) => [fixed, ...item]);
			result.push(...fixedPermutation);
		});
		return result;
	};

	const check = (users) => {
		for (let i = 0; i < banned_id.length; i++) {
			if (users[i].length !== banned_id[i].length) return false;
			else {
				for (let j = 0; j < users[i].length; j++) {
					if (banned_id[i][j] === '*') continue;
					if (users[i][j] !== banned_id[i][j]) return false;
				}
			}
		}
		return true;
	};

	const resultSet = new Set([]);
	// const resultSet=[];
	const userSet = permutation(user_id, banned_id.length);
	userSet.forEach((users) => {
		if (check(users)) {
			resultSet.add(users.sort().join(''));
			// console.log(users)
			// resultSet.push(users);
		}
	});
	return resultSet.size;
	// console.log(userSet)
	// return resultSet.length;
}
