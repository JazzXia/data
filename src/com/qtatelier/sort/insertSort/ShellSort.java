package com.qtatelier.sort.insertSort;

import java.util.Arrays;
/**
 * ϣ�������ǶԼ򵥲�������ĸĽ�
 * @author JazzXdh
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		/*int[] arr = {8,9,1,7,2,3,5,4,6,0};*/
		/*ChanegeShellSortByStep(arr);*/
/*		System.out.println("ϣ���Ľ���������");
		System.out.println(Arrays.toString(ChanegeShellSort(arr)));*/
		
		/**
		 * �����͵�ϣ������
		 */
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//����һ��[0,8000000)�����
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("ϣ���������򡾽����ķ�ʽ��ִ��80000����������������:");
		
		ChangeShellSort(randomArr);

		long time2 = System.currentTimeMillis();
		
		System.out.println((time2-time)/1000+"��");//6������
		
		
		/**
		 * ��λ�͵�ϣ������
		 */
		
		int []randomArr1 = new int[800000];
		for(int i = 0 ; i <randomArr1.length;i++) {
			randomArr1[i] = (int) (Math.random()*randomArr1.length*100);//����һ��[0,8000000)�����
		}
		

		long time3 = System.currentTimeMillis();
		System.out.printf("ϣ������������λ�ķ�ʽ��ִ��80000����������������:");
		
		MoveShellSort(randomArr1);

		long time4 = System.currentTimeMillis();
		
		System.out.println((time4-time3)/1000+"��");//�ķѲ���1�����ң�����800000������ҲֻҪ����1�룬8000000��ҲֻҪ2��,80000000��ҲֻҪ11��
		
		
		
		
	}
	
	/**
	 * 
	 * ������ʽ��ϣ�������Ż�����λ��ϣ������
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
	 * ��������ϣ������
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
	 * ʹ�����Ƶ��ķ�ʽ��ʱ��ʾϣ������
	 * 
	 * ��������ϣ������
	 */
	public static void ChanegeShellSortByStep(int[] arr) {

		// ��һ��
		// ��Ϊ��һ�������ǽ�10�����ݷֳ���5��
		int temp = 0;
		for (int i = 5; i < arr.length; i++) {
			// �������������е�Ԫ��(��5��,ÿһ����2��Ԫ��,������5)
			for (int j = i - 5; j >= 0; j -= 5) {
				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
				if (arr[j] > arr[j+5]) {
					temp = arr[j];
					arr[j] = arr[j + 5];
					arr[j + 5] = temp;
				}
			}
		}
		System.out.println("ϣ������1�ֺ�=" + Arrays.toString(arr));
		
		
		
		
		// �ڶ���
		// ��Ϊ��һ�������ǽ�10�����ݷֳ���2��
		for (int i = 2; i < arr.length; i++) {
			// �������������е�Ԫ��(��5��,ÿһ����2��Ԫ��,������5)
			for (int j = i - 2; j >= 0; j -= 2) {
				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
				if (arr[j] > arr[j+2]) {
					temp = arr[j];
					arr[j] = arr[j + 2];
					arr[j + 2] = temp;
				}
			}
		}
		System.out.println("ϣ������2�ֺ�=" + Arrays.toString(arr));
		
		
		
		
		// ������
		// ��Ϊ��һ�������ǽ�10�����ݷֳ���1��
		for (int i = 1; i < arr.length; i++) {
			// �������������е�Ԫ��(��5��,ÿһ����2��Ԫ��,������5)
			for (int j = i - 1; j >= 0; j -= 1) {
				// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("ϣ������3�ֺ�=" + Arrays.toString(arr));
		
	}
}
