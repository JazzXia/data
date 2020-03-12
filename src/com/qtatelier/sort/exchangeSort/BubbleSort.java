package com.qtatelier.sort.exchangeSort;

/**
 * 内部排序：
 * 
 * 冒泡排序是交换排序中的一种
 * 
 * @author JazzXdh
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
/*		int arr[] = { 3, 9, -1, 10, 20 };
		System.out.println("排序前");
		System.out.println(Arrays.toString(arr));
		*//**
		 * 展示封装起来的方法
		 *//*
		optimizeBubbleSort(arr);
		System.out.println("排序后");
		System.out.println(Arrays.toString(arr));*/
		
		//测试一下冒泡排序的速度O(n^2),给80000数据，测试
		//创建要给80000个数的随机数组
		
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//生成一个[0,8000000)随机数
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("冒泡排序执行80000个数的排序运行了:");
		
		optimizeBubbleSort(randomArr);

		long time2 = System.currentTimeMillis();
		
		
		System.out.println((time2-time)/1000+"秒");//10s左右
		

		// 为了容易理解，将冒泡排序的排序过程展示出来
		
		//冒泡排序的循环次数是数组长度-1
		//冒泡排序的比较次数也是数组长度-1
		
		// 第一趟排序，就是将最大的数排在最后
/*		int temp = 0;// 辅助变量(临时变量)
		
		for (int j = 0; j < arr.length - 1 - 0; j++) {
			// 如果前面的数比后面的数大
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		System.out.println("第一趟排序后的数组:");
		System.out.println(Arrays.toString(arr));

		
		
		// 第二趟排序是将第二大的数排在倒数第二位
		// (可以将数组长度-1,因为数组上一个已经解决最后一位所以最后一位不需要交换)
		for (int j = 0; j < arr.length - 1 - 1; j++) {
			// 如果前面的数比后面的数大
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		System.out.println("第二趟排序后的数组:");
		System.out.println(Arrays.toString(arr));

		
		
		// 第三趟排序是将第三大的数排在倒数第三位
		// (可以将数组长度-1,因为数组上一个已经解决最后一位所以最后一位不需要交换)
		for (int j = 0; j < arr.length - 1 - 1 - 1; j++) {
			// 如果前面的数比后面的数大
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		System.out.println("第三趟排序后的数组:");
		System.out.println(Arrays.toString(arr));
		
		
		
		
		// 第四趟排序将第四大的数放到倒数第四位置
		// (可以将数组长度-1,因为数组上一个已经解决最后一位所以最后一位不需要交换)
		for (int j = 0; j < arr.length - 1 - 1 - 1; j++) {
			// 如果前面的数比后面的数大
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		System.out.println("第四趟排序后的数组【最后的结果】:");
		System.out.println(Arrays.toString(arr));*/

		
		
	//将下面的排序封装成方法	
		
		/**
		 * 将上面的所有循环整合起来
		 * 
		 * 冒泡排序时间复杂度是O(n^2)
		 */
/*		int temp = 0;// 辅助变量(临时变量)
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				// 如果前面的数比后面的数大
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if(!flag) {//在排序中，一次交换都没有发生
				break;
			}else {
				flag = false;//重置flag，进行下一次的判断【假设前一次为true之后第二次还要将开关关闭】
			}
			System.out.println("第"+(i+1)+"趟排序后的数组:");
			System.out.println(Arrays.toString(arr));
		}
		
		
		System.out.println();
		*//**
		 * 下面的也可以只不过没有上面的优化好,多比较了几次
		 *//*
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1-i; j++) {
				// 如果前面的数比后面的数大
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.println("第"+(i+1)+"趟排序后的数组:");
			System.out.println(Arrays.toString(arr));
		}*/
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

	/**
	 * 优化之后的冒泡排序
	 * 
	 * 时间复杂度O(n^2)
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
				if(arr[j]>arr[j+1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(!flag) {
				break;
			}else {
				flag = false;
			}

		}

		return arr;
	}
	
	
}
