/*
 * @lc app=leetcode id=2116 lang=java
 *
 * [2116] Check if a Parentheses String Can Be Valid
 */

// @lc code=start
class Solution {
    public boolean canBeValid(String s, String locked) {
        if ( s.length()%2 != 0 )
            return false;
        return valid(s, locked, '(') && valid(new StringBuilder(s).reverse().toString(), new StringBuilder(locked).reverse().toString(),')');
    }
    public boolean valid(String s, String locked, char c){
        if ( s.length()%2 != 0 )
            return false;
        System.out.println(s);
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if( locked.charAt(i)=='1'){
                count += s.charAt(i)==c ? 1 : -1;
            }
            else{
                count++;
            }
            if( count < 0 )
                return false;
        }
        return count >= 0 ;
    }
}
// @lc code=end

