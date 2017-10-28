import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/24/2017.
 */
public class Lemon {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        ArrayList<Long> answers = new ArrayList<>();
        while (C-- > 0){
            int n ,m;
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[][] map = new int[n][m];
            for (int i =  0 ; i < n ; i++)
                for (int j = 0 ; j < m; j++)
                {
                    map[i][j]  = scanner.nextInt();
                }
            long[]dp = new long[m];
            dp[0] = map[0][0];
            for (int i =1 ; i < m ; i++)
            {
                dp[i] = Integer.MIN_VALUE;
                for (int x = 0 ; x< i;x++)
                {
                  if ((i+1)%(x+1)==0 || x== i-1){
                      dp[i] = max(dp[i],dp[x]+map[0][i]);
                  }
                }
            }
            for (int i = 1 ; i < n; i++)
                for (int j = 0 ; j < m; j++)
                {
                    dp[j] += map[i][j];
                    for (int x = 0; x < j; x++){
                        if ((j+1)%(x+1) == 0 || x == j -1){
                            dp[j] = max(dp[j],dp[x]+map[i][j]);
                        }
                    }
                }
                answers.add(dp[m-1]);
        }
        for (long answer : answers){
            System.out.println(answer);
        }
    }
    private static long max(long a, long b){
        if (a>b)
            return a;
        else
            return b;
    }
}
