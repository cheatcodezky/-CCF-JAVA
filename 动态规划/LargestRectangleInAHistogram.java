package 动态规划;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by max on 17-4-25.
 */
public class LargestRectangleInAHistogram {

    public static void main(String[] args)
    {


        ArrayList<String> answer = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n;

        while((n=scanner.nextInt())!=0)
        {
            HashMap<Integer,HashMap<Integer,Character>> had = new HashMap<>();

            int h[] = new int[n];
            long[] value = new long[n];
            for (int i=0;i<n;i++)
            {
                h[i] = scanner.nextInt();
                had.put(i,new HashMap<>());
            }
            for (int i = 0;i<n;i++)
            {

                if (had.get(i).containsKey(h[i]))
                {
                    continue;
                }
                int j = i-1,z=i+1;
                int left = i;
                int right = i;
                while (j>=0)
                {
                    if (h[j]>=h[i])
                    {
                        left=j;
                        if (had.containsKey(left))
                        {
                            had.get(left).put(h[i],'x');
                        }
                        else
                        {
                            had.put(left,new HashMap<>());
                            had.get(left).put(h[i],'x');
                        }
                    }
                    else break;
                    j--;
                }
                while(z<n)
                {

                    if (h[z]>=h[i])
                    {
                        right=z;
                        if (had.containsKey(right))
                        {
                            had.get(right).put(h[i],'x');
                        }
                        else
                        {
                            had.put(right,new HashMap<>());
                            had.get(right).put(h[i],'x');
                        }
                    }
                    else break;
                    z++;
                }
                value[i] =(right-left+1)*h[i];
            }
            long max = 0;
            for (int i=0;i<n;i++)
                if (max<value[i])
                    max=value[i];
            answer.add(String.valueOf(max));
        }

        while (!answer.isEmpty())
        {
            System.out.println(answer.get(0));
            answer.remove(0);
        }
    }
}
