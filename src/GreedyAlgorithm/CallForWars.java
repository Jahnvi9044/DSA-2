package GreedyAlgorithm;

import java.util.*;

public class CallForWars {


    /**Call of War
        Send Feedback
        Decen Tile Games have launched a new First Person Shooter soldier game, called the Call of War, that young gamers can play on their website.
        Our protagonist, Ninja (played by you) is a soldier whose mission is to kill all the enemies plotting against you. Your enemies are standing in a circle, numbered clockwise from 1 to n. Initially, the i-th enemy has ai health.
        You have only one pistol, and infinite bullet magazines. You have to shoot the enemies in order to kill them. Each bullet fired at the enemy decreases their health by 1 (deals 1 damage to it). When the health of some enemy i becomes O or less than 0, he dies and his grenade drops down and explodes, dealing bi damage to the next enemy (enemy i+1, if i<n, or enemy 1, if i=n). If the next enemy is already dead, then nothing happens. If the frag from the grenade kills the next enemy, even he drops a grenade, damaging the enemy after him and possibly triggering another explosion, and so on.
        You have to calculate the minimum number of bullets you need in order to kill all the enemies and win the game.
        Input Format:
        First line of input will contain T(number of test cases). each test case follows as. Line 1: contain an integer N Next N line contains two space separated integers a and b
        Output Format:
        For each test case print the output in a new line.
        Constraints:
        1 <= T <= 100
        1 <= N <= 10^4
        1 <= a, b <= 10^12

        Sample Input:
        1
        3
        7
        15
        2 14
        53
        Sample Output:
        6
     */







    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here


            int n=sc.nextInt();

            long[] health=new long[n];
            long[] bomb=new long[n];
            for(int i=0;i<n;i++)
            {
                long a=sc.nextLong();
                long b=sc.nextLong();

                health[i]=a;
                bomb[i]=b;
            }



            long[] post_detonation=new long[n];
            for(int i=0;i<n;i++)
            {
                post_detonation[(i+1)%n]= Math.max(0,health[(i+1)%n]-bomb[i]) ;

            }


            long total_additional = 0;
            for(int i=0;i<n;i++)
            {
                total_additional+=post_detonation[i];
            }

            long ans=Long.MAX_VALUE,req;

            for(int i=0;i<n;i++)
            {
                req=health[i]+total_additional-post_detonation[i];
                ans=Math.min(req,ans);

            }

            System.out.println(ans);




        }

    }

}

