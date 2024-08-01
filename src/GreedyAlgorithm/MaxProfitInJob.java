 package GreedyAlgorithm;
import java.util.*;
import java.io.*;
public class MaxProfitInJob {
/**
 * Input:
 *      4
        3 5 200
        1 2 50
        6 19 100
        2 100 200

      Output:  350



 Input:

 4
 3 10 20
 1 2 50
 6 19 100
 2 100 200

 Output:250
*/
        public static void main(String[] args)throws IOException {
            /*
             * Your class should be named Solution.
             * Read input as specified in the question.
             * Print output as specified in the question.
             * Write your code here
             */
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


            int n=Integer.parseInt(br.readLine());
            if(n==0)
                System.out.println(0);


            GreedyAlgorithm.Job[] jobs=new GreedyAlgorithm.Job[n];

            for(int i=0;i<n;i++)
            {
                String[] st=br.readLine().split(" ");
                int s=Integer.parseInt(st[0]);
                int f=Integer.parseInt(st[1]);
                int val=Integer.parseInt(st[2]);

                jobs[i]=new GreedyAlgorithm.Job(s,f,val);
            }

            Comparator<GreedyAlgorithm.Job> ob=(o1, o2)->(o1.s>o2.s)?1:-1;

            Arrays.sort(jobs,ob);

            int[] arr=new int[n+1];

//            jobSchedulingM(jobs, n, 0,arr);
//            System.out.println( arr[0]);

            System.out.println(jobSchedulingDp(jobs, n , 0, arr));
        }

    private static  int jobSchedulingDp(Job[] jobs,int n,int j,int[] arr)
    {
        arr[n]=0;
        for(int i=n-1;i>=0;i--)
        {
            int ans1=0,ans2=0;
            int nextIndex=nextNonOverlappingJob( jobs, n, i);
            ans1 = jobs[i].val + arr[nextIndex] ;
            ans2 = arr[i+1];
            arr[i]=Math.max(ans1,ans2);

        }
        return arr[0];

    }

    private static int jobSchedulingM(Job[] jobs,int n,int j,int[] arr)
    {
        if(j>=n)
            return 0;

        if(arr[j]!=0)
            return arr[j];

        int nextNonOverlappingJob=nextNonOverlappingJob( jobs, n, j);

        int ans1=0;
        //if i consider this job as my solution
        if(nextNonOverlappingJob!=-1)
            ans1 =  jobs[j].val + jobSchedulingM(jobs,n,nextNonOverlappingJob,arr);
        int ans2 =  jobSchedulingM(jobs , n , j+1 , arr);
        int myans=Math.max(ans1,ans2);
        arr[j]=myans;
        return arr[j];

    }

    public static int nextNonOverlappingJob(Job[] jobs,int n,int j){
        int target=jobs[j].e;
        int ans=n+1;
        int low=j+1, high=n-1, mid=0;
        while(low<=high)
        {
            mid=low+(high-low)/2;

            if(jobs[mid].s>=target)
            {  ans=mid;
                high=mid-1;
                //  search for better
            }
            else low=mid+1;

        }
        return ans;

    }
}





 class Job
 {

     int s;
     int e;
     int val;
     Job(int s,int e,int val)
     { this.s=s;
         this.e=e;
         this.val=val;


     }
     void	printM()
     {
         System.out.println(s+" "+e+" "+val);
     }
 }