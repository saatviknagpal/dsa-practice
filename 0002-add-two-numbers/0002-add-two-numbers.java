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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode newList = dummy;

        while (l1 != null || l2 != null) {
            int x = (l1 != null ? l1.val : 0);
            int y = (l2 != null ? l2.val : 0);
            int sum = x + y + carry;
            ListNode newNode = new ListNode();
            if (sum >= 10) {
                int rem = sum % 10;
                newNode.val = rem;
            } else {
                newNode.val = sum;
            }
            carry = sum / 10;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            newList.next = newNode;
            newList = newList.next;
        }

        if (carry > 0) {
            newList.next = new ListNode(carry);
        }

        return dummy.next;
    }
}