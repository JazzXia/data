package com.qtatelier.stack;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		//列出表达式
		Scanner scanner = new Scanner(System.in);
		/*5+3-2*9+5*/
		System.out.println("请输入运算表达式:");
		String expression = scanner.nextLine();
		/*String expression = "70+5-2";*/
		scanner.close();
		//新建两个栈，一个是符号栈，一个数栈
		CalculatorStack dataStack = new CalculatorStack(10);
		CalculatorStack operStack = new CalculatorStack(10);
		//定义需要的相关变量
		int index = 0;//用于扫描
		int data1 = 0;
		int data2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';//将每次扫描得到char保存到ch中
		String  keepNum = "";//用于拼接多位数的
		
		//开始while循环的扫描expression
		while(true) {
			
			//依次得到expression的每一个字符
			//[由于得到的只是一个字符，所以使用charAt(0)从string转成char]
			
			ch = expression.substring(index, index+1).charAt(0);
			
			//判断ch是什么，然后做相应的处理
			
			if(operStack.isOper(ch)) {
				
				//如果是运算符
				//判断当前符号栈是否为空
				
				if(!operStack.isEmpty()) {
					
					//如果符号栈有操作符，那么就进行优先级的比较
					//如果当前的操作符的优先级小于或等于栈中的操作符，
					//那么接下来就从数栈pop出两个数字，再从符号栈中
					//pop出一个符号，进行运算，得到结果，再将结果入数栈
					//随后将当前的操作符入符号栈。
					
					if(operStack.priority(ch) <=operStack.priority(operStack.peek())) {
						data1 = dataStack.pop();
						data2 = dataStack.pop();
						oper = operStack.pop();
						res = dataStack.cal(data1, data2, oper);
						
						//把运算的结果入数栈
						
						dataStack.push(res);
						
						//把当前的符号放入符号栈
						
						operStack.push(ch);
					}else {
						
						//如果当前的操作符优先级大于栈中的操作符，就直接入符号栈
						
						operStack.push(ch);
					}
				}else {
					
					//如果为空，直接入符号栈
					
					operStack.push(ch);
					
				}
			}else {
				
				//如果是数字，那么就是直接入栈
				//由于前方的每个ch都是char类型的对应ASCII码表,原来的数字，和ASCII相差48个
				//dataStack.push(ch-48);
				//1.当处理多位数时，不能发现是一个数就立即入栈，因为它可能是多位数
				//2.在处理数字时，需要向expression的表达式的index后在看一位
				//  如果是数字就继续扫描，如果是符号才入栈
				//3.因此我们需要定义一个字符串变量，用于拼接
				//处理多位数
				keepNum += ch;
				
				//如果ch已经是expression的最后一位，就直接入栈
				if(index == expression.length()-1) {
					dataStack.push(Integer.parseInt(keepNum));
				}else {
				
				//判断下一个字符是不是数字,如果是数字，就继续扫描，如果是运算符，就入数栈
				//只是看一位，而不是++
				if(operStack.isOper(expression.substring(index+1, index+2).charAt(0))) {
					//如果后一位是运算符，则入栈
					dataStack.push(Integer.parseInt(keepNum));
					//重要!!!keepNum要清空
					keepNum ="";
				}
			}
				
		}
			
			//让index + 1，并判断是否扫描到experssion最后.
			index++;
			if(index >= expression.length()) {
				break;
			}
		}
		
		//当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并计算。
		while(true) {
			//如果符号栈为空，则计算到最后的结果,数栈中只有一个数字
			if(operStack.isEmpty()) {
				break;
			}
			data1 = dataStack.pop();
			data2 = dataStack.pop();
			oper = operStack.pop();
			res = dataStack.cal(data1, data2, oper);
			dataStack.push(res);
		}
		
		System.out.printf("表达式 %s = %d",expression,dataStack.peek());
	}
}


//通过栈来创建计算器
//直接沿用之前创建好的数组栈,顺便扩展功能。

class CalculatorStack {
	private int maxSize; // 栈的大小
	private int[] stack; // 数组模拟栈，数据就放在该数组
	private int top = -1;// top表示栈顶，没数据即为-1

	public CalculatorStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	//栈顶的方法
	public int peek() {
		return stack[top];
	}
	

	// 栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// 栈空
	public boolean isEmpty() {
		return top == -1;
	}

	// 入栈
	public void push(int value) {
		// 先判断栈是否满
		if (isFull()) {
			System.out.println("栈满");
			return;
		}

		top++;
		stack[top] = value;
	}

	// 出栈
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("已经没有数据了!");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// 遍历栈
	// 从栈顶往下遍历,便利时，需要从栈顶显示数据
	public void list() {
		if (isEmpty()) {
			System.out.println("栈是空的，无法遍历");
			return;
		}

		// 需要从栈顶开始显示数据
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
	
	//返回运算符的优先级，自定义优先级，优先级使用数字表示
	//数字越大，则优先级越高。
	public int priority(int oper) {
		if(oper == '*' || oper == '/') {
			return 1;
		}else if(oper == '+' ||oper == '-') {
			return 0;
		}else {
			return -1;//假定目前的表达式只有+，-，*，/未加上小括号
		}
	}
	
	//判断是否是运算符
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	//计算方法
	public int cal(int data1,int data2,int oper) {
		int res = 0;//用于存放计算的结果
		switch(oper) {

		case '+':
			res = data1 + data2;
			break;
		case '-':
			res = data2 - data1;//注意顺序，将后弹出的数据当做减数
			break;
		case '*':
			res = data1 * data2;
			break;
		case '/':
			res = data2 / data2;//注意顺序
			break;	
		default:
			break;
		}
		return res;
	}
	
	
	
	
	
	
	
	
}