import java.util.Random;

/**
 * Created by 95112 on 2018/4/23.
 */
public class Insert {
    public static void main(String[] args){
        Random random = new Random(System.currentTimeMillis());
        int[] input = new int[10];
        for(int i = 0 ; i< 10;i++)
            input[i] = random.nextInt()%100;
        for (int i=1; i < input.length;i++){
            int temp = input[i];
            int j;
            for (j= i-1; j >=0 && input[j]>temp;j--){
                input[j+1] = input[j];
            }
            input[j+1] = temp;
        }
        for (int i=0; i < input.length;i++){
            System.out.print(input[i]+" ");
        }
    }
}
