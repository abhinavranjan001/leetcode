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
    ListNode oh = null, ot = null, th = null, tt = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLength(head);
        if(head == null || head.next == null || k < 2) return head;
        ListNode current = head, nextP = null;
        
        while(len >= k){
            int i = k;
            th = null; tt = null;
            while(i-- > 0){
                nextP = current.next;
                current.next = null;
                addFirst(current);
                current = nextP;
            }
            if(oh == null){
                oh = th;
                ot = tt;
            }else{
                ot.next = th;
                ot = tt;
            }
            len = len-k;
        }
        ot.next = current;
        
        return oh;
    }
    
    public int getLength(ListNode head){
        int l = 0;
        ListNode t = head;
        while(t != null) {
            l++;
            t = t.next;
        }
        
        return l;
    }
    
    public void addFirst(ListNode temp){
        if(th == null){
            th = temp;
            tt = temp;
        }else{
            temp.next = th;
            th = temp;
        }
    }
}