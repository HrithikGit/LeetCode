/*
 * @lc app=leetcode id=2657 lang=java
 *
 * [2657] Find the Prefix Common Array of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int freq[] = new int[A.length+1];
        int ans[] = new int[A.length];
        int count = 0;
        for(int i = 0;i<A.length;i++){
            freq[A[i]]++;
            freq[B[i]]++;
            count += freq[A[i]]==2 ? 1 : 0;
            if( B[i] != A[i] )  
                count += freq[B[i]]==2 ? 1 : 0;
            ans[i] = count; 
        }   
        return ans;
    }
}
// @lc code=end

