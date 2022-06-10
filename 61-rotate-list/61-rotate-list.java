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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        
        int count = 0;
        ListNode counter = head;
        while(counter != null){
            count++;
            counter = counter.next;
        }
        k = k%count;
        while(k-- > 0){
            ListNode temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            ListNode newNode = temp.next;
            temp.next = null;
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}