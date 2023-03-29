function solution(n, m, x, y, queries) {
    let xs=x;
    let xe=x;
    let ys=y;
    let ye=y;
    const reverse=queries.reverse()
    for(let i=0;i<reverse.length;i++){
        const [command,dx]=reverse[i];
        
        if(command===0){
            if(ys>0) 
                ys+=dx;
            ye=Math.min(ye+dx,m-1);
        }
        if(command===1){
            if(ye<m-1)
                ye-=dx;
            ys=Math.max(ys-dx,0);
        }
        if(command===2){
            if(xs>0) 
                xs+=dx;
            xe=Math.min(xe+dx,n-1);
        }
        if(command===3){
           if(xe<n-1) 
               xe-=dx;
            xs=Math.max(xs-dx,0);
        }
        if (xs > n-1 || xe < 0 || ys > m-1 || ye < 0) return 0;
    }
    
    return (BigInt(xe-xs+1) * BigInt(ye-ys+1));
}
