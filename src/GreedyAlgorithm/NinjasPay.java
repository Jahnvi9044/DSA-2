package GreedyAlgorithm;

import java.util.*;

public class NinjasPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
                        //1.3 500 1 1.25
            int n = 4; //  1  2  3  4
            int[] time = {4,1000,2,5};
            int[] loss = {3,1,2,4};
            Job1[] job = new Job1[n];

            for (int i = 0; i < n; i++) {
                job[i] = new Job1(i, time[i], loss[i]);
            }
            System.out.println(Arrays.toString(minLoss(job,n,time,loss)));
        }
    }


    public static int[] minLoss(Job1[] job,int n, int[] time, int[] loss) {
        // Write your code here


        Comparator<Job1> ob = (ob1, ob2) -> {


            if (ob1.t / ob1.l <  ob2.t / ob2.l)
                return -1;
            else if ( ob1.t / ob1.l > ob2.t / ob2.l )
                return 1;
            else {
                if (ob1.i < ob2.i)
                    return 1;
                else return -1;
            }
        };


           Arrays.sort(job,ob);

           int[] ans=new int[n];
           for(int i=0;i<n;i++)
           {
               ans[i]=job[i].i+1;
           }

        return ans;
    }
}






class Job1
{
    int i;
    float t;
    float l;
    Job1(int i, float t,float l)
    {
        this.i=i;
        this.t=t;
        this.l=l;
    }

}










