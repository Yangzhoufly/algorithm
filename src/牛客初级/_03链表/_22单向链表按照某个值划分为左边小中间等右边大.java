package 牛客初级._03链表;

/**
 *将单向链表按某值划分成左边小、中间相等、右边大的形式
 *
 *1、不要求顺序
 *      1.1 先放入数组中   再取出来
 *      1.2 直接放在3个新的链表上，最后把三个链表连起来
 *
 *2、各自的位置有顺序要求
 *      2.1  用到21中所述的排序插入   结合 1.2
 *
 *
 *
 */

public class _22单向链表按照某个值划分为左边小中间等右边大 {

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



    public static Node mergeLinkList(Node node ,int num){
        if(node==null){
            return null;
        }

        Node less=null;
        Node equal=null;
        Node greater =null;

        while(node !=null){
            Node temp=node.next;//因为后边的插入会切断联系
            if(node.value==num){
                equal = insertLinkedList(equal, node);
            }else if(node.value<num){
                less=insertLinkedList(less,node);
            }else{
                greater=insertLinkedList(greater,node);
            }
            node=temp;

            //System.out.println(node.value);
        }

        Node lessEnd=less;
        if(less !=null){
            while(lessEnd.next!=null){
                lessEnd=lessEnd.next;
            }
        }

        Node equalEnd=equal;
        if(equal !=null){
            while(equalEnd.next!=null){
                equalEnd=equalEnd.next;
            }
        }

        if(less!=null){
            if(equal!=null){
                lessEnd.next=equal;
                equalEnd.next=greater;
            }else{
                lessEnd.next=greater;
            }
            return less;
        } else if(equal!=null){
            equalEnd.next=greater;
            return equal;
        }else{
            return greater;
        }
    }


    public static void main(String[] args) {

        Node head = new Node(1);
        head.next=new Node(7);
        head.next.next=new Node(5);
        head.next.next.next=new Node(5);
        head.next.next.next.next=new Node(20);

        Node node = mergeLinkList(head, 5);
        printLinkedList(node,"node");
    }

}
