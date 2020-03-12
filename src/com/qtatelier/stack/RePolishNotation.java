package com.qtatelier.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class RePolishNotation {

	public static void main(String[] args) {
		
		//��ɽ�һ����׺���ʽת����Ϊ��׺���ʽ�Ĺ���
		//˵��
		//1. 1+((2+3)x4)-5 ת��1 2 3 + 4 x + 5 -
		//2.��Ϊֱ�Ӷ�str���в�����̫���㡣
		//  ����׺���ʽת��Ϊ���õ�List 
		//3.���õ�����׺���ʽ��Ӧ��Listת��Ϊ��׺���ʽ��Ӧ��List
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ����ı��ʽ�����Դ����š�");
		String expression = scanner.nextLine();
		List<String> infixExpressionList =  toInfixExpressionList(expression);
		System.out.println("��׺���ʽת��ΪList�Ľ��Ϊ: "+infixExpressionList);
		List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
		System.out.println("��׺���ʽת��Ϊ��׺���ʽ�Ľ��Ϊ: "+parseSuffixExpressionList);
		int res = calculate(parseSuffixExpressionList);
		System.out.println(expression+" = "+ res);
		scanner.close();
/*		//�ȶ����沨�����ʽ����׺���ʽ��
		//(30+4)x5-6ת��Ϊ��׺���ʽ 30 4 + 5 x 6 -
		//4 * 5 - 8 + 60 +8 / 2ת��Ϊ��׺���ʽ4 5 * 8 - 60 + 8 2 / + =76
		//��ÿ���ַ�֮���ÿո����������ָ�
		String suffixExpression = "1 2 3 + 4 x + 5 -";
		//�ⷨ
		//1.�Ƚ����ʽ���뵽ArrayList��
		//2.��ArrayList ���ݸ�һ������,���ջ��ɼ���
		
		List<String> rpnList = getListString(suffixExpression);
		System.out.println(rpnList);
		int res = calculate(rpnList);
		System.out.println(suffixExpression+" = "+ res);*/
		
	}
	
	
	
	//����׺���ʽת��Ϊ��׺���ʽ
	public static List<String> parseSuffixExpressionList(List<String> list){
		//��������ջ
		Stack<String> stack1 = new Stack<String>();//����ջ
		//��ʵ����ʹ�õڶ���ջ���������֣����ǵڶ���ջ��ͷ��β������POP���ݣ�
		//����Ϊ�˱����鷳�Ͳ���ջ������������ֱ��ʹ��List<String>����
		List<String> ls = new ArrayList<String>();
		
		//����list
		for(String item:list) {
			//�����������жϣ������һ�������ͼ��뵽ls,��������ʽ���ж�
			if(item.matches("\\d+")) {
				 ls.add(item);
			}else if(item.equals("(")) {
				stack1.push(item);
			}else if(item.equals(")")) {
				//�����������")",��һֱpop��һֱ�����������ĵ�һ�������ż�ֹͣ����ʱ������һ������
				while(!stack1.peek().equals("(")) {
					ls.add(stack1.pop());
				}
				stack1.pop();//��(���ŵ���stack1���ջ,��������
			}else {
				//���ȼ�:��item�����ȼ�С�ڵ���stack1��ջ��������������ȼ�
				//��ʱ��stack1ջ�����������������ӵ�ls�У�Ȼ����ѭ��
				//ȱ���ж����ȼ��ķ���
				while(stack1.size() != 0 && Opertion.getValue(stack1.peek()) >= Opertion.getValue(item)) {
						ls.add(stack1.pop());
				}
				//����Ҫ��itemѹ��ջ��
				stack1.push(item);
				
			}
		}
		//��stack1��ʣ��������һ�ε���������ls
		while(stack1.size()!=0) {
			ls.add(stack1.pop());
		}
		return ls;
	}
	
	
	//����������׺���ʽת�ɶ�Ӧ��List
	public static List<String> toInfixExpressionList(String expression){
		//�ȶ���һ��List�������׺���ʽ��Ӧ������
		List<String> ls = new ArrayList<String>();
		int index=0;//������һ��ָ�����ڱ������ʽexpression
		String str;//������ƴ�ӡ����ڶ�λ�����ԣ�ǰ��Ҳд����
		char c;//ÿ������һ���ַ����ͷ��뵽c
		do {
			//���c��һ��������,�Ǿ���Ҫ���뵽ls��
			if((c=expression.charAt(index)) < 48 || (c=expression.charAt(index)) > 57) {
				ls.add(""+ c);
				index++;//index����
			}else {//�����һ��������Ҫ���Ƕ�λ��������
				str = "";//�Ƚ�str�ÿ�
				
				while(index < expression.length() && (c=expression.charAt(index))>=48 && (c=expression.charAt(index))<=57) {
					str += c;
					index++;
				}
				ls.add(str);
			}
		}while(index < expression.length());
		//����do-whileѭ��������ִ�к��жϣ���ΪС�ںŶ�����С�ڵ��ں�
		return ls;
	}
	
	
	
	//���沨�����ʽ�����ν����ݺ������ ���뵽ArrayList��
	public static List<String> getListString(String suffixExpression){
		//�����ʽ�ָ�
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele: split) {
			list.add(ele);
		}
		return list;
	}
	
	//��ɶ��沨�����ʽ������
	/**
	 *  1)��������ɨ�裬��3��4ѹ���ջ
	 *  2)����+���������˵���4��3(4Ϊջ��Ԫ�أ�3Ϊ�ζ�Ԫ��)��
	 *    �����3+4��ֵΪ7���ٽ�7ѹ��ջ��
	 *  3)��5��ջ
	 *  4)��������x���������˵���5��7�����5x7=35����35��ջ
	 *  5)��6��ջ��
	 *  6)�����-������������35-6��ֵ����29���ɴ˵ó����ս��  
	 */
	public static int calculate(List<String> ls) {
		//����һ��ջ,ֻ��Ҫһ��ջ����.
		Stack<String> stack = new Stack<String>();
		//����list
		for(String item: ls) {
			//����ʹ��������ʽ��ȡ��ֵ
			if(item.matches("\\d+")) {//ƥ����Ƕ�λ��
				//��ջ
				stack.push(item);
				
			}else {//�����
				//pop�������������㣬����ջ
				//���ȵ���data2
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
					System.out.println("��������");
					throw new RuntimeException("���������");
				}
				
				//��res��ջ
				stack.push(""+res);
			}
		}
		//�������stack�е����ݾ���������
		return Integer.parseInt(stack.peek());
	}
	
}


//�ж����ȼ���Operation��, ���Է����������Ӧ�����ȼ�
class Opertion{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	
	//дһ���������ض�Ӧ�����ȼ�����
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
			/*System.out.println("�����ڸ������(��ǰλ�ÿ���������)");*/
			break;
		}
		return result;
	}
	
}








