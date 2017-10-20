import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 95112 on 10/15/2017.
 */
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String output = "";
        int start = 0 ;
        int end = input.length() -1;
        if (input.contains("-")) {
            start = 1;
            output = "-";
        }

        for (int i = input.length() -1 ; i >=start ;i-- )
        {
            output = output + input.charAt(i);
        }
        String deal = "";

        if (output.contains("-"))
        {
         deal = "-";
        }
        int key = 0;
        for (int i = start ; i < output.length();i++)
        {
            if (key == 1  )
                deal = deal + output.charAt(i);
            else {
                if (output.charAt(i)!='0')
                {
                    deal = deal+output.charAt(i);
                    key = 1;
                }
            }
        }
        output =deal;
        if (output.contains("-")) {
            if (output.length() == 1) {
                System.out.println("0");
                return;
            }
        }
        else {

            if (output.length()<1)
            {
                System.out.println("0");
                return;
            }
            }
        if (output.contains("-"))
        {
           if (output.length() > 11)
               output = "0";
           else if (output.length() == 11)
           {
               if (new Integer(output.charAt(1)+"")>2)
                   output = "0";
               else
               {
                   if (output.charAt(1)== '2') {
                       String test = "";
                       for (int i = 2; i < output.length(); i++) {
                           test = test + output.charAt(i);
                       }
                       if (new Integer(test) > 147483648 )
                           output = "0";
                   }
               }
           }
        }
        else
        {
            if (output.length() > 10)
                output = "0";
            else if (output.length() == 10)
            {
                if (new Integer(output.charAt(0)+"") >2)
                    output = "0";
                else
                {
                    if (output.charAt(0) == '2')
                    {
                        String test = "";
                        for (int i = 1; i < output.length(); i++) {
                            test = test + output.charAt(i);
                        }
                        if (new Integer(test) > 147483647 )
                            output = "0";

                    }
                }
            }

        }
        System.out.println(output);
    }
}
//7463847412
//-8463847412