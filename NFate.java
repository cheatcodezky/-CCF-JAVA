import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/29/2017.
 */
public class NFate {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answrs = new ArrayList<>();
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int s = scanner.nextInt();
            int[] experiencePoint = new int[k];
            int[] patience = new int[k];
            for(int i = 0 ; i< k ; i++)
            {
                experiencePoint[i] = scanner.nextInt();
                patience[i] = scanner.nextInt();
            }
            int[] dp = new int[n+1];
            dp[0] = m;
            for (int i =1 ; i< n+1 ; i++){
                dp[i] = -1;
            }
            for (int i = 0; i < s ;i++) {
                    for (int  z = n ; z >=0 ;z--){
                        for (int j =0 ; j < k;j++) {
                            if (experiencePoint[j] >= z) {
                                dp[z] = max(dp[z], dp[0] - patience[j]);
                            } else {
                                if (dp[z - experiencePoint[j]] >= 0) {
                                    dp[z] = max(dp[z], dp[z - experiencePoint[j]] - patience[j]);
                                }
                            }
                        }
                    }

            }
            if (dp[n] < 0 )
                answrs.add("-1");
            else{
                answrs.add(dp[n] +"");
            }
        }
        for (String answer :answrs){
            System.out.println(answer);
        }
    }
    private static int max(int a, int b)
    {
        if (a>b)
            return  a;
        else
            return  b;
    }
}
