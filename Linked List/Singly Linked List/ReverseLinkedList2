class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1); // create dummy node
        dummy.next = head;
        ListNode prev = dummy; // initialize prev pointer on dummy node
        int i = 0;
        while (i < left - 1) {
            prev = prev.next; // adjust the prev pointer to its actual index
            i++;
        }
        
        ListNode curr = prev.next; // curr pointer will be just after prev
        int j = 0;
        while (j < right - left) {
            ListNode forw = curr.next; // forw pointer will be after curr
            curr.next = forw.next;
            forw.next = prev.next;
            prev.next = forw;
            j++;
        }
        
        return dummy.next;
    }
}
