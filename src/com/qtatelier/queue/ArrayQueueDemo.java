package com.qtatelier.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		// 测试
		// 创建一个队列
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';// 接收用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		// 输出一个菜单
		while (loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查看队列头的数据");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个数字");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("取出的数字%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':// 查看队列头数据
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("队列头的数据是%d\n", res);
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
		System.out.println("程序退出!");
	}
}

/**
 * 这个写了正常一般的队列 但是会出现如下问题 1.如果数据边入边出那么下面的位置便会空出来， 而rear还是会向上增加，那么下面的空地方就用不了了
 * 2.最后这个队列只剩一下一个数据rear却等于maxSize-1【一个数据就占了一个队列浪费资源】 3.为了解决这个问题后面我会写上环形队列。
 * 
 * @author JazzXdh
 *
 */
// 使用数组模拟队列[后面使用链表]
class ArrayQueue {
	private int maxSize; // 表示数组最大容量
	private int front;// 队列头 默认为-1
	private int rear; // 队列尾 默认为-1
	private int[] arr; // 该数据用于存放数据，模拟队列

	// 创建队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;// 指向队列头部，归根结底就是指向队列头的前一个位置
		rear = -1;// 指向队列尾，如果插入一个数据后此时rear+1即为0【本质上指向队列最后一个数据】。
	}

	// 判断队列是否满
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 添加数据到队列
	public void addQueue(int n) {
		// 判断队列是否满
		if (isFull()) {
			System.out.println("队列已满，不能加入数据~");
			return;
		}
		rear++;// 让rear 后移
		arr[rear] = n;// 可以和上面组合起来 arr[++rear]=n;
	}

	// 获取队列的数据，出队列
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空!,不能取数字");
		}
		front++;// 实现front后移
		return arr[front];
	}

	// 显示队列的所有数据【其实也可以从front开始】
	public void showQueue() {
		// 遍历
		if (isEmpty()) {
			System.out.println("队列空，无数据！");
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

	// 显示队列的头数据，注意不是取出数据仅仅只是查看
	public int headQueue() {
		// 判断
		if (isEmpty()) {
			throw new RuntimeException("队列空，无数据！");
		}
		// 从这里可以看出front+1 与 front+=1 与++front或front++的
		// 本质区别就是在于front+1在堆中新建了一个变量用来保存参数，并没有将值赋值给自己本身的变量。
		int c = front + 1;
		return arr[c];
	}
}
