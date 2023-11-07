package LeetcodePractice.Node;

import static java.util.Arrays.sort;

public class SortList {
    public ListNode sortList1(ListNode head) {
        ListNode ptr = head;
        int count = 0;
        while (ptr.next!=null){
            count++;
            ptr = ptr.next;
        }
        int[] arr = new int[count];
        for(int i=0;i<count;i++){
            arr[i] = ptr.val;
            ptr = ptr.next;
        }
        sort(arr);


        return null;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next ==null) return head;
        ListNode slow=head,fast =head.next;
        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast = fast.next.next;
        } ListNode l2 = sortList(slow.next);
        slow.next = null;
        return merge(sortList(head),l2);
    }
    private ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);;
            return l2; } }
}
