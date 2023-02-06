function solution(n, costs) {
  let answer = 0;
  const arr=[];
  costs.sort((a,b)=>a[2]-b[2]);
  const parents=make(n);
  costs.forEach(cost=>{
     if(union(parents,cost[0],cost[1])){
         answer+=cost[2];
     }
  })
  return answer;
}

function make(n){
  return Array.from({length:n},(a,b)=>b);
}

function find(parents,a){
  if(parents[a]===a) return a;
  return parents[a]=find(parents,parents[a]);
}

function union(parents,a,b){
  const rootA=find(parents,a);
  const rootB=find(parents,b);
  if(rootA===rootB) return false;
  parents[rootA]=rootB;
  return true;
}
