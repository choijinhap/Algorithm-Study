function solution(board) {
  const o=[];
  const x=[];
  for(let i=0;i<3;i++){
      for(let j=0;j<3;j++){
          if(board[i][j]==='X') x.push(i*3+j+1);
          if(board[i][j]==='O') o.push(i*3+j+1);
      }
  }
  const oCnt=o.length;
  const xCnt=x.length;
  if(oCnt>xCnt+1) return 0;
  if(xCnt>oCnt) return 0;
  
  const isOFinished=isFinished(o,board);
  const isXFinished=isFinished(x,board);
  if(isOFinished&&oCnt-1!==xCnt) return 0;
  if(isXFinished&&oCnt!==xCnt) return 0;
  if(isOFinished&&isXFinished) return 0;
  return 1;
  
}
function isFinished(arr,board){
      const completedArr=[[1,2,3],[4,5,6],[7,8,9],[1,4,7],[2,5,8],[3,6,9],[1,5,9],[3,5,7]];
      for(let i=0;i<completedArr.length;i++){
          let cnt=0;
          for(let j=0;j<completedArr[i].length;j++){
              if(arr.includes(completedArr[i][j])){
                  cnt++;
              }else break;
          }
          if(cnt===3) return true;
      }
      return false;
  }
