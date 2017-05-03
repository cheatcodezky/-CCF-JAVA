package 动态规划;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * Created by max on 17-4-25.
 */
public class LargestREctangle {
    public static void main(String[] args) {
        ArrayList<Double> answer = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n;

        while ((n = scanner.nextInt()) != 0) {


            long h[] = new long[n];
            int[] left = new int[n];
            int[] right = new int[n];

            for (int i = 0; i < n; i++) {
                h[i] = scanner.nextLong();
            }
            left[0] = 0;
            for (int i=1;i<n;i++)
            {
               left[i] = i;
                int j = i;
                while (j>0&&(h[i]<=h[j-1]))
                {
                    j = left[j-1];
                }
                left[i] =j;
            }
            right[n-1] = n-1;
            for (int i = n-2;i>=0;i--)
            {

                int j = i;
                while(j<(n-1)&&(h[i]<=h[j+1]))
                {
                    j = right[j+1];
                }
                right[i] = j;
            }
            double max = 0;
            double tmp = 0;
            for (int i=0;i<n;i++)
            {
                tmp = h[i]*(right[i]-left[i]+1);
                if (max<tmp)
                    max=tmp;
            }
            answer.add(max);
        }
        while (!answer.isEmpty())
        {
            System.out.printf("%.0f\n",answer.get(0));
            answer.remove(0);
        }
    }
}
