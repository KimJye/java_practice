package lab7_3;
import java.util.Stack;
import java.util.Scanner;
/*
 * 2017/10/14
 * ������
 * StackŬ���� ����
 */
public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab7_3:������");
		Scanner input = new Scanner(System.in);
		
		Stack<Integer> s= new Stack<Integer>();//Integer ���� ����
		
		System.out.println("�޴� ��ȣ�� �Է��ϼ���");
		int menu=0;
		int item=0;
		do{
			System.out.print("1:���� 2:���� 3:��ȸ 4:��ü���� 5.���� --->");
			menu=input.nextInt();
			switch(menu){
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
				while(s.peek()!=null){
					System.out.println(s.pop());
				}
				break;
				
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				break;
				
			default:
				System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
			}
		}while(menu!=5);
	}

}
