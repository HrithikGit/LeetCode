/*


https://www.geeksforgeeks.org/problems/print-diagonally1623/1

Give a N*N square matrix, return an array of its anti-diagonals in top-leftmost to bottom-rightmost order. In an element of a anti-diagonal (i, j), surrounding elements will be (i+1, j-1) and (i-1, j+1). Look at the examples for more clarity.

Example 1:

Input:
N = 2
matrix[][] = 1 2
            3 4
Output:
1 2 3 4
Explanation:
List of anti-diagnoals in order is
{1}, {2, 3}, {4}
Example 2:

Input:
N = 3
matrix[][] = 3 2 3
            4 5 1
            7 8 9
Output:
3 2 4 3 5 7 1 8 9
Explanation:
List of anti-diagnoals in order is
{3}, {2, 4}, {3, 5, 7}, {1, 8}, {9}

*/


class Solution
{
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        int ans[] = new int[matrix.length*matrix[0].length];
        int ind = 0;
        for(int j=0;j<matrix[0].length;j++){
            int y = j;
            int x = 0;
            while(y>=0){
                ans[ind++] = matrix[x++][y--];
            }
        }
        if(matrix.length>1){
            for(int j=1;j<matrix.length;j++){
                int y = matrix[0].length-1;
                int x = j;
                while(x<matrix.length){
                    ans[ind++] = matrix[x++][y--];
                }
            }
        }
        return ans;
    }
}