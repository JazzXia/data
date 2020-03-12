package com.qtatelier.sort.selectSort;

import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
/*		int arr[] = { 101, 34, 119, 1 };
		selectSortByStep(arr);
		
		System.out.println("排序后的数组为:");
		System.out.println(Arrays.toString(selectSort(arr)));*/
		
		
		/**
		 * 测试80000个数的性能
		 */
		
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//生成一个[0,8000000)随机数
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("选择排序执行80000个数的排序运行了:");
		
		selectSort(randomArr);

		long time2 = System.currentTimeMillis();
		
		System.out.println((time2-time)/1000+"秒");//1s左右
		//【虽然时间复杂度都是O(n^2),但是由于选择排序的双层循环里的语句比冒泡排序的少,所以速度快】
		
	}

	/**
	 * 选择排序
	 * 
	 * 时间复杂度O(n^2)
	 * 
	 * @param arr 参数是一个要排序的数组
	 *            
	 * @return 返回值是一个数组
	 */
	public static int[] selectSort(int[] arr) {
		int minIndex = 0;
		int min = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			min = arr[i];
			for (int j = 1+i; j < arr.length; j++) {
				if (min > arr[j]) { // 说明假定的最小值，并不是最小值
					min = arr[j];// 重置最小值
					minIndex = j;// 重置最小值的索引
				}
			}
			// 将最小值放在arr[0],即交换
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}

		}
		return arr;

	}

	/**
	 * 
	 *  选择排序分步执行
	 * @param arr
	 */
	public static void selectSortByStep(int[] arr) {
		// 使用逐步推导的方式
		// 第一轮
		// 原始数组： 101,34,119,1
		// 第一轮顺序：1,34,119,101
		// 算法 先简单--->复杂【化繁为简】

		int minIndex = 0;
		int min = arr[minIndex];
		for (int j = 1; j < arr.length; j++) {
			if (min > arr[j]) { // 说明假定的最小值，并不是最小值
				min = arr[j];// 重置最小值
				minIndex = j;// 重置最小值的索引
			}
		}
		// 将最小值放在arr[0],即交换
		if(minIndex != 0) {
		arr[minIndex] = arr[0];
		arr[0] = min;
		}
		
		System.out.println("第一轮后：");
		System.out.println(Arrays.toString(arr));
		
		
		
		
		
		//第二轮
		 minIndex = 1;
		 min = arr[minIndex];
		for (int j = 1+1; j < arr.length; j++) {
			if (min > arr[j]) { // 说明假定的最小值，并不是最小值
				min = arr[j];// 重置最小值
				minIndex = j;// 重置最小值的索引
			}
		}
		// 将最小值放在arr[0],即交换
		if(minIndex != 1) {
		arr[minIndex] = arr[1];
		arr[1] = min;
		}
		
		System.out.println("第二轮后：");
		System.out.println(Arrays.toString(arr));
		
		
		
		
		
		
		//第三轮
		 minIndex = 2;
		 min = arr[minIndex];
		for (int j = 1+1+1; j < arr.length; j++) {
			if (min > arr[j]) { // 说明假定的最小值，并不是最小值
				min = arr[j];// 重置最小值
				minIndex = j;// 重置最小值的索引
			}
		}
		// 将最小值放在arr[0],即交换
		if(minIndex != 2) {
		arr[minIndex] = arr[2];
		arr[2] = min;
		}
		
		System.out.println("第三轮后：");
		System.out.println(Arrays.toString(arr));
		
	}

}
