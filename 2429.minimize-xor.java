/*
 * @lc app=leetcode id=2429 lang=java
 *
 * [2429] Minimize XOR
 */

// @lc code=start
class Solution {
    public int minimizeXor(int num1, int num2) {
        int setCount = Integer.bitCount(num2);
        char binary[] = Integer.toBinaryString(num1).toCharArray();
        char ans[] = new char[32];
        Arrays.fill(ans, '0');
        for(int i = 0;i<binary.length;i++){
            char c = binary[i];
            int index = 32-binary.length+i;
            if( c == '1' && setCount>0 ){
                ans[index] = '1';
                setCount--;
            }
        }
        for(int i = ans.length-1;setCount>0 && i>=0;i--){
            if( ans[i]=='0'){
                ans[i]='1';
                setCount--;
            }
        }

        return Integer.parseInt(new String(ans),2);
    }
}
// @lc code=end

