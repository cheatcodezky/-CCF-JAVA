package 动态规划;

import java.util.Scanner;

/**
 * Created by max on 17-5-11.
 */
public class Coin {
    private static int kinds;
    private static int aim_money;
    static int[] input_coin;
    static byte[][] G;
    static byte[]  visited;
    static int[] min;
    static int[] max;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        kinds = scanner.nextInt();
        aim_money  = scanner.nextInt();
        input_coin = new int[kinds];
        G = new byte[aim_money][aim_money];
        visited = new byte[aim_money];
        min = new int[aim_money];
        max = new int[aim_money];
        for(int i=0;i<kinds;i++)
        {
           input_coin[i] = scanner.nextInt();
        }

    }
    private static int  max_dp(int i)
    {
        if (i<0)
            return Integer.MIN_VALUE;
        if (visited[i] ==1)
            return max[i];
        visited[i] =1 ;
        int ans = -1;
        for (int j = 0;i< kinds;i++)
        {
            if (i>input_coin[j])
                ans = max(ans,max_dp(i - input_coin[i])+1);
        }
        max[i] = ans;
        return ans;
    }

    private static int max(int a,int b)
    {
        if (a>b)
            return a;
        else
            return b;
    }
    private static int min(int a,int b)
    {
        if (a>b)
            return b;
        else
            return a;
    }
}
