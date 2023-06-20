package com.problem.solve.v2.linkedList;

public class RemoveNthFromEnd {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String args[]) {
        ListNode l1= new ListNode(1);

        ListNode l11 = new ListNode(2);
        l1.next = l11;
        /*
        ListNode l111 = new ListNode(3);
        l11.next = l111;
*/
        System.out.println(removeNthFromEnd(l1,  2));
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;

        int count =0;
        while(curr !=null) {
            count++;
            curr = curr.next;
        }
        int position = count -n;
        curr = head;
        int newCount = 0;
        while(curr !=null) {
            newCount++;
            /*if(position == 1) {
                ListNode tmp = curr.next.next;
                curr.next = tmp;
                // curr.next = null;
                break;
            } else
*/          if(position == 0) {
                if(count ==1) {
                    head = null;
                } else {
                    head = head.next;
                }
                break;
            } else if(newCount == position) {
                ListNode tmp = curr.next.next;
                curr.next = tmp;
                // curr.next = null;
                break;
            }

            curr = curr.next;
        }
        return head;
    }
}
