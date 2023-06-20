package com.problem.solve.v2.linkedList;

public class LinkedListisPalindrome {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String args[]) {
        ListNode l1= new ListNode(1);

        ListNode l11 = new ListNode(1);
        l1.next = l11;

        ListNode l111 = new ListNode(2);
        l11.next = l111;
        /*
        ListNode l1111 = new ListNode(1);
        l111.next = l1111;
*/

        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode curr = head;
        if(curr.next == null) {
            return true;
        }
        ListNode buf = head;
        boolean track = false;
        ListNode prev = head;
        int count = 0, pinterCount =0, newcount=0;
        int middleCount = 0;
        int tailCount = 0;

        while (curr != null) {
            if (prev.val == curr.val) {
                if(middleCount ==0)
                    count++;
                else
                    middleCount++;
                //if()
                // contunie
            } else {//if (tailCount ==0){
                if(middleCount==0)
                  middleCount++;
                else
                    middleCount =0;

                if(middleCount ==0 && tailCount >0)
                    tailCount --;

                if(middleCount >0)
                   tailCount = count;
                count = 0;
            }

        }
        while (curr != null) {

            if (prev.val == curr.val) {
                count++;
                // contunie
            } else {
                count =0;
                if (track && curr.val == buf.val) {
                    newcount++;
                    //track = false;
                    //buf = curr;
                }
                if (track && curr.val != buf.val) {
                    track = false;
                    buf = curr;
                    newcount=0;
                }
            }
            if (!track && buf.val != curr.val) {
                track = true;
                prev = curr;
                if(pinterCount ==0)
                    pinterCount = count;

//                if(newcount ==0)
//                    newcount = count;

                count = 0;

            }

            curr = curr.next;
            if(curr == null) {
                if(count >=2 && count <=3 ) return true;
                if(pinterCount == newcount) return true;
            }
        }
        return false;
    }
    /*
    check 1221
     */
    public  boolean isPalindromev3(ListNode head) {
        ListNode curr = head;
        if(curr.next == null) {
            return true;
        }
        ListNode buf = head;
        boolean track = false;
        ListNode prev = head;
        int count = 0;
        while (curr != null) {

            if (prev.val == curr.val) {
                count++;
                // contunie
            } else {
                count =0;
                if (track && curr.val == buf.val) {
                    return true;
                    //track = false;
                    //buf = curr;
                }
                if (track && curr.val != buf.val) {
                    track = false;
                    buf = curr;

                }
            }
            if (!track && buf.val != curr.val) {
                track = true;
                prev = curr;
                count = 0;
            }
            if(count >=2 && count <=3) return true;
            curr = curr.next;
        }
        return false;
    }
}
