import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by max on 17-4-12.
 */
public class HDOJ2107 {
    public static void main(String[] args)
    {
        ArrayList<Long> answer = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n!=0) {
            long max = 0;
            long[] ac = new long[n];
            for (int i = 0; i < n; i++) {
                ac[i] = scanner.nextInt();
                if (max < ac[i]) {
                    max = ac[i];
                }
            }
            answer.add(max);
            n = scanner.nextInt();
        }
        while (!answer.isEmpty())
        {
            System.out.println(answer.get(0));
            answer.remove(0);
        }
    }
}
