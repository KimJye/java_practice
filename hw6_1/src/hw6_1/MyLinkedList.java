package hw6_1;

public class MyLinkedList {
	// (1) �ν��Ͻ� ���� head ����: ���Ḯ��Ʈ�� ù��° ��带 ����Ŵ
		private Node head;
	
		
		// (2) ��Ÿ �ʿ��� �ν��Ͻ� ���� ����
		private int count;


		// (3) ����ִ� ����Ʈ�� ����
		public MyLinkedList() {
			
			head=null;
			count =0;


		}

		// (4) ����Ʈ�� �� �տ� item�� ����
		public void addFirst(int item) {
			// data �ʵ尡 item�� ���ο� Node ��ü�� ����(newNode)
			Node newNode = new Node(item);
			// head�� ����Ű�� ���Ḯ��Ʈ�� �� �տ� newNode�� ����
			newNode.link= head;
			head=newNode;
			count++;

		}

		// (5) ����Ʈ�� ���̸� ����
		public int size() {
			return count;


		}

		// ����Ʈ ���ҵ��� ��� ���
		public void printList() {
			Node temp = head;
			System.out.print("[");
			while(temp != null) {
				System.out.print(temp.data);
				temp = temp.link;
				if(temp != null)
					System.out.print(", ");
			}
			System.out.println("]");
		}

		// ����Ʈ���� item�� ����� ��带 Ž���ϴ� private �޼ҵ� -- lab6_1������ ������� ����
		private Node searchNode(int item) {
			Node temp = head;
			while(temp != null) {
				if(item == temp.data)  
					return temp;		// Ž�� ������ �ش� ��� ����
				else 
					temp = temp.link;
			}
			return temp;	
		}
		
		public int removeFirst(){
			Node pre,temp;
			if(head == null) return -1;
			if(head.link ==null){
				head=null;
			}
			else{
				pre = head;
				temp = head.link;
				while(temp.link !=null){
					pre = temp;
					temp = temp.link;
				}
				pre.link =null;
			}
			return head.data;
		}
		
		//contains - �������� �Ű������� �޾� �˻� ���(boolean ��)�� ����
		public boolean contains(int item){
			if(searchNode(item)==null){
				return false;
			}else{
				return true;
			}
		}
		
		// add - �ε����� �������� �Ű������� ����Ʈ�� �ε��� ��ġ�� �������� ����(�߸��� �ε��� ó���� ���� �˾Ƽ�)
		public void add(int index, int item){
			Node p = head;
			Node newNode = new Node(item);
			for(int i=0;i<(index-1);i++){
				p=p.link;
			}
			newNode.link=p.link;
			p=newNode;
		}
		
		//remove - �ε����� �Ű������� �޾� ����Ʈ�� �ε��� ��ġ ���Ҹ� �����ϰ� ���Ұ��� ����(�߸��� �ε��� ó���� ���� �˾Ƽ�)
		public int remove(int index){
			Node c =head;
			for(int i=0;i<(index-1);i++){
				c=c.link;
			}
			if(c==null){
				return -1;
			}else{
				Node old=c.link.link;
				c.link=old;
				return old.data;
			}
		}
		//toString - �������̵�(printList���� ����ϴ� ������ String���� ���� ����. main������ printList ��� toString�� ȣ���� ��)
		     // ȿ������ ���� StringBuffer/StringBuilder�� ����� ��
		 @Override
		   public String toString(){
		      Node temp = head;
		      StringBuffer st = new StringBuffer();
		      while(temp != null){
		         st.append(temp.data);
		      }
		      return st.toString();
		   } 
		// ���Ḯ��Ʈ ��� ������ ǥ���ϴ� private Ŭ����
		private class Node {
			      int data;	 // (6) �������� ������ ������ �ʵ� data ����
			      Node link;	 // (7) ���� ��� �������� ������ ��ũ �ʵ�link ����

			Node() {
				data = 0;
				link = null;
			}

			Node(int data) {
				this.data = data;
				this.link = null;
			}

			Node(int data, Node link) {
				this.data = data;
				this.link = link;
			}
		}
	}

