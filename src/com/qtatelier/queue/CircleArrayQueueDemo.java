package com.qtatelier.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// 测试
		System.out.println("测试数组模拟环形队列@@@@@@");
		// 设置了6其队列最大存储为5【其实可以改的】
		CircleArrayQueue circleArrayQueue = new CircleArrayQueue(6);
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
				circleArrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个数字");
				int value = scanner.nextInt();
				circleArrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = circleArrayQueue.getQueue();
					System.out.printf("取出的数字%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':// 查看队列头数据
				try {
					int res = circleArrayQueue.headQueue();
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
 * 环形队列!!与之前的队列有所区别 【模拟环形队列的方法有很多这里，这里只选取一种】
 * 
 * @author JazzXdh
 *
 */

class CircleArrayQueue {
	private int maxSize; // 表示数组最大容量
	private int front; // 队列头 默认为0,指向第一个元素
	private int rear; // 队列尾 默认为0 ,指向队列最后一个元素的后一位
						// 【当然也可以和之前一样只不过是模拟的方式不一样】
	private int[] arr; // 该数据用于存放数据，模拟队列

	public CircleArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		/*
		 * 由于在Java中int的默认值为0 所以不需要初始化 front = 0; rear = 0;
		 */
	}

	// 判断是否是满
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	// 判断是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 向其中插入数据
	public void addQueue(int n) {
		// 判断是否满
		if (isFull()) {
			System.out.println("队列满了!不能添加数据!");
			return;
		}
		// 直接将数据加入
		arr[rear] = n;
		// 将rear后移，这里必须考虑取模
		rear = (rear + 1) % maxSize;
	}

	// 获取队列的数据，出队列
	public int getQueue() {
		// 判断队列是否为空
		if (isEmpty()) {
			throw new RuntimeException("队列空！！！！");
		}

		// 这里需要分析front是指向队列的第一个元素
		// 1.先将front对应的值保存到临时变量
		int value = arr[front];
		// 2.将front后移
		front = (front + 1) % maxSize;
		// 3.将临时保存的变量返回
		return value;
	}

	// 显示队列数据的方法
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列是空的！");
			return;
		}
		// 遍历的方法
		// 由于可能之前的数据被取出来了，那么全部遍历也没有任何意义又由于数据是由从front开始存储的
		// 那么可以从front开始遍历，遍历的个数是从front开始+有效元素的个数的长度
		// 【想了一下】貌似之前的ArrayQueueDemo也可以用front+1来遍历。
		//
		for (int i = front; i < front + size(); i++) {

			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);

		}
	}

	// 显示头
	public int headQueue() {
		// 判断
		if (isEmpty()) {
			throw new RuntimeException("队列空，无数据！");
		}
		// 从这里可以看出front+1 与 front+=1 与++front或front++的
		// 本质区别就是在于front+1在堆中新建了一个变量用来保存参数，并没有将值赋值给自己本身的变量。
		return arr[front];
	}

	// 求当前队列有效数据的个数
	public int size() {
		/**
		 * 理解:rear指的是最后一个数的下一个位置加上最大容量(为什么加上，是因为如果rear绕了一圈它的值可能比front小，
		 * 再减去front就是这个有效数据的个数加上最大值的倍数只要取余得到余数就是有效数据个数) 本质上就是小学奥数题目。 举个例子： rear=1,
		 * front=5,maxSize=6,此时有效数据个数:(1+6-5)%6=2所以有效数据为2。 rear=5,
		 * front=1,maxSize=6,此时有效数据个数:(5+6-1)%6=4 rear=5,
		 * front=5,maxSize=6,此时有效数据个数:(5+6-5)%6=0 完全正确！！！
		 */
		return (rear + maxSize - front) % maxSize;
	}

}