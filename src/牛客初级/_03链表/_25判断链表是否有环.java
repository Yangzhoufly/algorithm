package 牛客初级._03链表;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 判断链表是否有环,如果有环返回第一个入环节点
 * 方法1：遍历链表，查看hashset中是否包含该节点
 *        1、不包含，把节点放入hashset，
 *        2、包含，结束，返回该节点
 *
 * 方法2：
 */

public class _25判断链表是否有环 {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    //需要使用HashSet
    public static Node getLoopNode(Node head){
        if(head==null ){
            return null;
        }
        Set<Node> set = new HashSet<>();
        while(head!=null){
            if(set.contains(head)){
                return head;
            }else{
                set.add(head);
            }
            head=head.next;
        }
        return null;
    }


    //不使用hashset，   玄乎！！！
    public static Node getLoopNode2(Node head){
        if(head==null || head.next==null ||head.next.next==null){
            return null;
        }

        //快指针一次两步
        Node fast=head.next.next;
        //慢指针一次一步
        Node slow=head.next;

        //找fast 和 slow 相遇的点
        while(fast!=slow){
            if(fast==null || fast.next==null ||fast.next.next==null){  //如果到达链表结束，表示不可能有环
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        //fast回到head，遇到slow即为入环节点
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        printLinkedList(head1,"head1");
        Node loopNode = getLoopNode2(head1);
        if(loopNode!=null){
            System.out.println("loopNode: "+loopNode.value);
        }else{
            System.out.println("无");
        }


        // 1->2->3->4->5->6->7->4...
        Node head2 = new Node(1);
        head2.next = new Node(1);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(6);
        head2.next.next.next.next.next.next = new Node(7);
        head2.next.next.next.next.next.next = head2.next.next.next; // 7->4

        loopNode = getLoopNode2(head2);
        if(loopNode!=null){
            System.out.println("loopNode: "+loopNode.value);
        }else{
            System.out.println("无");
        }

        Node head3 = new Node(1);
        head3.next = head3;


        loopNode = getLoopNode2(head3);
        if(loopNode!=null){
            System.out.println("loopNode: "+loopNode.value);
        }else{
            System.out.println("无");
        }


    }

    //打印链表
    public static void printLinkedList(Node node,String info){
        System.out.print(info+" :");
        while(node!=null){
            System.out.print(node.value + "  ");
            node=node.next;
        }
        System.out.println();
    }

}
