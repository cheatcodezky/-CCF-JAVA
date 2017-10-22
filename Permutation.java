import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 95112 on 10/22/2017.
 */
public class Permutation {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int[] input = new int[n];
        HashMap<Integer,Integer> storage = new HashMap();
        for (int i = 0 ; i < n ; i++)
        {
            input[i] = scanner.nextInt();
            if (!storage.containsKey(input[i]))
                storage.put(input[i],i);
        }
        int count = 0;
        int key = 1;
        for (int i = 0 ;i < n ; i++)
        {
            if (input[i] == i)
                count++;
            else {
                if (storage.containsKey(i) && storage.get(i) == input[i] && key ==1){
                    count++;
                    count++;
                    key--;
                }
            }
        }
        if (key == 1 && count < n){
            count++;
        }

        System.out.println(count);
    }

}
