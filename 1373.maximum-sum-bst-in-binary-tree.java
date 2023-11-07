/*
 * @lc app=leetcode id=1373 lang=java
 *
 * [1373] Maximum Sum BST in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//LinkedList
class Solution {
    class Pair{
        int low,high,sum;
        Pair(int low,int high,int sum){
            this.low = low;
            this.high = high;
            this.sum = sum;
        }
    }
    int maxans = 0;
    public int maxSumBST(TreeNode root) {
        maxans = 0;
        isBST(root);
        return maxans;
    }
    public Pair isBST(TreeNode root){
        if(root == null){
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Pair left = isBST(root.left);
        Pair right = isBST(root.right);
        if(left == null || right == null){
            return null;
        }
        if(left.high>=root.val || right.low<=root.val){
            return null;
        }
        int sum = left.sum+right.sum+root.val;
        maxans = Math.max(sum,maxans);
        return new Pair(Math.min(root.val,left.low),Math.max(root.val,right.high),sum);
    }
}
// @lc code=end

/*

AT EACH NODE CHECK IF ALL THE SUBNODES ARE IN BST AND ADD CURRENT VALUE IF THE SUBTREE ON LEFT AND RIGHT IS IN BST

*/
