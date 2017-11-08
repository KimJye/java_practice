package lab7_1;
/* 김지혜
 * 2017/10/14
 * 스택의 순차자료구조 구현을이해한다.
 */
import java.util.Scanner;
public class MyArrayStackTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("lab7_1:김지혜");

		MyArrayStack s =new MyArrayStack(10);
		Scanner input = new Scanner(System.in);
		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		do {
			System.out.print("1:삽입 2:삭제 3:조회 4:전체삭제 5.종료 --->");
			menu = input.nextInt();
			switch(menu) {
			case 1:
				System.out.println("스택 삽입합니다.");
				System.out.print("삽입하는 값: ");
				item=input.nextInt();
				s.push(item);
				break;
			case 2:
				System.out.println("스택 삭제합니다.");
				System.out.println("삭제된 값:"+ s.pop());

				break;
			case 3:
				System.out.println("top의 원소값을 조회합니다.");
				System.out.println("조회된 원소 = " + s.peek());
				break;
			case 4:
				System.out.println("전체 삭제를 수행합니다.");
				for(int i=0;i<=s.stackSize;i++) {
					System.out.println(s.pop());
				}
				System.out.println(s.pop());
				break;

			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while(menu != 5);
	}

}