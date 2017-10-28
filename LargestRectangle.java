import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 95112 on 10/23/2017.
 */
public class LargestRectangle {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> answers = new ArrayList<>();

        int n ;
        do {
            n = scanner.nextInt();
            if (n == 0)
                break;
            HashMap<Integer,Integer> map = new HashMap<>();
            int[] left = new int[n];
            int[] right = new int[n];
            int[] input = new int[n];
            left[0] = 0;
            right[n-1] = n-1;
            for (int i = 0 ; i < n; i ++ ){
                input[i] = scanner.nextInt();
            }
            long sum = 0;
            for (int i = 1 ; i < n ; i++)
            {
                int j =i ;
                while (j > 0 && input[j-1] >= input[i] ) {
                    j = left[j-1];
                }
                left[i] = j;
            }
            for (int i = n-2; i >=0 ; i--)
            {
                int j = i ;
                while ( j < n - 1 && input[j+1] >= input[i]) {
                    j = right[j+1];

                }
                right[i] = j;

            }
            for (int i= 0 ; i< n; i++)
            {
                Long length = Long.valueOf((right[i] - left[i] +1 ));
                Long tmp = length * input[i];
                if (tmp > sum){
                    sum = length * input[i];
                }
            }
            answers.add(sum);
        }while (true);
        for (Long answer : answers)
            System.out.println(answer);
    }
}
