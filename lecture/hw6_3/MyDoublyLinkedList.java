package hw6_3;
/*
 * ���ϸ�: MyDoublyLinkedList.java
 * �ۼ���: ������
 * �ۼ���: 2017�� 10�� 11��
 * ����: ���߿����ڷᱸ���� ��������Ʈ�� ������ MyDoublyLinkedList Ŭ����
 */

public class MyDoublyLinkedList {

	private Node head;	// ����Ʈ�� ù��° ��带 ����ų ����
	private int count;	// ����Ʈ�� ���� ���� ��Ÿ���� ����

	public MyDoublyLinkedList() {
		head = null;
		count = 0;
	}

	// ����Ʈ ���̸� ����
	public int size() {
		return count;
	}

	// ����Ʈ�� �� �տ� item�� ����
	public void addFirst(int item) {

		// (1) �����Ͱ� item�� ���ο� ��� ����
		Node newNode = new Node(item);
		// (2) ���ο� ��带 ����Ʈ�� �� �տ� ����

		if(head==null){
			head=newNode;
			
		}else{
			newNode.rlink=head;
			head=newNode;
			newNode.rlink.llink=newNode;
		}
		// (3) ���� �� 1 ����
		count++;
	}
	public int removeFirst(){
		Node temp = head;
		if(head==null){
			System.out.println("������ ���Ұ� �����ϴ�.");
			return -1;
		}else{
			count--;
			head=head.rlink;
			return temp.data;
		}

	}

	public void remove(int item){

		Node temp =head;//������ ���Ҹ� ī��Ű�� ���

			while(temp!=null){
				if(temp.data==item){
					if(temp.llink==null){
						if(count==1){
							head=null;
							count--;
							break;
						}else{
							head=head.rlink;
							temp.rlink.llink=null;
							temp.rlink=null;
							count--;
							break;
						}
					}
					if(temp.rlink==null){
						temp.llink.rlink=null;
						count--;
						break; 
					}else{
						temp.llink.rlink=temp.rlink;
						temp.rlink.llink=temp.llink;
						count--;
						break;
					}
				}
				else{
					temp=temp.rlink;
					
				}
			}
		}
	
	// ����Ʈ�� ����⿬���� ����� �̷�������� Ȯ��
	public void printLink() {
		if (head == null) {
			System.out.println("���鸮��Ʈ��");
		}
		else {
			// ����Ʈ�� ���������� ���
			Node temp = head;
			System.out.print("����Ʈ ����=" + count + " ������ ��ũ: ");
			while(temp.rlink != null) {
				System.out.print(temp.data + "->");
				temp = temp.rlink;
			}
			System.out.print(temp.data);

			// ����Ʈ�� ���������� ���
			System.out.print(" ������ ��ũ: ");
			while(temp.llink != null) {
				System.out.print(temp.data + "->");
				temp = temp.llink;
			}
			System.out.println(temp.data);
		}
	}
	@Override
	public String toString(){
		Node temp=head;
		StringBuilder str = new StringBuilder();
		str.append("����Ʈ ����=").append(count+" ").append("������ ��ũ:[");
		while(temp!=null){
			str.append(temp.data).append(" ");
			temp=temp.rlink;
		}
		str.append("]");
		String s=str.toString();
		return s;
	}
	// ���߿��Ḯ��Ʈ ��� ����
	private class Node {
		int data;
		Node llink; 
		Node rlink;

		Node() {
			this(0, null, null);
		}
		Node(int data) {
			this(data, null, null);
		}
		Node(int data, Node llink, Node rlink) {
			this.data = data;
			this.llink = llink;
			this.rlink = rlink;
		}
	}
}

