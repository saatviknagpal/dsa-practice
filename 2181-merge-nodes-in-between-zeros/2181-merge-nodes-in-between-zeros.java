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
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        
        ListNode temp = head.next;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(temp != null){
            if(temp.val == 0){
                ListNode res = new ListNode(sum);
                prev.next = res;
                prev = prev.next;
                sum = 0;
            } else {
                sum += temp.val;
            }
            temp = temp.next;
        }
        
        return dummy.next;
    }
}