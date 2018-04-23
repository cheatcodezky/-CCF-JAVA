import java.util.Random;

/**
 * Created by 95112 on 2018/4/21.
 */
public class Parti {
    static int[] input = new int[10];
    public static void main(String[] args){
        Random random = new Random(System.currentTimeMillis());

        System.out.println("origin : ");
        for (int i =0 ; i<input.length;i++){
            input[i] = random.nextInt()%100;
            System.out.print(input[i]+" ");
        }
        System.out.println();

        sort(input,0,input.length-1);
        for (int i =0 ; i<input.length;i++){
            System.out.print(input[i]+" ");
        }
        System.out.println();
    }
    public static void sort(int[] input,int start, int end){
        int s = start;
        int e = end;
        if (s>=e)
            return;
        while(s<e){
            while (s < e && input[s] <= input[e])e--;
            if (s < e){
                int temp = input[s];
                input[s] = input[e];
                input[e] = temp;
            }
            while (s < e && input[s] < input[e])s++;
            if (s < e){
                int temp = input[s];
                input[s] = input[e];
                input[e] = temp;
            }
        }
        sort(input,start,s-1);
        sort(input,s+1,end);

    }
}
