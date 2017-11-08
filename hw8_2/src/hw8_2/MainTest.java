package hw8_2;

import java.util.Scanner;
public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hw8_2: 김지혜");
		Scanner input = new Scanner(System.in);

		MyLinkedQueue queue = new MyLinkedQueue();//MyLinkedQueue 객체를 생성

		System.out.println("메뉴 번호를 입력하세요:");
		int menu=0;
		int item;
		do{
			System.out.print("1:삽입  2:삭제  3:전체삭제  4:종료--->");
			menu=input.nextInt();         
			switch(menu){
			case 1: System.out.println("삽입할 정수 입력:");//사용자로부터 정수값을 하나 입력받아 큐에 삽입
			item =input.nextInt();
			queue.enQueue(item);
			break;
			case 2: System.out.println("삭제된 원소:"+queue.deQueue());//큐에서 원소 하나를 삭제하여 출력
			break;
			case 3: while(queue.isEmpty()==false){//큐가 텅 빌때까지 원소를 하나씩 삭제하여 출력
				System.out.println(queue.deQueue());
			}break;
			case 4: System.out.println("프로그램을 종료합니다.");
			break;
			default: System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요");

			}
		} while(menu != 4);

	}

}