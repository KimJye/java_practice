package lab0_4;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_4: ±èÁöÇý");
		Scanner input = new Scanner(System.in);
		System.out.print("µÎ Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä: ");
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		System.out.println("ÃÖ´ñ°ª:"+findMax(num1,num2));
	}
	
	public static int findMax(int a, int b){
		int max=0;
		if(a>=b){
			max=a;
		}else{
			max=b;
		}
		return max;
	}

}
