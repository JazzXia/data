package com.qtatelier.recursion;
/**
 * ���ڽ���Թ�����
 * @author JazzXdh
 *
 */
public class Maze {

	public static void main(String[] args) {
		//�ȴ���һ����ά���飬ģ���Թ�
		//��ͼ
		//δд���棬���д����Ļ�����ͨ��ѡ������ȡ�Թ��Ĵ�С��
		//�Զ������ϰ��
		int [][] map = new int [8][7]; 
		//ʹ��1��ʾ�ϰ������ǽ��
		//����ȫ����Ϊ1
		for(int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		//������ȫ����Ϊ1������ǽ��
		for(int i = 0; i < 8;i++) {
			map[i][0]=1;
			map[i][6]=1;
		}
		//���õ����ϰ���˴�����������ɣ�����Ϊ�˷�����ʾѡ��̶���
		map[2][2]=1;
		map[3][1]=1;
		map[3][2]=1;
		map[3][5]=1;
		map[5][3]=1;
		map[4][4]=1;
		
		//�����ͼ
		System.out.println("Ŀǰ���ɵĵ�ͼ����:");
		for(int i=0;i<8;i++) {
			for(int j =0;j<7;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		//ʹ�õݹ���ݸ�С����·
		//��->��->��->��
		//setWay(map, 1, 1);
		
		//��->��->��->��
		setWay2(map, 1, 1);
		//����µĵ�ͼ,С���߹��������ʶ���ĵ�ͼ
		System.out.println("����µĵ�ͼ,С���߹��������ʶ���ĵ�ͼ:");
		for(int i=0;i<8;i++) {
			for(int j =0;j<7;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	/**
	 * ����ҵ����·�������˺������С�������㷨֮��
	 * ���������ʹ����򵥵ģ������еĲ����г���
	 * Ȼ��������дһ����������Ѱ�����·��������ʹ��Map<String,int>������
	 * ֮��ͨ��������ͼ�ж��ж��ٸ�2��ô��Ӧ��String��int����Ŀ���Ǿ���
	 * �����2�ĸ������ٵľ������··��
	 *
	 */
	
	
	
	//ʹ�õݹ��������С����·
	//˵��
	//1.map��ʾ��ͼ
	//2.i,j��ʾ�ӵ�ͼ���Ǹ�λ�ÿ�ʼ����
	//3.���С���ܵ�map[6][5]λ�ã���˵��ͨ·�ҵ�
	//�����ڵ�ǰ��ģ�⣬��������ĸ������ƣ��������ȷ����ʼ�㣬���ȷ���յ㣬��ʹ�����ڵ�λ����Ϊ0��ʾ���ڡ�
	//4.Լ��:��map[i][j]Ϊ0ʱ����ʾ�õ�û���ߣ�1Ϊ��ʾ�ϰ��2λ�н�����ȷ·����3��ʾ��ǰ�߹����ǲ���ͨ·
	//5.�����Թ�ʱ����Ҫȷ��һ������(����)���������棬������治ͨ�������棬������滹��ͨ�����棬������治ͬ��
	//�������棬����õ��߲�ͨ���ͻ���
	//���ڲ��Զ��ԣ���ʵҲ�ǿ�������ģ���ÿ�����Զ�����һ����������ʹ�������������һ�����Լ��ɡ�
	/**
	 * 
	 * @param map ��ʾ��ͼ
	 * @param i   (i,j)��ʾ���ĸ�λ������
	 * @param j   
	 * @return    ��������ҵ�ͨ·��Ϊ�棬���û�ҵ���Ϊfalse
	 */
	//��->��->��->�� 
	public static boolean setWay(int[][] map,int i, int j) {
		if(map[6][5] == 2) {//ͨ·�Ѿ��ҵ�
			return true;
		}else {
			if(map[i][j] == 0) {//�����ǰ����㻹û���߹�
				//���ղ��� ��->��->��->�� ��
				map[i][j] = 2;//�ٶ��õ��ǿ�����ͨ��.
				if(setWay(map, i+1, j)) {//������
					return true;
				}else if(setWay(map, i, j+1)) {//������
					return true;
				}else if(setWay(map, i-1, j)) {//������
					return true;
				}else if(setWay(map, i, j-1)) {//������
					return true;
				}else {
					//˵���õ����߲�ͨ�ģ�����·
					map[i][j] = 3;
					return false;
				}
				
			}else { //���map[]i[j] != 0 ,������1,2,3
				return false;
			}
		}
	}
	
	//�޸���·�Ĳ���  ��->��->��->��
	public static boolean setWay2(int[][] map,int i, int j) {
		if(map[6][5] == 2) {//ͨ·�Ѿ��ҵ�
			return true;
		}else {
			if(map[i][j] == 0) {//�����ǰ����㻹û���߹�
				//���ղ��� ��->��->��->�� ��
				map[i][j] = 2;//�ٶ��õ��ǿ�����ͨ��.
				if(setWay2(map, i-1, j)) {//������
					return true;
				}else if(setWay2(map, i, j+1)) {//������
					return true;
				}else if(setWay2(map, i+1, j)) {//������
					return true;
				}else if(setWay2(map, i, j-1)) {//������
					return true;
				}else {
					//˵���õ����߲�ͨ�ģ�����·
					map[i][j] = 3;
					return false;
				}
				
			}else { //���map[]i[j] != 0 ,������1,2,3
				return false;
			}
		}
	}
}
