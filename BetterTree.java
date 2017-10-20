import java.util.Scanner;

/**
 * Created by 95112 on 10/17/2017.
 */
public class BetterTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int deep,n;
        deep = scanner.nextInt();
        n = scanner.nextInt();
        System.out.println(deal(deep - 1,n,1));
    }
    private static int deal(int deep , int n,int k ){
        if (deep == 0)
        {
            return k;
        }
        if (n % 2 == 0)
        {
            return deal(deep -1 , n /2 , k*2 +1);
        }
        else
        {
            return  deal(deep - 1, (n + 1)/2 , k*2 );
        }

    }

}
