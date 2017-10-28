import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/28/2017.
 */
public class Stupa {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        int C = scanner.nextInt();
        for (int i = 0 ; i < C ; i++)
        {
            int N = scanner.nextInt();
            int[][] stupa = new int[N][N];
            for (int x = 0 ; x < N;x++ )
                for (int y = 0 ; y <=x ; y++){
                  stupa[x][y] = scanner.nextInt();
                }
            for (int x = N-2; x >=0 ; x--)
                for (int y =0; y <=x ;y++ ){
                    stupa[x][y] = max(stupa[x+1][y],stupa[x+1][y+1])+stupa[x][y];
                }
            answers.add(stupa[0][0]+"");
        }
        for (String answer : answers)
            System.out.println(answer);
    }
    private static int  max (int a, int b)
    {
        if (a>b)
            return a;
        else
            return b;
    }
}
