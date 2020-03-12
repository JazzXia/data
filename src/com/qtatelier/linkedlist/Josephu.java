package com.qtatelier.linkedlist;

public class Josephu {
	public static void main(String[] args) {
		//����Լɪ������
		
		//����һ����������
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		//���ȴ���41����̫�˲���������
		circleSingleLinkedList.addPerson(41);
		//���Ա�������
		circleSingleLinkedList.showPerson();
		//����Լɪ��
		System.out.println("��ɱ����");
		circleSingleLinkedList.countPerson(1, 3, 41);
		System.out.println("�����ŵ���");
		circleSingleLinkedList.showPerson();
		
		
	}
}

// ����һ�����εĵ�������ѭ������(���ε����������)
class CircleSingleLinkedList {
	// ����һ��first�ڵ㣬��ǰû�б��
	private Person first = null;

	// ����˵Ľڵ㣬����һ�����ε�����
	// ������ΪҪ��Ӷ��ٸ��˼��ɣ���Ϊû�б�����ԡ�
	public void addPerson(int nums) {
		if (nums < 1) {
			System.out.println("nums��ֵ����ȷ!");
			return;
		}

		Person curPerson = null;
		// ʹ��forѭ����������������
		for (int i = 1; i <= nums; i++) {
			// ���ݱ�����������
			Person person = new Person(i);
			// ����ǵ�һ����
			if (i == 1) {
				first = person;
				first.setNext(first);//����һ����
				curPerson = first;//�൱�ڸ���ָ���������
			}else {
				curPerson.setNext(person);
				person.setNext(first);
				curPerson = person;
			}
		}

	}
	
	
	//������ǰ�Ļ�������
	public void showPerson() {
		//�ж������Ƿ�Ϊ��
		if(first==null) {
			System.out.println("����Ϊ��");
			return;
		}
		//ʹ�ø���ָ���������
		Person curPerson = first;
		while(true) {
			System.out.printf("��̫�˵ı��Ϊ%d\n",curPerson.getNo());
			if(curPerson.getNext()==first) {//�������
				break;
			}
			
			curPerson = curPerson.getNext();
		}
		
	}
	
	//�������������Ӧ�����֣�������ɱ�ı�ţ�
	//����֤����Ҵ���ǲ���16�ź�31��
	/**
	 * 
	 * @param startNo ��ʾ�ӱ�ż���ʼ����
	 * @param countNum ��ʾ���ڼ�����ʼ��ɱ
	 * @param nums ��ʼһ���ܵ�����
	 */
	public void countPerson(int startNo, int countNum, int nums) {
		//�ȶ����ݽ���У��
		if(first == null || startNo < 1 || startNo > nums || countNum <0 || countNum > nums) {
			System.out.println("������������!����������");
			countPerson(startNo, countNum, nums);
		}
		
		//����Ҫ���ĸ���ָ�룬�������������ı��
		Person helper = first;
		//��helperָ�����һ�ڵ�
		while(true) {
			if(helper.getNext()==first) {//ָ�������һ���ڵ�
				break;
			}
			helper = helper.getNext();
		}
		//����ǰ����������first��helper�ƶ�startNo-1��
		//�ִ��ʼ�㣬�����ʼ��Ϊ3���Ǿ�first�����ƶ����Σ�ѭ������
		for (int j = 0; j < startNo - 1; j++) {
		     first = first.getNext();
		     helper = helper.getNext();
		}
		
		//������ʱ����first��helperָ��ͬʱ�ƶ�m-1�Σ�Ȼ����ɱ
		//������һ��ѭ������,
		while(true) {
			//Ҫ�ж�һ�������ŵ�����
			//nums%countNum���������ŵ�����
			if(nums == nums%countNum) {
				break;
			}

			//��first��helperָ��ͬʱ�ƶ�countNum-1�Σ�Ȼ����ɱ
			for(int j = 0; j < countNum - 1; j++) {
			     first = first.getNext();
			     helper = helper.getNext();
			}
			
			//��ʱָ��Ľڵ�ľ���Ҫ��ɱ����̫��
			System.out.printf("��̫��%d����ɱ\n",first.getNo());
			//��ʱ��firstָ�����̫����ɱ,
			//first����һ���ڵ��ƶ�
			first = first.getNext();
			//��ָ��ָ����һ���ڵ�����һ���ڵ�����
			helper.setNext(first);
			nums--;
		}
		
	
	}
	
	
	
}



















// ���Լɪ�������
class Person {
	private int no;// ���
	private Person next;// ָ����һ�ڵ�

	public Person(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Person getNext() {
		return next;
	}

	public void setNext(Person next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Person [no=" + no + ", next=" + next + "]";
	}

}
