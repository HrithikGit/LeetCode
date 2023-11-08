/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headcopy = head;
        while(head!=null){
            ListNode current = head;
            while(current.next!=null && current.next.val == current.val){
                current = current.next;
            }
            head.next = current.next;
            head = head.next;
        }
        return headcopy;
    }
}
// @lc code=end

/*

Explanation : 

Skip nodes with same value as current node and attach the next different node to current node

*/
