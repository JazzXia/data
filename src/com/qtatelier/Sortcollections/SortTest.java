package com.qtatelier.Sortcollections;

import java.util.Arrays;

/**
 * 默写内部排序算法
 *交换排序：冒泡和快速排序
 *选择排序：简单选择排序和堆排序
 *插入排序：直接插入排序和希尔排序
 *归并排序
 *基数排序【桶排序的升级版】
 *
 * 
 * @author JazzXdh
 *
 */
public class SortTest {

	public static void main(String[] args) {
		
		int arr[] = { 3, 9, -1, 10, -2 };
		/**
		 * 普通的冒泡
		 */
		System.out.println("普通冒泡的最后结果是");
		System.out.println(Arrays.toString(BubbleSort(arr)));
	
		
		
		int arr2[] = { -100, 900, -10086, 1540, -2121 };
		/**
		 * 优化之后的冒泡
		 */
		System.out.println("大幅度优化之后的冒泡的最后结果:");
		System.out.println(Arrays.toString(optimizeBubbleSort(arr2)));
		
		
		
		
		int arr3[] = {-99,55,66,100,-998,54,545};
		/**
		 * 选择排序
		 */
		System.out.println("选择排序的最后结果:");
		System.out.println(Arrays.toString(SelectSort(arr3)));
		
		
		
		
		int arr4[] = {-99,55,66,100,-998,54,545};
		/**
		 * 插入排序
		 */
		System.out.println("普通插入排序的最后结果:");
		System.out.println(Arrays.toString(InsertSort(arr4)));
		
		
		
		int arr5[] = {283, 468, 549, 570, 229, 213, 432, 137};
		/**
		 * 优化后的插入排序
		 */
		System.out.println("不明显优化后的插入排序的最后结果:");
		System.out.println(Arrays.toString(optimizeInsertSort(arr5)));
		
		
		/**
		 * 希尔排序的第一种排序方式[交换的方式]
		 */
		int arr6[] = { 283, 468, 549, 570, 229, 213, 432, 137, 10086, 996 };
		System.out.println("希尔排序的第一种排序方式[交换的方式]:");
		System.out.println(Arrays.toString(ChangeShellSort(arr6)));
		
		
		/**
		 * 希尔排序的第二种排序方式[移位的方式]
		 */
		int arr7[] = { 283, 468, 549, 570, 229, 213, 432, 137, 10086, 996 };
		System.out.println("希尔排序的第一种排序方式[交换的方式]:");
		System.out.println(Arrays.toString(MoveShellSort(arr7)));
		
		
		/**
		 * 快速排排序
		 */
		int arr8[] = { 283, 229, 549, 570, 229, 213, 432, 137, 10086, 996 };
		System.out.println("快速排排序:");
		System.out.println(Arrays.toString(QuickSort(arr8, 0, arr8.length-1)));
		
		
		
		/**
		 * 归并排序
		 */
		int arr9[] = { 283, 229, 549, 570, 229, 213, 432, 137, 10086, 996 };
		int [] temp = new int[arr9.length];
		System.out.println("归并排排序:");
		System.out.println(Arrays.toString(mergeSort(arr9, 0, arr9.length-1, temp)));
		
		
		
		
		
		/**
		 * 基数排排序
		 */
		int arr10[] = { 283, 229, 549, 570, 229, 213, 432, 137, 10086, 996 };
		System.out.println("基数排排序:");
		System.out.println(Arrays.toString(radixSort(arr10)));
	}
	
	
	/**
	 * 基数排序
	 * 时间复杂度O(n*k)
	 * 
	 * @param arr
	 * @return
	 */
	
	
	public static int[] radixSort(int[] arr) {

		//1.得到数组中最大的数的位数
		int max = arr[0];
		for(int i = 1;i < arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		int maxLength = (max + "").length();
		
		
		int[][] bucket = new int[10][arr.length];

		int[] bucketElementCounts = new int[10];

		int index;

		for (int i = 0,n=1; i < maxLength; i++ , n *= 10) {
			for (int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j] / n % 10;
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			index = 0;
			for (int k = 0; k < bucket.length; k++) {
				if (bucketElementCounts[k] != 0) {
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						arr[index++] = bucket[k][l];
					}

				}
				bucketElementCounts[k] = 0;
			}
		}
		return arr;
	}
	
	
	
	
	
	
		/**
		 *  归并排序(分治和递归的思想) 
		 *  
		 *  时间复杂度O(N*logN)
		 *  
		 * @param arr
		 * @param left
		 * @param right
		 * @param temp
		 */
	
		//分+合的方法
		public static int[] mergeSort(int[] arr, int left,int right,int[] temp) {
			if(left < right) {
				int mid = (left + right)/2;//中间的索引
				//向左递归进行分解
				mergeSort(arr, left, mid, temp);
				//向右递归进行分解
				mergeSort(arr, mid+1, right, temp);
				//到合并时
				merge(arr, left, mid, right, temp);
			}
			return arr;
		}
		//合并的方法
		/**
		 * 
		 * @param arr 待排序的数组
		 * @param left 左边有序序列的初始索引
		 * @param mid	中间索引
		 * @param right 右边索引
		 * @param temp  做中转的数组
		 */
		public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
			int i = left;// 初始化i，左边有序序列的初始索引
			int j = mid + 1;// 初始化j表示右边有序序列的初始索引
			int t = 0; // 指向temp中转数组的索引

			// (一)
			// 先把左右(有序序列)两边的数据按照规则填充到temp数组
			// 直到左右两边的有序序列,有一边处理完毕为止
			while (i <= mid && j <= right) {// 继续
				// 如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
				// 即将左边的元素，拷贝到temp数组
				// 然后t++,i++
				if (arr[i] <= arr[j]) {
					temp[t] = arr[i];
					t += 1;
					i += 1;
				} else {// 反之，将右边的有序序列的当前元素填充到temp数组
					temp[t] = arr[j];
					t += 1;
					j += 1;
				}
			}
			// (二)
			// 把有剩余数据的一边的数据，依次全部填充到temp
			while (i <= mid) {// 左边的有序序列还有剩余的元素，就全部填充到temp
				temp[t] = arr[i];
				t += 1;
				i += 1;
			}

			while (j <= right) {// 右边的有序序列还有剩余的元素，就全部填充到temp
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
			// (三)
			// 将temp数组的元素拷贝到arr
			// 注意,不是每一次都拷贝所有
			t = 0;
			int tempLeft = left;//
	//第一次合并时,tempLeft=0，right=1//tempLeft=2，right=3//tempLeft=0，right=3
	//最后一次tempLeft=0，right=7
			while (tempLeft <= right) {
				arr[tempLeft] = temp[t];
				t += 1;
				tempLeft += 1;
			}

		}
	
		
		
		
	
	/**
	 * 快速排序
	 * 使用空间来换取时间【速度超级快!!!比移位的希尔排序还要快】
	 * 
	 * 时间复杂度O(N*logN)
	 * @param arr    待排序的数组
	 * @param left   左下标
	 * @param right  右下标
	 * @return       返回已经排好的数组
	 */
	public static int[] QuickSort(int arr[], int left, int right) {
		int l = left;
		int r = right;
		int pivot = arr[(left + right) / 2];
		int temp = 0;

		while (l < r) {
			while (arr[l] < pivot) {
				l++;
			}

			while (arr[r] > pivot) {
				r--;
			}

			if (l >= r) {
				break;
			}
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			if (arr[l] == pivot) {
				r--;
			}

			if (arr[r] == pivot) {
				l++;
			}
		}

		//下面的两种形式都可以
		//不推荐最下面的因为其参数的++和--都在while循环中实现了
		//但如果用l==r来判断就稍微[**仅仅是稍微**]减小了消耗
		if (l == r) {
			l++;
			r--;
		}
		
		if (left < r) {
			QuickSort(arr, left, r);
		}

		if (right > l) {
			QuickSort(arr, l, right);
		}
		
/*		if (left < r) {
			QuickSort(arr, left, --r);
		}

		if (right > l) {
			QuickSort(arr, ++l, right);
		}*/

		return arr;
	}
	
	
	/**
	 * 希尔排序的第二种排序方式
	 * 移位方式
	 * 
	 * 时间复杂度O(n^3)
	 * 
	 * 
	 * (有点难度)
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	
	
	public static int[] MoveShellSort(int[] arr) {
		int insertIndex = 0;
		int insertVal = 0;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			//遍历各组中的所有元素(共gap组),步长为gap
			for (int i = gap; i < arr.length; i++) {
				insertIndex = i - gap;
				insertVal = arr[i];
				while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
					arr[insertIndex+gap] = arr[insertIndex];
					insertIndex -= gap;
				}
				
				arr[insertIndex+gap] = insertVal;
			}
		}
		return arr;
	}
	
	
	
	/**
	 * 希尔排序的第一种排序方式
	 * 交换方式
	 * 
	 * 时间复杂度O(n^3)
	 * 
	 * 
	 * (有点难度)
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	
	public static int[] ChangeShellSort(int[] arr) {
		int temp = 0;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
		}
		return arr;
	}
	
	/**
	 * 稍微优化的的插入排序【效果不明显,只是去掉了时间复杂度的低次位n】
	 * 
	 * 时间复杂度为O(n^2)
	 * 
	 * @param arr
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
			if (insertIndex != i - 1) {
				arr[insertIndex + 1] = insertVal;
			}
		}
		return arr;
	}
	
	
	
	
	
	/**
	 * 正常的插入排序
	 * 
	 * 时间复杂度为O(n^2)
	 * 
	 * @param arr
	 * @return
	 */
	
	public static int[] InsertSort(int[] arr) {
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
	 * 正常的选择排序【最后交换不太熟练要继续默写】
	 * 
	 * 时间复杂度o(n^2)
	 * @param arr
	 * @return
	 */

	public static int[] SelectSort(int arr[]) {
		int minIndex = 0;
		int min = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			min = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					minIndex = j;
					min = arr[j];
				}
			}
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}

		return arr;
	}
	
	
	
	
	/**
	 * 优化之后的冒泡排序
	 * 
	 * 事件复杂度O(n^2)
	 * 
	 * @param arr 要排序的数组
	 *            
	 * @return 返回数组
	 */
	public static int[] optimizeBubbleSort(int arr[]) {
		int temp = 0;
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!flag) {
				break;
			} else {
				flag = false;
			}
		}

		return arr;
	}

	
	
	
	
	/**
	 * 正常的冒泡排序
	 * 
	 * 时间复杂度:O(n^2)
	 * 
	 * @param arr要排序的数组
	 * 
	 * @return 返回一个数组
	 */
	public static int[] BubbleSort(int arr[]) {
		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

}
