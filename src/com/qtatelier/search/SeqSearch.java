package com.qtatelier.search;

public class SeqSearch {
	public static void main(String[] args) {
		int arr[] = { 1, 9, 11, -1, 34, 89 };
		int index = seqSearch(arr, 11);
		if (index == -1) {
			System.out.println("û���ҵ�");
		} else {
			System.out.println("�ҵ����±�=" + index);
		}
	}

	/**
	 * ������ʵ�ֵ����Բ������ҵ�һ������������ֵ���ͷ��� ���Ҫ�������е�ֵ,���������±�,���ֵ��ͬ,���±�ŵ������м��ɡ�
	 * 
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int seqSearch(int[] arr, int value) {
		// ���Բ�������һ�ȶԣ���������ͬ��ֵʱ���ͷ����±�
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

}
