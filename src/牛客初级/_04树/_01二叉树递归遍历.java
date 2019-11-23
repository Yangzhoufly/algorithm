package 牛客初级._04树;

//recursive

/**
 * 递归版本的实现比较简单，其实就是把输出放在不同的位置，其余都是一样的
 *
 * 放在前边即为前序遍历
 * 中间为中序遍历
 * 放在后边为后序遍历
 *
 * 每个节点会到达三次，前序为输出第一次到达，中序为输出第二次到达，后序为第三次到达
 *
 */

public class _01二叉树递归遍历 {
    public static class Node{
        public int  value;
        public Node left=null;
        public Node right=null;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void preOrderRecur(Node head){
        if(head==null){
            return ;
        }
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void  inOrderRecur(Node head){
        if(head==null){
            return ;
        }
        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);
    }

    public static void postOrderRecur(Node head){
        if(head==null){
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.println(head.value);
    }


    public static void main(String[] args) {
        //Node head = new Node(5);
        //head.left = new Node(3);
        //head.right = new Node(8);
        //head.left.left = new Node(2);
        //head.left.right = new Node(4);
        //head.left.left.left = new Node(1);
        //head.right.left = new Node(7);
        //head.right.left.left = new Node(6);
        //head.right.right = new Node(10);
        //head.right.right.left = new Node(9);
        //head.right.right.right = new Node(11);

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);


        preOrderRecur(head);
    }
}
