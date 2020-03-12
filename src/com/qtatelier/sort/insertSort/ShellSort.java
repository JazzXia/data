package com.qtatelier.sort.insertSort;

import java.util.Arrays;
/**
 * 希尔排序是对简单插入排序的改进
 * @author JazzXdh
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		/*int[] arr = {8,9,1,7,2,3,5,4,6,0};*/
		/*ChanegeShellSortByStep(arr);*/
/*		System.out.println("希尔的交换法排序");
		System.out.println(Arrays.toString(ChanegeShellSort(arr)));*/
		
		/**
		 * 交换型的希尔排序
		 */
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//生成一个[0,8000000)随机数
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("希尔插入排序【交换的方式】执行80000个数的排序运行了:");
		
		ChangeShellSort(randomArr);

		long time2 = System.currentTimeMillis();
		
		System.out.println((time2-time)/1000+"秒");//6秒左右
		
		
		/**
		 * 移位型的希尔排序
		 */
		
		int []randomArr1 = new int[800000];
		for(int i = 0 ; i <randomArr1.length;i++) {
			randomArr1[i] = (int) (Math.random()*randomArr1.length*100);//生成一个[0,8000000)随机数
		}
		

		long time3 = System.currentTimeMillis();
		System.out.printf("希尔插入排序【移位的方式】执行80000个数的排序运行了:");
		
		MoveShellSort(randomArr1);

		long time4 = System.currentTimeMillis();
		
		System.out.println((time4-time3)/1000+"秒");//耗费不到1秒左右，而且800000个数据也只要不到1秒，8000000个也只要2秒,80000000个也只要11秒
		
		
		
		
	}
	
	/**
	 * 
	 * 将交换式的希尔排序优化成移位法希尔排序。
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
	 * 交换法的希尔排序
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
	 * 使用逐步推导的方式来时显示希尔排序
	 * 
	 * 交换法的希尔排序
	 */
	public static void ChanegeShellSortByStep(int[] arr) {

		// 第一轮
		// 因为第一轮排序是将10个数据分成了5组
		int temp = 0;
		for (int i = 5; i < arr.length; i++) {
			// 遍历各组中所有的元素(共5组,每一组有2个元素,步长是5)
			for (int j = i - 5; j >= 0; j -= 5) {
				// 如果当前元素大于加上步长后的那个元素，说明交换
				if (arr[j] > arr[j+5]) {
					temp = arr[j];
					arr[j] = arr[j + 5];
					arr[j + 5] = temp;
				}
			}
		}
		System.out.println("希尔排序1轮后=" + Arrays.toString(arr));
		
		
		
		
		// 第二轮
		// 因为第一轮排序是将10个数据分成了2组
		for (int i = 2; i < arr.length; i++) {
			// 遍历各组中所有的元素(共5组,每一组有2个元素,步长是5)
			for (int j = i - 2; j >= 0; j -= 2) {
				// 如果当前元素大于加上步长后的那个元素，说明交换
				if (arr[j] > arr[j+2]) {
					temp = arr[j];
					arr[j] = arr[j + 2];
					arr[j + 2] = temp;
				}
			}
		}
		System.out.println("希尔排序2轮后=" + Arrays.toString(arr));
		
		
		
		
		// 第三轮
		// 因为第一轮排序是将10个数据分成了1组
		for (int i = 1; i < arr.length; i++) {
			// 遍历各组中所有的元素(共5组,每一组有2个元素,步长是5)
			for (int j = i - 1; j >= 0; j -= 1) {
				// 如果当前元素大于加上步长后的那个元素，说明交换
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("希尔排序3轮后=" + Arrays.toString(arr));
		
	}
}
