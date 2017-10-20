import java.util.Scanner;

/**
 * Created by 95112 on 10/15/2017.
 */
public class Ofo {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0 ; i< n;i++)
        {
            scores[i] = scanner.nextInt();
        }
    }
}
