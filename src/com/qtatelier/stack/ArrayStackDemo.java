package com.qtatelier.stack;

import java.util.Scanner;

/**
 * 用数组模拟栈
 * @author JazzXdh
 *
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
/*		//模拟栈
		ArrayStack  stack = new ArrayStack(5);
		stack.push(5);
		stack.push(4);
		stack.push(4);
		stack.push(4);
		stack.push(4);
		stack.pop();
		stack.list();*/
		
		//测试栈
		String key="";
		boolean loop = true;//控制是否退出菜单
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入栈的大小");
		int num = scanner.nextInt();
		ArrayStack stack = new ArrayStack(num);
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


//定义一个ArrayStack来表示栈
class ArrayStack{
	private int maxSize; //栈的大小
	private int [] stack; //数组模拟栈，数据就放在该数组
	private int top = -1;//top表示栈顶，没数据即为-1
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//栈满
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//栈空
	public boolean isEmpty() {
		return top==-1;
	}
	
	//入栈
	public void push(int value) {
		//先判断栈是否满
		if(isFull()) {
			System.out.println("栈满");
			return;
		}
		
		top++;
		stack[top] = value;
	}
	
	//出栈
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("已经没有数据了!");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	//遍历栈
	//从栈顶往下遍历,便利时，需要从栈顶显示数据
	public void list() {
		if(isEmpty()) {
			System.out.println("栈是空的，无法遍历");
			return;
		}
		
		//需要从栈顶开始显示数据
		for(int i = top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
		
	}
	
}
