import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by 95112 on 10/25/2017.
 */
public class Algorithms {
    public static void main(String[] args)
    {
        Random random = new Random();
        int[] input = new int[100];
        for (int i =0 ; i < input.length; i++)
        {
            input[i] = random.nextInt();
        }
        for(int output : input)
        {
            System.out.print(output+" ");
        }
        System.out.println("");
        Arrays.sort(input );
        for(int output : input)
        {
            System.out.print(output+" ");
        }
    }
}
