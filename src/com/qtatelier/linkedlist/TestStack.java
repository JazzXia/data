package com.qtatelier.linkedlist;

import java.util.Stack;

//��ʾջStack�Ļ���ʹ��
public class TestStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack();
		// ��ջ
		// push��add��һ����
		stack.push("jack");
		stack.push("tom");
		stack.add("smith");

		// ��ջ
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
}
