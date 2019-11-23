package 牛客初级._03链表;

import java.util.HashMap;

public class _24深度拷贝有随机指针的链表 {
    public static class Node{
        public int value;
        public Node rand=null;
        public Node next=null;

        public Node(int value ){
            this.value=value;
        }
    }

    //用一个hash表来存放(老的node节点->新的node节点),然后再根据老的连接关系，连接新的链表
    //额外空间复杂度O(N),哈希表查询复杂度O(1)
    public static Node  copyRandLinkedList1(Node head){
        if(head ==null){
            return null;
        }
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node cur=head;

        //把原始节点，和拷贝节点放入Map
        while(cur !=null){
            hashMap.put(cur,new Node(cur.value));
            cur=cur.next;
        }
        System.out.println(hashMap.size());

        cur=head;
        //连接对应关系
        while(cur!=null){
            hashMap.get(cur).next=hashMap.get(cur.next);
            hashMap.get(cur).rand=hashMap.get(cur.rand);
            cur=cur.next;

        }
        return  hashMap.get(head);//注意这里要返回头结点
    }


    //不使用hashmap额外空间，使用特殊的结构来查找新旧节点的关系：
    //  1->1'->2->2'->3->3'->null
    //一次取出两个
    //额外空间复杂度O(1),哈希表查询复杂度O(1)
    public static Node  copyRandLinkedList2(Node head){
        if(head ==null){
            return null;
        }
        //Node cur=head;
        //Node curTail=null;//用来生成   1->1'->2->2'->3->3'->null 结构用
        //while(cur!=null){
        //    Node temp=cur.next;
        //    cur.next=new Node(cur.value);
        //    if (curTail==null) {
        //        curTail=cur.next;
        //    }else{
        //        curTail.next=cur;
        //        curTail=cur.next;
        //    }
        //    cur=temp;
        //}

        Node cur=head;
        Node next=null;
        //这是左神的代码，     用来生成   1->1'->2->2'->3->3'->null 结构
        while(cur!=null){
            next=cur.next;
            cur.next=new Node(cur.value);
            cur.next.next=next;
            cur=next;
        }

        cur=head;
        //连接新表的rand结构
        while(cur!=null){
            cur.next.rand=cur.rand==null?null:cur.rand.next;//连接rand,需要判断，因为cur.rand可能为null，如果再取.next就会报错
            cur=cur.next.next;
        }

        cur=head;
        Node copyHead=cur.next;
        Node curCopy = null;

        // 把1->1'->2->2'->3->3'->null 结构   拆开
        while(cur!=null){
            next=cur.next.next;

            curCopy=cur.next;
            curCopy.next=next==null?null:next.next;//连接新表

            cur.next=next;//还原老表

            cur=next;
        }
        return copyHead;
    }

    public static void main(String[] args) {

        Node  head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        System.out.println("========新表==========");
        Node newHead = copyRandLinkedList2(head);
        printRandLinkedList(newHead);
        System.out.println("========老表==========");
        printRandLinkedList(head);
    }

    public static void printRandLinkedList(Node head){
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();

        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
        System.out.println("==================");
    }

}
