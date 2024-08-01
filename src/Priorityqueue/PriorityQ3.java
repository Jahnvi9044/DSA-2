package Priorityqueue;

import java.util.*;

public class PriorityQ3 {
    public static void main(String[] args) {
//        pqComparator  ob=new pqComparator();

//        Lambda Expression
//        min heap
//        Comparator<String > ob=(o1,o2)->(o1.length()>o2.length())?1:-1;
        Comparator<String > ob= Comparator.comparingInt(String::length);

        PriorityQueue<String> pq=new PriorityQueue<>(ob);
       Collections.addAll(pq, "Hey1","you2","there3" ,"how4","are5", "you6");


            while (!pq.isEmpty())
                System.out.print(pq.remove() + " ");


        System.out.println();
//        max heap
        pqComparator2  ob1=new pqComparator2();
        PriorityQueue<String> pq2=new PriorityQueue<>(ob1);
       Collections.addAll(pq2,"Hey1","you2","there3" ,"how4","are5", "you6");

        while(!pq2.isEmpty())
            System.out.print(pq2.remove()+" ");


    }
}


class pqComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) return -1;
        else if (o1.length() > o2.length()) return 1;
        return 0;
    }
}
class pqComparator2 implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) return 1;
        else if (o1.length() > o2.length()) return -1;
        else
         return 0;
    }
}