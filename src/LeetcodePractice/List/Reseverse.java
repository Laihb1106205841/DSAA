package LeetcodePractice.List;

import LeetcodePractice.Node.ListNode;

public class Reseverse {
    public ListNode reverseList(ListNode head) {
        if(head==null){return null;}
        ListNode current = head;
        ListNode prev=null;
        while (current != null ){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
    }
}
