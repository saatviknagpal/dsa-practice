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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        for (ListNode head : lists) {
            if (head != null) {
                heap.add(head);
            }
        }

        while(!heap.isEmpty()){
            ListNode top = heap.poll();
            temp.next = top;
            temp = temp.next;
            if (top.next != null) {
                heap.add(top.next);
            }
        }

        return dummy.next;
    }
}
