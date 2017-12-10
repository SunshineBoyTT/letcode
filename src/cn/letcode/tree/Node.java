package cn.letcode.tree;

/**
 * 二叉树节点 (详情:http://www.jb51.net/article/118130.htm)
 * @author Administrator
 *按惯例左兄弟优先于右兄弟，故若将节点及其孩子分别记作V、L和R，则下图所示，局部访问的次序可有VLR、LVR和LRV三种选择。根据节点V在其中的访问次序，三种策略也相应地分别称作先序遍历、中序遍历和后序遍历，下面将分别介绍
 *
 *				root(V)
 *			     |
 *		|---------------|
 *    leftChild(L)  rightChild(R)	
 **/
public class Node {
		public Object element;  
	    public Node lChild;  //为了方便理解不设置成private
	    public Node rChild;  
	    public Node(Object element, Node lChild, Node rChild) {
	        this.element = element;
	        this.lChild = lChild;
	        this.rChild = rChild;
	      }
		public Node getlChild() {
			return lChild;
		}
		public void setlChild(Node lChild) {
			this.lChild = lChild;
		}
		public Node getRChild() {
			return rChild;
		}
		public void setRChild(Node rChild) {
			this.rChild = rChild;
		}  
}
