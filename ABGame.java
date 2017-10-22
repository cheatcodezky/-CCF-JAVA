import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/22/2017.
 */
public class ABGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        int max = 0;
        for (int i = 0 ; i < n ; i++) {
            input[i] = scanner.nextInt();
            if (max < input[i])
                max = input[i];
        }
        int v = input[0];
        for (int i = 1 ; i < n ; i++)
        {
            v = gcd(v,input[i]);
        }
        v = max/v - n;
        if (v%2 == 1) System.out.println("Alice");
        else
            System.out.println("Bob");
    }
    private static int gcd(int a, int b){
        if (a < b)
        {
            a = b+a;
            b = a - b;
            a = a - b;
        }
        if (a%b == 0)
            return b;
        else return gcd(b,a%b);
    }
}
