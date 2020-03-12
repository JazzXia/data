package com.qtatelier.recursion;
/**
 * 使用回溯解决八皇后
 * 后面还会使用贪心算法来解决
 * @author JazzXdh
 *
 */
public class EightQueen {

	//定义一个max表示共有多少个皇后
	int max = 8;
	//定义数组array，保存皇后放置位置的结果
	//比如其中一种结果是arr = {0,4,7,5,2,6,1,3}，
	//每一个数字所占的位置是对应的行，
    //而位置上数字的值则是对应的列数
	int[] array = new int[max];
	static int count = 0;
	static int total = 0;
	public static void main(String[] args) {
		EightQueen eight = new EightQueen();
		eight.set(0);
		System.out.println("总共运行了"+total+"次");
		System.out.println("一共有"+count+"种解法");
	}
	
	
	
	//编写一个方法，放置第n个皇后
	
	private void set(int n) {
		if(n == max) { // n = 8,其实8个皇后就已经放完了
			count++;
			print();
			return;
		}
		//依次放入皇后并判断是否冲突
		for(int i=0;i < max;i++) {
			//判断一共跑了多少次
			total++;
			//先把当前这个皇后n，放到该行的第1列
			array[n] = i;
			//当放置第n个皇后到i列时，是否冲突
			if(judge(n)) {
				//接着放第n+1个皇后,即开始递归
				set(n+1);
			}
			//如果冲突,即将第n个皇后放置在本行的后移的一个位置
		}
	}
	
	
	
	

	//查看当我们放置第n个皇后,就去检测该皇后是否和前面已经摆放的皇后冲突
	/**
	 * 
	 * @param n 表示放置的第n个皇后
	 * @return
	 */
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			//首先array[i] == array[n]是列相同
			//然后后面Math.abs(n-i) == Math.abs(array[n]- array[i])
			//       假设第n行的n为5 第i行的i是3 那么5-3的绝对值为2
			//           第n行的列的位置是array[n]
			//           第i行的列的位置是array[i]
			//只要行之间的差等于列之间的差其实就是一个斜率为1的直线，也就是夹角为45°
			//意味着这两个皇后在一个斜线上。
			
			//没有必要判断是否在同一行，因为数组每次都在递增,每一行只能放一个数
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]- array[i])) {
				return false;
			}
		}
		return true;

	}
	
	//写一个方法，可以将皇后摆放的位置输出
	private void print() {
		for(int i = 0; i< array.length;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
