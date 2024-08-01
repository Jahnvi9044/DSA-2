package GreedyAlgorithm;

import java.util.*;
import java.io.*;


public class MinAbsDiff {


    public static void main(String[] args)throws IOException {
        /*
         * Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         * Write your code here
         */

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        int t =Integer.parseInt(br.readLine());
        while (t-- > 0) {//Write your code here

            int n=Integer.parseInt(br.readLine());
            Integer[] arr=new Integer[n];
            String[] st=br.readLine().split(" ");
            for(int i=0;i<n;i++)
            {
                arr[i]=Integer.parseInt(st[i]);
            }


            Comparator<Integer> ob=(o1,o2)->(o1>o2)?-1:1;
            Arrays.sort(arr,ob);
            int min=Integer.MAX_VALUE;
            for(int i=0;i<n-1;i++)
            {
                min=Math.min(min,Math.abs(arr[i]-arr[i+1]));

            }


            System.out.println(min);

        }



    }

}
