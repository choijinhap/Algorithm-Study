import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main_2022{
	
	

     public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	double x = Double.parseDouble(st.nextToken());
    	double y = Double.parseDouble(st.nextToken());
    	double c = Double.parseDouble(st.nextToken());
    	
    	if(x < y) {
    		double temp = x;
    		x = y;
    		y = temp;
    	}
    	
    	
    	double l = 0;
    	double r = y;
 
    	while(true){
    		double d = (l+r)/2;
// 해당 d값에서의 교점에서의 높이를 알아낸다
    		double myC = getC(x,y,d);
    		
// 주어진 c값과의 차이가 0.001 미만이면 종료
    		if(Math.abs(myC - c) <= 0.001) {
    			System.out.println(d);
    			return;
    		}
    		
// 구한값이 c보다 크면 d가 좁다는 얘기
    		if(myC > c) {
    			l = d;
    		}else { // 반대면 d가 너무 크다는 얘기
    			r = d;
    		}
    	}
    	
     }
     static double getC(double x,double y,double d) {
 		double a = Math.sqrt(x*x-d*d);
 		double b = Math.sqrt(y*y-d*d);
 		return (a*b)/(a+b);
 	}
}
