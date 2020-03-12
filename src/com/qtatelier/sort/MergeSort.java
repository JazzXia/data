package com.qtatelier.sort;

/**
 * �鲢����,�����㷨
 * @author JazzXdh
 *
 */
public class MergeSort {
	public static void main(String[] args) {
/*		int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
		int temp[] = new int[arr.length];// �鲢������Ҫһ������Ŀռ�
		mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println("�鲢�����=" + Arrays.toString(arr));*/
		int []randomArr = new int[80000];
		int temp[] = new int[randomArr.length];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//����һ��[0,8000000)�����
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("ϣ���������򡾽����ķ�ʽ��ִ��80000����������������:");
		
		mergeSort(randomArr, 0, randomArr.length-1, randomArr);

		long time2 = System.currentTimeMillis();
		
		System.out.println((time2-time)/1000+"��");
		
		//80000000�����ݴ�ԼΪ13��
        //80000������1��
		//800000������1��
		//8000000��1������
	}
	
	
	//��+�ϵķ���
	public static void mergeSort(int[] arr, int left,int right,int[] temp) {
		if(left < right) {
			int mid = (left + right)/2;//�м������
			//����ݹ���зֽ�
			mergeSort(arr, left, mid, temp);
			//���ҵݹ���зֽ�
			mergeSort(arr, mid+1, right, temp);
			//���ϲ�ʱ
			merge(arr, left, mid, right, temp);
		}
	}
	
	
	
	//�ϲ��ķ���
	/**
	 * 
	 * @param arr �����������
	 * @param left ����������еĳ�ʼ����
	 * @param mid	�м�����
	 * @param right �ұ�����
	 * @param temp  ����ת������
	 */
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;// ��ʼ��i������������еĳ�ʼ����
		int j = mid + 1;// ��ʼ��j��ʾ�ұ��������еĳ�ʼ����
		int t = 0; // ָ��temp��ת���������

		// (һ)
		// �Ȱ�����(��������)���ߵ����ݰ��չ�����䵽temp����
		// ֱ���������ߵ���������,��һ�ߴ������Ϊֹ
		while (i <= mid && j <= right) {// ����
			// �����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұ��������еĵ�ǰԪ��
			// ������ߵ�Ԫ�أ�������temp����
			// Ȼ��t++,i++
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
			} else {// ��֮�����ұߵ��������еĵ�ǰԪ����䵽temp����
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}
		// (��)
		// ����ʣ�����ݵ�һ�ߵ����ݣ�����ȫ����䵽temp
		while (i <= mid) {// ��ߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}

		while (j <= right) {// �ұߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		// (��)
		// ��temp�����Ԫ�ؿ�����arr
		// ע��,����ÿһ�ζ���������
		t = 0;
		int tempLeft = left;//
//��һ�κϲ�ʱ,tempLeft=0��right=1//tempLeft=2��right=3//tempLeft=0��right=3
//���һ��tempLeft=0��right=7
		/*System.out.println("tempLeft"+tempLeft+"right="+right);*/
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}

	}

}
