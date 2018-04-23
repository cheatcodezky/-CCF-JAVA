import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 95112 on 2018/4/20.
 */
public class MagicBox {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] xyz = new int[3];
        xyz[0] = scanner.nextInt();
        xyz[1] = scanner.nextInt();
        xyz[2] = scanner.nextInt();
        scanner.nextLine();
        String input= scanner.nextLine();
        char[] squence = input.toCharArray();
        int amountOfR = 0,amountOfB = 0,amountOfY = 0;
        int maxSize = 0;
        int sum = 0;
        Arrays.sort(xyz);
        int[] del = new int[3];
        for (int i =0 ;i < squence.length;i++ )
        {
            char now = squence[i];
            if (now == 'R')
                amountOfR++;
            else if(now == 'B')
                amountOfB++;
            else if(now == 'Y')
                amountOfY++;
            sum++;
            if (maxSize < sum)
                maxSize = sum;
            del[0] = Math.abs(amountOfB - amountOfR);
            del[1] = Math.abs(amountOfB - amountOfY);
            del[2] = Math.abs(amountOfR - amountOfY);
            Arrays.sort(del);
            if (del[0] == xyz[0] && del[1] == xyz[1] && del[2] == xyz[2]) {
                sum = 0;
                amountOfB = 0;
                amountOfR = 0;
                amountOfY = 0;
            }
        }
        System.out.println(maxSize);
    }
}
