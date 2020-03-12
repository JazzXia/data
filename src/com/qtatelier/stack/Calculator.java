package com.qtatelier.stack;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		//�г����ʽ
		Scanner scanner = new Scanner(System.in);
		/*5+3-2*9+5*/
		System.out.println("������������ʽ:");
		String expression = scanner.nextLine();
		/*String expression = "70+5-2";*/
		scanner.close();
		//�½�����ջ��һ���Ƿ���ջ��һ����ջ
		CalculatorStack dataStack = new CalculatorStack(10);
		CalculatorStack operStack = new CalculatorStack(10);
		//������Ҫ����ر���
		int index = 0;//����ɨ��
		int data1 = 0;
		int data2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';//��ÿ��ɨ��õ�char���浽ch��
		String  keepNum = "";//����ƴ�Ӷ�λ����
		
		//��ʼwhileѭ����ɨ��expression
		while(true) {
			
			//���εõ�expression��ÿһ���ַ�
			//[���ڵõ���ֻ��һ���ַ�������ʹ��charAt(0)��stringת��char]
			
			ch = expression.substring(index, index+1).charAt(0);
			
			//�ж�ch��ʲô��Ȼ������Ӧ�Ĵ���
			
			if(operStack.isOper(ch)) {
				
				//����������
				//�жϵ�ǰ����ջ�Ƿ�Ϊ��
				
				if(!operStack.isEmpty()) {
					
					//�������ջ�в���������ô�ͽ������ȼ��ıȽ�
					//�����ǰ�Ĳ����������ȼ�С�ڻ����ջ�еĲ�������
					//��ô�������ʹ���ջpop���������֣��ٴӷ���ջ��
					//pop��һ�����ţ��������㣬�õ�������ٽ��������ջ
					//��󽫵�ǰ�Ĳ����������ջ��
					
					if(operStack.priority(ch) <=operStack.priority(operStack.peek())) {
						data1 = dataStack.pop();
						data2 = dataStack.pop();
						oper = operStack.pop();
						res = dataStack.cal(data1, data2, oper);
						
						//������Ľ������ջ
						
						dataStack.push(res);
						
						//�ѵ�ǰ�ķ��ŷ������ջ
						
						operStack.push(ch);
					}else {
						
						//�����ǰ�Ĳ��������ȼ�����ջ�еĲ���������ֱ�������ջ
						
						operStack.push(ch);
					}
				}else {
					
					//���Ϊ�գ�ֱ�������ջ
					
					operStack.push(ch);
					
				}
			}else {
				
				//��������֣���ô����ֱ����ջ
				//����ǰ����ÿ��ch����char���͵Ķ�ӦASCII���,ԭ�������֣���ASCII���48��
				//dataStack.push(ch-48);
				//1.�������λ��ʱ�����ܷ�����һ������������ջ����Ϊ�������Ƕ�λ��
				//2.�ڴ�������ʱ����Ҫ��expression�ı��ʽ��index���ڿ�һλ
				//  ��������־ͼ���ɨ�裬����Ƿ��Ų���ջ
				//3.���������Ҫ����һ���ַ�������������ƴ��
				//�����λ��
				keepNum += ch;
				
				//���ch�Ѿ���expression�����һλ����ֱ����ջ
				if(index == expression.length()-1) {
					dataStack.push(Integer.parseInt(keepNum));
				}else {
				
				//�ж���һ���ַ��ǲ�������,��������֣��ͼ���ɨ�裬������������������ջ
				//ֻ�ǿ�һλ��������++
				if(operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
					//�����һλ�������������ջ
					dataStack.push(Integer.parseInt(keepNum));
					//��Ҫ!!!keepNumҪ���
					keepNum ="";
				}
			}
				
		}
			
			//��index + 1�����ж��Ƿ�ɨ�赽experssion���.
			index++;
			if(index >= expression.length()) {
				break;
			}
		}
		
		//�����ʽɨ����ϣ���˳��Ĵ���ջ�ͷ���ջ��pop����Ӧ�����ͷ��ţ������㡣
		while(true) {
			//�������ջΪ�գ�����㵽���Ľ��,��ջ��ֻ��һ������
			if(operStack.isEmpty()) {
				break;
			}
			data1 = dataStack.pop();
			data2 = dataStack.pop();
			oper = operStack.pop();
			res = dataStack.cal(data1, data2, oper);
			dataStack.push(res);
		}
		
		System.out.printf("���ʽ %s = %d",expression,dataStack.peek());
	}
}


//ͨ��ջ������������
//ֱ������֮ǰ�����õ�����ջ,˳����չ���ܡ�

class CalculatorStack {
	private int maxSize; // ջ�Ĵ�С
	private int[] stack; // ����ģ��ջ�����ݾͷ��ڸ�����
	private int top = -1;// top��ʾջ����û���ݼ�Ϊ-1

	public CalculatorStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	//ջ���ķ���
	public int peek() {
		return stack[top];
	}
	

	// ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// ջ��
	public boolean isEmpty() {
		return top == -1;
	}

	// ��ջ
	public void push(int value) {
		// ���ж�ջ�Ƿ���
		if (isFull()) {
			System.out.println("ջ��");
			return;
		}

		top++;
		stack[top] = value;
	}

	// ��ջ
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("�Ѿ�û��������!");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// ����ջ
	// ��ջ�����±���,����ʱ����Ҫ��ջ����ʾ����
	public void list() {
		if (isEmpty()) {
			System.out.println("ջ�ǿյģ��޷�����");
			return;
		}

		// ��Ҫ��ջ����ʼ��ʾ����
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
	
	//��������������ȼ����Զ������ȼ������ȼ�ʹ�����ֱ�ʾ
	//����Խ�������ȼ�Խ�ߡ�
	public int priority(int oper) {
		if(oper == '*' || oper == '/') {
			return 1;
		}else if(oper == '+' ||oper == '-') {
			return 0;
		}else {
			return -1;//�ٶ�Ŀǰ�ı��ʽֻ��+��-��*��/δ����С����
		}
	}
	
	//�ж��Ƿ��������
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	//���㷽��
	public int cal(int data1,int data2,int oper) {
		int res = 0;//���ڴ�ż���Ľ��
		switch(oper) {

		case '+':
			res = data1 + data2;
			break;
		case '-':
			res = data2 - data1;//ע��˳�򣬽��󵯳������ݵ�������
			break;
		case '*':
			res = data1 * data2;
			break;
		case '/':
			res = data2 / data2;//ע��˳��
			break;	
		default:
			break;
		}
		return res;
	}
	
	
	
	
	
	
	
	
}