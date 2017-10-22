import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 95112 on 10/22/2017.
 */
public class Arrange {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0 ; i < n ; i++)
        {
            input[i] = scanner.nextInt();
        }

        Arrays.sort(input);
        int tmp;
        tmp = input[0];
        input[0] = input[n-1];
        input[n-1] = tmp;
        for (int a : input)
            System.out.print(a+" ");
    }

}
