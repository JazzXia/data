package com.qtatelier.sort.exchangeSort;

/**
 * 快排是对冒泡排序的改进
 * 使用递归，所以开辟了栈，原理上是使用空间换时间
 * 
 * @author JazzXdh
 *
 */
public class QuickSortArray{
	public static void main(String[] args) {
/*		int[] arr = { -9, 78, 0, 23, -567, 70,10086,945,989};

		QuickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));*/
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//生成一个[0,8000000)随机数
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("快速排序执行80000个数的排序运行了:");
		
		QuickSort(randomArr, 0, randomArr.length-1);

		long time2 = System.currentTimeMillis();
		
		
		System.out.println((time2-time)/1000+"秒");
		//80000不到1秒，800000个数据也不到1s,8000000个数据1秒不到,80000000个数据7秒左右
	}

	
	
	public static int[] QuickSort(int arr[], int left, int right) {
		int l = left;// 左下标
		int r = right;// 右下标
		// pivot:中轴值
		int pivot = arr[(left + right) / 2];
		int temp = 0;// 临时变量,交换时使用

		// while循环的目的是让比pivot值小的放左边
		// 比pivot大的值放右边
		while (l < r) {// 只要右边的下标还大于左边的下标
			// 在pivot左边一直找，找到一个大于等于pivot的值才退出
			while (arr[l] < pivot) {
				l += 1;
			}
			// 在pivot右边一直找，找到一个小于等于pivot的值才退出
			while (arr[r] > pivot) {
				r -= 1;
			}
			// 如果l>=r卓明pivot左右两边的值，已经按照左边全部是
			// 小于等于pivot的值，右边全部都是大于等于pivot的值
			if (l >= r) {
				break;
			}
			// 交换
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			// 如果交换完毕后，发现arr[l] == pivot的值相等就让r--,此时就前移
			if (arr[l] == pivot) {
				r -= 1;
			}
			// 如果交换完毕后，发现arr[r] == pivot的值相等就让l++,此时就后移
			if (arr[r] == pivot) {
				l += 1;
			}
		}

		// 如果l == r,必须l++,r--,否则会出现栈溢出
		if (l == r) {
			l += 1;
			r -= 1;
		}
		// 向左递归
		if (left < r) {
			QuickSort(arr, left, r);
		}

		if (right > l) {
			QuickSort(arr, l, right);
		}

		return arr;
	}
	

}
