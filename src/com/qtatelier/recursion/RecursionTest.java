package com.qtatelier.recursion;

public class RecursionTest {
	public static void main(String[] args) {
		//ͨ����ӡ���⣬�ع˵ݹ�ĵ��û���
		test(4);//console: 2 3 4
		System.out.println(factorial(5));//5*4*3*2*1
	}

	
	public static void test(int n) {
		if (n > 2) {
			test(n - 1);
		}
		//else {
		System.out.println("n=" + n);
		
		//����Ǽ���else��ô�������consoleΪn=2
		//��Ϊif��else�Ƕ�ѡһ����ֻ�����һ��
		
		//}
	}
	
	
	public static int factorial(int n) {
		if(n==1) {
			return 1;
		}else {
			return factorial(n-1)*n;
		}
	}
}