package com.qtatelier.sort.insertSort;

import java.util.Arrays;

public class InsertSort {
	
	public static void main(String[] args) {
/*		int [] arr= {101,34,119,1};
		int [] arrOrder = insertSort(arr);
		System.out.println(Arrays.toString(arrOrder));*/
		
		//测试80000个数的排序速度
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//生成一个[0,8000000)随机数
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("直接插入排序,执行80000个数的排序运行了:");
		
		optimizeInsertSort(randomArr);

		long time2 = System.currentTimeMillis();
		
		System.out.println((time2-time)/1000+"秒");//1s左右比选择排序慢一点
	}
	
	
	
	

	/**
	 * 正常的插入排序
	 * 
	 * 时间复杂度为O(n^2)
	 * 
	 * @param arr
	 * @return
	 */
	
	public static int[] insertSort(int[] arr) {
		int insertVal = 0;
		int insertIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i - 1;
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			arr[insertIndex + 1] = insertVal;
		}
		return arr;
	}
	
	
	/**
	 * 优化之后的插入排序
	 * 时间复杂度O(n^2)
	 * @return
	 */
	public static int[] optimizeInsertSort(int[] arr) {
		int insertVal = 0;
		int insertIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i - 1;
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			// 优化判断是否需要赋值
			if (insertIndex != i - 1) {
				arr[insertIndex + 1] = insertVal;
			}
		}
		return arr;
	}
	
	
	
	
	
	/**
	 * 按步骤推导来进行插入排序
	 * @param arr
	 * 
	 * 详细解释插入排序.
	 * 首先,本质上来说是将一个数组分成两个部分，一个是有序的部分，一个是无序的部分
	 * 【这里详解从小到大，从大到小也同理】
	 * 然后,有序部分默认是数组的第一个元素,将数组的第二个元素搞出来,并做好索引下标
	 * 将之与之前的每一个数做一个比较如果比前一个数字小,那么就将前一个数字的向后移，
	 * 直到不满足while循环条件【1.该元素前面已经没有了元素 2.该元素的所在值>=前一个元素】
	 * 跳出循环,将元素插入到当前的位置。
	 * 
	 */
	public static void insertSortByStep(int arr[]) {
		//第一轮
		//先定义待插入的数
		int insertVal = arr[1];
		int insertIndex = 1 - 1;//即arr[1]的前面这个数的下标
		
		//给insertValue找到插入的位置
		//1.insertIndex>=0保证在给insertValue 找插入位置的时候不越界。
		//2.insertVal < arr[insertIndex]待插入的数,还没有找到插入的位置
		//3.就需要将arr[insertIndex]后移
		while(insertIndex >= 0 && insertVal < arr[insertIndex]) {//两个都要满足才能为true
			arr[insertIndex+1] = arr[insertIndex];
			insertIndex--;
		}
		//当退出while循环的时候，那么插入的位置就找到
		arr[insertIndex+1] = insertVal;
		
		System.out.println("第一轮插入之后:");
		System.out.println(Arrays.toString(arr));
	
	
	
		//第二轮
		//先定义待插入的数
		 insertVal = arr[2];
		 insertIndex = 2 - 1;//即arr[1]的前面这个数的下标
		
		//给insertValue找到插入的位置
		//1.insertIndex>=0保证在给insertValue 找插入位置的时候不越界。
		//2.insertVal < arr[insertIndex]待插入的数,还没有找到插入的位置
		//3.就需要将arr[insertIndex]后移
		while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
			arr[insertIndex+1] = arr[insertIndex];
			insertIndex--;
		}
		//当退出while循环的时候，那么插入的位置就找到
		arr[insertIndex+1] = insertVal;
		
		System.out.println("第二轮插入之后:");
		System.out.println(Arrays.toString(arr));
		
		
		
		//第三轮
		//先定义待插入的数
		 insertVal = arr[3];
		 insertIndex = 3 - 1;//即arr[1]的前面这个数的下标
		
		//给insertValue找到插入的位置
		//1.insertIndex>=0保证在给insertValue 找插入位置的时候不越界。
		//2.insertVal < arr[insertIndex]待插入的数,还没有找到插入的位置
		//3.就需要将arr[insertIndex]后移
		while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
			arr[insertIndex+1] = arr[insertIndex];
			insertIndex--;
		}
		//当退出while循环的时候，那么插入的位置就找到
		arr[insertIndex+1] = insertVal;
		
		System.out.println("第三轮插入之后:");
		System.out.println(Arrays.toString(arr));
		
		
		
		
		
		
		
		
		
		
	
	}
}
