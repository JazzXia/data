package com.qtatelier.sort.insertSort;

import java.util.Arrays;

public class InsertSort {
	
	public static void main(String[] args) {
/*		int [] arr= {101,34,119,1};
		int [] arrOrder = insertSort(arr);
		System.out.println(Arrays.toString(arrOrder));*/
		
		//����80000�����������ٶ�
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//����һ��[0,8000000)�����
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("ֱ�Ӳ�������,ִ��80000����������������:");
		
		optimizeInsertSort(randomArr);

		long time2 = System.currentTimeMillis();
		
		System.out.println((time2-time)/1000+"��");//1s���ұ�ѡ��������һ��
	}
	
	
	
	

	/**
	 * �����Ĳ�������
	 * 
	 * ʱ�临�Ӷ�ΪO(n^2)
	 * 
	 * @param arr
	 * @return
	 */
	
	public static int[] insertSort(int[] arr) {
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
	 * �Ż�֮��Ĳ�������
	 * ʱ�临�Ӷ�O(n^2)
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
			// �Ż��ж��Ƿ���Ҫ��ֵ
			if (insertIndex != i - 1) {
				arr[insertIndex + 1] = insertVal;
			}
		}
		return arr;
	}
	
	
	
	
	
	/**
	 * �������Ƶ������в�������
	 * @param arr
	 * 
	 * ��ϸ���Ͳ�������.
	 * ����,��������˵�ǽ�һ������ֳ��������֣�һ��������Ĳ��֣�һ��������Ĳ���
	 * ����������С���󣬴Ӵ�СҲͬ��
	 * Ȼ��,���򲿷�Ĭ��������ĵ�һ��Ԫ��,������ĵڶ���Ԫ�ظ����,�����������±�
	 * ��֮��֮ǰ��ÿһ������һ���Ƚ������ǰһ������С,��ô�ͽ�ǰһ�����ֵ�����ƣ�
	 * ֱ��������whileѭ��������1.��Ԫ��ǰ���Ѿ�û����Ԫ�� 2.��Ԫ�ص�����ֵ>=ǰһ��Ԫ�ء�
	 * ����ѭ��,��Ԫ�ز��뵽��ǰ��λ�á�
	 * 
	 */
	public static void insertSortByStep(int arr[]) {
		//��һ��
		//�ȶ�����������
		int insertVal = arr[1];
		int insertIndex = 1 - 1;//��arr[1]��ǰ����������±�
		
		//��insertValue�ҵ������λ��
		//1.insertIndex>=0��֤�ڸ�insertValue �Ҳ���λ�õ�ʱ��Խ�硣
		//2.insertVal < arr[insertIndex]���������,��û���ҵ������λ��
		//3.����Ҫ��arr[insertIndex]����
		while(insertIndex >= 0 && insertVal < arr[insertIndex]) {//������Ҫ�������Ϊtrue
			arr[insertIndex+1] = arr[insertIndex];
			insertIndex--;
		}
		//���˳�whileѭ����ʱ����ô�����λ�þ��ҵ�
		arr[insertIndex+1] = insertVal;
		
		System.out.println("��һ�ֲ���֮��:");
		System.out.println(Arrays.toString(arr));
	
	
	
		//�ڶ���
		//�ȶ�����������
		 insertVal = arr[2];
		 insertIndex = 2 - 1;//��arr[1]��ǰ����������±�
		
		//��insertValue�ҵ������λ��
		//1.insertIndex>=0��֤�ڸ�insertValue �Ҳ���λ�õ�ʱ��Խ�硣
		//2.insertVal < arr[insertIndex]���������,��û���ҵ������λ��
		//3.����Ҫ��arr[insertIndex]����
		while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
			arr[insertIndex+1] = arr[insertIndex];
			insertIndex--;
		}
		//���˳�whileѭ����ʱ����ô�����λ�þ��ҵ�
		arr[insertIndex+1] = insertVal;
		
		System.out.println("�ڶ��ֲ���֮��:");
		System.out.println(Arrays.toString(arr));
		
		
		
		//������
		//�ȶ�����������
		 insertVal = arr[3];
		 insertIndex = 3 - 1;//��arr[1]��ǰ����������±�
		
		//��insertValue�ҵ������λ��
		//1.insertIndex>=0��֤�ڸ�insertValue �Ҳ���λ�õ�ʱ��Խ�硣
		//2.insertVal < arr[insertIndex]���������,��û���ҵ������λ��
		//3.����Ҫ��arr[insertIndex]����
		while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
			arr[insertIndex+1] = arr[insertIndex];
			insertIndex--;
		}
		//���˳�whileѭ����ʱ����ô�����λ�þ��ҵ�
		arr[insertIndex+1] = insertVal;
		
		System.out.println("�����ֲ���֮��:");
		System.out.println(Arrays.toString(arr));
		
		
		
		
		
		
		
		
		
		
	
	}
}
