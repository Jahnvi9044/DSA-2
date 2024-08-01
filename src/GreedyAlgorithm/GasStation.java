package GreedyAlgorithm;

import java.util.*;

public class GasStation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here

        }

    }

    public class Solution {
        public static int startingPoint(int[] gas, int[] cost, int n) {
            // Write your code here.

            int total_gas=0,total_cost=0;
            for(int i : gas)
                total_gas+=i;
            for(int i : cost)
                total_cost+=i;

            //    check if travel is possible
            if(total_gas<total_cost)
                return -1;

            int ans=0 , left_gas=0 ;

            for(int i=0;i<n;i++)
            {
                left_gas=left_gas+(gas[i]-cost[i]);
                if(left_gas <0)
                {
                    ans=i+1;
                    left_gas=0;
                }

            }

            return ans;



        }
    }
}
