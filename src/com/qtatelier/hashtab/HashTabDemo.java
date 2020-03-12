package com.qtatelier.hashtab;

import java.util.Scanner;

/**
 * 哈希表的应用
 * @author JazzXdh
 *
 */
public class HashTabDemo {

	public static void main(String[] args) {
		//创建哈希表
		HashTab hashTab = new HashTab(7);
		
		//写一个简单菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("add:  添加雇员");
			System.out.println("list: 显示雇员");
			System.out.println("find: 查找雇员");
			System.out.println("exit: 退出系统");
			
			key = scanner.next();
			switch(key) {
			case "add":
				System.out.println("输入id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
				String name = scanner.next();
				//创建 雇员
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("输入要查找的id");
				id = scanner.nextInt();
				hashTab.findEmpById(id);
				break;				
			case "exit":
				scanner.close();
				loop = false; //或者直接写System.exit(0);
				break;
			default:
				break;
			}
		}
	}
}


//创建HashTab 管理多条链表
class HashTab{
	private EmpLinkedList[] empLinkedListArray;//创建数组，数组中放了链表
	private int size;//链表的数量
	
	//构造器
	public HashTab(int size) {
		this.size = size;
		//初始化链表的数量
		empLinkedListArray = new EmpLinkedList[size];
		//这时不要忘记分别初始化每个链表【如果不初始化，那么就不存在链表，也就没有空间来存放链表的数据】
		for(int i = 0; i<size;i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}
	}
	//添加雇员
	public void add(Emp emp) {
		//根据员工的id，得到该员工应当添加到哪条链表
		int empLinkedListNO = hashFun(emp.id);
		//将emp添加到对应的链表中
		empLinkedListArray[empLinkedListNO].add(emp);
	}
	
	//遍历所有的链表，遍历哈希表
	public void list() {
		for(int i = 0; i< size; i++) {
			empLinkedListArray[i].list(i);
		}
	}
	
	//根据输入的id查找雇员
	public void findEmpById(int id) {
		//使用散列函数确定到哪条链表查找
		int empLinkedListNo = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
		if(emp != null) {//找到
			System.out.printf("在第%d条链表中找到雇员id = %d,姓名为=%s\n", (empLinkedListNo + 1), id, emp.name);
		}else {
			System.out.println("在哈希表中，没有找到该雇员~");
		}
	}
	
	//编写散列函数，使用一个简单的取模法
	public int hashFun(int id) {
		return id % size;
	}
}






//表示一个雇员节点
class Emp{
	public int id;
	public String name;
	public Emp next;//指向下一个节点默认为空
	public Emp(int id,String name) {
		super();
		this.id =id;
		this.name = name;
	}
}

//创建EmpLinkedList，表示链表
class EmpLinkedList {

	// 头指针，指向第一个Emp,因此我们这个链表的head是直接指向第一个Emp,即没有头结点,也就是说头结点就指的是第一个节点
	private Emp head;// 默认为空null

	// 添加雇员到链表
	// 说明
	// 1.假定，当添加雇员时，id是自增长的，即id的分配总是从小到大
	// 因此，我们将该雇员直接加入到本链表最后一个即可
	public void add(Emp emp) {
		// 如果是添加第一个雇员
		if (head == null) {
			head = emp;
			return;
		}
		// 如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
		Emp curEmp = head;
		while (true) {
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		// 退出时直接将emp 加入链表
		curEmp.next = emp;
	}

	// 遍历链表的雇员信息
	public void list(int no) {
		if (head == null) {// 说明链表为空
			System.out.println("第"+(no+1)+"链表为空。");
			return;
		}
		System.out.println("第"+(no+1)+"链表的信息为");
		Emp curEmp = head;// 辅助指针
		while (true) {
			System.out.printf("=> id =%d name=%s\t", curEmp.id, curEmp.name);
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;// 后移，遍历
		}
		System.out.println();
	}

	//根据id查找雇员
	//如果查找到就返回Emp,如果没有找到，就返回空
	public Emp findEmpById(int id) {
		//判断链表是否为空
		if(head == null) {
			System.out.println("链表为空。");
			return null;
		}
		//辅助指针
		Emp curEmp = head;
		while(true) {
			if(curEmp.id == id) {//说明找到
				break;//这时curEmp就只想要查找的雇员
			}
			//退出条件
			if(curEmp.next == null) {//说明遍历当前链表没有找到雇员
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;//后移
		}
		return curEmp;
	}
}