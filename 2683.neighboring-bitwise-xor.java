/*
 * @lc app=leetcode id=2683 lang=java
 *
 * [2683] Neighboring Bitwise XOR
 */

// @lc code=start
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        if( derived.length == 1 ){
            return derived[0]==0;
        }
        int ans = 0;
        for(int i : derived)
            ans = ans ^ i;
        return ans==0;
    }
}
// @lc code=end

