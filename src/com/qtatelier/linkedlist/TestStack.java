package com.qtatelier.linkedlist;

import java.util.Stack;

//演示栈Stack的基本使用
public class TestStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack();
		// 入栈
		// push和add是一样的
		stack.push("jack");
		stack.push("tom");
		stack.add("smith");

		// 出栈
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
}
