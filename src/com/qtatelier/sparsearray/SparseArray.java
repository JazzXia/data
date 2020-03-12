package com.qtatelier.sparsearray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SparseArray {

	public static void main(String[] args) throws IOException {
		// ����һ����ά���� 19*19��ʾʮ��·Χ�������
		// 0: ��ʾ��ǰλ��Ϊ�գ�
		// 1: ��ʾ��ǰλ��Ϊ����
		// 2:��ʾ��ǰλ��Ϊ����

		// ע:��������Ϊģ���������������ʵ�ʡ�
		// �ȸ�ϰ���㷨�����ݽṹ���ƻ����һ����׵�Χ����Ϸ����������ϰʹ�á�
		int goArr[][] = new int[19][19];
		goArr[1][2] = 1;
		goArr[1][8] = 1;
		goArr[3][5] = 1;
		goArr[2][4] = 2;
		goArr[7][8] = 2;
		goArr[10][15] = 2;
		// �������
		// ����ʹ������ѭ������һ�ν�һά���������������Ƕ��һ��ѭ����ÿ��Ԫ��ȡ����,ͬʱʹ���Ʊ��
		System.out.println("���ս������:");
		for (int[] row : goArr) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// ����ά����ת��Ϊϡ������
		// 1.�ȱ�����ά���� �õ�����ĸ���
		int sum = 0;
		// �˴�goArr.length:Ϊ�У���goArr[0].lengthΪ����
		for (int i = 0; i < goArr.length; i++) {
			for (int j = 0; j < goArr[0].length; j++) {
				if (goArr[i][j] != 0) {
					sum++;
				}
			}
		}

		// 2.������Ӧ��ϡ������
		// ϡ����������������ж��ٸ��������⣬�����ܼ��ж����ж����У�һ����������������sum+1
		// ��3�ǹ̶��ķֱ����У��У�ֵ
		int sparseArr[][] = new int[sum + 1][3];
		// ��ϡ�����鸳ֵ
		sparseArr[0][0] = goArr.length;
		sparseArr[0][1] = goArr[0].length;
		sparseArr[0][2] = sum;
		// ������ά���齫�����ֵ��ŵ�ϡ��������
		int count = 0;// count���ڼ�¼�ǵڼ�����������
		for (int i = 0; i < goArr.length; i++) {
			for (int j = 0; j < goArr[0].length; j++) {
				if (goArr[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = goArr[i][j];
				}
			}

		}
		System.out.println();
		// ����������ϡ���������һ���Ƿ񴴽��ɹ�

		System.out.println("���̱���Ϊϡ�������ʽ:");
		for (int[] row : sparseArr) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		// �������Լ���ʱ�����ֵ��ȫһ��!!

		/**
		 * ����֮�����ڴ�����chess.dat �Ƽ�ʹ�����·��
		 */
		PrintWriter pw = new PrintWriter("chess.dat", "UTF-8");
		for (int i = 0; i < sparseArr.length; i++) {
			pw.println(sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" + sparseArr[i][2]);
		}
		pw.close();
		System.out.println("����ɹ�!");

		System.out.println();

		FileInputStream fis = new FileInputStream("chess.dat");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		/**
		 * ���������ǽ��Ӵ����ж�ȡchess.dat ����֮����ϡ������
		 */
		String line = null;
		System.out.println("��ȡ����");
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();

		// ��ϡ������ָ������̵Ķ�ά����
		// 1.�ȶ�ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�����ԭʼ�Ķ�ά����
		System.out.println();
		int goArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		// �ڶ�ȡϡ��������е����ݣ�����ֵ����ά���飬���ɻָ�����
		// ���ǲ����㿪ʼ��Ϊ��һ��д���ǹ������ж����У�һ���ж��ٷ�����
		for (int i = 1; i < sparseArr.length; i++) {
			goArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		System.out.println();
		System.out.println("�ָ���������!");
		for (int[] row : goArr2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

	}

}
