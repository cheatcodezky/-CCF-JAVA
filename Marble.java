import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 95112 on 10/10/2017.
 */
public class Marble {
    public static void main(String[] args)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();

        BigInteger bigInteger = new BigInteger("11");
        HashMap<Integer,Integer> stoneMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        do {
            int N,Q;
            int[] stones;
            N = scanner.nextInt();
            Q = scanner.nextInt();
            stones = new int[N];
            if (N==0 && Q==0)
            {
                break;
            }
            for (int i = 0 ; i< N ; i++)
            {
                stones[i] = scanner.nextInt();
            }
            Arrays.sort(stones);
            for (int i =0; i< N;i++)
            {
                stoneMap.put(stones[i],(i+1));
            }
            for (int i = 0; i < Q ;i++)
            {
                int key = scanner.nextInt();
                if (stoneMap.containsKey(key))
                {
                    System.out.println(stoneMap.get(key));
                }
            }

        }while (true);
    }
}
