package lab7_2;
import java.util.Scanner;
/*
 * 2017/10/14
 * ������
 * ���� �ڷᱸ�� ���� ��������
 */
public class MyLinkedStackTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.out.println("lab7_2: ������");
		MyLinkedStack s = new MyLinkedStack();
		Scanner input =new Scanner(System.in);
		System.out.println("�޴� ��ȣ�� �Է��ϼ���.");
		int menu = 0;
		int item = 0;
		do {
			System.out.print("1:���� 2:���� 3:��ȸ 4:��ü���� 5.���� --->");
			menu = input.nextInt();
			switch(menu) {
			case 1:
				System.out.println("���� �����մϴ�.");
				System.out.print("�����ϴ� ��: ");
				item=input.nextInt();
				s.push(item);
				break;
			case 2:
				System.out.println("���� �����մϴ�.");
				System.out.println("������ ��:"+ s.pop());

				break;
			case 3:
				System.out.println("top�� ���Ұ��� ��ȸ�մϴ�.");
				System.out.println("��ȸ�� ���� = " + s.peek());
				break;
			case 4:
				System.out.println("��ü ������ �����մϴ�.");
				for(int i=0;i<=s.stackSize;i++) {
					System.out.println(s.pop());
				}
				System.out.println(s.pop());
				break;

			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
			}
		} while(menu != 5);
	}

}
