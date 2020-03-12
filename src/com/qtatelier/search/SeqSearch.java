package com.qtatelier.search;

public class SeqSearch {
	public static void main(String[] args) {
		int arr[] = { 1, 9, 11, -1, 34, 89 };
		int index = seqSearch(arr, 11);
		if (index == -1) {
			System.out.println("没有找到");
		} else {
			System.out.println("找到，下标=" + index);
		}
	}

	/**
	 * 这里是实现的线性查找是找到一个满足条件的值，就返回 如果要返回所有的值,遍历所有下标,如果值相同,将下标放到集合中即可。
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int seqSearch(int[] arr, int value) {
		// 线性查找是逐一比对，发现有相同的值时，就返回下标
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

}
