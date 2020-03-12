package com.qtatelier.Sortcollections;

import java.util.Arrays;

/**
 * Ĭд�ڲ������㷨
 *��������ð�ݺͿ�������
 *ѡ�����򣺼�ѡ������Ͷ�����
 *��������ֱ�Ӳ��������ϣ������
 *�鲢����
 *��������Ͱ����������桿
 *
 * 
 * @author JazzXdh
 *
 */
public class SortTest {

	public static void main(String[] args) {
		
		int arr[] = { 3, 9, -1, 10, -2 };
		/**
		 * ��ͨ��ð��
		 */
		System.out.println("��ͨð�ݵ��������");
		System.out.println(Arrays.toString(BubbleSort(arr)));
	
		
		
		int arr2[] = { -100, 900, -10086, 1540, -2121 };
		/**
		 * �Ż�֮���ð��
		 */
		System.out.println("������Ż�֮���ð�ݵ������:");
		System.out.println(Arrays.toString(optimizeBubbleSort(arr2)));
		
		
		
		
		int arr3[] = {-99,55,66,100,-998,54,545};
		/**
		 * ѡ������
		 */
		System.out.println("ѡ������������:");
		System.out.println(Arrays.toString(SelectSort(arr3)));
		
		
		
		
		int arr4[] = {-99,55,66,100,-998,54,545};
		/**
		 * ��������
		 */
		System.out.println("��ͨ��������������:");
		System.out.println(Arrays.toString(InsertSort(arr4)));
		
		
		
		int arr5[] = {283, 468, 549, 570, 229, 213, 432, 137};
		/**
		 * �Ż���Ĳ�������
		 */
		System.out.println("�������Ż���Ĳ�������������:");
		System.out.println(Arrays.toString(optimizeInsertSort(arr5)));
		
		
		/**
		 * ϣ������ĵ�һ������ʽ[�����ķ�ʽ]
		 */
		int arr6[] = { 283, 468, 549, 570, 229, 213, 432, 137, 10086, 996 };
		System.out.println("ϣ������ĵ�һ������ʽ[�����ķ�ʽ]:");
		System.out.println(Arrays.toString(ChangeShellSort(arr6)));
		
		
		/**
		 * ϣ������ĵڶ�������ʽ[��λ�ķ�ʽ]
		 */
		int arr7[] = { 283, 468, 549, 570, 229, 213, 432, 137, 10086, 996 };
		System.out.println("ϣ������ĵ�һ������ʽ[�����ķ�ʽ]:");
		System.out.println(Arrays.toString(MoveShellSort(arr7)));
		
		
		/**
		 * ����������
		 */
		int arr8[] = { 283, 229, 549, 570, 229, 213, 432, 137, 10086, 996 };
		System.out.println("����������:");
		System.out.println(Arrays.toString(QuickSort(arr8, 0, arr8.length-1)));
		
		
		
		/**
		 * �鲢����
		 */
		int arr9[] = { 283, 229, 549, 570, 229, 213, 432, 137, 10086, 996 };
		int [] temp = new int[arr9.length];
		System.out.println("�鲢������:");
		System.out.println(Arrays.toString(mergeSort(arr9, 0, arr9.length-1, temp)));
		
		
		
		
		
		/**
		 * ����������
		 */
		int arr10[] = { 283, 229, 549, 570, 229, 213, 432, 137, 10086, 996 };
		System.out.println("����������:");
		System.out.println(Arrays.toString(radixSort(arr10)));
	}
	
	
	/**
	 * ��������
	 * ʱ�临�Ӷ�O(n*k)
	 * 
	 * @param arr
	 * @return
	 */
	
	
	public static int[] radixSort(int[] arr) {

		//1.�õ���������������λ��
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
		 *  �鲢����(���κ͵ݹ��˼��) 
		 *  
		 *  ʱ�临�Ӷ�O(N*logN)
		 *  
		 * @param arr
		 * @param left
		 * @param right
		 * @param temp
		 */
	
		//��+�ϵķ���
		public static int[] mergeSort(int[] arr, int left,int right,int[] temp) {
			if(left < right) {
				int mid = (left + right)/2;//�м������
				//����ݹ���зֽ�
				mergeSort(arr, left, mid, temp);
				//���ҵݹ���зֽ�
				mergeSort(arr, mid+1, right, temp);
				//���ϲ�ʱ
				merge(arr, left, mid, right, temp);
			}
			return arr;
		}
		//�ϲ��ķ���
		/**
		 * 
		 * @param arr �����������
		 * @param left ����������еĳ�ʼ����
		 * @param mid	�м�����
		 * @param right �ұ�����
		 * @param temp  ����ת������
		 */
		public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
			int i = left;// ��ʼ��i������������еĳ�ʼ����
			int j = mid + 1;// ��ʼ��j��ʾ�ұ��������еĳ�ʼ����
			int t = 0; // ָ��temp��ת���������

			// (һ)
			// �Ȱ�����(��������)���ߵ����ݰ��չ�����䵽temp����
			// ֱ���������ߵ���������,��һ�ߴ������Ϊֹ
			while (i <= mid && j <= right) {// ����
				// �����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұ��������еĵ�ǰԪ��
				// ������ߵ�Ԫ�أ�������temp����
				// Ȼ��t++,i++
				if (arr[i] <= arr[j]) {
					temp[t] = arr[i];
					t += 1;
					i += 1;
				} else {// ��֮�����ұߵ��������еĵ�ǰԪ����䵽temp����
					temp[t] = arr[j];
					t += 1;
					j += 1;
				}
			}
			// (��)
			// ����ʣ�����ݵ�һ�ߵ����ݣ�����ȫ����䵽temp
			while (i <= mid) {// ��ߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
				temp[t] = arr[i];
				t += 1;
				i += 1;
			}

			while (j <= right) {// �ұߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
			// (��)
			// ��temp�����Ԫ�ؿ�����arr
			// ע��,����ÿһ�ζ���������
			t = 0;
			int tempLeft = left;//
	//��һ�κϲ�ʱ,tempLeft=0��right=1//tempLeft=2��right=3//tempLeft=0��right=3
	//���һ��tempLeft=0��right=7
			while (tempLeft <= right) {
				arr[tempLeft] = temp[t];
				t += 1;
				tempLeft += 1;
			}

		}
	
		
		
		
	
	/**
	 * ��������
	 * ʹ�ÿռ�����ȡʱ�䡾�ٶȳ�����!!!����λ��ϣ������Ҫ�졿
	 * 
	 * ʱ�临�Ӷ�O(N*logN)
	 * @param arr    �����������
	 * @param left   ���±�
	 * @param right  ���±�
	 * @return       �����Ѿ��źõ�����
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

		//�����������ʽ������
		//���Ƽ����������Ϊ�������++��--����whileѭ����ʵ����
		//�������l==r���жϾ���΢[**��������΢**]��С������
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
	 * ϣ������ĵڶ�������ʽ
	 * ��λ��ʽ
	 * 
	 * ʱ�临�Ӷ�O(n^3)
	 * 
	 * 
	 * (�е��Ѷ�)
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	
	
	public static int[] MoveShellSort(int[] arr) {
		int insertIndex = 0;
		int insertVal = 0;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			//���������е�����Ԫ��(��gap��),����Ϊgap
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
	 * ϣ������ĵ�һ������ʽ
	 * ������ʽ
	 * 
	 * ʱ�临�Ӷ�O(n^3)
	 * 
	 * 
	 * (�е��Ѷ�)
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
	 * ��΢�Ż��ĵĲ�������Ч��������,ֻ��ȥ����ʱ�临�Ӷȵĵʹ�λn��
	 * 
	 * ʱ�临�Ӷ�ΪO(n^2)
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
	 * �����Ĳ�������
	 * 
	 * ʱ�临�Ӷ�ΪO(n^2)
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
	 * ������ѡ��������󽻻���̫����Ҫ����Ĭд��
	 * 
	 * ʱ�临�Ӷ�o(n^2)
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
	 * �Ż�֮���ð������
	 * 
	 * �¼����Ӷ�O(n^2)
	 * 
	 * @param arr Ҫ���������
	 *            
	 * @return ��������
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
	 * ������ð������
	 * 
	 * ʱ�临�Ӷ�:O(n^2)
	 * 
	 * @param arrҪ���������
	 * 
	 * @return ����һ������
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
