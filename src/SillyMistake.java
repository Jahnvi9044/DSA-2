import java.util.*;

public class SillyMistake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (t-- > 0) {//Write your code here
            int n=sc.nextInt();

            int[] arr=new int[n];
            int sum=0,count=0;
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
                sum+=arr[i];
            }
            //corner case
            if(n%2!=0||sum!=0) {
                System.out.println(-1);
                return ;
            }
            ArrayList<Integer> ans=new ArrayList<>();
            HashMap<Integer,Integer> map=new HashMap<>();
            int i=0,j=0;
            while(j<n)
            {
                sum+=arr[j];
                if(arr[j]>0)
                {
                    if (!map.containsKey(arr[j])) {
                        map.put(arr[j], 1);
                        j++;
                    }
                    else if(map.containsKey(arr[j]) && sum-arr[j]==0)
                    {
                        //means once the employ has already entered , he cannot enter again -->so break;
                        ans.add(j-i);
                        i=j;
                        count++;
                        map.clear();
//                        System.out.println(" Cleared Map "+map);
//                        System.out.println(ans);
                        sum=0;
                    }
                    else {
                        System.out.println(-1);
                        return ;
                    }
                }

                else {
                    if(!map.containsKey(-1*arr[j]))
                    {
                        System.out.println(-1);
                        return ;
                    }
                    else if(map.containsKey(-1*arr[j]) && map.get(-1*arr[j])>=2) {
                        System.out.println(-1);
                        return ;

                    }
                    else if(map.containsKey(-1*arr[j]) && map.get(-1*arr[j])==1) {
                        map.put(-1*arr[j],2);
                        j++;

                    }
                }


            }

            ans.add(j-i);
            count++;

            System.out.println(count);
            for(Integer k:ans)
                System.out.print(k+" ");



        }

    }
}
