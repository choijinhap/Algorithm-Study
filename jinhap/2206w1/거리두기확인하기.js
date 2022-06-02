
function solution(places) {
    const dir=[[0,1],[0,-1],[1,0],[0,1]];
    return places.map((place)=>{
        let visited=new Array(places.length).fill(0).map((place)=>new Array(place.length).fill(false));
        for(let i=0;i<places.length;i++){
            for(let j=0;j<places[i].length;j++){
                if(place[i][j]!=='P') continue;
                visited[i][j]=true;
                if(!check(i,j,0,place,visited)) return 0;
            }
        }
        return 1;
    })
    
    function check(x,y,level,place,visited){
        let queue=[[x,y,level]];
        while(queue.length>0){
            const [x,y,level]=queue.shift();
            if(level>0&&place[x][y]==='P') return false;
            dir.forEach(([dx,dy])=>{
                const nx=x+dx;
                const ny=y+dy;
                if(nx>=0&&nx<place.length&&ny>=0&&ny<place[nx].length&&!visited[nx][ny]&&place[nx][ny]!=='X'&&level<2){
                    visited[nx][ny]=true;
                    queue.push([nx,ny,level+1]);
                }
            })
        }
        return true;
    }
}

