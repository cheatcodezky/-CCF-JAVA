import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/29/2017.
 */
public class INeedAOffer {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        do{
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if ( n == 0 && m == 0){
                break;
            }
            int[] money = new int[m];
            double[] probability = new double[m];
            for (int i =0 ;i < m ; i++)
            {
                money[i] = scanner.nextInt();
                probability[i] = 1 - scanner.nextDouble();
            }
            double[] dp = new double[n+1];
            for (int i = 0 ; i < n+1 ; i++)
                dp[i] = 1;
            for (int i =0 ;i < m ; i++){
                for (int j = n ; j >=0 ; j--){
                    if (j >= money[i] ){
                        dp[j] = min(dp[j] , dp[j - money[i]]*probability[i]);

                    }
                }
            }
            BigDecimal bg = new BigDecimal((1-dp[n])*100);
            double a = bg.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();

            answers.add(a+"%");
        }while(true);

        for (String answer : answers)
            System.out.println(answer);
    }
    private static double min(double a, double b)
    {
        if (a < b)
            return  a;
        else
            return  b;
    }
}
