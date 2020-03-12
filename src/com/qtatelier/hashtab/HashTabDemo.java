package com.qtatelier.hashtab;

import java.util.Scanner;

/**
 * ��ϣ���Ӧ��
 * @author JazzXdh
 *
 */
public class HashTabDemo {

	public static void main(String[] args) {
		//������ϣ��
		HashTab hashTab = new HashTab(7);
		
		//дһ���򵥲˵�
		String key = "";
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("add:  ��ӹ�Ա");
			System.out.println("list: ��ʾ��Ա");
			System.out.println("find: ���ҹ�Ա");
			System.out.println("exit: �˳�ϵͳ");
			
			key = scanner.next();
			switch(key) {
			case "add":
				System.out.println("����id");
				int id = scanner.nextInt();
				System.out.println("��������");
				String name = scanner.next();
				//���� ��Ա
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("����Ҫ���ҵ�id");
				id = scanner.nextInt();
				hashTab.findEmpById(id);
				break;				
			case "exit":
				scanner.close();
				loop = false; //����ֱ��дSystem.exit(0);
				break;
			default:
				break;
			}
		}
	}
}


//����HashTab �����������
class HashTab{
	private EmpLinkedList[] empLinkedListArray;//�������飬�����з�������
	private int size;//���������
	
	//������
	public HashTab(int size) {
		this.size = size;
		//��ʼ�����������
		empLinkedListArray = new EmpLinkedList[size];
		//��ʱ��Ҫ���Ƿֱ��ʼ��ÿ�������������ʼ������ô�Ͳ���������Ҳ��û�пռ��������������ݡ�
		for(int i = 0; i<size;i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}
	}
	//��ӹ�Ա
	public void add(Emp emp) {
		//����Ա����id���õ���Ա��Ӧ����ӵ���������
		int empLinkedListNO = hashFun(emp.id);
		//��emp��ӵ���Ӧ��������
		empLinkedListArray[empLinkedListNO].add(emp);
	}
	
	//�������е�����������ϣ��
	public void list() {
		for(int i = 0; i< size; i++) {
			empLinkedListArray[i].list(i);
		}
	}
	
	//���������id���ҹ�Ա
	public void findEmpById(int id) {
		//ʹ��ɢ�к���ȷ���������������
		int empLinkedListNo = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
		if(emp != null) {//�ҵ�
			System.out.printf("�ڵ�%d���������ҵ���Աid = %d,����Ϊ=%s\n", (empLinkedListNo + 1), id, emp.name);
		}else {
			System.out.println("�ڹ�ϣ���У�û���ҵ��ù�Ա~");
		}
	}
	
	//��дɢ�к�����ʹ��һ���򵥵�ȡģ��
	public int hashFun(int id) {
		return id % size;
	}
}






//��ʾһ����Ա�ڵ�
class Emp{
	public int id;
	public String name;
	public Emp next;//ָ����һ���ڵ�Ĭ��Ϊ��
	public Emp(int id,String name) {
		super();
		this.id =id;
		this.name = name;
	}
}

//����EmpLinkedList����ʾ����
class EmpLinkedList {

	// ͷָ�룬ָ���һ��Emp,���������������head��ֱ��ָ���һ��Emp,��û��ͷ���,Ҳ����˵ͷ����ָ���ǵ�һ���ڵ�
	private Emp head;// Ĭ��Ϊ��null

	// ��ӹ�Ա������
	// ˵��
	// 1.�ٶ�������ӹ�Աʱ��id���������ģ���id�ķ������Ǵ�С����
	// ��ˣ����ǽ��ù�Աֱ�Ӽ��뵽���������һ������
	public void add(Emp emp) {
		// �������ӵ�һ����Ա
		if (head == null) {
			head = emp;
			return;
		}
		// ������ǵ�һ����Ա����ʹ��һ��������ָ�룬������λ�����
		Emp curEmp = head;
		while (true) {
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		// �˳�ʱֱ�ӽ�emp ��������
		curEmp.next = emp;
	}

	// ��������Ĺ�Ա��Ϣ
	public void list(int no) {
		if (head == null) {// ˵������Ϊ��
			System.out.println("��"+(no+1)+"����Ϊ�ա�");
			return;
		}
		System.out.println("��"+(no+1)+"�������ϢΪ");
		Emp curEmp = head;// ����ָ��
		while (true) {
			System.out.printf("=> id =%d name=%s\t", curEmp.id, curEmp.name);
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;// ���ƣ�����
		}
		System.out.println();
	}

	//����id���ҹ�Ա
	//������ҵ��ͷ���Emp,���û���ҵ����ͷ��ؿ�
	public Emp findEmpById(int id) {
		//�ж������Ƿ�Ϊ��
		if(head == null) {
			System.out.println("����Ϊ�ա�");
			return null;
		}
		//����ָ��
		Emp curEmp = head;
		while(true) {
			if(curEmp.id == id) {//˵���ҵ�
				break;//��ʱcurEmp��ֻ��Ҫ���ҵĹ�Ա
			}
			//�˳�����
			if(curEmp.next == null) {//˵��������ǰ����û���ҵ���Ա
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;//����
		}
		return curEmp;
	}
}