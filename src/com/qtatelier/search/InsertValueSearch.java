package com.qtatelier.search;

import java.util.Arrays;

public class InsertValueSearch {
    static int num = 0;
	public static void main(String[] args) {

		int[] arr = new int[100];
		for (int i = 0; i <= 99; i++) {
			arr[i] = i + 1;
		}
		int index = insertValueSearch(arr, 0, arr.length-1, 66);
		if (index != -1) {
			System.out.println("�±�Ϊ:" + index);
		}else {
			System.out.println("�Բ���û��Ҫ�ҵ��±�");
		}
		System.out.println("ԭ����Ϊ��" + Arrays.toString(arr));
		System.out.println("���Ҵ���:"+ num);
	}
	
	//��ֵ�����㷨
	//˵������ֵ�����㷨��ҲҪ����������ġ�
	/**
	 * 
	 * @param arr ����
	 * @param left �������
	 * @param right �ұ�����
	 * @param findVal ����ֵ
	 * @return
	 */
	public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
		num++;
		//ע�⣺indVal < arr[0] || findVal > arr.length - 1������Ҫ���������ǵõ���mid����Խ�硣
		if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
			return -1;
		}
		//���mid
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		if(findVal > midVal) {//˵��Ӧ�����ұߵݹ�
			return insertValueSearch(arr, mid+1, right, findVal);
		}else if(findVal < midVal) {
			return insertValueSearch(arr, left, mid-1, findVal);
		}else {
			return mid;
		}
	}
	
}
