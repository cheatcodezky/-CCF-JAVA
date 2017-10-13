import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/13/2017.
 */
public class BrokenKeyboard {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        ArrayList<String> answers = new ArrayList<>();
        while (scanner.hasNext())
        {
            input = scanner.next();
            String output = "";
            int key = 1;
            Char first = new Char();
            first.name = "first";
            Char index = first;

            Char last  = first;
            for (int i=0; i <input.length();i++)
            {


                if (input.charAt(i) == '[')
                    index = first;
                else if (input.charAt(i) == ']')
                    while (index.next != null)
                    {
                        index = index.next;
                    }
                else
                {
                    if (index.next == null) {
                        index.next = new Char();
                        index.next.pre = index;
                        index.next.name = input.charAt(i) + "";
                        index = index.next;
                    }
                    else
                    {
                        Char tmp = new Char();
                        tmp.next = index.next;
                        tmp.pre = index;
                        tmp.name = input.charAt(i)+"";
                        index.next = tmp;
                        index = tmp;
                    }
                }
            }
            while (first.next!= null)
            {
                first = first.next;
                System.out.print(first.name);
            }
        }

    }
}
class Char{
    Char pre,next;
    String name;
}
