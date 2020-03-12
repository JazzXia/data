package com.qtatelier.sort;

import java.util.Arrays;

/**
 * ��������
 * 
 * ʱ�临�Ӷ�O(n*k)
 * @author JazzXdh
 *
 */
public class RadixSort {
	public static void main(String[] args) {
/*		int arr[] = { 53, 3, 542, 748, 14, 214 };
		radixSortByStep(arr);
		System.out.println(Arrays.toString(radixSort(arr)));*/
		
		
		/**
		 * ����80000����������
		 * 
		 * �������ʹ��80000000������
		 * 80000000*11*4/1024/1024/1024=3.278255462646484��G���ڴ���ܼ������
		 */
		
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//����һ��[0,8000000)�����
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("��������ִ��80000����������������:");
		
		radixSort(randomArr);

		long time2 = System.currentTimeMillis();
		
		System.out.println((time2-time)/1000+"��");//����1�� //800000�����ݲ���1�� //8000000������1������
	}

	
	
	
	/**
	 * ������������
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
	
	
	
	
	// ���������㷨������ִ��
	public static void radixSortByStep(int[] arr) {

		// ����һ����ά����,��ʾ10��Ͱ��ÿһ��Ͱ����һ��һά����
		// ��ά�������10��һλ����
		// �����ԣ���������ʱʹ�ÿռ任ʱ��ľ����㷨
		int[][] bucket = new int[10][arr.length];

		// Ϊ�˼�¼ÿһ��Ͱ��ʵ�ʴ���˶��ٸ��������Ƕ���һ��һά��������¼����Ͱÿ�η�������ݸ���
		// bucketElementCounts[0]��¼��bucket[0]�е�Ͱ(һά����)�зŵ����ݸ���,�����10ָ����һ����10��Ͱ
		int[] bucketElementCounts = new int[10];

		// ��1������(���Ԫ�صĸ�λ������������)
		for (int j = 0; j < arr.length; j++) {
			// ȡ��ÿ��Ԫ�صĸ�λ��ֵ
			int digitOfElement = arr[j] % 10;
			// �����Ӧ��Ͱ��
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;//ÿ��һ����λ����Ӧ��λ�þ�+1
		}
		// �������Ͱ��˳��(һά������±�����ȡ�����ݣ�����ԭ������)
		int index = 0;
		// ����ÿһ��Ͱ,����Ͱ�������ݣ����뵽ԭ����,��ʵ��10��Ͱ
		for (int k = 0; k <bucket.length; k++) {
			// ���Ͱ�������ݣ����ǲŷ��뵽ԭ����
			if (bucketElementCounts[k] != 0) {
				// ѭ����Ͱ����k��Ͱ(����k��һά����),����
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// ȡ��Ԫ�ط����뵽arr
					arr[index++] = bucket[k][l];
				}

			}
			//��һ�ִ������Ҫ��bucketElement[k] = 0!!!
			bucketElementCounts[k] = 0;
		}
		System.out.println("��1�֣��Ը�λ�������� arr=" + Arrays.toString(arr));

		//==========================================================================
		
		// ��2������(���Ԫ�صĸ�λ������������)
		for (int j = 0; j < arr.length; j++) {
			// ȡ��ÿ��Ԫ�صĸ�λ��ֵ
			int digitOfElement = arr[j]/10 % 10;
			// �����Ӧ��Ͱ��
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;//ÿ��һ����λ����Ӧ��λ�þ�+1
		}
		// �������Ͱ��˳��(һά������±�����ȡ�����ݣ�����ԭ������)
	    index = 0;
		// ����ÿһ��Ͱ,����Ͱ�������ݣ����뵽ԭ����,��ʵ��10��Ͱ
		for (int k = 0; k <bucket.length; k++) {
			// ���Ͱ�������ݣ����ǲŷ��뵽ԭ����
			if (bucketElementCounts[k] != 0) {
				// ѭ����Ͱ����k��Ͱ(����k��һά����),����
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// ȡ��Ԫ�ط����뵽arr
					arr[index++] = bucket[k][l];
				}

			}
			bucketElementCounts[k] = 0;
		}
		System.out.println("��2�֣��Ը�λ�������� arr=" + Arrays.toString(arr));

		
		
		
		// ��3������(���Ԫ�صĸ�λ������������)
		for (int j = 0; j < arr.length; j++) {
			// ȡ��ÿ��Ԫ�صĸ�λ��ֵ
			int digitOfElement = arr[j]/10/10 % 10;
			// �����Ӧ��Ͱ��
			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
			bucketElementCounts[digitOfElement]++;//ÿ��һ����λ����Ӧ��λ�þ�+1
		}
		// �������Ͱ��˳��(һά������±�����ȡ�����ݣ�����ԭ������)
	    index = 0;
		// ����ÿһ��Ͱ,����Ͱ�������ݣ����뵽ԭ����,��ʵ��10��Ͱ
		for (int k = 0; k <bucket.length; k++) {
			// ���Ͱ�������ݣ����ǲŷ��뵽ԭ����
			if (bucketElementCounts[k] != 0) {
				// ѭ����Ͱ����k��Ͱ(����k��һά����),����
				for (int l = 0; l < bucketElementCounts[k]; l++) {
					// ȡ��Ԫ�ط����뵽arr
					arr[index++] = bucket[k][l];
				}

			}
			bucketElementCounts[k] = 0;
		}
		System.out.println("��3�֣��Ը�λ�������� arr=" + Arrays.toString(arr));
	}
}
