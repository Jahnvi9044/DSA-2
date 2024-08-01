package GreedyAlgorithm;

import java.util.*;

public class Candies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here

            int[] stu={8,7,6,5,4,6};
            System.out.println("Candies required are  "+requiredCandies(stu));
        }

    }



        public static int requiredCandies(int[] students) {
            // Write your code here.

            int n=students.length;
            int[] arr=new int[n];
            arr[0]=1;
            for(int i=1;i<n;i++)
            {  if(students[i-1]<students[i])
                arr[i]=arr[i-1]+1;
            else
            {
                arr[i]=1;
            }

            }
            //    System.out.println(Arrays.toString(arr));
            for(int i=n-2; i >=0 ; i--)
            {
                if(students[i]>students[i+1] && arr[i]<=arr[i+1] )
                    arr[i]=arr[i+1]+1;


            }
            int sum=0;
            for(int i=n-1; i >=0 ; i--)
            {
                sum+=arr[i];

            }
            return sum;
        }
    }






// 5 8 1 5 9 4
// 1 2 1 2 3 1
// 1 2 1 2 3 1


// 1 3 4
// 1 2 3


// 1 2 2
// 1 2 1


// 1 9 1 3 2 4
// 1 2 1 2 1 2


