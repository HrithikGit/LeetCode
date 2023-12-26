/*
 * @lc app=leetcode id=1155 lang=java
 *
 * [1155] Number of Dice Rolls With Target Sum
 */

// @lc code=start
class Solution {
    int dp[][];
    int mod = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        return recurse(n,k,target);   
    }
    public int recurse(int n,int k, int target){
        if(n==0){
            return target==0 ? 1 : Integer.MIN_VALUE;
        }
        if(dp[n][target] == -1 ){
            int count = 0;
            for(int i=1;i<=k;i++){
                if(i<=target){
                    int val = recurse(n-1,k,target-i);
                    val = (val == Integer.MIN_VALUE) ? 0 : val;
                    count = (count%mod + val%mod)%mod;
                }
            }
            dp[n][target] = count;
        }
        return dp[n][target];
    }
}
// @lc code=end

