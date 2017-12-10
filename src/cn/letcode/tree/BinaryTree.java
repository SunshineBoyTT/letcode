package cn.letcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 算法实现
 * @author Administrator
 *
 */
public class BinaryTree {
	private static List<Node> list = new ArrayList<Node>();
	private static Node root;
	/**
	 * 对该二叉树进行前序遍历 结果存储到list中 前序遍历
	 */
	public static void preOrder(Node node) {
	  list.add(node); // 先将根节点存入list
	  // 如果左子树不为空继续往左找，在递归调用方法的时候一直会将子树的根存入list，这就做到了先遍历根节点
	  if (node.lChild != null) {
	    preOrder(node.lChild);
	  }
	  // 无论走到哪一层，只要当前节点左子树为空，那么就可以在右子树上遍历，保证了根左右的遍历顺序
	  if (node.rChild != null) {
	    preOrder(node.rChild);
	  }
	} 
	
	/**
	 * 对该二叉树进行中序遍历 结果存储到list中
	 */
	public static void inOrder(Node node) {
	  if (node.lChild != null) {
	    inOrder(node.lChild);
	  }
	  list.add(node);
	  if (node.rChild != null) {
	    inOrder(node.rChild);
	  }
	}
	
	/**
	 * 对该二叉树进行后序遍历 结果存储到list中
	 */
	public static void postOrder(Node node) {
	  if (node.lChild != null) {
	    postOrder(node.lChild);
	  }
	  if (node.rChild != null) {
	    postOrder(node.rChild);
	  }
	  list.add(node);
	}
	// 树的初始化:先从叶节点开始,由叶到根
	public static void init() {
	  Node b = new Node("b", null, null);
	  Node a = new Node("a", null, b);
	  Node c = new Node("c", a, null);
	 
	  Node e = new Node("e", null, null);
	  Node g = new Node("g", null, null);
	  Node f = new Node("f", e, g);
	  Node h = new Node("h", f, null);
	 
	  Node d = new Node("d", c, h);
	  Node j = new Node("j", null, null);
	  Node k = new Node("k", j, null);
	  Node m = new Node("m", null, null);
	  Node o = new Node("o", null, null);
	  Node p = new Node("p", o, null);
	  Node n = new Node("n", m, p);
	  Node l = new Node("l", k, n);
	 
	  root = new Node("i", d, l);
	}
     
	public static void main(String[] args) {
		  init();
		  // TODO Auto-generated method stub
		  preOrder(root);
		  //inOrder(root);
//		  postOrder(root);
		  for (int i = 0; i < list.size(); i++) {
		    System.out.print(list.get(i).element + " ");
	 }
	}
}