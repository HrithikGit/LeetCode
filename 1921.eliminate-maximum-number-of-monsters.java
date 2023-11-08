/*
 * @lc app=leetcode id=1921 lang=java
 *
 * [1921] Eliminate Maximum Number of Monsters
 */

// @lc code=start
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int time[] = new int[dist.length];
        for(int i =0;i<dist.length;i++){
            time[i] = (int)Math.ceil((double)dist[i]/(double)speed[i]);
        }
        Arrays.sort(time);
        int count = 1;
        if(time[0] == 0 ){
            return count;
        }
        for(int i =1;i<time.length;i++){
            if(time[i]<=count){
                return count;
            }
            count++;
        }
        return count;
    }
}
// @lc code=end

/*
EXPLANATION : 

EACH MONSTER HAS A SPEED OF s AND IS AT A DISTANCE d FROM THE CITY
TIME TAKEN BY EACH MONSTER TO REACH CITY = d/s (time = distance/speed)
SINCE WE LOOSE THE GAME WHEN A MONSTER REACHES OUR CITY WE ARE MORE FOCUSED ON THE MONSTER THAT TAKES LEAST TIME TO REACH OUR CITY
THEREFORE, WE SORT THE ARRAY TO GET THE TIME IN ASCENDING ORDER
AT ANY POINT OF TIME (STARTING FROM 1) IF A MONSTER HAS NOT YET REACHED CITY, WE INCREMENT OUR KILL_COUNT 
ELSE, RETURN THE KILL_COUNT SO FAR

*/
