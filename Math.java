import java.util.Scanner;

/**
 * Created by 95112 on 11/1/2017.
 */
public class Math {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        int[] scores = new int[amount];
        int[] spentTime = new int[amount];
        for (int i = 0 ; i< amount;i++)
            scores[i] = scanner.nextInt();
        for (int i =0 ; i < amount ; i++)
            spentTime[i] = scanner.nextInt();
        int Time = scanner.nextInt();
        int[] dp = new int[Time+1];
        for (int i = 0 ;  i< amount; i++)
        {
            for (int j = Time ; j >=0 ; j--){
                if ( j >= spentTime[i]){
                    dp[j] = max(dp[j] , dp[j - spentTime[i]] + scores[i]);
                }
            }
        }
        System.out.println(dp[Time]);
    }
    private static int max(int a, int b)
    {
        if (a > b)
            return a;
        else
            return b;
    }
}
/*
5
5 4 3 5 2
2 2 3 5 1
10
 */