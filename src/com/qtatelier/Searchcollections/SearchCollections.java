package com.qtatelier.Searchcollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchCollections {
	static int count = 0;
	static int add = 0;
	static int num = 0;
	public static void main(String[] args) {
		//�Զ�����1~100������
/*		int[] arr = new int[100];
		for (int i = 0; i <= 99; i++) {
			arr[i] = i + 1;
		}*/
		
		int arr[] = { 1, 8, 10, 89,1000, 1234 };
		//���Բ���
		int index = seqSearch(arr, 89);
		if (index == -1) {
			System.out.println("û���ҵ�");
		} else {
			System.out.println("�ҵ����±�=" + index);
		}
		System.out.println("���Ҵ���:"+ count);
		
		
		//���ֲ���
		List<Integer> resIndex = binary(arr, 0, arr.length-1,89);
		if(resIndex == null) {
			System.out.println("û�����ҵ�����!!!");
		}else {
			System.out.println("�±�:"+ resIndex);
		}
		System.out.println("���Ҵ���:"+ add);
		
		
		//�������
		int index1 = insertValueSearch(arr, 0, arr.length-1, 89);
		if (index1 != -1) {
			System.out.println("�±�Ϊ:" + index1);
		}else {
			System.out.println("�Բ���û��Ҫ�ҵ��±�");
		}
		System.out.println("���Ҵ���:"+ num);
		System.out.println("ԭ����Ϊ��" + Arrays.toString(arr));
		
		
		
		
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
			count++;
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	//������Ķ��ֲ���
	//�ó��ֲ�������
	/**
	 * 
	 * @param arr ����
	 * @param left ��ߵ�����
	 * @param right �ұߵ�����
	 * @param findVal Ҫ���ҵ�ֵ
	 * @return ����ҵ��ͷ����±꣬���û�оͷ���-1
	 */
	public static List<Integer> binary(int[] arr,int left,int right,int findVal) {
		add++;
		if(left>right) {
			return null;
		}
		int mid = (left + right) /2;
		int midVal = arr[mid];
		if(findVal > midVal) {//���ҵݹ�
			return binary(arr, mid+1, right, findVal);
		}else if(findVal < midVal){//����ݹ�
			return binary(arr, left, right-1, findVal);
		}else{
			/**
			 *  ˼·����
			 * 1.���ҵ�mid����ֵ����Ҫ���Ϸ���
			 * 2.��mid����ֵ�����ɨ�裬�������������ֵ��Ԫ�ص��±���뼯����
			 * 3.��mid����ֵ���ұ�ɨ�裬�������������ֵ��Ԫ�ص��±���뼯����
			 * 4.����
			 */
			List<Integer> res = new ArrayList<Integer>();
			//��mid���ɨ�裬Ѱ��1000
			int temp = mid -1;
			while(true) {
				if(temp < 0 || arr[temp] != findVal) {
					break;
				}
				res.add(temp);
				temp -= 1;//temp����
			}
			res.add(mid);
			
			//��mid�ұ�ɨ�裬Ѱ��1000
			temp = mid + 1;
			while(true) {
				if(temp > arr.length-1 || arr[temp] != findVal) {
					break;
				}
				res.add(temp);
				temp += 1;//temp����
			}
			return res;
		}
	}
	
	//��ֵ�����㷨
	//˵������ֵ�����㷨��ҲҪ����������ġ�
	//�ó��ֲ�����
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
		}else if(findVal < midVal) {//˵��Ӧ������ߵݹ�
			return insertValueSearch(arr, left, mid-1, findVal);
		}else {
			return mid;
		}
	}
	
}
