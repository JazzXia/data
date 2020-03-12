package com.qtatelier.util;

//定义HeroNode，每个Node对象就是一个节点
//此处定义了单链表的一个节点真正的关键的两个东西【数据域和next域】
//数据域中定义了一堆属性
public class HeroNode {
	// 数据域
	public int no;
	public String name;
	public String nickname;
	// next域
	public HeroNode next;

	// 构造器
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	// 为了显示方便，重写toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
