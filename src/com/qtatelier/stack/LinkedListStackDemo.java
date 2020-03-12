package com.qtatelier.stack;

import java.util.Scanner;

/**
 * ��˫��������ģ��ջ
 * @author JazzXdh
 *
 */
public class LinkedListStackDemo {
	public static void main(String[] args) {
				//����ջ
				String key="";
				boolean loop = true;//�����Ƿ��˳��˵�
				Scanner scanner = new Scanner(System.in);
				System.out.println("������ջ�Ĵ�С");
				int num = scanner.nextInt();
				LinkedListStack stack = new LinkedListStack(num);
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


//����ջ
class LinkedListStack{
	
	private int top = -1;
	//ջ���������
	private int maxSize;

	//����ͷ�ڵ�
	private StackNode head = new StackNode(-1,0);

	
	//��������ָ��
	private StackNode curStack = head;
	//����ڵ�
	StackNode stackNode = null;
	//��ʼ��
	public LinkedListStack(int maxSize) {
		this.maxSize = maxSize;
	}

	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}

	//ջ��
	public boolean isFull() {
		return top == maxSize-1;
	}


	//��ջ
	public void push(int no) {
		if (isFull()) {
			System.out.println("ջ�����ģ��޷����");
			return;
		}
		top++;
	    stackNode = new StackNode(top, no);
		curStack.setNext(stackNode);
		stackNode.setPre(curStack);
		curStack = curStack.getNext();
	}
	
	//��ջ
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("�Ѿ�û��������!");
		}
		int value = curStack.getData();
		
		curStack = curStack.getPre();
		curStack.setNext(curStack.getNext().getNext());
		top--;
		return value;
	}
	
	//����
	public void list() {
		// �ж������Ƿ�Ϊ��
		if (isEmpty()) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��Ϊͷ�ڵ㣬���ܶ�����һ����־��������һ��������
		// �ɴ�������һ����������������ͷ���
		StackNode temp = head.getNext();
		while (true) {
			// �ж��Ƿ���������
			if (temp == null) {
				break;
			}
			// ����ڵ����Ϣ
			System.out.println(temp);
			// ���temp���ƣ�ָ����һ���ڵ���������
			// Ҫ��Ȼ��Զ����ָ��ͬһ��ֵ��������ѭ��
			temp = temp.getNext();
		}
		
	}
	
	
}





// �����ڵ�
class StackNode {
	private int data;//������
	private int order;
	private StackNode pre;
	private StackNode next;//ָ����һ���ڵ�

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

