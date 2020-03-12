package com.qtatelier.stack;

import java.util.Scanner;

/**
 * ������ģ��ջ
 * @author JazzXdh
 *
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
/*		//ģ��ջ
		ArrayStack  stack = new ArrayStack(5);
		stack.push(5);
		stack.push(4);
		stack.push(4);
		stack.push(4);
		stack.push(4);
		stack.pop();
		stack.list();*/
		
		//����ջ
		String key="";
		boolean loop = true;//�����Ƿ��˳��˵�
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ջ�Ĵ�С");
		int num = scanner.nextInt();
		ArrayStack stack = new ArrayStack(num);
		while(loop) {
			System.out.println("show: ��ʾ��ʾջ");
			System.out.println("exit: �˳�����");
			System.out.println("push: ��ջ");
			System.out.println("pop:  ��ջ");
			System.out.println("���������ָ��");
			key = scanner.next();
			switch(key) {
			case "show":
				stack.list();
			break;
			case "push":
				System.out.println("������һ����");
				int value = scanner.nextInt();
				stack.push(value);
				break;
				
			case "pop":
				 try {
					 int res = stack.pop();
					 System.out.printf("��ջ��������%d\n",res);
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
		System.out.println("�����˳�!");
		
	}
}


//����һ��ArrayStack����ʾջ
class ArrayStack{
	private int maxSize; //ջ�Ĵ�С
	private int [] stack; //����ģ��ջ�����ݾͷ��ڸ�����
	private int top = -1;//top��ʾջ����û���ݼ�Ϊ-1
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//ջ��
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//ջ��
	public boolean isEmpty() {
		return top==-1;
	}
	
	//��ջ
	public void push(int value) {
		//���ж�ջ�Ƿ���
		if(isFull()) {
			System.out.println("ջ��");
			return;
		}
		
		top++;
		stack[top] = value;
	}
	
	//��ջ
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("�Ѿ�û��������!");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	//����ջ
	//��ջ�����±���,����ʱ����Ҫ��ջ����ʾ����
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ�ǿյģ��޷�����");
			return;
		}
		
		//��Ҫ��ջ����ʼ��ʾ����
		for(int i = top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
		
	}
	
}
