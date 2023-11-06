/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
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
//LinkedList
class Solution {
    public ListNode reverseList(ListNode head) {
        //return reverseIterative(head);
        return reverseRecurse(head);
    }

    public ListNode reverseIterative(ListNode head){
        ListNode nhead = null;
        while(head != null){
            ListNode temp = head;
            head = head.next;
            if(nhead == null){
                nhead = temp;
                temp.next = null;
            }
            else{
                temp.next = nhead;
                nhead = temp;
            }
        }
        return nhead;
    }

    public ListNode reverseRecurse(ListNode head){
        if( head == null || head.next==null ){
            return head;
        }  
        ListNode reversed = reverseRecurse(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
// @lc code=end

/*
APPROACH 1 : ITERATIVE
-> FOR EACH NODE, WE ITERATIVELY CHANGE NODE AND POINT THE NEW NODE TO THE OLD REVERSED PART

APPROACH 2 : RECURSIVE
-> FOR EACH NODE, WE RECURSIVELY GET THE REVERSED PART OF REST OF LL
   ONCE WE GET THE REVERSED SUBLIST, WE ADD THE CURRENT NODE TO THE LL AND RETURN IT
*/
