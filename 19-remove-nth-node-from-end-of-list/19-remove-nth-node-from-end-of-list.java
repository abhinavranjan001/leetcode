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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        
        int i = 0;
        ListNode temp = head;
        while(temp != null){
            i++;
            temp = temp.next;
        }
        
        n = i - n;
        ListNode prev = sentinel;
        temp = head;
        while(n > 0){
            temp = temp.next;
            prev = prev.next;
            n--;
        }
        
        if(temp.next == null) prev.next = null;
        else prev.next = temp.next;
        return sentinel.next;
    }
}