package LeetcodePractice.Node;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class leetcode02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        ListNode Head = new ListNode(0);
        ListNode goNode= Head;

        while (l1!=null || l2!=null || carry!=0){
            int digit1,digit2;

            if(l1 != null){digit1=l1.val;}else {digit1 =0;}
            if(l2 != null){digit2=l2.val;}else {digit2 =0;}

            int sum = (digit1+digit2+carry)%10;//this node's sum

            carry = (digit1+digit2+carry)/10;

            ListNode nowNode = new ListNode(sum);
            goNode.next = nowNode;
            goNode = goNode.next;//move to next node

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;

        }

        ListNode result = Head.next;
        Head.next = null;
        return result;


    }
}
