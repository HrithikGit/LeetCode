/*
 * @lc app=leetcode id=2849 lang=java
 *
 * [2849] Determine if a Cell Is Reachable at a Given Time
 */

// @lc code=start
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(t == 0 ){
            return sx==fx && sy==fy;
        }
        int xdiff = Math.abs(sx-fx);
        int ydiff = Math.abs(sy-fy);
        int steps = Math.max(xdiff,ydiff)
        if(steps == 0){
            return t!=1;
        }
        return steps<=t;
    }
}
// @lc code=end

/*
Explanation : 

Given an infite grid, we need to check if the final destination can be reached in the given number of steps
As we can move in any of the 8 directions for each step, we need minimum number of steps to get optimal result

We use MANHATTAN distance to estimate the distance between the given points

Once we have difference between xcoordinates and ycoordinates, the number of steps to reach final dest will be
the Maximum of differennce btw xcoordinates and ycoordinates.

The common distance of fx and fy will be covered through diagnol traversals
The remaining distance of either fx or fy will be covered through side traversals

*/
