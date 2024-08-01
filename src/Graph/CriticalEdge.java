package Graph;
import java.io.*;

import java.lang.reflect.Array;
import java.util.*;
//  Question :-
//https://www.geeksforgeeks.org/problems/critical-connections/1
public class CriticalEdge {
    static int timer;

    public static void dfs(int n, int parent, int[] visited, int[] tim, int[] low, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> bridges) {

        visited[n]=1;
        low[n]=timer;
        tim[n]=timer;
        timer++;

        for(Integer it:adj.get(n))
        {
            if (it == parent) continue;
            if (visited[it] == 0) {
                dfs(it, n, visited, tim, low, adj, bridges);
                low[n] = Math.min(low[n], low[it]);
                if (low[it] > tim[n])
                {
                    ArrayList<Integer> a=new ArrayList<>(2);


                    //We have to add sorted data

                    if(n<it)
                    {
                    a.add(n);
                    a.add(it);
                    }
                    else
                    {
                        a.add(it);
                        a.add(n);
                    }
                    bridges.add(a);

                }
            } else {
                low[n] = Math.min(low[n], low[it]);
            }
        }

    }

    public static ArrayList<ArrayList<Integer>> CriticalConnections(int n, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<ArrayList<Integer>> bridges=new ArrayList<>();

        int[] tim=new int[n];
        int[] low=new int[n];
        int[]  visited=new int[n];
        dfs(0,-1,visited,tim,low, adj, bridges);

       Collections.sort(bridges, (o1,o2)->(o1.get(0)==o2.get(0))?o1.get(1)-o2.get(1):o1.get(0)-o2.get(0) );
        return bridges;

    }

//   tarts
//Initial Template for Java

        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                String[] s = br.readLine().trim().split(" ");
                int V = Integer.parseInt(s[0]);
                int E = Integer.parseInt(s[1]);
                ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
                for(int i = 0; i < V; i++)
                    adj.add(i, new ArrayList<Integer>());
                for(int i = 0; i < E; i++){
                    String[] S = br.readLine().trim().split(" ");
                    int u = Integer.parseInt(S[0]);
                    int v = Integer.parseInt(S[1]);
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }

                ArrayList<ArrayList<Integer>> ans = CriticalConnections(V, adj);
                for(int i=0;i<ans.size();i++)
                    System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
            }
        }
    }
// } Driver Code Ends
//Input
//3
//3 2
//0 1
//0 2





//Input
//1
//9 11
//0 6
//0 5
//6 8
//6 7
//5 3
//8 4
//8 1
//6 2
//1 5
//7 2
//0 4

//
//Input
//1
//5 5
//1 2
//2 3
//4 1
//1 3
//0 1