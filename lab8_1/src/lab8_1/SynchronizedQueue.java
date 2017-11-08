package lab8_1;
/*
 * ���ϸ� : SynchronizedQueue.java
 * �ۼ���: 2017�� 11�� 2��
 * �ۼ���: ������
 * ����: �迭�� ������ ����ȭ�� ���� ť
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedQueue {
	private final Lock lock = new ReentrantLock();
	private final Condition notFull  = lock.newCondition(); //���Ǻ���
	private final Condition notEmpty = lock.newCondition(); //���Ǻ���
	private int[] array; //�����迭
	private int capacity;//�迭ũ��
	private int front = 0;
	private int rear = 0;
	
	public SynchronizedQueue(int capacity) {
		this.capacity = capacity;
		array = new int[capacity];
	}
	
	public boolean isEmpty() {//ť�� ����ִ� ���.
		return front == rear;
	}
	
	public boolean isFull() {//ť�� ������ ���.
		return (rear + 1) % capacity == front;// rear�� ���� ��ġ�� ť�� ���̷� ���� �������� front�� ������ ���������̴�.
	}

	public void enQueue(int item) throws InterruptedException {//���� ť�� ����
		lock.lock();//�ٸ� �����尡 �������� ���ϵ��� ���°�
		try {
			while (isFull()) {//�������� �ݺ��� ����
				System.out.println("enQueue : ť�� �������� ��ٸ��ϴ�.");
				notFull.await();//��ٷ�	
			}
			rear = (rear + 1) % capacity;//������ ������ �ε����� ������ rear�� ���� �ϳ� ������Ű�� ������ ��Ÿ���� ���� capactiy�� ������ �������� rear�� �����ؼ� ������ �ڸ��� �غ��Ѵ�.
			array[rear] = item;//������ rear ��ġ�� item�� ����
			notEmpty.signal();//notEmpty�� ����� �����
		} finally {
			lock.unlock();
		}
	}

	public int deQueue() throws InterruptedException {//���� ť�� ����
		lock.lock();//�ٸ� �����尡 �������� ���ϵ��� ���°�
		try {
			while (isEmpty()) {//ť�� ��������� �ݺ��� ����
				System.out.println("\t\tdeQueue : ť�� �� ��ٸ��ϴ�.");
				notEmpty.await();
			}
			front = (front + 1) % capacity;//front��ġ�� ���ڸ� �ڷ� �̵��Ͽ� ť�� �����ִ� ù ��° ������ ��ġ�� �̵��Ͽ� ������ �ڸ� �غ�.������ ��Ÿ���� ����capacity�� ������ ������.
			int item = array[front];//�������� ���Ұ��� item�� ����
			notFull.signal();
			return item;//item�� ��ȯ
		} finally {
			lock.unlock();
		}
	}
}
