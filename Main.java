import sun.nio.ch.sctp.SctpNet;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by max on 17-3-18.
 */
public class Main {
    public static void main(String[] arg)
    {
        Hashtable<Integer,Integer> hashtable = new Hashtable<Integer,Integer>(3);
        Scanner scanner = new Scanner(System.in);
        int number_content = scanner.nextInt();
        int  number_relationship = scanner.nextInt();
        scanner.nextLine();
        boolean[][] myMap= new boolean[number_content+1][number_content+1];
        int[] start=new int[number_relationship];
        for (int i =0;i<number_relationship;i++)
        {
            String[] input =scanner.nextLine().split("\\ ");
            start[i] = Integer.valueOf(input[0]);
            myMap[Integer.valueOf(input[0])][Integer.valueOf(input[1])]=true;
            myMap[Integer.valueOf(input[1])][Integer.valueOf(input[0])]=true;
        }
        
//        for (int i = 0;i<number_relationship;i++)
//        {
//             if (hashtable.containsKey(start)||)
//        }
    }



}
