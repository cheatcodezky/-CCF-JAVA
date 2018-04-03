import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 95112 on 2/23/2018.
 */
public class Marshtomp {
    private int
            testNumber = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String output = "";
        Pattern p = Pattern.compile("marshtomp",Pattern.CASE_INSENSITIVE);
        while(scanner.hasNextLine()){
            output = scanner.nextLine();
            Matcher m2 = p.matcher(output);
            System.out.println(m2.replaceAll("fjxmlhx"));
        }

    }
}
