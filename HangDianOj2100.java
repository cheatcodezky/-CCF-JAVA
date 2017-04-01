
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * Created by max on 17-4-1.
 */
public class HangDianOj2100 {
    public static ArrayList<String> answer = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();

            String[] ab = line.split(" +");
            answer.add(add(ab[0],ab[1]));
        }
        scanner.close();

        while (!answer.isEmpty())
        {
            System.out.println(answer.get(0));
            answer.remove(0);
        }

    }
    public static String add(String a,String b )
    {
        int length_a,length_b;
        length_a = a.length();
        length_b = b.length();
        if (length_a>length_b)
        {
            for (int i = 0;i<(length_a-length_b);i++)
            {
                b = 'A'+b;
            }
            length_b = length_a;
        }
        else if (length_a<length_b)
        {
            for (int i = 0;i<(length_b-length_a);i++)
            {
                a = 'A'+a;
            }
            length_a = length_b;
        }
        int tmp = 0;
        String answer = "";
        for (int i = length_a-1 ; i>=0;i--)
        {
            int ans = (a.charAt(i) - 'A')+(b.charAt(i) - 'A')+tmp;
            if (ans<26)
            {

                answer = (char)(ans+'A')+answer;
                tmp = 0;
            }
            else
            {
                ans = ans - 26;
                answer = (char)(ans+'A')+answer;
                tmp = 1;
            }

        }
        if (tmp ==1 )
        {
            answer = 'B'+answer;
        }

        StringBuilder testAnswer = new StringBuilder(answer);

        while(testAnswer.charAt(0)=='A'&&testAnswer.length()>1)
        {
            testAnswer.deleteCharAt(0);
        }

        return testAnswer.toString();
    }

}
