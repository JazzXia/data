package com.qtatelier.linkedlist;

/**
 * 双向链表
 * @author JazzXdh
 *
 */
public interface DoubleLinkedListDemo {
	public static void main(String[] args) {
		//测试节点插入的功能和遍历链表的功能
		DHeroNode d1 = new DHeroNode(1, "天使", "JazzXia");
		DHeroNode d2 = new DHeroNode(2, "死神", "Ten");
		DHeroNode d3 = new DHeroNode(3, "源氏", "Jazz");
		DHeroNode d4 = new DHeroNode(4, "铁拳", "SS");
		DHeroNode d5 = new DHeroNode(5, "麦克雷", "JazzXia");
		
		DoubleLinkedList list = new DoubleLinkedList();
		//Debug之后可以看见每一个节点的pre和next所以创建成功!
/*		list.add(d1);
		list.add(d2);
		list.add(d5);
		list.add(d3);
		list.add(d4);
		System.out.println("无序的插入");
		list.list();*/
		
		list.addByOrder(d5);
		list.addByOrder(d1);
		list.addByOrder(d2);
		list.addByOrder(d4);
		list.addByOrder(d3);
		
		System.out.println("有序的插入");
		list.list();
		
		//测试修改节点
		list.update(new DHeroNode(4, "温斯顿", "Jazz"));
		System.out.println("修改节点");
		list.list();
		
		//测试删除节点
		list.delete(1);
		System.out.println("测试删除节点");
		list.list();
	}
}

//双向链表类
class DoubleLinkedList{
	// 先初始化一个头结点，头结点不要动【它是一个标记】,不存放具体的数据
	private DHeroNode head = new DHeroNode(0, "", "");

	public DHeroNode getHead() {
		return head;
	}

	
	//遍历双向链表的方法
	public void list() {
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		DHeroNode temp = head.next;
		while(true) {
			if(temp == null) {
				break;
			}
			
			System.out.println(temp);
			temp = temp.next;
		}
	}
	
	//添加节点到双向链表
	//思路：使用尾插法1.找到最后一个节点，然后将最后一个结点的next给要插入的节点(由于默认为null可以不写)
	//			     2.并且将temp.next指向新的节点
	//               3.将要插入的节点的pre赋值为之前的为后一个节点
	
	public void add(DHeroNode node) {
		//首先定义一个辅助变量
		DHeroNode temp = head;
		//首先找到链表的最后
		while(true) {
			if(temp.next == null) {
				break;
			}
			//如果没到最后那就继续向后面移动
			temp = temp.next;
		}
		//当退出循环的时候开始插入链表
		node.next = temp.next;
		temp.next = node;
		node.pre = temp;
		
	}
	
	
	//按照顺序添加双向链表
	public void addByOrder(DHeroNode heroNode) {
		//首先定义辅助变量
		DHeroNode temp = head;
		boolean flag = false;
		while(true) {//每次都是从头到尾来遍历一遍
			if(temp.next == null) {
				break;
			}
			
			if(temp.next.no > heroNode.no) {
				break;
			}else if(temp.next.no == heroNode.no) {
				flag =true;
				break;
			}
			temp = temp.next;
		}
		
		if(flag) {
			System.out.printf("准备插入的角色的编号%d 已经存在，不能加入\n", heroNode.no);
		}else {			
			heroNode.next = temp.next;
			temp.next = heroNode;
			heroNode.pre =temp;
		}
	}
	

	//修改节点信息
	public void update(DHeroNode node) {
		if(node==null) {
			System.out.println("链表为空~");
			return;
		}
		
		DHeroNode temp = head;
		boolean flag =false;
		while(true) {
			if (temp == null) {
				break;// 已经遍历完
			}
			if(temp.no == node.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if(flag) {
			temp.name = node.name;
			temp.nickname = node.nickname;
			
		}else {
			System.out.printf("没有找到编号为%d的节点,不能修改\n", node.no);
		}
	}
	
	//删除节点
	public void delete(int no) {
		if(head.next==null) {
			System.out.println("链表为空~不需要删除!");
			return;
		}
		DHeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next==null) {
				break;//遍历完全
			}
			
			if(temp.no==no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if(flag) {
			temp.pre.next =  temp.next;
			temp.next.pre = temp.pre;
		}else {
			System.out.printf("没有找到编号为%d的节点,不能删除\n", no);
		}
		
		
	}
	
	
	
}



 class DHeroNode {
	// 数据域
	public int no;
	public String name;
	public String nickname;
	public DHeroNode next;//指向下一个节点
	public DHeroNode pre; //指向前一个节点

	// 构造器
	public DHeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	
	
	// 为了显示方便，重写toString
	@Override
	public String toString() {
		return "DHeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}




