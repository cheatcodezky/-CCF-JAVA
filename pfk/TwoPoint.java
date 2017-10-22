package pfk;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by 95112 on 10/21/2017.
 */
public class TwoPoint {
    private static long sum = 1;
    private static BigInteger ans;
    static BigInteger two;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ans = new BigInteger("0");
        BigInteger n = new BigInteger(scanner.next());
        BigInteger l = new BigInteger(scanner.next());
        BigInteger r = new BigInteger(scanner.next());
        BigInteger x = new BigInteger("1");
        BigInteger y = new BigInteger("1");
        BigInteger tmp = n.add(new BigInteger("0"));
         two = new BigInteger("2");
        while (tmp.compareTo(x) == 1)
        {
            tmp = tmp.divide(two);
            y = y.multiply(two).add(x);
        }
        solve(x,y,l,r,n);
        System.out.println(ans.toString());
    }
    private static  void solve(BigInteger x,BigInteger y , BigInteger l , BigInteger r , BigInteger n){
        if (x.compareTo(y) == 1 || l.compareTo(r) == 1)
            return;
        BigInteger mid = x.add(y).divide(two);
        if ( mid.compareTo(l) == -1 )
            solve(mid.add(BigInteger.ONE),y,l,r,n.divide(two));
        else if (mid.compareTo(r) == 1)
            solve(x,mid.subtract(BigInteger.ONE),l,r,n.divide(two));
        else {
            ans = ans.add(n.mod(two));
            solve(mid.add(BigInteger.ONE),y,mid.add(BigInteger.ONE),r,n.divide(two));
            solve(x,mid.subtract(BigInteger.ONE),l,mid.subtract(BigInteger.ONE),n.divide(two));
        }

    }
}
