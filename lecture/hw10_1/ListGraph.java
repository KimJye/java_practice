/*
 * 	undirected graph를 표현하는 추상자료형인 ListGraph 클래스를 정의하고 이를 이용하는 프로그램을 작성하시오.
	단, vertex 개수가 n이면, vertex 번호는 0, 1, 2, ... n-1 이다.
 */
package hw10_1;

public class ListGraph {
	private Node[] list;
	private int n;//정점 개수

	public ListGraph(int n){
		list = new Node[n];
		this.n=n;

	}
	//간선을 이루는 두개의 정점 v1, v2를 매개변수로 받아 그래프에 간선을 추가
	public void addEdge(int v1, int v2){
		if(v1<0||v1>=n||v2<0||v2>=n){//잘못된 정점 번호인 경우 오류 메시지 출력
			System.out.println("간선 삽입 오류- 잘못된 정점 번호입니다");
		}
		else{
			Node temp = list[v1];
			while (temp != null) {//이미 존재하는 간선인 경우 오류 메시지 출력  
				if (temp.vertex == v2) {
					System.out.println("간선 삽입 오류 - 이미 존재하는 간선입니다.");
					return;
				}
				temp = temp.link;
			}
			//v1노드에 정점v2삽입
			Node newNode1 = new Node();
			newNode1.vertex = v2;
			newNode1.link = list[v1];
			list[v1] = newNode1;
			//v2노드에 정점 v1삽입
			Node newNode2 = new Node();
			newNode2.vertex = v1;
			newNode2.link = list[v2];
			list[v2] = newNode2;
		}
	}
	//정점을 매개변수로 받아 그 정점에 인접한 정점들을 모두 출력
	public void printAdjacentVertices(int v){
		if(v<0||v>=n){//잘못된 정점 번호인 경우 오류 메시지 출력
			System.out.println("인접 정점 출력 오류 - 잘못된 정점 번호입니다.");
		}else{
			System.out.printf("%d에 인접한 정점=",v);
			Node temp=list[v];
			while(temp!=null){
				System.out.print(temp.vertex+" ");
				temp=temp.link;

			}
		}
	}

	private class Node{
		int vertex;
		Node link;
	}
}

