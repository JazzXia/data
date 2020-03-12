package com.qtatelier.sort.exchangeSort;

/**
 * �ڲ�����
 * 
 * ð�������ǽ��������е�һ��
 * 
 * @author JazzXdh
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
/*		int arr[] = { 3, 9, -1, 10, 20 };
		System.out.println("����ǰ");
		System.out.println(Arrays.toString(arr));
		*//**
		 * չʾ��װ�����ķ���
		 *//*
		optimizeBubbleSort(arr);
		System.out.println("�����");
		System.out.println(Arrays.toString(arr));*/
		
		//����һ��ð��������ٶ�O(n^2),��80000���ݣ�����
		//����Ҫ��80000�������������
		
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//����һ��[0,8000000)�����
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("ð������ִ��80000����������������:");
		
		optimizeBubbleSort(randomArr);

		long time2 = System.currentTimeMillis();
		
		
		System.out.println((time2-time)/1000+"��");//10s����
		

		// Ϊ��������⣬��ð��������������չʾ����
		
		//ð�������ѭ�����������鳤��-1
		//ð������ıȽϴ���Ҳ�����鳤��-1
		
		// ��һ�����򣬾��ǽ��������������
/*		int temp = 0;// ��������(��ʱ����)
		
		for (int j = 0; j < arr.length - 1 - 0; j++) {
			// ���ǰ������Ⱥ��������
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		System.out.println("��һ������������:");
		System.out.println(Arrays.toString(arr));

		
		
		// �ڶ��������ǽ��ڶ���������ڵ����ڶ�λ
		// (���Խ����鳤��-1,��Ϊ������һ���Ѿ�������һλ�������һλ����Ҫ����)
		for (int j = 0; j < arr.length - 1 - 1; j++) {
			// ���ǰ������Ⱥ��������
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		System.out.println("�ڶ�������������:");
		System.out.println(Arrays.toString(arr));

		
		
		// �����������ǽ�������������ڵ�������λ
		// (���Խ����鳤��-1,��Ϊ������һ���Ѿ�������һλ�������һλ����Ҫ����)
		for (int j = 0; j < arr.length - 1 - 1 - 1; j++) {
			// ���ǰ������Ⱥ��������
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		System.out.println("����������������:");
		System.out.println(Arrays.toString(arr));
		
		
		
		
		// ���������򽫵��Ĵ�����ŵ���������λ��
		// (���Խ����鳤��-1,��Ϊ������һ���Ѿ�������һλ�������һλ����Ҫ����)
		for (int j = 0; j < arr.length - 1 - 1 - 1; j++) {
			// ���ǰ������Ⱥ��������
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		System.out.println("���������������顾���Ľ����:");
		System.out.println(Arrays.toString(arr));*/

		
		
	//������������װ�ɷ���	
		
		/**
		 * �����������ѭ����������
		 * 
		 * ð������ʱ�临�Ӷ���O(n^2)
		 */
/*		int temp = 0;// ��������(��ʱ����)
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				// ���ǰ������Ⱥ��������
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if(!flag) {//�������У�һ�ν�����û�з���
				break;
			}else {
				flag = false;//����flag��������һ�ε��жϡ�����ǰһ��Ϊtrue֮��ڶ��λ�Ҫ�����عرա�
			}
			System.out.println("��"+(i+1)+"������������:");
			System.out.println(Arrays.toString(arr));
		}
		
		
		System.out.println();
		*//**
		 * �����Ҳ����ֻ����û��������Ż���,��Ƚ��˼���
		 *//*
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1-i; j++) {
				// ���ǰ������Ⱥ��������
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.println("��"+(i+1)+"������������:");
			System.out.println(Arrays.toString(arr));
		}*/
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

	/**
	 * �Ż�֮���ð������
	 * 
	 * ʱ�临�Ӷ�O(n^2)
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
				if(arr[j]>arr[j+1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(!flag) {
				break;
			}else {
				flag = false;
			}

		}

		return arr;
	}
	
	
}
