package lab0_3;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
				
		System.out.println("lab0_3: 김지혜");
		
		System.out.print("정수갯수를 입력하세요: ");
		
		int number = input.nextInt();
		
		
		System.out.print(number+"개의 정수를 입력하세요: ");

		int n =input.nextInt();
		int arr[] = new int[n];

		int max=arr[0];
		for(int i=0;i<10;i++){
			arr[i]=input.nextInt();
				}
		for(int i=1;i<10;i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		System.out.println("최댓값:"+max);
		
	}

}
