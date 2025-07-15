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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;

        while(curr != null){
            ListNode newNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNode;
        }

        ListNode first = head, second = prev;
        ListNode nextNode = null;
        while (second != null && first != second) {
            nextNode = first.next;      
            first.next = second;     
            first = nextNode;           

            nextNode = second.next;
            second.next = first;
            second = nextNode;
        }
        first.next = null;
    }
}