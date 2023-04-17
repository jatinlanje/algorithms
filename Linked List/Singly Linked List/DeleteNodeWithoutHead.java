class Solution {
    public void deleteNode(ListNode node) {
        ListNode current=node.next;
        node.val=current.val;
        node.next=current.next;
    }
}
