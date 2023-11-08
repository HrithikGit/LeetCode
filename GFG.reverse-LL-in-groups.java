//Reverse a Linked List in groups of given size
//GeeksForGeeks
//[https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1]

/*
Given a linked list of size N.
The task is to reverse every k nodes (where k is an input to the function) in the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should be considered as a group and must be reversed (See Example 2 for clarification).

Example 1:
Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5 
Explanation: 
The first 4 elements 1,2,2,4 are reversed first 
and then the next 4 elements 5,6,7,8. Hence, the 
resultant linked list is 4->2->2->1->8->7->6->5.

Example 2:
Input:
LinkedList: 1->2->3->4->5
K = 3
Output: 3 2 1 5 4 
Explanation: 
The first 3 elements are 1,2,3 are reversed 
first and then elements 4,5 are reversed.Hence, 
the resultant linked list is 3->2->1->5->4.

*/

class Solution
{
    public static Node reverse(Node head, int k)
    {
        if(k==1 || head == null || head.next == null){
            return head;
        }
        
        int count = 1;
        Node headcopy = head;
        while(head != null && count!=k){
            head = head.next;
            count++;
        }
        Node remaining = head==null ? null : reverse(head.next,k);
        if(head != null)
            head.next = null;
        Node currentRev = reverseList(headcopy);
        Node currentRevCopy = currentRev;
        while(currentRev.next!=null){
            currentRev = currentRev.next;
        }
        currentRev.next = remaining;
        return currentRevCopy;
    }
    
    public static Node reverseList(Node head){
        if(head == null || head.next==null){
            return head;
        }
        Node nhead = null;
        while(head != null){
            Node temp = head;
            head = head.next;
            if(nhead == null){
                nhead = temp;
                nhead.next = null;
                continue;
            }
            temp.next = nhead;
            nhead = temp;
        }
        return nhead;
    }
    
}