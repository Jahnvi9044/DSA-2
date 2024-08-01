package GreedyAlgorithm;

import java.util.*;

public class MinNoOfSwaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {   int N=sc.nextInt();


            int M=sc.nextInt();


            int K=sc.nextInt();

           sc.nextLine();
            String st=sc.nextLine();


            String[] s=sc.nextLine().split(" ");

            char[] ch=new char[s.length];
            for(int i=0;i<s.length;i++)
            {
                ch[i]=s[i].charAt(0);
            }

//            System.out.println(ch[0]+" "+ch[1]+" "+ch[2]+" ");

            System.out.println("Result "+minSwap(N,M,K,st,ch));
        }

    }

    public static int minSwap(int N, int M, int K, String S, char[] arr) {
        // Write your code here
       boolean[] flag=new boolean[26];
       for(int i=0;i<arr.length;i++)
       {
           flag[(arr[i]-97)]=true;
       }
        int n=S.length(),max=0;
        int[][] freq =new int[K][26];
        for(int i=0;i<n;i++)
        {
            char ch=S.charAt(i);

            freq[i%K][(int)ch-97]++;

        }
        int sum=0;

        int swaps=0;
        for(int j=0;j<K;j++)
        {
            max=0;
            sum=0;

            for (int i = 0; i < 26; i++)
            {  sum+=freq[j][i];
               if( max<freq[j][i]  && flag[i])
               {

                    max=freq[j][i];
               }

            }

            swaps+=sum-max;

        }

        return swaps;
    }


    public static boolean isPresent(char[] arr, char ch)
    {
         for(int i=0;i<arr.length;i++)
             if(ch==arr[i]) return true;
         return false;
    }

}
