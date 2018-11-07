package hw5_1;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("hw5_1: 김지혜");
		MyList list = new MyList();//MyList 객체 생성
		
		list.add(20);
		list.add(30);
		list.add(20);
		list.add(40);
		list.add(-999);
		list.add(50);
		list.add(90);
		list.add(10);
		System.out.println("\n");
		System.out.println(list);
		
		System.out.println("리스트 크기="+list.size());//list 크기를 출력
		
		int index1;//인덱스1
		int index2;//인덱스2
		int index3;//인덱스3
		int index4;//인덱스4
		
		System.out.print("\n");
		System.out.print("조회할 인덱스 입력:");
		index1=input.nextInt();//조회할 인덱스(index1)를 사용자로부터 입력받음
		System.out.println("인덱스"+index1+"의 원소="+list.get(index1));//index1 위치의 값을 알아내어 출력
		
		System.out.print("\n");
		System.out.print("777로 갱신할 인덱스 입력:");
		index2=input.nextInt();//갱신할 인덱스(index2)를 사용자로부터 입력받음
		list.set(index2, 777);//index2 위치의 값을 777로 지정
		System.out.println(list);
		
		System.out.print("\n");
		System.out.print("999를 삽입할 인덱스 입력:");
		index3=input.nextInt();//삽입할 인덱스(index3)를 사용자로부터 입력받음
		list.add(index3,999);//index3 위치에 999를 삽입
		System.out.println(list);
		
		System.out.print("\n");
		System.out.print("삭제할 인덱스 입력:");
		index4=input.nextInt();//삭제할 인덱스(index4)를 사용자로부터 입력받음
		list.remove(index4);//index4 위치의 값을 삭제하여 출력
		System.out.println(list);
		
		
	}

}
