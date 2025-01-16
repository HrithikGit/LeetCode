/*
 * @lc app=leetcode id=2425 lang=java
 *
 * [2425] Bitwise XOR of All Pairings
 */

// @lc code=start
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        boolean test = nums2.length%2==0;
        for(int i : nums1){
            if( ! test ){
                ans = ans^i;
            }
        }
        test = nums1.length%2==0;
        for(int i : nums2){
            if( !test ){
                ans = ans^i;
            }
        }
        return ans;
    }
}

// @lc code=end

