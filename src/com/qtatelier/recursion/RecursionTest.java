package com.qtatelier.recursion;

public class RecursionTest {
	public static void main(String[] args) {
		//通过打印问题，回顾递归的调用机制
		test(4);//console: 2 3 4
		System.out.println(factorial(5));//5*4*3*2*1
	}

	
	public static void test(int n) {
		if (n > 2) {
			test(n - 1);
		}
		//else {
		System.out.println("n=" + n);
		
		//如果是加上else那么结果就是console为n=2
		//因为if和else是二选一所以只能输出一个
		
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