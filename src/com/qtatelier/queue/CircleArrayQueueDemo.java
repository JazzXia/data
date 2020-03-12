package com.qtatelier.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// ����
		System.out.println("��������ģ�⻷�ζ���@@@@@@");
		// ������6��������洢Ϊ5����ʵ���Ըĵġ�
		CircleArrayQueue circleArrayQueue = new CircleArrayQueue(6);
		char key = ' ';// �����û�����
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		// ���һ���˵�
		while (loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):������ݵ�����");
			System.out.println("g(get):�Ӷ���ȡ������");
			System.out.println("h(head):�鿴����ͷ������");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				circleArrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("������һ������");
				int value = scanner.nextInt();
				circleArrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = circleArrayQueue.getQueue();
					System.out.printf("ȡ��������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':// �鿴����ͷ����
				try {
					int res = circleArrayQueue.headQueue();
					System.out.printf("����ͷ��������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�!");
	}
}

/**
 * ���ζ���!!��֮ǰ�Ķ����������� ��ģ�⻷�ζ��еķ����кܶ��������ֻѡȡһ�֡�
 * 
 * @author JazzXdh
 *
 */

class CircleArrayQueue {
	private int maxSize; // ��ʾ�����������
	private int front; // ����ͷ Ĭ��Ϊ0,ָ���һ��Ԫ��
	private int rear; // ����β Ĭ��Ϊ0 ,ָ��������һ��Ԫ�صĺ�һλ
						// ����ȻҲ���Ժ�֮ǰһ��ֻ������ģ��ķ�ʽ��һ����
	private int[] arr; // ���������ڴ�����ݣ�ģ�����

	public CircleArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		/*
		 * ������Java��int��Ĭ��ֵΪ0 ���Բ���Ҫ��ʼ�� front = 0; rear = 0;
		 */
	}

	// �ж��Ƿ�����
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}

	// �����в�������
	public void addQueue(int n) {
		// �ж��Ƿ���
		if (isFull()) {
			System.out.println("��������!�����������!");
			return;
		}
		// ֱ�ӽ����ݼ���
		arr[rear] = n;
		// ��rear���ƣ�������뿼��ȡģ
		rear = (rear + 1) % maxSize;
	}

	// ��ȡ���е����ݣ�������
	public int getQueue() {
		// �ж϶����Ƿ�Ϊ��
		if (isEmpty()) {
			throw new RuntimeException("���пգ�������");
		}

		// ������Ҫ����front��ָ����еĵ�һ��Ԫ��
		// 1.�Ƚ�front��Ӧ��ֵ���浽��ʱ����
		int value = arr[front];
		// 2.��front����
		front = (front + 1) % maxSize;
		// 3.����ʱ����ı�������
		return value;
	}

	// ��ʾ�������ݵķ���
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("�����ǿյģ�");
			return;
		}
		// �����ķ���
		// ���ڿ���֮ǰ�����ݱ�ȡ�����ˣ���ôȫ������Ҳû���κ������������������ɴ�front��ʼ�洢��
		// ��ô���Դ�front��ʼ�����������ĸ����Ǵ�front��ʼ+��ЧԪ�صĸ����ĳ���
		// ������һ�¡�ò��֮ǰ��ArrayQueueDemoҲ������front+1��������
		//
		for (int i = front; i < front + size(); i++) {

			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

		}
	}

	// ��ʾͷ
	public int headQueue() {
		// �ж�
		if (isEmpty()) {
			throw new RuntimeException("���пգ������ݣ�");
		}
		// ��������Կ���front+1 �� front+=1 ��++front��front++��
		// ���������������front+1�ڶ����½���һ���������������������û�н�ֵ��ֵ���Լ�����ı�����
		return arr[front];
	}

	// ��ǰ������Ч���ݵĸ���
	public int size() {
		/**
		 * ���:rearָ�������һ��������һ��λ�ü����������(Ϊʲô���ϣ�����Ϊ���rear����һȦ����ֵ���ܱ�frontС��
		 * �ټ�ȥfront���������Ч���ݵĸ����������ֵ�ı���ֻҪȡ��õ�����������Ч���ݸ���) �����Ͼ���Сѧ������Ŀ�� �ٸ����ӣ� rear=1,
		 * front=5,maxSize=6,��ʱ��Ч���ݸ���:(1+6-5)%6=2������Ч����Ϊ2�� rear=5,
		 * front=1,maxSize=6,��ʱ��Ч���ݸ���:(5+6-1)%6=4 rear=5,
		 * front=5,maxSize=6,��ʱ��Ч���ݸ���:(5+6-5)%6=0 ��ȫ��ȷ������
		 */
		return (rear + maxSize - front) % maxSize;
	}

}