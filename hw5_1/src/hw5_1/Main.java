package hw5_1;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("hw5_1: ������");
		MyList list = new MyList();//MyList ��ü ����
		
		list.add(20);
		list.add(30);
		list.add(20);
		list.add(40);
		list.add(-999);
		list.add(50);
		list.add(90);
		list.add(10);
		System.out.println("\n");
		System.out.println(list);
		
		System.out.println("����Ʈ ũ��="+list.size());//list ũ�⸦ ���
		
		int index1;//�ε���1
		int index2;//�ε���2
		int index3;//�ε���3
		int index4;//�ε���4
		
		System.out.print("\n");
		System.out.print("��ȸ�� �ε��� �Է�:");
		index1=input.nextInt();//��ȸ�� �ε���(index1)�� ����ڷκ��� �Է¹���
		System.out.println("�ε���"+index1+"�� ����="+list.get(index1));//index1 ��ġ�� ���� �˾Ƴ��� ���
		
		System.out.print("\n");
		System.out.print("777�� ������ �ε��� �Է�:");
		index2=input.nextInt();//������ �ε���(index2)�� ����ڷκ��� �Է¹���
		list.set(index2, 777);//index2 ��ġ�� ���� 777�� ����
		System.out.println(list);
		
		System.out.print("\n");
		System.out.print("999�� ������ �ε��� �Է�:");
		index3=input.nextInt();//������ �ε���(index3)�� ����ڷκ��� �Է¹���
		list.add(index3,999);//index3 ��ġ�� 999�� ����
		System.out.println(list);
		
		System.out.print("\n");
		System.out.print("������ �ε��� �Է�:");
		index4=input.nextInt();//������ �ε���(index4)�� ����ڷκ��� �Է¹���
		list.remove(index4);//index4 ��ġ�� ���� �����Ͽ� ���
		System.out.println(list);
		
		
	}

}
