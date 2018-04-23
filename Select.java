import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Random;

/**
 * Created by 95112 on 2018/4/23.
 */
public class Select {
    public static void main(String[] args)
    {
        Random random = new Random(System.currentTimeMillis());
        int[] input = new int[10];
        for (int i=0;i<input.length;i++)
        {
            input[i] = random.nextInt()%100;
            System.out.print(input[i]+" ");
        }
        System.out.println();
        int[] answer = new int[input.length];
        for (int i =0 ; i < input.length;i++){
            int min = input[0];
            int index = 0;
            for (int j = 0; j < input.length;j++){
                if (min >= input[j]){
                    min = input[j];
                    index = j;
                }
            }
            input[index] = Integer.MAX_VALUE;
            answer[i] = min;
        }
        for (int i=0;i<input.length;i++)
        {

            System.out.print(answer[i]+" ");
        }
        System.out.println();
    }
}
