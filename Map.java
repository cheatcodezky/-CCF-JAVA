import java.util.Scanner;

/**
 * Created by 95112 on 10/17/2017.
 */
public class Map {
    private static char[][] map ;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n,m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        map =  new char[n][m];
        for (int i = 0;i < n;i++)
        {
            String input = scanner.next();
            for (int j = 0; j< m;j++)
            {
                map[i][j] = input.charAt(j);
            }
        }


    }
}
