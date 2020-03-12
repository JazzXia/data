package com.qtatelier.util;

import com.qtatelier.util.HeroNode;

public class SingleLinkedList {
	// �ȳ�ʼ��һ��ͷ��㣬ͷ��㲻Ҫ��������һ����ǡ�,����ž��������
	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return head;
	}

	public void setHead(HeroNode head) {
		this.head = head;
	}

	// ��ӽڵ㵽������
	// ˼·,�������Ǳ��˳��ʱ
	// 1.�ҵ���ǰ��������ڵ�
	// 2.���������ڵ��next ָ���µĽڵ�
	// ����ʵ����Ĳ��뷽���кܶ��֣���Ҫ��ͷ�巨��β�巨��
	// ����ʹ�õ���β�巨
	// ��ͷ�巨��˼·��
	// 1.�ҵ���ǰ�ڵ��ͷ��㣬
	// 2.��ͷ����nextָ���µĽڵ�
	// 3.�µĽڵ��nextָ��֮ǰͷ���ָ��Ľڵ㡣
	// ��β�巨��˼·��
	// 1.�ҵ���ǰ�ڵ����һ����null
	// 2.����ǰ�Ľڵ��nullָ���µĽڵ㡣
	// 3.��Ϊ�µĽڵ�nextΪĬ��Ϊnull
	// ��ͷ�巨��˼·��д�������忴���������C++���㷨��������һ����
	public void add(HeroNode hearNode) {
		// ��Ϊhead�ڵ���һ����ǣ����������Ҫһ������ָ�� temp��
		// ����������head�����á�������Կ�˧�����ڵ����ݽṹ��ͼ�⡿
		HeroNode temp = head;
		// ���������ҵ����
		while (true) {
			// �ж��Ƿ������
			if (temp.next == null) {
				break;
			}
			// ����������,�ͽ�temp����
			temp = temp.next;
		}
		// ���˳�whileѭ��ʱ��temp��ָ������������
		// ���������ڵ��nextָ���µĽڵ�
		temp.next = hearNode;
	}

	// �ڶ��ַ�ʽ����ӽ�ɫʱ��������������ɫ���뵽ָ��λ��
	// (�������������������ʧ�ܣ���������ʾ)
	public void addByOrder(HeroNode heroNode) {
		// ����ͷ��㲻�ܶ�,�ʻ�����һ������ָ��
		// ��Ϊ�����ҵ�temp��λ�����λ�õ�ǰһ���ڵ㣬������벻��
		HeroNode temp = head;
		boolean flag = false;// ��ʶ��ӵı���Ƿ����,Ĭ����false
		while (true) {
			if (temp.next == null) {// ˵��temp�Ѿ�����������
				break;
			}
			/**
			 * �˴�����: Ϊʲô���Ǻ�temp�Ƚ϶��Ǻ�temp.next���Ƚ� ����֪�����龰�ǵ������龰������temp.no�ض�С��temp.next.no
			 * ����ֱ�ӱȽ�temp ��ô����heroNode.no>temp.no�Ͳ��뵽temp�ĺ��� ��heroNode.no<temp.no�Ͳ��뵽temp��ǰ��
			 * ������һ���׶ˡ�������⡿ �������û�ȡ��һ���ڵ����Ϣ���Բ��뵽ǰ�治�ò塾����˫������ ��ô,ʹ��temp.next�ĺô�������
			 * �ô�������ʹ��temp.next.no
			 */
			if (temp.next.no > heroNode.no) {// �ҵ�����λ�ã�����temp�ĺ������
				break;
			} else if (temp.next.no == heroNode.no) {// ˵��ϣ����ӵ�heroNode�ı����Ȼ����
				flag = true;// ˵����Ŵ���
				break;
			}
			temp = temp.next;// ���ƣ�������ǰ����
		}
		// �ж�flag��ֵ
		if (flag) {// ���flag��ֵΪ��(true)��˵����Ŵ��ڲ������
			System.out.printf("׼������Ľ�ɫ�ı��%d �Ѿ����ڣ����ܼ���\n", heroNode.no);

		} else {
			// ���뵽�����У�temp�ĺ���
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	// ����Ϊ��
	public boolean isEmpty() {
		return head.next == null;
	}

	// �޸Ľڵ����Ϣ������no������޸ģ���no��Ų����޸�
	// ˵��
	// 1.����newHeroNode��no���޸ļ���(�������µ�һ���ڵ�)
	public void update(HeroNode newHeroNode) {
		// �п�
		if (isEmpty()) {
			System.out.println("����Ϊ��~");
			return;
		}
		// �ҵ���Ҫ�޸ĵĽڵ㣬����no���
		// �ȶ���һ����������
		HeroNode temp = head.next;
		boolean flag = false;// ��ʾ�Ƿ��ҵ��ýڵ�
		while (true) {
			if (temp == null) {
				break;// �Ѿ�������
			}
			if (temp.no == newHeroNode.no) {
				// �ҵ��ڵ�
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// ����flag �ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;

		} else {
			System.out.printf("û���ҵ����Ϊ%d�Ľڵ�,�����޸�\n", newHeroNode.no);
		}
	}

	// ɾ���ڵ�
	// ��Ҫ��������:
	// 1.����Ҫ�ҵ��ڵ�
	// 2.�ҵ��ڵ�֮�󽫴˽ڵ�֮ǰ��һ���ڵ�.next = �˽ڵ�.next

	public void delete(int no) {
		if (isEmpty()) {
			System.out.println("����Ϊ��~����Ҫɾ��!");
			return;
		}
		HeroNode temp = head;
		boolean flag = false;// �Ƿ��ҵ���ɾ���ڵ��ǰһ���ڵ�
		while (true) {
			if (temp.next == null) {
				break;// �Ѿ�������
			}
			if (temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}

		// ��ʵ���Բ���Ҫflagд�����Ϊ�˷���
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.printf("û���ҵ����Ϊ%d�Ľڵ�,����ɾ��\n", no);
		}

	}

	// ��ʾ����[����]
	public void list() {
		// �ж������Ƿ�Ϊ��
		if (isEmpty()) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��Ϊͷ�ڵ㣬���ܶ�����һ����־��������һ��������
		// �ɴ�������һ����������������ͷ���
		HeroNode temp = head.next;
		while (true) {
			// �ж��Ƿ���������
			if (temp == null) {
				break;
			}
			// ����ڵ����Ϣ
			System.out.println(temp);
			// ���temp���ƣ�ָ����һ���ڵ���������
			// Ҫ��Ȼ��Զ����ָ��ͬһ��ֵ��������ѭ��
			temp = temp.next;
		}
	}

}
