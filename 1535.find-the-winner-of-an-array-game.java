/*
 * @lc app=leetcode id=1535 lang=java
 *
 * [1535] Find the Winner of an Array Game
 */

// @lc code=start
class Solution {
    public int getWinner(int[] arr, int k) {
        if( k==1 ){
            return Math.max(arr[0],arr[1]);
        }
        int winner = arr[0];
        int count = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>winner){
                winner = arr[i];
                count = 1;
            }
            else{
                count++;
            }
            if(count == k){
                return winner;
            }
        }
        return winner;
    }
}
// @lc code=end

/* Approach 

BASE CASE : if K == 1, return the maximum element of first two elements
BASE CASE 2 : if K>=arraylength, return the maximum element of array, as it eventually wins more rounds once it is encountered

Apart from Base Cases : 

Compare consecutive elements and increase the count if the current number is maximum of both,
If not assign a new winner and compare new elements with current winner
If the goal (k) number of wins has been reached, then return the current winner

*/
