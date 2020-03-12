package com.qtatelier.recursion;
/**
 * ʹ�û��ݽ���˻ʺ�
 * ���滹��ʹ��̰���㷨�����
 * @author JazzXdh
 *
 */
public class EightQueen {

	//����һ��max��ʾ���ж��ٸ��ʺ�
	int max = 8;
	//��������array������ʺ����λ�õĽ��
	//��������һ�ֽ����arr = {0,4,7,5,2,6,1,3}��
	//ÿһ��������ռ��λ���Ƕ�Ӧ���У�
    //��λ�������ֵ�ֵ���Ƕ�Ӧ������
	int[] array = new int[max];
	static int count = 0;
	static int total = 0;
	public static void main(String[] args) {
		EightQueen eight = new EightQueen();
		eight.set(0);
		System.out.println("�ܹ�������"+total+"��");
		System.out.println("һ����"+count+"�ֽⷨ");
	}
	
	
	
	//��дһ�����������õ�n���ʺ�
	
	private void set(int n) {
		if(n == max) { // n = 8,��ʵ8���ʺ���Ѿ�������
			count++;
			print();
			return;
		}
		//���η���ʺ��ж��Ƿ��ͻ
		for(int i=0;i < max;i++) {
			//�ж�һ�����˶��ٴ�
			total++;
			//�Ȱѵ�ǰ����ʺ�n���ŵ����еĵ�1��
			array[n] = i;
			//�����õ�n���ʺ�i��ʱ���Ƿ��ͻ
			if(judge(n)) {
				//���ŷŵ�n+1���ʺ�,����ʼ�ݹ�
				set(n+1);
			}
			//�����ͻ,������n���ʺ�����ڱ��еĺ��Ƶ�һ��λ��
		}
	}
	
	
	
	

	//�鿴�����Ƿ��õ�n���ʺ�,��ȥ���ûʺ��Ƿ��ǰ���Ѿ��ڷŵĻʺ��ͻ
	/**
	 * 
	 * @param n ��ʾ���õĵ�n���ʺ�
	 * @return
	 */
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			//����array[i] == array[n]������ͬ
			//Ȼ�����Math.abs(n-i) == Math.abs(array[n]- array[i])
			//       �����n�е�nΪ5 ��i�е�i��3 ��ô5-3�ľ���ֵΪ2
			//           ��n�е��е�λ����array[n]
			//           ��i�е��е�λ����array[i]
			//ֻҪ��֮��Ĳ������֮��Ĳ���ʵ����һ��б��Ϊ1��ֱ�ߣ�Ҳ���Ǽн�Ϊ45��
			//��ζ���������ʺ���һ��б���ϡ�
			
			//û�б�Ҫ�ж��Ƿ���ͬһ�У���Ϊ����ÿ�ζ��ڵ���,ÿһ��ֻ�ܷ�һ����
			if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]- array[i])) {
				return false;
			}
		}
		return true;

	}
	
	//дһ�����������Խ��ʺ�ڷŵ�λ�����
	private void print() {
		for(int i = 0; i< array.length;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
