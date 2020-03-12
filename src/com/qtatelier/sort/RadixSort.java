package com.qtatelier.sort;

import java.util.Arrays;

/**
 * 基数排序
 * 
 * 时间复杂度O(n*k)
 * @author JazzXdh
 *
 */
public class RadixSort {
	public static void main(String[] args) {
/*		int arr[] = { 53, 3, 542, 748, 14, 214 };
		radixSortByStep(arr);
		System.out.println(Arrays.toString(radixSort(arr)));*/
		
		
		/**
		 * 测试80000个数的性能
		 * 
		 * 但是如果使用80000000个数据
		 * 80000000*11*4/1024/1024/1024=3.278255462646484个G的内存才能计算出来
		 */
		
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//生成一个[0,8000000)随机数
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("基数排序执行80000个数的排序运行了:");
		
		radixSort(randomArr);

		long time2 = System.currentTimeMillis();
		
		System.out.println((time2-time)/1000+"秒");//不到1秒 //800000个数据不到1秒 //8000000个数据1秒左右
	}

	
	
	
	/**
	 * 基数排序整合
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
	
	
	
	
	// 基数排序算法按步骤执行
	public static void radixSortByStep(int[] arr) {

		// 定义一个二维数组,表示10个桶，每一个桶就是一个一维数组
		// 二维数组包含10个一位数组
		// 很明显，基数排序时使用空间换时间的经典算法
		int[][] bucket = new int[10][arr.length];

		// 为了记录每一个桶中实际存放了多少个数据我们定义一个一维数组来记录各个桶每次放入的数据个数
		// bucketElementCounts[0]记录了bucket[0]中的桶(一维数组)中放的数据个数,这里的10指的是一共有10个桶
		int[] bucketElementCounts = new int[10];

		// 第1轮排序(针对元素的个位数进行排序处理)
		for (int j = 0; j < arr.length; j++) {
			// 取出每个元素的个位的值
			int digitOfElement = arr[j] % 10;
			// 放入对应的桶中
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;//每多一个个位数对应的位置就+1
		}
		// 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
		int index = 0;
		// 遍历每一个桶,并将桶中是数据，放入到原数组,其实是10个桶
		for (int k = 0; k <bucket.length; k++) {
			// 如果桶中有数据，我们才放入到原数组
			if (bucketElementCounts[k] != 0) {
				// 循环该桶即第k个桶(即第k个一维数组),放入
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// 取出元素发放入到arr
					arr[index++] = bucket[k][l];
				}

			}
			//第一轮处理后需要将bucketElement[k] = 0!!!
			bucketElementCounts[k] = 0;
		}
		System.out.println("第1轮，对个位的排序处理 arr=" + Arrays.toString(arr));

		//==========================================================================
		
		// 第2轮排序(针对元素的个位数进行排序处理)
		for (int j = 0; j < arr.length; j++) {
			// 取出每个元素的个位的值
			int digitOfElement = arr[j]/10 % 10;
			// 放入对应的桶中
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;//每多一个个位数对应的位置就+1
		}
		// 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
	    index = 0;
		// 遍历每一个桶,并将桶中是数据，放入到原数组,其实是10个桶
		for (int k = 0; k <bucket.length; k++) {
			// 如果桶中有数据，我们才放入到原数组
			if (bucketElementCounts[k] != 0) {
				// 循环该桶即第k个桶(即第k个一维数组),放入
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// 取出元素发放入到arr
					arr[index++] = bucket[k][l];
				}

			}
			bucketElementCounts[k] = 0;
		}
		System.out.println("第2轮，对个位的排序处理 arr=" + Arrays.toString(arr));

		
		
		
		// 第3轮排序(针对元素的个位数进行排序处理)
		for (int j = 0; j < arr.length; j++) {
			// 取出每个元素的个位的值
			int digitOfElement = arr[j]/10/10 % 10;
			// 放入对应的桶中
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;//每多一个个位数对应的位置就+1
		}
		// 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
	    index = 0;
		// 遍历每一个桶,并将桶中是数据，放入到原数组,其实是10个桶
		for (int k = 0; k <bucket.length; k++) {
			// 如果桶中有数据，我们才放入到原数组
			if (bucketElementCounts[k] != 0) {
				// 循环该桶即第k个桶(即第k个一维数组),放入
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// 取出元素发放入到arr
					arr[index++] = bucket[k][l];
				}

			}
			bucketElementCounts[k] = 0;
		}
		System.out.println("第3轮，对个位的排序处理 arr=" + Arrays.toString(arr));
	}
}
