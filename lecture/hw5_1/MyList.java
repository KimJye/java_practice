package hw5_1;

public class MyList {
	private int[] arr;
	private int save;//����뷮
	private int number;//�ڷ� ������ ��Ÿ���� ����
	
	public MyList(){
		arr = new int [10];//ũ�Ⱑ 10�� ���� �迭�� �����Ͽ� �迭 �Ӽ��� �ʱ�ȭ
		save=10;//����뷮�� 10���� �ʱ�ȭ
		number=0;//����� ���� ������ 0���� �ʱ�ȭ
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
		return result;// �ε����� �Ű������� �޾� �迭�� �ε��� ��ġ ���Ҹ� ����
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
	return st.toString();//StringBuffer�� st�� ���ڿ��� ����� ����
}
	
}
