package lab10_1;

public class MatrixGraph {
	private int[][] matrix;
	private int n;

	public MatrixGraph(int n){//정점수 n을 매개변수로 받아 정점은 n개이고 간선은 없는 초기 그래프를 생성
		matrix = new int [n][n];
		this.n=n;
	}
	//간선을 이루는 두개의 정점 v1, v2를 매개변수로 받아 그래프에 간선을 추가
	// 잘못된 정점 번호인 경우 오류 메시지 출력
	// 이미 존재하는 간선인 경우 오류 메시지 출력
	public void addEdge(int v1, int v2){
		if(v1<0 || v1>=n || v2<0 || v2>=n){
			System.out.println("간선 삽입 오류-잘못된 정점 번호입니다.");
			
		}
		else if(matrix[v1][v2]==1){
			System.out.println("간선 삽입 오류-이미 존재하는 간선입니다.");
		}
		else{
			matrix[v1][v2]=1;
			matrix[v2][v1]=1;
		}
	}
	//정점을 매개변수로 받아 그 정점에 인접한 정점들을 모두 출력
	// 잘못된 정점 번호인 경우 오류 메시지 출력
	public void printAdjacentVertices(int v1){
		if(v1<0 || v1>=n){
			System.out.println("잘못된 정점 번호입니다.");
		}
		else{
			System.out.printf("%d에 인접한 정점=",v1);
			for(int i=0;i<n;i++){
				if(matrix[v1][i]==1){
					System.out.printf("%d ",i);
		
				}
			
			}
		}
	}
}
