package 剑指offer;


import java.util.ArrayList;
import java.util.Stack;

public class _6从头到尾打印链表 {
    public  static class ListNode{
        int val;
        ListNode next=null;
        ListNode(int val){
            this.val=val;
        }
    }

    /**
     * 使用栈来实现反转
     * @param listNode
     * @return
     */
    public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    /**
     * 使用递归来实现反转
     * @param listNode
     * @return
     */
    public static void printListFromTailToHead_recursion(ListNode listNode) {
        if(listNode==null){
            return;
        }
        printListFromTailToHead_recursion(listNode.next);
        System.out.println(listNode.val);
    }


    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);

        System.out.println(printListFromTailToHead(head));
        printListFromTailToHead_recursion(head);

    }
}
