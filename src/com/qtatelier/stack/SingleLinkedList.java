package com.qtatelier.stack;


/**
 * 使用链表来实现栈
 *
 */
public class SingleLinkedList {
	Node top;
	
	/**
	 * 压栈
	 * @param data
	 */
	public void push(int data) {
		// 先把传入的数字构造成一个节点，因为是链表嘛！
		Node node = new Node(data);
		if(top == null) {
			top = node;
		}else {
			// 直接将新节点作为栈顶元素
			node.next = top;
			top = node;
		}
	}
	
	
	/**
	 * 出栈
	 * @return
	 */
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈是空的!");
		}
		int data = top.data;
		top = top.next;
		return data;
	}
	
	
	/**
	 * 返回栈顶元素
	 * @return
	 */
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("栈是空的!");
		}
		return top.data;
	}
	
	
	/**
	 * 栈中元素总数
	 * @return
	 */
	public int length() {
		if(top == null) {
			return 0;
		}
		Node temp = top;
		// 计数器
		int count = 0;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		
		return count;
	}
	
	
	/**
	 * 判空
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

