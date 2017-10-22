import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Created by 95112 on 10/22/2017.
 */
public class Resistor {
    static long a,b;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextLong();
        b = scanner.nextLong();
        change();
        long tmp = 0;
        while (a > 0){
            if (b==0)
                break;
            tmp += a/b;
            a = a % b;
            change();
        }
        System.out.println(tmp);
    }
    private static void change(){
        if (a > b)
            return;
        else{
            b = a + b;
            a = b - a;
            b = b - a;
        }

    }
}
