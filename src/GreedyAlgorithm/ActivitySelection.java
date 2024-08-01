//package GreedyAlgorithm;
//import java.util.*;
//import java.io.*;
//
//
//public class ActivitySelection {
//
//        public static void main(String[] args)throws IOException {
//            /*
//             * Your class should be named Solution.
//             * Read input as specified in the question.
//             * Print output as specified in the question.
//             * Write your code here
//             */
//            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//
//
//            int n=Integer.parseInt(br.readLine());
//            if(n==0)
//                System.out.println(0);
//
//
//            Job[] jobs=new Job[n];
//
//            for(int i=0;i<n;i++)
//            {
//                String[] st=br.readLine().split(" ");
//                int s=Integer.parseInt(st[0]);
//                int f=Integer.parseInt(st[1]);
//                int val=Integer.parseInt(st[2]);
//
//                jobs[i]=new Job(s,f,val);
//            }
//
//            Comparator<Job> ob=(o1,o2)->(o1.e>o2.e)?1:-1;
//
//            Arrays.sort(jobs,ob);
//
//            System.out.println("After Sorting");
//            for(Job jb:jobs)
//                jb.printM();
//
//            int sum=jobs[0].val;
//
//            Job selected=jobs[0];
//
//            for(int i=1;i<n;i++)
//            {
//
//                System.out.print("Jobs");
//                jobs[i].printM();
//
//                System.out.print("Selected  ");
//                selected.printM();
//
//                if(jobs[i].s>selected.e && jobs[i].e>=selected.e ||  jobs[i].s<selected.s && jobs[i].e<=selected.s)
//                {
//                    jobs[i].printM();
//                    sum+=jobs[i].val;
//                    selected=jobs[i];
//
//                }
//
//            }
//            System.out.println(sum);
//
//
//        }
//
//    }
/////////////////////////////////////////////////////////////Job class///////////////////////////////////////////////////////////////////////
//    class Job
//    {
//
//        int s;
//        int e;
//        int val;
//        Job(int s,int e,int val)
//        { this.s=s;
//            this.e=e;
//            this.val=val;
//
//
//        }
//        void	printM()
//        {
//            System.out.println(s+" "+e+" "+val);
//        }
//    }
