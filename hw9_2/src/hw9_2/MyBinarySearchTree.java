package hw9_2;

/*
 * 파일명: MyBinarySearchTree.java
 * 작성일: 2017.11.28
 * 작성자: 김지혜
 * 설명: int형 키값 저장하는 이진탐색트리를 연결자료구조로 구현한 클래스
 */

import java.util.NoSuchElementException;

class MyBinarySearchTree {
	// 트리의 루트 노드를 가리킬 인스턴스 변수 root 선언하고 null로 초기화
	private Node root =null;
	// (가) ...


	// 트리의 노드를 표현하는 클래스 - 필드(int형 key, leftChild, rightChild), 생성자(key값을 매개변수하여 초기화)
	private class Node {
		// (나) ...
		private int key;
		private Node leftChild;
		private Node rightChild;

		public Node(int key){
			this.key=key;
		}

	}

	// (1) 전체조회를 위한 toString() 오버라이드
	@Override
	public String toString() {
		String result = inorder(root);
		return result;
	}

	// p를 루트로 하는 트리를 중위 순회하며 키값을 문자열로 리턴하는 메소드(재귀 알고리즘)
	private String inorder(Node p) {
		String result = "";
		if(p != null) {
			result += inorder(p.leftChild);
			result += p.key + " ";
			result += inorder(p.rightChild);
		}
		return result;
	}

	// (2) 재귀 삽입
	public void insert(int key) {  
		root = insertKey(root, key);
	}

	// p를 루트로 하는 트리에 key를 삽입하는 메소드 (재귀 알고리즘)
	private Node insertKey(Node p, int key) {
		if(p == null) {		
			Node newNode = new Node(key);
			return newNode;	
		}
		else if(key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p;		// 루트 불변
		}
		else if(key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p;		// 루트 불변        
		}
		else {  // key = p.key 인 경우 삽입 실패
			System.out.println("Insertion fail! key duplication : " + key);
			return p;  	// 루트 불변
		}
	}   

	// (3) 후위 순회
	public void printPostorder() {
		postorder(root);
		System.out.println();
	}

	// p를 루트로 하는 트리를 후위 순회하며 키값을 출력하는 메소드
	private void postorder(Node p) {
		if(p!=null){
			postorder(p.leftChild);
			postorder(p.rightChild);
			System.out.print(p.key+" ");
		}
	}
	//검색하는 메소드
	public boolean contains(int item){
		Node temp=root;
		if(item==temp.key) return true;
		else {
			while(temp!=null){
				if(item<temp.key){
					temp=temp.leftChild;
					if(item==temp.key) return true;
				}
				else if(item>temp.key){
					temp=temp.rightChild;
					if(item==temp.key) return true;
				}
			}
			return false;
		}
	}
	//최댓값 메소드
	public int max(){
		Node temp=root;
		if(temp==null){
			throw new NoSuchElementException("비어있습니다~");
		}else{
			while(temp!=null){
				if(temp.rightChild!=null){
					temp=temp.rightChild;
				}else
					break;
			}
			return temp.key;
		}
	}
	//반복 알고리즘을 이용한 삽입 메소드
	public boolean add(int item){
		Node temp=root;
		Node newNode = new Node(item);

		if(temp == null) {		
			temp=newNode;
			return true;
		}
		while(temp!=null){
			if(item < temp.key) {
				if(temp.leftChild!=null){
					temp=temp.leftChild;
				}else{
					temp.leftChild=newNode;
					return true;
				}
			}
			else if(item > temp.key) {
				if(temp.rightChild!=null){
					temp=temp.rightChild;
				}else{
					temp.rightChild=newNode;
					return true;
				}
			}
			else if(item==temp.key) return false;
		}
		return false;

	}
	//삭제 메소드
	public boolean remove(int item){
		Node p=root;//삭제할 노드
		Node parent=null;//삭제할 노드의 부모 노드
		if(p==null) return false;
		else{
			while(p!=null && p.key != item){

				if(item==p.key){
					parent=null;
					break;
				}
				else if(item<p.key){
					parent=p;
					p=p.leftChild;
					if(item==p.key) break;

				}
				else if(item>p.key){
					parent=p;
					p=p.rightChild;
					if(item==p.key) break;

				}

			}
			if(p.leftChild==null && p.rightChild==null){//삭제할 노드가 단말노드일 경우
				if(parent==null){//p가 루트인 경우
					p=null;
					return true;
				}else if(parent.leftChild==p){
					parent.leftChild=null;
					return true;
				}else if(parent.rightChild==p){
					parent.rightChild=null;
					return true;
				}
			}else if(p.leftChild==null || p.rightChild==null){//삭제할 노드가 하나의 자식노드를 가진 경우
				
				if(p.leftChild==null){
					if(parent.leftChild==p){
						parent.leftChild=p.rightChild;
						return true;
					}else if(parent.rightChild==p){
						parent.rightChild=p.rightChild;
						return true;
					}
				}else if(p.rightChild==null){
					if(parent.rightChild==p){
						parent.rightChild=p.leftChild;
						return true;
					}else if(parent.leftChild==p){
						parent.leftChild=p.leftChild;
						return true;
					}
					
				}
			}else if(p.leftChild!=null&&p.rightChild!=null){//삭제할 노드가 두개의 자식노드를 가진 경우
				Node max_q=max(p);//왼쪽 서브트리의 최대 노드가 후계자
				int hoo = max_q.key;//후계자의 키 값을 p에 복사
				remove(hoo);
				p.key=hoo;
				return true;
			}

		}
		return true;
	}

	//최댓값 메소드.후계자 선택 위한 메소드.
	public Node max(Node p){
		Node temp=p;
		while(temp!=null){
			if(temp.rightChild!=null){
				temp=temp.rightChild;
			}else
				break;
		}
		return temp;

	}

}
