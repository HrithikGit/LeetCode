/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> hm  = new HashMap<>();
        for(int i=0;i<numCourses ;i++){
            hm.put(i,new ArrayList<>());
        }
        for(int each[] : prerequisites){
            hm.get(each[1]).add(each[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        // Plain DFS to check if there is a cycle anywhere, if a cycle is found we return false
        for(int i=0;i<numCourses ; i++){
            if(!dfs(i,hm,visited)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int start,HashMap<Integer,ArrayList<Integer>> hm, HashSet<Integer> vis){
        if(hm.get(start).size() == 0){
            return true;
        }
        if(vis.contains(start)){
            return false;
        }
        vis.add(start);
        ArrayList<Integer> arr = hm.get(start);
        for(int i : arr){
            if(!dfs(i,hm,vis)){
                return false;
            }
        }
        //ArrayList was successfully traversed
        hm.get(start).clear();
        vis.remove(start);
        return true;
    }
}
// @lc code=end

