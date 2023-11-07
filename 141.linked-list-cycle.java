/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

//LinkedList

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow !=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

/*
USE FLOYD ALGORITHM TO FIND IF THE LINKEDLIST HAS A CIRCLE
-> INITIALISE TWO POINTERS slow AND fast AT HEAD
-> MOVE SLOW POINTER BY ONE STEP AND FAST POINTER BY TWO STEPS AT A TIME
-> IF FAST POINTER REACHES THE END, THEN THERE IS NO CYCLE
-> ELSE, IF SLOW POINTER AND FAST POINTER EVENTUALLY MEET, THEN THERE EXISTS A CYCLE IN LL
*/
