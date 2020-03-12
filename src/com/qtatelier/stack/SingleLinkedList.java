package com.qtatelier.stack;


/**
 * ʹ��������ʵ��ջ
 *
 */
public class SingleLinkedList {
	Node top;
	
	/**
	 * ѹջ
	 * @param data
	 */
	public void push(int data) {
		// �ȰѴ�������ֹ����һ���ڵ㣬��Ϊ�������
		Node node = new Node(data);
		if(top == null) {
			top = node;
		}else {
			// ֱ�ӽ��½ڵ���Ϊջ��Ԫ��
			node.next = top;
			top = node;
		}
	}
	
	
	/**
	 * ��ջ
	 * @return
	 */
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("ջ�ǿյ�!");
		}
		int data = top.data;
		top = top.next;
		return data;
	}
	
	
	/**
	 * ����ջ��Ԫ��
	 * @return
	 */
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("ջ�ǿյ�!");
		}
		return top.data;
	}
	
	
	/**
	 * ջ��Ԫ������
	 * @return
	 */
	public int length() {
		if(top == null) {
			return 0;
		}
		Node temp = top;
		// ������
		int count = 0;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		
		return count;
	}
	
	
	/**
	 * �п�
	 * @return
	 */
	public boolean isEmpty() {
		return top == null;
	}
	
	
	
	
}
 
 
class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
}

