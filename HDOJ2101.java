import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by max on 17-4-2.
 */
public class HDOJ2101 {
    static ArrayList<String> answer = new ArrayList<>();
    public static void main(String[] args)
    {
        int a,b;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext())
        {
            a = scanner.nextInt();
            b = scanner.nextInt();
            if ((a+b)%86 == 0 )
            {
                answer.add("yes");
            }
            else
            {
                answer.add("no");
            }
        }
        while (!answer.isEmpty())
        {
            System.out.println(answer.get(0));
            answer.remove(0);
        }
    }
}
