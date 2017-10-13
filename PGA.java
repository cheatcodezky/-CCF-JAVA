import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by 95112 on 10/12/2017.
 */
public class PGA  {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[n];
        Stack<Integer> input = new Stack<>();
        int key = 1;
        for (int i = n ;  i > 0; i--)
        {
            input.add(i);
        }
        for (int i = 0 ; i< n; i++)
        {
            output[i]  = scanner.nextInt();
            if (stack.peek() != output[i])
            {
                while (output[i] != input.peek() )
                {
                    stack.add(input.pop());
                    if (input.isEmpty())
                    {
                        key = -1;
                        break;

                    }
                }
            }

        }
    }
}
