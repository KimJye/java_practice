package lab0_7;



public class MyList {
	private int arr[];
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
}
