/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
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
    public ListNode detectCycle(ListNode head) {
        ListNode slow,fast;
        slow = fast = head;
        boolean cycleExists = false;
        while(slow !=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycleExists = true;
                break;
            }
        }
        if(!cycleExists){
            return null;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
// @lc code=end

/*
USING FLOYD ALGORITHM TO RETURN THE STARTING POINT OF THE CIRCLE IN LINKEDLIST
-> INITIALISE TWO POINTERS slow AND fast AT HEAD
-> MOVE SLOW POINTER BY ONE STEP AND FAST POINTER BY TWO STEPS AT A TIME
-> IF FAST POINTER REACHES THE END, THEN THERE IS NO CYCLE
-> ELSE, IF SLOW POINTER AND FAST POINTER EVENTUALLY MEET, THEN THERE EXISTS A CYCLE IN LL
-> SETBACK SLOW POINTER TO HEAD
-> MOVE BOTH SLOW POINTER AND FAST POINTER BY ONE STEP AT A TIME
-> THE POINT AT WHICH BOTH MEET IS THE STARTING POINT OF THE CIRCLE 
*/