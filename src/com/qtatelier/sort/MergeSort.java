package com.qtatelier.sort;

/**
 * 归并排序,分治算法
 * @author JazzXdh
 *
 */
public class MergeSort {
	public static void main(String[] args) {
/*		int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
		int temp[] = new int[arr.length];// 归并排序需要一个额外的空间
		mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println("归并排序后=" + Arrays.toString(arr));*/
		int []randomArr = new int[80000];
		int temp[] = new int[randomArr.length];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//生成一个[0,8000000)随机数
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("希尔插入排序【交换的方式】执行80000个数的排序运行了:");
		
		mergeSort(randomArr, 0, randomArr.length-1, randomArr);

		long time2 = System.currentTimeMillis();
		
		System.out.println((time2-time)/1000+"秒");
		
		//80000000个数据大约为13秒
        //80000个不到1秒
		//800000个不到1秒
		//8000000个1秒左右
	}
	
	
	//分+合的方法
	public static void mergeSort(int[] arr, int left,int right,int[] temp) {
		if(left < right) {
			int mid = (left + right)/2;//中间的索引
			//向左递归进行分解
			mergeSort(arr, left, mid, temp);
			//向右递归进行分解
			mergeSort(arr, mid+1, right, temp);
			//到合并时
			merge(arr, left, mid, right, temp);
		}
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
		/*System.out.println("tempLeft"+tempLeft+"right="+right);*/
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}

	}

}
