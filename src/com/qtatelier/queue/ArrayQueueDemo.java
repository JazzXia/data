package com.qtatelier.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		// ����
		// ����һ������
		ArrayQueue arrayQueue = new ArrayQueue(3);
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
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("������һ������");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("ȡ��������%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':// �鿴����ͷ����
				try {
					int res = arrayQueue.headQueue();
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
 * ���д������һ��Ķ��� ���ǻ������������ 1.������ݱ���߳���ô�����λ�ñ��ճ����� ��rear���ǻ��������ӣ���ô����Ŀյط����ò�����
 * 2.����������ֻʣһ��һ������rearȴ����maxSize-1��һ�����ݾ�ռ��һ�������˷���Դ�� 3.Ϊ�˽�������������һ�д�ϻ��ζ��С�
 * 
 * @author JazzXdh
 *
 */
// ʹ������ģ�����[����ʹ������]
class ArrayQueue {
	private int maxSize; // ��ʾ�����������
	private int front;// ����ͷ Ĭ��Ϊ-1
	private int rear; // ����β Ĭ��Ϊ-1
	private int[] arr; // ���������ڴ�����ݣ�ģ�����

	// �������еĹ�����
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;// ָ�����ͷ���������׾���ָ�����ͷ��ǰһ��λ��
		rear = -1;// ָ�����β���������һ�����ݺ��ʱrear+1��Ϊ0��������ָ��������һ�����ݡ���
	}

	// �ж϶����Ƿ���
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}

	// ������ݵ�����
	public void addQueue(int n) {
		// �ж϶����Ƿ���
		if (isFull()) {
			System.out.println("�������������ܼ�������~");
			return;
		}
		rear++;// ��rear ����
		arr[rear] = n;// ���Ժ������������ arr[++rear]=n;
	}

	// ��ȡ���е����ݣ�������
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��!,����ȡ����");
		}
		front++;// ʵ��front����
		return arr[front];
	}

	// ��ʾ���е��������ݡ���ʵҲ���Դ�front��ʼ��
	public void showQueue() {
		// ����
		if (isEmpty()) {
			System.out.println("���пգ������ݣ�");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
		/*
		 * for(int i=front+1;i<rear-front;i++) {
		 * System.out.printf("arr[%d]=%d\n",i,arr[i]); }
		 */
	}

	// ��ʾ���е�ͷ���ݣ�ע�ⲻ��ȡ�����ݽ���ֻ�ǲ鿴
	public int headQueue() {
		// �ж�
		if (isEmpty()) {
			throw new RuntimeException("���пգ������ݣ�");
		}
		// ��������Կ���front+1 �� front+=1 ��++front��front++��
		// ���������������front+1�ڶ����½���һ���������������������û�н�ֵ��ֵ���Լ�����ı�����
		int c = front + 1;
		return arr[c];
	}
}
