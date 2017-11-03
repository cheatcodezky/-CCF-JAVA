import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 11/2/2017.
 */
public class Coins {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        do {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n == 0 && m == 0)
                break;
            int[] prices = new int[n];
            int[] amounts = new int[n];
            int[] dealPrices = new int[n*10001];
            int allAmount = 0;
            for (int i =0 ;i < n ; i++)
                prices[i] = scanner.nextInt();
            int index = 0;
            for (int i =0 ; i< n; i++) {
                amounts[i] = scanner.nextInt();

            }

            int[] dp = new int[m+1];
            for (int i =1 ; i < m; i++)
                dp[i] = Integer.MIN_VALUE;
            for (int i =0 ; i< n; i++)
            {
                int k = 1;
                int tmp = amounts[i];
                while (tmp - k >0)
                {
                    tmp -= k;
                    dealPrices[index++] = prices[i] * k;
                    k  *= 2;
                }
                dealPrices[index++] = prices[i] * tmp;
            }
            for (int i = 0; i <index; i++){
                for (int j = m; j >= dealPrices[i];j--){
                        dp[j] = max(dp[j],dp[j - dealPrices[i]]+dealPrices[i]);
                }
            }
            for (int i =1 ; i<=m ; i++){
                if (dp[i] > 0)
                    allAmount++;
            }
            answers.add(allAmount+"");
        }while(true);
        for (String answer : answers)
            System.out.println(answer);
    }
    private static int max(int a, int b)
    {
        if (a>b)
            return a;
        else
            return b;
    }
}
