// Add one to number represented by LinkedList 
// [https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1]

/*
A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output: 457
Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Example 2:

Input:
LinkedList: 1->2->3
Output: 124 

*/

//LinkedList
class Solution
{
    public static Node addOne(Node head) 
    { 
        head = reverse(head);
        Node copy = head;
        boolean carryon = true;
        while(head!=null && carryon){
            int data = head.data+1;
            head.data = data%10;
            if(data<10){
                carryon =false;
            }
            if(head.next == null && carryon){
                head.next = new Node(1);
                break;
            }
            head = head.next;
        }
        return reverse(copy);
    }
    
    public static Node reverse(Node head){
        Node nhead = head;
        Node copyhead = head.next;
        nhead.next = null;
        while(copyhead != null){
            Node temp = copyhead.next;
            copyhead.next = nhead;
            nhead = copyhead;
            copyhead = temp;
        }
        return nhead;
    }
}