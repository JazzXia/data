package com.qtatelier.util;

import com.qtatelier.util.HeroNode;

public class SingleLinkedList {
	// 先初始化一个头结点，头结点不要动【它是一个标记】,不存放具体的数据
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}

	public void setHead(HeroNode head) {
		this.head = head;
	}

	// 添加节点到单链表
	// 思路,当不考虑编号顺序时
	// 1.找到当前链表的最后节点
	// 2.将最后这个节点的next 指向新的节点
	// 【其实链表的插入方法有很多种，主要有头插法和尾插法】
	// 这里使用的是尾插法
	// 【头插法的思路】
	// 1.找到当前节点的头结点，
	// 2.将头结点的next指向新的节点
	// 3.新的节点的next指向之前头结点指向的节点。
	// 【尾插法的思路】
	// 1.找到当前节点的下一个是null
	// 2.将当前的节点的null指向新的节点。
	// 3.因为新的节点next为默认为null
	// 【头插法的思路已写出，具体看需求】相较于C++的算法，本质是一样的
	public void add(HeroNode hearNode) {
		// 因为head节点是一个标记，因此我们需要一个辅助指针 temp。
		// 用它来代替head的作用【详情可以看帅辉天勤的数据结构的图解】
		HeroNode temp = head;
		// 遍历链表，找到最后
		while (true) {
			// 判断是否是最后
			if (temp.next == null) {
				break;
			}
			// 如果不是最后,就将temp后移
			temp = temp.next;
		}
		// 当退出while循环时，temp就指向了链表的最后
		// 将最后这个节点的next指向新的节点
		temp.next = hearNode;
	}

	// 第二种方式再添加角色时，更具排名将角色插入到指定位置
	// (如果有这个排名，则添加失败，并给出提示)
	public void addByOrder(HeroNode heroNode) {
		// 由于头结点不能动,故还定义一个辅助指针
		// 因为我们找的temp是位于添加位置的前一个节点，否则插入不了
		HeroNode temp = head;
		boolean flag = false;// 标识添加的编号是否存在,默认是false
		while (true) {
			if (temp.next == null) {// 说明temp已经在链表的最后
				break;
			}
			/**
			 * 此处解释: 为什么不是和temp比较而是和temp.next来比较 由于知道此情景是递增的情景，所以temp.no必定小于temp.next.no
			 * 假设直接比较temp 那么，当heroNode.no>temp.no就插入到temp的后面 当heroNode.no<temp.no就插入到temp的前面
			 * 以上有一个弊端【自我理解】 单链表不好获取上一个节点的信息所以插入到前面不好插【不是双向链表】 那么,使用temp.next的好处在哪呢
			 * 好处就在于使用temp.next.no
			 */
			if (temp.next.no > heroNode.no) {// 找到插入位置，就在temp的后面插入
				break;
			} else if (temp.next.no == heroNode.no) {// 说明希望添加的heroNode的编号依然存在
				flag = true;// 说明编号存在
				break;
			}
			temp = temp.next;// 后移，遍历当前链表
		}
		// 判断flag的值
		if (flag) {// 如果flag的值为真(true)，说明编号存在不能添加
			System.out.printf("准备插入的角色的编号%d 已经存在，不能加入\n", heroNode.no);

		} else {
			// 插入到链表中，temp的后面
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	// 链表为空
	public boolean isEmpty() {
		return head.next == null;
	}

	// 修改节点的信息，根据no编号来修改，即no编号不能修改
	// 说明
	// 1.根据newHeroNode的no来修改即可(参数是新的一个节点)
	public void update(HeroNode newHeroNode) {
		// 判空
		if (isEmpty()) {
			System.out.println("链表为空~");
			return;
		}
		// 找到需要修改的节点，根据no编号
		// 先定义一个辅助变量
		HeroNode temp = head.next;
		boolean flag = false;// 表示是否找到该节点
		while (true) {
			if (temp == null) {
				break;// 已经遍历完
			}
			if (temp.no == newHeroNode.no) {
				// 找到节点
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 根据flag 判断是否找到要修改的节点
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;

		} else {
			System.out.printf("没有找到编号为%d的节点,不能修改\n", newHeroNode.no);
		}
	}

	// 删除节点
	// 主要做法就是:
	// 1.首先要找到节点
	// 2.找到节点之后将此节点之前的一个节点.next = 此节点.next

	public void delete(int no) {
		if (isEmpty()) {
			System.out.println("链表为空~不需要删除!");
			return;
		}
		HeroNode temp = head;
		boolean flag = false;// 是否找到待删除节点的前一个节点
		while (true) {
			if (temp.next == null) {
				break;// 已经遍历完
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}

		// 其实可以不需要flag写这个是为了方便
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.printf("没有找到编号为%d的节点,不能删除\n", no);
		}

	}

	// 显示链表[遍历]
	public void list() {
		// 判断链表是否为空
		if (isEmpty()) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点，不能动，是一个标志，代表了一整个链表
		// 由此我们找一个辅助变量来代替头结点
		HeroNode temp = head.next;
		while (true) {
			// 判断是否到链表的最后
			if (temp == null) {
				break;
			}
			// 输出节点的信息
			System.out.println(temp);
			// 随后将temp后移，指向下一个节点进行输出，
			// 要不然永远都会指向同一个值，陷入死循环
			temp = temp.next;
		}
	}

}
