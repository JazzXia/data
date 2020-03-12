package com.qtatelier.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		//先创建一个二叉树
		BinaryTree binaryTree = new BinaryTree();
		//常见需要的结点
		HeroNode root = new HeroNode(1,"V社");
		HeroNode node2 = new HeroNode(2,"熊猫酒仙");
		HeroNode node3 = new HeroNode(3,"死亡先知");
		HeroNode node4 = new HeroNode(4,"暗牧");
		HeroNode node5 = new HeroNode(5,"影魔");
		
		//说明，我们先手动创建该二叉树，后面学习递归的方式来创建二叉树
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		binaryTree.setRoot(root);
		//测试
	/*	System.out.println("前序遍历");//1,2,3,5,4
		binaryTree.preOrder();
		
		System.out.println("中序遍历");//2,1,5,3,4
		binaryTree.infixOrder();
		
		System.out.println("后序遍历");//2,5,4,3,1
		binaryTree.postOrder();
		
		//前序遍历的次数
		//首先V社，然后熊猫酒仙，...1,2,3,5，一共四次
		//前序遍历查找
		System.out.println("前序遍历的方式");
		HeroNode resNode = binaryTree.preOrderSearch(5);
		if(resNode != null) {
			System.out.printf("找到了，信息为no=%d name=%s",resNode.getNo(),resNode.getName());
			System.out.println();
		}else {
			System.out.println("没有找到");
		}
		
		
		//中序遍历的次数
		//2,1,5，一共三次
		//前序遍历查找
		System.out.println("中序遍历的方式");
		HeroNode resNode1 = binaryTree.infixOrderSearch(5);
		if(resNode1 != null) {
			System.out.printf("找到了，信息为no=%d name=%s",resNode1.getNo(),resNode1.getName());
			System.out.println();
		}else {
			System.out.println("没有找到");
		}
		
		
		//后序遍历的次数
		//2,5，一共二次
		//前序遍历查找
		System.out.println("后序遍历的方式");
		HeroNode resNode2 = binaryTree.postOrderSearch(5);
		if(resNode2 != null) {
			System.out.printf("找到了，信息为no=%d name=%s",resNode2.getNo(),resNode2.getName());
		}else {
			System.out.println("没有找到");
		}
		*/
		
		//测试删除结点
		
		System.out.println("删除前,前序遍历");//1,2,3,5,4
		binaryTree.preOrder();
		binaryTree.delNode(5);//denug
		System.out.println("删除后,前序遍历");//1,2
		binaryTree.preOrder();
	}
}



//定义BinaryTree 二叉树
class BinaryTree {
	private HeroNode root;
	
	public void setRoot(HeroNode root) {
			this.root = root;
	}
	//写前序遍历
	public void preOrder() {
		if(this.root != null) {
			this.root.preOrder();
		}else {
			System.out.println("二叉树为空,无法遍历");
		}
	}
	
	//中序遍历
	public void infixOrder() {
		if(this.root != null) {
			this.root.infixOrder();
		}else {
			System.out.println("二叉树为空,无法遍历");
		}
	}
	
	//后序遍历
	public void postOrder() {
		if(this.root != null) {
			this.root.postOrder();
		}else {
			System.out.println("二叉树为空,无法遍历");
		}
	}
	
	
	
	//前序遍历查找
	public HeroNode preOrderSearch(int no) {
		if(root != null) {
			return root.preOrdersearch(no);
		} else {
			return null;
		}
	}
	
	//中序遍历查找
	public HeroNode infixOrderSearch(int no) {
		if(root != null) {
			return root.infixOrdersearch(no);
		} else {
			return null;
		}
	}
	
	
	//后序遍历查找
	public HeroNode postOrderSearch(int no) {
		if(root != null) {
			return root.postOrdersearch(no);
		} else {
			return null;
		}
	}
	
	
	//删除节点
	public void delNode(int no) {
		if(root != null) {
			//如果只有一个root，立即判断是不是要删除的节点
			if(root.getNo() == no) {
				root = null;
			}else {
				root.delNode(no);
			}
		}else {
			System.out.println("空树，不可以为空");
		}
	}
	
	
}








//先创建HeroNode 结点
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
	
	
	//编写前序遍历的方法
	public void preOrder() {
		System.out.println(this);//先遍历父结点【当前节点】
		//递归向左子树前序遍历
		if(this.left != null) {
			this.left.preOrder();
		}
		//递归向右子树前序遍历
		if(this.right != null) {
			this.right.preOrder();
		}
		
	}
	
	
	//编写中序遍历的方法
	public void infixOrder() {
		//递归向左子树中序遍历
		if(this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);//遍历父结点
		//递归向右子树中序遍历
		if(this.right != null) {
			this.right.infixOrder();
		}
		
	}
	
	
	//编写后序遍历的方法
	public void postOrder() {
		//递归向左子树中序遍历
		if(this.left != null) {
			this.left.postOrder();
		}
		
		//递归向右子树中序遍历
		if(this.right != null) {
			this.right.postOrder();
		}
		
		System.out.println(this);//遍历父结点
		
	}
	
	//前序遍历查找
	/**
	 * 
	 * @param no编号
	 * @return如果找到就返回该Node，如果没有找到就返回null
	 */
	public HeroNode preOrdersearch(int no) {
		System.out.println("进入前序遍历");
		//判断当前结点是不是
		if(this.no == no) {
			return this;
		}
		//1.则判断当前节点的左子结点是否为空，如果不为空，则递归前序查找
		//2.如果左递归前序查找，找到结点，则返回
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.preOrdersearch(no);
		}
		if(resNode != null) {//说明我们左子树找到了
			return resNode;
		}
		//1.左递归前序查找，找到结点，否则继续判断
		//2.当前的结点的右子结点是否为空，如果不空，则继续向右递归前序查找
		if(this.right != null) {
			resNode = this.right.preOrdersearch(no);
		}
		return resNode;
	}
	
	
	//中序遍历查找
	public HeroNode infixOrdersearch(int no) {
		//1.则判断当前节点的左子结点是否为空，如果不为空，则递归中序查找
		HeroNode resNode = null;
		if(this.left != null) {
			resNode = this.left.infixOrdersearch(no);
		}
		
		if(resNode != null) {
			return resNode;
		}
		System.out.println("进入中序遍历");
		//如果找到,则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
		if(this.no == no) {
			return this;
		}
		
		//否则就继续向右中序查找
		if(this.right != null) {
			resNode = this.right.infixOrdersearch(no);
		}
		
		return resNode;
	}
	
	
	//后序遍历查找
		public HeroNode postOrdersearch(int no) {
			//1.则判断当前节点的左子结点是否为空，如果不为空，则递归后序查找
			HeroNode resNode = null;
			if(this.left != null) {
				resNode = this.left.postOrdersearch(no);
			}
			
			if(resNode != null) {//说明在左子树
				return resNode;
			}
			
			//否则就继续向右后序查找
			if(this.right != null) {
				resNode = this.right.postOrdersearch(no);
			}
			
			if(resNode != null) {//说明在右子树
				return resNode;
			}
			System.out.println("进入后序遍历");
			//左右子树都没有，那么就查当前节点，如果找到,则返回，如果没有找到，就和当前结点比较，如果是则返回当前结点
			if(this.no == no) {
				return this;
			}
			return resNode;
		}
		
		
		//递归删除结点
		//1.如果是叶子结点，则删除该结点
		//23.如果是非叶子结点，则删除该子树
		
		public void delNode(int no) {
			//思路
			/**
			 * 1.因为我们的二叉树是单向的,所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除的结点。
			 * 2.如果当前结点的左子结点不为空，并且左子结点就是要删除结点，就将this.left = null，并且就返回(结束递归删除)
			 * 3.如果当前结点的右子结点不为空，并且右子结点就是要删除结点，就将this.right = null，并且就返回(结束递归删除)
			 * 4.如果第二和第三步没有删除结点，那么我们就需要向左子树进行递归删除
			 * 5.如果第4步也没有删除结点，则应当向右子树进行递归删除
			 */
			//如果当前结点的左子结点不为空，并且左子结点就是要删除结点，就将this.left = null，并且就返回(结束递归删除)
			if(this.left != null && this.left.no == no) {
				this.left = null;
				return;
			}
			//3.如果当前结点的右子结点不为空，并且右子结点就是要删除结点，就将this.right = null，并且就返回(结束递归删除)
			if(this.right != null && this.right.no == no) {
				this.right = null;
				return;
			}
			//4.如果第二和第三步没有删除结点，那么我们就需要向左子树进行递归删除
			if(this.left != null) {
				this.left.delNode(no);
			}
			//5.如果第4步也没有删除结点，则应当向右子树进行递归删除
			if(this.right != null) {
				this.right.delNode(no);
			}
			
			
		}
		
		
}
