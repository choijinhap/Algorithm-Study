/**
 * 이진 트리, binary tree
 */
function solution(nodeinfo) {
	const preArr = [];
	const postArr = [];
	const arr = nodeinfo
		.map((info, idx) => [...info, idx + 1])
		.sort((a, b) => (b[1] - a[1] === 0 ? a[0] - b[0] : b[1] - a[1]));

	const tree = new BinaryTree(arr[0][2], arr[0][0]);
	for (let i = 1; i < arr.length; i++) {
		tree.insert(arr[i][2], arr[i][0]);
	}

	preorder(tree);
	postorder(tree);

	function preorder(tree) {
		if (tree !== null) {
			preArr.push(tree.value);
			preorder(tree.left);
			preorder(tree.right);
		}
	}
	function postorder(tree) {
		if (tree !== null) {
			postorder(tree.left);
			postorder(tree.right);
			postArr.push(tree.value);
		}
	}
	return [preArr, postArr];
}

class BinaryTree {
	constructor(value, x) {
		this.value = value;
		this.x = x;
		this.left = null;
		this.right = null;
	}
	insert(value, x) {
		this.x > x ? this.toLeft(value, x) : this.toRight(value, x);
	}
	toLeft(value, x) {
		this.left === null ? (this.left = new BinaryTree(value, x)) : this.left.insert(value, x);
	}
	toRight(value, x) {
		this.right === null ? (this.right = new BinaryTree(value, x)) : this.right.insert(value, x);
	}
}
