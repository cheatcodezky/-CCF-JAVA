import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 11/2/2017.
 */
public class DP {
    static int dp[];
    static int a[];
    static int b[] ;
    static void OneZeroPack(int m , int v , int w)
    {
        for (int i = m ; i>=v;i--){
            dp[i] = max(dp[i],dp[i-v]+w);
        }
    }
    static void CompletePack(int m,int v,int w)
    {
        for (int i = v ; i<=m;i++)
        {
            dp[i] = max(dp[i], dp[i-v]+w);
        }
    }

    static void MultiplePack(int m,int v, int w,int num){
        if (v*num >= m)
        {
            CompletePack(m,v,w);
            return;
        }
        int k = 1;
        for (k=1; k <=num; k<<=1){
            OneZeroPack(m,k*v,k*w);
            num = num - k;
        }
        if (num>0){
            OneZeroPack(m,v*num,w*num);
        }

    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        int n, m;
        do {
            n = scanner.nextInt();
            m = scanner.nextInt();
            if (n == 0 && m == 0)
                break;
            dp = new int[1111111];
            a = new int[111];
            b = new int[111];
            for (int i =0 ; i < n;i++)
                a[i] = scanner.nextInt();
            for (int i = 0; i < n;i++)
                b[i] = scanner.nextInt();
            for (int i = 0; i < n;i++)
            {
                MultiplePack(m,a[i],a[i],b[i]);
            }
            int sum = 0;
            for (int i= 1; i<= m;i++)
                if (dp[i] == i)
                    sum++;
            answers.add(sum+"");
        }while (true);
        for (String answer : answers)
            System.out.println(answer);
    }
    static int max(int a,int b)
    {
        if (a>b)
            return a;
        else
            return b;
    }

}
