package com.qtatelier.Searchcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchCollections {
	static int count = 0;
	static int add = 0;
	static int num = 0;
	public static void main(String[] args) {
		//自动生成1~100的数组
/*		int[] arr = new int[100];
		for (int i = 0; i <= 99; i++) {
			arr[i] = i + 1;
		}*/
		
		int arr[] = { 1, 8, 10, 89,1000, 1234 };
		//线性查找
		int index = seqSearch(arr, 89);
		if (index == -1) {
			System.out.println("没有找到");
		} else {
			System.out.println("找到，下标=" + index);
		}
		System.out.println("查找次数:"+ count);
		
		
		//二分查找
		List<Integer> resIndex = binary(arr, 0, arr.length-1,89);
		if(resIndex == null) {
			System.out.println("没有所找的序列!!!");
		}else {
			System.out.println("下标:"+ resIndex);
		}
		System.out.println("查找次数:"+ add);
		
		
		//插入查找
		int index1 = insertValueSearch(arr, 0, arr.length-1, 89);
		if (index1 != -1) {
			System.out.println("下标为:" + index1);
		}else {
			System.out.println("对不起，没有要找的下标");
		}
		System.out.println("查找次数:"+ num);
		System.out.println("原数组为：" + Arrays.toString(arr));
		
		
		
		
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
			count++;
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	//多个数的二分查找
	//擅长分布不均匀
	/**
	 * 
	 * @param arr 数组
	 * @param left 左边的索引
	 * @param right 右边的索引
	 * @param findVal 要查找的值
	 * @return 如果找到就返回下标，如果没有就返回-1
	 */
	public static List<Integer> binary(int[] arr,int left,int right,int findVal) {
		add++;
		if(left>right) {
			return null;
		}
		int mid = (left + right) /2;
		int midVal = arr[mid];
		if(findVal > midVal) {//向右递归
			return binary(arr, mid+1, right, findVal);
		}else if(findVal < midVal){//向左递归
			return binary(arr, left, right-1, findVal);
		}else{
			/**
			 *  思路分析
			 * 1.在找到mid索引值，不要马上返回
			 * 2.向mid索引值的左边扫描，将所有满足查找值的元素的下标加入集合中
			 * 3.向mid索引值的右边扫描，将所有满足查找值的元素的下标加入集合中
			 * 4.返回
			 */
			List<Integer> res = new ArrayList<Integer>();
			//向mid左边扫描，寻找1000
			int temp = mid -1;
			while(true) {
				if(temp < 0 || arr[temp] != findVal) {
					break;
				}
				res.add(temp);
				temp -= 1;//temp左移
			}
			res.add(mid);
			
			//向mid右边扫描，寻找1000
			temp = mid + 1;
			while(true) {
				if(temp > arr.length-1 || arr[temp] != findVal) {
					break;
				}
				res.add(temp);
				temp += 1;//temp左移
			}
			return res;
		}
	}
	
	//插值查找算法
	//说明：插值查找算法，也要求数组有序的。
	//擅长分布均匀
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
		}else if(findVal < midVal) {//说明应该向左边递归
			return insertValueSearch(arr, left, mid-1, findVal);
		}else {
			return mid;
		}
	}
	
}
