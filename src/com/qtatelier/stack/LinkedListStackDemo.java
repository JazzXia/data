package com.qtatelier.stack;

import java.util.Scanner;

/**
 * 用双向链表来模拟栈
 * @author JazzXdh
 *
 */
public class LinkedListStackDemo {
	public static void main(String[] args) {
				//测试栈
				String key="";
				boolean loop = true;//控制是否退出菜单
				Scanner scanner = new Scanner(System.in);
				System.out.println("请输入栈的大小");
				int num = scanner.nextInt();
				LinkedListStack stack = new LinkedListStack(num);
				while(loop) {
					System.out.println("show: 表示显示栈");
					System.out.println("exit: 退出程序");
					System.out.println("push: 入栈");
					System.out.println("pop:  出栈");
					System.out.println("请输入你的指令");
					key = scanner.next();
					switch(key) {
					case "show":
						stack.list();
					break;
					case "push":
						System.out.println("请输入一个数");
						int value = scanner.nextInt();
						stack.push(value);
						break;
						
					case "pop":
						 try {
							 int res = stack.pop();
							 System.out.printf("出栈的数据是%d\n",res);
						 }catch(Exception e) {
							 System.out.println(e.getMessage());
						 }
						 break;
					case "exit":
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


//创建栈
class LinkedListStack{
	
	private int top = -1;
	//栈的最大容量
	private int maxSize;

	//创建头节点
	private StackNode head = new StackNode(-1,0);

	
	//创建辅助指针
	private StackNode curStack = head;
	//定义节点
	StackNode stackNode = null;
	//初始化
	public LinkedListStack(int maxSize) {
		this.maxSize = maxSize;
	}

	//栈空
	public boolean isEmpty() {
		return top == -1;
	}

	//栈满
	public boolean isFull() {
		return top == maxSize-1;
	}


	//入栈
	public void push(int no) {
		if (isFull()) {
			System.out.println("栈是满的，无法添加");
			return;
		}
		top++;
	    stackNode = new StackNode(top, no);
		curStack.setNext(stackNode);
		stackNode.setPre(curStack);
		curStack = curStack.getNext();
	}
	
	//出栈
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("已经没有数据了!");
		}
		int value = curStack.getData();
		
		curStack = curStack.getPre();
		curStack.setNext(curStack.getNext().getNext());
		top--;
		return value;
	}
	
	//遍历
	public void list() {
		// 判断链表是否为空
		if (isEmpty()) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点，不能动，是一个标志，代表了一整个链表
		// 由此我们找一个辅助变量来代替头结点
		StackNode temp = head.getNext();
		while (true) {
			// 判断是否到链表的最后
			if (temp == null) {
				break;
			}
			// 输出节点的信息
			System.out.println(temp);
			// 随后将temp后移，指向下一个节点进行输出，
			// 要不然永远都会指向同一个值，陷入死循环
			temp = temp.getNext();
		}
		
	}
	
	
}





// 创建节点
class StackNode {
	private int data;//数据域
	private int order;
	private StackNode pre;
	private StackNode next;//指向下一个节点

	public StackNode(int order,int data) {
		super();
		this.data = data;
		this.order = order;
	}

	public StackNode getPre() {
		return pre;
	}

	public void setPre(StackNode pre) {
		this.pre = pre;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public StackNode getNext() {
		return next;
	}

	public void setNext(StackNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "StackNode [data=" + data + ", order=" + order + ", next=" + next + "]";
	}


}

