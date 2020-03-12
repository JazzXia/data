package com.qtatelier.search;

//注意:使用二分查找的前提是该数组是有序的
public class BinarySearch {
	public static void main(String[] args) {
		
		int arr[] = { 1, 8, 10, 89, 1000, 1234 };
		int resIndex = binary(arr, 0, arr.length-1,1000);
		if(resIndex == -1) {
		System.out.println("没有所找的序列!!!");
		}else {
			System.out.println(resIndex);
		}
	}
	
	//二分查找
	/**
	 * 
	 * @param arr 数组
	 * @param left 左边的索引
	 * @param right 右边的索引
	 * @param findVal 要查找的值
	 * @return 如果找到就返回下标，如果没有就返回-1
	 */
	public static int binary(int[] arr,int left,int right,int findVal) {
		if(left>right) {
			return -1;
		}
		int mid = (left + right) /2;
		int midVal = arr[mid];
		if(findVal > midVal) {//向右递归
			return binary(arr, mid+1, right, findVal);
		}else if(findVal < midVal){//向左递归
			return binary(arr, left, right-1, findVal);
		}else{
			return mid;
		}
	}
}




//思考题：解答见BinarySearchTest
/* { 1, 8, 10, 89, 1000, 1000, 1234 };
 * 有多个相同数值时，如何将所有的数值都查找到，比如1000
 * 
 * 思路分析
 * 1.在找到mid索引值，不要马上返回
 * 2.向mid索引值的左边扫描，将所有满足查找值的元素的下标加入集合中
 * 3.向mid索引值的右边扫描，将所有满足查找值的元素的下标加入集合中
 * 4.返回
 */
