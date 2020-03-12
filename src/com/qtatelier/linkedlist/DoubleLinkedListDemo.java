package com.qtatelier.linkedlist;

/**
 * ˫������
 * @author JazzXdh
 *
 */
public interface DoubleLinkedListDemo {
	public static void main(String[] args) {
		//���Խڵ����Ĺ��ܺͱ�������Ĺ���
		DHeroNode d1 = new DHeroNode(1, "��ʹ", "JazzXia");
		DHeroNode d2 = new DHeroNode(2, "����", "Ten");
		DHeroNode d3 = new DHeroNode(3, "Դ��", "Jazz");
		DHeroNode d4 = new DHeroNode(4, "��ȭ", "SS");
		DHeroNode d5 = new DHeroNode(5, "�����", "JazzXia");
		
		DoubleLinkedList list = new DoubleLinkedList();
		//Debug֮����Կ���ÿһ���ڵ��pre��next���Դ����ɹ�!
/*		list.add(d1);
		list.add(d2);
		list.add(d5);
		list.add(d3);
		list.add(d4);
		System.out.println("����Ĳ���");
		list.list();*/
		
		list.addByOrder(d5);
		list.addByOrder(d1);
		list.addByOrder(d2);
		list.addByOrder(d4);
		list.addByOrder(d3);
		
		System.out.println("����Ĳ���");
		list.list();
		
		//�����޸Ľڵ�
		list.update(new DHeroNode(4, "��˹��", "Jazz"));
		System.out.println("�޸Ľڵ�");
		list.list();
		
		//����ɾ���ڵ�
		list.delete(1);
		System.out.println("����ɾ���ڵ�");
		list.list();
	}
}

//˫��������
class DoubleLinkedList{
	// �ȳ�ʼ��һ��ͷ��㣬ͷ��㲻Ҫ��������һ����ǡ�,����ž��������
	private DHeroNode head = new DHeroNode(0, "", "");

	public DHeroNode getHead() {
		return head;
	}

	
	//����˫������ķ���
	public void list() {
		if(head.next == null) {
			System.out.println("����Ϊ��");
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
	
	//��ӽڵ㵽˫������
	//˼·��ʹ��β�巨1.�ҵ����һ���ڵ㣬Ȼ�����һ������next��Ҫ����Ľڵ�(����Ĭ��Ϊnull���Բ�д)
	//			     2.���ҽ�temp.nextָ���µĽڵ�
	//               3.��Ҫ����Ľڵ��pre��ֵΪ֮ǰ��Ϊ��һ���ڵ�
	
	public void add(DHeroNode node) {
		//���ȶ���һ����������
		DHeroNode temp = head;
		//�����ҵ���������
		while(true) {
			if(temp.next == null) {
				break;
			}
			//���û������Ǿͼ���������ƶ�
			temp = temp.next;
		}
		//���˳�ѭ����ʱ��ʼ��������
		node.next = temp.next;
		temp.next = node;
		node.pre = temp;
		
	}
	
	
	//����˳�����˫������
	public void addByOrder(DHeroNode heroNode) {
		//���ȶ��帨������
		DHeroNode temp = head;
		boolean flag = false;
		while(true) {//ÿ�ζ��Ǵ�ͷ��β������һ��
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
			System.out.printf("׼������Ľ�ɫ�ı��%d �Ѿ����ڣ����ܼ���\n", heroNode.no);
		}else {			
			heroNode.next = temp.next;
			temp.next = heroNode;
			heroNode.pre =temp;
		}
	}
	

	//�޸Ľڵ���Ϣ
	public void update(DHeroNode node) {
		if(node==null) {
			System.out.println("����Ϊ��~");
			return;
		}
		
		DHeroNode temp = head;
		boolean flag =false;
		while(true) {
			if (temp == null) {
				break;// �Ѿ�������
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
			System.out.printf("û���ҵ����Ϊ%d�Ľڵ�,�����޸�\n", node.no);
		}
	}
	
	//ɾ���ڵ�
	public void delete(int no) {
		if(head.next==null) {
			System.out.println("����Ϊ��~����Ҫɾ��!");
			return;
		}
		DHeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next==null) {
				break;//������ȫ
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
			System.out.printf("û���ҵ����Ϊ%d�Ľڵ�,����ɾ��\n", no);
		}
		
		
	}
	
	
	
}



 class DHeroNode {
	// ������
	public int no;
	public String name;
	public String nickname;
	public DHeroNode next;//ָ����һ���ڵ�
	public DHeroNode pre; //ָ��ǰһ���ڵ�

	// ������
	public DHeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	
	
	// Ϊ����ʾ���㣬��дtoString
	@Override
	public String toString() {
		return "DHeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}




