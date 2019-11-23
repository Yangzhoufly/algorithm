package 牛客初级._03链表;

import java.util.Stack;

/**
 * Is Palindrome List
 *
 *判断一个链表是否为回文结构
 *
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回文结构。
 *          例如： 1->2->1，返回true。 1->2->2->1，返回true。
 *                15->6->15，返回true。 1->2->3，返回false。
 *
 * 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 *
 * 笔试中不用考虑空间，1、考虑压栈，2、快指针，慢指针压栈
 * 面试中要额外空间复杂度最低
  */

public class _20判断一个链表是否为回文结构 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //1、额外空间复杂度O(n)
    public static boolean isPalindromeList1(Node head){
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node temp=head;
        //全部放入栈中
        while(temp !=null){
            stack.push(temp);
            temp=temp.next;
        }
        while(head!=null){
            if(head.value != stack.pop().value){
                return false;
            }
            head=head.next;
        }
        return true;
    }

    //2、额外空间复杂度O(n/2)
    public static boolean isPalindromeList2(Node head){
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();

        Node slow =head;
        Node fast =head;
        //快指针移动两步，慢指针移动一步
        while(fast!=null && fast.next!=null){
            fast= fast.next.next;
            slow=slow.next;
        }
        //把剩下的数据放入栈中
        while(slow!=null){
            stack.push(slow.value);
            slow=slow.next;
        }
        System.out.println(stack);

        //出栈，和node前半部分比较
        while (stack.size()!=0){
            int value = stack.pop();
            if(value!= head.value){
                return  false;
            }
            head=head.next;
        }
        return true;
    }

    // need n/2 extra space,更加少一个
    public static boolean isPalindromeList3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        Stack<Integer> stack = new Stack<Integer>();
        while (slow != null) {
            stack.push(slow.value);
            slow = slow.next;
        }
        System.out.println(stack);
        while (!stack.isEmpty()) {
            if (head.value != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    //need O(1) extra space
    public static boolean isPalindromeList4(Node head){

        if (head == null || head.next == null) {
            return true;
        }

        Node fast=head; //快指针
        Node mid=head; //mid 为慢指针,

        //1、使得 mid 打到中间
        while(fast.next !=null  && fast.next.next !=null) {
            fast=fast.next.next;
            mid=mid.next;
        }

        Node rightHead=mid.next;  //右半部分的头
        mid.next=null;    //左半部分的尾指向null,  1、可以用于循环判断   2、可以用于恢复


        printLinkedList(rightHead,"rightHead");
        printLinkedList(head,"head");

        //2、将后半部分链表反转
        Node newHead=null;
        while(rightHead!=null){
            Node temp=rightHead.next;
            rightHead.next=newHead;
            newHead=rightHead;
            rightHead=temp;
        }
        printLinkedList(newHead,"newHead");

        boolean isPalindrome=true;

        //Node saveHead=head;
        Node saveNewHead=newHead;  //保存头，以备recover


        //3、将后半部分的reverse 与 前半部分 进行比较
        while(newHead!=null && head!=null){
            if(newHead.value != head.value){
                isPalindrome=false;
                break;
            }
            newHead=newHead.next;
            head=head.next;
        }

        //4、将后半部分recover
        Node rightRecover=null;
        while(saveNewHead!=null){
            Node temp=saveNewHead.next;
            saveNewHead.next=rightRecover;
            rightRecover=saveNewHead;
            saveNewHead=temp;
        }

        mid.next=rightRecover;  //把中间接上

        return isPalindrome;
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
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(3);
        head.next.next.next.next=new Node(2);
        //head.next.next.next.next.next=new Node(1);
        //head.next.next.next.next.next.next=new Node(1);



        printLinkedList(head,"原始");

        //System.out.println(isPalindromeList1(head));
        //System.out.println(isPalindromeList2(head));

        System.out.println(isPalindromeList4(head));

        printLinkedList(head,"之后");

    }
}
