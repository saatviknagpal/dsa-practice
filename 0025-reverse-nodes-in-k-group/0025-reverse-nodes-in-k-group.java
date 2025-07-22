class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode pivot = head;
        solve(tail, pivot, k);
        return dummy.next;
    }

    private void solve(ListNode tail, ListNode pivot, int k) {
        if (pivot == null) {
            tail.next = null;
            return;
        }
        ListNode node = pivot;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        if (count == k) {
            ListNode prev = null, curr = pivot;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            tail.next = prev;
            solve(pivot, curr, k);
        } else {
            tail.next = pivot;
        }
    }
}
