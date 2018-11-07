package hw5_1;

public class MyList {
	private int[] arr;
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
	
	public int get(int index){
		int result=0;
		result=arr[index];
		return result;// 인덱스를 매개변수로 받아 배열의 인덱스 위치 원소를 리턴
	}
	
	public void set(int index, int value){
		arr[index]=value;
	}
	
	public int size(){
		return number;
	}
	
	public void add(int index, int value){
		arr[index]=value;
	}
	
	public int[] remove(int index){
		for(int i=index;i<number;i++){
			arr[i]=arr[i+1];
		}
		number--;
		
		return arr;
	}

	@Override
	public String toString(){
	StringBuffer st = new StringBuffer();
	st.append("[");
	for(int i=0;i<number;i++){
		st.append(" "+arr[i]);
	}
	st.append("]");
	return st.toString();//StringBuffer인 st를 문자열로 만들어 리턴
}
	
}
