package lab0_7;
/*
 * 정수 리스트 관리하기
 * 김지혜
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab0_7: 김지혜");
		MyList list = new MyList();//MyList 객체 생성
		
		list.print();//list를 출력
		
		list.add(2);//list에 2를 저장
		list.print();//list를 출력
		
		list.add(3);//list에 3을 저장
		list.print();//list를 출력
		
		list.add(2);//list에 2를 저장
		list.print();//list를 출력
	}

}
