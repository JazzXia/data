package com.qtatelier.util;

//����HeroNode��ÿ��Node�������һ���ڵ�
//�˴������˵������һ���ڵ������Ĺؼ��������������������next��
//�������ж�����һ������
public class HeroNode {
	// ������
	public int no;
	public String name;
	public String nickname;
	// next��
	public HeroNode next;

	// ������
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	// Ϊ����ʾ���㣬��дtoString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}
