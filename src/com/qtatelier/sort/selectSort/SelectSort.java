package com.qtatelier.sort.selectSort;

import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
/*		int arr[] = { 101, 34, 119, 1 };
		selectSortByStep(arr);
		
		System.out.println("����������Ϊ:");
		System.out.println(Arrays.toString(selectSort(arr)));*/
		
		
		/**
		 * ����80000����������
		 */
		
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//����һ��[0,8000000)�����
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("ѡ������ִ��80000����������������:");
		
		selectSort(randomArr);

		long time2 = System.currentTimeMillis();
		
		System.out.println((time2-time)/1000+"��");//1s����
		//����Ȼʱ�临�Ӷȶ���O(n^2),��������ѡ�������˫��ѭ���������ð���������,�����ٶȿ졿
		
	}

	/**
	 * ѡ������
	 * 
	 * ʱ�临�Ӷ�O(n^2)
	 * 
	 * @param arr ������һ��Ҫ���������
	 *            
	 * @return ����ֵ��һ������
	 */
	public static int[] selectSort(int[] arr) {
		int minIndex = 0;
		int min = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			min = arr[i];
			for (int j = 1+i; j < arr.length; j++) {
				if (min > arr[j]) { // ˵���ٶ�����Сֵ����������Сֵ
					min = arr[j];// ������Сֵ
					minIndex = j;// ������Сֵ������
				}
			}
			// ����Сֵ����arr[0],������
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}

		}
		return arr;

	}

	/**
	 * 
	 *  ѡ������ֲ�ִ��
	 * @param arr
	 */
	public static void selectSortByStep(int[] arr) {
		// ʹ�����Ƶ��ķ�ʽ
		// ��һ��
		// ԭʼ���飺 101,34,119,1
		// ��һ��˳��1,34,119,101
		// �㷨 �ȼ�--->���ӡ�����Ϊ��

		int minIndex = 0;
		int min = arr[minIndex];
		for (int j = 1; j < arr.length; j++) {
			if (min > arr[j]) { // ˵���ٶ�����Сֵ����������Сֵ
				min = arr[j];// ������Сֵ
				minIndex = j;// ������Сֵ������
			}
		}
		// ����Сֵ����arr[0],������
		if(minIndex != 0) {
		arr[minIndex] = arr[0];
		arr[0] = min;
		}
		
		System.out.println("��һ�ֺ�");
		System.out.println(Arrays.toString(arr));
		
		
		
		
		
		//�ڶ���
		 minIndex = 1;
		 min = arr[minIndex];
		for (int j = 1+1; j < arr.length; j++) {
			if (min > arr[j]) { // ˵���ٶ�����Сֵ����������Сֵ
				min = arr[j];// ������Сֵ
				minIndex = j;// ������Сֵ������
			}
		}
		// ����Сֵ����arr[0],������
		if(minIndex != 1) {
		arr[minIndex] = arr[1];
		arr[1] = min;
		}
		
		System.out.println("�ڶ��ֺ�");
		System.out.println(Arrays.toString(arr));
		
		
		
		
		
		
		//������
		 minIndex = 2;
		 min = arr[minIndex];
		for (int j = 1+1+1; j < arr.length; j++) {
			if (min > arr[j]) { // ˵���ٶ�����Сֵ����������Сֵ
				min = arr[j];// ������Сֵ
				minIndex = j;// ������Сֵ������
			}
		}
		// ����Сֵ����arr[0],������
		if(minIndex != 2) {
		arr[minIndex] = arr[2];
		arr[2] = min;
		}
		
		System.out.println("�����ֺ�");
		System.out.println(Arrays.toString(arr));
		
	}

}
