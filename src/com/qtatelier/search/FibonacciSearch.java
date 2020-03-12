package com.qtatelier.search;

import java.util.Arrays;
/**
 * 通过斐波那契数列中的值来寻找分割点来查找数据
 * 所以斐波那契数列内的数值就是需要查找数组的下标
 * 时间复杂度:O(n*Log(n))
 * @author JazzXdh
 *
 */
public class FibonacciSearch {
	public static int maxSize = 20;

	public static void main(String[] args) {
		
		int[] arr = { 1, 8, 10, 89, 1000, 1234 };
		 System.out.println(fibSearch(arr, 1));
	}

	
	/*
	      f[k]  = f[k-1] + f[k-2] 
	           这个既代表了斐波那契数列的表达式 1,1,2,3,5,8,13,21....
	           也代表了一个数组的长度
	      1.设data[i]为有序数列，i=0,1…n-1;计算斐波那契数列前m项，m是保证fib[m]>=n的最小数。

     2.low=0,high=n-1;

     3.mid=low+fib[m-1]-1

         如果data[mid]>key,则说明可能在左半部分，m=m-1;

         如果data[mid]<key,则说明可能在右半部分，m=m-2;

         则否找到key，正确定位即可。

    该算法的时间复杂度为O(n*Log(n))，和二分查找一样，但可以避开除法运算，在计算机中除法运算的占用资源比加减高得多。当然在很多时候可以用位运算避开除2运算。
	
	      原理：
	        1）当key=a[mid]时，查找成功；
	        2）当key<a[mid]时，新的查找范围是第low个到第mid-1个，此时范围个数为f[k-1] - 1个，即数组左边的长度，
	           所以要在[low, f[k - 1] - 1]范围内查找；
	        3）当key>a[mid]时，新的查找范围是第mid+1个到第high个，此时范围个数为f[k-2] - 1个，即数组右边的长度，
	           所以要在[f[k - 2] - 1,high]范围内查找。
	        4)  对于二分查找，分割是从mid= (low+high)/2开始；而对于斐波那契查找，分割是从mid = low + f[k-1] - 1开始的；
	            通过上面知道了，数组a现在的元素个数为f[k]-1个，即数组长为f[k]-1，mid把数组分成了左右两部分， 
	            左边的长度为：f[k-1] - 1， 那么右边的长度就为（数组长-左边的长度-1）， 
	            即：（f[k]-1） - （f[k-1] - 1） = f[k] - f[k-1] - 1 = f[k-2] - 1。  
	*/
	
	
	// 因为后面我们mid= low + F(k-1)-1,需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
	// 非递归的方法得到一个斐波那契数列
	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		return f;
	}
	
	//斐波那契查找算法
	//使用非递归的方式编写
	/**
	 * 
	 * @param a 数组
	 * @param key 目标值
	 * @return 返回对应下标
	 */
	public static int fibSearch(int[] a, int key) {
		int low = 0;//表示数组的第一个序列号
		
		int high = a.length-1;//表示数组的最高序列号
		
		int k = 0;//表示斐波那契分割数值的下标
		
		int mid = 0;//存放mid值
		
		int f[] = fib();//获取到斐波那契数列
		
		//获取斐波那契分割数值的下标
		while(high >f[k]-1) {
			k++;
		}
		//因为f[k]的值可能大于数组a 的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
		//不足的部分会使用0填充
		int[] temp = Arrays.copyOf(a, f[k]);
		//实际上，需要a数组最后的数来填充
		for (int i = high + 1; i < temp.length; i++) {
			temp[i] = a[high];
		}
		
		// 使用while循环来处理，找到我们所需要的key
		while (low <= high) {// 只要满足这个条件就可以一直寻找
			
			mid = low + f[k - 1] - 1;
			
			if(key < temp[mid]) {//说明我们应该向数组的前面查找(左边)
				//[low, F[k - 1] - 1]范围内查找
				high = mid - 1;
				
				//解释k--的原因
				//1.全部元素 = 前面的元素 + 后边的元素
				//2.f[k] = f[k-1]+ f[k-2]
				//因为 前面有 f[k-1]个元素，所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
				//即在f[k-1]的前面继续查找 k--
				//即下次循环mid =  f[k - 1 - 1] - 1;
				k--;
			}else if( key > temp[mid]){//我们应该继续想数组的后面查找(右边)
				//
				low = mid + 1;
				
				//为什么k-2
				//解释
				//1.全部元素 =前面元素 + 后面元素
				//2.f[k] = f[k-1]+ f[k-2]
				//3.因为后面我们有f[k-2] 所以可以继续拆分f[k-1] = f[k-3] + f[k-4]
				//4.在f[k-2]的前面进行查找 k-=2
				//5.即下次循环 mid = f[k - 1 - 2] - 1
				k -= 2;
			} else {//找到
				//需要确定返回的是哪个下标
				if(mid <= high) {
					return mid;
				}else {
					return high;
				}
				
			}
		}
		return -1;
	}
	
}
