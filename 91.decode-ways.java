/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    int dp[] ;
    public boolean isValid(String s){
        if(s.length() == 0 || s.length()==1)
            return true;
        int val = Integer.parseInt(s);
        return val<=26;
    }
    public int numDecodings(String s) {
       dp = new int[s.length()+1];
       Arrays.fill(dp,-1);
       return decodings(s,0);
    }
    public int decodings(String s, int index){
        if(dp[index] == -1){
            if(index == s.length()){
                return 1;
            }
            if(s.charAt(index) == '0' ){
                return 0;
            }
            int count = decodings(s,index+1);
            if(index+1<s.length() && isValid(s.substring(index,index+2))){
                count += decodings(s,index+2);
            }
            dp[index] = count;
        }
       return dp[index];
    }
}

/*

216

2 1 6
21 6
2 16

*/
// @lc code=end

