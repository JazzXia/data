package com.qtatelier.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		//�ȴ���һ��������
		BinaryTree binaryTree = new BinaryTree();
		//������Ҫ�Ľ��
		HeroNode root = new HeroNode(1,"V��");
		HeroNode node2 = new HeroNode(2,"��è����");
		HeroNode node3 = new HeroNode(3,"������֪");
		HeroNode node4 = new HeroNode(4,"����");
		HeroNode node5 = new HeroNode(5,"Ӱħ");
		
		//˵�����������ֶ������ö�����������ѧϰ�ݹ�ķ�ʽ������������
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		binaryTree.setRoot(root);
		//����
	/*	System.out.println("ǰ�����");//1,2,3,5,4
		binaryTree.preOrder();
		
		System.out.println("�������");//2,1,5,3,4
		binaryTree.infixOrder();
		
		System.out.println("�������");//2,5,4,3,1
		binaryTree.postOrder();
		
		//ǰ������Ĵ���
		//����V�磬Ȼ����è���ɣ�...1,2,3,5��һ���Ĵ�
		//ǰ���������
		System.out.println("ǰ������ķ�ʽ");
		HeroNode resNode = binaryTree.preOrderSearch(5);
		if(resNode != null) {
			System.out.printf("�ҵ��ˣ���ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
			System.out.println();
		}else {
			System.out.println("û���ҵ�");
		}
		
		
		//��������Ĵ���
		//2,1,5��һ������
		//ǰ���������
		System.out.println("��������ķ�ʽ");
		HeroNode resNode1 = binaryTree.infixOrderSearch(5);
		if(resNode1 != null) {
			System.out.printf("�ҵ��ˣ���ϢΪno=%d name=%s",resNode1.getNo(),resNode1.getName());
			System.out.println();
		}else {
			System.out.println("û���ҵ�");
		}
		
		
		//��������Ĵ���
		//2,5��һ������
		//ǰ���������
		System.out.println("��������ķ�ʽ");
		HeroNode resNode2 = binaryTree.postOrderSearch(5);
		if(resNode2 != null) {
			System.out.printf("�ҵ��ˣ���ϢΪno=%d name=%s",resNode2.getNo(),resNode2.getName());
		}else {
			System.out.println("û���ҵ�");
		}
		*/
		
		//����ɾ�����
		
		System.out.println("ɾ��ǰ,ǰ�����");//1,2,3,5,4
		binaryTree.preOrder();
		binaryTree.delNode(5);//denug
		System.out.println("ɾ����,ǰ�����");//1,2
		binaryTree.preOrder();
	}
}



//����BinaryTree ������
class BinaryTree {
	private HeroNode root;
	
	public void setRoot(HeroNode root) {
			this.root = root;
	}
	//дǰ�����
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("������Ϊ��,�޷�����");
		}
	}
	
	//�������
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		}else {
			System.out.println("������Ϊ��,�޷�����");
		}
	}
	
	//�������
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("������Ϊ��,�޷�����");
		}
	}
	
	
	
	//ǰ���������
	public HeroNode preOrderSearch(int no) {
		if(root != null) {
			return root.preOrdersearch(no);
		} else {
			return null;
		}
	}
	
	//�����������
	public HeroNode infixOrderSearch(int no) {
		if(root != null) {
			return root.infixOrdersearch(no);
		} else {
			return null;
		}
	}
	
	
	//�����������
	public HeroNode postOrderSearch(int no) {
		if(root != null) {
			return root.postOrdersearch(no);
		} else {
			return null;
		}
	}
	
	
	//ɾ���ڵ�
	public void delNode(int no) {
		if(root != null) {
			//���ֻ��һ��root�������ж��ǲ���Ҫɾ���Ľڵ�
			if(root.getNo() == no) {
				root = null;
			}else {
				root.delNode(no);
			}
		}else {
			System.out.println("������������Ϊ��");
		}
	}
	
	
}








//�ȴ���HeroNode ���
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	public HeroNode(int no,String name) {
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeroNode getLeft() {
		return left;
	}
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	public HeroNode getRight() {
		return right;
	}
	public void setRight(HeroNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	
	
	//��дǰ������ķ���
	public void preOrder() {
		System.out.println(this);//�ȱ�������㡾��ǰ�ڵ㡿
		//�ݹ���������ǰ�����
		if(this.left != null) {
			this.left.preOrder();
		}
		//�ݹ���������ǰ�����
		if(this.right != null) {
			this.right.preOrder();
		}
		
	}
	
	
	//��д��������ķ���
	public void infixOrder() {
		//�ݹ����������������
		if(this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);//���������
		//�ݹ����������������
		if(this.right != null) {
			this.right.infixOrder();
		}
		
	}
	
	
	//��д��������ķ���
	public void postOrder() {
		//�ݹ����������������
		if(this.left != null) {
			this.left.postOrder();
		}
		
		//�ݹ����������������
		if(this.right != null) {
			this.right.postOrder();
		}
		
		System.out.println(this);//���������
		
	}
	
	//ǰ���������
	/**
	 * 
	 * @param no���
	 * @return����ҵ��ͷ��ظ�Node�����û���ҵ��ͷ���null
	 */
	public HeroNode preOrdersearch(int no) {
		System.out.println("����ǰ�����");
		//�жϵ�ǰ����ǲ���
		if(this.no == no) {
			return this;
		}
		//1.���жϵ�ǰ�ڵ�����ӽ���Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
		//2.�����ݹ�ǰ����ң��ҵ���㣬�򷵻�
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.preOrdersearch(no);
		}
		if(resNode != null) {//˵�������������ҵ���
			return resNode;
		}
		//1.��ݹ�ǰ����ң��ҵ���㣬��������ж�
		//2.��ǰ�Ľ������ӽ���Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
		if(this.right != null) {
			resNode = this.right.preOrdersearch(no);
		}
		return resNode;
	}
	
	
	//�����������
	public HeroNode infixOrdersearch(int no) {
		//1.���жϵ�ǰ�ڵ�����ӽ���Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.infixOrdersearch(no);
		}
		
		if(resNode != null) {
			return resNode;
		}
		System.out.println("�����������");
		//����ҵ�,�򷵻أ����û���ҵ����ͺ͵�ǰ���Ƚϣ�������򷵻ص�ǰ���
		if(this.no == no) {
			return this;
		}
		
		//����ͼ��������������
		if(this.right != null) {
			resNode = this.right.infixOrdersearch(no);
		}
		
		return resNode;
	}
	
	
	//�����������
		public HeroNode postOrdersearch(int no) {
			//1.���жϵ�ǰ�ڵ�����ӽ���Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
			HeroNode resNode = null;
			if(this.left != null) {
				resNode = this.left.postOrdersearch(no);
			}
			
			if(resNode != null) {//˵����������
				return resNode;
			}
			
			//����ͼ������Һ������
			if(this.right != null) {
				resNode = this.right.postOrdersearch(no);
			}
			
			if(resNode != null) {//˵����������
				return resNode;
			}
			System.out.println("����������");
			//����������û�У���ô�Ͳ鵱ǰ�ڵ㣬����ҵ�,�򷵻أ����û���ҵ����ͺ͵�ǰ���Ƚϣ�������򷵻ص�ǰ���
			if(this.no == no) {
				return this;
			}
			return resNode;
		}
		
		
		//�ݹ�ɾ�����
		//1.�����Ҷ�ӽ�㣬��ɾ���ý��
		//23.����Ƿ�Ҷ�ӽ�㣬��ɾ��������
		
		public void delNode(int no) {
			//˼·
			/**
			 * 1.��Ϊ���ǵĶ������ǵ����,�����������жϵ�ǰ�����ӽ���Ƿ���Ҫɾ����㣬������ȥ�жϵ�ǰ�������ǲ�����Ҫɾ���Ľ�㡣
			 * 2.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ����㣬�ͽ�this.left = null�����Ҿͷ���(�����ݹ�ɾ��)
			 * 3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ����㣬�ͽ�this.right = null�����Ҿͷ���(�����ݹ�ɾ��)
			 * 4.����ڶ��͵�����û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
			 * 5.�����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��
			 */
			//�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ����㣬�ͽ�this.left = null�����Ҿͷ���(�����ݹ�ɾ��)
			if(this.left != null && this.left.no == no) {
				this.left = null;
				return;
			}
			//3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ����㣬�ͽ�this.right = null�����Ҿͷ���(�����ݹ�ɾ��)
			if(this.right != null && this.right.no == no) {
				this.right = null;
				return;
			}
			//4.����ڶ��͵�����û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
			if(this.left != null) {
				this.left.delNode(no);
			}
			//5.�����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��
			if(this.right != null) {
				this.right.delNode(no);
			}
			
			
		}
		
		
}
