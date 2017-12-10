package cn.letcode.tree;

import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * 排序2叉树 
 *  定义：二叉排序树或者是一棵空树，或者是具有下列性质的二叉树： 
	（1）若左子树不空，则左子树上所有结点的键值均小于或等于它的根结点的键值； 
	（2）若右子树不空，则右子树上所有结点的键值均大于或等于它的根结点的键值； 
	（3）左、右子树也分别为二叉排序树；
 * @author LYYL 
 * 详情参考:http://blog.csdn.net/yanglun1/article/details/45368523
 * @param  
 */  
public class SortedBinTree {  
    public static class Node{  
        int data;  
        Node parent;  
        Node left;  
        Node right;  
        public Node(int data, Node parent, Node left, Node right){  
            this.data = data;  
            this.parent = parent;  
            this.left = left;  
            this.right = right;  
        }  
        public String toString(){  
            return "[ data = " + data + " ]";  
        }  
        public boolean equals(Object object){  
            if(this == object){  
                return true;  
            }  
            if(object instanceof Node){  
                Node target = (Node)object;  
                return (data==target.data)&&left==target.left  
                        &&right == target.right&&parent == target.parent;  
            }  
            return false;  
        }  
    }  
    private Node root;  
    public SortedBinTree(){  
        root = null;  
    }  
    public SortedBinTree(int o){  
        root = new Node(o, null, null, null);  
    }  
    //添加节点  
    public void add(int element){  
        //如果根节点为空  
        if(root == null){  
            root = new Node(element, null, null, null);  
        }else{  
            Node current = root;  
            Node parent = null;  
            int cmp = 0;  
            do{  
                parent = current;  
                cmp = element-parent.data;  
                if(cmp > 0){  
                    //以右子节点作为当前节点  
                    current = current.right;  
                }else{  
                    current = current.left;  
                }  
            }while(current != null);  
            Node newNode = new Node(element, parent, null, null);  
            if(cmp > 0){  
                parent.right = newNode;  
            }else{  
                parent.left = newNode;  
            }  
        }  
    }  
    //删除节点  
    public void remove(int element){  
        //获取要删除的节点：  
        Node target = getNode(element);  
        if(target == null){  
            return;  
        }  
        //被删除节点既没有左节点又没有右节点  
        if(target.left == null && target.right == null){  
            //如果被删除的节点就是根节点  
            if(target == root){  
                root = null;  
            }else{  
                //被删除节点是父节点的左节点  
                if(target == target.parent.left){  
                    target.parent.left = null;  
                }else{  
                    //被删除节点是父节点的右节点  
                    target.parent.right = null;  
                }  
                target.parent = null;  
            }  
        }  
        //被删除节点左子树为空，右子树不为空  
        else if(target.left == null && target.right != null){  
            if(target == root){  
                root = target.right;  
            }else{  
                //被删除节点是父节点的左节点  
                if(target == target.parent.left){  
                    target.parent.left = target.right;  
                }else{  
                    //被删除节点是父节点的右节点  
                    target.parent.right = target.right;  
                }  
            }  
            target.right.parent = target.parent;  
            //很多书上没有下面两条语句，但我认为如果不加这两句将会造成内存泄露  
            target.right = null;  
            target.parent = null;  
        }  
        //被删除节点左子树不为空，右子树为空  
        else if(target.left != null && target.right == null){  
            if(target == root){  
                root = target.left;  
            }else{  
                //被删除节点是父节点的左节点  
                if(target == target.parent.left){  
                    target.parent.left = target.left;  
                }else{  
                    //被删除节点是父节点的右节点  
                    target.parent.right = target.left;  
                }  
            }  
            target.left.parent = target.parent;  
            //很多书上没有下面两条语句，但我认为如果不加这两句将会造成内存泄露  
            target.left = null;  
            target.parent = null;  
        }  
        else{  
            //左右子树均不为空，采用中序遍历的前驱节点替代目标节点  
            Node maxLeftNode = target.left;  
            //找到目标节点的前驱节点  
            while(maxLeftNode.right != null){  
                maxLeftNode = maxLeftNode.right;  
            }  
            //从原来的子树中删除maxLeftNode节点  
            maxLeftNode.parent.right = null;  
            //让maxLeftNode的父节点指向target的父节点  
            maxLeftNode.parent = target.parent;  
            if(target == target.parent.left){  
                //如果target的为父节点的左节点  
                target.parent.left = maxLeftNode;  
            }else{  
                target.parent.right = maxLeftNode;  
            }  
            maxLeftNode.left = target.left;  
            maxLeftNode.right = target.right;  
            //置空删除节点的引用，防止内存泄露  
            target.parent = target.right = target.left = null;  
        }  
    }  
    //根据指定元素找到该节点  
    public Node getNode(int element){  
        Node current = root;  
        int cmp = 0;  
        do{  
            cmp = element-current.data;  
            if(cmp > 0){  
                current = current.right;  
            }else if(cmp < 0){  
                current = current.left;  
            }else{  
                break;  
            }  
        }while(current != null);  
        return current;  
    }  
    //采用中序遍历二叉树，得到该2叉树的有序排列  
    public List inIterator(){  
        return inIterator(root);  
    }  
    public List inIterator(Node node){  
        List list = new ArrayList();  
        if(node.left != null){  
            list.addAll(inIterator(node.left));  
        }  
        list.add(node);  
        if(node.right != null){  
            list.addAll(inIterator(node.right));  
        }  
        return list;  
    }  
    //获得排序二叉树的深度  
    public int getTreeDeep(){  
        return getTreeDeep(root);  
    }  
    public int getTreeDeep(Node node){  
        if(node == null){  
            return 0;  
        }  
        if(node.left == null && node.right == null){  
            return 1;  
        }  
        else{  
            int leftDeep = getTreeDeep(node.left);  
            int rightDeep = getTreeDeep(node.right);  
            int max = leftDeep>rightDeep ? leftDeep : rightDeep;  
            return max+1;  
        }  
    }  
    public static void main(String[] args) {  
        SortedBinTree tree = new SortedBinTree();  
        tree.add(5);  
        tree.add(20);  
        tree.add(10);  
        tree.add(3);  
        tree.add(8);  
        tree.add(15);  
        tree.add(30);  
        tree.add(32);  
        tree.add(27);  
        tree.add(18);  
        System.out.println(tree.inIterator());  
        System.out.println("树的深度为： " + tree.getTreeDeep());  
        tree.remove(20);  
        System.out.println(tree.inIterator());  
        System.out.println("树的深度为： " + tree.getTreeDeep());
    }  
}  