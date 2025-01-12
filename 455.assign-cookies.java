/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = 0;
        for(int i : g){
            boolean found = false;
            while(index<s.length){
                if(s[index++]>=i){
                    count++;
                    found = true;
                    break;
                }
            }
            if(!found){
                break;
            }
        }
        return count;
    }
}
// @lc code=end

