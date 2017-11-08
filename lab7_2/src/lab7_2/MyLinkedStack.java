package lab7_2;

public class MyLinkedStack {
	private Node top;
	public int stackSize;
	
	public MyLinkedStack(){
		top=null;
		stackSize=0;
	}

	public boolean isEmpty(){
		return (top == null);
	}

	public void push(int item){
		Node newNode = new Node();
		newNode.data=item;
		newNode.link=top;
		top=newNode;
		stackSize++;
	}

	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("스택이 비어있습니다.");
		}else{
			int item=top.data;
			top=top.link;
			stackSize--;
			return item;
		}
	}

	public int peek()throws Exception{
		if(isEmpty()){
			throw new Exception("스택이 비어있습니다.");
		}else{
			return top.data;
		}
	}

	private class Node{
		int data;
		Node link;
	}
}
