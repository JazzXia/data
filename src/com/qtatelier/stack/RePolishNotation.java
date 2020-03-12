package com.qtatelier.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RePolishNotation {

	public static void main(String[] args) {
		
		//完成将一个中缀表达式转换成为后缀表达式的功能
		//说明
		//1. 1+((2+3)x4)-5 转成1 2 3 + 4 x + 5 -
		//2.因为直接对str进行操作不太方便。
		//  将中缀表达式转换为对用的List 
		//3.将得到的中缀表达式对应的List转换为后缀表达式对应的List
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入需要计算的表达式【可以带括号】");
		String expression = scanner.nextLine();
		List<String> infixExpressionList =  toInfixExpressionList(expression);
		System.out.println("中缀表达式转换为List的结果为: "+infixExpressionList);
		List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
		System.out.println("中缀表达式转换为后缀表达式的结果为: "+parseSuffixExpressionList);
		int res = calculate(parseSuffixExpressionList);
		System.out.println(expression+" = "+ res);
		scanner.close();
/*		//先定义逆波兰表达式【后缀表达式】
		//(30+4)x5-6转换为后缀表达式 30 4 + 5 x 6 -
		//4 * 5 - 8 + 60 +8 / 2转换为后缀表达式4 5 * 8 - 60 + 8 2 / + =76
		//将每个字符之间用空格隔开，方便分割
		String suffixExpression = "1 2 3 + 4 x + 5 -";
		//解法
		//1.先将表达式放入到ArrayList中
		//2.将ArrayList 传递给一个方法,配合栈完成计算
		
		List<String> rpnList = getListString(suffixExpression);
		System.out.println(rpnList);
		int res = calculate(rpnList);
		System.out.println(suffixExpression+" = "+ res);*/
		
	}
	
	
	
	//将中缀表达式转换为后缀表达式
	public static List<String> parseSuffixExpressionList(List<String> list){
		//定义两个栈
		Stack<String> stack1 = new Stack<String>();//符号栈
		//其实可以使用第二个栈来保存数字，但是第二个栈从头到尾都不会POP数据，
		//所以为了避免麻烦就不用栈来保存数据了直接使用List<String>即可
		List<String> ls = new ArrayList<String>();
		
		//遍历list
		for(String item:list) {
			//接下来就是判断，如果是一个数，就加入到ls,用正则表达式来判断
			if(item.matches("\\d+")) {
				 ls.add(item);
			}else if(item.equals("(")) {
				stack1.push(item);
			}else if(item.equals(")")) {
				//如果是右括号")",就一直pop，一直到碰到弹出的第一个左括号即停止，此时舍弃这一对括号
				while(!stack1.peek().equals("(")) {
					ls.add(stack1.pop());
				}
				stack1.pop();//将(括号弹出stack1这个栈,消除括号
			}else {
				//优先级:当item的优先级小于等于stack1的栈顶的运算符的优先级
				//此时将stack1栈顶的运算符弹出并添加到ls中，然后再循环
				//缺少判断优先级的方法
				while(stack1.size() != 0 && Opertion.getValue(stack1.peek()) >= Opertion.getValue(item)) {
						ls.add(stack1.pop());
				}
				//还需要将item压入栈中
				stack1.push(item);
				
			}
		}
		//将stack1中剩余的运算符一次弹出并加入ls
		while(stack1.size()!=0) {
			ls.add(stack1.pop());
		}
		return ls;
	}
	
	
	//方法：将中缀表达式转成对应的List
	public static List<String> toInfixExpressionList(String expression){
		//先定义一个List，存放中缀表达式对应的内容
		List<String> ls = new ArrayList<String>();
		int index=0;//索引是一个指针用于遍历表达式expression
		String str;//用于做拼接【对于多位数而言，前面也写过】
		char c;//每遍历到一个字符，就放入到c
		do {
			//如果c是一个非数字,那就需要加入到ls中
			if((c=expression.charAt(index)) < 48 || (c=expression.charAt(index)) > 57) {
				ls.add(""+ c);
				index++;//index后移
			}else {//如果是一个数，需要考虑多位数的问题
				str = "";//先将str置空
				
				while(index < expression.length() && (c=expression.charAt(index))>=48 && (c=expression.charAt(index))<=57) {
					str += c;
					index++;
				}
				ls.add(str);
			}
		}while(index < expression.length());
		//由于do-while循环所以先执行后判断，故为小于号而不是小于等于号
		return ls;
	}
	
	
	
	//将逆波兰表达式，依次将数据和运算符 放入到ArrayList中
	public static List<String> getListString(String suffixExpression){
		//将表达式分割
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele: split) {
			list.add(ele);
		}
		return list;
	}
	
	//完成对逆波兰表达式的运算
	/**
	 *  1)从左至右扫描，将3和4压入堆栈
	 *  2)遇到+运算符，因此弹出4和3(4为栈顶元素，3为次顶元素)，
	 *    计算出3+4的值为7，再将7压入栈中
	 *  3)将5入栈
	 *  4)接下来是x运算符，因此弹出5和7计算出5x7=35，将35入栈
	 *  5)将6入栈；
	 *  6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果  
	 */
	public static int calculate(List<String> ls) {
		//创建一个栈,只需要一个栈即可.
		Stack<String> stack = new Stack<String>();
		//遍历list
		for(String item: ls) {
			//这里使用正则表达式来取出值
			if(item.matches("\\d+")) {//匹配的是多位数
				//入栈
				stack.push(item);
				
			}else {//运算符
				//pop出两个数并运算，再入栈
				//首先弹出data2
				int data2 = Integer.parseInt(stack.pop());
				int data1 = Integer.parseInt(stack.pop());
				int res = 0;
				if(item.equals("+")) {
					res = data1 + data2;
				}else if(item.equals("-")) {
					res = data1-data2;
				}else if (item.equals("x")) {
					res = data1*data2;
				}else if(item.equals("/")) {
					res = data1/data2;
				}else {
					System.out.println("输入有误");
					throw new RuntimeException("运算符有误");
				}
				
				//把res入栈
				stack.push(""+res);
			}
		}
		//最后留在stack中的数据就是运算结果
		return Integer.parseInt(stack.peek());
	}
	
}


//判断优先级的Operation类, 可以返回运算符对应的优先级
class Opertion{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	
	//写一个方法返回对应的优先级数字
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "x":
			result = MUL;
			break;	
		case "/":
			result = DIV;
			break;	
		default:
			/*System.out.println("不存在该运算符(当前位置可能是括号)");*/
			break;
		}
		return result;
	}
	
}








