import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by max on 17-4-13.
 */
public class HDOJ2110 {
    static ArrayList<String> answer = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n ;
        while((n=scanner.nextInt())!=0)
        {
//            int[] china,japanses;
//            china = new int[n];
//            japanses = new int[n];

            ArrayList<Integer> china,japanses;
            china = new ArrayList<>();
            japanses = new ArrayList<>();
            int a = 0 ,b = 0;

            for (int i = 0 ; i<n ; i++)
            {
                china.add(scanner.nextInt());
            }
            for (int i = 0 ; i<n;i++)
            {
                japanses.add(scanner.nextInt());
            }
            Collections.sort(china);
            Collections.sort(japanses);

            for(int i = 0 ; i< n ; i++)
            {



                if (china.get(i) >japanses.get(i))
                {
                    a +=2;
                }
                else if (japanses.get(i)>china.get(i))
                {
                    b +=2;
                }
                else
                {
                    a +=1;
                    b +=1;
                }
            }
            answer.add(a+" vs "+b);
        }

        while (!answer.isEmpty())
        {
            System.out.println(answer.get(0));
            answer.remove(0);
        }
    }
}
