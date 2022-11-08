function solution(s) {
  return s.split(' ').map(str=>str?str[0].toUpperCase()+str.substr(1).toLowerCase():str).join(' ');
}
