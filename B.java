import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/20/2017.
 */
public class B {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        int n;
        do {
            n  = scanner.nextInt();
            if (n == 0)
                break;
            int[] input = new int[n];
            for (int i = 0; i < n; i++)
                input[i] = scanner.nextInt();
            int answerFirst = 0;
            int answerLast = 0;
            int answerSum = 0;
            int answerLength = 0;
            int first = 0;
            int last = 0;
            int sum = 0;
            int changeKey = 0;
            for (int i = 0 ; i < n; i++){
                if (input[i]>=0)
                    changeKey = 1;
                sum+= input[i];
                if (sum < 0){
                    sum = 0;
                    first = i+1;
                    last = i+1;

                }
                else {
                    last = i;
                }
                if(sum > answerSum || (input[i] == 0 && answerSum == 0)){
                    answerSum = sum;
                    answerLast = last;
                    answerFirst = first;
                    answerLength = last - first + 1;
                }


            }
            if (changeKey == 1)
                answers.add( answerSum+" "+input[answerFirst]+" "+input[answerLast]);
            else
                answers.add( 0+" "+input[0]+" "+input[input.length-1]);
        }while(true);
        for (String output : answers)
            System.out.println(output);
    }

}
