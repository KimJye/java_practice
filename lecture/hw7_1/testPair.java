package hw7_1;
/*
 * 2017/11/01
 * ������
 * ���� ��ȣ �˻�
 */
import java.util.Scanner;
public class testPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw7_1:������");

		Scanner input =new Scanner(System.in);

		Pair pair = new Pair();//Ŭ���� ��ü ����

		String exp = null;

		System.out.print("��ȣ�� �Է��ϼ���: ");
		exp=input.nextLine();

		if(pair.testPair(exp)){
			System.out.println("������ �ùٸ�(��ȣ�� ���� ��ġ)");
		}else{
			System.out.println("������ �ùٸ��� ����(��ȣ�� ���� ����ġ)");
		}


	}
}
