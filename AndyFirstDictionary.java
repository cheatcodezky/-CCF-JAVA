import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 95112 on 10/19/2017.
 */
public class AndyFirstDictionary {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input;
        String paStr = "([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(paStr);
        Matcher matcher;
        ArrayList<String> answer = new ArrayList();
        String tmp ;
        while(scanner.hasNextLine())
        {
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
            while (matcher.find()){

                tmp = matcher.group(1).toLowerCase();
                if (!answer.contains(tmp)&& tmp.length()>0) {
                    answer.add(tmp);
                }
            }

        }
        Collections.sort(answer);
        for ( String a : answer)
            System.out.println(a);
    }
}
