package 动态规划;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by max on 17-4-25.
 */
public class MaxSum {
    static ArrayList<String> answer = new ArrayList<>();
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T!=0)
        {
            int all = 0;
            int tmp_all = 0;
            int start = 0;
            int end = 0;
            int ans_start = 0;
            int ans_end = 0;
            int N = scanner.nextInt();
            int input[] = new int[N];
            int key = Integer.MIN_VALUE;
            int step = 0;
            for (int i=0;i<N;i++) {

                input[i] = scanner.nextInt();
                end = i;

                if (key<input[i])
                {
                    key = input[i];
                    step = i+1;
                }
                tmp_all += input[i];
                if (tmp_all > all) {
                    ans_start = start;
                    ans_end = end;
                    all = tmp_all;
                }
                if (tmp_all < 0) {
                    start = i+1;
                    tmp_all = 0;
                }


            }
            if (key<0)
            {
                answer.add(key+" "+step+" "+step);
            }
            else{
                answer.add(all+" "+(ans_start+1)+" "+(ans_end+1));
            }


            T--;
        }
        int i = 1;
        int length = answer.size();
        while (!answer.isEmpty())
        {
            System.out.println("Case "+i+":");
            System.out.println(answer.get(0));
            if (i!=length)
                System.out.println("");

            answer.remove(0);
            i++;
        }
    }
}
