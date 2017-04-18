import java.io.File;
import java.util.Scanner;

/**
 * Created by max on 17-3-17.
 */
public class FastMi {
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int a  = scanner.nextInt();
        int b  = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("a="+a+" b="+b+" c="+c+"   answer="+fasrMi(a,b,c));
    }
    public static int fasrMi(int a,int b,int c)
    {
        int ans = 1;
        a = a % c;
        while (b > 0) {

            if(b%2 ==1) {

                ans = (ans * a) % c;
                System.out.println("test"+ans);
            }
            b = (int)b/2;
            a = (a*a) %c;


        }
        return ans;
    }
}
