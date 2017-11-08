package javaprojectpractice;
import java.util.Random;
public class Example01 {

		static Random random = new Random();
		
		static int[] makeIntArray(int count){
			int[] a=new int[count];
			for(int i=0;i<count;i++){
				a[i]=random.nextInt(10000);
			}
			return a;
		}
		
		static double[] makeDoubleArray(int count){
			double[]b=new double[count];
			for(int i=0;i<count;i++){
				b[i]=random.nextDouble()+random.nextInt(100);
			}
			return b;
		}
		
		static String makeRandomString(){
			StringBuilder str=new StringBuilder();
			int size=random.nextInt(3)+3;
			for(int i=0; i<size;i++){
				int n=random.nextInt(26)+(int)'a';
				str.append((char)n);
			}
			return str.toString();
		}
		
		static String[]makeStringArray(int count){
			String[]a=new String[count];
			for(int i=0;i<count;i++){
				a[i]=makeRandomString();
			}
			return a;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length=random.nextInt(5)+5;
		int []a1=makeIntArray(length);
		double[]a2=makeDoubleArray(length);
		String[]a3=makeStringArray(length);
		
		System.out.println("        int         double        String");
		System.out.println("---------- --------------- -------------");
		
		for(int i=0;i<length;i++){
		System.out.println(a1[i]+"          "+a2[i]+"        "+a3[i]);
		}
				
	}

}
