package com.qtatelier.search;

import java.util.ArrayList;
import java.util.List;

/**
 * { 1, 8, 10, 89, 1000, 1000, 1234 };
 * �ж����ͬ��ֵʱ����ν����е���ֵ�����ҵ�������1000
 * @author JazzXdh
 *
 */
public class BinarySearch2 {

	public static void main(String[] args) {
		
		int arr[] = { 1, 8, 10, 89, 1000,1000, 1234 };
		List<Integer> resIndex = binary(arr, 0, arr.length-1,1000);
		if(resIndex == null) {
		System.out.println("û�����ҵ�����!!!");
		}else {
			System.out.println(resIndex);
		}
	}
	
	//������Ķ��ֲ���
	/**
	 * 
	 * @param arr ����
	 * @param left ��ߵ�����
	 * @param right �ұߵ�����
	 * @param findVal Ҫ���ҵ�ֵ
	 * @return ����ҵ��ͷ����±꣬���û�оͷ���-1
	 */
	public static List<Integer> binary(int[] arr,int left,int right,int findVal) {
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

}
