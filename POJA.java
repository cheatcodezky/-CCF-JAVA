import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/20/2017.
 */
public class POJA {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> answers = new ArrayList<>();
        for (int i = 0 ; i< n; i++)
        {
            String input = scanner.next();
            int[] alphabet = new int[26];
            for (int j = 0; j < 26 ; j++)
                alphabet[j] = 0;
            for (char tmp: input.toCharArray()){
                alphabet[tmp - 'a']++;
            }
            int count = 0;
            for (int tmp : alphabet)
                if (tmp%2 == 1)
                    count++;
            if (count > 1)
            {
                answers.add("Impossible");
                continue;
            }
            char[] inputChar = input.toCharArray();
            int x = 0;
            int y = input.length()-1;
            int answer = 0;
            for ( ; x < input.length() && x < y ; x++,y--){
                int left = x;
                int right = y;
                for (;left < y; left++){
                    if (inputChar[left] == inputChar[y])
                        break;
                }
                for (; right > x ; right--){
                    if (inputChar[right] == inputChar[x])
                        break;
                }
                if (left - x > (y - right))
                {
                    char deal;
                    answer += (y - right);
                    for (int start = right ; start < y; start++ )
                    {
                        deal = inputChar[start+1];
                        inputChar[start+1] = inputChar[start];
                        inputChar[start] = deal;
                    }
                }
                else {
                    char deal;
                    answer += (left-x);
                    for (int start = left; start > 0 ; start--)
                    {
                        deal = inputChar[start];
                        inputChar[start] = inputChar[start-1];
                        inputChar[start-1] = deal;
                    }
                }

            }

            answers.add(String.valueOf(answer));

        }
        for (String answer : answers)
            System.out.println(answer);
    }
}
