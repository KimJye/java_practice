package hw8_2;
import java.util.NoSuchElementException;
public class MyLinkedQueue{
	private Node front;
	private Node rear;
	
	public MyLinkedQueue(){//������. ���� �ʱ�ȭ�ϱ�
		front=null;
		rear=null;
	}
	
	public boolean isEmpty(){//����ִ� ���
		return(front==null);
	}
	
	public void enQueue(int item){//���� ����
		Node newNode = new Node(item);
		if(isEmpty()){
			front=newNode;
			rear=newNode;
		}else{
			rear.link=newNode;
			rear=newNode;
		}	
	}
	
	public int deQueue(){//���� ����
		if(isEmpty()){
			throw new NoSuchElementException("ť�� ����־� ������ �ȵ˴ϴ�~"); 
		}else{
			int item= front.data;
			front=front.link;
			if(front==null){
				rear=null;
			}
			return item;	
		}
	}
	
	private class Node{//��� ����
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

