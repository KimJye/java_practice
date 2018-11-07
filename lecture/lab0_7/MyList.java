package lab0_7;



public class MyList {
	private int arr[];
	private int save;//저장용량
	private int number;//자료 갯수를 나타내는 변수
	
	public MyList(){
		arr = new int [10];//크기가 10인 정수 배열을 생성하여 배열 속성을 초기화
		save=10;//저장용량을 10으로 초기화
		number=0;//저장된 정수 갯수를 0으로 초기화
	}
	
	public void add(int value){
		arr[number]=value;
		number++;
		
	}
	
	public void print(){
		System.out.print("[");
		for(int i=0;i<number;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("]");
	}
}
