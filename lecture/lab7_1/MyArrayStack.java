package lab7_1;

public class MyArrayStack {

	private int stack[];//����
	private int top;
	public int stackSize;//���� ũ��
	
	public MyArrayStack(int size){//���� ������
		stack=new int[size];
		stackSize=size;
		top=-1;
	}
	
	public boolean isFull(){//������ ��������
		return top==stackSize-1;
	}
	
	public boolean isEmpty(){//������ ���������
		return top==-1;
	}
	
	public void push(int item){//item�� �ֱ�
		if(isFull()){
			System.out.println("Inserting fail! Array Stack is full!");
		}else{
			stack[++top]=item;
			stackSize++;
		}
	}
	
	public int pop()throws Exception{
		if(isEmpty()){
			throw new Exception("������ ����ֽ��ϴ�.");
		}else{
			stackSize--;
			return stack[top--];
		}
	}
	
	public int peek()throws Exception{
		if(isEmpty()){
			throw new Exception("������ ����ֽ��ϴ�.");
		}else{
			return stack[top];
		}
	}
	
	
}
