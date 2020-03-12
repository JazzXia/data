package com.qtatelier.sparsearray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SparseArray {

	public static void main(String[] args) throws IOException {
		// 创建一个二维数组 19*19表示十九路围棋的棋盘
		// 0: 表示当前位置为空，
		// 1: 表示当前位置为黑子
		// 2:表示当前位置为白子

		// 注:以下数据为模拟操作，并不等于实际。
		// 等复习完算法和数据结构，计划设计一款简易的围棋游戏。【用作复习使用】
		int goArr[][] = new int[19][19];
		goArr[1][2] = 1;
		goArr[1][8] = 1;
		goArr[3][5] = 1;
		goArr[2][4] = 2;
		goArr[7][8] = 2;
		goArr[10][15] = 2;
		// 输出棋盘
		// 这里使用了新循环，第一次将一维数组遍历出来，再嵌套一层循环将每个元素取出来,同时使用制表符
		System.out.println("棋局战况如下:");
		for (int[] row : goArr) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// 将二维数组转化为稀疏数组
		// 1.先遍历二维数组 得到非零的个数
		int sum = 0;
		// 此处goArr.length:为行，而goArr[0].length为列数
		for (int i = 0; i < goArr.length; i++) {
			for (int j = 0; j < goArr[0].length; j++) {
				if (goArr[i][j] != 0) {
					sum++;
				}
			}
		}

		// 2.创建对应的稀疏数组
		// 稀疏数组的行数除了有多少个非零数外，还有总计有多少行多少列，一共几个非零数。故sum+1
		// 而3是固定的分别定义行，列，值
		int sparseArr[][] = new int[sum + 1][3];
		// 给稀疏数组赋值
		sparseArr[0][0] = goArr.length;
		sparseArr[0][1] = goArr[0].length;
		sparseArr[0][2] = sum;
		// 遍历二维数组将非零的值存放到稀疏数组中
		int count = 0;// count用于记录是第几个非零数据
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
		// 接下来遍历稀疏数组检验一下是否创建成功

		System.out.println("棋盘保存为稀疏数组格式:");
		for (int[] row : sparseArr) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		// 结论与自己当时定义的值完全一致!!

		/**
		 * 并将之保存在磁盘里chess.dat 推荐使用相对路径
		 */
		PrintWriter pw = new PrintWriter("chess.dat", "UTF-8");
		for (int i = 0; i < sparseArr.length; i++) {
			pw.println(sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" + sparseArr[i][2]);
		}
		pw.close();
		System.out.println("保存成功!");

		System.out.println();

		FileInputStream fis = new FileInputStream("chess.dat");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);

		/**
		 * 接下来我们将从磁盘中读取chess.dat 并将之传给稀疏数组
		 */
		String line = null;
		System.out.println("读取数据");
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();

		// 将稀疏数组恢复成棋盘的二维数组
		// 1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
		System.out.println();
		int goArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		// 在读取稀疏数组后几行的数据，并赋值给二维数组，即可恢复棋盘
		// 我们不从零开始因为第一行写的是共多少行多少列，一共有多少非零数
		for (int i = 1; i < sparseArr.length; i++) {
			goArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		System.out.println();
		System.out.println("恢复以下棋谱!");
		for (int[] row : goArr2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

	}

}
