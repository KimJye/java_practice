package lab7_3;
import java.util.Stack;
import java.util.Scanner;
/*
 * 2017/10/14
 * 김지혜
 * Stack클래스 연습
 */
public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lab7_3:김지혜");
		Scanner input = new Scanner(System.in);
		
		Stack<Integer> s= new Stack<Integer>();//Integer 스택 생성
		
		System.out.println("메뉴 번호를 입력하세요");
		int menu=0;
		int item=0;
		do{
			System.out.print("1:삽입 2:삭제 3:조회 4:전체삭제 5.종료 --->");
			menu=input.nextInt();
			switch(menu){
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
				while(s.peek()!=null){
					System.out.println(s.pop());
				}
				break;
				
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
				
			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		}while(menu!=5);
	}

}
