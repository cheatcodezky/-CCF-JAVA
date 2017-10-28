import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 95112 on 10/28/2017.
 */
public class BigEvent {
    public static void main(String[] srgs)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        do {
            int N = scanner.nextInt();
            if (N <=0)
                break;
            int[] facilities = new int[100000000];
            int count = 0;
            int sum = 0;
            for (int i = 0 ; i < N;i++)
            {
                int V = scanner.nextInt();
                int M = scanner.nextInt();
                for (int j = 0; j< M;j++){
                    facilities[count++] = V;
                    sum += V;
                }
            }
            int half = sum/2; // error

            int[] dp = new int[half+1];
            dp[0] = 0;
            for (int i =0 ; i < count;i++){
                for(int j = half ;  j > 0; j--){
                    if (facilities[i] <= j && dp[j - facilities[i]] + facilities[i] <= half){
                        dp[j] = max(dp[j] , dp[j - facilities[i]] + facilities[i]);
                    }
                }
            }
    //        System.out.printf((sum-dp[half])+" "+dp[half]+"\n");
            answers.add((sum-dp[half])+" "+dp[half]+"\n");
        }while(true);
        for (String answer : answers)
            System.out.print(answer);
    }
    private static int max(int a,int b){
        if (a > b)
            return  a;
        else
            return b;
    }
}
/*

20 10
40 40
 */
