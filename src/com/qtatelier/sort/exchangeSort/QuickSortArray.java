package com.qtatelier.sort.exchangeSort;

/**
 * �����Ƕ�ð������ĸĽ�
 * ʹ�õݹ飬���Կ�����ջ��ԭ������ʹ�ÿռ任ʱ��
 * 
 * @author JazzXdh
 *
 */
public class QuickSortArray{
	public static void main(String[] args) {
/*		int[] arr = { -9, 78, 0, 23, -567, 70,10086,945,989};

		QuickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));*/
		int []randomArr = new int[80000];
		for(int i = 0 ; i <randomArr.length;i++) {
			randomArr[i] = (int) (Math.random()*randomArr.length*100);//����һ��[0,8000000)�����
		}
		

		long time = System.currentTimeMillis();
		System.out.printf("��������ִ��80000����������������:");
		
		QuickSort(randomArr, 0, randomArr.length-1);

		long time2 = System.currentTimeMillis();
		
		
		System.out.println((time2-time)/1000+"��");
		//80000����1�룬800000������Ҳ����1s,8000000������1�벻��,80000000������7������
	}

	
	
	public static int[] QuickSort(int arr[], int left, int right) {
		int l = left;// ���±�
		int r = right;// ���±�
		// pivot:����ֵ
		int pivot = arr[(left + right) / 2];
		int temp = 0;// ��ʱ����,����ʱʹ��

		// whileѭ����Ŀ�����ñ�pivotֵС�ķ����
		// ��pivot���ֵ���ұ�
		while (l < r) {// ֻҪ�ұߵ��±껹������ߵ��±�
			// ��pivot���һֱ�ң��ҵ�һ�����ڵ���pivot��ֵ���˳�
			while (arr[l] < pivot) {
				l += 1;
			}
			// ��pivot�ұ�һֱ�ң��ҵ�һ��С�ڵ���pivot��ֵ���˳�
			while (arr[r] > pivot) {
				r -= 1;
			}
			// ���l>=r׿��pivot�������ߵ�ֵ���Ѿ��������ȫ����
			// С�ڵ���pivot��ֵ���ұ�ȫ�����Ǵ��ڵ���pivot��ֵ
			if (l >= r) {
				break;
			}
			// ����
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;

			// ���������Ϻ󣬷���arr[l] == pivot��ֵ��Ⱦ���r--,��ʱ��ǰ��
			if (arr[l] == pivot) {
				r -= 1;
			}
			// ���������Ϻ󣬷���arr[r] == pivot��ֵ��Ⱦ���l++,��ʱ�ͺ���
			if (arr[r] == pivot) {
				l += 1;
			}
		}

		// ���l == r,����l++,r--,��������ջ���
		if (l == r) {
			l += 1;
			r -= 1;
		}
		// ����ݹ�
		if (left < r) {
			QuickSort(arr, left, r);
		}

		if (right > l) {
			QuickSort(arr, l, right);
		}

		return arr;
	}
	

}
