import java.util.Scanner;

/**
 * Created by ZhouKeyu on 17-3-18.
 */
public class Wave_max {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] input = new int[number];
        for (int i=0; i<number;i++)
        {
            input[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i=0;i<number-1;i++)
        {
            int tested = Math.abs(input[i]-input[i+1]);
            if (tested>max)
                max=tested;
        }
        System.out.println(max);
    }
}
