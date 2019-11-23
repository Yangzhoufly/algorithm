package 牛客初级._03链表;


//插入链表，从小到大
public class _21链表的插入_排个序 {

    public static class Node{
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }


    public static Node insertLinkedList(Node head ,Node insert){
        if(insert==null){
            return head;
        }

        insert.next=null;  //切断插入点和之后数据的联系，只插入这一个节点

        if(head==null){
            return insert;
        }

        //如果insert的数据 比 第一个小  挂在头上
        if(head.value>=insert.value){
            insert.next=head;
            return insert;
        }

        //主要思路：  一前  一后  卡在中间
        Node before=head;
        Node after=head.next;

        while(before!=null){
            if(after==null){
                before.next=insert;
                break;
            }
            if(before.value<=insert.value && insert.value<=after.value){
                insert.next=after;
                before.next=insert;
                break;
            }
            before=before.next;
            after=after.next;
        }
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
        head.next=new Node(5);
        head.next.next=new Node(7);
        head.next.next.next=new Node(9);
        head.next.next.next.next=new Node(20);

        Node insert = new Node(1);


        head=insertLinkedList(head,insert);
        printLinkedList(head,"head");



    }

}
