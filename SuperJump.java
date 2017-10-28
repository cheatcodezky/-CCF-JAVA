import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 95112 on 10/24/2017.
 */
public class SuperJump {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Long> answers= new ArrayList<>();
        do {
            int n = scanner.nextInt();
            if (n == 0)
                break;
            int[] input = new int[n];
            long[] dp ;
            int max = 0;
            dp = new long[10001];
            dp[0] = 0;
            dp[1] = input[0];
            for (int i = 0 ; i< n ; i++)
            {
                input[i] = scanner.nextInt();
                dp[i+1] = input[i];
                if (max < input[i]){
                    max = input[i];
                }
            }

            for (int i = 0 ; i < n ;i++){
                for (int j = 0 ; j< i ; j++){
                    if(input[i] > input[j]){
                        dp[i+1] = max(dp[i+1],dp[j+1]+input[i]);
                    }
                }
            }
            long amax = 0;
            for (int i = 0 ; i<= n;i++)
            {
                if (amax<dp[i])
                    amax = dp[i];

            }
            answers.add(amax);

        }while (true);
        for (Long answer : answers){
            System.out.println(answer);
        }
    }
    public static long max(long a, long b)
    {
        if (a > b)
            return a;
        else
            return b;
    }
}
