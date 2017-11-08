package lab0_6;
import java.util.*;
/*
 * 클래스 작성 연습
 * 김지혜
 */
public class MyPairTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_6: 김지혜");
		Scanner input = new Scanner(System.in);
		
		System.out.print("2개의 정수를 입력하세요:");
		int a= input.nextInt();
		int b= input.nextInt();
		
		MyPair pair = new MyPair(a,b); //MyPair 객체 생성, 매개변수도 넘김
		
		System.out.println(pair.toString());
		System.out.println("합="+pair.sum());
		System.out.println("평균="+pair.average());
		
		
		pair.swap();
		

		System.out.println(pair.toString());
		System.out.println("합="+pair.sum());
		System.out.println("평균="+pair.average());
		
	}

}
