package GreedyAlgorithm;


import java.util.*;
import java.io.*;

public class FractionalKanpsack {




        public static void main(String[] args)throws IOException {
            /*
             * Your class should be named Solution.
             * Read input as specified in the question.
             * Print output as specified in the question.
             * Write your code here
             */

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));



            String[] st=br.readLine().split(" ");
            int n=Integer.parseInt(st[0]);
            int W=Integer.parseInt(st[1]);


            Bag[] bag=new Bag[n];

            for(int i=0;i<n;i++)
            {  st=br.readLine().split(" ");
                int val=Integer.parseInt(st[0]);
                int wt=Integer.parseInt(st[1]);
                double fr=(double)val/wt;

                bag[i]=new Bag(val,wt,fr);
            }

            //    System.out.println();
            //    System.out.println();
            Comparator<Bag> ob=(o1,o2)->(o1.fr>o2.fr)?-1:1;
            Arrays.sort(bag,ob);

            double ans=0;
            for(int i=0;i<n ;i++)
            {

                if(bag[i].wt>W)
                {
                    ans+=W*bag[i].fr;
                    W=0;

                }

                else if(bag[i].wt<=W)
                {
                    ans+= bag[i].val;
                    W-=bag[i].wt;
                }

                if(W==0)
                    break;


            }


            System.out.printf("%f",ans);

        }





    }

    class Bag
    {
        int val;
        int wt;
        double fr;
        Bag(int val, int wt ,double fr)
        {
            this.fr=fr;
            this.val=val;
            this.wt=wt;

        }
        void printB()
        {
            System.out.println(val+" "+fr+" "+wt);
        }
    }

    /**
     *
     Input:
        4 22
        6 4
        6 4
        4 4
        4 4

     Output:
        20.000000
*/
