package lab0_6;
import java.util.*;
/*
 * Ŭ���� �ۼ� ����
 * ������
 */
public class MyPairTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_6: ������");
		Scanner input = new Scanner(System.in);
		
		System.out.print("2���� ������ �Է��ϼ���:");
		int a= input.nextInt();
		int b= input.nextInt();
		
		MyPair pair = new MyPair(a,b); //MyPair ��ü ����, �Ű������� �ѱ�
		
		System.out.println(pair.toString());
		System.out.println("��="+pair.sum());
		System.out.println("���="+pair.average());
		
		
		pair.swap();
		

		System.out.println(pair.toString());
		System.out.println("��="+pair.sum());
		System.out.println("���="+pair.average());
		
	}

}
