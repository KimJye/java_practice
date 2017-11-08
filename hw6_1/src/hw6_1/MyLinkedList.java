package hw6_1;

public class MyLinkedList {
	// (1) 인스턴스 변수 head 선언: 연결리스트의 첫번째 노드를 가리킴
		private Node head;
	
		
		// (2) 기타 필요한 인스턴스 변수 선언
		private int count;


		// (3) 비어있는 리스트를 생성
		public MyLinkedList() {
			
			head=null;
			count =0;


		}

		// (4) 리스트의 맨 앞에 item을 삽입
		public void addFirst(int item) {
			// data 필드가 item인 새로운 Node 객체를 생성(newNode)
			Node newNode = new Node(item);
			// head가 가리키는 연결리스트의 맨 앞에 newNode를 삽입
			newNode.link= head;
			head=newNode;
			count++;

		}

		// (5) 리스트의 길이를 리턴
		public int size() {
			return count;


		}

		// 리스트 원소들을 모두 출력
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

		// 리스트에서 item이 저장된 노드를 탐색하는 private 메소드 -- lab6_1에서는 사용하지 않음
		private Node searchNode(int item) {
			Node temp = head;
			while(temp != null) {
				if(item == temp.data)  
					return temp;		// 탐색 성공시 해당 노드 리턴
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
		
		//contains - 정수값을 매개변수로 받아 검색 결과(boolean 값)를 리턴
		public boolean contains(int item){
			if(searchNode(item)==null){
				return false;
			}else{
				return true;
			}
		}
		
		// add - 인덱스와 정수값을 매개변수로 리스트의 인덱스 위치에 정수값을 삽입(잘못된 인덱스 처리는 각자 알아서)
		public void add(int index, int item){
			Node p = head;
			Node newNode = new Node(item);
			for(int i=0;i<(index-1);i++){
				p=p.link;
			}
			newNode.link=p.link;
			p=newNode;
		}
		
		//remove - 인덱스를 매개변수로 받아 리스트의 인덱스 위치 원소를 삭제하고 원소값을 리턴(잘못된 인덱스 처리는 각자 알아서)
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
		//toString - 오버라이드(printList에서 출력하던 내용을 String으로 만들어서 리턴. main에서는 printList 대신 toString을 호출할 것)
		     // 효율성을 위해 StringBuffer/StringBuilder를 사용할 것
		 @Override
		   public String toString(){
		      Node temp = head;
		      StringBuffer st = new StringBuffer();
		      while(temp != null){
		         st.append(temp.data);
		      }
		      return st.toString();
		   } 
		// 연결리스트 노드 구조를 표현하는 private 클래스
		private class Node {
			      int data;	 // (6) 정수값을 저장할 데이터 필드 data 선언
			      Node link;	 // (7) 다음 노드 참조값을 저장할 링크 필드link 선언

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

