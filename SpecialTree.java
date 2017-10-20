import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 95112 on 10/17/2017.
 */
public class SpecialTree {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String pattern =  "((\\d *),(\\w*))";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);
        while (m.find())
            System.out.println(m.group(1));
    }
}
