package com.problem.solve.v2.linkedList;

public class OddEvenList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String args[])
    {
        ListNode l1= new ListNode(1);
        ListNode l11 = new ListNode(2);
        l1.next = l11;
        ListNode l111 = new ListNode(3);
        l11.next = l111;
        ListNode l1111 = new ListNode(4);
        l111.next = l1111;
        ListNode l11111 = new ListNode(5);
        l1111.next = l11111;

        System.out.println(oddEvenList(l1));
    }
    public ListNode oddEvenListV2(ListNode head) {
        if (head == null)
            return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    public static ListNode oddEvenList(ListNode head) {
        ListNode curr = head;
        ListNode even = null;
        ListNode odd = null;
        int count = 1;
        while (curr !=null)
        {
            if(count %2 == 0) {
                if(even == null) {
                    even = curr;
                } else {
                    even.next = curr;
                }

            } else {
                if(odd == null) {
                    odd = curr;
                } else {
                    odd.next = curr;
                }
            }
            curr = curr.next;
            count++;
        }
        if((count - 1)%2 == 0) {
            even.next = curr;
        } else {
            odd.next = curr;
        }

        odd.next = even;
        return odd;
    }
}
