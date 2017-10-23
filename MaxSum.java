import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/23/2017.
 */
public class MaxSum {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<String>> answers = new ArrayList<>();
        int n;
        n = scanner.nextInt();
        for (int i = 0 ; i < n ; i ++)
        {
            ArrayList<String> answer = new ArrayList<>();
            answer.add("Case "+(i+1)+":");
            int amount = scanner.nextInt();
            int[] input = new int[amount];
            for (int j = 0 ; j < amount; j++)
                input[j] = scanner.nextInt();
            int start = 0;
            int end;
            int answerStart= 0;
            int answerEnd= 0;
            int answerSum = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = 0 ; j < amount; j++) {
                sum += input[j];
                if (sum > answerSum) {
                    answerSum = sum;
                    answerStart = start+1;
                    answerEnd = j+1;

                }
                if (sum < 0) {
                    sum = 0;
                    start = j + 1;
                }
            }
            answer.add(answerSum+" "+answerStart+" "+answerEnd);
            answers.add(answer);
        }
        int i = 0;
        for (ArrayList<String> answer : answers){
            for (String a : answer)
                System.out.println(a);
            if (i< answers.size()-1)
                System.out.println("");
            i++;
        }
    }
}
