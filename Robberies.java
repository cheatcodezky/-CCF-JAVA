import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/23/2017.
 */
public class Robberies {
    static double dp[];
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        ArrayList<Integer> answers = new ArrayList<>();
        while (T >0){
            int sum = 0;
            double alive = 1 - scanner.nextDouble();
            int amountBanks = scanner.nextInt();
            double[] bankAlive = new double[amountBanks];
            int[] valueBank = new int[amountBanks];
            for (int i =0 ; i < amountBanks; i++)
            {
                valueBank[i] = scanner.nextInt();
                bankAlive[i]  = 1 - scanner.nextDouble();
                sum += valueBank[i];
            }
            dp = new double[100010];
            dp[0] = 1;
            for (int i = 0 ; i < amountBanks ; i++){
                for (int j = sum; j >= valueBank[i] ; j --){
                    dp[j] = max(dp[j],dp[j-valueBank[i]] * bankAlive[i]);
                }

            }
            for (int i = sum; i >= 0; i--){
                if (dp[i] > alive)
                {
                    answers.add(i);
                    break;
                }
            }

            T--;
        }
        for (Integer a : answers){
            System.out.println(a);
        }
    }
    private static double max(double a, double b)
    {
        if (a > b)
            return a;
        else
            return b;
    }
}
