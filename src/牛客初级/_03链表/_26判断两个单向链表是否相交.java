package 牛客初级._03链表;

/**
 * 判断两个单向链表是否相交,否返回null,是返回第一个相交节点
 * 两个单向链表
 * 1、两个都无环  ->
 *
 * 2、一个有环、一个无环 ->一定不相交
 *
 * 3、两个都有环： 3种情况
 *      见讲义12页图
 *
 */
public class _26判断两个单向链表是否相交 {

    public static class Node{
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }


    //不使用hashset，   玄乎！！！
    public static Node getLoopNode(Node head){
        if(head==null || head.next==null ||head.next.next==null){
            return null;
        }

        Node fast=head.next.next;
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

    public static Node getIntersectNode(Node head1,Node head2){
        if(head1==null || head2==null){
            return null;
        }
        //分别考察两个链表是否有环，如果有环得到入环节点
        Node loopNode1 = getLoopNode(head1);
        Node loopNode2 = getLoopNode(head2);

        //case 1:两个都没有环
        if(loopNode1==null && loopNode2==null){
            System.out.println("getNoLoop");
            return getNoLoop(head1,head2);
        }

        //case 2:两个都有环
        if(loopNode1!=null && loopNode2!=null){
            System.out.println("getBothLoop");
            return getBothLoop(head1,loopNode1,head2,loopNode2);
        }

        //case 3: 一个有，一个没有
        return null;
    }

    //两个都没有环
    public static Node getNoLoop(Node head1,Node head2){
        if(head1==null || head2==null){
            return null;
        }

        int size1=0;//链表1的长度
        int size2=0;//链表2的长度


        Node end1=head1;
        Node end2=head2;

        //找两个链表的末尾节点
        while (end1!=null){
            size1++;
            end1=end1.next;
        }
        while(end2!=null){
            size2++;
            end2=end2.next;
        }

        //如果两个链表的末尾不相等，那么两个单向链表一定不相交
        if(end1!=end2){
            return null;
        }

        //如果相等。长的先从头移动（sizeBig-sizeSamll）位，随后一块移动
        while(head1!=null && head2 !=null){
            //遇到相交的节点返回
            if(head1==head2){
                return head1;
            }

            if(size1==size2){
                head1= head1.next;
                head2= head2.next;
            }else if(size1<size2){
                head2=head2.next;
                size2--;
            }else{
                head1=head1.next;
                size1--;
            }
        }
        return null;
    }

    //两个都有环
    public static Node getBothLoop(Node head1,Node loopNode1,Node head2,Node loopNode2){
        if(head1==null || head2==null){
            return null;
        }
        //如果两个链表入环节点相同
        if(loopNode1==loopNode2){
            //记录下 loopNode1.next 是为了 将之后的环断开，然后复用之前的getNoLoop方法。但是计算完之后记得还原
            Node loopNext=loopNode1.next;
            loopNode1.next=null;
            Node loopEqual = getNoLoop(head1, head2);
            loopNode1.next=loopNext;
            return loopEqual;
        }else{
            //如果两个链表入环节点不相同，情况一，不相交；情况2，不同的入环节点，随便返回一个
            Node cur=loopNode1.next;
            while(cur!=loopNode1){
                if(cur==loopNode2){
                    return cur;
                }
                cur=cur.next;
            }
            return null;
        }
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

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6

        //head1,head2相交 无环 ，交点6

        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        //head1,head2相交，有环 loopNode1==loopNode2
        System.out.println(getIntersectNode(head1, head2).value);


        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        //head1,head2相交，有环，loopNode1！=loopNode2
        System.out.println(getIntersectNode(head1, head2).value);

    }

}
