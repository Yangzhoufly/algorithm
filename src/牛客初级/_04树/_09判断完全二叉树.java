package 牛客初级._04树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树 Complete Binary Tree   ->CBT
 *
 * 通过层次比遍历来实现
 *
 * 1、如果一个节点只有右孩子 、没有左孩子，直接返回false
 * 2、如果达到没有左右孩子  or 只有左孩子  那么之后的节点必须是叶子节点
 */
public class _09判断完全二叉树 {

    public static boolean isCBT(Node head){

        if(head==null){
            return true;
        }

        Queue<Node> queue =new LinkedList<>();
        queue.offer(head);
        //达到第二种情况，开启检查是否为叶子节点模式
        boolean leafNode=false;

        while(!queue.isEmpty()){
            head=queue.poll();
            Node left = head.left;
            Node right = head.right;

            //case,中了，直接false
            if(left==null && right!=null){
                return false;
            }
            //达到leafNode开启的情况下，必须为叶子节点
            if(leafNode==true && (left!=null || right!=null)){
                return false;
            }

            if(left!=null){
                queue.offer(left);
            }
            if(right!=null){
                queue.offer(right);
            }
            //没有左右孩子  or 只有左孩子
            if(right==null){
                leafNode=true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);


        System.out.println(isCBT(head));
    }
}
