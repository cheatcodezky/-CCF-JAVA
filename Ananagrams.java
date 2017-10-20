import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 95112 on 10/20/2017.
 */
public class Ananagrams {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> storage = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String>  answers = new ArrayList<>();
        String paStr = "([a-zA-Z]+)";
        Pattern pattern = Pattern.compile(paStr);
        Matcher matcher;
        do {
            String input = scanner.nextLine();
            if (input.equals("#"))
                break;
            matcher = pattern.matcher(input);
            while (matcher.find())
            {
                if (!storage.contains(matcher.group(1))) {

                    storage.add(matcher.group(1));
                    String tmpStr = matcher.group(1).toLowerCase();
                    char[] tmp = tmpStr.toCharArray();
                    Arrays.sort(tmp);
                    tmpStr = String.valueOf(tmp);
                    if (!map.containsKey(tmpStr)) {
                        map.put(tmpStr,1);
                    }
                    else
                    {
                        map.put(tmpStr,map.get(tmpStr)+1);
                    }
                }
            }
        }while(true);
        for (String test : storage)
        {
            char[] tmp = test.toLowerCase().toCharArray();
            Arrays.sort(tmp);
            String tmpStr = String.valueOf(tmp);
            if (map.get(tmpStr) == 1)
                answers.add(test);
        }
        Collections.sort(answers);
        for (String ans : answers)
            System.out.println(ans);
    }
}
