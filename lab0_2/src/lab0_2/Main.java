package lab0_2;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*������
		 * �ٽ�����
		 */
		System.out.println("lab0_2:������");
		Scanner input = new Scanner(System.in);
		System.out.println("10���� ������ �Է��ϼ���.");
		int [] arr = new int[10];
		int sum=0;
		for(int i=0;i<10;i++){
			arr[i]=input.nextInt();
			
			sum+=arr[i];
		}
		System.out.println("���:"+(double)sum/10);
		
		System.out.print("��� �̻��� ��=");
		
		for(int j=0; j<10;j++){
			if((double)arr[j]>=(double)sum/10){
				System.out.print(" "+arr[j]);
			}
		}
		
		
	}

}
