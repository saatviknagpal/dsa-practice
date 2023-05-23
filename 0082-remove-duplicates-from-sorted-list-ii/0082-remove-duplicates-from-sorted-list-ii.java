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
    public ListNode deleteDuplicates(ListNode head) {
        
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        
        ListNode temp = head;
        
        while(temp != null){
            if(map.containsKey(temp.val)){
                map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            } else {
                map.put(temp.val, 1);
            }
            temp = temp.next;
        }
        
        ListNode result = new ListNode(0);
        ListNode curr = result;
        for(int val : map.keySet()){
            ListNode ans = new ListNode(val);
            if(map.get(val) == 1){
                curr.next = ans;
                curr = ans;
            }
        }
        
        return result.next;
    }
}