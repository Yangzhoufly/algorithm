package 牛客初级._03链表;

public class _23参数传递测试 {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node changeNext(Node head ){
        head.next=null;
        return head;

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


    public static void main(String[] args) {

        Node head = new Node(1);
        head.next=new Node(7);

        head=changeNext(head);
        printLinkedList(head,"head");
    }
}
