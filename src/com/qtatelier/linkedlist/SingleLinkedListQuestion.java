package com.qtatelier.linkedlist;

import java.util.Stack;

import com.qtatelier.util.HeroNode;
import com.qtatelier.util.SingleLinkedList;;

/**
 * 此处我将之前的SingleLLinkedListDemo中的单链表的CRUD封装到util包下面，要使用只需要调用即可
 * 
 * @author JazzXdh
 *
 */
public class SingleLinkedListQuestion {
	/**
	 * 问题:求单链表中有效节点的个数
	 */
	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "德鲁伊", "JazzXia");
		HeroNode hero2 = new HeroNode(2, "暗牧", "WEI");
		HeroNode hero3 = new HeroNode(3, "龙骑士", "Xia");
		HeroNode hero4 = new HeroNode(4, "亚龙", "Jazz");
		HeroNode hero5 = new HeroNode(5, "熊猫酒仙", "JJJ");
		HeroNode hero6 = new HeroNode(6, "影魔", "JazzXia");
		HeroNode hero7 = new HeroNode(7, "蓝猫", "WEI");
		HeroNode hero8 = new HeroNode(8, "蓝胖", "Xia");
		HeroNode hero9 = new HeroNode(9, "双头龙", "Jazz");
		HeroNode hero10 = new HeroNode(10, "死亡先知", "JJJ");

		// 创建单链表
		SingleLinkedQuestionHandle singleLinkedList = new SingleLinkedQuestionHandle();

		SingleLinkedQuestionHandle singleLinkedList1 = new SingleLinkedQuestionHandle();
		// 按照编号的顺序

		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero5);
		singleLinkedList.addByOrder(hero7);
		singleLinkedList.addByOrder(hero10);

		singleLinkedList1.addByOrder(hero1);
		singleLinkedList1.addByOrder(hero4);
		singleLinkedList1.addByOrder(hero6);
		singleLinkedList1.addByOrder(hero8);
		singleLinkedList1.addByOrder(hero9);

		singleLinkedList.list();
		singleLinkedList1.list();

		System.out.println("有效节点一共有:" + singleLinkedList.getLength(singleLinkedList.getHead()) + "个");

		/**
		 * 查找单链表中的倒数第k个节点【新浪面试题】
		 */
		singleLinkedList.info(3, singleLinkedList);

		/**
		 * 合并两个有序的单链表，合并之后的链表依然有序【归并排序】 对于此题目我只有一个思路，步骤如下： 1.首先新建一个新的头结点
		 * 2.将两个链表同时遍历遍历的同时比较插入顺序 如果插入的时候两个序号一样，那么就报错，不能使用同一个序号
		 */
		singleLinkedList.merge(singleLinkedList.getHead(), singleLinkedList1.getHead());
		System.out.println("将两个合并");
		singleLinkedList1.list();

		/**
		 * 单链表的反转【腾讯面试题】
		 */
		singleLinkedList.reverseList(singleLinkedList.getHead());
		System.out.println("链表的反转");
		singleLinkedList.list();

		/**
		 * 从尾到头打印单链表【百度面试题】 方法一：先将单链表反转操作，然后再遍历 【这样做会出现问题：1.破坏原来单链表的结构
		 * 2.太过复杂，而且效率低，浪费空间】 方法二：可以利用栈这个数据结构，将各个节点压入到栈中， 然后利用栈的先进后出的特点，就实现了逆序打印的效果
		 * 栈【stack:英文翻译过来就是一堆的意思】 在汇编中学过对于入栈是push出栈是pop相应的其SP要-2 每压一次栈减一次2
		 * 在Java中入栈有两个方法一个是push一个是add 为什么add也可以因为stack继承了vector这个类的add方法
		 */
		System.out.println("逆序打印单链表");
		// 由于上一个题目是将其反转，现在将反转的链表逆序
		singleLinkedList.reversePrint(singleLinkedList.getHead());

	}

}

class SingleLinkedQuestionHandle extends SingleLinkedList {

	// 方法:获取到单链表的节点的个数(如果是带头结点，不需要统计头结点)
	/**
	 * 
	 * @param head:参数是链表的头结点【插入头结点便可知返回值】
	 * @return 链表的长度
	 */
	public int getLength(HeroNode head) {
		if (isEmpty()) {// 空链表
			return 0;
		}
		int length = 0;
		// 定义一个辅助变量
		HeroNode cur = head.next;
		while (cur != null) {
			length++;
			cur = cur.next;// 遍历
		}
		return length;
	}

	// 问题二的方法:
	// 1.首先先获取所有有效节点个数【除去头结点】
	// 2.然后拿总的节点数-倒数的那个数字+1
	public void info(int no, SingleLinkedQuestionHandle singleLinkedQuestionHandle) {
		HeroNode head = singleLinkedQuestionHandle.getHead();
		HeroNode temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;// 已经遍历完
			}
			if (temp.no == singleLinkedQuestionHandle.getLength(head) - no + 1) {
				flag = true;
				break;
			}
			temp = temp.next;

		}

		if (flag) {
			System.out.println(temp);
		} else {
			System.out.println("超出限制");
		}
	}

	// 问题三:单链表的反转的解决办法
	// 根据之前学习天勤的经验，我认为可行的办法如下
	// 1.先创建一个新的头结点【即新链表】
	// 2.随后将其链表遍历每一个节点，
	// 3.将节点从后向前添加
	public void reverseList(HeroNode head) {
		if (head.next == null || head.next.next == null) {
			System.out.println("链表元素过少,不需要反转");
			return;
		}
		// 定义辅助指针，帮助我们遍历链表
		HeroNode current = head.next;
		HeroNode next = null;// 指向当前节点[current]的下一个节点
		HeroNode reverseHead = new HeroNode(0, "", "");// 定义一个新节点
		while (current != null) {
			next = current.next;// 保存当前节点的下一个节点，后面需要使用
			current.next = reverseHead.next;// 这个地方其实是将新链表的头结点的所有后面的东西，
											// 都放到当前节点的后面下一句就是将新的头结点与当前节点相连
			reverseHead.next = current;
			current = next;

		}
		// 将head.next指向reverseHead.next,实现单链表的反转
		head.next = reverseHead.next;

	}

	/**
	 * 问题四:从尾到头打印单链表【百度面试题】
	 */
	public void reversePrint(HeroNode head) {
		if (isEmpty()) {
			System.out.println("为空链表无法打印");
		}

		// 创建一个栈将每个节点压入栈
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode current = head.next;
		// 将链表的所有节点压入栈中
		while (current != null) {
			stack.push(current);
			current = current.next;
		}
		// 将栈中节点进行打印
		while (stack.size() > 0) {
			System.out.println(stack.pop());

		}
	}

	/**
	 * 问题五:合并两个有序的单链表，合并之后的链表依然有序【归并排序】
	 */
	public void merge(HeroNode head1, HeroNode head2) {
		if (head1.next == null || head2.next == null) {
			System.out.println("有为空的链表,不需要合并");
		}

		// 创建三个辅助变量
		HeroNode temp1 = head1.next;
		HeroNode temp2 = head2.next;
		HeroNode temp3 = null;// 标记最后的一个节点[归并的那个链表]
		// 新建一个头结点
		HeroNode unitHead = new HeroNode(0, "", "");
		temp3 = unitHead;
		while (temp1 != null && temp2 != null) {
			if (temp1.no < temp2.no) {
				temp3.next = temp1;
				temp1 = temp1.next;
				temp3 = temp3.next;
			} else if (temp1.no > temp2.no) {
				temp3.next = temp2;
				temp2 = temp2.next;
				temp3 = temp3.next;
			} else {
				System.out.println("有相同元素无法添加");
				break;
			}
			if (temp1 != null) {
				temp3.next = temp1;
			}
			if (temp2 != null) {
				temp3.next = temp2;
			}
		}

	}

}
