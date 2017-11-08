package e2017.exam1;
import java.util.Arrays;
public class Example11 {

	static void printSum(int...a){
		int sum=0;

		for(int i=0;i<a.length;i++){
			sum+=a[i];
		}
		System.out.print("배열:"+a+"  ");
		System.out.println("합계:%d"+sum);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a=new int[]{21,33,17,40,5,13};

		printSum(11,13,17,20);
		printSum(a);
	}
	@Override 
	public String toString(){
		
		StringBuffer st=new StringBuffer();
		Object a = null;
		Object sum = 0;
		st.append("배열:").append(a).append("  ").append("합계:").append(sum);
		return st.toString();

	}


}
