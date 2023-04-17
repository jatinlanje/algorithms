public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Get the length of the linked list
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        // Connect the tail to the head to form a circular linked list
        tail.next = head;

        // Find the (len - k)th node from the beginning
        k %= len; // Normalize the rotation amount
        for (int i = 0; i < len - k; i++) {
            tail = tail.next;
        }

        // Set the new head and break the circular linked list
        ListNode newHead = tail.next;
        tail.next = null;

        return newHead;
    }
}




