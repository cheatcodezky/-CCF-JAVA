import java.util.Scanner;

/**
 * Created by ZhouKeyu on 17-3-16.
 */
public class CCF2016124 {
    private static int[][] memory;
    private static int[] sum ;
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] input = new int[number];
        sum = new int[number+1];
        memory = new int[number][number];
        for (int i=0;i<number;i++)
            for (int j=0;j<number;j++)
                memory[i][j] = Integer.MAX_VALUE;


        sum[0] = 0;
        for (int i=0;i<number;i++)
        {
            input[i] = scanner.nextInt();
            memory[i][i] = 0;
            sum[i+1] = sum[i] + input [i];
        }
        System.out.println(solve(0,number-1));




    }
    public static int solve(int start,int end)
    {
        if (memory[start][end] == Integer.MAX_VALUE)
        {
            for (int i = start;i<end;i++)
                memory[start][end] = min(solve(start,i)+solve(i+1,end)+sum[end+1]-sum[start],memory[start][end]);
        }
        return memory[start][end];
    }
    public static int min(int a,int b)
    {
        if (a>b)
            return b;
        else
            return a;
    }
}
