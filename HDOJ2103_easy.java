import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * Created by max on 17-4-10.
 */
public class HDOJ2103_easy {
    static ArrayList<String> answer = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T,N,M;
        T = scanner.nextInt();
        for (int i = 0;i<T;i++)
        {
            M = scanner.nextInt();
            N = scanner.nextInt();

            byte[] input = new byte[N];
            for (int j = 0;j<N;j++)
            {
                input[j]  = scanner.nextByte();
            }
            int count = 0;

            int limit = N<=M?N:M;

            for(int j= 0; j<limit;j++)
            {
                if (input[j]==1)
                {

                    count = limit -j-1;
                    break;
                }
            }
            if (N>M)
            {
                count += (N-M);
            }

                answer.add(pay(count - 1) + " " + "RMB");

        }
        while(!answer.isEmpty())
        {
            System.out.println(answer.get(0));
            answer.remove(0);
        }
    }
    public static long pay(int times)
    {
        if (times<0)
            return 0;
        long pay_mid = (long)pow(2,times)*10000;
        return pay_mid+pay(times-1);
    }
}
