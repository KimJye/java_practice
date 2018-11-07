package hw8_2;
import java.util.NoSuchElementException;
public class MyLinkedQueue{
	private Node front;
	private Node rear;
	
	public MyLinkedQueue(){//생성자. 변수 초기화하기
		front=null;
		rear=null;
	}
	
	public boolean isEmpty(){//비어있는 경우
		return(front==null);
	}
	
	public void enQueue(int item){//원소 삽입
		Node newNode = new Node(item);
		if(isEmpty()){
			front=newNode;
			rear=newNode;
		}else{
			rear.link=newNode;
			rear=newNode;
		}	
	}
	
	public int deQueue(){//원소 삭제
		if(isEmpty()){
			throw new NoSuchElementException("큐가 비어있어 삭제가 안됩니다~"); 
		}else{
			int item= front.data;
			front=front.link;
			if(front==null){
				rear=null;
			}
			return item;	
		}
	}
	
	private class Node{//노드 정의
		int data;
		Node link;
		
		Node(){
			link=null;
		}
		Node(int data){
			this.data=data;
		}
	}
}

