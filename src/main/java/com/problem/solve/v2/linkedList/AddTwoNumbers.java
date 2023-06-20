package com.problem.solve.v2.linkedList;

public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String args[]) {
        ListNode l1= new ListNode(2);
        ListNode l11 = new ListNode(4);
        l1.next = l11;
        ListNode l111 = new ListNode(3);
        l11.next = l111;
       // l111.next = null;

        ListNode l2= new ListNode(5);
        ListNode l21 = new ListNode(6);
        l2.next = l21;
        ListNode l211 = new ListNode(4);
        l21.next = l211;
//        l211.next = null;



        System.out.println(addTwoNumbers(l1, l2));

    }
    /*
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int extra =0;
        while (l1 !=null && l2!=null) {
            int sum = l1.val + l2.val + extra;
            if(sum >= 10) {
                curr.val=sum-10;
                extra = 1;
            } else {
                extra = 0;
                curr.val=sum;
            }
            l1 = l1.next;
            l2 = l2.next;

            //ListNode newCurr = ;
            if(l1 !=null) {
                curr.next = new ListNode(0);
                curr = curr.next;
            }
            //curr = newCurr;
        }
        if(extra > 0) {
            curr.val = extra;
        }
        return res;
    }
    */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int extra =0;

        while (l1 != null  || l2!=null || extra==1) {
            int sum = 0;
            if(l1 != null){ // adding l1 to our sum & moving l1
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){ // adding l2 to our sum & moving l2
                sum += l2.val;
                l2 = l2.next;
            }
            //int sum = l2 == null? l1.val + extra : l1.val + l2.val + extra;
            sum = sum +extra;
            int sumact = sum;
            if(sum >= 10) {
                sumact=sum-10;
                extra = 1;
            } else {
                extra = 0;
                sumact=sum;
            }
            //if(l1 != null) {
                curr.next = new ListNode(sumact);
                curr = curr.next;
            //}
            //l1 = l1 !=null? l1.next : null;
//            l2 = l2 !=null ? l2.next : null;

            //ListNode newCurr = ;

            //curr = newCurr;
        }
//        if(extra > 0) {
//            curr.val = extra;
//        }
        return res.next;
    }
    public ListNode addTwoNumbersv2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // creating an dummy list
        ListNode curr = dummy; // intialising an pointer
        int carry = 0; // intialising our carry with 0 intiall
        // while loop will run, until l1 OR l2 not reaches null OR if they both reaches null. But our carry has some value in it.
        // We will add that as well into our list
        while(l1 != null || l2 != null || carry == 1){
            int sum = 0; // intialising our sum
            if(l1 != null){ // adding l1 to our sum & moving l1
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){ // adding l2 to our sum & moving l2
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry; // if we have carry then add it into our sum
            carry = sum/10; // if we get carry, then divide it by 10 to get the carry
            ListNode node = new ListNode(sum % 10); // the value we'll get by moduloing it, will become as new node so. add it to our list
            curr.next = node; // curr will point to that new node if we get
            curr = curr.next; // update the current every time
        }
        return dummy.next; // return dummy.next bcz, we don't want the value we have consider in it intially!!
    }
}