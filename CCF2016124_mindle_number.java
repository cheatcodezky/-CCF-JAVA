import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by max on 17-3-16.
 */
public class CCF2016124_mindle_number implements Comparator<Integer>{
    private static Integer[] input;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        input = new Integer[number];
        for (int i= 0;i<number;i++)
        {
            input[i] = scanner.nextInt();
        }
        Arrays.sort(input, new CCF2016124_mindle_number());
        for (int i =0;i<input.length;i++)
        {
            System.out.print(input[i]+" ");
        }
//        ArrayList<Integer> list= new ArrayList<Integer>(Arrays.asList(input));
//        list.sort();
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
