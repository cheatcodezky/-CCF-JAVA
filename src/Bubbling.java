import java.util.Scanner;

/**
 * Created by 95112 on 12/5/2017.
 */
public class Bubbling {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[10];
        for (int i =0 ; i < 10; i++)
        {
            input[i] = scanner.nextInt();
        }
        int tmp;
        for (int i = 9; i > 0 ; i--) {
            for (int j = 0 ; j< i; j++){
                if (input[j] > input[j+1]){
                    tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }
        }
        for (int a : input){
            System.out.print(a+" ");
        }
    }
}
