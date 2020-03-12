package com.qtatelier.linkedlist;

public class Josephu {
	public static void main(String[] args) {
		//测试约瑟夫问题
		
		//创建一个环形链表
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		//首先创建41个犹太人并加入链表
		circleSingleLinkedList.addPerson(41);
		//测试遍历功能
		circleSingleLinkedList.showPerson();
		//测试约瑟夫
		System.out.println("自杀报号");
		circleSingleLinkedList.countPerson(1, 3, 41);
		System.out.println("最后活着的人");
		circleSingleLinkedList.showPerson();
		
		
	}
}

// 创建一个环形的单向链表【循环链表】(环形单向链表队列)
class CircleSingleLinkedList {
	// 创建一个first节点，当前没有编号
	private Person first = null;

	// 添加人的节点，构建一个环形的链表
	// 【参数为要添加多少个人即可，因为没有别的属性】
	public void addPerson(int nums) {
		if (nums < 1) {
			System.out.println("nums的值不正确!");
			return;
		}

		Person curPerson = null;
		// 使用for循环来创建环形链表
		for (int i = 1; i <= nums; i++) {
			// 根据编号来添加人数
			Person person = new Person(i);
			// 如果是第一个人
			if (i == 1) {
				first = person;
				first.setNext(first);//构成一个环
				curPerson = first;//相当于辅助指针帮助遍历
			}else {
				curPerson.setNext(person);
				person.setNext(first);
				curPerson = person;
			}
		}

	}
	
	
	//遍历当前的环形链表
	public void showPerson() {
		//判断链表是否为空
		if(first==null) {
			System.out.println("链表为空");
			return;
		}
		//使用辅助指针帮助遍历
		Person curPerson = first;
		while(true) {
			System.out.printf("犹太人的编号为%d\n",curPerson.getNo());
			if(curPerson.getNext()==first) {//遍历完毕
				break;
			}
			
			curPerson = curPerson.getNext();
		}
		
	}
	
	//根据需求，输入对应的数字，计算自杀的编号，
	//并验证最后幸存的是不是16号和31号
	/**
	 * 
	 * @param startNo 表示从编号几开始数数
	 * @param countNum 表示数第几个开始自杀
	 * @param nums 初始一共总的人数
	 */
	public void countPerson(int startNo, int countNum, int nums) {
		//先对数据进行校验
		if(first == null || startNo < 1 || startNo > nums || countNum <0 || countNum > nums) {
			System.out.println("参数输入有误!请重新输入");
			countPerson(startNo, countNum, nums);
		}
		
		//创建要给的辅助指针，帮助计算死亡的编号
		Person helper = first;
		//将helper指向最后一节点
		while(true) {
			if(helper.getNext()==first) {//指向了最后一个节点
				break;
			}
			helper = helper.getNext();
		}
		//报数前，首先先让first和helper移动startNo-1次
		//抵达初始点，比如初始点为3，那就first向右移动两次，循环两次
		for (int j = 0; j < startNo - 1; j++) {
		     first = first.getNext();
		     helper = helper.getNext();
		}
		
		//当报数时。让first和helper指针同时移动m-1次，然后自杀
		//这里是一个循环操作,
		while(true) {
			//要判断一下最后活着的人数
			//nums%countNum就是最后活着的人数
			if(nums == nums%countNum) {
				break;
			}

			//让first和helper指针同时移动countNum-1次，然后自杀
			for(int j = 0; j < countNum - 1; j++) {
			     first = first.getNext();
			     helper = helper.getNext();
			}
			
			//这时指向的节点的就是要自杀的犹太人
			System.out.printf("犹太人%d已自杀\n",first.getNo());
			//这时将first指向的犹太人自杀,
			//first向下一个节点移动
			first = first.getNext();
			//将指针指向下一个节点与下一个节点相连
			helper.setNext(first);
			nums--;
		}
		
	
	}
	
	
	
}



















// 解决约瑟夫的问题
class Person {
	private int no;// 编号
	private Person next;// 指向下一节点

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
