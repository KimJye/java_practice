package lab0_2;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*±èÁöÇı
		 * ´Ù½ÃÁ¦Ãâ
		 */
		System.out.println("lab0_2:±èÁöÇı");
		Scanner input = new Scanner(System.in);
		System.out.println("10°³ÀÇ Á¤¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
		int [] arr = new int[10];
		int sum=0;
		for(int i=0;i<10;i++){
			arr[i]=input.nextInt();
			
			sum+=arr[i];
		}
		System.out.println("Æò±Õ:"+(double)sum/10);
		
		System.out.print("Æò±Õ ÀÌ»óÀÎ °ª=");
		
		for(int j=0; j<10;j++){
			if((double)arr[j]>=(double)sum/10){
				System.out.print(" "+arr[j]);
			}
		}
		
		
	}

}
