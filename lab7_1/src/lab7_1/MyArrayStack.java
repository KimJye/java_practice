package lab7_1;

public class MyArrayStack {

	private int stack[];//스택
	private int top;
	public int stackSize;//스택 크기
	
	public MyArrayStack(int size){//스택 생성자
		stack=new int[size];
		stackSize=size;
		top=-1;
	}
	
	public boolean isFull(){//스택이 가득찰때
		return top==stackSize-1;
	}
	
	public boolean isEmpty(){//스택이 비어있을때
		return top==-1;
	}
	
	public void push(int item){//item을 넣기
		if(isFull()){
			System.out.println("Inserting fail! Array Stack is full!");
		}else{
			stack[++top]=item;
			stackSize++;
		}
	}
	
	public int pop()throws Exception{
		if(isEmpty()){
			throw new Exception("스택이 비어있습니다.");
		}else{
			stackSize--;
			return stack[top--];
		}
	}
	
	public int peek()throws Exception{
		if(isEmpty()){
			throw new Exception("스택이 비어있습니다.");
		}else{
			return stack[top];
		}
	}
	
	
}
