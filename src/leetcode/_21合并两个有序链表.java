package leetcode;

public class _21合并两个有序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        class Solution {
            public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
                if (l1 == null && l2 == null) {
                    return null;
                } else if (l1 == null) {
                    return l2;
                } else if (l2 == null) {
                    return l1;
                }

                ListNode res = l1.val > l2.val ? l2 : l1;

                ListNode head = null;
                if (l1.val > l2.val) {
                    head = l2;
                    l2 = l2.next;
                } else {
                    head = l1;
                    l1 = l1.next;
                }

                while (l1 != null && l2 != null) {
                    if (l1.val > l2.val) {
                        head.next = l2;
                        l2 = l2.next;
                    } else {
                        head.next = l1;
                        l1 = l1.next;
                    }
                    head = head.next;
                }

                head.next = l1 == null ? l2 : l1;
                return res;
            }
        }
    }
}