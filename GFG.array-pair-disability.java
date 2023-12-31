/*
Given an array of integers nums and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.
https://www.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        //BASE CASES
        if(nums.length%2 !=0){
            return false;
        }
        if(k==1){
            return true;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        int maxi = Integer.MIN_VALUE;
        for(int i : nums){
            maxi = Math.max(maxi,i);
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        if(k>maxi){
            return false;
        }
        int iter = (2*maxi)/k;
        for(int key : hm.keySet()){
            int value = hm.get(key);
            while(value-- != 0){
                int start = 1;
                boolean found = false;
                while(start<=iter){
                    if(hm.containsKey(k*start - key) && hm.get(k*start - key)!=0 ){
                        found = true;
                        //System.out.println("matched "+key+" "+start+" "+iter);
                        hm.put(k*start-key,hm.get(k*start-key)-1);
                        break;
                    }
                    start++;
                }
                if(!found){
                    //System.out.println("False for "+key);
                    return false;
                }
            }
        }
        return true;
    }
}

