package 动态规划;

import java.util.Scanner;

/**
 * Created by max on 17-5-11.
 */
public class Retangle {

    private static int[] vertical;
    private static boolean[] visited;
    private static int d[];
    private static int length;
    private static boolean[][] G;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        length = scanner.nextInt();
        G = new boolean[length][length];
        vertical = new int[length];
        visited = new boolean[length];
        d = new int[length];
        for (int i = 0 ;i< length;i++)
        {
            vertical[i] = scanner.nextInt();
        }
        for (int i =0;i<length;i++) {
            for (int j = 0; j < length; j++) {
                if (vertical[i] > vertical[j])
                    G[i][j] = true;
                else
                    G[i][j] = false;

            }

        }

        int max  = -1;
        for (int i=0;i<length;i++)
        {
            if (max<dp(i))
                max = dp(i);
        }

        System.out.println(max);
    }
    private static int dp(int i)
    {

        if (visited[i]==true)
            return d[i];
        visited[i] = true;
        int ans = 1;
        for (int j=0;j<length;j++)
            if (G[i][j]==true) {
                ans = max(ans, dp(j) + 1);

            }
            d[i] = ans;
        return ans;
    }
    private static int max(int a,int b)
    {
        if (a>b)
            return a;
        else
            return b;
    }

}

