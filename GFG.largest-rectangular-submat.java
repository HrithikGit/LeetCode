/*

Given a matrix mat[][] of size N x M. The task is to find the largest rectangular sub-matrix by area whose sum is 0.

If there are multiple solutions return the rectangle which starts from minimum column index. If you still have multiple solutions return the one having greatest row number. If no such matrix is present return a zero (0) size matrix.

Example 1:

Input: N = 3, M = 3
mat[][] =  1, 2, 3
          -3,-2,-1
           1, 7, 5

Output:  1, 2, 3
        -3,-2,-1

Explanation: This is the largest sub-matrix,
whose sum is 0.



https://www.geeksforgeeks.org/problems/largest-rectangular-sub-matrix-whose-sum-is-0/1?

*/


class Solution {
    //Correct solution --- Bad way of test cases conditions in case of multiple solutions
    public static ArrayList<ArrayList<Integer>> extract(int[][] a,int ai,int aj,int m,int k){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=ai;i<=m;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=aj;j<=aj+k;j++){
                temp.add(a[i][j]);
            }
            ans.add(temp);
        }
        return ans;
    }
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int size = 0;
        int crow = -1;
        int crowend = -1;
        int ccol = -1;
        int[][] rsum = new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(j ==0){
                    rsum[i][j] = a[i][j];
                }
                else{
                    rsum[i][j] = a[i][j]+rsum[i][j-1];
                }
                // System.out.print(rsum[i][j]);
            }
            // System.out.println();
        }
        for(int j=0;j<a[0].length;j++){
            outer : for(int i=0;i<a.length;i++){
                for(int k = 0;k<1000;k++){
                    if(k+j>=a[0].length){
                        continue outer;
                    }
                    int sum = 0;
                    for(int m = i;m<a.length;m++){
                        sum += rsum[m][j+k];
                        if(j!=0){
                            sum -= rsum[m][j-1];
                        }
                        if(sum == 0){
                            int csize = (k+1)*(m-i+1);
                            if(csize > size){
                                size = csize;
                                crow = i;
                                crowend = m;
                                ccol = j;
                                ans = extract(a,i,j,m,k);
                            }
                            else if(csize == size && j==ccol && m-i>crowend-crow){
                                size = csize;
                                crow = i;
                                crowend = m;
                                ccol = j;
                                ans = extract(a,i,j,m,k);
                            }
                        }
                    }
                }
             }
        }
        return ans;
    }
}
    