package com.qtatelier.recursion;
/**
 * 用于解决迷宫问题
 * @author JazzXdh
 *
 */
public class Maze {

	public static void main(String[] args) {
		//先创建一个二维数组，模拟迷宫
		//地图
		//未写界面，如果写界面的话可以通过选择来获取迷宫的大小，
		//自动生成障碍物。
		int [][] map = new int [8][7]; 
		//使用1表示障碍物【或者墙】
		//上下全部置为1
		for(int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		//将左右全部置为1由于是墙壁
		for(int i = 0; i < 8;i++) {
			map[i][0]=1;
			map[i][6]=1;
		}
		//设置挡板障碍物，此处可以随机生成，但是为了方便演示选择固定的
		map[2][2]=1;
		map[3][1]=1;
		map[3][2]=1;
		map[3][5]=1;
		map[5][3]=1;
		map[4][4]=1;
		
		//输出地图
		System.out.println("目前生成的地图如下:");
		for(int i=0;i<8;i++) {
			for(int j =0;j<7;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		//使用递归回溯给小球找路
		//下->右->上->左
		//setWay(map, 1, 1);
		
		//上->右->下->左
		setWay2(map, 1, 1);
		//输出新的地图,小球走过，并表标识过的地图
		System.out.println("输出新的地图,小球走过，并表标识过的地图:");
		for(int i=0;i<8;i++) {
			for(int j =0;j<7;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	/**
	 * 如何找到最短路径，除了后面的最小生成树算法之外
	 * 在这里可以使用最简单的，将所有的策略列出来
	 * 然后再重新写一个方法用于寻找最短路径，可以使用Map<String,int>来接收
	 * 之后通过遍历地图判断有多少个2那么对应的String的int的数目就是距离
	 * 到最后2的个数最少的就是最短路路径
	 *
	 */
	
	
	
	//使用递归回溯来给小球找路
	//说明
	//1.map表示地图
	//2.i,j表示从地图的那个位置开始出发
	//3.如果小球能到map[6][5]位置，则说明通路找到
	//【由于当前是模拟，如果想做的更加完善，可以随机确定起始点，随机确定终点，并使其所在的位置置为0表示出口】
	//4.约定:当map[i][j]为0时，表示该点没有走，1为表示障碍物，2位行进的正确路径，3表示当前走过但是不是通路
	//5.在走迷宫时，需要确定一个策略(方法)，先走下面，如果下面不通才走右面，如果右面还不通走上面，如果上面不同，
	//就走左面，如果该点走不通，就回溯
	//对于策略而言，其实也是可以随机的，将每条策略都定义一个常量，并使得随机数获得随机一个策略即可。
	/**
	 * 
	 * @param map 表示地图
	 * @param i   (i,j)表示从哪个位置来找
	 * @param j   
	 * @return    返回如果找到通路就为真，如果没找到就为false
	 */
	//下->右->上->左 
	public static boolean setWay(int[][] map,int i, int j) {
		if(map[6][5] == 2) {//通路已经找到
			return true;
		}else {
			if(map[i][j] == 0) {//如果当前这个点还没有走过
				//按照策略 下->右->上->左 走
				map[i][j] = 2;//假定该点是可以走通的.
				if(setWay(map, i+1, j)) {//向下走
					return true;
				}else if(setWay(map, i, j+1)) {//向右走
					return true;
				}else if(setWay(map, i-1, j)) {//向上走
					return true;
				}else if(setWay(map, i, j-1)) {//向左走
					return true;
				}else {
					//说明该点是走不通的，是死路
					map[i][j] = 3;
					return false;
				}
				
			}else { //如果map[]i[j] != 0 ,可能是1,2,3
				return false;
			}
		}
	}
	
	//修改找路的策略  上->右->下->左
	public static boolean setWay2(int[][] map,int i, int j) {
		if(map[6][5] == 2) {//通路已经找到
			return true;
		}else {
			if(map[i][j] == 0) {//如果当前这个点还没有走过
				//按照策略 上->右->下->左 走
				map[i][j] = 2;//假定该点是可以走通的.
				if(setWay2(map, i-1, j)) {//向下走
					return true;
				}else if(setWay2(map, i, j+1)) {//向右走
					return true;
				}else if(setWay2(map, i+1, j)) {//向上走
					return true;
				}else if(setWay2(map, i, j-1)) {//向左走
					return true;
				}else {
					//说明该点是走不通的，是死路
					map[i][j] = 3;
					return false;
				}
				
			}else { //如果map[]i[j] != 0 ,可能是1,2,3
				return false;
			}
		}
	}
}
