class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1,head); // Create a dummy node to handle edge cases
        ListNode prev = dummy; // The previous node
        ListNode current = head; // The current node

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                int duplicateValue = current.val; // Store the duplicate value
                while (current != null && current.val == duplicateValue) {
                    current = current.next; // Skip all duplicates
                }
                prev.next = current; // Update prev.next to the new node after skipping duplicates
            } 
            else {
                prev = current; // Move prev to the current node
                current = current.next; // Move current to the next node
            }
        }

        return dummy.next; // Return the head of the modified linked list
    }
}
