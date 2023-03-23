function solution(board) {
    let start=[];
    let goal=[];
    for(let i=0;i<board.length;i++){
        for(let j=0;j<board[i].length;j++){
            if(board[i][j]==='R'){
                start=[i,j];
            }
            if(board[i][j]==='G'){
                goal=[i,j];
            }
        }
    }
    const visited=Array.from({length:board.length},()=>Array.from({length:board[0].length},()=>false));
    const queue=[];
    queue.push([...start,0]);
    while(queue.length){
        const [x,y,time]=queue.shift();
        if(visited[x][y]) continue;
        visited[x][y]=true;
        if(x===goal[0]&&y===goal[1]) return time;
        queue.push([...slideDown(board,x,y),time+1]);
        queue.push([...slideUp(board,x,y),time+1]);
        queue.push([...slideLeft(board,x,y),time+1]);
        queue.push([...slideRight(board,x,y),time+1]);
    }
    return -1;
}

function slideRight(map,x,y){
    for(let i=y+1;i<map[x].length;i++){
        if(map[x][i]==='D') return [x,i-1];
    }
    return [x,map[x].length-1];
}
function slideLeft(map,x,y){
    for(let i=y-1;i>=0;i--){
        if(map[x][i]==='D') return [x,i+1];
    }
    return [x,0];
}
function slideUp(map,x,y){
    for(let i=x-1;i>=0;i--){
        if(map[i][y]==='D') return [i+1,y];
    }
    return [0,y];
}
function slideDown(map,x,y){
    for(let i=x+1;i<map.length;i++){
        if(map[i][y]==='D') return [i-1,y];
    }
    return [map.length-1,y];
}
