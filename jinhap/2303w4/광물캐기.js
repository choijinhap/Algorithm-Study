function solution(picks, minerals) {
    let [diaCnt,ironCnt,stoneCnt]=picks;
    const num=diaCnt+ironCnt+stoneCnt;
    let cnt=0;
    let sum=0;
    const arr=[];
    for(let i=0;i<minerals.length;i++){
        if(i!==0&&i%5===0){
            arr.push([sum,i/5]);
            sum=0;
            cnt=0;
        }
        if(minerals[i]==='diamond') {
            sum+=25;
        }
        if(minerals[i]==='iron') {
            sum+=5;
        }
        if(minerals[i]==='stone') {
            sum+=1;
        }
        cnt++;
    }
    if(sum!==0) {
        arr.push([sum,Math.ceil(minerals.length/5)]);
    }
    let answer=0;
    arr.sort((a,b)=>b[0]-a[0]).forEach(([cnt,idx])=>{
        if(idx>num) return;
        
        const item=diaCnt?'dia':ironCnt?'iron':'stone';
        if(item==='dia') diaCnt--;
        if(item==='iron') ironCnt--;
        if(item==='stone') {
            if(stoneCnt===0) return;
            stoneCnt--;
        }
        for(let i=(idx-1)*5;i<idx*5;i++){
            if(minerals[i]){
                if(item==='dia') answer++;
                if(item==='iron'){
                    if(minerals[i]==='diamond') answer+=5;
                    else answer+=1;
                }
                if(item==='stone'){
                    if(minerals[i]==='diamond') answer+=25;
                    else if(minerals[i]==='iron') answer+=5;
                    else answer+=1;
                    
                }
            }
        }
    })
    return answer;
}

