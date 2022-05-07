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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp.next!= null){
            count++;
            temp = temp.next;
        }
        temp = head;
        int result = 0;
        while(temp!= null){
            if(temp.val == 1){
                result += Math.pow(2, count);
                count--;
                temp = temp.next;
            }
            else{
                count--;
                temp = temp.next;
            }
            
        }
        return result;
    }
}