package 牛客初级._03链表;

/**
 * 指定地址上的值不会改变，
 * 但是其next可以改变
 * 也就是说结构可能会发生变化
 */

public class _19链表反转 {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
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

    //反转链表
    public static Node  reverseLinkedList2(Node node){

        if(node==null || node.next==null){
            return node;
        }

        Node newHead=null;

        while(node!=null){
            Node temp=node.next;//先保node的留下一个地址
            node.next=newHead;  //将原始链表当前节点的连接关系断掉，接上新的头结点
            newHead=node;       //新的头结点  换成原始的  当前节点
            node=temp;          //原始节点往后移动一位
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next=new Node(6);

        printLinkedList(reverseLinkedList2(head),"reverse");

        printLinkedList(head,"head");

        System.out.println(head);
        }
}
