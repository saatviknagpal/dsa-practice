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
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode h) {
    int first = Integer.MAX_VALUE, last = 0, prev_val = h.val, min_d = Integer.MAX_VALUE;
    for (int i = 0; h.next != null; ++i) {
        if ((prev_val < h.val && h.val > h.next.val) || 
            (prev_val > h.val && h.val < h.next.val)) {
            if (last != 0)
                min_d = Math.min(min_d, i - last);
            first = Math.min(first, i);
            last = i;
        }
        prev_val = h.val;
        h = h.next;
    }        
    if (min_d == Integer.MAX_VALUE)
        return new int[] {-1, -1};
    return new int[] {min_d, last - first};
    }
}