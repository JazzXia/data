package com.qtatelier.linkedlist;

import java.util.Stack;

import com.qtatelier.util.HeroNode;
import com.qtatelier.util.SingleLinkedList;;

/**
 * �˴��ҽ�֮ǰ��SingleLLinkedListDemo�еĵ������CRUD��װ��util�����棬Ҫʹ��ֻ��Ҫ���ü���
 * 
 * @author JazzXdh
 *
 */
public class SingleLinkedListQuestion {
	/**
	 * ����:����������Ч�ڵ�ĸ���
	 */
	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "��³��", "JazzXia");
		HeroNode hero2 = new HeroNode(2, "����", "WEI");
		HeroNode hero3 = new HeroNode(3, "����ʿ", "Xia");
		HeroNode hero4 = new HeroNode(4, "����", "Jazz");
		HeroNode hero5 = new HeroNode(5, "��è����", "JJJ");
		HeroNode hero6 = new HeroNode(6, "Ӱħ", "JazzXia");
		HeroNode hero7 = new HeroNode(7, "��è", "WEI");
		HeroNode hero8 = new HeroNode(8, "����", "Xia");
		HeroNode hero9 = new HeroNode(9, "˫ͷ��", "Jazz");
		HeroNode hero10 = new HeroNode(10, "������֪", "JJJ");

		// ����������
		SingleLinkedQuestionHandle singleLinkedList = new SingleLinkedQuestionHandle();

		SingleLinkedQuestionHandle singleLinkedList1 = new SingleLinkedQuestionHandle();
		// ���ձ�ŵ�˳��

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

		System.out.println("��Ч�ڵ�һ����:" + singleLinkedList.getLength(singleLinkedList.getHead()) + "��");

		/**
		 * ���ҵ������еĵ�����k���ڵ㡾���������⡿
		 */
		singleLinkedList.info(3, singleLinkedList);

		/**
		 * �ϲ���������ĵ������ϲ�֮���������Ȼ���򡾹鲢���� ���ڴ���Ŀ��ֻ��һ��˼·���������£� 1.�����½�һ���µ�ͷ���
		 * 2.����������ͬʱ����������ͬʱ�Ƚϲ���˳�� ��������ʱ���������һ������ô�ͱ�������ʹ��ͬһ�����
		 */
		singleLinkedList.merge(singleLinkedList.getHead(), singleLinkedList1.getHead());
		System.out.println("�������ϲ�");
		singleLinkedList1.list();

		/**
		 * ������ķ�ת����Ѷ�����⡿
		 */
		singleLinkedList.reverseList(singleLinkedList.getHead());
		System.out.println("����ķ�ת");
		singleLinkedList.list();

		/**
		 * ��β��ͷ��ӡ�������ٶ������⡿ ����һ���Ƚ�������ת������Ȼ���ٱ��� ����������������⣺1.�ƻ�ԭ��������Ľṹ
		 * 2.̫�����ӣ�����Ч�ʵͣ��˷ѿռ䡿 ����������������ջ������ݽṹ���������ڵ�ѹ�뵽ջ�У� Ȼ������ջ���Ƚ�������ص㣬��ʵ���������ӡ��Ч��
		 * ջ��stack:Ӣ�ķ����������һ�ѵ���˼�� �ڻ����ѧ��������ջ��push��ջ��pop��Ӧ����SPҪ-2 ÿѹһ��ջ��һ��2
		 * ��Java����ջ����������һ����pushһ����add ΪʲôaddҲ������Ϊstack�̳���vector������add����
		 */
		System.out.println("�����ӡ������");
		// ������һ����Ŀ�ǽ��䷴ת�����ڽ���ת����������
		singleLinkedList.reversePrint(singleLinkedList.getHead());

	}

}

class SingleLinkedQuestionHandle extends SingleLinkedList {

	// ����:��ȡ��������Ľڵ�ĸ���(����Ǵ�ͷ��㣬����Ҫͳ��ͷ���)
	/**
	 * 
	 * @param head:�����������ͷ��㡾����ͷ�����֪����ֵ��
	 * @return ����ĳ���
	 */
	public int getLength(HeroNode head) {
		if (isEmpty()) {// ������
			return 0;
		}
		int length = 0;
		// ����һ����������
		HeroNode cur = head.next;
		while (cur != null) {
			length++;
			cur = cur.next;// ����
		}
		return length;
	}

	// ������ķ���:
	// 1.�����Ȼ�ȡ������Ч�ڵ��������ȥͷ��㡿
	// 2.Ȼ�����ܵĽڵ���-�������Ǹ�����+1
	public void info(int no, SingleLinkedQuestionHandle singleLinkedQuestionHandle) {
		HeroNode head = singleLinkedQuestionHandle.getHead();
		HeroNode temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;// �Ѿ�������
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
			System.out.println("��������");
		}
	}

	// ������:������ķ�ת�Ľ���취
	// ����֮ǰѧϰ���ڵľ��飬����Ϊ���еİ취����
	// 1.�ȴ���һ���µ�ͷ��㡾��������
	// 2.������������ÿһ���ڵ㣬
	// 3.���ڵ�Ӻ���ǰ���
	public void reverseList(HeroNode head) {
		if (head.next == null || head.next.next == null) {
			System.out.println("����Ԫ�ع���,����Ҫ��ת");
			return;
		}
		// ���帨��ָ�룬�������Ǳ�������
		HeroNode current = head.next;
		HeroNode next = null;// ָ��ǰ�ڵ�[current]����һ���ڵ�
		HeroNode reverseHead = new HeroNode(0, "", "");// ����һ���½ڵ�
		while (current != null) {
			next = current.next;// ���浱ǰ�ڵ����һ���ڵ㣬������Ҫʹ��
			current.next = reverseHead.next;// ����ط���ʵ�ǽ��������ͷ�������к���Ķ�����
											// ���ŵ���ǰ�ڵ�ĺ�����һ����ǽ��µ�ͷ����뵱ǰ�ڵ�����
			reverseHead.next = current;
			current = next;

		}
		// ��head.nextָ��reverseHead.next,ʵ�ֵ�����ķ�ת
		head.next = reverseHead.next;

	}

	/**
	 * ������:��β��ͷ��ӡ�������ٶ������⡿
	 */
	public void reversePrint(HeroNode head) {
		if (isEmpty()) {
			System.out.println("Ϊ�������޷���ӡ");
		}

		// ����һ��ջ��ÿ���ڵ�ѹ��ջ
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode current = head.next;
		// ����������нڵ�ѹ��ջ��
		while (current != null) {
			stack.push(current);
			current = current.next;
		}
		// ��ջ�нڵ���д�ӡ
		while (stack.size() > 0) {
			System.out.println(stack.pop());

		}
	}

	/**
	 * ������:�ϲ���������ĵ������ϲ�֮���������Ȼ���򡾹鲢����
	 */
	public void merge(HeroNode head1, HeroNode head2) {
		if (head1.next == null || head2.next == null) {
			System.out.println("��Ϊ�յ�����,����Ҫ�ϲ�");
		}

		// ����������������
		HeroNode temp1 = head1.next;
		HeroNode temp2 = head2.next;
		HeroNode temp3 = null;// �������һ���ڵ�[�鲢���Ǹ�����]
		// �½�һ��ͷ���
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
				System.out.println("����ͬԪ���޷����");
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
