package com.qtatelier.search;

//ע��:ʹ�ö��ֲ��ҵ�ǰ���Ǹ������������
public class BinarySearch {
	public static void main(String[] args) {
		
		int arr[] = { 1, 8, 10, 89, 1000, 1234 };
		int resIndex = binary(arr, 0, arr.length-1,1000);
		if(resIndex == -1) {
		System.out.println("û�����ҵ�����!!!");
		}else {
			System.out.println(resIndex);
		}
	}
	
	//���ֲ���
	/**
	 * 
	 * @param arr ����
	 * @param left ��ߵ�����
	 * @param right �ұߵ�����
	 * @param findVal Ҫ���ҵ�ֵ
	 * @return ����ҵ��ͷ����±꣬���û�оͷ���-1
	 */
	public static int binary(int[] arr,int left,int right,int findVal) {
		if(left>right) {
			return -1;
		}
		int mid = (left + right) /2;
		int midVal = arr[mid];
		if(findVal > midVal) {//���ҵݹ�
			return binary(arr, mid+1, right, findVal);
		}else if(findVal < midVal){//����ݹ�
			return binary(arr, left, right-1, findVal);
		}else{
			return mid;
		}
	}
}




//˼���⣺����BinarySearchTest
/* { 1, 8, 10, 89, 1000, 1000, 1234 };
 * �ж����ͬ��ֵʱ����ν����е���ֵ�����ҵ�������1000
 * 
 * ˼·����
 * 1.���ҵ�mid����ֵ����Ҫ���Ϸ���
 * 2.��mid����ֵ�����ɨ�裬�������������ֵ��Ԫ�ص��±���뼯����
 * 3.��mid����ֵ���ұ�ɨ�裬�������������ֵ��Ԫ�ص��±���뼯����
 * 4.����
 */
