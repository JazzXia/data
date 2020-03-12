package com.qtatelier.search;

import java.util.Arrays;

public class InsertValueSearch {
    static int num = 0;
	public static void main(String[] args) {

		int[] arr = new int[100];
		for (int i = 0; i <= 99; i++) {
			arr[i] = i + 1;
		}
		int index = insertValueSearch(arr, 0, arr.length-1, 66);
		if (index != -1) {
			System.out.println("下标为:" + index);
		}else {
			System.out.println("对不起，没有要找的下标");
		}
		System.out.println("原数组为：" + Arrays.toString(arr));
		System.out.println("查找次数:"+ num);
	}
	
	//插值查找算法
	//说明：插值查找算法，也要求数组有序的。
	/**
	 * 
	 * @param arr 数组
	 * @param left 左边索引
	 * @param right 右边索引
	 * @param findVal 查找值
	 * @return
	 */
	public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
		num++;
		//注意：indVal < arr[0] || findVal > arr.length - 1必须需要，否则我们得到的mid可能越界。
		if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
			return -1;
		}
		//求出mid
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		if(findVal > midVal) {//说明应该向右边递归
			return insertValueSearch(arr, mid+1, right, findVal);
		}else if(findVal < midVal) {
			return insertValueSearch(arr, left, mid-1, findVal);
		}else {
			return mid;
		}
	}
	
}
