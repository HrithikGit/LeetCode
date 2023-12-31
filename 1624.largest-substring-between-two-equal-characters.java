/*
 * @lc app=leetcode id=1624 lang=java
 *
 * [1624] Largest Substring Between Two Equal Characters
 */

// @lc code=start
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int last[] = new int[26];
        Arrays.fill(last,-1);
        int ans = -1;
        for(int i =0;i<s.length();i++){
            if(last[s.charAt(i)-97] != -1 && i-last[s.charAt(i)-97]-1 > ans){
                ans = i-last[s.charAt(i)-97]-1;
            }
            if(last[s.charAt(i)-97] == -1)
                last[s.charAt(i)-97] = i;
        }
        return ans;
    }
}
// @lc code=end

