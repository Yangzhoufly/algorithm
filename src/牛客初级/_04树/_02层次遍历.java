package 牛客初级._04树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 需要借助队列的结构来实现，
 * 将left  ,   right 依次放入队列，弹出打印
 *
 */

public class _02层次遍历 {

    public static void levelOrder(Node head){
        if(head==null){
            return ;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            System.out.print(head.value+" ");
            if(head.left!=null){
                queue.offer(head.left);
            }
            if(head.right!=null){
                queue.offer(head.right);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);


        levelOrder(head);



        //printTree(head);
    }

}
