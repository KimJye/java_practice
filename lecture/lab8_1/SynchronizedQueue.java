package lab8_1;
/*
 * 파일명 : SynchronizedQueue.java
 * 작성일: 2017년 11월 2일
 * 작성자: 김지혜
 * 내용: 배열로 구현한 동기화된 원형 큐
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedQueue {
	private final Lock lock = new ReentrantLock();
	private final Condition notFull  = lock.newCondition(); //조건변수
	private final Condition notEmpty = lock.newCondition(); //조건변수
	private int[] array; //정수배열
	private int capacity;//배열크기
	private int front = 0;
	private int rear = 0;
	
	public SynchronizedQueue(int capacity) {
		this.capacity = capacity;
		array = new int[capacity];
	}
	
	public boolean isEmpty() {//큐가 비어있는 경우.
		return front == rear;
	}
	
	public boolean isFull() {//큐가 가득찬 경우.
		return (rear + 1) % capacity == front;// rear의 다음 위치를 큐의 길이로 나눈 나머지가 front와 같으면 가득찬것이다.
	}

	public void enQueue(int item) throws InterruptedException {//원형 큐의 삽입
		lock.lock();//다른 스레드가 실행하지 못하도록 막는것
		try {
			while (isFull()) {//가득차면 반복문 실행
				System.out.println("enQueue : 큐가 가득차서 기다립니다.");
				notFull.await();//기다려	
			}
			rear = (rear + 1) % capacity;//마지막 원소의 인덱스를 저장한 rear의 값을 하나 증가시키고 원형을 나타내기 위해 capactiy로 나누고 나머지를 rear에 대입해서 삽입할 자리를 준비한다.
			array[rear] = item;//움직인 rear 위치에 item을 저장
			notEmpty.signal();//notEmpty인 사람은 깨어나라
		} finally {
			lock.unlock();
		}
	}

	public int deQueue() throws InterruptedException {//원형 큐의 삭제
		lock.lock();//다른 스레드가 실행하지 못하도록 막는것
		try {
			while (isEmpty()) {//큐가 비어있으면 반복문 실행
				System.out.println("\t\tdeQueue : 큐가 비어서 기다립니다.");
				notEmpty.await();
			}
			front = (front + 1) % capacity;//front위치를 한자리 뒤로 이동하여 큐에 남아있는 첫 번째 원소의 위치로 이동하여 삭제할 자리 준비.원형을 나타내기 위해capacity로 나누고 나머지.
			int item = array[front];//삭제당한 원소값을 item에 저장
			notFull.signal();
			return item;//item을 반환
		} finally {
			lock.unlock();
		}
	}
}

