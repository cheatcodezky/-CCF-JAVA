import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 95112 on 2/23/2018.
 */
public class Supplement {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T,N,M;
        T = scanner.nextInt();
        while(T > 0){
            N = scanner.nextInt();
            M = scanner.nextInt();
            int[] days = new int[N];
            for (int i =0; i< N;i++)
                days[i] = scanner.nextInt();
            Arrays.sort(days);
            int start = 0,end = 100;
            int sum;
            int max = 0;
            int residue;
            for (int i = 0; i<N;i++){
                residue = M;
                sum = days[i] - start -1;
                int now;
                now = days[i];
                for (int j = i+1; j< N;j++){
                    if (residue == 0)
                        break;
                    sum += (days[j] - now);
                    residue--;
                    now = days[j];
                }
                if (now == days[days.length-1] && residue > 0)
                    sum += ( 100 - now + 1);
                if (sum>max)
                    max = sum;
                start = days[i];
            }
            System.out.println(max);
            T--;
        }
    }
}
