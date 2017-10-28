import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/24/2017.
 */
public class BoneCollector {
    public static void main(String[] args)
    {
        long[] dp;
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        ArrayList<Long> answers = new ArrayList<>();
        while (T-- >0){
            int N,V;
            N = scanner.nextInt();
            V = scanner.nextInt();
            dp = new long[V+1];
            dp[0] = 0;
            int[] boneValue = new int[N];
            int[] boneVolume = new int[N];
            for (int i = 0 ; i< N;i++)
            {
                boneValue[i] = scanner.nextInt();
            }
            for (int i = 0 ;i < N;i++)
            {
                boneVolume[i] = scanner.nextInt();
            }
            for (int i = 0 ; i < N; i++){
                for (int j=V ; j >= 0 ;j--){
                    if (boneVolume[i] <= j)
                        dp[j] = max(dp[j],dp[j - boneVolume[i]]+boneValue[i]);
                    else
                        break;
                }
            }
            answers.add(dp[V]);
        }
        for (Long answer : answers){
            System.out.println(answer);
        }
    }
    public static long max(long a, long b){
        if (a>b)
            return  a;
        else
                return b;
    }

}
