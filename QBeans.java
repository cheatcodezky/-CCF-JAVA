

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 95112 on 11/3/2017.
 */
public class QBeans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        int N, M;
        N =0 ;
        M = 0;
        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            String p = "(\\d+)";
            Pattern pattern = Pattern.compile(p);
            Matcher matcher = pattern.matcher(input);
            String[] deal = input.split(" ");
            if (matcher.find())
                N = Integer.valueOf(matcher.group(1));
            if (matcher.find())
                M = Integer.valueOf(matcher.group(1));
            if (N == 0 || M==0)
                break;
            long[] vertical = new long[N];
            long[][] map = new long[N][M];
            for (int i = 0; i < N; i++) {
                int j = 0;
                input = scanner.nextLine();
                matcher = pattern.matcher(input);
                while (matcher.find())
                    map[i][j++] = Integer.valueOf(matcher.group(1));
                long[] dp = new long[M + 1];
                dp[0] = 0;
                dp[1] = map[i][0];
                for ( j = 2; j <= M; j++) {
                    dp[j] = max(dp[j - 1], dp[j - 2] + map[i][j - 1]);
                }
                vertical[i] = dp[M];
            }

            long[] dp = new long[N + 1];
            dp[1] = vertical[0];
            for (int i = 2; i <= N; i++) {
                dp[i] = max(dp[i - 1], dp[i - 2] + vertical[i - 1]);
            }
          answers.add(dp[N]+"");

        }
        for (String answer : answers)
            System.out.println(answer);
    }
    private static long max(long a,long b)
    {
        if (a>b)
            return a;
        else
            return b;
    }
}
