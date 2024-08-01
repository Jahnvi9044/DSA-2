import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
           int a=10, b=20;

          if((a=1)==2)
              System.out.println("yep");
          else if(++a<1 && a/0==9)
              System.out.println("yepppp");
          else System.out.println(a);
        }

    }
}
