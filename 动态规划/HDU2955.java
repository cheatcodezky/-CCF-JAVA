package 动态规划; /**
 * Created by MyWorld on 2017/4/18.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class HDU2955 {
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T, N;
        float P;
        T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            P = scanner.nextFloat();
            N = scanner.nextInt();
            int all_money = 0;
            int[] cash = new int[N];
            float[] p_cash = new float[N];
            float p_min = 1;
            for (int j = 0; j < N; j++) {
                cash[j] = scanner.nextInt();
                all_money += cash[j];
                p_cash[j] = scanner.nextFloat();
                p_cash[j] = 1 - p_cash[j];
            }
            P = 1 - P;
            float[] dp = new float[all_money+1];
            dp[0] = 1;
            for (int j = 0; j < N; j++) {
                for (int z = all_money; z >= cash[j]; z--) {
                    dp[z] = dp[z] > (dp[z - cash[j]] * p_cash[j]) ? dp[z] : (dp[z - cash[j]] * p_cash[j]);
                }
            }
            int j;
            for (j = all_money; j > 0; j--) {
                if (dp[j] > P)
                    break;
            }
            answer.add(j);

        }
        while (!answer.isEmpty()) {
            System.out.println(answer.get(0));
            answer.remove(0);
        }
    }
}




