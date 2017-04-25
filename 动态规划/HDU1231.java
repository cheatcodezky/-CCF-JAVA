package 动态规划;

import java.util.*;

/**
 * Created by MyWorld on 2017/4/18.
 */
public class HDU1231 {
    static ArrayList<String> answer = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (N!=0)
        {
            int[] input = new int[N];
            int answer_start=0,answer_end = 0;
            int max = 0;
            int tmp = 0;
            int tmp_start = 0 ,tmp_end=0;
            for (int i  = 0 ; i <N;i++)
            {
                input[i] =  scanner.nextInt();
                tmp+= input[i];
                tmp_end = i;
                if (max<tmp)
                {
                    answer_end = tmp_end;
                    answer_start = tmp_start;
                    max =tmp;

                }
                if (max==0&&tmp==0)
                {
                    answer_end = tmp_end;
                    answer_start = tmp_start;
                }
                if (tmp<0)
                {
                    tmp = 0;
                    if (i!=N-1)
                        tmp_start = i+1;
                }
            }
            if (max==0&&input[answer_start]!=0)
            {
                answer_start = 0;
                answer_end  = N-1;
            }
            answer.add(max+" "+input[answer_start]+" "+input[answer_end]);
            N = scanner.nextInt();

        }
        while(!answer.isEmpty())
        {
            System.out.println(answer.get(0));
            answer.remove(0);
        }
    }
}
