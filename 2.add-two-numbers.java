/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode anscopy = ans;
        int carry = 0;
        while(l1!=null || l2!=null){
            int val = l1!=null ? l1.val : 0;
            val += l2!=null ? l2.val : 0;
            val+=carry;
            carry = val/10;
            ans.next = new ListNode(val%10);
            ans = ans.next;
            l1 = l1!=null ? l1.next  :null;
            l2 = l2!=null ? l2.next  :null;
        }
        if(carry!=0){
            ans.next = new ListNode(carry);
        }
        return anscopy.next;
    }
}
// @lc code=end

