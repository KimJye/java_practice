package hw8_2;

import java.util.Scanner;
public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw8_2: ������");
		Scanner input = new Scanner(System.in);

		MyLinkedQueue queue = new MyLinkedQueue();//MyLinkedQueue ��ü�� ����

		System.out.println("�޴� ��ȣ�� �Է��ϼ���:");
		int menu=0;
		int item;
		do{
			System.out.print("1:����  2:����  3:��ü����  4:����--->");
			menu=input.nextInt();         
			switch(menu){
			case 1: System.out.println("������ ���� �Է�:");//����ڷκ��� �������� �ϳ� �Է¹޾� ť�� ����
			item =input.nextInt();
			queue.enQueue(item);
			break;
			case 2: System.out.println("������ ����:"+queue.deQueue());//ť���� ���� �ϳ��� �����Ͽ� ���
			break;
			case 3: while(queue.isEmpty()==false){//ť�� �� �������� ���Ҹ� �ϳ��� �����Ͽ� ���
				System.out.println(queue.deQueue());
			}break;
			case 4: System.out.println("���α׷��� �����մϴ�.");
			break;
			default: System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���");

			}
		} while(menu != 4);

	}

}