// map 재귀함수 최적화
function solution(k, room_number) {
	const rooms = new Map();
	return room_number.map((num) => findRoom(rooms, num));
}
function findRoom(rooms, num) {
	if (!rooms.has(num)) {
		rooms.set(num, num + 1);
		return num;
	}
	const room = findRoom(rooms, rooms.get(num));
	rooms.set(num, room + 1);
	return room;
}
