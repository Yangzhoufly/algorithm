package 牛客初级._04树;

/**
 * 【题目】 现在有一种新的二叉树节点类型如下：
 public static class Node{
     public int value;
     public Node left=null;
     public Node rihtg=null;
     public Node parent=null;

     public Node(int value) {
     this.value = value;
     }
 }
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 * 假设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针
 * 都正确地指向 自己的父节点，头节点的parent指向null。只给一个在
 * 二叉树中的某个节点 node，请实现返回node的后继节 点的函数。在二
 * 叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
 *
 * 后继节点：中序遍历的下一个节点
 *
 * 思路：
 *      case1：一个节点A有右子树，那么它的后继节点是该右子树下最左的节点
 *      case2: 一个节点A没有右子树，那么从该节点往上找，如果当前节点是父节点的左孩子，那么父节点为节点A的后继
 *
 *
 */
public class _04找后继节点 {

    public static class Node{
        public int value;
        public Node left=null;
        public Node right=null;
        public Node parent=null;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return node;
        }
        //如果该节点有右子树，那么它的后继节点是该右子树下最左的节点
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;

        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }




}
