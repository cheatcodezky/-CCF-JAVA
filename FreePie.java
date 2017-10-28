import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/28/2017.
 */
public class FreePie {
    static int[][] map;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> answers = new ArrayList<>();
        do {
            int n = scanner.nextInt();
            if (n == 0 )
                break;
            map = new int[100005][11];
            int max = 0;
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int T = scanner.nextInt();
                map[T][x]++;
                if (max< T)
                    max = T;
            }

            for (int i = max; i >=0 ; i --){
                for (int j = 0 ; j<11;j++){
                    map[i][j] = maxLast(i,j)+map[i][j];
                }
            }
            answers.add(map[0][5]);
        }while(true);
        for (int answer : answers)
            System.out.println(answer);
    }
    private static int maxLast(int i ,int j){
        int a,b,c;
        a = 0;
        b = 0;
        c = 0;
        if (j == 0){
            b = map[i+1][j];
            c = map[i+1][j+1];
        }
        else if (j == 10){
            a = map[i+1][j-1];
            b = map[i+1][j];
        }
        else {
            a = map[i+1][j-1];
            b = map[i+1][j];
            c = map[i+1][j+1];
        }
     if (a < b)
         a = b;
     if (a < c)
         a = c;
     return a;
    }
}
