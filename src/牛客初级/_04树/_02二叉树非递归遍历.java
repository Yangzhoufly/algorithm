package 牛客初级._04树;

//recursive

import java.util.Stack;

/**
 * 递归版本的实现比较简单，其实就是把输出放在不同的位置，其余都是一样的
 *
 * 放在前边即为前序遍历
 * 中间为中序遍历
 * 放在后边为后序遍历
 *
 * 每个节点会到达三次，前序为输出第一次到达，中序为输出第二次到达，后序为第三次到达
 *
 *
 * https://www.cnblogs.com/liuyang0/p/6271331.html
 */

public class _02二叉树非递归遍历 {
    public static class Node{
        public int  value;
        public Node left=null;
        public Node right=null;
        public Node(int value) {
            this.value = value;
        }
    }

    public static void preOrderUnRecur(Node head){
        if(head==null){
            return ;
        }
        System.out.print("非递归前序遍历：  ");

        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node point=null;//指针

        while(!stack.empty()){
            point=stack.pop();
            System.out.print(point.value+" ");
            if(point.right!=null){
                stack.push(point.right);
            }
            if(point.left!=null){
                stack.push(point.left);
            }
        }
        System.out.println();
    }

    // pre1前序遍历非递归
    public static void preOrderUnRecur_V2(Node head) {
        Stack<Node> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                //压入，打印
                System.out.print(head.value + " ");
                stack.push(head);
                head = head.left;
            }
            //说明head指针已经到底了，弹出栈顶的节点，并取head=stack.pop().right;
            if (!stack.isEmpty()) {
                head = stack.pop().right;
            }
        }
    }


    //中序遍历
    public static void inOrderUnRecur_V2(Node head){
        if(head==null){
            return ;
        }
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty() || head!=null){
            while(head!=null){
                stack.push(head);
                head=head.left;
            }
            if(!stack.isEmpty()){
                //弹出 打印
                head=stack.pop();
                System.out.println(head.value);
                head=head.right;
            }
        }
    }

    //后序遍历，左右中
    public static void postOrderUnRecur_V1(Node head){
        if(head==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> printStack = new Stack<>();//存放数据打印的栈

        stack.push(head);

        while(!stack.isEmpty()){
            head=stack.pop();
            printStack.push(head);
            if(head.left!=null){
                stack.push(head.left);
            }
            if(head.right!=null){
                stack.push(head.right);
            }
        }
        while (!printStack.isEmpty()){
            System.out.println(printStack.pop().value);
        }

    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        //preOrderUnRecur_V2(head);

        //inOrderUnRecur_V2(head);

        postOrderUnRecur_V1(head);


        //head=new Node(1);
        //head.left=new Node(2);
        //head.left.left=new Node(3);
        //head.left.right=new Node(4);
        //head.left.right.left=new Node(5);
        //head.left.right.left.left=new Node(6);
        //head.left.right.right=new Node(7);
        //System.out.println("======");
        //
        //inOrderUnRecur_V2(head);








    }
}
