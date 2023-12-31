/*
 * @lc app=leetcode id=1578 lang=java
 *
 * [1578] Minimum Time to Make Rope Colorful
 */

// @lc code=start
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int count = 0;
        int maxi = neededTime[0];
        int sum = neededTime[0];
        int ans = 0;
        for(int i = 1;i<colors.length();i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                count++;
                sum += neededTime[i];
                maxi = Math.max(maxi, neededTime[i]);
            }
            else{
                ans += (sum-maxi);
                maxi = neededTime[i];
                sum = maxi;
            }
        }
        ans += (sum-maxi);
        return ans;
    }
}

// @lc code=end

